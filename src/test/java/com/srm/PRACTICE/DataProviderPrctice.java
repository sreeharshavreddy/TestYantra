package com.srm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPrctice 
{
	@Test(dataProvider="getData")
	public void Dataproviderpractice(String Name, String model, int qty)
	{
		System.out.println(Name+"-----"+model+"----"+qty);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[3][3];
		
		obj[0][0]="Mi";
		obj[0][1]="Pro Max";
		obj[0][2]=10;
		
		obj[1][0]="Apple";
		obj[1][1]="11 max";
		obj[1][2]=25;
		
		obj[2][0]="Vivo";
		obj[2][1]="8 pro";
		obj[2][2]=15;
		return obj;
	}
}
