package com.hrm.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.microsoft.edge.seleniumtools.EdgeOptions;


public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browsweName, String appURL)
	{
		if(browsweName.equalsIgnoreCase("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
		}
		
		else if(browsweName.equalsIgnoreCase("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			
			System.setProperty("webdriver.firefox.bin","C:\\Users\\salam\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			
			driver = new FirefoxDriver();
		}
		
		else if(browsweName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\shahz\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			
			driver = new EdgeDriver();
		}
		
		else if(browsweName.equalsIgnoreCase("HeadlessChrome"))
		{	
			String jenkinsPathBinary = "/usr/bin/google-chrome";
			String jenkinsPath = "/usr/local/bin/chromedriver";
			String linuxDriverPath = "./Drivers/chromedriver";
			String normalPath = "./Drivers/chromedriverWindows.exe";
			System.setProperty("webdriver.chrome.driver",jenkinsPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("disable-gpu");
			//options.setHeadless(true);
			options.addArguments("window-size=1366x768"); // Reqd if You running locally
			driver = new ChromeDriver(options); 
		}
		
		else if(browsweName.equalsIgnoreCase("HeadlessEdge"))
		{	
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver92.exe");
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--headless");
			edgeOptions.addArguments("window-size=1366x768");
			driver = new com.microsoft.edge.seleniumtools.EdgeDriver(edgeOptions); 
		}
		
		else
		{
			System.out.println("Sorry!!! We do not support selected browser...");
		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get(appURL);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
}
