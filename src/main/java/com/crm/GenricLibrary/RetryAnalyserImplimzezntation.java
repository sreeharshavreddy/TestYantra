package com.crm.GenricLibrary;

import java.awt.color.ICC_Profile;

import org.apache.poi.ss.formula.functions.Count;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplimzezntation implements IRetryAnalyzer
{
     int count=0;
     int retryCount =3;
	public boolean retry(ITestResult result) {
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
