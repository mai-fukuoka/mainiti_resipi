package controllers.zairyoulists;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Zairyoulist;
import utils.DBUtil;

/**
 * Servlet implementation class ZairyoulistsDestroy
 */
@WebServlet("/zairyoulists/destroy")
public class ZairyoulistsDestroy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZairyoulistsDestroy() {
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
            em.getTransaction().begin();
            em.createNamedQuery("removeAllZairyoulists",Zairyoulist.class)
                    .setParameter("userid","abc").executeUpdate();

            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/zairyoulists/index");
        }
    }

}
