/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.ClassBlackJack;

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
    public Integer open() {
        int total = 0;//合計値
        for (int i = 0; i < myCards.size(); i++) {//myCardsをすべて展開
            int all = myCards.get(i);
            total += all;//totalに手札の値を入れていく
        }
        return total;
    }

    //myCardsにdealとhitのArrayListをadd・ArrayList
    @Override
    public void setCard(ArrayList<Integer> set) {

        for (int i = 0; i < set.size(); i++) {//setCardsをすべて展開
            Integer tmp = set.get(i);
            myCards.add(tmp);//myCardsにsetで受けた値を入れていく
        }
    }

//myCardsを確認し、カードが必要か(true)、不要か(false)を返却・int
    @Override
    public Boolean checkSum() {

        int total = 0;//合計値
        for (int i = 0; i < myCards.size(); i++) {//myCardsをすべて展開
            total += myCards.get(i);//totalに手札の値を入れていく
        }
        if (total < 21) {//合計値が21未満ならtrue
            return true;
        } else {
            return false;
        }
    }

}
