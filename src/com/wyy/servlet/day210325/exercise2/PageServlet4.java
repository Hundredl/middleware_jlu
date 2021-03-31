package com.wyy.servlet.day210325.exercise2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/page4")
public class PageServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1    使用ServletContext共享变量
        ServletContext sc = request.getServletContext();
        //sc.setAttribute("sharingvar_sc", "context");
        // 2    使用HttpSession共享变量
        HttpSession session = request.getSession();
        //session.setAttribute("sharingvar_se", "session");
        // 3    使用HttpServletRequest共享变量
        //request.setAttribute("sharingvar_req", "request");
        //4     跳转到新的页面读取共享变量结果
        String sc_value = (String) sc.getAttribute("sharingvar_sc");
        String session_value = (String) session.getAttribute("sharingvar_se");
        String request_value = (String) request.getAttribute("sharingvar_req");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("    <HEAD><meta charset=\"UTF-8\"><TITLE>A Servlet</TITLE></HEAD>");
        out.println("    <BODY>");
        out.println("读取共享变量页面page4<br>");
        out.println("Context:" + sc_value + "<br>");
        out.println("Session:" + session_value + "<br>");
        out.println("Request:" + request_value + "<br>");
        out.println("    <a href=/page1>");
        out.println("    使用超链接跳转到使用共享变量页面" + "<br>");
        out.println("    </a>");
        out.println("跳转到使用共享变量页面方式如下:" + "<br>");
        out.println("page1:在同一个页面中读取共享变量" + "<br>");
        out.println("page2:转发,request.getRequestDispatcher(\"/page4\").forward(request, response);" + "<br>");
        out.println("page3:跳转response.sendRedirect(\"/page4\");" + "<br>");

        out.println("    </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
