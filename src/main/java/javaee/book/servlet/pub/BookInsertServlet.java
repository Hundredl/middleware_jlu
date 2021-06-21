package javaee.book.servlet.pub;

import com.alibaba.fastjson.JSONObject;
import javaee.book.entity.BookBook;
import javaee.book.service.BookService;
import javaee.book.utils.GlobalVar;
import javaee.book.utils.ServletUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "BookInsertServlet" , value = "/book/pub/book/insert")
public class BookInsertServlet extends HttpServlet {
    @EJB
    BookService bookService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        Map<?,?> params= ServletUtils.getPostParams(req);

        BookBook bookBook= JSONObject.toJavaObject((JSONObject)params.get("book"),BookBook.class);
        bookService.insert(bookBook);
        ServletUtils.returnResp(resp, GlobalVar.RespMsg.success,bookBook);
    }
}
