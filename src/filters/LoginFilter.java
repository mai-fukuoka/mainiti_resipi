
package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String context_path=((HttpServletRequest)request).getContextPath();
        String servlet_path = ((HttpServletRequest)request).getServletPath();

        if(!servlet_path.matches("/css.*")){
            HttpSession session=((HttpServletRequest)request).getSession();

            User u=(User)session.getAttribute("login_user");

            if(!servlet_path.equals("/login")){ //ログイン画面以外で
                if(servlet_path.matches("/kaimonolists/index")){ //買い物リストの時
                    ((HttpServletResponse)response).sendRedirect(context_path+ "/login"); //ログインするようにする。
                    return;
                }else if(servlet_path.matches("myresipis/index")){ //Myresipiの時
                    ((HttpServletResponse)response).sendRedirect(context_path+"/login");
                    return;
                }

            }else{
              //ログイン画面で
                // ログインしているのにログイン画面を表示させようとした場合は
                // システムのトップページにリダイレクト
                if(u!=null){
                    ((HttpServletResponse)response).sendRedirect(context_path+"/");
                    return;
                }
            }
        }

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }
    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}