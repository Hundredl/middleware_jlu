package com.wyy.servlet.day210325.exercise3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/readfile")
public class FileReadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws IOException {
        //设置页面的文档类型和字符集，页面中的字符所采用的字符集
        response.setContentType("text/html;charset=UTF-8");
        //设置页面的编码方式，即以什么样的编码方式来保存页面文件
        response.setCharacterEncoding("UTF-8");
        //从response中获得PrintWriter类的对象，以用于向页面输出信息
        PrintWriter out = response.getWriter();
        //向页面输出信息
        out.println("HTML文件头......" + "<br>");
        //文件相对路径
        String fileName = "/WEB-INF/web.xml";
        //文件绝对路径
        String filePath = "C:\\Users\\Administrator\\Desktop\\test.txt";//this.getServletContext().getRealPath(fileName);
        //使用文件的绝对路经打开文件
        File file = new File(filePath);
        if (file.exists()) {
            //使用打开的文件对象，创建FileReader类的实例
            FileReader reader = new FileReader(file);
            //使用打开文件对应的reader对象，创建BufferedReader 类的实例
            BufferedReader bufferReader = new BufferedReader(reader);
            String line;
            //逐行读取文件，并输出到页面上
            while ((line = bufferReader.readLine()) != null) {
                out.println(line);
            }
            bufferReader.close();
        } else {
            out.print("未找到文件！");
        }
        out.println("<br>" + "HTML文件尾......");
        out.flush();
        out.close();
    }

}
