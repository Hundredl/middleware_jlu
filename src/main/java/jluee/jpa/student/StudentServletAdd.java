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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Student p = new Student();
        p.setName("testAdd");
        p.setMajor("add");
        p.setGender("male");

        Address address = new Address();
        address.setDetail("test add address");
        p.setAddress(address);

        studentService.addStudent(p);

    }
}
