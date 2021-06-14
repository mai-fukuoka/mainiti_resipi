package controllers.kaimonolists;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Kaimonolist;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class KaimonolistsDestroy
 */
@WebServlet("/kaimonolists/destroy")
public class KaimonolistsDestroy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KaimonolistsDestroy() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        User login_user = (User)request.getSession().getAttribute("login_user");

        //データベースから削除する
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();
            em.getTransaction().begin();
            em.createNamedQuery("removeAllKaimonolists",Kaimonolist.class)
            .setParameter("userid",login_user.getUser_id()).executeUpdate();

            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/kaimonolists/index");
        }
    }
}

