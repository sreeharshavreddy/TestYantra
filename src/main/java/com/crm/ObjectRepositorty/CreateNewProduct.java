package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProduct
{
	 @FindBy(name="productname")   
	 private WebElement productnameText; 

	 @FindBy(xpath="//input[@name='button']")  
	 public WebElement saveBtn;
	 
	 @FindBy(name="search_txt")
	 public WebElement searchEdt;
	 
	 @FindBy(name="search")
	 public WebElement SearchBtn;
	 
	 //initization
	 public CreateNewProduct(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 //utilization

	public WebElement getProductnameText() {
		return productnameText;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public void setSearchEdt(WebElement searchEdt) {
		this.searchEdt = searchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public void setSearchBtn(WebElement searchBtn) {
		SearchBtn = searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	 //bussiness 
	public void productnametext(WebDriver driver,String Productname)
	{
		productnameText.sendKeys(Productname);
		saveBtn.click();
	}
	public void searchTextfiled(String Productname)
	{
		searchEdt.sendKeys(Productname);
	}
	public void clickonsearchbtn()
	{
		SearchBtn.click();
	}
	 
}
