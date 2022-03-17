package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricLibrary.WebdriverUtility;

public class OrganigationInfoPage 
{
   @FindBy(xpath="//span[@class='dvHeaderText']")
   private WebElement headerText;
   
   //step 2: initilization
   public OrganigationInfoPage(WebDriver driver)  
   {
	   PageFactory.initElements(driver, this);
   }
   //step 3: utilization
    public WebElement getHeaderText() {
	return headerText;
    }
    //business library
        public String OrgInfo()
        {
    	String OrgInfo = headerText.getText();
    	return OrgInfo;
         }
   
}
