/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.Class.BlackJack;

/**
 *
 * @author guest1Day
 */


import java.util.ArrayList;

class Dealer extends Human {

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
            myCards.add(tmp);
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
        if (total <= 17) {
            return true;
        } else {
            return false;
        }
    }

    //以下Dealer独自のメソッド
    //山札
    ArrayList<Integer> cards = new ArrayList<>();
    //山札の初期値

    public Dealer() {
        //52枚のカード
        int[] hearts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        int[] spades = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        int[] clubs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        int[] diamonds = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        ArrayList<Integer> allCards = new ArrayList<Integer>();

        for (int H : hearts) {
            allCards.add(H);
        }
        for (int S : spades) {
            allCards.add(S);
        }
        for (int C : clubs) {
            allCards.add(C);
        }
        for (int D : diamonds) {
            allCards.add(D);
        }

        //52枚のカードをcardsに格納
        cards = allCards;
    }

    //山札から2枚くばる
    public ArrayList<Integer> deal() {
        ArrayList<Integer> dealCards = new ArrayList<>();
        dealCards.add(cards.get(0));
        dealCards.add(cards.get(1));
        cards.remove(0);
        cards.remove(0);
        return dealCards;
    }

    //山札から1枚くばる
    public ArrayList<Integer> hit() {
        ArrayList<Integer> hitCards = new ArrayList<>();
        hitCards.add(cards.get(0));
        cards.remove(0);
        return hitCards;
    }

}
