/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.stClass;

/**
 *
 * @author kmk
 */
import java.io.*;


// ファイルに自己紹介を書き出し、保存してください。
class stClass_015_04_01 {

    public static void main(String[] args) throws IOException {
        //ファイルオープン
        File prof = new File("prof.txt");
        // FileWriter作成
        FileWriter fw = new FileWriter(prof);
        //自己紹介書き出し        
        fw.write("石井喜美子です。");
        fw.write("生年月日は1991年2月27日です。");
        fw.write("生まれも育ちも埼玉県です。");
        //クローズ
        fw.close();

        //追記
        //ファイルオープン
        File addprof = new File("prof.txt");
        //追記用 FileWriter作成
        FileWriter addfw = new FileWriter(addprof,true);
        //追記書き出し
        addfw.write("猫を一匹飼ってます！");
        //クローズ
        addfw.close();


    }

}
