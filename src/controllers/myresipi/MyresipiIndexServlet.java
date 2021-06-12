package controllers.myresipi;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Myresipi;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class MyresipiIndexServlet
 */
@WebServlet("/myresipis/index")
public class MyresipiIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyresipiIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em=DBUtil.createEntityManager();
        User loginUser = (User)request.getSession().getAttribute("login_user");

        int page;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }
        List<Myresipi> myresipis = em.createNamedQuery("getAllMyresipis", Myresipi.class)
                                  .setParameter("user",loginUser)
                                  .setFirstResult(10 * (page - 1))
                                  .setMaxResults(10)
                                  .getResultList();

        long myresipis_count = (long)em.createNamedQuery("getMyresipisCount", Long.class)
                                     .setParameter("user",loginUser)
                                     .getSingleResult();

        em.close();

        request.setAttribute("myresipis", myresipis);
        request.setAttribute("myresipis_count", myresipis_count);
        request.setAttribute("page", page);
    RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/myresipis/index.jsp");
    rd.forward(request, response);

    }
}
