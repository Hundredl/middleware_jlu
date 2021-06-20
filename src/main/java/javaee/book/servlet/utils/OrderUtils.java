package javaee.book.servlet.utils;

import javaee.book.entity.BookOrder;
import javaee.book.entity.BookOrderResp;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class OrderUtils {
    public static List<BookOrderResp> getBookOrderRespList(List<BookOrder> bookOrderList) throws InvocationTargetException, IllegalAccessException {
        List<BookOrderResp> bookOrderRespList=new LinkedList<>();
        for (BookOrder bookOrder:bookOrderList)
        {
            BookOrderResp bookOrderResp=new BookOrderResp();
            BeanUtils.copyProperties(bookOrderResp,bookOrder);
            bookOrderRespList.add(bookOrderResp);
        }
        return bookOrderRespList;
    }
}
