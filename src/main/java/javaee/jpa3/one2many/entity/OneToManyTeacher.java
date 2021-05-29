package javaee.jpa3.one2many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
public class OneToManyTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String gender;
    private String teacherName;
    @OneToMany(cascade = { CascadeType.ALL },mappedBy="teacher")
    private Collection<OneToManyCourse> courses=new ArrayList<OneToManyCourse>();

    public OneToManyTeacher() {
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

    public Collection<OneToManyCourse> getCourses() {
        return courses;
    }

    public void setCourses(Collection<OneToManyCourse> courses) {
        this.courses = courses;
    }

    public OneToManyTeacher(int id, int age, String gender, String teacherName, Collection<OneToManyCourse> courses) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.teacherName = teacherName;
        this.courses = courses;
    }
}
