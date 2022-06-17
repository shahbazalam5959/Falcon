package com.hrm.testscript;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstClassSel {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("").setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.monsterindia.com/");
		//Logger log = (Logger) LogManager.getLogger();
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		driver.findElement(By.xpath(" //*[@class='nav-wrapper flex-container slide-effect']//span[text()='Jobseeker Login']")).click();
		//log.info("User Successfully clicked on JobSeeker Login ");
		driver.findElement(By.id("signInName")).sendKeys("shahbazalam5959@gmail.com");
		driver.findElement(By.id("password")).sendKeys("shahz@123");
		Thread.sleep(1000);
		driver.findElement(By.id("signInbtn")).click();
		
		//log.info("User Successfully Logged in !!!");
		Thread.sleep(5000);
		
		boolean status = driver.findElement(By.xpath("//nav[@class='mq-menu clearfix']//ul[2]//span[text()='My Profile']")).isDisplayed();
		System.out.println(status);
		
		if(status)
		{
			System.out.println("Element found ......user logged in successfully");
		}
		else
		{
			System.out.println("Test Failed....Element not found");
		}
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
