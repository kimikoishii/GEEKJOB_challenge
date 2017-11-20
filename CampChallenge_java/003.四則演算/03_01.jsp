<%-- 
    Document   : 02_02
    Created on : 2017/11/20, 14:53:32
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
        <%

final int BASE = 777;
int num = 777;

// 足し算
int tasu = BASE + num;

// 引き算
int hiku = BASE - num;

// 掛け算
int kake = BASE * num;

// 割り算
int wari = BASE / num;

// 剰余算
int amari = BASE % num;

out.print(tasu);
out.print(hiku);
out.print(kake);
out.print(wari);
out.print(amari);

%>
    </body>
</html>
