package com.crm.OraganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelfileUtility;
import com.crm.GenricLibrary.JavaUtilityjava;
import com.crm.GenricLibrary.PropertyfileUtiljava;
import com.crm.GenricLibrary.WebdriverUtility;
import com.crm.ObjectRepositorty.CreateOrganizationPage;
import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.LoginPage;
import com.crm.ObjectRepositorty.OrganigationInfoPage;
import com.crm.ObjectRepositorty.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class CreateOrgwithMultipleData extends BaseClass{
		
		
		
		@Test(dataProvider = "OrgtestData")
		
		public void createOrgWithMltipleData(String orgName, String indType) throws Throwable
		{
			
			
			String orgname = orgName+jLib.getRandomNumber();
				//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.clickOnOrgLnk();
			Reporter.log("navigated to org link",true);
			
			//create Org
			OrganizationPage op = new OrganizationPage(driver);
			op.clickonCreateOrgImg();
			Reporter.log("click on create org link",true);
			
			//create new org
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createNewOrg(orgname, indType);
			Reporter.log("create org with insustry type",true);
			
			//validate
			OrganigationInfoPage oip = new OrganigationInfoPage(driver);
			String actHeader = oip.OrgInfo();
			if (actHeader.contains(orgname)) {
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			Reporter.log("verification successful",true);		
			
			
		}
		
		@DataProvider(name = "OrgtestData")
		public Object[][] getData() throws Throwable
		{
			Object[][] data = eLib.readmultipleDataFromExcel("OrgMultipleData");
			return data;
		}
}

