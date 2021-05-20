package jluee.jpa.stu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StuServletDel", value = "/stu/del")
public class StuServletDel extends HttpServlet {

    private StuService stuService = new StuService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        stuService.deleteStudent(4);
    }
}
