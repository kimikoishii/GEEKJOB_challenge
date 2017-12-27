/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.Class.BlackJack;

import java.util.Collections;

/**
 *
 * @author guest1Day
 */
class Game {

    public static void main(String[] args) {
        Dealer bunny = new Dealer();//
        User me = new User();

        //山札
        System.out.println("山札があります。");
        System.out.println(bunny.cards);
        
        //カードをシャッフル
        System.out.println("山札をシャッフルします。");
        Collections.shuffle(bunny.cards);
        System.out.println(bunny.cards);//カード総数
        
        System.out.println("*********************************************");

        //deal
        
        System.out.println("バニーちゃんにdealします。");
        bunny.setCard(bunny.deal());
        System.out.println(bunny.myCards + "手札枚数：" + bunny.myCards.size() + "枚");

        System.out.println("わたしにdealします。");
        me.setCard(bunny.deal());
        System.out.println(me.myCards + "手札枚数：" + me.myCards.size() + "枚");

        System.out.println("＞わたし");
        System.out.println("手札合計値：" + me.open());
        System.out.println("hitする？＞" + me.checkSum());

        System.out.println("＞バニーちゃん");
        System.out.println("手札合計値：" + bunny.open());
        System.out.println("hitする？＞" + bunny.checkSum());

        System.out.println("*********************************************");
        
        //おれのターン
        
        while (me.checkSum() == true) {
            System.out.println("＞わたしにhit");
            me.setCard(bunny.hit());
            System.out.println(me.myCards + "手札枚数：" + me.myCards.size() + "枚");
            System.out.println("＞わたし");
            System.out.println("手札合計値：" + me.open());
            System.out.println("hitする？＞" + me.checkSum());
            System.out.println("*********************************************");
            if(me.open() > 21){
            System.out.println("バニーちゃんのかち！");
            break;
            }
        }//バニーちゃんのターン
        if(me.open() <= 21){
        while (bunny.checkSum() == true) {
            System.out.println("＞バニーちゃんにhit");
            bunny.setCard(bunny.hit());
            System.out.println(bunny.myCards + "手札枚数：" + bunny.myCards.size() + "枚");
            System.out.println("＞バニーちゃん");
            System.out.println("手札合計値：" + bunny.open());
            System.out.println("hitする？＞" + bunny.checkSum());
            System.out.println("*********************************************");
            
            if(bunny.open() > 21){
            System.out.println("わたしのかち！");
            break;
            }
        }
        }

        //バーストしなかった場合の判定
        if(me.open() <= 21 && bunny.open() <= 21){
        if (bunny.open() == me.open()) {
            System.out.println("ひきわけ");
        } else if (bunny.open() > me.open()) {
            System.out.println("バニーちゃんのかち！");
        } else if (bunny.open() < me.open()) {    System.out.println("わたしのかち！");
        }
        }

        //最終結果表示
        System.out.println("最終結果");
        System.out.println("バニーちゃん：" + bunny.open() + "点　　" + "わたし：" + me.open() + "点");
    }
}


