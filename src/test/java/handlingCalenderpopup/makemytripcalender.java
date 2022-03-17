package handlingCalenderpopup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class makemytripcalender 
{
	@Test
    public void handlingpopup()
    {
       WebDriver driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       driver.get("https://www.makemytrip.com/");
       Actions actions=new Actions(driver);
       actions.moveByOffset(10, 10).click().perform();
       WebElement calender = driver.findElement(By.xpath("//span[.='DEPARTURE']"));
       calender.click();
       driver.findElement(By.xpath("//div[.='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='11']")).click();
       
    }
}
