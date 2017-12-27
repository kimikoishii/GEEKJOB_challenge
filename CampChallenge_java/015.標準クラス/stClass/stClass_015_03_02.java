/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.stClass;

/**
 *
 * @author guest1Day
 */
//自分のメールアドレスの「@」以降の文字を取得して、表示してください。
public class stClass_015_03_02 {

    public static void main(String[] args) {

        String myAddress = "onnnkdisk170927@gmail.com";

        //@の位置数を取得
        int i = myAddress.indexOf("@");
        //@以降の文字を取得
        System.out.print(myAddress.substring(i));

    }

}
