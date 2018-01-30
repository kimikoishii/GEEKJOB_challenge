<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    
    //★個人情報詳細をリクエストディスパッチャから受け取る
    //下記の入力フォーム初期値として使用
    UserDataDTO udd = (UserDataDTO) request.getAttribute("userDetail");
    //uddのBirthdayから年月日を分割
    String year = new SimpleDateFormat("yyyy").format(udd.getBirthday());
    String month = new SimpleDateFormat("MM").format(udd.getBirthday());
    String day = new SimpleDateFormat("dd").format(udd.getBirthday());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
        <form action="UpdateResult" method="POST">
            名前:
            <input type="text" name="name" value="<%= udd.getName()%>">
            <br><br>

            生年月日:　
            <select name="year">
                <option value="<%= year%>"><%= year%></option>
                <% for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>" ><%=i%></option>
                <% }%>
            </select>年
            <select name="month">
                <option value="<%= month%>"><%= month%></option>
                <% for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>" ><%=i%></option>
                <% }%>
            </select>月
            <select name="day">
                <option value="<%= day%>"><%= day%></option>
                <% for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            </select>日
            <br><br>

            種別:
            <br>
            <% for (int i = 1; i <= 3; i++) {%>
            <input type="radio" name="type" value="<%=i%>" <%if (i == udd.getType()) {
                    out.print("checked");
                }%>><%=jh.exTypenum(i)%><br>
            <% }%>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%= udd.getTell()%>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udd.getComment()%></textarea><br><br>

            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>
        <!-- クエリストリングを利用して、userIDをもとに「詳細画面」へ戻る-->
        <a href="ResultDetail?id=<%= udd.getUserID()%>">詳細画面へ戻る</a><br>
        <%=jh.home()%>
    </body>
</html>
