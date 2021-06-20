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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "OrderInsertTemporarilyServlet" , value = "/book/user/order/insertTemp")
public class OrderInsertTemporarilyServlet extends HttpServlet {
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
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.wrong_param,null);
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
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.wrong_param,null);
        }

    }
    private void insertTemp(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {

        Integer bookId = params.get("bookId")==null?null:Integer.parseInt(params.get("bookId").toString());
        Integer num = params.get("num")==null?null:Integer.parseInt(params.get("num").toString());
        if (bookId==null||num==null)
        {
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.wrong_param,null);
            return;
        }
        orderStatefulService.addToSubOrderList(bookId,num);
        ServletUtils.returnResp(resp, GlobalVar.RespMsg.book_order_insert_temp_success, OrderUtils.getBookSubOrderWithBookList(orderStatefulService.getSubOrderList()));

    }
    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        BookUserResp user=(BookUserResp) req.getSession().getAttribute("user");
        Integer userId=3;
        BookOrder bookOrder= JSONObject.toJavaObject((JSONObject) params.get("orderInfo"),BookOrder.class);
        if (bookOrder == null)
        {
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.wrong_param,null);
        }
        System.out.println(bookOrder+"--------------------------------------------------------------");
        assert bookOrder != null;
        Integer result=orderStatefulService.save(userId,bookOrder);
        if (result<0)
        {
            //说明书籍数量不够了
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.book_order_insert_temp_save_failure, OrderUtils.getBookSubOrderWithBookList(orderStatefulService.getSubOrderList()));
        }
        else {
            //书籍数量足够
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.book_order_insert_temp_save, OrderUtils.getBookSubOrderWithBookList(orderStatefulService.getSubOrderList()));
        }
    }
}
