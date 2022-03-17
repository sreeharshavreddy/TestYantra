package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	// Declaration -use FindBy annotation 
     @FindBy(name="user_name")
      private WebElement usernameEdt;
     
     @FindBy(name="user_password")
     private WebElement passwordEdt;
     
     @FindBy(id = "submitButton")
     private WebElement submitBtn;
     
     //step :2 Initiligation -provide getters
     
     public  LoginPage(WebDriver driver)
     {
    	 PageFactory.initElements(driver, this);
     }   
    
    ///step:3 Ulilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	   
    //Business Library
    public void LoginToApp(String userName,String password)
    {
   	 usernameEdt.sendKeys(userName);
   	 passwordEdt.sendKeys(password);
   	 submitBtn.click();
    }
     
}
