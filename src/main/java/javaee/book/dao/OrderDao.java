package javaee.book.dao;

import javaee.book.entity.BookBook;
import javaee.book.entity.BookOrder;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

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
}
