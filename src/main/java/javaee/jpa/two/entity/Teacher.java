package javaee.jpa.two.entity;

import javaee.jpa.two.entity.Course;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String gender;
    private String teacherName;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "courseId")
    private Course course;

    public Teacher() {
    }

    public Teacher(int id, int age, String gender, String teacherName, Course course) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.teacherName = teacherName;
        this.course = course;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
