/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.stClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author kmk
 */

//ファイルから自己紹介を読み出し、表示してください。
public class stClass_015_04_02 {

    public static void main(String[] args) throws IOException {

        //自己紹介のFileReader作成
        FileReader fr = new FileReader("prof.txt");
        //BufferedReader作成
        BufferedReader br = new BufferedReader(fr);
        //自己紹介読み出し
        System.out.println(br.readLine());
        //クローズ
        br.close();

    }
}
