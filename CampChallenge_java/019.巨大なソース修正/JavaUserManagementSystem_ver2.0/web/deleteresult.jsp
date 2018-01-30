<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    //セッション取得
    HttpSession hs = request.getSession();

    //○クエリ用変数
    //▽フォームからの入力値が空でなければ、URLに代入する
    //SearchResult.javaにて取得済み
    String name = "";
    if (!hs.getAttribute("name").equals("")) {
        name = (String) hs.getAttribute("name");
    }
    String year = "";
    if (!hs.getAttribute("year").equals("")) {
        year = (String) hs.getAttribute("year");
    }
    String type = "";
    if (hs.getAttribute("type") != null) {
        type = (String) hs.getAttribute("type");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
        <h1>削除確認</h1>
        削除しました。<br><br>
    </body>
    <form method="GET">
        <!-- 検索結果画面へ戻るボタンを追加
        ▽フォームからの入力値が空でなければ、○クエリ用変数をURLに代入-->
        <a href="SearchResult?name=<%if (!name.equals("")) {%><%=name%><%}
           %>&year=<%if (!year.equals("")) {%><%=year%><%}
           %><%if (!type.equals("")) {
                   out.print("&type=");%><%=type%><%}%>">検索結果へ戻る</a><br>      
    </form>
    <%=jh.home()%>
    <!--セッションを破棄-->
    <%hs.invalidate();%>
</html>
