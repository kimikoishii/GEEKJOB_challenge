<%-- 
    Document   : DB_018_03_10
    Created on : 2018/01/12, 15:53:07
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

        
        <form action="/servlet_challenge/DB_018_03_10" method="post">

            指定したuserIDの情報を削除します。
            <br>
            <input type="number" name="userID" value="" style="width:50px;" required>
            <br>
            <input type="submit" name="btnSubmit">
        </form>
    </body>
</html>