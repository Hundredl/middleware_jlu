package javaee.jpa3.one2many.service;

import javaee.jpa3.one2many.entity.OneToManyTeacher;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;


public class One2ManyTeacherServiceImp implements One2ManyTeacherService{
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }
    @Override
    public List<OneToManyTeacher> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("select t from OneToManyTeacher T");
        List<OneToManyTeacher> result = query.getResultList();
        for(OneToManyTeacher t:result)
        {
            System.out.println(t.getId()+" "+t.getTeacherName()+ " "+ Arrays.toString(t.getCourses().toArray()));
        }
        entityManager.close();
        return result;
    }

    @Override
    public void add(OneToManyTeacher teacher) {
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
    public void update(Integer id, OneToManyTeacher teacher) {

    }
}
