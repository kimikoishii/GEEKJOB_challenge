<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = new UserDataBeans();
    
    /*insertconfirmからinsertへ再度入力する際に、このままではフォームに値が保持されていない。
    適切な処理を施して、再度入力の際にはフォームに値を保持したままにさせなさい*/

    //各項目の初期値
    String name = "";
    String year = "";
    String month = "";
    String day = "";
    String type = "";
    String tell = "";
    String comment = "";
    
/*各項目の初期値。セッションがnullならこれらを返す*/
    String checkName = "";
    String checkYear = "";
    String checkMonth = "";
    String checkDay = "";
    
    //typeのチェック用
    String check1 = "checked";
    String check2 = "";
    String check3 = "";
    
    String checkTell = "";
    String checkComment = "";

/*insertconfirm.jspにアクセス済みなら != null と判断。
各項目にセッションの値を代入する*/
    if (hs.getAttribute("in").equals("pass")) {
        name = (String) hs.getAttribute("name");
        year = (String) hs.getAttribute("year");
        month = (String) hs.getAttribute("month");
        day = (String) hs.getAttribute("day");
        type = (String) hs.getAttribute("type");
        //typeチェック用
        int typeCheck = Integer.parseInt(type);
        switch (typeCheck) {
            case 1:
                check1 = "checked";
                break;
            case 2:
                check2 = "checked";
                check1 = "";
                break;

            case 3:
                check3 = "checked";
                check1 = "";
                break;
        }
        tell = (String) hs.getAttribute("tell");
        comment = (String) hs.getAttribute("comment");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
        <form action="insertconfirm" method="POST">
            名前:
            <input type="text" name="name" value="<%=udb.clear(udb.checkNull(name, checkName))%>">
            <br><br>

            生年月日:
            <select name="year">
                <option value="<%=udb.clear(udb.checkNull(year, checkYear))%>" selected><%=udb.clear(udb.checkNull(year, checkYear))%></option>
                <% for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>"> <%=i%> </option>
                <% } %>
            </select>年
            <select name="month">
                <option value="<%=udb.clear(udb.checkNull(month, checkMonth))%>" selected><%=udb.clear(udb.checkNull(month, checkMonth))%></option>
                <% for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <option value="<%=udb.clear(udb.checkNull(month, checkMonth))%>" selected><%=udb.clear(udb.checkNull(day, checkDay))%></option>
                <%  for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            </select>日
            <br><br>

            種別:
            <br>
            <input type="radio" name="type" value="1" <%=check1%>>エンジニア<br>
            <input type="radio" name="type" value="2"<%=check2%>>営業<br>
            <input type="radio" name="type" value="3"<%=check3%>>その他<br>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%=udb.clear(udb.checkNull(tell, checkTell))%>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udb.clear(udb.checkNull(comment, checkComment))%></textarea><br><br>

            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>

        <!-- 1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい -->
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
