package javaee.jpa3.one2many.servlet;

import javaee.jpa.one.entity.Mentor;
import javaee.jpa3.one2many.entity.One2manyCourse;
import javaee.jpa3.one2many.entity.One2manyTeacher;
import javaee.jpa3.one2many.service.One2ManyTeacherService;
import javaee.jpa3.one2many.service.One2ManyTeacherServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "One2ManySelect" ,value = "/jpa3/one2many/select")
public class One2ManySelect extends HttpServlet {
    private static One2ManyTeacherService service=new One2ManyTeacherServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //返回结果
        PrintWriter out = resp.getWriter();
        List<One2manyTeacher> result = service.findAll();
        out.println("id\t name \t age \t gender \t courses");
        out.println("<br>");
        for (One2manyTeacher m: result) {
            out.print(m.getId() + "\t" +m.getTeacherName()+"\t"+m.getAge() + "\t" + m.getGender() + "\t | ");
            for (One2manyCourse c:m.getCourses())
            {
                out.println(c.getCourseName() + " \t");
            }
            out.println("<br>");
        }
    }
}
