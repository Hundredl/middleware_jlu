package javaee.book.servlet.pages;

import javaee.book.utils.PageTurn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 页面跳转使用到的servlet，跳转到登录界面
 */
@WebServlet(name = "LoginPageServlet" , value = "/book/pages/login")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageTurn.turnToPage(req,resp, PageTurn.PageName.login);
    }
}
