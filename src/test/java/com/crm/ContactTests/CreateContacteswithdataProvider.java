package com.crm.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.ExcelfileUtility;
import com.crm.GenricLibrary.JavaUtilityjava;
import com.crm.GenricLibrary.PropertyfileUtiljava;
import com.crm.GenricLibrary.WebdriverUtility;
import com.crm.ObjectRepositorty.ContactInfoPage;
import com.crm.ObjectRepositorty.Contactspage;
import com.crm.ObjectRepositorty.CreateOrganizationPage;
import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.LoginPage;
import com.crm.ObjectRepositorty.OrganigationInfoPage;
import com.crm.ObjectRepositorty.OrganizationPage;
import com.crm.ObjectRepositorty.createNewContact;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContacteswithdataProvider
{
	public class CreateOrgWithMultipleDataTest {

		//Create Obj for all utilities
		PropertyfileUtiljava pLib = new PropertyfileUtiljava();
		ExcelfileUtility eLib = new ExcelfileUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		JavaUtilityjava jLib = new JavaUtilityjava();

		@Test(dataProvider = "Contactes")
		public void createOrgWithMltipleData(String LastName) throws Throwable
		{


			//read data 
			String BROWSER = pLib.readfrompropertyfile("browser");
			String URL = pLib.readfrompropertyfile("url");
			String USERNAME = pLib.readfrompropertyfile("username");
			String PASSWORD = pLib.readfrompropertyfile("password");

			String Lastname = LastName+jLib.getRandomNumber();

			WebDriverManager.chromedriver().setup();
			WebDriverManager.firefoxdriver().setup();
			//launch the application
			WebDriver driver = null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("FIREFOX"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}

			wLib.maximizewindow(driver);
			wLib.waitforthePageLoad(driver);
			driver.get(URL);

			//login to application
			LoginPage lp = new LoginPage(driver);
			lp.LoginToApp(USERNAME, PASSWORD);
			Reporter.log("login successful",true);

			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.clickOnConLnk();
			Reporter.log("navigated to Contactes link",true);	

			// click on contactpage
			Contactspage cp=new Contactspage(driver);
			cp.clickOnCreateContactImg();
			Reporter.log("create new contactes page", true);

			//create new contcats
			createNewContact cnc=new createNewContact(driver);
			cnc.createNewContacts(LastName);
			Reporter.log("last name taken", true);

			//validate
			ContactInfoPage cip=new ContactInfoPage(driver);
			String actHeader = cip.ContactNameInfo();
			if (actHeader.contains(LastName)) {
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			Reporter.log("verification successful",true);		

			//logout
			hp.signOutOfApp(driver);

			driver.quit();
		}
		@DataProvider(name = "Contactes")
		public Object[][] getData() throws Throwable
		{
			Object[][] data = eLib.readmultipleDataFromExcel("ContactesData");
			return data;
		}
	}

}
















