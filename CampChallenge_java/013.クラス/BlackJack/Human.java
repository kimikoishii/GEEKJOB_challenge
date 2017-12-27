package org.camp.servlet.Class.BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//抽象クラスHuman
abstract class Human {

    abstract protected Integer open();

    abstract protected void setCard(ArrayList<Integer> set);

    abstract protected Boolean checkSum();
    ArrayList<Integer> myCards = new ArrayList<>();

}






        
        