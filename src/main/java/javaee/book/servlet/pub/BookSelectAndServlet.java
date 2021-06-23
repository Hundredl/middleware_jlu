package javaee.book.servlet.pub;

import com.alibaba.fastjson.JSONObject;
import javaee.book.entity.BookBook;
import javaee.book.entity.req.BookBookReq;
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
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookSelectAndServlet" , value = "/book/pub/book/selectAnd")
public class BookSelectAndServlet extends HttpServlet {
    @EJB
    BookService bookService;
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        Map<?,?> params= ServletUtils.getPostParams(req);
        BookBookReq bookBookReq= JSONObject.toJavaObject((JSONObject)params.get("bookFilter"),BookBookReq.class);
        System.out.println(bookBookReq);
        List<BookBook> result=bookService.selectAnd(bookBookReq);
        ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, BookUtils.getBookBookReqList(result));
    }
}
