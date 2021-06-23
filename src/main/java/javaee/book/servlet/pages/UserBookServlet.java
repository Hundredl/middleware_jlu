package javaee.book.servlet.pages;

import javaee.book.utils.PageTurn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserBookServlet" , value = "/book/pages/user/book")
public class UserBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageTurn.turnToPage(req,resp, PageTurn.PageName.userBook);
    }
}
