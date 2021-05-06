package jluee.control;

import jluee.client.MyContext;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 吴非凡
 */
@WebServlet(name = "bindingServlet", value = "/bind")
public class BindingServlet extends HttpServlet {

    private static final String RESPONSE = "/hello/response.jsp";
    private static final String ERROR = "/hello/error.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("binding_name");
        String value = request.getParameter("binding_value");

        Context ctx = MyContext.getContext();
        try {
            ctx.bind(name, value);
            HttpSession session = request.getSession();
            session.setAttribute("code", "绑定成功！");
            session.setAttribute("result", "bind_name:" + name + ";bind_value:" + value);
            response.sendRedirect(RESPONSE);
        } catch (NamingException e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            session.setAttribute("code", "绑定失败！");
            response.sendRedirect(ERROR);
        }

    }
}
