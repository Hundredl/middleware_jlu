package jluee.jpa.student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StudentServletDel", value = "/student/del")
public class StudentServletDel extends HttpServlet {

    private final IStudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");

        studentService.deleteStudent(Integer.parseInt(id));

    }
}
