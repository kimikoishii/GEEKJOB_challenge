/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

/**
 *入力情報を添削して、適切ならセッションに収めるJavaBeans。
 * @author guest1Day
 */
/*フォームから受け取ったデータ自体を格納できるJavaBeans(UserDataBeans.java)
を作成し、これを利用して表示や分岐などをさせなさい*/
public class UserDataBeans {

    private String name;
    private String birthday;
    private String year;
    private String month;
    private String day;
    private String tell;
    private String type;
    private String comment;

    /*4.insertconfirmにて、フォームの内容が未入力であっても通過してしまう場合がある。
    これを通過させないようにし、かつどの項目が不完全なのかをわかるようにしなさい*/
    //getCheckメソッドにて、全項目入力済みなら"yes"を返す
    private String check = "yes";
    //各getメソッドにて、引数が空文字なら"未入力"の文字を返す(文字色赤)
    private String error = "<font color=\"red\">-未入力-</font>";

    /*各getメソッド：
    引数が空文字なら"未入力"の文字を返す(文字色赤)
    かつ、checkに"no"を代入して未入力通過を防ぐ*/
    public String getName() {
        if (name.equals("")) {
            check = "no";
            return error;
        } else {
            return name;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        if (birthday.equals("--")) {
            check = "no";
            return error;
        } else {
            return birthday;
        }
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getYear() {
        if (year.equals("")) {
            check = "no";
            return error;
        } else {
            return year;
        }
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        if (month.equals("")) {
            check = "no";
            return error;
        } else {
            return month;
        }
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        if (day.equals("")) {
            check = "no";
            return error;
        } else {
            return day;
        }
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTell() {
        if (tell.equals("")) {
            check = "no";
            return error;
        } else {
            return tell;
        }
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getType() {
        if (type.equals("")) {
            check = "no";
            return error;
        } else {
            return type;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        if (comment.equals("")) {
            check = "no";
            return error;
        } else {
            return comment;
        }
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    /*↑まで各項目のget、setメソッド
    ↓はオプション*/
    
    //入力確認用
    //全項目が入力済みならyes
    //ひとつでも未入力ならnoを返す
    public String getCheck() {
        return check;
    }

    //未入力エラー表示後のセッションリセット用
    //各getメソッドにて、引数が空文字なら"未入力"の文字を返す(文字色赤)
    //↑引数内に上記が格納されていたら、空文字にして返す
    public String clear(String sent) {
        if (sent.equals("<font color=\"red\">-未入力-</font>")) {
            sent = "";
            return sent;
        } else {
            return sent;
        }
    }

    //nullチェック用
    //引数inがnullなら、引数outを返す
    public String checkNull(String in, String out) {
        if (in != null) {
            return in;
        }
        return out;
    }

}
