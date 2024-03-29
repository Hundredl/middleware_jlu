package javaee.book.servlet.login;

import javaee.book.entity.BookUser;
import javaee.book.entity.resp.BookUserResp;
import javaee.book.service.UserService;
import javaee.book.utils.GlobalVar;
import javaee.book.utils.ServletUtils;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 登录使用到的servlet
 */
@WebServlet(name = "LoginServlet" , value = "/book/login")
public class LoginServlet extends HttpServlet {
    UserService userService=new UserService();
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        resp.setContentType("application/json;charset=UTF-8");
        Map<?,?> params= ServletUtils.getPostParams(req);

        String userName=params.get("userName").toString();
        String password=params.get("password").toString();

        if (userService.canLoginIn(userName,password))
        {
            BookUser bookUser=userService.selectByUserName(userName);
            BookUserResp bookUserResp=new BookUserResp();
            BeanUtils.copyProperties(bookUserResp,bookUser);
            req.getSession().setAttribute("user",bookUserResp);
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.success,bookUserResp);
        }
        else {
            //PageTurn.turnToPage(req,resp, PageTurn.PageName.toLogin);
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.failure,null);

        }
    }
}
