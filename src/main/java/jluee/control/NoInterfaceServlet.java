package jluee.control;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 吴非凡
 */
@WebServlet(name = "NoInterfaceServlet", value = "/nointerface")
public class NoInterfaceServlet extends HttpServlet {

    @EJB
    private jluee.biz.NoInterfaceHelloBean hello;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out;
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet call no interface EJB</title>");
            out.println("</head>");
            out.println("<body>");
            String result = "";
            result = hello.sayHello("Jilin University");
            out.println("no interface executed - Result: " + result);
            out.println("</body>");
            out.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}