package javaee.jpa.one.servlet;

import javaee.jpa.one.entity.Mentor;
import javaee.jpa.one.service.MentorService;
import javaee.jpa.one.service.MentorServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MentorDelete" , value = "/jpa/mentor/delete")
public class MentorDelete extends HttpServlet {

    static MentorService mentorService=new MentorServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        List<Mentor> result = mentorService.findAll();

        out.println("Id\tname\tmajor");
        out.println("<br>");
        for (Mentor mentor: result) {
            out.println(mentor.getId() + "\t" + mentor.getGender() + "\t" + mentor.getAge() + "\t"+ mentor.getTeacherName());
            out.println("<br>");
        }
    }
}
