package com.crm.OraganizationTest;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelfileUtility;
import com.crm.GenricLibrary.JavaUtilityjava;
import com.crm.GenricLibrary.ListenersImplementationClass;
import com.crm.GenricLibrary.PropertyfileUtiljava;
import com.crm.GenricLibrary.WebdriverUtility;
import com.crm.ObjectRepositorty.CreateOrganizationPage;
import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.LoginPage;
import com.crm.ObjectRepositorty.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(ListenersImplementationClass.class)
public class CreateOrganizationTest extends BaseClass
{     
	//*******create organization - hard coding*******/
	@Test(groups="RegressionSuite") 
	public void createOraganizationTest() throws Throwable
	{
		String OrgName = eLib.readthedatafroExcel("Org", 1, 2)+"-"+jLib.getRandomNumber();
		// step:3 navigate to organization link
		HomePage hm=new HomePage(driver);
		hm.clickOnOrgLnk();
		String ExpData = "Organization";
	    String actData = driver.findElement(By.linkText("Organizations")).getText();
		 Assert.assertEquals(actData, ExpData);

		//step:4  click on create organization link
		OrganizationPage op=new OrganizationPage(driver);
		op.clickonCreateOrgImg();
		String ExpData1 = "Creating New Organization";
		WebElement actData1 = driver.findElement(By.xpath("Creating New Organization"));
		Assert.assertEquals(ExpData1, actData1);

		// step:5 create organization with mandatory fields
		CreateOrganizationPage pg=new CreateOrganizationPage(driver);
  		pg.createNewOrg(OrgName);
  		Thread.sleep(2000);
	}
}
