package com.crm.OraganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.util.LazilyConcatenatedByteArray;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.DumperOptions.ScalarStyle;

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelfileUtility;
import com.crm.GenricLibrary.JavaUtilityjava;
import com.crm.GenricLibrary.ListenersImplementationClass;
import com.crm.GenricLibrary.PropertyfileUtiljava;
import com.crm.GenricLibrary.WebdriverUtility;
import com.crm.ObjectRepositorty.CreateOrganizationPage;
import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.LoginPage;
import com.crm.ObjectRepositorty.OrganigationInfoPage;
import com.crm.ObjectRepositorty.OrganizationPage;


@Listeners(com.crm.GenricLibrary.ListenersImplementationClass.class)
public class CreateOrgTest extends BaseClass
{ 
@Test(retryAnalyzer=com.crm.GenricLibrary.RetryAnalyserImplimzezntation.class,groups="smock")
   public void CreateorgTest() throws Throwable
   {
	   String OrgName = eLib.readthedatafroExcel("Org", 1, 2)+" "+jLib.getRandomNumber();
		/*Step 4: Navigate to Organizations Link*/
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		/*Step 5: click on create organization btn*/
		OrganizationPage og=new OrganizationPage(driver);
		og.clickonCreateOrgImg();
		
		
		/* step 6: enter mandatory fields and save*/
		 CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		 cop.createNewOrg(OrgName);
	
		
		/*Step 7: verification*/
		 OrganigationInfoPage OrgInfo=new OrganigationInfoPage(driver);
		 String act = OrgInfo.OrgInfo();
		 if(act.contains(OrgName))
		 {
			 System.out.println(act+"------>data verified");
		 }else{
			 System.out.println("data is invailed");
		 }
		 
   } }
		

