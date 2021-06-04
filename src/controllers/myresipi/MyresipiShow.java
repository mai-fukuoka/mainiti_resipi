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
import utils.DBUtil;

/**
 * Servlet implementation class MyresipiShow
 */
@WebServlet("/myresipis/show")
public class MyresipiShow extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyresipiShow() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            EntityManager em=DBUtil.createEntityManager();

            Myresipi m=em.find(Myresipi.class, Integer.parseInt(request.getParameter("id")));

            em.close();

            request.setAttribute("myresipi", m);
            request.setAttribute("_token", request.getSession().getId());

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/myresipis/show.jsp");
            rd.forward(request, response);
        }

    }


