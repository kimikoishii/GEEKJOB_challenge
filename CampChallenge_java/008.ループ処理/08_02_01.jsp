<%-- 
    Document   : 08_02_01
    Created on : 2017/12/06, 13:45:10
    Author     : guest1Day
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

//1000を2で割り続け、100未満になったら終了

int num = 1000; //割られる値
int waru = 2; //割る値
int count = 0; //ループ回数計算用    

out.print("解が100未満になったらループをやめます。<br><br>");

//numが100以上であればループがつづく
while(num >=100){

//計算式の表示
out.print(num + "÷" + waru + "=");

//割る
num /=waru;

//カウント+1する
count++;    

//解を表示
out.print(num +"<br>");
}

out.print("<br>おわり。" + count + "回ループしました。");

%>
    </body>
</html>
