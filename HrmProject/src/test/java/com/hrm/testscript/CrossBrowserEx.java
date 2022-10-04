package com.hrm.testscript;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.reactor.Command.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserEx {

	WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser"})
	public void startBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Path of Firefox driver");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\shahz\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("We do not support this browser!!!");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(enabled = false)
	public void Test1()
	{
	
		driver.get("https://www.redbus.in/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Inside Test 1");
		driver.findElement(By.xpath("//div[contains(@class,'fl search-box date-box gtm-onwardCalendar')]")).click();
		//Thread.sleep(5000);
		List<WebElement> calendarDate = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));
		//table[@class='rb-monthTable first last']/tbody/tr/td
		
		System.out.println(calendarDate.size());
	
		for(int i=0;i<calendarDate.size();i++)
		{
			String date = calendarDate.get(i).getText();
			
			if(date.equalsIgnoreCase("22"))
			{
				calendarDate.get(i).click();
				System.out.println(date);
				break;
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Test
	public void ATest2()
	{
	
		driver.get("https://www.redbus.in/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Inside Test 2");
		driver.findElement(By.xpath("//div[contains(@class,'fl search-box date-box gtm-onwardCalendar')]")).click();
		//Thread.sleep(5000);
		List<WebElement> calendarDate = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"))		;
		//table[@class='rb-monthTable first last']/tbody/tr/td
		
		System.out.println(calendarDate.size());
	
		for(int i=0;i<calendarDate.size();i++)
		{
			String date = calendarDate.get(i).getText();
			
			if(date.equalsIgnoreCase("10"))
			{
				calendarDate.get(i).click();
				System.out.println(date);
				break;
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}


}