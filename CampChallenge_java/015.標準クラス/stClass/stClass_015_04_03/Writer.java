/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.stClass.stClass_015_04_03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kmk
 */
//1. 処理の経過を書き込むログファイルを作成する。
//2. 処理の開始、終了のタイミングで、ログファイルに開始・終了の書き込みを行う。
//3. 書き込む内容は、「日時　状況（開始・終了）」の形式で書き込む。
//4. 最後に、ログファイルを読み込み、その内容を表示してください。
//
//ログファイルに情報を書き出すクラス（現在時刻、引数で受けた文章）
public class Writer {

    //ログファイル
    File log = new File("log.txt");

    //現在時間を書き出す（引数でコメントを添える）
    public File timeRec(String word) throws IOException {

        FileWriter timelogfw = new FileWriter(log, true);//追記
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        timelogfw.write(word + sdf.format(now));//引数で受けたコメント+時間
        timelogfw.write("\r\n");
        timelogfw.close();
        
        return log;
    }

    //引数で受けた文章を書き出す(nullなら改行)
    public File textRec(String word) throws IOException {

        //書き出し
        FileWriter textlogfw = new FileWriter(log, true);//追記
        textlogfw.write(word);
        textlogfw.write("\r\n");
        textlogfw.close();
        
        return log;
    }    
}
