package com.srm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2
{
  @Test(dataProvider="getdata")
  public void sampletestdataprovider(String Name, String Movie)
  {
	  System.out.println(Name+"----"+Movie+"-----");
  }
  @DataProvider
  public Object[][] getdata()
  {
	  Object[][] obj = new Object[6][2];
	  
	  obj[0][0]="Yash";
	  obj[0][1]="KJF";
	  
	  obj[1][0]="Viji";
	  obj[1][1]="Slaga";
		
	  obj[2][0]="Darshan";
	  obj[2][1]="Yajamana";
	  
	  obj[3][0]="Ganesh";
	  obj[3][1]="cool";
	  
	  obj[4][0]="Sudeep";
	  obj[4][1]="VikranthRona";
	  
	  obj[5][0]="Punith";
	  obj[5][1]="Jeams";
	return obj;
	  
  }
}
