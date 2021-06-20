package javaee.book.service;

import javaee.book.dao.OrderDao;
import javaee.book.entity.BookOrder;

import javax.ejb.LocalBean;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.List;

@Stateful
@LocalBean
public class OrderStatefulService {
    OrderDao orderDao=new OrderDao();
    public List<BookOrder> selectAll()
    {
        return orderDao.selectAll();
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
}
