package javaee.jpa3.one2many.servlet;

import javaee.jpa3.one2many.entity.OneToManyCourse;
import javaee.jpa3.one2many.entity.OneToManyTeacher;
import javaee.jpa3.one2many.service.One2ManyTeacherService;
import javaee.jpa3.one2many.service.One2ManyTeacherServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "One2ManyAdd" ,value = "/jpa3/one2many/add")
public class One2ManyAdd extends HttpServlet {
    private static One2ManyTeacherService service=new One2ManyTeacherServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //准备数据
        OneToManyTeacher teacher;
        Integer id=Integer.parseInt(req.getParameter("id"));
        Integer age=Integer.parseInt(req.getParameter("age"));
        String name=req.getParameter("name");
        String gender=req.getParameter("gender");
        String courses=req.getParameter("course");
        List<OneToManyCourse> courseList=new ArrayList<>();
        teacher=new OneToManyTeacher(id,age,gender,name,courseList);
        for(String courseName:courses.split("&"))
        {
            OneToManyCourse course=new OneToManyCourse();
            course.setCourseName(courseName);
            course.setTeacher(teacher);
            teacher.getCourses().add(course);
        }
        //添加结果
        service.add(teacher);
        //返回结果
        PrintWriter out = resp.getWriter();
        List<OneToManyTeacher> result = service.findAll();
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
