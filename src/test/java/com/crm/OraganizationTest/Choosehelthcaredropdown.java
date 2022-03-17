package com.crm.OraganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class Choosehelthcaredropdown extends BaseClass
{
	@Test(groups="RegressionSuite")
	public void ChooseHelthcareDropdown() throws Throwable{
		
		 String OrgName = eLib.readthedatafroExcel("Org", 1, 2)+"-"+jLib.getRandomNumber();
		  String IndType= eLib.readthedatafroExcel("Org", 4, 3);
		
		HomePage hm=new HomePage(driver);
		hm.clickOnOrgLnk();
		 // pg.createNewOrg("orgName");
		OrganizationPage og =new OrganizationPage(driver);
		og.clickonCreateOrgImg();
		CreateOrganizationPage op=new CreateOrganizationPage(driver);
	     op.createNewOrg(OrgName, IndType);
	         //verification
	     OrganigationInfoPage oip=new OrganigationInfoPage(driver);
	     String actHeader= oip.OrgInfo();
		if(actHeader.contains(OrgName))
	     {
	    	 System.out.println(actHeader +"------>Organasation created");
	     }else{
	    	 System.out.println("Organization not verifed");
	     }
	    
	}
}
