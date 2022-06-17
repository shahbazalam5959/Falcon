package com.hrm.testscript; 
import java.util.List;
import org.openqa.selenium .By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium. chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DragDropValidation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://monsterindia.com/");
		
		driver.get("https://demoqa.com/droppable/");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
//		WebElement ele = driver.findElement(By.xpath("//*[text()='Work from Home']"));
//		act.moveToElement(ele).build().perform();
//		
//		Thread.sleep(3000);
//		
//		act.contextClick(driver.findElement(By.xpath("//ul[@class='anchor-tabs fs-14']/li[5]"))).build().perform();
//		
//		Thread.sleep(3000);
//		
		WebElement source = driver.findElement(By.xpath("//*[text()=\"Drag me\"]"));
		
		WebElement target = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		act.dragAndDrop(source, target).build().perform();
		
		Thread.sleep(3000);
		
		String expectedText="Dropped!";
		
		String actualText = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
		
		if(expectedText.equals(actualText))
		{
			System.out.println("Test Passed...");
		}
		else
		{
			System.out.println("Test Failed!!!");
		}
		
		
		driver.close();
		
		//driver.quit();
	}

}
