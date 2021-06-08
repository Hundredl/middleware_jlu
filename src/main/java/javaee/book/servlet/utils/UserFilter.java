package javaee.book.servlet.utils;

import javaee.book.utils.GlobalVar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFilter {
    public static GlobalVar.userType getUserType(HttpServletRequest req)
    {
        String userType=(String) req.getSession().getAttribute("user");
        if (userType==null)
        {
            return GlobalVar.userType.none;
        }
        if (userType.equals("user"))
        {
            return GlobalVar.userType.user;
        }
        else if(userType.equals("admin"))
        {
            return GlobalVar.userType.admin;
        }else {
            return GlobalVar.userType.none;
        }
    }
    public static boolean filter(HttpServletRequest req, HttpServletResponse resp,GlobalVar.userType userType) throws ServletException, IOException {
        GlobalVar.userType reqUserType=getUserType(req);
        if (userType== GlobalVar.userType.user)
        {
            if(reqUserType== GlobalVar.userType.none)
            {
                req.getRequestDispatcher("/book/pages/tips/toLogin.html").forward(req,resp);
                return true;
            }
        }
        return false;
    }
}
