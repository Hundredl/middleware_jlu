package javaee.jpa3.one2many.entity;

import javax.persistence.*;

public class One2manyCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String courseName;
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="teacherId")
    private One2manyTeacher teacher;
    public One2manyCourse() {
    }

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

    public One2manyTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(One2manyTeacher teacher) {
        this.teacher = teacher;
    }
}
