 package com.crm.GenricLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This file will read date from property file and return to user
 * @author ADMIN
 *
 */
public class PropertyfileUtiljava 
{
	/**
	 * This method will read the data from property file for the key given by user
	 * @param key
	 * @return
	 * @throws Throwable
	 */
   public String readfrompropertyfile(String key) throws Throwable
   {
	   FileInputStream fis = new FileInputStream(IpathofContrants.PropertyFile);
       Properties Plib = new Properties();
       Plib.load(fis);
       String value = Plib.getProperty(key);
       return value;
   }
}
