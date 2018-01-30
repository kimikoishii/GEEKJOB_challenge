<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    //☆個人情報リストをリクエストディスパッチャから受け取る
    ArrayList<UserDataDTO> uddList = (ArrayList<UserDataDTO>) request.getAttribute("resultData");
    //セッションを取得
    HttpSession hs = request.getSession();
    //セッションに☆個人情報リストを保存
    hs.setAttribute("resultData", uddList);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <!-- ☆個人情報リストを全て展開して一覧にする-->
            <%for (int i = 0; i <= uddList.size() - 1; i++) {
                    UserDataDTO udd = uddList.get(i);%>
            <!-- クエリストリングを利用して、指定したuserIDの個人ページにリンク-->
            <td><a href="ResultDetail?id=<%= udd.getUserID()%>"><%= udd.getName()%></a></td>
            <td><%= udd.getBirthday()%></td>
            <td><%= jh.exTypenum(udd.getType())%></td>
            <td><%= udd.getNewDate()%></td>
            <tr>
                <% }%>
            </tr>

        </table>
    </body>
    <%=jh.home()%>
</html>
