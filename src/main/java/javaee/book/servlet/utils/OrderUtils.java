package javaee.book.servlet.utils;

import com.alibaba.fastjson.JSON;
import javaee.book.entity.BookOrder;
import javaee.book.entity.BookSubOrder;
import javaee.book.entity.resp.*;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderUtils {
    /**
     * 获取纯粹的订单信息
     * @param bookOrderList 订单信息
     * @return 纯粹的订单信息
     * @throws InvocationTargetException 异常
     * @throws IllegalAccessException 异常
     */
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

    /**
     * 获取纯粹的订单信息
     * @param bookOrder 订单信息
     * @return 纯粹订单信息
     * @throws InvocationTargetException 异常
     * @throws IllegalAccessException 异常
     */
    public static BookOrderResp getBookOrderResp(BookOrder bookOrder) throws InvocationTargetException, IllegalAccessException {
        BookOrderResp bookOrderResp=new BookOrderResp();
        BeanUtils.copyProperties(bookOrderResp,bookOrder);
        return bookOrderResp;
    }
    /**
     * 获取订单信息，带有子订单和子订单的书籍
     * @param bookOrderList 订单列表
     * @return 订单列表的信息
     * @throws InvocationTargetException 异常
     * @throws IllegalAccessException 异常
     */
    public static List<BookOrderWithSubOrder> getBookOrderWithSubOrderList(List<BookOrder> bookOrderList) throws InvocationTargetException, IllegalAccessException {
        List<BookOrderWithSubOrder> bookOrderWithSubOrderList=new LinkedList<>();
        for (BookOrder bookOrder:bookOrderList)
        {
            BookOrderWithSubOrder bookOrderWithSubOrder=getBookOrderWithSubOrder(bookOrder);
            //加入list
            bookOrderWithSubOrderList.add(bookOrderWithSubOrder);
        }
        return bookOrderWithSubOrderList;
    }

    /**
     * 获取一个订单的信息，带有子订单和子订单的书籍
     * @param bookOrder 订单
     * @return 订单信息，带有子订单信息，子订单带有书籍信息
     * @throws InvocationTargetException 异常
     * @throws IllegalAccessException 异常
     */
    public static BookOrderWithSubOrder getBookOrderWithSubOrder(BookOrder bookOrder) throws InvocationTargetException, IllegalAccessException {
        //拷贝订单信息
        BookOrderWithSubOrder bookOrderWithSubOrder=new BookOrderWithSubOrder();
        BeanUtils.copyProperties(bookOrderWithSubOrder,bookOrder);
        //获取子订单全部信息
        List<BookSubOrder> bookSubOrderList=bookOrder.getSubOrderList();
        List<BookSubOrderWithBook> bookSubOrderWithBookList=new LinkedList<>();
        for (BookSubOrder bookSubOrder:bookSubOrderList)
        {
            //拷贝子订单信息
            BookSubOrderWithBook bookSubOrderWithBook=new BookSubOrderWithBook();
            BeanUtils.copyProperties(bookSubOrderWithBook,bookSubOrder);
            //拷贝书籍信息
            BookBookResp bookBookResp=new BookBookResp();
            BeanUtils.copyProperties(bookBookResp,bookSubOrder.getBookBook());
            //设置书籍信息
            bookSubOrderWithBook.setBook(bookBookResp);
            //加入List
            bookSubOrderWithBookList.add(bookSubOrderWithBook);
        }
        //设置子订单信息
        bookOrderWithSubOrder.setSubOrderList(bookSubOrderWithBookList);
        return bookOrderWithSubOrder;
    }

    public static BookSubOrderWithBook getBookSubOrderWithBook(BookSubOrder bookSubOrder) throws InvocationTargetException, IllegalAccessException {
        //拷贝信息
        BookSubOrderWithBook bookSubOrderWithBook=new BookSubOrderWithBook();
        BeanUtils.copyProperties(bookSubOrderWithBook,bookSubOrder);
        //拷贝书籍信息
        BookBookResp bookBookResp=new BookBookResp();
        BeanUtils.copyProperties(bookBookResp,bookSubOrder.getBookBook());
        //设置书籍信息
        bookSubOrderWithBook.setBook(bookBookResp);
        return bookSubOrderWithBook;
    }

    public static List<BookSubOrderWithBook> getBookSubOrderWithBookList(List<BookSubOrder> bookSubOrderList) throws InvocationTargetException, IllegalAccessException {
        List<BookSubOrderWithBook> bookSubOrderWithBookList=new LinkedList<>();
        for (BookSubOrder bookSubOrder:bookSubOrderList)
        {
            BookSubOrderWithBook bookSubOrderWithBook = getBookSubOrderWithBook(bookSubOrder);
            bookSubOrderWithBookList.add(bookSubOrderWithBook);
        }
        return bookSubOrderWithBookList;
    }


    /**
     * 取得全部订单的全部信息
     * @param bookOrderList  订单信息
     * @return 订单信息
     * @throws InvocationTargetException 异常
     * @throws IllegalAccessException 异常
     */
    public static List<BookOrderFullResp> getBookOrderFullRespList(List<BookOrder> bookOrderList) throws InvocationTargetException, IllegalAccessException {

        List<BookOrderFullResp> bookOrderFullRespList = new ArrayList<>();
        for (BookOrder bookOrder:bookOrderList)
        {
            BookOrderFullResp bookOrderFullResp = getBookOrderFullResp(bookOrder);
            bookOrderFullRespList.add(bookOrderFullResp);
        }
        return bookOrderFullRespList;
    }

    /**
     * 取得一个订单的全部信息
     * @param bookOrder 订单信息
     * @return 订单信息
     * @throws InvocationTargetException 异常
     * @throws IllegalAccessException 异常
     */
    public static BookOrderFullResp getBookOrderFullResp(BookOrder bookOrder) throws InvocationTargetException, IllegalAccessException {

        //拷贝其余订单信息
        BookOrderWithSubOrder bookOrderWithSubOrder=getBookOrderWithSubOrder(bookOrder);
        BookOrderFullResp bookOrderFullResp=new BookOrderFullResp();
        BeanUtils.copyProperties(bookOrderFullResp,bookOrderWithSubOrder);
        //拷贝用户信息
        BookUserResp bookUserResp=new BookUserResp();
        BeanUtils.copyProperties(bookUserResp,bookOrder.getUser());
        bookOrderFullResp.setUser(bookUserResp);
        return bookOrderFullResp;

    }

    /**
     * @param order 订单信息
     * @return 订单的json信息
     */
    public static String getOrderMessage(BookOrderWithSubOrder order)
    {
        return JSON.toJSON(order).toString();
    }
}
