package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricLibrary.WebdriverUtility;

public class OrganizationPage extends WebdriverUtility
{
     //step 1: Decleration
	@FindBy(xpath= "//img[@alt='Create Organization...']")
	private WebElement createOrgLookupImg;
	
	//step 2: Initilaztion 
	public OrganizationPage(WebDriver driver)
	{
	
		PageFactory.initElements(driver,this);
	}
	//step 3: Utilization

	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}
	
	//Bussiness Libray
	public void clickonCreateOrgImg()
	{
		createOrgLookupImg.click();
	}
	
}
