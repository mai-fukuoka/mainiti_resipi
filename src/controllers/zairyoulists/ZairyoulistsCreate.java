package controllers.zairyoulists;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.Zairyoulist;
import utils.DBUtil;

/**
 * Servlet implementation class ZairyoulistsCreate
 */
@WebServlet("/zairyoulists/create")
public class ZairyoulistsCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZairyoulistsCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token=request.getParameter("_token");
        User login_user = (User)request.getSession().getAttribute("login_user");
        if(_token !=null && _token.equals(request.getSession().getId())){
            EntityManager em=DBUtil.createEntityManager();

            em.getTransaction().begin();
            em.createNamedQuery("removeAllZairyoulists",Zairyoulist.class)
            .setParameter("userid", login_user.getUser_id()).executeUpdate();

            String[] ingredient=request.getParameterValues("todoData");
            if(ingredient !=null){
                for(int i=0; i<ingredient.length; i++){
                    Zairyoulist z=new Zairyoulist();
                    z.setUserid(login_user.getUser_id());
                    z.setIngredient(ingredient[i]);
                    em.persist(z);
                }
                em.getTransaction().commit();
                em.close();
            }
        }
        request.setAttribute("_token",request.getSession().getId());

        response.sendRedirect(request.getContextPath() + "/zairyoulists/index");



    }

}