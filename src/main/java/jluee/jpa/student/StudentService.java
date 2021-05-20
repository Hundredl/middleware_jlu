package jluee.jpa.student;

import jluee.jpa.stu.Stu;

import javax.persistence.*;
import java.util.List;

public class StudentService implements IStudentService {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("jpaUnit");
    }

    @Override
    public List<Student> findAllStudents() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Student C");

        List<Student> result = query.getResultList();
        for (Student c : result) {
            System.out.println(c.getId() + ", " + c.getName() + ", " + c.getMajor() + ", " + c.getAddress().getDetail());
        }
        em.close();
        return result;
    }

    @Override
    public void addStudent(Student student) {
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

        Student p = em.find(Student.class, id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(p);
        transaction.commit();

        em.close();
    }

    @Override
    public void updateStudent(Integer id, Student student) {
        EntityManager em = emf.createEntityManager();

        Student p = em.find(Student.class, id);
        p.setGender(student.getGender());
        p.setMajor(student.getMajor());
        p.setName(student.getName());
        p.setAddress(student.getAddress());

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(p);
        transaction.commit();

        em.close();
    }
}
