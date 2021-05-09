package controllers.kaimonolists;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            request.getSession().getAttribute("kaimonolist");

            em.getTransaction().begin();
            em.remove("kaimonolist");
            em.getTransaction().commit();
            em.close();

            request.getSession().removeAttribute("kaimonolist");

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/kaimonolists/index.jsp");
            rd.forward(request, response);
        }
    }
}

