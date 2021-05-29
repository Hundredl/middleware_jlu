package javaee.jpa3.one2many.service;

import javaee.jpa3.one2many.entity.OneToManyTeacher;

import java.util.List;

public interface One2ManyTeacherService {
    List<OneToManyTeacher> findAll();

    void add(OneToManyTeacher teacher);

    void delete(Integer id);

    void update(Integer id, OneToManyTeacher teacher);
}
