<%-- 
    Document   : DB_018_03_13
    Created on : 2018/01/15, 13:00:40
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            //セッション取得
            HttpSession You = request.getSession(false);
            String checkPass = String.valueOf(You.getAttribute("YourPass"));
        %>
    <body>
        <title>ログイン</title>    </head>

    <%//
        if (checkPass.equals("null")) {
    %>
    <form action="managerInfo.jsp" maethod="post">
        パスワードを入力してください。<br>
        <br>
        <input type = "password" name = "pass"> <br>
        <input type = "submit" value ="ログイン">
    </form>

    <%
    } else {
    %>
    ログイン中です。<br>
    <form action="managerInfo.jsp" maethod="post">
        <input type = "password" name = "pass" value="<%=checkPass%>"> <br>
        <input type = "submit" value ="管理画面">
    </form>

    <%
        }
    %>
</body>
</html>
