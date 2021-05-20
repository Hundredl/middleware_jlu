package jluee.jpa.stu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StuServletUpdate", value = "/stu/update")
public class StuServletUpdate extends HttpServlet {

    private StuService stuService = new StuService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String major = request.getParameter("major");

        Stu p = new Stu();
        p.setName(name);
        p.setMajor(major);
        p.setGender(gender);
        stuService.updateStudent(Integer.parseInt(id), p);
    }
}
