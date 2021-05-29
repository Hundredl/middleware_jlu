package javaee.jpa3.one2many.entity;

import javax.persistence.*;
@Entity
public class OneToManyCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String courseName;
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name= "teacher_id")
    private OneToManyTeacher teacher;
    public OneToManyCourse() {
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

    public OneToManyTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(OneToManyTeacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "OneToManyCourse{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
