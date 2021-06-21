package javaee.book.servlet.admin.book;

import javaee.book.entity.req.BookIsbnVerifyReq;
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

@WebServlet(name = "BookIsbnVerifyServlet" , value = "/book/admin/book/isbnVerify")
public class BookIsbnVerifyServlet extends HttpServlet {
    @EJB
    BookService bookService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        Map<?,?> params= ServletUtils.getPostParams(req);
        String isbnRaw=params.get("isbnRaw")==null?null:params.get("isbnRaw").toString();
        if (isbnRaw!=null)
        {
            String isbn=null;
            isbn=bookService.isbnVerify(isbnRaw);
            isbn=(isbn==null)?"wrong":isbn;//如果为null则返回wrong
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.success,new BookIsbnVerifyReq(isbn));
        }else {
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.failure,null);
        }

    }
}
