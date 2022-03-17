package com.crm.ObjectRepositorty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage 
{
	//declaration
    @FindBy(xpath="//span[@class='lvtHeaderText']")
    private WebElement HeaderText;
    // ini
    public ProductInfoPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    //utilization
    public WebElement getHeaderText() {
		return HeaderText;
    }
	//business library
    public String ProductInfo()
    {
	String ProductInfo = HeaderText.getText();
	return ProductInfo;
     }
}
