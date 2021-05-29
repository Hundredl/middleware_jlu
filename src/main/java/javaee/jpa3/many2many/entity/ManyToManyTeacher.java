package javaee.jpa3.many2many.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ManyToManyTeacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String gender;
    private String teacherName;
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="MANYTOMANY_REF_STUDENT_TEACHER",
    joinColumns = {
            @JoinColumn(name="teacher_id",referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name="course_id",referencedColumnName = "id")
    })
    private Collection<ManyToManyCourse> courses=new ArrayList<>();


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

    public Collection<ManyToManyCourse> getCourses() {
        return courses;
    }

    public void setCourses(Collection<ManyToManyCourse> courses) {
        this.courses = courses;
    }

    public ManyToManyTeacher() {
    }

    public ManyToManyTeacher(int id, int age, String gender, String teacherName, Collection<ManyToManyCourse> courses) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.teacherName = teacherName;
        this.courses = courses;
    }
}
