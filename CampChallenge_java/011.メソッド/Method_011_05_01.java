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
public class Method_011_05_01 extends HttpServlet {
    

  
    //引数として渡された値と同じIDを持つ人物のプロフィールを返却する
    //同じIDの人物がいなければエラーメッセージを表示
    String[] profile(String ID) {
        String[] data1 = {"123", "石井喜美子", "1991年2月27日", "埼玉県"};
        String[] data2 = {"456", "いしいきみこ", "2017年12月18日", "栃木県"};
        String[] data3 = {"789", "イシイキミコ", "不明", "鹿児島県"};
        String[] error = {"ERROR","ERROR!!!!!"};
        
    switch(ID) {
            case "123":
              return data1;
            case "456":
                return data2;
            case "789":
                return data3;
            default://上記以外の文字はエラーメッセージを表示
                return error;    
}
        
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
        
        //引数を渡してメソッドから配列を呼び出す    
        String[] d = profile("123");
        //配列を順番に表示するループ処理（IDは除外）
        for(String i:d) {
                if (i == d[0]) {//IDの表示を除外する
                continue;
                }
                out.print(i + "<br>");
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
