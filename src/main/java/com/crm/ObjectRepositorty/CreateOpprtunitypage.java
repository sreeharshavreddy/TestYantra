package com.crm.ObjectRepositorty;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricLibrary.WebdriverUtility;

public class CreateOpprtunitypage extends WebdriverUtility
{
	@FindBy(name="potentialname")
	private WebElement OpportuntyTextEdt;

	@FindBy(name="related_to_type")
	private WebElement RelatedToDropDown;


	@FindBy(xpath="//input[@name='related_to_display']/following-sibling::img[@title='Select']")
	private WebElement SelectcontNImg;

	@FindBy(name="search_text")
	private WebElement SearchTextEdt;

	@FindBy(name="search")
	private WebElement searchBtn;

	@FindBy(xpath="//a[.= ' Adarsh']")
	private WebElement SelectLastName;

	@FindBy(xpath="//select[@name='sales_stage']")
	private WebElement salesStagedropdown;

	@FindBy(xpath="//input[@name='closingdate']")
	private WebElement closeingdatedropdown;

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headsertext;


	@FindBy(xpath="//input[@type='radio']")
	private WebElement ClikRadioBtn;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//initilization
	public CreateOpprtunitypage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	//Bussiness Library
	public void CreateOppName(WebDriver driver,String OppName, String Relatedto,String Salessatge,String Expectedclosedate,String Lastname)
	{
		OpportuntyTextEdt.sendKeys(OppName);
		select(RelatedToDropDown,Relatedto);
		SelectcontNImg.click();
		swithtowindowHandles(driver,"Contacts");
		SearchTextEdt.sendKeys(Lastname);
		searchBtn.click();
		SelectLastName.click();
		swithtowindowHandles(driver,"Potentials");
		select(salesStagedropdown,Salessatge);
		closeingdatedropdown.clear();
		closeingdatedropdown.sendKeys(Expectedclosedate);
		ClikRadioBtn.click();
		saveBtn.click();
	}
	public void getcalenderdate(WebDriver driver)
	{
		driver.findElement(By.xpath("(//td[.='March, 2022']/ancestor::table[@style='visibility: visible;'])[4]/descendant::td[.='18']"));
	}

	public WebElement getOpportuntyTextEdt() {
		return OpportuntyTextEdt;
	}

	public WebElement getRelatedToDropDown() {
		return RelatedToDropDown;
	}

	public WebElement getSelectcontNImg() {
		return SelectcontNImg;
	}

	public WebElement getSearchTextEdt() {
		return SearchTextEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSelectLastName() {
		return SelectLastName;
	}

	public WebElement getSalesStagedropdown() {
		return salesStagedropdown;
	}

	public WebElement getCloseingdatedropdown() {
		return closeingdatedropdown;
	}

	public WebElement getHeadsertext() {
		return headsertext;
	}
	public WebElement getClikRadioBtn() {
		return ClikRadioBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
} 
