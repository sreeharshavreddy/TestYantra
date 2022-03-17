package com.crm.GenricLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenersImplementationClass implements ITestListener
{
    ExtentReports report;
    ExtentTest test;
	public void onStart(ITestContext result) {
		// Execution will start here
		/*Configuration*/
		ExtentSparkReporter htmlReport= new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtilityjava().getsystemdateInFormate()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser" ,"Chrome");
		report.setSystemInfo("Os","Windows");
		report.setSystemInfo("Base-Url","http://localhost:8888");
		report.setSystemInfo("Reporter Name","Harsha");
		
	}
	public void onFinish(ITestContext result) {
		report.flush();
		
	}

	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName()+"-";
		//Reporter.log(MethodName+"---testScript execution failed",true);
			String path = null;
		//step 1: Configure screenshot name
		String screenshotName = MethodName+new JavaUtilityjava().getsystemdateInFormate();
			System.out.println(screenshotName);
		
			//Step 2: using screenshot method from webdriver utility
			try {
				
				path = new WebdriverUtility().getScreenshot(BaseClass.sdriver, screenshotName);
				/*EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sdriver);
				File src = eDriver.getScreenshotAs(OutputType.FILE);
				//String pa= System.getProperty("user.dir")+"/ScreenShot/"+screenshotName+".PNG";
				path ="./Screenshots/"+screenshotName+".png";
				File dst = new File(path);
				Files.copy(src, dst);*/
				
			} 
			catch (Throwable e) {
				
				e.printStackTrace();
			}
			test.log(Status.FAIL, MethodName+"------->failed");
			//it will capture exception and log it in the report
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(path);
	
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"------->skipped");
		//it will capture the exception and log it in the reports
		test.log(Status.SKIP, result.getThrowable());
		
		
		
	}

	public void onTestStart(ITestResult result) {
	String MethodName = result.getMethod().getMethodName();
	//Reporter.log(MethodName+"---testScript execution started");
	test=report.createTest(MethodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName+"---testScript execution successfull--PASS");
		test.log(Status.PASS, MethodName+"------>Pass");
			
		
	}

}
