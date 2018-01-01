<%-- 
    Document   : 05_02
    Created on : 2017/11/20, 17:02:38
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
   
int num = 3;
        
switch(num) {

//numが1の場合
case 1:
out.print("one");
break;

//numが2の場合
case 2:
out.print("two");
break;

//numがその他の場合
default:
out.print("想定外");  
break;
}
    %>
    </body>
</html>
