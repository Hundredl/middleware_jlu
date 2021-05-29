package javaee.jpa3.one2many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

public class One2manyTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String gender;
    private String teacherName;
    @OneToMany(cascade = { CascadeType.ALL },mappedBy="teacher")
    private Collection<One2manyCourse> courses=new ArrayList<One2manyCourse>();

    public One2manyTeacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Collection<One2manyCourse> getCourses() {
        return courses;
    }

    public void setCourses(Collection<One2manyCourse> courses) {
        this.courses = courses;
    }
}
