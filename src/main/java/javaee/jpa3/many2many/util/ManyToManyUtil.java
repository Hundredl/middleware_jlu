package javaee.jpa3.many2many.util;

import javaee.jpa3.many2many.entity.ManyToManyCourse;
import javaee.jpa3.many2many.entity.ManyToManyTeacher;
import javaee.jpa3.one2many.entity.OneToManyCourse;
import javaee.jpa3.one2many.entity.OneToManyTeacher;

import java.io.PrintWriter;
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
}
