<%-- 
    Document   : test
    Created on : 2018/01/05, 10:24:34
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
// 受け取るパラメータの文字コード
        request.setCharacterEncoding("UTF-8");
//名前
        String name = request.getParameter("txtName");
//性別　0なら男性、1なら女性
        String MorF = request.getParameter("rdoMorF");
//趣味
        String text = request.getParameter("mulText");
    %>
    <body>
        <%
            out.print("△▼自己紹介▽▲" + "<br>");
            out.print("わたしの名前は、" + name + "です。<br>");
            if (MorF.equals("0")) {
                out.print("性別は男性" + "です。<br>");
            } else {
                out.print("性別は女性" + "です。<br>");
            }
            out.print("趣味は、" + text + "です。<br>");
        %>
    </body>
</html>
