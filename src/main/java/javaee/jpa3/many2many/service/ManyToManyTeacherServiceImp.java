package javaee.jpa3.many2many.service;

import javaee.jpa3.many2many.entity.ManyToManyTeacher;
import javaee.jpa3.one2many.entity.OneToManyTeacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Integer id, ManyToManyTeacher teacher) {

    }
}
