<%-- 
    Document   : 010_01_01
    Created on : 2017/12/08, 13:28:14
    Author     : guest1Day
--%>

<%@page import="org.camp.servlet.ResultData" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    
     <!DOCTYPE html>
<html>
  <head>
  <%
    ResultData data = (ResultData)request.getAttribute("DATA");
  %>
  <meta http-equiv="contentType" content="text/html: charset=UTF-8">
  <title>JSP Page</title>
  </head>
  <body>
  <%
      //日付表示のフォーマット
      SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d");
      String datestr = format.format(data.getD());
      
      //運勢表示
      if(data != null){
      out.print("あなたの" + datestr + "の運勢は………<br><br>");
      out.print("<font size=10 color=red>" + data.getluck() + "です!</font><br><br>");
     
            
            //結果によってコメントを表示
            out.print("<br>" + "(*^^*)＜");
            //要素番号にコメントを割り振っています
            switch(data.getI()) {
            case 0:
                out.print("おめでとう！");//大吉
                break;
            case 1:
                out.print("まあまあおめでとう");//中吉
                break;
            case 2:
                out.print("ふつう");//吉
                break;
            case 3:
                out.print("ふつうよりちょっと下");//半吉
                break;
            case 4:
                out.print("ふつうの中の最下層");//末小吉
                break;
            case 5:
                out.print("残念");//凶
                break;
            case 6:
                out.print("けっこう残念");//小凶
                break;
            case 7:
                out.print("がんばろう");//半凶
                break;
            case 8:
                out.print("まだ下がいる！");//末凶
                break;
            case 9:
                out.print("ギリギリセーフ");//中凶
                break;
            case 10:
                out.print("逆におめでとう！");//大凶
                break;
            } 
           out.print("）");
            
      
    }
  
  %>
  </body>
</html>
