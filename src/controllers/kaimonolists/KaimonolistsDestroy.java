package controllers.kaimonolists;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Kaimonolist;
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

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Kaimonolist k=em.find(Kaimonolist.class, (Integer)(request.getSession().getAttribute("kaimonolist_id")));

            em.getTransaction().begin();
            em.remove(k);
            em.getTransaction().commit();
            em.close();

            request.getSession().removeAttribute("kaimonolist_id");

            response.sendRedirect(request.getContextPath() + "/kaimonolists/index");
        }
    }
}

