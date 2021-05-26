package javaee.jpa.one.entity;

import javaee.jpa.two.entity.Course;

import javax.persistence.*;

@Entity
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String gender;
    private String teacherName;

    public Mentor() {
    }

    public Mentor(int id, int age, String gender, String teacherName) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.teacherName = teacherName;
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
}
