package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenricLibrary.WebdriverUtility;

public class CreateOrganizationPage extends WebdriverUtility
{
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industrydropdown;
	
	@FindBy(name="accounttype")
	private WebElement accounttypedropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="accounttype")
	private WebElement typedropdown;
	// step 2: initilization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//step 3: Utilization

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getTypedropdown() {
		return typedropdown;
	}

	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}

	public WebElement getAccounttypedropdown() {
		return accounttypedropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business Library
		public void createNewOrg(String orgName)
		{
			OrgNameEdt.sendKeys(orgName);
			saveBtn.click();
		}
		public void createNewOrg(String orgName, String IndusType)
		{
			OrgNameEdt.sendKeys(orgName);
			select(IndusType,industrydropdown );
			saveBtn.click();
		}
		public void createNewOrg(String orgName,String IndusType,String Type)
		{
		OrgNameEdt.sendKeys(orgName);
		select(IndusType,industrydropdown);
		select(Type,typedropdown);
		saveBtn.click();
		}
}        
