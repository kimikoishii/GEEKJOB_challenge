/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.stClass;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author guest1Day
 */
//自分の氏名について、バイト数と文字数を取得して、表示してください。
public class stClass_015_03_01 {

    public static void main(String[] args) {

        String myName = "いしいきみこ";

        //文字数
        System.out.println(myName);
        System.out.print("の文字数は、");
        System.out.println(myName.length() + "文字です。");

        //バイト列
        System.out.println("バイト列にすると、");
        byte[] ishii = myName.getBytes(StandardCharsets.UTF_8);
        for (byte y : ishii) {
            System.out.print(y);
        }
        
        //バイト数
        System.out.println("となります。");
        System.out.print("バイト数は、");
        System.out.println(ishii.length + "個です。");
    }
}
