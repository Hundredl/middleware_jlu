package javaee.book.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PageTurn {
    public enum PageName{test,toLogin}
    public static void turnToPage(HttpServletRequest req, HttpServletResponse resp, PageName pageName) throws ServletException, IOException {
        String url;
        switch (pageName)
        {
            case test:url="/book/pages/user/test.html";break;
            case toLogin:url="/book/pages/tips/toLogin.html";break;
            default:url="/book/pages/user/test.html";break;
        }
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
