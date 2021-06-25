package javaee.book.servlet.filter;

import javaee.book.entity.resp.BookUserResp;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录拦截，不登陆的用户不能访问界面。
 * 实际并没有使用这个类
 */
@WebFilter(
        filterName = "loginFilter",
        urlPatterns = "/bookghjkl/*",
        initParams = {
                @WebInitParam(name = "loginPageUrl", value = "/book/pages/login"),
                @WebInitParam(name = "loginUrl" ,value = "/book/login"),
                @WebInitParam(name = "encoding", value = "utf-8")})
public class LoginFilter implements Filter {
    private FilterConfig config;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取配置参数
        String loginUrl=config.getInitParameter("loginUrl");
        String encoding = config.getInitParameter("encoding");
        String loginPageUrl= config.getInitParameter("loginPageUrl");
        //获取请求
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        // 设置请求的字符集（post请求方式有效）
        request.setCharacterEncoding(encoding);
        //获取不带http://:端口的地址
        String uri = req.getRequestURI();
        if (uri.contains(loginUrl)||uri.contains(loginPageUrl))
        {
            chain.doFilter(req,resp);
        }else
        {
            BookUserResp user= (BookUserResp) req.getSession().getAttribute("user");
            if(user==null)
            {
                req.getRequestDispatcher("/book/pages/login/login.html").forward(req,resp);
            }
            else {
                chain.doFilter(req,resp);
            }
        }
    }


    @Override
    public void init(FilterConfig config) {
        this.config = config;

    }

    @Override
    public void destroy() {
        this.config = null;
    }
}

