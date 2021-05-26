package javaee.jpa.two.servlet;

import javaee.jpa.one.entity.Mentor;
import javaee.jpa.one.service.MentorService;
import javaee.jpa.one.service.MentorServiceImp;
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

@WebServlet(name = "TeacherSelect", value = "/jpa/teacher/select")
public class TeacherSelect extends HttpServlet {
    static TeacherService teacherService=new TeacherServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

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
