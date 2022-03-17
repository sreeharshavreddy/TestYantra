package handlingCalenderpopup;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Redbuscalenderpopup
{
	@Test
   public void redbuscanlenderpopup()
   {
	   //String month="Mar 2022";
	  // String date="20";
		 
	   Date date = new Date();
	   String d1 = date.toString();
	   String[] dat = d1.split(" ");
	   String mon = dat[1];
	    String day = dat[2];
	    String year = dat[5];
	    String DateFormate = day+"-"+mon+"-"+year;
	    
	   WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.get("https://www.redbus.com/");
	   driver.findElement(By.xpath("//button[.='Accept All']")).click();
//	   Actions action =new Actions(driver);
//	  Alert allert = driver.switchTo().alert();
//	  allert.accept();
	   
	  
	   driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
	    List<WebElement> date1 = driver.findElements(By.xpath("//td[.='Mar 2022']/ancestor::div[@class='rb-calendar']/descendant::td[.='10']"));
	   //for (WebElement ele: date1) 
	   //{
		 //  if(ele.getText().equals(DateFormate))
		   //{
			 //  ele.click();
			   //break;
		   //}
		
	//}
   }
}
