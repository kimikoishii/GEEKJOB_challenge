<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    
    //◇変更結果をリクエストディスパッチャから受け取る
    UserDataBeans udb = (UserDataBeans)request.getAttribute("updateData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        <!-- 変更結果の表示-->
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        以上の内容で登録しました。<br>       
    </body>
    <!-- クエリストリングを利用して、userIDをもとに「詳細画面」へ戻る-->
    <a href="ResultDetail?id=<%= udb.getUserID()%>">詳細画面へ戻る</a><br>
    <%=jh.home()%>
    </body>
</html>
