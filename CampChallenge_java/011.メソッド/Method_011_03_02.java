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

/**
 *
 * @author guest1Day
 */
public class Method_011_03_02 extends HttpServlet {
    
    //3つ目の引数が偶数ならtrue・奇数ならfalse
    void suji(int num1 , int num2 , int num3 , PrintWriter pw){
        
        //1つ目と2つ目の引数をかけた結果を表示
        int total1 = num1 * num2;
        pw.print(num1 + "×" + num2 + "は、" + total1 + "です。<br>");
        
        //3つ目の引数が偶数か奇数か判定
        if(num3%2 ==0){
           int total2 = total1 * total1;//3つ目の引数がtrueならtotal1を二乗します。
           pw.print(total1 + "×" + total1 + "は、" + total2 +"です。<br>");
           pw.print("最終結果は、" + total2 + "です。<br><br>");
        }else{
            pw.print("最終結果は、" + total1 + "です。<br><br>");//falseなら二乗しないでtotalを表示します。
        }
        }
    //デフォルト値の設定。2つ目の引数は5、3つ目の引数はfalse
    void suji(PrintWriter pw){
        suji(2,5,1,pw);
    
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>引数2</title>");            
            out.println("</head>");
            out.println("<body>");
            
            suji(2,2,3,out);
            suji(2,2,2,out);
            suji(100,100,1,out);
            
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
