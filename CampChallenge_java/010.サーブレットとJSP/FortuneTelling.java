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
import javax.servlet.RequestDispatcher;
import org.camp.servlet.ResultData;
import java.util.Date;


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
       
            
            
            //占い結果のリスト
            String lucklist[] = {"大吉", "中吉", "吉", "半吉", "末小吉", "凶", "小凶", "半凶", "末凶", "中凶", "大凶"};
            
            //リストからランダムで取り出します
            Random rand = new Random();
            Integer index = rand.nextInt(lucklist.length);
           
            //リクエストスコープの準備
            ResultData data = new ResultData();
            request.setAttribute("DATA",data);
            
            //日付をセット
            data.setD(new Date());
            //運勢をセット
            data.setluck(lucklist[index]);
            //要素番号（コメント用）をセット
            data.setI(index);
            
            //表示するJSPファイルの指定
            RequestDispatcher rd = request.getRequestDispatcher("/FortuneTellingResult.jsp");
            rd.forward(request, response);

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
