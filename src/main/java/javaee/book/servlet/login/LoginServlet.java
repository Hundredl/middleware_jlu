package javaee.book.servlet.login;

import javaee.book.entity.BookUser;
import javaee.book.service.UserService;
import javaee.book.utils.PageTurn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet" , value = "/book/login")
public class LoginServlet extends HttpServlet {
    UserService userService=new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Integer userId=Integer.parseInt(req.getParameter("userId"));
        String password=req.getParameter("password");
        if (userService.canLoginIn(userId,password))
        {
            BookUser bookUser=userService.select(userId);
            req.getSession().setAttribute("userId",userId);
            req.getSession().setAttribute("userName",bookUser.getUserName());
            PageTurn.turnToPage(req,resp, PageTurn.PageName.test);
        }
        else {
            PageTurn.turnToPage(req,resp, PageTurn.PageName.toLogin);
        }
    }
}
