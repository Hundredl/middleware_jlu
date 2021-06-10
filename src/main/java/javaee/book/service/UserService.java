package javaee.book.service;

import javaee.book.entity.BookUser;
import javaee.jpa.one.entity.Mentor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserService {
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }
    public boolean canLoginIn(Integer userId,String password)
    {
        BookUser user=select(userId);
        return user != null && password.equals(user.getPassword());
    }
    public BookUser select(Integer userId){
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("select u from BookUser U");
        List<BookUser> result = query.getResultList();
        entityManager.close();
        return result.get(0);
    }
}
