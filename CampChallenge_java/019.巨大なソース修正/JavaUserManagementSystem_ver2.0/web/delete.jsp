<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    
    //セッションから★個人情報詳細を取得
    //ResultDetail.javaにて格納済み
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO) hs.getAttribute("userDetail");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>削除確認</h1>
        以下の内容を削除します。よろしいですか？<br>
        ID:<%= udd.getUserID()%><br>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= jh.exTypenum(udd.getType())%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>

        <!-- 「いいえ」なら、クエリストリングを利用してResultDetail.javaに戻る-->
        <form action="ResultDetail?id=<%= udd.getUserID()%>" method="POST">
            <input type="submit" name="NO" value="いいえ"style="width:100px">
        </form>
        <!-- 「はい」なら、DeleteResultDetail.javaに進む-->
        <form action="DeleteResult" method="POST">
            <input type="submit" name="YES" value="はい"style="width:100px">
        </form><br>
        <%=jh.home()%>
    </form>
</body>
</html>
