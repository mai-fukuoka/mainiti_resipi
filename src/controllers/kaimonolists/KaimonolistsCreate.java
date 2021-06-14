package controllers.kaimonolists;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Kaimonolist;
import models.User;
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
        //CSRF対策のチェック
        String _token=request.getParameter("_token");
        if(_token !=null && _token.equals(request.getSession().getId())){
            EntityManager em=DBUtil.createEntityManager();

            //ユーザー情報をセッションスコープへと保存
            User login_user = (User)request.getSession().getAttribute("login_user");

            em.getTransaction().begin();
            em.createNamedQuery("removeAllKaimonolists",Kaimonolist.class)
            .setParameter("userid",login_user.getUser_id()).executeUpdate();

            //リストの中身を順番に保管
            String[] ingredient=request.getParameterValues("todoData");
            if(ingredient !=null){
                for(int i=0; i<ingredient.length; i++){
                    Kaimonolist k=new Kaimonolist();
                    k.setUserid(login_user.getUser_id());

                    k.setIngredient(ingredient[i]);
                    em.persist(k);
                }
                em.getTransaction().commit();
                em.close();
            }
        }
        // CSRF対策
        request.setAttribute("_token",request.getSession().getId());

        //index.jspへと遷移
        response.sendRedirect(request.getContextPath() + "/kaimonolists/index");


    }
}