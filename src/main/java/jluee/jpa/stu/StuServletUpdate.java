package jluee.jpa.stu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StuServletUpdate", value = "/stu/update")
public class StuServletUpdate extends HttpServlet {

    private StuService stuService = new StuService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        Stu p = new Stu();
        p.setGender("female");
        p.setName("testUpdate");
        p.setMajor("updating");
        stuService.updateStudent(3, p);
    }
}
