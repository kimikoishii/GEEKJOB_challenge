<%-- 
    Document   : 05_02_02
    Created on : 2017/12/04, 15:50:40
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

char moji = 'A';
        
switch(moji) {

//mojiが'A'の場合の処理
case 'A':
out.print("英語");
break;

//mojiが'あ'の場合の処理
case 'あ':
out.print("日本語");
break;

//mojiがその他の場合は何も表示しない処理
default:
 
break;

}

%>
    </body>
</html>
