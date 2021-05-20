package jluee.jpa.stu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StuServlet", value = "/stu")
public class StuServlet extends HttpServlet {

    private final IStuService stuService = new StuService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Stu> result = stuService.findAllStudents();

        out.println("Id\tname\tmajor");
        out.println("<br>");
        for (Stu c: result) {
            out.println(c.getId() + "\t" + c.getName() + "\t" + c.getMajor());
            out.println("<br>");
        }
    }
}
