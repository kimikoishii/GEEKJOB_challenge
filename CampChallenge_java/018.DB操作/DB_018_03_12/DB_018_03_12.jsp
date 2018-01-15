<%-- 
    Document   : DB_018_03_12
    Created on : 2018/01/12, 19:15:08
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
        <form action="/servlet_challenge/DB_018_03_12" method="post">

            複合検索します。
            <br>
            <label>名前
                <br>
                <input type="text" name="userName" value=""></label>
            <br>
            <label>年齢
                <br>
                <input type="number" name="age" min ="1" value="" 
                       style="width:50px;">歳</label>
            <br>
            <label>誕生日（西暦）
                <br>
                <input type="date" name="birthday" value=""  
                       min="1900-01-01" max="<%= today%>"></label>
            <br>
            <input type="submit" name="btnSubmit">
        </form>
    </body>
</html>
