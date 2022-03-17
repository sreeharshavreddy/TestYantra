package com.crm.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.GenricLibrary.ExcelfileUtility;
import com.crm.GenricLibrary.JavaUtilityjava;
import com.crm.GenricLibrary.PropertyfileUtiljava;
import com.crm.GenricLibrary.WebdriverUtility;
import com.crm.ObjectRepositorty.Contactspage;
import com.crm.ObjectRepositorty.CreateOrganizationPage;
import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.LoginPage;
import com.crm.ObjectRepositorty.OrganizationPage;
import com.crm.ObjectRepositorty.createNewContact;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactwithLeadsourceOrgLastName extends BaseClass
{

	@Test
	public void createOrgTest() throws Throwable
	{
		
        int ran1=jLib.getRandomNumber();
		String lastName = eLib.readthedatafroExcel("Org", 1, 2)+" "+ran1;
		String OrgName= eLib.readthedatafroExcel("Contacts", 4, 2)+" "+ran1;
		String Leadsource= eLib.readthedatafroExcel("Contacts", 4, 4);
		
		// click on Org link
		HomePage hm=new HomePage(driver);
		hm.clickOnOrgLnk();
		OrganizationPage og=new OrganizationPage(driver);
		og.clickonCreateOrgImg();
		CreateOrganizationPage cog=new CreateOrganizationPage(driver);
		cog.createNewOrg(OrgName);
		//Step:4 click on contacts
		hm.clickOnConLnk();
		// step :5 create contacts
	    Contactspage cp=new Contactspage(driver);
	    cp.clickOnCreateContactImg();
		//Contacts mandatory field
		createNewContact cnc=new createNewContact(driver);
		cnc.createNewContacts(lastName, Leadsource);
		
}}

