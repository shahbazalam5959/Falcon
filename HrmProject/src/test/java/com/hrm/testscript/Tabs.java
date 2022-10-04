package com.hrm.testscript;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tabs {

	@Test
	public void tabs() throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String parentWindow = driver.getWindowHandle(); //ha
		
		System.out.println("Window Id :" +parentWindow);
		
		driver.findElement(By.xpath("//div[@class='premium-collection swiper-wrapper']/div[1]")).click();
		
		Set<String> allWindowId = driver.getWindowHandles();
		System.out.println(allWindowId);
		for(String child : allWindowId) // ha, ka
		{
			if(!parentWindow.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				WebElement ele = driver.findElement(By.xpath("//*[text()='Save as Alert']"));
				String salert = ele.getText();
				System.out.println(salert);
				Thread.sleep(2000);
				ele.click();
				
				try {
				if(driver.findElement(By.xpath("//div[@class='naukri-drawer right open']")).isDisplayed())
				{
					System.out.println("review Jobs Modal displayed Successfully...");
					Thread.sleep(2000);
					driver.close();
				}
				}
				catch(Exception a)
				{
					System.out.println("Modal not displayed!!!");
				}
			}
		}
		
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
