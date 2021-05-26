package javaee.jpa.one.service;

import javaee.jpa.one.entity.Mentor;
import jluee.jpa.stu.Stu;

import javax.persistence.*;
import java.util.List;


public class MentorServiceImp implements MentorService{
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }
    @Override
    public List<Mentor> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("select m from Mentor M");
        List<Mentor> result = query.getResultList();
        for(Mentor m:result)
        {
            System.out.println(m.getId()+" "+m.getTeacherName());
        }
        entityManager.close();
        return result;
    }

    @Override
    public void add(Mentor mentor) {
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(mentor);
        transaction.commit();

        em.close();
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        Mentor mentor = em.find(Mentor.class, id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(mentor);
        transaction.commit();
        em.close();
    }

    @Override
    public void update(Integer id, Mentor mentor) {
        EntityManager em = emf.createEntityManager();

        Mentor m = em.find(Mentor.class, id);
        m.setAge(mentor.getAge());
        m.setGender(mentor.getGender());
        m.setTeacherName(mentor.getTeacherName());

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(m);
        transaction.commit();

        em.close();
    }
}
