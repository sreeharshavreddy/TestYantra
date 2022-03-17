package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
	//Declaration
   @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
   private WebElement createnewproducImg;
   
  
  
   //initilization
   public ProductPage(WebDriver driver)
   {
   PageFactory.initElements(driver, this);
   }
   //utilization

public WebElement getCreatenewproducImg() {
	return createnewproducImg;
}

   // bussines librarty
   
	public void createnewproducImg()
	{
		createnewproducImg.click();
	}
}
