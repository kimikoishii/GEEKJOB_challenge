/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.Class.BlackJack;

import java.util.ArrayList;

/**
 *
 * @author guest1Day
 */

class User extends Human {

    //myCards・ArrayList
    ArrayList<Integer> myCards = new ArrayList<>();

    //myCardsの合計値を返却・int
    @Override
    protected Integer open() {
        int total = 0;//合計値
        for (int i = 0; i < myCards.size(); i++) {//myCardsをすべて展開
            int all = myCards.get(i);
            total += all;//totalに合計値を入れる
        }
        return total;
    }

    //myCardsにdealとhitのArrayListをadd・ArrayList
    @Override
    protected void setCard(ArrayList<Integer> set) {

        for (int i = 0; i < set.size(); i++) {//setCardsをすべて展開
            Integer tmp = set.get(i);
            myCards.add(tmp);//myCardsに入れる
        }
    }

//myCardsを確認し、カードが必要か(true)、不要か(false)を返却・int
    @Override
    protected Boolean checkSum() {

        int total = 0;//合計値
        for (int i = 0; i < myCards.size(); i++) {//myCardsをすべて展開
            int all = myCards.get(i);
            total += all;//totalに合計値を入れる
        }
        if (total < 21) {//totalが21未満？
            return true;//はい
        } else {
            return false;//いいえ
        }
    }

}