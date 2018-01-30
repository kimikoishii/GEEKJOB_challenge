package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class ResultDetail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更

            //クエリストリングを利用して現在のuserIDを取得
            int ID = Integer.parseInt(request.getParameter("id"));
            //セッションを取得
            HttpSession session = request.getSession();
            //セッションに現在のuserIDを保存
            //UpdateResult.javaで使用
            session.setAttribute("userID", ID);

            //DTOに現在のuserIDを格納
            UserDataDTO searchData = new UserDataDTO();
            searchData.setUserID(ID);

            //DAOのsearchByIDメソッドで検索
            UserDataDTO resultDetail = UserDataDAO.getInstance().searchByID(searchData);

            //セッションに★個人情報詳細を格納
            //Update.javaにて「変更フォームの初期値」として使用
            //Delete.javaにて表示用に使用
            //DeleteResult.javaにて使用
            session.setAttribute("userDetail", resultDetail);

            //検索結果をリクエストディスパッチャでもちまわる（★個人情報詳細）
            request.setAttribute("resultDetail", resultDetail);
            request.getRequestDispatcher("/resultdetail.jsp").forward(request, response);

        } catch (Exception e) {
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
