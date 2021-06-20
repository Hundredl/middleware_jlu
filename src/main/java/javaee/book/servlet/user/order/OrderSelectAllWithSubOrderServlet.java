package javaee.book.servlet.user.order;

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
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "OrderSelectAllWithSubOrderServlet" , value = "/book/user/order/selectAllWithSubOrder")
public class OrderSelectAllWithSubOrderServlet extends HttpServlet {
    @EJB
    OrderStatefulService orderService;
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        List<BookOrder> orderList=orderService.selectAll();
        System.out.println(Arrays.toString(orderList.toArray()));
        ServletUtils.returnResp(resp, GlobalVar.RespMsg.book_search_result, OrderUtils.getBookOrderWithSubOrderList(orderList));

    }
}
