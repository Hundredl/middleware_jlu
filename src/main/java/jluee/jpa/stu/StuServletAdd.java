package jluee.jpa.stu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StuServletAdd", value = "/stu/add")
public class StuServletAdd extends HttpServlet {

    private StuService stuService = new StuService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        Stu p = new Stu();
        p.setName("testAdd");
        p.setMajor("add");
        p.setGender("male");


        stuService.addStudent(p);
    }
}
