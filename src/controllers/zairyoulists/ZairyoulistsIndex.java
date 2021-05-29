package controllers.zairyoulists;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Zairyoulist;
import utils.DBUtil;

/**
 * Servlet implementation class ZairyoulistsIndex
 */
@WebServlet("/zairyoulists/index")
public class ZairyoulistsIndex extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZairyoulistsIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           EntityManager em=DBUtil.createEntityManager();

            int page=1;
            try{
                page=Integer.parseInt(request.getParameter("page"));
            }catch(NumberFormatException k){}
            List<Zairyoulist>zairyoulists=em.createNamedQuery("getAllZairyoulists",Zairyoulist.class)
                                            .setFirstResult(9*(page-1))
                                            .setMaxResults(9)
                                            .getResultList();

            long zairyoulists_count=(long)em.createNamedQuery("getZairyoulistsCount",Long.class)
                                            .getSingleResult();
        em.close();

        request.setAttribute("zairyoulists", zairyoulists);
        request.setAttribute("zairyoulists_count", zairyoulists_count);
        request.setAttribute("page", page);
        request.setAttribute("_token", request.getSession().getId());


        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/zairyoulists/index.jsp");
        rd.forward(request,response);




    }

}