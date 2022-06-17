package com.hrm.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

	WebDriver driver;
	
	@BeforeClass
	public void initialSetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/shahz/Desktop/frames.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="logincred")
	public void TestMultipleUserLogin(String username, String password) throws Exception
	{
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("user")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.name("user_pass")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.id("myButton")).click();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.navigate().back();
	}
	
	@DataProvider(name="logincred")
	public static String[][] getLoginData()
	{
		String data[][] = new String[3][2];
		
		data[0][0]="abc@gmail.com";
		data[0][1]="admin";
		data[1][0]="xyz@gmail.com";
		data[1][1]="admin12";
		data[2][0]="shahbaz@gmail.com";
		data[2][1]="admin123";
		
		return data;
		
	}
	
	@AfterClass
	public void quitBrowser()
	{
		driver.quit();
	}
	
	

}
