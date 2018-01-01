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

public class stClass_015_02_01 {

    //2016年1月1日 0時0分0秒のタイムスタンプを作成し、表示してください。
    public static void main(String[] args) {
        Date d = new Date("2016/1/1 0:0:0");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日H時m分s秒");
        System.out.println(sdf.format(d));

    }
}
