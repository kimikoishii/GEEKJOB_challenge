<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    //アクセス済みのしるしを付与
    //(insert.jspにてセッション代入を有効にする)
    hs.setAttribute("in", "pass");
    //リクエストスコープ
    UserDataBeans data = (UserDataBeans) request.getAttribute("userData");
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
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <!-- 4.insertconfirmにて、フォームの内容が未入力であっても通過してしまう場合がある。
        これを通過させないようにし、かつどの項目が不完全なのかをわかるようにしなさい -->
        <!-- 全項目入力済みの場合はこちらを表示-->
        <% if (data.getCheck().equals("yes")) {%>
        <h1>登録確認</h1>
        <%=JumsHelper.getInstance().form(name, birthday, type, tell, comment)%>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <!-- 未入力の項目がある場合はこちらを表示--> 
        <% } else {%>
        <h1>入力が不完全です</h1>
        <%=JumsHelper.getInstance().form(name, birthday, type, tell, comment)%>
        <% }%>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <!-- 1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい -->
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
