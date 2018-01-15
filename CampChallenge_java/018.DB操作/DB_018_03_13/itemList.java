/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.DB.DB_018_03_13;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class itemList extends HttpServlet {

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
            out.println("<title>商品一覧</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //Challenge_dbに関するユーザー情報
            String URL = "jdbc:mysql://localhost:3306/challenge_db";
            String USERNAME = "kimikoishii";
            String PASSWORD = "kmkooo0109";

            Connection con = null;
            PreparedStatement ps = null;

            request.setCharacterEncoding("UTF-8");
            HttpSession You = request.getSession();
            String checkName = String.valueOf(You.getAttribute("Name"));
            String checkID = String.valueOf(You.getAttribute("ID"));
            int YourID = Integer.parseInt(checkID);

            try {
                //Challenge_dbに接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                String sql = "select * from item where managerID like ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, YourID);

                ResultSet rs = ps.executeQuery();

                out.print(checkName + "　さんの商品一覧<br><br>");
                while (rs.next()) {
                        out.print("商品ID：" + rs.getInt("itemID"));
                        out.print("・");
                        out.print("商品名：" + rs.getString("itemName"));
                        out.print("・");
                        out.print("値段：" + rs.getString("price"));
                        out.print("・");
                        out.print("個数：" + rs.getInt("number"));
                        out.print("<br>");
                    }
                rs.close();
                ps.close();

            //実行時例外のエラー表示    
            } catch (ClassNotFoundException e) {
                out.println("ClassNotFoundException:" + e.getMessage());
            } catch (SQLException e) {
                out.println("SQLException:" + e.getMessage());
            } catch (Exception e) {
                out.println("Exception:" + e.getMessage());
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    out.println("SQLException:" + e.getMessage());
                }
            }
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
