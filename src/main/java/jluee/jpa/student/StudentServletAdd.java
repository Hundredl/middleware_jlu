package jluee.jpa.student;

import jluee.jpa.stu.Stu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StudentServletAdd", value = "/student/add")
public class StudentServletAdd extends HttpServlet {

    private final IStudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String major = request.getParameter("major");
        String addr = request.getParameter("address");

        Student p = new Student();
        p.setName(name);
        p.setMajor(major);
        p.setGender(gender);

        Address address = new Address();
        address.setDetail(addr);
        p.setAddress(address);

        studentService.addStudent(p);

    }
}
