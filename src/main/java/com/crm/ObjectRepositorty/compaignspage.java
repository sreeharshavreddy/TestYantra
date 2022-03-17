package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class compaignspage 
{
	//Declaration
      @FindBy(xpath="//img[@title='Create Campaign...']")
	  private WebElement createnewLookup;
      // intilization
      public compaignspage(WebDriver driver){
      PageFactory.initElements(driver, this);
      //utilization
      }
  
	public WebElement getCreatenewLookup() {
		return createnewLookup;
	}
	//bussines libary
	public void createnewcampaignimg(){
		createnewLookup.click();
	}
}
