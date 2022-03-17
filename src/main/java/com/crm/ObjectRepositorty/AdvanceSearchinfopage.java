package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenricLibrary.WebdriverUtility;

public class AdvanceSearchinfopage extends WebdriverUtility
{
     //Declaration
	   @FindBy(xpath="//select[@id='fcol0']")
	   private WebElement OppInfopagedropdown;
	   
	   @FindBy(xpath="//select[@id='fop0']") 
	   WebElement noneDropdown;
	   
	   @FindBy(xpath="//input[@value=' Search Now ']")
	   private WebElement SearchBtn;
    //Initiation
    public AdvanceSearchinfopage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    //utilization
	public WebElement getOppInfopagedropdown() {
		return OppInfopagedropdown;
	}
	public WebElement getNoneDropdown() {
		return noneDropdown;
	}
	public WebElement getSearchBtn() {
		return SearchBtn;
	}
    //Business library
	public void Opppageinfopage(String OppName,String Options)
	{
	select(OppInfopagedropdown,OppName);
	select(noneDropdown,Options);
    SearchBtn.click();
    }
}
