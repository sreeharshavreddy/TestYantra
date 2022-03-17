package com.crm.ProductsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.ContactTests.CreateContactwithMadetoryField;
import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelfileUtility;
import com.crm.GenricLibrary.JavaUtilityjava;
import com.crm.GenricLibrary.PropertyfileUtiljava;
import com.crm.GenricLibrary.WebdriverUtility;
import com.crm.ObjectRepositorty.ContactInfoPage;
import com.crm.ObjectRepositorty.CreateNewProduct;
import com.crm.ObjectRepositorty.CreatecampaignsInfoPage;
import com.crm.ObjectRepositorty.Createnewcompaigns;
import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.ProductInfoPage;
import com.crm.ObjectRepositorty.ProductPage;
import com.crm.ObjectRepositorty.compaignspage;

public class CompaineTest extends BaseClass
{
@Test
  public void CompaineScriptTest() throws Throwable
  {
		PropertyfileUtiljava pLib=new PropertyfileUtiljava();
		ExcelfileUtility eLib=new ExcelfileUtility();
		JavaUtilityjava jLib=new JavaUtilityjava();
		WebdriverUtility wLib=new WebdriverUtility();
       String productname = eLib.readthedatafroExcel("Products", 1,1 )+" "+jLib.getRandomNumber();
       String Compaignename = eLib.readthedatafroExcel("Products", 1, 2)+" "+jLib.getRandomNumber();
		
	   //click on Products
       HomePage hp=new HomePage(driver);
       hp.clickOnProductLnk();
       // click on new Lookup Img
       ProductPage pg=new ProductPage(driver);
       pg.createnewproducImg();
	  // create new productname
       CreateNewProduct cnp=new CreateNewProduct(driver);
       cnp.productnametext(driver, productname);
	   //verification
       ProductInfoPage pip=new ProductInfoPage(driver);
       String actHeader = pip.ProductInfo();
		if (actHeader.contains(productname)) {
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
	   // navigate to compaigne
	  hp.ClickOncampaignsLnk();
	   compaignspage cp=new compaignspage(driver);
	   cp.createnewcampaignimg();
	  // select campaignname
	   Createnewcompaigns cnc=new Createnewcompaigns();
	   cnc.getCreateproductImg().click();
	   //select product name
	   Createnewcompaigns cnc1=new Createnewcompaigns();
	   cnc1.selectproductnameImg();
	   wLib.swithtowindowHandles(driver, "Products");
	   wLib.swithtowindowHandles(driver, "Campaigns");
	   CreatecampaignsInfoPage cIp=new CreatecampaignsInfoPage(driver);
	   String actHeader1 = cIp.campaignInfo();
		if (actHeader1.contains(Compaignename))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
  }
}
