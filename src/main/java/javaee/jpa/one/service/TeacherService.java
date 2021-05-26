package javaee.jpa.one.service;

import javaee.jpa.one.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    void add(Teacher teacher);

    void delete(Integer id);

    void update(Integer id, Teacher teacher);
}
