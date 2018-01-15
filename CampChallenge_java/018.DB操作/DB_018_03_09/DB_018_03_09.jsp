<%-- 
    Document   : DB_018_03_09
    Created on : 2018/01/11, 19:06:10
    Author     : guest1Day
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String today = sdf.format(now);

        %>
    </head>
    <body>

        <form action="/servlet_challenge/DB_018_03_09" method="post">

            ユーザー情報を入力してください。
            <br>
            <label>名前
                <br>
                <input type="text" name="userName" value="" required></label>
            <br>
            <label>電話番号
                <br>
                <input type="number" name="tell1" min ="1" value="" 
                       style="width:50px;" required>-
                <input type="number" name="tell2" min ="1" value="" 
                       style="width:50px;" required>-
                <input type="number" name="tell3" min ="1" value="" 
                       style="width:50px;" required></label>
            <br>
            <label>年齢
                <br>
                <input type="number" name="age" min ="1" value="" 
                       style="width:50px;" required>歳</label>
            <br>
            <label>誕生日（西暦）
                <br>
                <input type="date" name="birthday" value="1989-01-01"  
                       min="1900-01-01" max="<%= today%>" required></label>
            <br>
            <label>部門
                <br>
                <select name="departmentID" required>
                    <option value="">-</option>
                    <option value="1">開発部</option>
                    <option value="2">営業部</option>
                    <option value="3">総務部</option>
                </select></label>
            <br>
            <label>駅
                <br>
                <select name="stationID" required>
                    <option value="">-</option>
                    <option value="1">九段下</option>
                    <option value="2">永田町</option>
                    <option value="3">渋谷</option>
                    <option value="4">神保町</option>
                    <option value="5">上井草</option>
                </select></label>
            <br>
            <input type="submit" name="btnSubmit">
        </form>
    </body>
</html>
