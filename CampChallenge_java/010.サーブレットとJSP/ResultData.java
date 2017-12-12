
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class ResultData implements Serializable {

    //日付
    private Date d;
    //運勢
    private String luck;
    //要素番号（コメント用）
    private int i;

    public ResultData() {}

    //日付
    public Date getD() { return d; } 
    public void setD (Date d){ this.d = d; }
    //運勢
    public String getluck(){ return luck; }
    public void setluck(String luck){ this.luck = luck;}
    //要素番号（コメント用）
    public int getI() {return i; }
    public void setI(int i){ this.i = i;}
   

    
}
 
  
    
    
    
   
