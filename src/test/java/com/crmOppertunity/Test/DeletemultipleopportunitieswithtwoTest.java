
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

public class DeletemultipleopportunitieswithtwoTest 
{
	@Test
  public void deletemultipleopportunitieswithtwo() throws Throwable
	{
		// generate random number
		 Random ran = new Random();
		 int random = ran.nextInt(500);
		 //Read necessary data from property file
		 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\PROPERTY.properties");
		 Properties pobj = new Properties();
		 pobj.load(fis);
		 String BROWSER = pobj.getProperty("browser");
		 String URL = pobj.getProperty("url");
		 String USERNAME = pobj.getProperty("username");
		 String PASSWORD = pobj.getProperty("password");
		 
		 // Read the data from excel sheet
		 FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		  Workbook WK = WorkbookFactory.create(fs);
		  Sheet sheet = WK.getSheet("Opportunity ");
		  Row row = sheet.getRow(1);
		  Cell cell = row.getCell(1);
		  String oppN = cell.getStringCellValue();
		  String OpportunityName = oppN+" "+random;
		           
		  Cell cell1 = row.getCell(1);
		  String Relatedto = cell1.getStringCellValue()+random;     
		  
		  Cell cell2 = row.getCell(2);
		  String Assignedto= cell2.getStringCellValue()+random;         
		 
		  Cell cell3 = row.getCell(3);
		  String Expectedclosedate= cell3.toString();
		 
		  Cell cell4 = row.getCell(4);
		  String Salessatge= cell2.getStringCellValue()+random;
		
		  
		  Cell cell5 = row.getCell(5);
		  String Lastname= cell5.getStringCellValue()+random;
    
		  
		  /*Step 2: launch the browser*/
			WebDriver driver=null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else

			{
				System.out.println("invalid browser");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
			
			/*Step : login to application*/
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			// create one contact name
			driver.findElement(By.xpath("//a[.='Contacts']")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
            driver.findElement(By.name("lastname")).sendKeys(Lastname);
            driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			
		  
		  /*step: Navigate to application*/
			  driver.findElement(By.xpath("//a[.='Opportunities']")).click();
			 
			 
			 //Create new opportunity
			 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			 //create a Opportunity with mandatory fields
              driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(OpportunityName);
              
              //handling dropdown
              WebElement Drop = driver.findElement(By.xpath("//select[@id='related_to_type']"));
              Select sel = new Select(Drop);
              sel.selectByVisibleText("Contacts");
              driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
              
              Set<String> alid = driver.getWindowHandles();
              for (String pid: alid)
              {
				driver.switchTo().window(pid);
			  }
            
              driver.findElement(By.xpath("//body[@class='small']")).sendKeys(Lastname);
       	      driver.findElement(By.name("search")).click();
       	      driver.findElement(By.xpath("//a[@id='10']")).click();
       	      
       	       Set<String> pid= driver.getWindowHandles();
               for (String pi: pid)
             {
				driver.switchTo().window(pi);
			  }
			 //radio button select user
               
             // driver.findElement(By.xpath("//input[@type='radio']")).click();
             
              //sales stage
               WebElement drop1 = driver.findElement(By.name("sales_stage"));
              Select sel3 = new Select(drop1);
              sel3.selectByVisibleText("Prospecting");
              //date text field
              driver.findElement(By.name("closingdate")).sendKeys(Expectedclosedate);
              // click on sav
              driver.findElement(By.xpath("//input[@type='submit']")).click();
              
              //Opportunity should be created with below msg 
              //[ POT* ] abc - Campaign Information   Updated today
              
              
            String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
             if(header.contains(OpportunityName))
             {
            	 System.out.println(header);
            	 System.out.println("Opp id created");
             }else{

            	 System.out.println(header);
            	 System.out.println("Opp id is not created");
             }
          driver.findElement(By.linkText("Opportunities")).click();
           driver.findElement(By.linkText("Go to Advanced Search")).click();
           
           WebElement Drop2 = driver.findElement(By.name("fcol0"));
           
           Select sel1 = new Select(Drop2);
           sel1.selectByVisibleText("Expected Close Date");
         
         
           driver.findElement(By.xpath("//table[@class='searchUIAdv3 small']//input[1]")).click();
           Alert a = driver.switchTo().alert();
          
          
      }
	}
