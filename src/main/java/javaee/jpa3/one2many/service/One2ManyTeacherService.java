package javaee.jpa3.one2many.service;

import javaee.jpa.two.entity.Teacher;
import javaee.jpa3.one2many.entity.One2manyTeacher;

import java.util.List;

public interface One2ManyTeacherService {
    List<One2manyTeacher> findAll();

    void add(One2manyTeacher teacher);

    void delete(Integer id);

    void update(Integer id, One2manyTeacher teacher);
}
