/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet.stClass;

/**
 *
 * @author guest1Day
 */

//以下の文章の「I」⇒「い」に、「U」⇒「う」に入れ替える処理を作成し、結果を表示してください。
//「きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます」
public class stClass_015_03_03 {
    
    public static void main(String[] args) {

    String st =  "「きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます」";
    
    //"I"を"い"に置換
    String i = st.replace("I","い");
    //"U"を"う"に置換
    String iu = i.replace("U","う");
    
    //「きょうはぴいえいちぴいのくみこみかんすうのがくしゅうをしています」
    System.out.print(iu);

    }
    
}
