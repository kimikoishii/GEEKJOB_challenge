<%-- 
    Document   : logout
    Created on : 2018/01/15, 16:22:14
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログアウト</title>

        <%
            HttpSession You = request.getSession();
            You.invalidate();
        %>
    </head>
    <body>
        ログアウトしました。<br>
        <form action="login.jsp" maethod="post"><br>
            <input type = "submit" value ="ログイン画面へ">
        </form>
    </body>
</html>
