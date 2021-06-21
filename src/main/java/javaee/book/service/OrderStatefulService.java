package javaee.book.service;

import javaee.book.dao.BookDao;
import javaee.book.dao.OrderDao;
import javaee.book.dao.UserDao;
import javaee.book.entity.BookBook;
import javaee.book.entity.BookOrder;
import javaee.book.entity.BookSubOrder;
import javaee.book.entity.BookUser;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.LocalBean;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.awt.print.Book;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

@Stateful
@LocalBean
public class OrderStatefulService {
    List<BookSubOrder> subOrderList=new LinkedList<>();
    OrderDao orderDao=new OrderDao();
    BookDao bookDao=new BookDao();
    UserDao userDao=new UserDao();
    public List<BookOrder> selectAll()
    {
        return orderDao.selectAll();
    }

    /**
     * 将书籍加入购物车，如果书籍存在，更新书籍数量。如果书籍不存在，新建购物车项目
     * @param bookId 书籍id
     * @param num 书籍数量
     */
    public void addToSubOrderList(Integer bookId,Integer num)
    {
        BookSubOrder destSubOrder=null;
        //找到需要修改的那个子订单
        for (BookSubOrder subOrder:subOrderList)
        {
            if (subOrder.getBookBook().getBookId().equals(bookId))
            {
                //subOrder.setNum(num);
                destSubOrder=subOrder;
            }
        }
        if (destSubOrder!=null)
        {
            //说明此时需要更新
            if (num<=0)
            {
                subOrderList.remove(destSubOrder);
            }
            else {
                destSubOrder.setNum(num);
            }
        }
        else {
            //说明此时需要添加书籍
            BookBook book=bookDao.selectById(bookId);//找到书籍的信息
            if (book!=null&&num>0)//找到书籍信息，并且需要添加。num<=0不添加。没有找到书籍信息不添加
            {
                BookSubOrder bookSubOrder=new BookSubOrder();
                bookSubOrder.setBookBook(book);
                bookSubOrder.setNum(num);
                bookSubOrder.setPrice(getBookPrice(book)*num);
                subOrderList.add(bookSubOrder);
            }
        }

    }

    /**
     * 保存购物车，下单
     * @param userId userId
     * @param bookOrderInfo 订单信息
     * @throws InvocationTargetException 异常
     * @throws IllegalAccessException 异常
     */
    public Integer save(Integer userId ,BookOrder bookOrderInfo) {
        //书籍的数量
        List<BookBook> bookList=new LinkedList<>();
        for (BookSubOrder subOrder:subOrderList)
        {
            Integer countOld=subOrder.getBookBook().getCount();
            Integer countNew=countOld-subOrder.getNum();
            if (countNew<0)
            {
                return -1;
            }
            subOrder.getBookBook().setCount(countNew);
            bookList.add(subOrder.getBookBook());
        }
        bookDao.updateBatch(bookList);
        //设置用户
        BookUser user=userDao.selectById(userId);
        bookOrderInfo.setUser(user);
        //计算总钱数
        Double sum= (double) 0;
        for (BookSubOrder subOrder:subOrderList)
        {
            sum+=subOrder.getPrice();
        }
        bookOrderInfo.setTotal(sum);
        //设置子订单
        bookOrderInfo.setSubOrderList(subOrderList);
        for (BookSubOrder subOrder:subOrderList)
        {
            subOrder.setBookOrder(bookOrderInfo);
        }
        //插入
        orderDao.insert(bookOrderInfo);
        return 0;
    }

    public List<BookSubOrder> getSubOrderList()
    {
        return subOrderList;
    }

    public List<BookOrder> selectByUserId(Integer userId)
    {
        return orderDao.selectByUserId(userId);
    }

    public List<BookOrder> selectByBookId(Integer bookId)
    {
        return orderDao.selectByBookId(bookId);
    }
    @Remove
    public void remove()
    {
        System.out.println(" OrderStatefulService remove");
    }
    @PrePassivate
    public void PrePassivate()
    {
        System.out.println("OrderStatefulService PrePassivate");
    }

    /**
     * 获取书籍的价格，为以后的打折做准备
     * @param bookBook 书籍
     * @return 书籍价格
     */
    private Double getBookPrice(BookBook bookBook)
    {
        return bookBook.getPrice();
    }

}
