<%@page import="java.util.Date"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    //フォーム入力結果内容
    String name = (String) hs.getAttribute("name");
    String birthday = (String) hs.getAttribute("year") + "年"
            + (String) hs.getAttribute("month") + "月"
            + (String) hs.getAttribute("day") + "日";
    String type = (String) hs.getAttribute("type");
    String tell = (String) hs.getAttribute("tell");
    String comment = (String) hs.getAttribute("comment");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        <%=JumsHelper.getInstance().form(name, birthday, type, tell, comment)%>
        以上の内容で登録しました。<br>
    </body>
    <br>
    <!-- 1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい -->
    <%=JumsHelper.getInstance().home()%>
    <!-- 7.適切なタイミングでセッションがクリアになるようにしなさい -->
    <%hs.invalidate();%>
</html>
