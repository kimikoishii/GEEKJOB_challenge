<%-- 
    Document   : 08_01_02
    Created on : 2017/12/06, 10:44:26
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

//変数Aに文字Aを足す処理を、countが30以上になるまで繰り返す    

//変数A(文字A)を作成
String A = "A";

//変数count(初期値1)で回数をカウント。1回ごとに+1する
//countの値が30以上になるまで繰り返す
for(int count = 1; count <=30; count++){

//Aを表示
out.print(A);

//Aの数を表示
out.print("・" + count + "個" + "<br>");

//Aに文字Aを足す
A += "A";

}
%>        
    </body>
</html>
