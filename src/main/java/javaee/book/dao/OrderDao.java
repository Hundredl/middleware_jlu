package javaee.book.dao;

import javaee.book.entity.BookBook;
import javaee.book.entity.BookOrder;
import javaee.book.entity.BookSubOrder;
import javaee.book.entity.BookUser;

import javax.persistence.*;
import java.util.*;

public class OrderDao {
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }

    public List<BookOrder> selectAll()
    {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("select u from BookOrder U");
        List<BookOrder> result = query.getResultList();
        entityManager.close();
        return result;
    }
    public void insert(BookOrder bookOrder)
    {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(bookOrder);
        transaction.commit();
        entityManager.close();
    }
    public List<BookOrder> selectByUserId(Integer userId)
    {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNativeQuery(String.format("select * from BOOKORDER where userId='%s'",userId), BookOrder.class);
        List<BookOrder> result = query.getResultList();
        entityManager.close();
        return result;
    }
    public List<BookOrder> selectByBookId(Integer bookId)
    {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNativeQuery(String.format("select * from BOOKSUBORDER where bookId='%s'",bookId), BookSubOrder.class);
        List<BookSubOrder> bookSubOrderList = query.getResultList();
        List<BookOrder> bookOrderList=new LinkedList<>();
        for (BookSubOrder bookSubOrder:bookSubOrderList)
        {
            if (!bookOrderList.contains(bookSubOrder))
            {
                bookOrderList.add(bookSubOrder.getBookOrder());
            }
        }
        entityManager.close();
        return bookOrderList;
    }
}
