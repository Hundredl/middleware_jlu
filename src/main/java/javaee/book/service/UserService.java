package javaee.book.service;

import javaee.book.entity.BookUser;
import javaee.jpa.one.entity.Mentor;

import javax.persistence.*;
import java.util.List;

public class UserService {
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }
    public boolean canLoginIn(String userName,String password)
    {
        BookUser user=selectByUserName(userName);
        return user != null && password.equals(user.getPassword());
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
    public void add(BookUser bookUser)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(bookUser);
        transaction.commit();
        em.close();
    }
}
