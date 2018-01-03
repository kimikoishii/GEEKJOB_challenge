/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.stClass.stClass_015_04_03;

import java.io.IOException;

/**
 *
 * @author kmk
 */
//紹介していないJAVAの標準クラスを利用して、処理を作成してください。
//１つJAVAの標準クラスを選び、実際にロジックを作成してみてください。
//
//1. 処理の経過を書き込むログファイルを作成する。
//2. 処理の開始、終了のタイミングで、ログファイルに開始・終了の書き込みを行う。
//3. 書き込む内容は、「日時　状況（開始・終了）」の形式で書き込む。
//4. 最後に、ログファイルを読み込み、その内容を表示してください。
//
//メインクラス
public class StoryTeller {

    public static void main(String[] args) throws IOException {

      //ログファイルに書き出す
        Writer me = new Writer();
        
        //開始時刻を記録する
        me.timeRec("処理を開始します。");

        //storyMakerでつくった文章をログに書き出す
        StoryMaker dazai = new StoryMaker();
        me.textRec(dazai.Link().toString());//つくった文章を引数で渡す

        //終了時刻を記録する
        me.timeRec("処理を終了します。");
        me.textRec("");

      //ログファイルを読み出す
        Reader reader = new Reader();
        reader.reading();

    }
}
