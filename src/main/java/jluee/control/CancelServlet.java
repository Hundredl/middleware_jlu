package jluee.control;

import jluee.biz.UserBiz;
import jluee.client.MyContext;
import jluee.entity.User;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 吴非凡
 */
@WebServlet(name = "CancelServlet", value = "/cancel")
public class CancelServlet extends HttpServlet {

    private static final String RESPONSE = "/hello/response.jsp";
    private static final String ERROR = "/hello/error.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("binding_name");

        Context ctx = MyContext.getContext();
        try {
            ctx.unbind(name);
            HttpSession session = request.getSession();
            session.setAttribute("code", "取消绑定成功！");
            session.setAttribute("result", "");
            response.sendRedirect(RESPONSE);
        } catch (NamingException e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("code", "取消绑定失败！");
            response.sendRedirect(ERROR);
        }

    }
}
