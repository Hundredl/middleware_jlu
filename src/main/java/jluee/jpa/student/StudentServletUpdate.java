package jluee.jpa.student;

import jluee.jpa.stu.Stu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StudentServletUpdate", value = "/student/update")
public class StudentServletUpdate extends HttpServlet {

    private final IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        Student p = new Student();
        p.setGender("female");
        p.setName("testUpdate");
        p.setMajor("updating");
        Address address = new Address();
        address.setDetail("test update address");
        p.setAddress(address);
        studentService.updateStudent(3, p);
    }
}
