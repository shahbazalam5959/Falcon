package com.hrm.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/shahz/Desktop/frames.html");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.switchTo().frame("w3c");
		WebElement InsideFrame = driver.findElement(By.xpath("//button[@class=\"menu-toggle dashicons-before dashicons-menu\"]"));
		InsideFrame.click();
		
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		try 
		{	
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'Click here')]"));
		System.out.println(ele.getText());
		
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("arguments[0].scrollIntoView();",ele);
		
		String url = driver.findElement(By.xpath("//a[contains(@href,'amazon.com')]")).getAttribute("href");
		System.out.println(url);
		System.out.println("Going to click on Shoppig link!!!");
		
		driver.findElement(By.linkText("Click here for Shopping!!!")).click();
		Thread.sleep(3000);
		
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("User is not on parent window..."+e.getMessage());
		}
		
		
		driver.quit();
	}

}
