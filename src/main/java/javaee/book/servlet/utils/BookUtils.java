package javaee.book.servlet.utils;

import javaee.book.entity.BookBook;
import javaee.book.entity.req.BookBookReq;
import javaee.book.entity.resp.BookBookResp;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class BookUtils {
    public static List<BookBookResp> getBookBookRespList(List<BookBook> bookList) throws InvocationTargetException, IllegalAccessException {
        List<BookBookResp> bookRespList = new LinkedList<>();
        for (BookBook book:bookList)
        {
            BookBookResp bookResp = new BookBookResp();
            BeanUtils.copyProperties(bookResp,book);
            bookRespList.add(bookResp);
        }
        return bookRespList;
    }
}
