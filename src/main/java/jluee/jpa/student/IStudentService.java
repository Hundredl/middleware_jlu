package jluee.jpa.student;

import java.util.List;

public interface IStudentService {
    List<Student> findAllStudents();

    void addStudent(Student student);

    void deleteStudent(Integer id);

    void updateStudent(Integer id, Student student);
}
