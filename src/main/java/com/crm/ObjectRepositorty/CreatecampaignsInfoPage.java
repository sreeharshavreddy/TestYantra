package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatecampaignsInfoPage 
{
	//declaration
   @FindBy(xpath="//span[@class='dvHeaderText']")
   private WebElement headerText;
   //initilization
   public CreatecampaignsInfoPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   //utilization
public WebElement getCampaignInfo() {
	return headerText;
}
   //bussiness bibrary
   public String campaignInfo()
   {
	  String camInfo = headerText.getText();
	  return camInfo;
   }
   
   
}
