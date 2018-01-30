<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();

    //セッションを取得
    HttpSession hs = request.getSession();

    //★個人情報詳細をリクエストディスパッチャから受け取る
    UserDataDTO udd = (UserDataDTO) request.getAttribute("resultDetail");

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
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        <!-- getUserIDにてID表示 -->
        ID:<%= udd.getUserID()%><br>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= jh.exTypenum(udd.getType())%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>
        <form action="Update" method="POST">
            <input type="submit" name="update" value="変更"style="width:100px">
        </form>
        <form action="Delete" method="POST">
            <input type="submit" name="delete" value="削除"style="width:100px">
        </form>
    </body>
    <form method="GET">
        <!-- 検索結果画面へ戻るボタンを追加
        ▽フォームからの入力値が空でなければ、○クエリ用変数をURLに代入-->
        <a href="SearchResult?name=<%if (!name.equals("")) {%><%=name%><%}
           %>&year=<%if (!year.equals("")) {%><%=year%><%}
           %><%if (!type.equals("")) {
                   out.print("&type=");%><%=type%><%}%>">検索結果へ戻る</a><br>
        <%=jh.home()%>
    </form>
</html>
