<%-- 
    Document   : managerInfo
    Created on : 2018/01/15, 13:13:28
    Author     : guest1Day
--%>

<%@page import="java.sql.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>管理画面</title>

        <%

            //Challenge_dbに関するユーザー情報
            String URL = "jdbc:mysql://localhost:3306/challenge_db";
            String USERNAME = "kimikoishii";
            String PASSWORD = "kmkooo0109";

            request.setCharacterEncoding("UTF-8");
            String Pass = request.getParameter("pass");

            HttpSession You = request.getSession();
            You.setAttribute("YourPass", Pass);

            Connection con = null;
            PreparedStatement ps = null;
            
            String sql = "";
            String loginName = "";
            String ID = "";
            String checkPass = "";

            try {
                //Challenge_dbに接続
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                sql = "select * from manager where pass like ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, Pass);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    out.print("ようこそ　" + rs.getString("managerName") + "　さん！");
                    out.print("<br>");
                    loginName = rs.getString("managerName");
                    ID = rs.getString("managerID");
                    checkPass = rs.getString("pass");
                    You.setAttribute("Name", loginName);
                    You.setAttribute("ID", ID);
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
        %>
    </head>
    <body>

        <%//
            if (checkPass.equals("")) {
                out.print("ログインできませんでした。");
            } else {
        %>

        <form action="/servlet_challenge/itemList" method="post">
            <input type="submit" value="商品一覧"><br>
        </form>

        <br>▼商品情報を登録<br>
        <form action="/servlet_challenge/itemAdd" method="post">

            <label>▽商品名<br>
                <input type="text" name="item" required><br>
                ▽値段<br>
                <input type="number" name="pri" min="1" 
                       style="width:100px;"required>円<br>
                ▽個数<br>
                <input type="number" name="number" min="1" 
                       style="width:50px;" required>個<br>
            <input type="submit" name="btn" value="商品登録"><br></label>
        </form>

        <br><form action="logout.jsp" method="post">
            <input type="submit" value="ログアウト"><br>
        </form>
        <%
            }
        %>
    </body>
</html>
