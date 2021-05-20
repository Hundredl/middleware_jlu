package jluee.jpa.student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {

    private final IStudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Student> result = studentService.findAllStudents();

        out.println("Id\tname\tmajor\taddress");
        out.println("<br>");
        for (Student c: result) {
            out.println(c.getId() + "\t" + c.getName() + "\t" + c.getMajor() + "\t" + c.getAddress().getDetail());
            out.println("<br>");
        }
    }
}
