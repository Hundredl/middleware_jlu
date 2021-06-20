package javaee.book.servlet.user.order;

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
import java.util.Map;

@WebServlet(name = "OrderInsertTemporarilyServlet" , value = "/book/user/order/insertTemp")
public class OrderInsertTemporarilyServlet extends HttpServlet {
    @EJB
    OrderStatefulService orderStatefulService;
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("application/json;charset=UTF-8");
        Map<?,?> params= ServletUtils.getPostParams(req);
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
}
