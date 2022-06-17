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

public class ScrollBy {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor jsx  = (JavascriptExecutor)driver;
		
		jsx.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		jsx.executeScript("window.scrollBy(0,-500)");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("refrigerator");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);
		
		WebElement pagination = driver.findElement(By.xpath("//span[@class='s-pagination-strip']"));
		
		if(pagination.isDisplayed())
		{
			jsx.executeScript("arguments[0].scrollIntoView();", pagination);
			System.out.println("Scrolled Successfully!!!!");
		}
		else
		{
			System.out.println("Unable to locate element");
		}
		
		jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
