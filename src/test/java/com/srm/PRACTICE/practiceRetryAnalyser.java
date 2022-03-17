package com.srm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class practiceRetryAnalyser 
{
	@Test(retryAnalyzer=com.crm.GenricLibrary.RetryAnalyserImplimzezntation.class)
  public void practiceRetry()
  {
	  System.out.println("this is test 1");
	  Assert.fail();
	  System.out.println("this is passed");
  }
}
