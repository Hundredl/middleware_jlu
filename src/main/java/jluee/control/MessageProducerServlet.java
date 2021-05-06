package jluee.control;

import jluee.client.MyContext;
import jluee.jms.producer.JMSProducer;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * @author 吴非凡
 */
@WebServlet(name = "MessageProducerServlet", value = "/producer")
public class MessageProducerServlet extends HttpServlet {

    private static final String DEFAULT_MESSAGE = "Welcome to JMS!";
    private static final String DEFAULT_CONNECTION_FACTORY = "java:/RemoteConnectionFactory";
    private static final String DEFAULT_DESTINATION = "java:/queue/test";
    private static final String DEFAULT_MESSAGE_COUNT = "1";
    private static final String DEFAULT_USERNAME = "testJNDI";
    private static final String DEFAULT_PASSWORD = "123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //调用printAndForget方法
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Message Producer</title>");

        Context context = MyContext.getContext();
        Connection connection = null;
        try {
            out.println("<h3>获取连接工厂!</h3>");
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);

            out.println("<h3>获取目的地!</h3>");
            Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);
            // 创建JMS连接、会话、生产者和消费者
            connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            connection.start();
            int count = Integer.parseInt(DEFAULT_MESSAGE_COUNT);
            // 发送特定数目的消息
            TextMessage message = null;
            for (int i = 0; i < count; i++) {
                message = session.createTextMessage(DEFAULT_MESSAGE);
                producer.send(message);
                out.println("<h3>message:" + message + "</h3>");
                out.println("<h3>message:" + DEFAULT_MESSAGE + "</h3>");
            }

            // 等待30秒退出
//            CountDownLatch latch = new CountDownLatch(1);
//            latch.await(30, TimeUnit.SECONDS);

        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
