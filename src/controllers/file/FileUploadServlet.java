package controllers.file;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import models.FileInfo;
import models.Myresipi;
import utils.EntityManagerUtil;


/**
 * ファイルをアップロードするクラス.
 */
@WebServlet("/upload")
@MultipartConfig(maxFileSize=1048576)
public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ.
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
    }

    /**
     * ファイルをアップロードするメソッド.
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Request、Responseの文字コードを「UTF-8」に設定
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // リクエストからアップロードしたファイルデータを取得
        Part part = request.getPart("uploadFile");

        // try-with-resources文を利用して、InputStreamの変数を宣言
        try  (
                // ファイルストリームを取得
                InputStream fileStream = part.getInputStream();
                ){

            // アップロードしたファイル名を取得
            String fileName = this.getFileName(part);

            // 画像ファイルフラグ
            boolean isImage = this.isImage(fileName);

            // EntityManagerのインスタンスを生成
            EntityManager em = EntityManagerUtil.createEntityManager();

            // トランザクションを開始
            em.getTransaction().begin();

            // ファイル情報(SampleFile)のインスタンスを生成
            FileInfo file = new FileInfo();

            // ファイル名を設定
            file.setName(fileName);

            // ファイルデータをByte[]に型変換し、設定
            file.setData(IOUtils.toByteArray(fileStream));

            // 画像ファイルフラグを設定
            file.setIs_image(isImage);

            // 現在日時を取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            file.setCreated_at(currentTime); // 作成日時を設定
            file.setUpdated_at(currentTime); // 更新日時を設定

            // ファイル情報を新規追加する
            FileInfo savedate = em.merge(file);
            Myresipi m = em.find(Myresipi.class, Integer.parseInt(request.getParameter("id")));
            m.setFile_id(savedate.getId());
            em.persist(m);

            // トランザクションをコミット
            em.getTransaction().commit();

            // EntityManagerのインスタンスを閉じる
            em.close();

        } catch (IOException e) {
            throw e;
        }


        // 編集画面にリダイレクトする
        response.sendRedirect(request.getContextPath() + "/myresipis/edit?id=" + request.getParameter("id"));
    }

    /**
     * 画像ファイルか否かを判定するメソッド.
     * @param ファイル名
     * @return 画像ファイルか判定した結果（画像ファイルの場合、true）
     */
    private boolean isImage(String fileName) {

        if (fileName.endsWith(".gif") || fileName.endsWith(".GIF")
                || fileName.endsWith(".jpeg") || fileName.endsWith(".JPEG")
                || fileName.endsWith(".jpg") || fileName.endsWith(".JPG")
                || fileName.endsWith(".png") || fileName.endsWith(".PNG")) {
            return true;
        }
        return false;
    }

    /**
     * ファイル名を取得するメソッド.
     * @param ファイルのPartオブジェクト
     * @return ファイル名
     */
    private String getFileName(Part part) {

        // ファイル名
        String name = null;

        // ヘッダーの「Content-Disposition」を「;」で分割し、配列
        String[] dispotions = part.getHeader("Content-Disposition").split(";");

        // 「;」で分割した「Content-Disposition」の配列をループ
        for (String dispotion : dispotions) {

            // Dispotionに「filename」が前方一致するか、判定
            if (dispotion.trim().startsWith("filename")) {
                // 「filename」で前方一致した場合
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }

        }
        return name;
    }

}
