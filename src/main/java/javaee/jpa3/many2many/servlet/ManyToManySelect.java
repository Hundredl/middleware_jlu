package javaee.jpa3.many2many.servlet;

import javaee.jpa3.many2many.service.ManyToManyTeacherService;
import javaee.jpa3.many2many.service.ManyToManyTeacherServiceImp;
import javaee.jpa3.many2many.util.ManyToManyUtil;
import javaee.jpa3.one2many.util.OneToManyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManyToManySelect" ,value = "/jpa/many2many/select")
public class ManyToManySelect extends HttpServlet {
    ManyToManyTeacherService service=new ManyToManyTeacherServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //返回结果
        ManyToManyUtil.outToPage(resp.getWriter(),service.findAll());
    }
}
