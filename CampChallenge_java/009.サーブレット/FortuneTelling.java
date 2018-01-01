/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 *
 * @author guest1Day
 */
public class FortuneTelling extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>うらない</title>");
            out.println("</head>");
            out.println("<body>");
            
            //占い結果のリスト
            String lucklist[] = {"大吉", "中吉", "吉", "半吉", "末小吉", "凶", "小凶", "半凶", "末凶", "中凶", "大凶"};
            
            //リストからランダムで取り出します
            Random rand = new Random();
            Integer index = rand.nextInt(lucklist.length);
            
            //取り出した占い結果を表示します
            out.print("あなたの今日の運勢は……<br>" + "<font size=10 color=red>" + lucklist[index] + "！！！！</font>");
            
            //結果によってコメントを表示します
            out.print("<br>" + "(*^^*)＜");
            //要素番号にコメントを割り振っています
            switch(index) {
            case 0:
                out.print("おめでとう！");
                break;
            case 1:
                out.print("まあまあおめでとう");
                break;
            case 2:
                out.print("ふつう");
                break;
            case 3:
                out.print("ふつうよりちょっと下");
                break;
            case 4:
                out.print("ふつうの中の最下層");
                break;
            case 5:
                out.print("残念");
                break;
            case 6:
                out.print("けっこう残念");
                break;
            case 7:
                out.print("がんばろう");
                break;
            case 8:
                out.print("まだ下がいる！");
                break;
            case 9:
                out.print("ギリギリセーフ");
                break;
            case 10:
                out.print("逆におめでとう！");
                break;
} 
           out.print("）");
           
            out.println("</body>");
            out.println("</html>");
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
