package com.crm.ContactTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
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

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelfileUtility;
import com.crm.GenricLibrary.JavaUtilityjava;
import com.crm.GenricLibrary.PropertyfileUtiljava;
import com.crm.GenricLibrary.WebdriverUtility;
import com.crm.ObjectRepositorty.Contactspage;
import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.LoginPage;
import com.crm.ObjectRepositorty.createNewContact;
import com.google.common.collect.Table.Cell;
import com.mysql.cj.result.Row;

public class CreateContactwithMadetoryField extends BaseClass 
{
	@Test
	public void createOrgTest() throws Throwable
	{
        int ran1=jLib.getRandomNumber();
		String lastName = eLib.readthedatafroExcel("Org", 1, 2)+" "+ran1;
		
		//Step:4 click on contacts
		HomePage hm=new HomePage(driver);
		hm.clickOnConLnk();
		// step :5 create contacts
	    Contactspage cp=new Contactspage(driver);
	    cp.clickOnCreateContactImg();
		//Contacts mandatory field
		createNewContact cnc=new createNewContact(driver);
		cnc.createNewContacts(lastName);
		
	
}}
