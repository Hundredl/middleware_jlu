package javaee.book.servlet.admin.book;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import javaee.book.entity.BookBook;
import javaee.book.service.BookStatefulService;
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
import java.awt.print.Book;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookInsertTemporarilyServlet" , value = "/book/admin/book/insertTemporarily")
public class BookInsertTemporarilyServlet extends HttpServlet {
    @EJB
    BookStatefulService bookStatefulServiceRemote;
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        Map<?,?> params= ServletUtils.getPostParams(req);
        List<BookBook> bookList=params.get("bookList")==null?new LinkedList<BookBook>(): JSONObject.parseArray(params.get("bookList").toString(),BookBook.class);
        BookBook bookBook = params.get("book")==null?null:JSON.toJavaObject((JSON) params.get("book"),BookBook.class);
        Integer bookId = params.get("bookId")==null?-1:Integer.parseInt(params.get("bookId").toString());
        String option=params.get("option").toString();
        switch (option) {
            case "insertTemporarilyOne":
                insertTemporarilyOne(bookBook);
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, BookUtils.getBookBookRespList(bookStatefulServiceRemote.getInsertSaveTemporarilyBookList()));
                break;
            case "insertTemporarilyDelete":
                insertTemporarilyDelete(bookId);
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, BookUtils.getBookBookRespList(bookStatefulServiceRemote.getInsertSaveTemporarilyBookList()));
                break;
            case "insertTemporarily":
                insertTemporarily(bookList);
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, BookUtils.getBookBookRespList(bookStatefulServiceRemote.getInsertSaveTemporarilyBookList()));
                break;
            case "insertTemporarilySave":
                insertTemporarilySave();
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, null);
                break;
            case "insertTemporarilySelect":
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, BookUtils.getBookBookRespList(bookStatefulServiceRemote.getInsertSaveTemporarilyBookList()));
                break;
            case "insertTemporarilyUpdate":
                insertTemporarilyUpdate(bookList);
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, BookUtils.getBookBookRespList(bookStatefulServiceRemote.getInsertSaveTemporarilyBookList()));
                break;
            case "insertTemporarilyUpdateOne":
                insertTemporarilyUpdateOne(bookList);
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.success, BookUtils.getBookBookRespList(bookStatefulServiceRemote.getInsertSaveTemporarilyBookList()));
                break;
            default:
                ServletUtils.returnResp(resp, GlobalVar.RespMsg.failure, null);
                break;
        }
    }
    private void insertTemporarilyOne(BookBook bookBook)
    {
        bookStatefulServiceRemote.insertTemporarilyOne(bookBook);
    }
    private void insertTemporarilyDelete(Integer bookId)
    {
        bookStatefulServiceRemote.insertTemporarilyDelete(bookId);
    }
    private void insertTemporarily(List<BookBook> bookList)
    {
        bookStatefulServiceRemote.insertSaveTemporarily(bookList);
    }
    private void insertTemporarilySave()
    {
        bookStatefulServiceRemote.insertSave();
    }
    private void insertTemporarilyUpdate(List<BookBook> bookList)
    {
        bookStatefulServiceRemote.update(bookList);
    }
    private void insertTemporarilyUpdateOne(List<BookBook> bookList) throws InvocationTargetException, IllegalAccessException {
        bookStatefulServiceRemote.updateOne(bookList.get(0));
    }
}
