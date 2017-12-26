/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.Class;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author guest1Day
 */
public class BlackJack extends HttpServlet {

    
    //抽象クラスHuman
    abstract class Human{
    
        abstract protected void open();
        abstract protected ArrayList<Integer> setCard(ArrayList setCard);
        abstract protected void checkSum();
        ArrayList<Integer> myCards = new ArrayList<Integer>();
        
    }

    //Dealerクラス
    class Dealer extends Human{

        ArrayList<Integer> myCards = new ArrayList<Integer>();
        
        protected void open() {    
        }
        protected ArrayList<Integer> setCard(ArrayList setCard) {
            return myCards;
        }
        protected void checkSum() {
            
        }
        
    //以下Dealer独自のメソッド
        
        //山札
        ArrayList<Integer> cards = new ArrayList<Integer>();
             //山札の初期値
             //52枚のカードを持ち、シャッフルする
             public Dealer(){
             //52枚のカード
             int[] hearts = {1,2,3,4,5,6,7,8,9,10,11,12,13};
             int[] spades = {1,2,3,4,5,6,7,8,9,10,11,12,13};
             int[] clubs = {1,2,3,4,5,6,7,8,9,10,11,12,13};
             int[] diamonds = {1,2,3,4,5,6,7,8,9,10,11,12,13};
             ArrayList<Integer>allCards = new ArrayList<Integer>();
        
             for(int H:hearts){
             allCards.add(H);
             }
             for(int S:spades){
             allCards.add(S);
             }
             for(int C:clubs){
             allCards.add(C);
             }
             for(int D:diamonds){
             allCards.add(D);
             }
        
             //カードをシャッフル
             Collections.shuffle(allCards);
             //シャッフルした52枚のカードをcardsに格納
             cards = allCards;
             }
        
        //山札から2枚くばる
        public ArrayList<Integer> deal(){
        ArrayList<Integer> dealCards = new ArrayList<Integer>();
        dealCards.add(cards.get(0));
        dealCards.add(cards.get(1));
        return dealCards;
        }
        
        //山札から1枚くばる
        public ArrayList<Integer> hit(){
        ArrayList<Integer> hitCards = new ArrayList<Integer>();
        hitCards.add(cards.get(0));
        return hitCards;
        }
        
    }
    
    //Userクラス
    class User extends Human{

        protected void open() {
        }
        protected ArrayList<Integer> setCard(ArrayList setCard) {
            return myCards;
        }
        protected void checkSum() {
        }
        ArrayList<Integer> myCards = new ArrayList<Integer>();
        
    }
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            

            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
