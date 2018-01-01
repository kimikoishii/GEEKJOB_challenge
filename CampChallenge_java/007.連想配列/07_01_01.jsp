<%-- 
    Document   : 07_01_01
    Created on : 2017/12/05, 12:16:36
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
<%@ page import="java.util.HashMap" %>    
<%@ page import="java.util.ArrayList" %>

<%
//Mapの作成
HashMap<String, String> map =
            new HashMap<String, String>();

//要素の作成
map.put("1", "AAA");
map.put("hello", "world");
map.put("soeda", "33");
map.put("20", "20");

//MapをArrayListで包括
ArrayList<HashMap> data = new ArrayList<HashMap>();
data.add(map);

//要素をまとめて表示
out.print("連想配列<br>" + data.get(0));

%>

    </body>
</html>
