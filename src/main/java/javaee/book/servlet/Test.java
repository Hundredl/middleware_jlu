package javaee.book.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.RemoteException;

@WebServlet(name="test",value = "/book/test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getSession().setAttribute("user","user");
        //PageTurn.turnToPage(req,resp, PageTurn.PageName.test);
//        try {
//            HelloWS service =  new HelloWSProxy();
//            System.out.println(service.sayHelloWS("a teacher"));
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
        /*try {
            HelloWS service = new HelloWSProxy();
            System.out.println(service.sayHelloWS("a teacher!!!!"));
        } catch (RemoteException e) {
            e.printStackTrace();
        }*/
    }
}
