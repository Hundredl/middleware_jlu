package javaee.book.servlet.admin.book;

import com.alibaba.fastjson.JSONObject;
import javaee.book.entity.BookBook;
import javaee.book.service.BookStatefulService;
import javaee.book.utils.GlobalVar;
import javaee.book.utils.ServletUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookInsertTemporarilyServlet" , value = "/book/admin/book/insertTemporarily")
public class BookInsertTemporarilyServlet extends HttpServlet {
    @EJB
    BookStatefulService bookStatefulServiceRemote;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        Map<?,?> params= ServletUtils.getPostParams(req);
        List<BookBook> bookList= JSONObject.parseArray(params.get("bookList").toString(),BookBook.class);
        String option=params.get("option").toString();
        switch (option) {
            case "insertTemporarily":
                insertTemporarily(bookList);
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.book_insert_temporarily_select, bookStatefulServiceRemote.getInsertSaveTemporarilyBookList());
                break;
            case "insertTemporarilySave":
                bookStatefulServiceRemote.insertSave();
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.book_insert_temporarily_save, null);
                break;
            case "insertTemporarilySelect":
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.book_insert_temporarily_select, bookStatefulServiceRemote.getInsertSaveTemporarilyBookList());
                break;
            default:
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.book_insert_temporarily_invalid_option, bookStatefulServiceRemote.getInsertSaveTemporarilyBookList());
                break;
        }
    }
    private void insertTemporarily(List<BookBook> bookList)
    {
        bookStatefulServiceRemote.insertSaveTemporarily(bookList);
    }
}
