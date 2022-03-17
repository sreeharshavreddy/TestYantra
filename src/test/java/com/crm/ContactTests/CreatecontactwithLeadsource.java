package com.crm.ContactTests;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelfileUtility;
import com.crm.GenricLibrary.JavaUtilityjava;
import com.crm.GenricLibrary.PropertyfileUtiljava;
import com.crm.GenricLibrary.WebdriverUtility;
import com.crm.ObjectRepositorty.ContactInfoPage;
import com.crm.ObjectRepositorty.Contactspage;

import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.LoginPage;
import com.crm.ObjectRepositorty.OrganigationInfoPage;
import com.crm.ObjectRepositorty.OrganizationPage;
import com.crm.ObjectRepositorty.createNewContact;
import com.srm.PRACTICE.ReadtheDataFromExcel;

public class CreatecontactwithLeadsource extends BaseClass
{
	@Test
	public void CreateContactWithExistingField() throws Throwable 
	{
		int ran1=jLib.getRandomNumber();
		String lastName = eLib.readthedatafroExcel("Contacts", 4, 2)+" "+ran1;
		HomePage hm=new HomePage(driver);
		hm.clickOnConLnk();
		
		Contactspage cp = new Contactspage(driver);
		cp.clickOnCreateContactImg();
		
		createNewContact cc = new createNewContact(driver);
		cc.createNewContacts(lastName, "Employee");
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String header = cip.ContactNameInfo();
		if(header.contains(lastName))
			System.out.println(header+"-->contact created");
		else
			System.out.println("contact not created");
		
	}
}
