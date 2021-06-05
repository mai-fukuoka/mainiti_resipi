package controllers.myresipi;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Myresipi;
import utils.DBUtil;

/**
 * Servlet implementation class MyeresipiDestroy
 */
@WebServlet("/myresipis/destroy")
public class MyeresipiDestroy extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyeresipiDestroy() {
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

            Myresipi m = em.find(Myresipi.class, (Integer)(request.getSession().getAttribute("myresipi_id")));

            em.getTransaction().begin();
            em.remove(m);
            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/myresipis/index");
        }

    }

}
