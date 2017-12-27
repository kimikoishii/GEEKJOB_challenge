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

import java.util.Date;
import java.text.SimpleDateFormat;

//現在の日時を「年-月-日 時:分:秒」で表示してください。
public class stClass_015_02_02 {
  public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-M月-d日 H時:m分:s秒");
        System.out.println(sdf.format(now));

    }
}  

