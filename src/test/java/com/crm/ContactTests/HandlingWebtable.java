package com.crm.ContactTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.createNewContact;

public class HandlingWebtable extends BaseClass
{
	@Test
     public void handlewebtableallcheckbox()
     {
    	 HomePage hm=new HomePage(driver);
    	 hm.clickOnConLnk();
    	   List<WebElement> checkbox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
    	  for (WebElement ele : checkbox) 
    	  {
			ele.click();  
		  }
     }
	@Test
	public void selectlastcheckbox()
	{
		HomePage hm=new HomePage(driver);
		hm.clickOnConLnk();
		List<WebElement> lastcheckbox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id']"));
				
		     
	}
}
