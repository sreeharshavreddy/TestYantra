 package com.crm.GenricLibrary;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of Generic methods wrt java
 * @author ADMIN
 *
 */
public class JavaUtilityjava
{
	/**
	 * This Methods will generate a random and return to user
	 * @return
	 */
       public int getRandomNumber()
       {
    	   Random ran = new Random();
    	   int random = ran.nextInt(500);
    	   return random;
       }
       /**
        * This method will generate current system system date and return it to user
        * @return
        */
       public String Systemdate()
       {
    	    Date dat = new Date();
    	    String date = dat.toString();
    	    return date;
       }
       public String getsystemdateInFormate()
       {
    	   Date date = new Date();
    	   String d1 = date.toString();
    	   String[] dat = d1.split(" ");
    	   
    	    String mon = dat[1];
    	    String day = dat[2];
    	    String time= dat[3].replace(":","-");
    	    String year = dat[5];
    	    
    	    String DateFormate = day+"-"+mon+"-"+year+"-"+time;
    	    return DateFormate;
    	    
       }
}
