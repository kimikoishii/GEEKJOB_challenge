/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.ClassBlackJack;

/**
 *
 * @author guest1Day
 */
import java.util.ArrayList;
import java.util.Random;

class Dealer extends Human {

    //myCards・ArrayList
    ArrayList<Integer> myCards = new ArrayList<>();

    //myCardsの合計値を返却・int
    @Override
    public Integer open() {
        int total = 0;//合計値
        for (int i = 0; i < myCards.size(); i++) {//myCardsをすべて展開
            total += myCards.get(i);//totalに手札の値を入れていく
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

    //myCardsを確認し、カードが必要か(true)、不要か(false)を返却・boolean
    @Override
    public Boolean checkSum() {

        int total = 0;//合計値
        for (int i = 0; i < myCards.size(); i++) {//myCardsをすべて展開
            total += myCards.get(i);//totalに手札の値を入れていく
        }
        if (total < 17) {//合計値が17未満ならtrue
            return true;
        } else {
            return false;
        }
    }

    //以下Dealer独自のメソッド
    
    //デッキ
    ArrayList<Integer> cards = new ArrayList<>();

    //デッキの初期値
    public Dealer() {
        //52枚のカード
        int A = 1;
        int J = 10;
        int Q = 10;
        int K = 10;
        int[] hearts = {A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K};
        int[] spades = {A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K};
        int[] clubs = {A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K};
        int[] diamonds = {A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K};

        //52枚のカードをデッキに格納
        for (int H : hearts) {
            cards.add(H);
        }
        for (int S : spades) {
            cards.add(S);
        }
        for (int C : clubs) {
            cards.add(C);
        }
        for (int D : diamonds) {
            cards.add(D);
        }
    }

    //デッキから2枚くばる
    public ArrayList<Integer> deal() {
        ArrayList<Integer> dealCards = new ArrayList<>();
        //乱数生成
        Random rnd1 = new Random();
        int r1 = rnd1.nextInt(cards.size());//乱数1
        int r2 = rnd1.nextInt(cards.size());//乱数2
        //2枚引く
        dealCards.add(cards.get(r1));//1枚目ランダム取得
        cards.remove(r1);//取得したカードをデッキから削除
        dealCards.add(cards.get(r2));//2枚目以下おなじ
        cards.remove(r2);
        return dealCards;
    }

    //デッキから1枚くばる
    public ArrayList<Integer> hit() {
        ArrayList<Integer> hitCards = new ArrayList<>();
        //乱数生成
        Random rnd = new Random();
        int r = rnd.nextInt(cards.size());
        //1枚引く
        hitCards.add(cards.get(r));//1枚ランダム取得
        cards.remove(r);//取得したカードをデッキから削除
        return hitCards;
    }

}
