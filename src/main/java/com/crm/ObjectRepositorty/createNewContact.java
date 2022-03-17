package com.crm.ObjectRepositorty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricLibrary.WebdriverUtility;

public class createNewContact extends WebdriverUtility
{

	//Declaraction
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameEdt;

	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement leadsourceDropDown;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name="search_text")
	private WebElement searchTextEdt;

	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement createneworgImg;

	// Initilization
	public createNewContact(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Ultilization

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}


	public WebElement getCreateneworgImg() {
		return createneworgImg;
	}

	public void setCreateneworgImg(WebElement createneworgImg) {
		this.createneworgImg = createneworgImg;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	//bussiness Library
	public void createNewContacts(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	public void createNewContacts(String lastName, String leadsource)
	{
		lastNameEdt.sendKeys(lastName);
		select(leadsource , leadsourceDropDown);
		saveBtn.click();
	}
	public void createNewContacts(WebDriver driver,String lastName,String leadsource)
	{
		lastNameEdt.sendKeys(lastName);
		select(leadsource, leadsourceDropDown);
		saveBtn.click();
		}
	public void createNewContacts(WebDriver driver,String lastName,String OrgName,String leadsource)
	{
		lastNameEdt.sendKeys(lastName);
		createneworgImg.click();
		swithtowindowHandles(driver, "Accounts");
		searchTextEdt.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		swithtowindowHandles(driver, "Contacts");
		saveBtn.click();
		}
	}
