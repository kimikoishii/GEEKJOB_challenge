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
class Monster02 {
    
    //フィールド。モンスターのステータス内容。
    //パブリックな２つの変数
    public String name = "スライム";
    public int hp = 100;

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
class Makai02{
public static void main(String[] args){

//ももんじゃ
Monster02 momonja = new Monster02();
momonja.setStatus("ももんじゃ",300);
String goMomonja = momonja.getStatus();

//さまようよろい
Monster02 samayouyoroi = new Monster02();
samayouyoroi.setStatus("さまようよろい", 800);
String goSamayouyoroi = samayouyoroi.getStatus();
} 

}


//課題「クラスの作成」で作成したクラスを継承し、以下の機能を持つクラスを作成してください。
//２つの変数の中身をクリアするパブリックなメソッド

//Monsterクラスを継承
class Yusya02 extends Monster02{

//２つの変数の中身をクリアするパブリックなメソッド
public void battle(){

//変数hpをクリア
hp = 0;
//変数nameをクリア
name = null;

System.out.print(name + hp);
}

//Yusyaクラスを動かすメソッド
public static void main(String[] args){
Yusya tonnura = new Yusya();
tonnura.battle();
}

}