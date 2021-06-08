package controllers.myresipi;

import java.io.IOException;

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
 * Servlet implementation class MyresipiEdit
 */
@WebServlet("/myresipis/edit")
public class MyresipiEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyresipiEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Myresipi m = em.find(Myresipi.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        User login_user = (User)request.getSession().getAttribute("login_user");
        if(m != null && login_user.getId() == m.getUser().getId()) {
            request.setAttribute("myresipi", m);
            request.setAttribute("_token", request.getSession().getId());
            request.setAttribute("myresipi_id", m.getId());
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/myresipis/edit.jsp");
        rd.forward(request, response);

    }

}
