package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createnewcompaigns 
{
    @FindBy(name="campaignname")
    private WebElement CampaignText;
    @FindBy(name="button")
    private WebElement saveBtn;
    @FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
    private WebElement createproductImg;
    
    //utilization
    public void createnewcampaigne(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    //initilization

	
	public WebElement getCampaignText() {
		return CampaignText;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getCreateproductImg() {
		return createproductImg;
	}


    //Bussiness laibrary
	public void createnecampaigne(String Compaignename)
	{
		CampaignText.sendKeys(Compaignename);
		saveBtn.click();
	}
	public void selectproductnameImg()
	{
		createproductImg.click();
	}
    	
}
