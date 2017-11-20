<%-- 
    Document   : 02_01
    Created on : 2017/11/20, 13:40:56
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
int thisyear = 2017;
int birth = 1991;
int age1 = thisyear - birth;

String hellow = "こんにちは！";
String name = "石井喜美子";
String age2 = "歳";
String desu = "です。";
String yoro = "よろしく";

out.print(hellow);
out.print(name);
out.print(desu);
out.print(age1);
out.print(age2);
out.print(desu);
out.print("<br>");
out.print(yoro);
out.print(desu);

%>
    </body>
</html>
