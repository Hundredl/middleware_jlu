package javaee.jpa.two.servlet;

import javaee.jpa.two.entity.Course;
import javaee.jpa.two.entity.Teacher;
import javaee.jpa.two.service.TeacherService;
import javaee.jpa.two.service.TeacherServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TeacherADD", value = "/jpa/teacher/add")
public class TeacherADD extends HttpServlet {
    static TeacherService teacherService=new TeacherServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Teacher teacher=new Teacher(Integer.parseInt(req.getParameter("id")),Integer.parseInt(req.getParameter("age")),req.getParameter("gender"),req.getParameter("name"),new Course(1,req.getParameter("course")));
        teacherService.add(teacher);
        //返回结果
        PrintWriter out = resp.getWriter();
        List<Teacher> result = teacherService.findAll();
        out.println("id\t gender \t age \t name \t course");
        out.println("<br>");
        for (Teacher m: result) {
            out.println(m.getId() + "\t" + m.getGender() + "\t" + m.getAge() + "\t"+ m.getTeacherName()+"\t"+m.getCourse().getCourseName());
            out.println("<br>");
        }
    }
}
