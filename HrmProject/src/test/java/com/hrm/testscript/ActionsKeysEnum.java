package com.hrm.testscript; 
import java.util.List;
import org.openqa.selenium .By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium. chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionsKeysEnum {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
		
		Thread.sleep(5000);
		
		Actions act = new Actions(driver);
		
		WebElement FN = driver.findElement(By.xpath("//input[@name='firstname']"));
		
		WebElement SN = driver.findElement(By.xpath("//input[@name='lastname']"));
		
		WebElement ME = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		
		act.sendKeys(FN,"John").build().perform();
		
		act.click(SN).sendKeys("Rock is a WWE Champ").build().perform();
		Thread.sleep(1000);
		act.keyDown(SN,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		
		Thread.sleep(2000);
		act.keyDown(SN,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		Thread.sleep(3000);
		act.keyDown(ME,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		
		Thread.sleep(3000);
		
		driver.close();
		
		//driver.quit();
	}

}
