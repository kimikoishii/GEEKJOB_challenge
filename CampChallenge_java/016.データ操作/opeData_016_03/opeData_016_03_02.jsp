<%-- 
    Document   : opeData_016_03_02
    Created on : 2018/01/06, 0:31:17
    Author     : kmk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>簡易素因数分解！！！</title>
    </head>
    <%
        request.setCharacterEncoding("UTF-8");
        String number = request.getParameter("num");//入力値を受け取る
        //String→intに返還
        final int original = Integer.parseInt(number);//元の値（比較用）
        int n = Integer.parseInt(number);//元の値（因数分解用）
        int[] prime = {2, 3, 5, 7};//1桁素数一覧
    %>
    <body>
        <%//
            out.print("元の数値：" + original);
            out.print("<br>");

            //originalの値が0か1の場合
            //下記を表示して処理を終える
            if (original <= 1) {
                out.print("この値は因数分解できません。");
                return;
            }

            out.print("簡易素因数分解の結果：");

            //nをprimeで割ってみる
            for (int j : prime) {

                //originalの値がprimに含まれる場合
                //下記を表示して処理を終える
                if (original == j) {
                    out.print("これは素数です。");
                    return;
                }

                //nの値が2以上
                //かつ"prime[j]"で割り切れる場合は、
                //以下のループを続ける
                //違う場合は37行目に戻る
                while (n >= 2 && n % j == 0) {
                    n = n / j;//解をもとめる
                    out.print(j);//1桁素数表示

                    //nが"primeの最大値"以下の正数で割り切れる場合（nが非素数）
                    //下記を表示して50行目に戻る
                    for (int i = 2; i <= prime[prime.length - 1]; i++) {
                        if (n % i == 0) {
                            out.print("×");
                            break;

                            //nの値がprimeに含まれる場合（nが素数）
                            //下記を表示して50行目に戻る
                        } else if (n >= j && n <= prime[prime.length - 1]) {
                            out.print("×");
                            break;
                        }
                    }
                }
            }

            //originalの値をprimeで1回も割れなかった場合
            //下記を表示して処理を終える
            if (original == n) {
                out.print("これは素数か、");
                out.print("1桁素数で割れない非素数です。");
                return;
            }

            //nの値が2以上
            //かつ2桁以上の素数を含んでいる場合
            //下記を表示して処理を終える
            if (n >= 2) {
                out.print("<br>");
                out.print("余った値：" + n);
            }
        %>
    </body>
</html>
