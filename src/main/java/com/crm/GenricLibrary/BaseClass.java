
package com.crm.GenricLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	// create object for all utilities
	public ExcelfileUtility eLib=new ExcelfileUtility();
	public DataBaseUtility dbLib=new DataBaseUtility();
	public PropertyfileUtiljava pLib= new PropertyfileUtiljava();
	public WebdriverUtility wLib=new WebdriverUtility();
	public JavaUtilityjava jLib=new JavaUtilityjava();
	public  WebDriver driver=null;
	public static WebDriver sdriver;
	
	//Initialize it to driver
	@BeforeSuite(groups={"smockSuite","RegressionSuite"})
	public void connectTodatabase()
	{
		// dbLib.connectToDB();
		Reporter.log("=======dataBaseconnection succesfully");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups={"smockSuite","RegressionSuite"})
	public void launchThebrowser() throws Throwable
	{
		//read the data from property file
		String BROWSER = pLib.readfrompropertyfile("browser");
		String URL = pLib.readfrompropertyfile("url");
		
		//create RunTime Polymorphisem
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
         {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else{
			System.out.println("Invaild Browser");
		}
		
		sdriver=driver;
		wLib.maximizewindow(driver);
		wLib.waitforthePageLoad(driver);
		driver.get(URL);
	}
	@BeforeMethod(groups={"smockSuite","RegressionSuite"})
	public void login() throws Throwable
	{
		String USERNAME = pLib.readfrompropertyfile("username");
		String PASSWORD = pLib.readfrompropertyfile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		Reporter.log("=====Login Succesful===",true);
	}
	@AfterMethod(groups={"smockSuite","RegressionSuite"})
	public void logout()
	{
		HomePage hp=new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("========logout succesfully====",true);
	}
	//@AfterTest
	@AfterClass(groups={"smockTest","RegressionTest"})
	public void closeDB()
	{
		//dbLib.closedb();
		Reporter.log("====DataBase close succesfully====",true);
	}
}
