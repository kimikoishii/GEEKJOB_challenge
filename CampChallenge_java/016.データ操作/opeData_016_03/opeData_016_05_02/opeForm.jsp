<%-- 
    Document   : opeForm
    Created on : 2018/01/08, 23:17:32
    Author     : kmk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%

            HttpSession You = request.getSession(false);
            String checkName = String.valueOf(You.getAttribute("YourName"));
            String checkMorF = String.valueOf(You.getAttribute("YourMorF"));
            String checkHobby = String.valueOf(You.getAttribute("YourHobby"));
            
        %>
        <form action="/servlet_challenge/opeAdd" method="post">

            お名前：
            <input type="text" name="userName" value="<%= checkName%>">
            <br>
            <label>
                性別：
                男性<input type="radio" name="morf"  value="male" 
                         <%=checkMorF.equals("male") ? "checked" : ""%>
                         <%=checkMorF.equals("null") ? "checked" : ""%>>
                女性<input type="radio" name="morf"  value="female" 
                         <%=checkMorF.equals("female") ? "checked" : ""%>>
            </label>
            <br>
            趣味：
            <input  type="text" name="hobby" value="<%= checkHobby%>">
            <br>
            <input type="submit" name="btnSubmit">
        </form>
    </body>
</html>
