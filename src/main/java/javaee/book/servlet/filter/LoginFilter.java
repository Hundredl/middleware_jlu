package javaee.book.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ��¼���أ�����½���û����ܷ��ʽ���
 */
@WebFilter(
        filterName = "loginFilter",
        urlPatterns = "/books/*",
        initParams = {
                @WebInitParam(name = "loginUrl", value = "/book/login"),
                @WebInitParam(name = "encoding", value = "utf-8")})
public class LoginFilter implements Filter {
    private FilterConfig config;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //��ȡ���ò���
        String loginUrl=config.getInitParameter("loginUrl");
        String encoding = config.getInitParameter("encoding");
        //��ȡ����
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        // ����������ַ�����post����ʽ��Ч��
        request.setCharacterEncoding(encoding);
        //��ȡ����http://:�˿ڵĵ�ַ
        String uri = req.getRequestURI();
        if (uri.contains(loginUrl))
        {
            chain.doFilter(req,resp);
        }else
        {
            String user=(String) req.getSession().getAttribute("user");
            if(user==null)
            {
                req.getRequestDispatcher("/book/pages/tips/toLogin.html").forward(req,resp);
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

