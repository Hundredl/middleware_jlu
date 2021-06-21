package javaee.book.servlet.pub;

import javaee.book.entity.BookBook;
import javaee.book.service.BookService;
import javaee.book.servlet.utils.BookUtils;
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

@WebServlet(name = "BookSearchServlet" , value = "/book/pub/book/selectAll")
public class BookSelectAllServlet extends HttpServlet {
    @EJB
    BookService bookService;

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        List<BookBook> result=bookService.selectAll();
        ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, BookUtils.getBookBookReqList(result));
    }
}
