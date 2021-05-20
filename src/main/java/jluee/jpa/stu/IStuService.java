package jluee.jpa.stu;

import java.util.List;

public interface IStuService {
    List<Stu> findAllStudents();

    void addStudent(Stu student);

    void deleteStudent(Integer id);

    void updateStudent(Integer id, Stu student);
}
