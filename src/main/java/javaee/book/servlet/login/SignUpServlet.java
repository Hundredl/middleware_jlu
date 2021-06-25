package javaee.book.servlet.login;

import javaee.book.entity.BookUser;
import javaee.book.entity.resp.BookUserResp;
import javaee.book.service.UserService;
import javaee.book.utils.GlobalVar;
import javaee.book.utils.ServletUtils;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 注册使用到的servlet
 */
@WebServlet(name = "SignUpServlet" , value = "/book/signup")
public class SignUpServlet extends HttpServlet {
    UserService userService=new UserService();
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        Map<?,?> params= ServletUtils.getPostParams(req);

        String userName=params.get("userName").toString();
        String password=params.get("password").toString();
        if (userService.selectByUserName(userName)==null)
        {
            //说明可以注册
            BookUser bookUser = new BookUser(null,userName,password,1);
            userService.add(bookUser);
            BookUserResp bookUserResp = new BookUserResp();
            BeanUtils.copyProperties(bookUserResp,bookUser);
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.success,bookUserResp);
        }
        else {
            ServletUtils.returnResp(resp, GlobalVar.RespMsg.failure,null);
        }
    }
}
