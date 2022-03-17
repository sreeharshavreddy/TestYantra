package com.srm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenricLibrary.JavaUtilityjava;
import com.crm.GenricLibrary.PropertyfileUtiljava;

public class PractiesforGenricUtils 
{
	@Test
   public void practiceforgenricutil() throws Throwable
   {
	   JavaUtilityjava jlib = new JavaUtilityjava();
	   int ran = jlib.getRandomNumber();
	   String dat = jlib.getsystemdateInFormate();
	     String date = jlib.Systemdate();
	     System.out.println(ran);
	     System.out.println(dat);
	     System.out.println(date);
	     
	     PropertyfileUtiljava plib = new PropertyfileUtiljava();
	     String browser = plib.readfrompropertyfile("browser");
	     System.out.println(browser);
   }
}