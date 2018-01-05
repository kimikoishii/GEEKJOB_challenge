<%-- 
    Document   : a
    Created on : 2018/01/05, 14:09:23
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
// 受け取るパラメータの文字コード
        request.setCharacterEncoding("UTF-8");
//総額
        String To = request.getParameter("total");
        int total = Integer.parseInt(To);
//種類
        String Ty = request.getParameter("type");
        int type = Integer.parseInt(Ty);
//個数
        String Co = request.getParameter("count");
        int count = Integer.parseInt(Co);

    %>
    <body>
        <%            out.print("買ったものは");
            switch (type) {
                case 1:
                    out.print("雑貨");
                    break;
                case 2:
                    out.print("生鮮食品");
                    break;
                case 3:
                    out.print("その他");
                    break;
            }
            out.print("<br>");
            out.print("総額は" + total + "円");
            out.print("<br>");
            out.print("個数は" + count);
            out.print("<br>");
            out.print("単価は" + total / count);
            out.print("<br>");
            if (total >= 5000) {
                out.print("5000以上買ったので、" + total * 0.5 + "ポイント付加！");
            } else if (total >= 3000) {
                out.print("3000以上買ったので、" + total * 0.4 + "ポイント付加！");
            }

        %>
    </body>
</html>
