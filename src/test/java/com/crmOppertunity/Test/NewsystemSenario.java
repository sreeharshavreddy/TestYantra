package com.crmOppertunity.Test;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelfileUtility;
import com.crm.GenricLibrary.JavaUtilityjava;
import com.crm.GenricLibrary.PropertyfileUtiljava;
import com.crm.GenricLibrary.WebdriverUtility;


public class NewsystemSenario extends BaseClass
{
	@Test
	public void SystemTC() throws Throwable
	{
		

		String ContactName = eLib.readthedatafroExcel("Opportunity" , 1, 6);
		String CampainName = eLib.readthedatafroExcel("Opportunity", 1,7);
		String  OppName= eLib.readthedatafroExcel("Opportunity", 1, 0);
		String  LastName= eLib.readthedatafroExcel("Opportunity", 1,5);
		String  Expectedclosedate= eLib.readthedatafroExcel("Opportunity", 1,3);

		//Create contact on contacts
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		String count = null;
		driver.findElement(By.name("lastname")).sendKeys(ContactName);
		driver.findElement(By.name("button")).click();

		//Create campaine 
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(CampainName);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();

		// Create Opprtunity
		driver.findElement(By.xpath("//a[.='Opportunities']")).click();
		//Create new opportunity
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//create a Opportunity with mandatory fields
		driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(OppName);

		//handling dropdown
		WebElement Drop = driver.findElement(By.xpath("//select[@id='related_to_type']"));
		wLib.select(Drop, "Contacts");
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		// handle dropdown
		wLib.swithtowindowHandles(driver, "Accounts");

		driver.findElement(By.id("search_txt")).sendKeys(LastName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[@id='1']")).click();
		// shift to parant
		wLib.swithtowindowHandles(driver, "Potential");
		//radio button select user
		// driver.findElement(By.xpath("//input[@type='radio']")).click();
		// chose emplaye from lead source dropdwn
		WebElement drop4 = driver.findElement(By.name("leadsource"));
		wLib.select(drop4, "Employee");
	 	//sales stage
		WebElement drop1 = driver.findElement(By.name("sales_stage"));
		wLib.select(drop1, "Prospecting");
		//date text field
		driver.findElement(By.name("closingdate")).sendKeys(Expectedclosedate);
		// click on sav
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		

	
	}
}
