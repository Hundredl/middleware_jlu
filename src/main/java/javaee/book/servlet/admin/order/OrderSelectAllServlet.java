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
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "OrderSelectAllServlet" , value = "/book/admin/order/selectAll")
public class OrderSelectAllServlet extends HttpServlet {
    @EJB
    OrderStatefulService orderService;
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        List<BookOrder> orderList=orderService.selectAll();
        ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, OrderUtils.getBookOrderFullRespList(orderList));
    }
}
