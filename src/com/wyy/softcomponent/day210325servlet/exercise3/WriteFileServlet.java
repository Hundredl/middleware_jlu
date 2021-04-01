package com.wyy.softcomponent.day210325servlet.exercise3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/writefile")
public class WriteFileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        //从response中获得PrintWriter类的对象，以用于向页面输出信息
        PrintWriter out = response.getWriter();
        String fileName = "temp.txt";//文件相对路径
        //文件绝对路径
        String filePath = "C:\\Users\\Administrator\\Desktop\\temp.txt";// 				this.getServletContext().getRealPath(fileName);
        //使用文件的绝对路经打开文件，如果文件不存在则创建文件
        File file = new File(filePath);
        //使用打开的文件对象，创建FileWriter类的实例
        FileWriter writer = new FileWriter(file);
        //使用打开文件对应的writer对象，创建BufferedWriter类的实例
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        //通过BufferedReader 类的实例，向文件中写入信息
        bufferWriter.write("Servlet写文件");
        //刷新缓存，将缓存中的内容写入到文件中
        bufferWriter.flush();
        bufferWriter.close();
        writer.close();
        out.print("文件写入完毕，路径:" + file.getAbsolutePath());
    }

}
