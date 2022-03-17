package com.srm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMpracticeforLogin 
{
	@Test
	public void pomPractice()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888");
		
		LoginPage lp= new LoginPage(driver);
		lp.LoginToApp("admin", "admin");
		HomePage hp =new HomePage(driver);
		hp.clickOnOrgLnk();
		hp.signOutOfApp(driver);
	}
	

}

