/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.stClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class stClass_015_02_03 {

    //2016年11月4日 10時0分0秒のタイムスタンプを作成し、「年-月-日 時:分:秒」で表示してください。
    public static void main(String[] args) {
        Date d = new Date("2016/11/4 10:0:0");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-M月-d日 H時:m分:s秒");
        System.out.println(sdf.format(d));

    }
}
