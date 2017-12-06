<%-- 
    Document   : 08_01_03
    Created on : 2017/12/06, 13:03:30
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
    //0から100をすべて足す
    
    //合計値を表す変数total(初期値0)
    int total = 0;
    
    //カウント値を表す変数count(初期値0)
    //+1ずつカウント値を増やし、100になるまで繰り返す
    for(int count = 0; count <=100; count++){
        
        //足す前の合計値を表示
        out.print(total);
        
        //合計値に現在のカウント値を足す
        total = total + count;
        
        //カウント値と、足した後の合計値を表示
        out.print("+" + count + "=" + total + "<br>");
    }
        
%>     
        
    </body>
</html>
