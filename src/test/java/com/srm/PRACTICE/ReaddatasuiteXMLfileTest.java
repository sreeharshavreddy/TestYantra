package com.srm.PRACTICE;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReaddatasuiteXMLfileTest 
{
  @Test
  public void ReadDataFromSuiteXMLFile(XmlTest xml)
  {
	 String BROWSER = xml.getParameter("browser");
	 String URL = xml.getParameter("url");
	 String USERNAME = xml.getParameter("usernme");
	  String PASSWORD = xml.getParameter("password");
	 
	 System.out.println(BROWSER);
	  System.out.println(URL);
  }
}
