/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.Class;

/**
 *
 * @author guest1Day
 */

//以下の機能を持つクラスを作成してください。
//パブリックな２つの変数と、
//２つの変数に値を設定するパブリックなメソッドと、
//２つの変数の中身をprintするパブリックなメソッド


//モンスタークラス
public class Monster {
    
    //フィールド。モンスターのステータス内容。
    //パブリックな２つの変数
    public String name;
    public int hp;

    //モンスターのステータスを設定するメソッド
    //２つの変数に値を設定するパブリックなメソッド
    public void setStatus(String monName,int monHp){
        name = monName;
        hp = monHp;
    }

    //モンスターのステータスを表示するメソッド
    //２つの変数の中身をprintするパブリックなメソッド
    public String getStatus(){
     String oneMonster = "なまえ：" + name + "/" + "HP："+ hp + "    ";
     System.out.print(oneMonster);
     return oneMonster;
    }
    
    }
    

//モンスターをうみだすインスタンス
class Boss{

//ももんじゃ
public static void main(String[] args){
Monster momonja = new Monster();
momonja.setStatus("ももんじゃ",300);
String goMomonja = momonja.getStatus();

//さまようよろい
Monster samayouyoroi = new Monster();
samayouyoroi.setStatus("さまようよろい", 800);
String goSamayouyoroi = samayouyoroi.getStatus();
}

}