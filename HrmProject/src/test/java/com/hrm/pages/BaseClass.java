package com.hrm.pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrm.util.BrowserFactory;
import com.hrm.util.ConfigDataProvider;


public class BaseClass {
	
	public WebDriver driver;
	public static ExtentHtmlReporter extent; // It creates a rich standalone HTML file.
	public static ExtentReports report; // ExtentReports start reporter & building the reports.
	public static ExtentTest extentLogger; // Defines a test with createTest(), we can add logs, screenshot.
	public ConfigDataProvider config;
	
	//public Logger log;
	
	public Logger log;

/*	@BeforeSuite
	public void setUpSuite()
	{
		
		Reporter.log("Setting Up report and Test is getting ready...",true);
		
		config = new ConfigDataProvider();
		
		extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Monster_"+HelperClass.captureCurrentDateTime() +".html"));
		
		report = new ExtentReports();
		
		report.attachReporter(extent);
		
		extent.config().setDocumentTitle("Automation_Report");
		
		extent.config().setReportName("HRM_Automation_Report");
		
		extent.config().setTheme(Theme.DARK);
		
		report.setSystemInfo("Project Name", "HRM_Recruiter");
		
		report.setSystemInfo("Environment", "Production");
		
		report.setSystemInfo("User", "HRM_Internal");
		
	}
	*/
	
//	@BeforeClass
//	public void logSetup()
//	{
//		//log = Logger.getLogger("Monster"); //added loggger---This code will generate the logs
//		//PropertyConfigurator.configure("log4j.properties");  //added loggger==Loc of property files
//		//log.setLevel(Level.DEBUG);
//		
//		 log = (Logger) LogManager.getLogger("Monster");
//		
//		
///*		try {
//				ScreenRecorderUtil.startRecord("VerifyRecruiterIndiaTest");
//			} 
//		catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//		log.info("----------- Test Recording started -----------"); */
//		
//	}   

	@Parameters({"browser", "appUrl"})
	@BeforeMethod
	public void initialSetup(Method testMethod)
	{
		Reporter.log("Setting Done Test can be Started...",true);
		
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStatgingUrl());
			//driver = BrowserFactory.startApplication(driver, "HeadlessChrome", "https://recruiter.monsterindia.com/v4/recruiter/search");
		//driver = BrowserFactory.startApplication(driver, browserName, ApplicationURL);
		
		Reporter.log("Browser and Application is up and running...");
		
		
//		try {
//			ScreenRecorderUtil.startRecord(testMethod.getName());
//		} 
//		catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
	log.info("----------- Test Recording started -----------");
		
		

	}
	
	
	@AfterMethod
	public void captureScreen(ITestResult result, Method testMethod)
	{
/*		try
		{
			if(result.getStatus()==ITestResult.FAILURE)
			{
			
				extentLogger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
				
				extentLogger.log(Status.FAIL,"Test Failed : "+result.getThrowable());
				
			}
		
			else if(result.getStatus()==ITestResult.SKIP)
			{
				//extentLogger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
				
				extentLogger.log(Status.SKIP,"Test Skipped : "+result.getName());
			}
			
			else if(result.getStatus()==ITestResult.SUCCESS)
			{
				//extentLogger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
				
				extentLogger.log(Status.PASS,"Test Passes : "+result.getName());
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//extentLogger=report.createTest(testMethod.getName());
		
		try {
			ScreenRecorderUtil.stopRecord();
			
			ConfigDataProvider config = new ConfigDataProvider();
			
			String ds = config.getDataFromConfig("deleteSuccess");
			
			if(ds.equalsIgnoreCase("true") && (result.getStatus()==ITestResult.SUCCESS || result.getStatus()==ITestResult.SKIP))
			{
				ScreenRecorderUtil.deleteFile();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		BrowserFactory.quitBrowser(driver);
	
	}
	
//	@AfterSuite
//	public void tearDown1()
//	{
//		report.flush();
//	}
	
	
	@AfterClass
	public void tearDown()
	{	
/*		try {
			ScreenRecorderUtil.stopRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}
	

}
