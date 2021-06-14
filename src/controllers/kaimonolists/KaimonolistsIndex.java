package controllers.kaimonolists;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Kaimonolist;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class Index
 */
@WebServlet("/kaimonolists/index")
public class KaimonolistsIndex extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KaimonolistsIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em=DBUtil.createEntityManager();
        User login_user = (User)request.getSession().getAttribute("login_user");

        //ページネーション
        int page=1;
        try{
            page=Integer.parseInt(request.getParameter("page"));
        }catch(NumberFormatException k){}
        List<Kaimonolist>kaimonolists=em.createNamedQuery("getAllKaimonolists",Kaimonolist.class)
                .setParameter("userid",login_user.getUser_id())
                .setFirstResult(9*(page-1))
                .setMaxResults(9)
                .getResultList();

        long kaimonolists_count=(long)em.createNamedQuery("getKaimonolistsCount",Long.class)
                .setParameter("userid",login_user.getUser_id())
                .getSingleResult();
        em.close();

        request.setAttribute("kaimonolists", kaimonolists);
        request.setAttribute("kaimonolists_count", kaimonolists_count);
        request.setAttribute("page", page);
        request.setAttribute("_token", request.getSession().getId());


        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/kaimonolists/index.jsp");
        rd.forward(request,response);



    }
}