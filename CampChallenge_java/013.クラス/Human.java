package org.camp.servlet.ClassBlackJack;

import java.util.ArrayList;

//抽象クラスHuman
abstract class Human {

    ArrayList<Integer> myCards = new ArrayList<>();//手札

    abstract public Integer open();//myCardsの合計値を計算する

    abstract public void setCard(ArrayList<Integer> set);//dealかhitしたcardsを、myCardsに入れる

    abstract public Boolean checkSum();//myCardsの合計値によって、hitする・しないの判断をする

}
