package javaee.jpa.two.service;

import javaee.jpa.one.entity.Mentor;
import javaee.jpa.two.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    void add(Teacher teacher);

    void delete(Integer id);

    void update(Integer id, Teacher teacher);
}
