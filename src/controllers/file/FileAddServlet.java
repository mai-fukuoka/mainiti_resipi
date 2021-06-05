package controllers.file;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ファイルを追加するクラス.
 */
@WebServlet("/add")
public class FileAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ.
     * @see HttpServlet#HttpServlet()
     */
    public FileAddServlet() {
        super();
    }

    /**
     * ファイルを追加するメソッド.
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Request、Responseの文字コードを「UTF-8」に設定
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // jspに遷移
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/files/add.jsp");
        rd.forward(request, response);
     }

}