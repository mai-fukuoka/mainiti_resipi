package controllers.user;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.validators.UserValidator;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class UserCreate
 */
@WebServlet("/users/create")
public class UserCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token=request.getParameter("_token");
        if(_token !=null && _token.equals(request.getSession().getId())){
            EntityManager em=DBUtil.createEntityManager();

            User u=new User();

            u.setUser_id(request.getParameter("user_id"));
            u.setName(request.getParameter("name"));
            u.setPassword(
                    EncryptUtil.getPasswordEncrypt(
                            request.getParameter("password"),
                            (String)this.getServletContext().getAttribute("pepper")
                            )
                    );

            //エラーがあったらエラーメッセージをだして新規登録ページへ遷移
            List<String> errors=UserValidator.validate(u, true, true);
            if(errors.size()>0){
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("user", u);
                request.setAttribute("errors", errors);

                RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/users/new.jsp");
                rd.forward(request, response);
            }else{   //エラーがなかったら、データベースに保存してトップページへ遷移
                em.getTransaction().begin();
                em.persist(u);
                em.getTransaction().commit();
                em.close();

                response.sendRedirect(request.getContextPath() + "/index.html");
            }

        }
    }

}