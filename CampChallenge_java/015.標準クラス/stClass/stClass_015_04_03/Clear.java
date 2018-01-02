/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.stClass.stClass_015_04_03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author kmk
 */
//ログファイルの中身をnullにするクラス
public class Clear {

    public static void main(String[] args) throws IOException {

        //クリアするファイル
        File log = new File("log.txt");
        FileWriter logfw = new FileWriter(log); 
            logfw.write("");//nullを上書きする
        //クローズ
        logfw.close();
    }
    }


