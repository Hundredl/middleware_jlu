package jluee.jpa.stu;

import javax.persistence.*;
import java.util.List;

public class StuService implements IStuService {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }

    @Override
    public List<Stu> findAllStudents() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Stu C");

        List<Stu> result = query.getResultList();
        for (Stu c : result) {
            System.out.println(c.getId() + " ," + c.getName());
        }
        em.close();
        return result;
    }

    @Override
    public void addStudent(Stu student) {
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(student);
        transaction.commit();

        em.close();
    }

    @Override
    public void deleteStudent(Integer id) {
        EntityManager em = emf.createEntityManager();

        Stu p = em.find(Stu.class, id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(p);
        transaction.commit();

        em.close();
    }

    @Override
    public void updateStudent(Integer id, Stu student) {
        EntityManager em = emf.createEntityManager();

        Stu p = em.find(Stu.class, id);
        p.setGender(student.getGender());
        p.setMajor(student.getMajor());
        p.setName(student.getName());

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(p);
        transaction.commit();

        em.close();
    }
}
