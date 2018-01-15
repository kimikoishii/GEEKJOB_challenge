<%-- 
    Document   : DB_018_03_08
    Created on : 2018/01/11, 18:49:57
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        
        <form action="/servlet_challenge/DB_018_03_08" method="post">

            名前で検索します。
            <br>
            <input type="text" name="userName" value="" required>
            <br>
            <label>年齢
                <br>
                <input type="number" name="age" min ="1" value="" 
                       style="width:50px;">歳</label>
            <input type="submit" name="btnSubmit">
        </form>
    </body>
</html>

