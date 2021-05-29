package javaee.jpa3.many2many.service;

import javaee.jpa3.many2many.entity.ManyToManyTeacher;
import javaee.jpa3.one2many.entity.OneToManyTeacher;

import java.util.List;

public interface ManyToManyTeacherService {
    List<ManyToManyTeacher> findAll();

    void add(ManyToManyTeacher teacher);

    void delete(Integer id);

    void update(Integer id, ManyToManyTeacher teacher);
}
