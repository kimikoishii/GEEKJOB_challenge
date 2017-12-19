/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.Method;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class Method_011_05_02 extends HttpServlet {
    
    //3人のプロフィールが入った配列を作成
    String[][] Human() {
        String[] data1 = {"123", "石井喜美子", "1991年2月27日", "埼玉県"};
        String[] data2 = {"456", "いしいきみこ", "2017年12月18日", "栃木県"};
        String[] data3 = {"789", "イシイキミコ", "1192年8月11日", null};
    //配列の配列を作成
    String[] all[] = {data1,data2,data3};
        return all;
    }    

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

            
        //プロフィール表示のループ処理    
        String[][] someHuman = Human();
        //someHumanの中の「data」を取り出す
        for(int i = 0; i < someHuman.length; i++){
            String[] oneHuman = someHuman[i];    
        
            //個々のプロフィールを取り出す
            for(int j = 0; j< oneHuman.length; j++){
                String prof = oneHuman[j];  
                //IDと、あればnullの表示をスキップする
                if(j == 0 || prof == null){continue;}
                
                 out.print(prof + "<br>");

            }
        
        out.print("<br>");
            
        }

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
