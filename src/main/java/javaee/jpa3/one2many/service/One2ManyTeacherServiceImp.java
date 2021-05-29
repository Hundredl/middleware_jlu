package javaee.jpa3.one2many.service;

import javaee.jpa.two.entity.Teacher;
import javaee.jpa3.one2many.entity.One2manyTeacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

public class One2ManyTeacherServiceImp implements One2ManyTeacherService{
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }
    @Override
    public List<One2manyTeacher> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("select t from Teacher T");
        List<One2manyTeacher> result = query.getResultList();
        for(One2manyTeacher t:result)
        {
            System.out.println(t.getId()+" "+t.getTeacherName()+ " "+ Arrays.toString(t.getCourses().toArray()));
        }
        entityManager.close();
        return result;
    }

    @Override
    public void add(One2manyTeacher teacher) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Integer id, One2manyTeacher teacher) {

    }
}
