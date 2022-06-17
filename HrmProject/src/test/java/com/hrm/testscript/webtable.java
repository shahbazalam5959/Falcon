package com.hrm.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webtable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[contains(@class,'fl search-box date-box gtm-onwardCalendar')]")).click();
		Thread.sleep(5000);
		List<WebElement> calendarDate = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"))		;
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
		Thread.sleep(5000);
		
		driver.quit();
	}
}
