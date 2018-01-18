<%@page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSトップ</title>
        <%
            HttpSession hs = request.getSession();

            //セッションがnullなら、初アクセスのしるしを付与
            //(insertconfirm.jspにて"アクセス済み"に上書き)
            if (hs.getAttribute("in") == null) {
                hs.setAttribute("in", "first");
            }
        %>
    </head>
    <body>
        <h1>ユーザー情報管理トップ</h1><br>
        <h3>ここでは、ユーザー情報管理システムとしてユーザー情報の登録や検索、
            付随して修正や削除を行うことができます</h3><br>
            <a href="insert">新規登録</a><br>
        <a href="" >検索(修正・削除)</a><br>
    </body>
</html>
