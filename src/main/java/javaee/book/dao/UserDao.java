package javaee.book.dao;

import javaee.book.entity.BookUser;

import javax.persistence.*;
import java.util.List;

public class UserDao {
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }
    public BookUser select(Integer userId){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("select u from BookUser U");
        List<BookUser> result = query.getResultList();
        entityManager.close();
        if (result.size()==0)
        {
            return null;
        }
        else {
            return result.get(0);
        }
    }
    public BookUser selectByUserName(String userName){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNativeQuery(String.format("select * from BOOKUSER where userName='%s'",userName),BookUser.class);
        List<BookUser> result = query.getResultList();
        entityManager.close();
        if (result.size()==0)
        {
            return null;
        }
        else {
            return result.get(0);
        }
    }
    public void select(BookUser bookUser)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(bookUser);
        transaction.commit();
        em.close();
    }
}
