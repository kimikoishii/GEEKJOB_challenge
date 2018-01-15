/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.DB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class DB_018_03_12 extends HttpServlet {

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
            out.println("<title>Servlet DB_018_03_12</title>");
            out.println("</head>");
            out.println("<body>");

            //Challenge_dbに関するユーザー情報
            String URL = "jdbc:mysql://localhost:3306/challenge_db";
            String USERNAME = "kimikoishii";
            String PASSWORD = "kmkooo0109";

            request.setCharacterEncoding("UTF-8");
            String Name = request.getParameter("userName");
            String Ages = request.getParameter("age");
            String Birthdays = request.getParameter("birthday");

            Connection con = null;
            PreparedStatement ps = null;

            try {
                //Challenge_dbに接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                //入力"されなかった"項目数カウント用
                int count = 0;
                //SQL文用
                String sql = "";

                //name検索
                if (Name.equals("")) {//未入力ならcount+1してage検索へ
                    count++;
                } else {//nameに入力された
                    sql = "select * from user where name like ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, "%" + Name + "%");//部分一致
                }

                //age検索
                if (Ages.equals("")) {//未入力ならcount+2してbirthday検索へ
                    count += 2;
                } else if (count == 1) {//ageに入力された + nameは未入力
                    sql = "select * from user where age like ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, Ages);//完全一致
                } else {//ageに入力された + nameにも入力された
                    sql = "select * from user where name like ? and age like ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, "%" + Name + "%");
                    ps.setString(2, Ages);
                }

                //birthday検索
                if (Birthdays.equals("")) {//未入力ならなにもしない
                } else if (count == 3) {//birthdayに入力された + nameとageは両方未入力
                    sql = "select * from user where birthday like ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, Birthdays);//完全一致     
                } else if (count == 2) {//birthdayに入力された + nameにも入力された + ageが未入力
                    sql = "select * from user where name like ? and birthday like ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, "%" + Name + "%");
                    ps.setString(2, Birthdays);
                } else {//birthdayに入力された + nameとageの両方も入力された
                    sql = "select * from user where name like ? "
                            + "and age like ? and birthday like ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, "%" + Name + "%");
                    ps.setString(2, Ages);
                    ps.setString(3, Birthdays);
                }

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    out.print("個人ID：" + rs.getInt("userID"));
                    out.print("・");
                    out.print("名前：" + rs.getString("name"));
                    out.print("・");
                    out.print("電話番号：" + rs.getString("tell"));
                    out.print("・");
                    out.print("年齢：" + rs.getInt("age"));
                    out.print("・");
                    out.print("誕生日：" + rs.getDate("birthday"));
                    out.print("・");
                    out.print("部門ID：" + rs.getInt("departmentID"));
                    out.print("・");
                    out.print("駅ID：" + rs.getInt("stationID"));
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
