/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.stClass.stClass_015_04_03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author kmk
 */
//4. 最後に、ログファイルを読み込み、その内容を表示してください。
//
//ログファイルの内容を全て読み出して、表示するクラス
public class Reader {

    //ログファイル
    File log = new File("log.txt");

    //ログファイルの内容を全て読み出して表示する
    public File reading() throws IOException {

        FileReader logfr = new FileReader("log.txt");
        BufferedReader logbr = new BufferedReader(logfr);
        //nullじゃなければ読み出しつづける
        String line = logbr.readLine();
        while (line != null) {
            System.out.println(line);
            line = logbr.readLine();
        }
        //クローズ
        logbr.close();

        return log;
    }
}
