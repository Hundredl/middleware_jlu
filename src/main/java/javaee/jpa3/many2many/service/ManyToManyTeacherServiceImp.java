package javaee.jpa3.many2many.service;

import javaee.jpa3.many2many.entity.ManyToManyTeacher;
import javaee.jpa3.one2many.entity.OneToManyTeacher;

import javax.persistence.*;
import java.util.List;

public class ManyToManyTeacherServiceImp implements ManyToManyTeacherService{
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }
    @Override
    public List<ManyToManyTeacher> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("select t from ManyToManyTeacher T");
        List<ManyToManyTeacher> result = query.getResultList();
        entityManager.close();
        return result;
    }

    @Override
    public void add(ManyToManyTeacher teacher) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(teacher);
        transaction.commit();
        em.close();

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Integer id, ManyToManyTeacher teacher) {
        EntityManager em = emf.createEntityManager();
        ManyToManyTeacher t=em.find(ManyToManyTeacher.class,id);
        t.setAge(teacher.getAge());
        t.setGender(teacher.getGender());
        t.setTeacherName(teacher.getTeacherName());
        t.setCourses(teacher.getCourses());
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(t);
        transaction.commit();
        em.close();
    }
}
