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

@WebServlet("/page2")
public class PageServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1    使用ServletContext共享变量
        ServletContext sc = this.getServletContext();
        sc.setAttribute("sharingvar_sc", "context");
        // 2    使用HttpSession共享变量
        HttpSession session = request.getSession();
        session.setAttribute("sharingvar_se", "session");
        // 3    使用HttpServletRequest共享变量
        request.setAttribute("sharingvar_req", "request");
        sc.setAttribute("type", "转发:request.getRequestDispatcher(\"/page4\").forward(request, response);");

        //4     转发到新的页面读取共享变量结果
        request.getRequestDispatcher("/page4").forward(request, response);
    }
}