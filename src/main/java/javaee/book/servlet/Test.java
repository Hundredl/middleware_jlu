package javaee.book.servlet;

import javaee.book.servlet.utils.UserFilter;
import javaee.book.utils.GlobalVar;
import javaee.book.utils.PageTurn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="test",value = "/book/test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("user","user");
        PageTurn.turnToPage(req,resp, PageTurn.PageName.test);
        //if (UserFilter.filter(req,resp, GlobalVar.userType.user)){return;}
        //req.getRequestDispatcher("/book/pages/user/test.html").forward(req,resp);
    }
}
