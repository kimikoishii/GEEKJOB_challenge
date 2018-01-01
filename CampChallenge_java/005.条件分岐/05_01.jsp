<%-- 
    Document   : 05_01
    Created on : 2017/11/20, 16:47:23
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

int num = 2;

if (num == 1) {
    out.print("１です！");
} else if (num == 2) {
    out.print("プログラミングキャンプ！");
} else {
    out.print("その他です！");
}
%>
    </body>
</html>
