/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.ClassBlackJack;

import java.util.Collections;

/**
 *
 * @author guest1Day
 */
class gameMaster {

    //true＝はい　false=いいえ　に置換する用メソッド
    public static String TorF(boolean a) {
        String bool = String.valueOf(a);
        String True = bool.replace("true", "はい");
        String TorF = True.replace("false", "いいえ");
        return TorF;
    }

    //ゲームを進行
    public static void main(String[] args) {
        
        System.out.println("＞BlackJackをはじめます。");
        System.out.println("＞プレイヤー：わたし");
        User me = new User();//Userのわたしを召喚
        System.out.println("＞ディーラー：バニーちゃん");
        Dealer bunny = new Dealer();//Dealerのバニーちゃんを召喚
        System.out.println("*********************************************");

        //初手の2枚をdeal
        System.out.println("＞DEALします。");
        System.out.println("・・・");

        //わたしにdeal
        System.out.println("＞わたし");
        me.setCard(bunny.deal());
        System.out.println(me.myCards);
        System.out.println("手札合計値：" + me.open());
        System.out.println("＞HITする？＞" + TorF(me.checkSum()));//myCardsが21未満ならhitする
        System.out.println("・・・");

        //バニーちゃんにdeal
        System.out.println("＞バニーちゃん");
        bunny.setCard(bunny.deal());
        System.out.println(bunny.myCards);
        System.out.println("手札合計値：" + bunny.open());
        System.out.println("＞HITできる？＞" + TorF(bunny.checkSum()));//myCardsが17未満ならhitする

        System.out.println("*********************************************");

        //おれのターン
        while (me.checkSum() == true) {//myCardsが21未満ならhitしつづける
            System.out.println("＞わたしがHITしました。");
            me.setCard(bunny.hit());
            System.out.println(me.myCards);
            System.out.println("手札合計値：" + me.open());
            System.out.println("＞まだHITする？＞" + TorF(me.checkSum()));
            System.out.println("*********************************************");

            if (me.open() > 21) {//myCardsが22以上になったらBUST・決着
                System.out.println("＞わたしがBUSTしました。");
                System.out.println("＞バニーちゃんのかち！");
            }
        }

        //バニーちゃんのターン
        if (me.open() <= 21) {//わたしがBUSTしていない時だけバニーちゃんのターンは訪れる
            while (bunny.checkSum() == true) {//myCardsが17未満ならhitしつづける
                System.out.println("＞バニーちゃんがHITしました。");
                bunny.setCard(bunny.hit());
                System.out.println(bunny.myCards);
                System.out.println("手札合計値：" + bunny.open());
                System.out.println("＞まだHITできる？＞" + TorF(bunny.checkSum()));
                System.out.println("*********************************************");

                if (bunny.open() > 21) {//myCardsが22以上になったらBUST・決着
                    System.out.println("＞バニーちゃんがBUSTしました。");
                    System.out.println("＞わたしのかち！");
                }
            }
        }

        //両者ともBUSTしなかった場合の判定
        if (me.open() <= 21 && bunny.open() <= 21) {
            if (bunny.open() == me.open()) {
                System.out.println("。。。PUSHです。。。");
            } else if (bunny.open() > me.open()) {
                System.out.println("＞バニーちゃんのかち！");
            } else if (bunny.open() < me.open()) {
                System.out.println("＞わたしのかち！");
            }
        }

        //最終結果表示
        System.out.println("*********************************************");
        System.out.println("最終結果");
        System.out.println("バニーちゃん：" + bunny.open() + "点　　" + "わたし：" + me.open() + "点");
    }
}
