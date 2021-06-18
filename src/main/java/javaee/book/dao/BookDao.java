package javaee.book.dao;

import javaee.book.entity.BookBook;
import javaee.book.entity.BookUser;

import javax.persistence.*;
import java.util.List;

public class BookDao {
    private static final EntityManagerFactory emf;
    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }
    public List<BookBook> selectAll()
    {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("select u from BookBook U");
        List<BookBook> result = query.getResultList();
        entityManager.close();
        return result;
    }
    public void insert(BookBook bookBook)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(bookBook);
        transaction.commit();
        em.close();
    }
}
