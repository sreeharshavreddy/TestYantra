package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage
{
   @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
   private WebElement createnewOppLookImg;
   
   @FindBy(linkText="//a[.='Go to Advanced Search']")
   private WebElement clickOnGotobasicsearch;
   
   // inilization
   public OpportunitiesPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   //utilization

    public WebElement getCreatenewLookImg() {
	return createnewOppLookImg;
  }
    
   public WebElement getClickOnGotobasicsearch() {
		return clickOnGotobasicsearch;
	}

	//Business library
    public void createnewOppLookImg(WebDriver driver)
    {
    	createnewOppLookImg.click();
    }
    public void clickOnGotobasicSearch()
    {
    	clickOnGotobasicsearch.click();
    }
}
