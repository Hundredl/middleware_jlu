package jluee.control;


import jluee.biz.PrintBean;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@WebServlet(name = "PrintServlet", value = "/print")
public class PrintServlet extends HttpServlet {
    @EJB
    PrintBean printBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //调用printAndForget方法
        printBean.printAndForget();
        out.println("<h3>printAndForget executed</h3>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet PrintServlet</title>");

        //调用printAndCheckLater方法
        Future<String> futureResult = printBean.printAndCheckLater();
        if (futureResult.isDone() && !futureResult.isCancelled()) {
            try {
                out.println("<h3>printAndCheckLater executed - Result: " + futureResult.get() + "</h3>");
            } catch (ExecutionException | InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            out.println("<h3>printAndCheckLater is not prepared</h3>");
        }

    }
}
