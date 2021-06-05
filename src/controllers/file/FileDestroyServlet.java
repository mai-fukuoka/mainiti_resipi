package controllers.file;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.FileInfo;
import utils.EntityManagerUtil;

/**
 * アップロードファイルを削除するクラス.
 */
@WebServlet("/destroy")
public class FileDestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ.
     * @see HttpServlet#HttpServlet()
     */
    public FileDestroyServlet() {
        super();
    }

    /**
     * アップロードファイルを削除するメソッド.
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Request、Responseの文字コードを「UTF-8」に設定
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // リクエストパラメータからファイルIDを取得
        String id = request.getParameter("id");

        // EntityManagerのインスタンスを生成
        EntityManager em = EntityManagerUtil.createEntityManager();

        // ファイルIDをキーにファイル情報を取得
        FileInfo file = em.find(FileInfo.class, Integer.parseInt(id));

        // トランザクションを開始
        em.getTransaction().begin();

        // ファイルデータ削除
        em.remove(file);

        // トランザクションをコミット
        em.getTransaction().commit();

        // EntityManagerのインスタンスを閉じる
        em.close();

        // indexページへリダイレクト
        response.sendRedirect(request.getContextPath() + "/list");

    }
}