package com.hrm.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginMultipleUser {
	
	WebDriver driver;
	
	@BeforeClass
	public void initialSetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/shahz/Desktop/frames.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test(dataProvider = "loginCredentials")
	public void TestMultipleUserlogin(String username, String password) throws Exception
	{	
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@placeholder,\"name\")]")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@placeholder,\"Password\")]")).sendKeys(password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[contains(text(),\"Login\")]")).click();
		
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		driver.navigate().back();
		
	}

	@DataProvider(name="loginCredentials")
	public String[][] getLoginData()
	{
		String data[][] = new String[4][2];
		
		data[0][0]="abc@gmail.com";
		data[0][1]="admin";
		data[1][0]="abc123@gmail.com";
		data[1][1]="admin12";
		data[2][0]="abcxyz@gmail.com";
		data[2][1]="admin123";
		data[3][0]="abcshaz@gmail.com";
		data[3][1]="admin12345";
		
		return data;
	}
	
	@AfterClass
	public void quitBrowser()
	{
		driver.quit();
	}
	
	
}
