package javaee.jpa3.many2many.entity;

import javaee.jpa3.one2many.entity.OneToManyTeacher;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ManyToManyCourse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String courseName;
    @ManyToMany(cascade={CascadeType.ALL},mappedBy = "courses")//cascade={CascadeType.PERSIST},
    private Collection<ManyToManyTeacher> teachers=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Collection<ManyToManyTeacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Collection<ManyToManyTeacher> teachers) {
        this.teachers = teachers;
    }

    public ManyToManyCourse() {
    }
}
