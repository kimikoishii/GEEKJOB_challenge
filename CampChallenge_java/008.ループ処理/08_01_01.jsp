<%-- 
    Document   : 08_01_01
    Created on : 2017/12/05, 13:44:51
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

 //カウント用変数
int count = 0;           

//変数i(初期値8)に8をかける
//カウントの値が20になるまで繰り返す
for (long i = 8; count <=20 ; i*=8) {
    
//カウント    
count = ++count;

//解の表示
out.print("<br>" + i + "<br>");
out.print(count-1 + "回目" + "<br>" );//カウント表示は初期表示分-1している

}

%>
    </body>
</html>
