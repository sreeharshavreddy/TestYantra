package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricLibrary.WebdriverUtility;

public class HomePage extends WebdriverUtility
{
    //step:1 declaraction
	@FindBy(xpath = "//a[.='Organizations']")
	private WebElement organizationLnk;
	
	@FindBy(linkText ="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunityLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminisrtatorImg;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	// step:2 Initilization 
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization using getters

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportunityLnk() {
		return opportunityLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getAdminisrtatorImg() {
		return adminisrtatorImg;
	}

	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}
	//Business Libraries
	public void clickOnOrgLnk()
	{
		organizationLnk.click();
	}
	public void clickOnConLnk()
	{
		contactsLnk.click();
	}
	public void clickOnProductLnk()
	{
		productsLnk.click();
	}
	public void clicOnOppclink()
	{
		opportunityLnk.click();
	}
	public void ClickOncampaignsLnk()
	{
		campaignsLnk.click();
	}
	
	public void signOutOfApp(WebDriver driver)
	{
		mousHover(driver, adminisrtatorImg);
		signOutLnk.click();
		
	}
	
	
	
}
