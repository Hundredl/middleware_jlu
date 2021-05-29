package javaee.jpa3.many2many.util;

import javaee.jpa3.many2many.entity.ManyToManyCourse;
import javaee.jpa3.many2many.entity.ManyToManyTeacher;
import javaee.jpa3.one2many.entity.OneToManyCourse;
import javaee.jpa3.one2many.entity.OneToManyTeacher;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ManyToManyUtil {
    public static void outToPage(PrintWriter out , List<ManyToManyTeacher> result)
    {
        out.println("id\t name \t age \t gender \t courses");
        out.println("<br>");
        for (ManyToManyTeacher m: result) {
            out.print(m.getId() + "\t" +m.getTeacherName()+"\t"+m.getAge() + "\t" + m.getGender() + "\t | ");
            for (ManyToManyCourse c:m.getCourses())
            {
                out.println(c.getCourseName() + " \t");
            }
            out.println("<br>");
        }
    }
    public static ManyToManyTeacher getTeacher(HttpServletRequest req)
    {
        ManyToManyTeacher teacher;
        Integer id=Integer.parseInt(req.getParameter("id"));
        Integer age=Integer.parseInt(req.getParameter("age"));
        String name=req.getParameter("name");
        String gender=req.getParameter("gender");
        String courses=req.getParameter("course");
        List<ManyToManyCourse> courseList=new ArrayList<>();
        teacher=new ManyToManyTeacher(id,age,gender,name,courseList);
        for(String courseName:courses.split("&"))
        {
            ManyToManyCourse course=new ManyToManyCourse();
            course.setCourseName(courseName);
            course.getTeachers().add(teacher);
            teacher.getCourses().add(course);
        }
        return teacher;
    }
}
