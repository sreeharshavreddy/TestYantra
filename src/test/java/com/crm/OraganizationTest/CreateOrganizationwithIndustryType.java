package com.crm.OraganizationTest;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelfileUtility;
import com.crm.GenricLibrary.JavaUtilityjava;
import com.crm.GenricLibrary.PropertyfileUtiljava;
import com.crm.GenricLibrary.WebdriverUtility;
import com.crm.ObjectRepositorty.CreateOrganizationPage;
import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.LoginPage;
import com.crm.ObjectRepositorty.OrganizationPage;

public class CreateOrganizationwithIndustryType extends BaseClass
{     //******read data from property file and create organization ******/ 
    @Test(groups="smockSuite")
    public void createorganizationwithproperty() throws Throwable
    {
     String OrgName = eLib.readthedatafroExcel("Org", 1, 2)+"-"+jLib.getRandomNumber();
      // step:4 Navigate to organization link
       HomePage hm= new HomePage(driver);
       hm.clickOnOrgLnk();
    
      //Step 4: click on create Organization link
  		OrganizationPage op=new OrganizationPage(driver);
  		op.clickonCreateOrgImg();
  		
  		//Step 5:create org with mandatory fields
  		CreateOrganizationPage pg=new CreateOrganizationPage(driver);
  		pg.createNewOrg(OrgName, "Banking");
  		}
    }

