package javaee.jpa3.one2many.util;

import javaee.jpa3.one2many.entity.OneToManyCourse;
import javaee.jpa3.one2many.entity.OneToManyTeacher;

import java.io.PrintWriter;
import java.util.List;

public class OneToManyUtil {
    public static void outToPage(PrintWriter out ,List<OneToManyTeacher> result)
    {
        out.println("id\t name \t age \t gender \t courses");
        out.println("<br>");
        for (OneToManyTeacher m: result) {
            out.print(m.getId() + "\t" +m.getTeacherName()+"\t"+m.getAge() + "\t" + m.getGender() + "\t | ");
            for (OneToManyCourse c:m.getCourses())
            {
                out.println(c.getCourseName() + " \t");
            }
            out.println("<br>");
        }
    }
}
