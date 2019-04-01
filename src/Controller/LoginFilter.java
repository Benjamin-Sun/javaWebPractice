package Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        /**
         * 1:未登录之前：login.jsp和login.user直接放行
         *
         */
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String uri=request.getRequestURI();
        System.out.println(uri);
        int offset=uri.lastIndexOf("/");
        if(offset!=uri.length()-1) {

            String path = uri.substring(uri.lastIndexOf("/") + 1, uri.indexOf("."));
            if ("login".equals(path)) {
                chain.doFilter(servletRequest, servletResponse);
                return;
            }

            /**
             * 2:是否登录：登录成功session：放行
             *    登录不成功，没有session：不能放行，显示登录login.jsp
             */

            HttpSession session=request.getSession();
            HttpServletResponse response=(HttpServletResponse) servletResponse;
            if(session.getAttribute("user")==null){
                response.sendRedirect("login.jsp");
            }else{
                chain.doFilter(servletRequest,servletResponse);
            }


        }else {
            chain.doFilter(servletRequest, servletResponse);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
