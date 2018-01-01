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

//2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）を表示してください。
public class stClass_015_02_04 {
    public static void main(String[] args) {
    Date a = new Date("2015/1/1 0:0:0");
    Date b = new Date("2015/12/31 23:59:59");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日H時m分s秒");
    System.out.println(sdf.format(a));
    System.out.println(sdf.format(b));
    System.out.print("の差分は「");
    System.out.print(b.getTime() - a.getTime());
    System.out.print("ミリ秒」です。");
    }   
}
