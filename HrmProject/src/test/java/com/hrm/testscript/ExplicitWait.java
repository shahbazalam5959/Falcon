package com.hrm.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWait {

	@Test
	public void ExplicitwaitExample() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/shahz/Desktop/frames.html");
		driver.manage().window().maximize();
		System.out.println("Maximized");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("Waited");
		System.out.println(driver.findElement(By.xpath("//*[text()='Click To Start Timer']")).getText());
		Thread.sleep(3000);
		WebElement eleN = driver.findElement(By.xpath("//*[text()='Click To Start Timer']"));
		System.out.println(eleN);
		//eleN.click();
		
		Actions act = new Actions(driver);
		
		act.moveToElement(eleN).build().perform();
		
		act.click(eleN).build().perform();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Maven/TestNG')]")));
		
		System.out.println(ele.getText());
		
		driver.quit();
		
	}
	

}
