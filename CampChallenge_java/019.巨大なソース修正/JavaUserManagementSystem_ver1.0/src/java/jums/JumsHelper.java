package jums;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラスです。定数なども保存されます
 *
 * @author hayashi-s
 */
public class JumsHelper {

    //トップへのリンクを定数として設定
    private final String homeURL = "index.jsp";

    public static JumsHelper getInstance() {
        return new JumsHelper();
    }

    //トップへのリンクを返却
    public String home() {
        return "<a href=\"" + homeURL + "\">トップへ戻る</a>";
    }

    //フォーム入力結果表示用
    public String form(String name,String birthday,String type,String tell,String comment) {
        String nameForm = "名前:" + name + "<br>";
        String birthdayForm = "生年月日:" + birthday + "<br>";
        String typeForm = "種別:" + type + "<br>";
        String tellForm = "電話番号:" + tell + "<br>";
        String commentForm = "自己紹介:" + comment + "<br>";
        String form = nameForm + birthdayForm + typeForm + tellForm + commentForm;
        return form;
    }

}
