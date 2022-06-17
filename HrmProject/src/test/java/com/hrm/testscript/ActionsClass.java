package com.hrm.testscript;//ul[@class='anchor-tabs fs-14']/li[5]

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionsClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.monsterindia.com/");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		WebElement hover = driver.findElement(By.xpath("//*[text()='Work from Home']"));
		WebElement profile = driver.findElement(By.xpath("//*[text()='Fresher Jobs']"));
		act.moveToElement(hover).build().perform();
		Thread.sleep(5000);
		act.contextClick(profile).build().perform();
		Thread.sleep(5000);
		driver.close();
		
		//driver.quit();
	}

}
