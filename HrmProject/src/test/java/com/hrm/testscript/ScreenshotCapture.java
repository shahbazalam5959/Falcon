package com.hrm.testscript;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreenshotCapture {

	public static void main(String[] args) throws InterruptedException, Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		File srcffile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Files.copy(srcffile, new File("C:\\Users\\shahz\\git\\Falcon\\HrmProject\\redbus.jpg"));
		Files.copy(srcffile, new File("C:\\Users\\shahz\\git\\Falcon\\HrmProject\\redbus.png"));
		
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
