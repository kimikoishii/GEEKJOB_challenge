/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.stClass.stClass_015_04_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kmk
 */
//紹介していないJAVAの標準クラスを利用して、処理を作成してください。
//１つJAVAの標準クラスを選び、実際にロジックを作成してみてください。
//Collectionsクラス☆
//StringBuilderクラス☆
//
//「いつ、どこで、だれが、なにを」の単語をランダムで取得し、文章にするクラス
public class StoryMaker {

    //単語を格納するフィールド
    List<String> whenList = new ArrayList<String>();
    List<String> whereList = new ArrayList<String>();
    List<String> whoList = new ArrayList<String>();
    List<String> whatList = new ArrayList<String>();
    
    //文章を格納するフィールド
    StringBuilder wwww = new StringBuilder();

    //単語・いつ
    public String When() {
        String when = "昔むかし、紀元前、いつだったか、昨日、今日、翌日、時は世紀末、昨夜未明、1時間前、つい先日";
        //"、"を区切りに配列化
        String[] whensp = when.split("、");
        //配列をフィールドへ格納
        //Collectionsクラス☆
        Collections.addAll(whenList, whensp);
        //要素をシャッフル
        //Collectionsクラス☆
        Collections.shuffle(whenList);
        //要素をランダムで取り出して返却
        String whentip = whenList.get(0);
        return whentip;
    }

    //単語・どこで
    public String Where() {
        String where = "自宅、公園、駅、荒野、ストリート、GEEKJOBキャンプ、ステージ、空中、中野サンプラザ、浜辺";
        String[] wheresp = where.split("、");

        Collections.addAll(whereList, wheresp);
        Collections.shuffle(whereList);

        String wheretip = whereList.get(0);
        return wheretip;
    }

    //単語・だれが
    public String Who() {
        String who = "石井、ゴリラ、おじいちゃん、赤ちゃん、仙人、社長、犬、通行人、屈強なレスラー、ミュージシャン";
        String[] whosp = who.split("、");

        Collections.addAll(whoList, whosp);
        Collections.shuffle(whoList);

        String whotip = whoList.get(0);
        return whotip;
    }

    //単語・なにをした
    public String What() {
        String what = "眠りに就いた、反復横跳びをした、理不尽に耐えた、爆発した、祈りを捧げた、踊り狂った、気合いを入れた、輝いた、おしるこをぶちまけた、微笑んだ";
        String[] whatsp = what.split("、");

        Collections.addAll(whatList, whatsp);
        Collections.shuffle(whatList);

        String whattip = whatList.get(0);
        return whattip;
    }

    //単語を連結し、文章にする
    //StringBuilderクラス☆
    public StringBuilder Link() {
        wwww.append(When());//いつ
        wwww.append("、　");
        wwww.append(Where());//どこで
        wwww.append("　で　");
        wwww.append(Who());//だれが
        wwww.append("　が　");
        wwww.append(What());//なにをした
        wwww.append("。");

        return wwww;
    }
}
