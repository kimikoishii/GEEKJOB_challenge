/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.DB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author guest1Day
 */
public class DB_018_03_11 extends HttpServlet {

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
            out.println("<title>Servlet DB_018_03_11</title>");
            out.println("</head>");
            out.println("<body>");

            //Challenge_dbに関するユーザー情報
            String URL = "jdbc:mysql://localhost:3306/challenge_db";
            String USERNAME = "kimikoishii";
            String PASSWORD = "kmkooo0109";

            request.setCharacterEncoding("UTF-8");
            int UserID = Integer.parseInt(request.getParameter("userID"));
            String Name = request.getParameter("userName");
            String[] Ttips = {request.getParameter("tell1"),
                request.getParameter("tell2"), request.getParameter("tell3")};
            String Tell = Ttips[0] + "-" + Ttips[1] + "-" + Ttips[2];
            String Ages = request.getParameter("age");
            String Birthdays = request.getParameter("birthday");
            String dmIDs = request.getParameter("departmentID");
            String stIDs = request.getParameter("stationID");

            Connection con = null;
            PreparedStatement ps = null;

            try {
                //Challenge_dbに接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                String name = "";
                String tell = "";
                String age = "";
                String birthday = "";
                String departmentID = "";
                String stationID = "";

                if (Name.equals("")) {
                    out.print("nameは更新しません。<br>");
                } else {
                    name = "update user set name=? where userID=" + UserID + ";";
                    ps = con.prepareStatement(name);
                    ps.setString(1, Name);//name
                    int num = ps.executeUpdate();
                    out.print("nameのデータを更新しました。<br>");
                }
                if (Ttips[0].equals("")) {
                    out.print("tellは更新しません。<br>");
                } else {
                    tell = "update user set tell=? where userID=" + UserID + ";";
                    ps = con.prepareStatement(tell);
                    ps.setString(1, Tell);//tell
                    int num = ps.executeUpdate();
                    out.print("tellのデータを更新しました。<br>");
                }
                if (Ages.equals("")) {
                    out.print("ageは更新しません。<br>");
                } else {
                    int Age = Integer.parseInt(Ages);
                    age = "update user set age=? where userID=" + UserID + ";";
                    ps = con.prepareStatement(age);
                    ps.setInt(1, Age);//age
                    int num = ps.executeUpdate();
                    out.print("ageのデータを更新しました。<br>");
                }
                if (Birthdays.equals("")) {
                    out.print("birthdayは更新しません。<br>");
                } else {
                    Date Birthday = java.sql.Date.valueOf(Birthdays);
                    birthday = "update user set birthday=? where userID=" + UserID + ";";
                    ps = con.prepareStatement(birthday);
                    ps.setDate(1, Birthday);//birthday
                    int num = ps.executeUpdate();
                    out.print("birthdayのデータを更新しました。<br>");
                }
                if (dmIDs.equals("")) {
                    out.print("dmIDは更新しません。<br>");
                } else {
                    int dmID = Integer.parseInt(dmIDs);
                    departmentID = "update user set departmentID=? where userID=" + UserID + ";";
                    ps = con.prepareStatement(departmentID);
                    ps.setInt(1, dmID);//departmentID
                    int num = ps.executeUpdate();
                    out.print("dmIDのデータを更新しました。<br>");
                }
                if (stIDs.equals("")) {
                    out.print("stIDは更新しません。<br>");
                } else {
                    int stID = Integer.parseInt(stIDs);
                    stationID = "update user set stationID=? where userID=" + UserID + ";";
                    ps = con.prepareStatement(stationID);
                    ps.setInt(1, stID);//stationID
                    int num = ps.executeUpdate();
                    out.print("stIDのデータを更新しました。<br>");
                }

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
