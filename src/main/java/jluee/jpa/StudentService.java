package jluee.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class StudentService implements IStudentService {
    @PersistenceContext(unitName = "jpaUnit")
    private EntityManager entityManager;

    @Override
    public List<Student> findAllStudents() {
        Query query = entityManager.createQuery("SELECT c FROM Student C");
        List<Student> result = query.getResultList();
        for (Student c : result) {
            System.out.println(c.getId() + " ," + c.getName());
        }
        return result;
    }
}
