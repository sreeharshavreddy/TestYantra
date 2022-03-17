package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage
{
   //Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement HeaderText;
	
	//Inilization 
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// utilization
	public void setHeaderText(WebElement headerText) {
		HeaderText = headerText;
	}
	public String ContactNameInfo()
	{
  		return HeaderText.getText();
	}
}
	
