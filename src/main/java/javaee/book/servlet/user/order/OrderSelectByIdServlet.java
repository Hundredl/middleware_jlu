package javaee.book.servlet.user.order;

import javaee.book.entity.BookOrder;
import javaee.book.service.OrderStatefulService;
import javaee.book.servlet.utils.OrderUtils;
import javaee.book.utils.GlobalVar;
import javaee.book.utils.ServletUtils;
import lombok.SneakyThrows;

import javax.ejb.EJB;
import javax.persistence.criteria.Order;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderSelectByIdServlet" , value = "/book/user/order/selectById")
public class OrderSelectByIdServlet extends HttpServlet {
    @EJB
    OrderStatefulService orderStatefulService;
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<?,?> params= ServletUtils.getPostParams(req);
        Integer userId=3;
        List<BookOrder> bookOrderList=orderStatefulService.selectByUserId(userId);
        ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, OrderUtils.getBookOrderWithSubOrderList(bookOrderList));
    }
}
