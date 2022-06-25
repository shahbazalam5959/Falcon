package com.hrm.testscript;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

import com.hrm.pages.BaseClass;

public class JenkinsE2ETest extends BaseClass {

	WebDriver driver;
	

	@Test
	public void MultiBrowser() throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[contains(@class,'fl search-box date-box gtm-onwardCalendar')]")).click();
		Thread.sleep(5000);
		List<WebElement> calendarDate = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));
		
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
		Thread.sleep(5000);
	}
	
	@Test
	public void Tabs() throws Exception {
		// TODO Auto-generated method stub
	
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[contains(@class,'fl search-box date-box gtm-onwardCalendar')]")).click();
		Thread.sleep(5000);
		List<WebElement> calendarDate = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));
		
		System.out.println(calendarDate.size());
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		for(int i=0;i<calendarDate.size();i++)
		{
			String date = calendarDate.get(i).getText();
			
			System.out.println("Calendar Date : "+date);
		}
	
		
	}

}