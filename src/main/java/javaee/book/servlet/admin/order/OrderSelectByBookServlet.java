package javaee.book.servlet.admin.order;

import javaee.book.entity.BookOrder;
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
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderSelectByBookServlet" , value = "/book/admin/order/selectByBookId")
public class OrderSelectByBookServlet extends HttpServlet {
    @EJB
    OrderStatefulService orderStatefulService;
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<?,?> params= ServletUtils.getPostParams(req);
        if (params.get("bookId")==null)
        {
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.failure,null);
        }
        Integer bookId = Integer.parseInt(params.get("bookId").toString());
        List<BookOrder> bookOrderList = orderStatefulService.selectByBookId(bookId);
        ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, OrderUtils.getBookOrderFullRespList(bookOrderList));
    }
}
