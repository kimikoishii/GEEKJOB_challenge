<%-- 
    Document   : 06_01_01
    Created on : 2017/12/04, 16:35:49
    Author     : guest1Day
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>



<%@ page import="java.util.ArrayList" %>
<%
// 配列の作成
ArrayList<String> data = new ArrayList<String>();

// 要素の作成
data.add("10");
data.add("100");
data.add( "soeda");
data.add("hayashi");
data.add("-20");
data.add("118");
data.add("END");

// 要素の表示
out.print(data.get(0) + "<br>");
out.print(data.get(1) + "<br>");
out.print(data.get(2) + "<br>");
out.print(data.get(3) + "<br>");
out.print(data.get(4) + "<br>");
out.print(data.get(5) + "<br>");
out.print(data.get(6) + "<br>");

%>


    </body>
</html>
