package jluee.jpa.stu;

import jluee.jpa.student.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StuServletAdd", value = "/stu/add")
public class StuServletAdd extends HttpServlet {

    private StuService stuService = new StuService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String major = request.getParameter("major");

        Stu p = new Stu();
        p.setName(name);
        p.setMajor(major);
        p.setGender(gender);

        stuService.addStudent(p);
    }
}
