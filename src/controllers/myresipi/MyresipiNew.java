package controllers.myresipi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Myresipi;

/**
 * Servlet implementation class MyresipiNew
 */
@WebServlet("/myrespi/new")
public class MyresipiNew extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyresipiNew() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token",request.getSession().getId());

        Myresipi m=new Myresipi();
        request.setAttribute("myresipi", m);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/myresipis/new.jsp");
        rd.forward(request, response);

    }
}
