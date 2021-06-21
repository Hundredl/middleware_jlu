package javaee.book.servlet.user.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import javaee.book.entity.BookBook;
import javaee.book.entity.BookOrder;
import javaee.book.entity.BookUser;
import javaee.book.entity.resp.BookUserResp;
import javaee.book.service.OrderStatefulService;
import javaee.book.servlet.utils.OrderUtils;
import javaee.book.utils.GlobalVar;
import javaee.book.utils.ServletUtils;
import lombok.SneakyThrows;

import javax.ejb.EJB;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "OrderInsertTemporarilyServlet" , value = "/book/user/order/insertTemp")
public class OrderInsertTemporarilyServlet extends HttpServlet {
    private static final String DEFAULT_MESSAGE = "Welcome to JMS!";
    private static final String DEFAULT_CONNECTION_FACTORY = "java:/RemoteConnectionFactory";
    private static final String DEFAULT_DESTINATION = "java:/topic/test";
    private static final String DEFAULT_MESSAGE_COUNT = "1";
    private static final String DEFAULT_USERNAME = "testJNDI";
    private static final String DEFAULT_PASSWORD = "123";

    @EJB
    OrderStatefulService orderStatefulService;
    Map<?,?> params;
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.setContentType("application/json;charset=UTF-8");
        params= ServletUtils.getPostParams(req);
        if (params.get("option")==null)
        {
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.failure,null);
            return;
        }
        String option=params.get("option").toString();
        switch (option){
            case "insertTemp":
                insertTemp(req,resp);
                break;
            case "save":
                save(req, resp);
                break;
            default:
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.failure,null);
        }

    }
    private void insertTemp(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {

        Integer bookId = params.get("bookId")==null?null:Integer.parseInt(params.get("bookId").toString());
        Integer num = params.get("num")==null?null:Integer.parseInt(params.get("num").toString());
        if (bookId==null||num==null)
        {
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.failure,null);
            return;
        }
        orderStatefulService.addToSubOrderList(bookId,num);
        ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, OrderUtils.getBookSubOrderWithBookList(orderStatefulService.getSubOrderList()));

    }
    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException, ServletException {
        BookUserResp user=(BookUserResp) req.getSession().getAttribute("user");
        Integer userId=3;
        BookOrder bookOrder= JSONObject.toJavaObject((JSONObject) params.get("orderInfo"),BookOrder.class);
        if (bookOrder == null)
        {
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.failure,null);
        }
        assert bookOrder != null;
        Integer result=orderStatefulService.save(userId,bookOrder);
        if (result<0)
        {
            //说明书籍数量不够了
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.failure, OrderUtils.getBookSubOrderWithBookList(orderStatefulService.getSubOrderList()));
        }
        else {
            //书籍数量足够
            //打印信息
            print(OrderUtils.getOrderMessage(OrderUtils.getBookOrderWithSubOrder(bookOrder)));
            //清空service里的东西
            orderStatefulService.getSubOrderList().clear();
            //返回
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, OrderUtils.getBookSubOrderWithBookList(orderStatefulService.getSubOrderList()));
        }
    }
    public void print(String message) throws IOException, ServletException {
        Context context = null;
        Connection connection = null;
        try {
            // 设置上下文
            System.out.println("设置JNDI访问环境信息也就是设置应用服务器的上下文信息!");
            // 获取到InitialContext对象.
            context = new InitialContext();
            System.out.println("获取连接工厂!");
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
            System.out.println("获取目的地!");
            Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);
            // 创建JMS连接、会话、生产者和消费者
            connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            connection.start();
            int count = Integer.parseInt(DEFAULT_MESSAGE_COUNT);
            // 发送特定数目的消息
            TextMessage messageToSend = null;
            messageToSend = session.createTextMessage(message);
            producer.send(messageToSend);
            connection.close();
            System.out.println("message:" + message);
            // 等待30秒退出
            /*CountDownLatch latch = new CountDownLatch(1);
            latch.await(30, TimeUnit.SECONDS);*/
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
