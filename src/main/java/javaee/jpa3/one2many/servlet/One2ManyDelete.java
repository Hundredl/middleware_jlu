package javaee.jpa3.one2many.servlet;

import javaee.jpa3.one2many.service.One2ManyTeacherService;
import javaee.jpa3.one2many.service.One2ManyTeacherServiceImp;
import javaee.jpa3.one2many.util.OneToManyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "One2ManyDelete",value = "/jpa3/one2many/delete")
public class One2ManyDelete extends HttpServlet {
    private static final One2ManyTeacherService service=new One2ManyTeacherServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        int id=Integer.parseInt(req.getParameter("id"));
        service.delete(id);
        //返回结果
        OneToManyUtil.outToPage(resp.getWriter(),service.findAll());
    }
}
