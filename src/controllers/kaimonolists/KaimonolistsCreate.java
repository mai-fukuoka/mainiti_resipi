package controllers.kaimonolists;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Kaimonolist;
import utils.DBUtil;

/**
 * Servlet implementation class KaimonolistsCreate
 */
@WebServlet("/kaimonolists/create")
public class KaimonolistsCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KaimonolistsCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String _token=request.getParameter("_token");
    if(_token !=null && _token.equals(request.getSession().getId())){
        EntityManager em=DBUtil.createEntityManager();

        Kaimonolist k=new Kaimonolist();

        em.getTransaction().begin();
        String[] ingredient=request.getParameterValues("todoData");
        if(ingredient !=null){
            for(int i=0; i<ingredient.length; i++){
                k.setUserid(request.getParameter("userid"));
                k.setIngredient(ingredient[i]);
                em.persist(k);
            }

            em.getTransaction().commit();
            em.close();

            request.setAttribute("_token",request.getSession().getId());
            request.getSession().setAttribute("kaimonolist", k);

            response.sendRedirect(request.getContextPath() + "/kaimonolists/index");
}
    }
}
}