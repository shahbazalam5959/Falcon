package com.hrm.testscript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertInWD {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/shahz/Desktop/frames.html");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[contains(text(),\"Try it Sim\")]")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()=\"Try it\"]")).click();
		
		System.out.println(alert.getText());
		
		alert.sendKeys("Pepsi");
		
		alert.accept();
		
		Thread.sleep(2000);
		
		String alertMsg = driver.findElement(By.xpath("//p[contains(text(),\"Pepsi\")]")).getText();
		
		if(alertMsg.contains("Pepsi"))
		{
			System.out.println("Test passed!!!");
		}
		else
		{
			System.out.println("Wrong input provided...");
		}
		
		
		driver.quit();
		
		
	}

}
