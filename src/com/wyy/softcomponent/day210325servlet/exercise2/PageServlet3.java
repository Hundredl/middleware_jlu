package com.wyy.softcomponent.day210325servlet.exercise2;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/page3")
public class PageServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1    使用ServletContext共享变量
        ServletContext sc = this.getServletContext();
        sc.setAttribute("sharingvar_sc", "context");
        sc.setAttribute("type", "跳转:response.sendRedirect(\"/page4\");");
        // 2    使用HttpSession共享变量
        HttpSession session = request.getSession();
        session.setAttribute("sharingvar_se", "session");
        // 3    使用HttpServletRequest共享变量
        request.setAttribute("sharingvar_req", "request");
        //4     跳转到新的页面读取共享变量结果
        response.sendRedirect("/page4");

    }
}
