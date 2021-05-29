package javaee.jpa.two.service;

import javaee.jpa.two.entity.Teacher;

import javax.persistence.*;
import java.util.List;


public class TeacherServiceImp implements TeacherService {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }
    @Override
    public List<Teacher> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("select t from Teacher T");
        List<Teacher> result = query.getResultList();
        for(Teacher t:result)
        {
            System.out.println(t.getId()+" "+t.getTeacherName());
        }
        entityManager.close();
        return result;
    }

    @Override
    public void add(Teacher mentor) {
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
        Teacher teacher = em.find(Teacher.class, id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(teacher);
        transaction.commit();
        em.close();
    }

    @Override
    public void update(Integer id, Teacher mentor) {
        EntityManager em = emf.createEntityManager();

        Teacher m = em.find(Teacher.class, id);
        m.setAge(mentor.getAge());
        m.setGender(mentor.getGender());
        m.setTeacherName(mentor.getTeacherName());
        m.setCourse(mentor.getCourse());

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(m);
        transaction.commit();
        em.close();
    }
}
