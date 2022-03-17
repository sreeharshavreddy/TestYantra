
package com.crmOppertunity.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Property;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenricLibrary.BaseClass;
import com.crm.ObjectRepositorty.Contactspage;
import com.crm.ObjectRepositorty.CreateOpprtunitypage;
import com.crm.ObjectRepositorty.HomePage;
import com.crm.ObjectRepositorty.OpportunitiesPage;
import com.crm.ObjectRepositorty.createNewContact;

public class Deletemultipleopportunities extends BaseClass
{
	@Test
  public void deletemultipleopportunities() throws Throwable
	{
		
		String oppN = eLib.readthedatafroExcel("Opportunity", 1, 0)+" "+jLib.getRandomNumber();
		String Relatedto = eLib.readthedatafroExcel("Opportunity", 1, 1);
		String Assignedto= eLib.readthedatafroExcel("Opportunity", 1, 2);
		String Expectedclosedate = eLib.readthedatafroExcel("Opportunity", 1, 3);
		String Salessatge= eLib.readthedatafroExcel("Opportunity", 1, 4);
		String Lastname= eLib.readthedatafroExcel("Opportunity", 1, 5)+" "+jLib.getRandomNumber();
		  
	
			
			// create one contact name
		HomePage homepage=new HomePage(driver);
		homepage.clickOnConLnk();
		Contactspage contactpage=new Contactspage(driver);
		contactpage.clickOnCreateContactImg();
		createNewContact createnewcontacts=new createNewContact(driver);
         createnewcontacts.createNewContacts(Lastname);
         
        // click on Opportunity link
          homepage.clicOnOppclink();
          OpportunitiesPage OPP = new OpportunitiesPage(driver);
          OPP.createnewOppLookImg(driver);
          CreateOpprtunitypage COP=new CreateOpprtunitypage(driver);
          COP.CreateOppName(driver, oppN, Relatedto, Salessatge, Expectedclosedate, Lastname);
          
          
          
          
         
		
		
		  
			 //radio button select user
               
             // driver.findElement(By.xpath("//input[@type='radio']")).click();
             
            
              
//              //Opportunity should be created with below msg 
//              //[ POT* ] abc - Campaign Information   Updated today
//              
//              
//            String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//             if(header.contains(oppN))
//             {
//            	 System.out.println(header);
//            	 System.out.println("Opp id created");
//             }else{
//
//            	 System.out.println(header);
//            	 System.out.println("Opp id is not created");
//             }
//          driver.findElement(By.linkText("Opportunities")).click();
//           driver.findElement(By.linkText("Go to Advanced Search")).click();
//           Thread.sleep(2000);
           
//           WebElement Drop2 = driver.findElement(By.id("fcol0"));
//           Select sel1 = new Select(Drop2);
//           sel1.selectByVisibleText("Opportunity Name");
//           driver.findElement(By.xpath("//table[@class='searchUIAdv3 small']//input[1]")).click();
//           Alert a = driver.switchTo().alert();
//           a.accept();
//           
//           WebElement drop3 = driver.findElement(By.xpath("//select[@class='repBox']"));
//           
// 
//           Select sel2 = new Select(drop3);
//           sel2.selectByVisibleText("does not contains");
//           driver.findElement(By.xpath("//table[@class='searchUIAdv3 small']//input[1]")).click();
//           
//           
     }
	}
