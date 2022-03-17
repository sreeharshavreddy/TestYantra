package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactspage
{
   //declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLookupImg;
	
	//initilization
	public Contactspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   //utilization
	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}
	//bussines laibrery
	public void clickOnCreateContactImg(){
		createContactLookupImg.click();
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
