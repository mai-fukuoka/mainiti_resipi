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
import models.validators.MyresipiValidator;
import utils.DBUtil;

/**
 * Servlet implementation class MyresipiCreate
 */
@WebServlet("/myresipis/create")
public class MyresipiCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyresipiCreate() {
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

            Myresipi m=new Myresipi();

            m.setUser((User)request.getSession().getAttribute("login_user"));

            m.setTitle(request.getParameter("title"));
            m.setContent(request.getParameter("content"));
            m.setMaterials(request.getParameter("materials"));
            m.setComents(request.getParameter("coments"));

            List<String> errors = MyresipiValidator.validate(m);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("myresipi", m);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/myresipis/new.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(m);
                em.getTransaction().commit();
                em.close();

        }
        }
        response.sendRedirect(request.getContextPath() + "/myresipis/index");
    }
}

