package com.srm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.Test;

public class PropertyFilePractice {
	//******read data from property file*****/
	@Test
		public void propertyfile() throws IOException
		{
          // step:1 read the file
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonDataproperties");
			
			// step:2 create Obj f properties
			Properties pobj = new Properties();
			pobj.load(fis);
			
			// step:3
			String URL = pobj.getProperty("username");
			
			//step:4 verification
			System.out.println(URL);
	    }

}

