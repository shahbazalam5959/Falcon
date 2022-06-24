package com.hrm.testscript;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserEx {

	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{

		if(browser.equalsIgnoreCase("firefox")){
		
		System.setProperty("","Path of your gecko driver");
		driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome")){
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")){
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\shahz\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		}
		else{
	
		throw new Exception("Sorry!!! We do not support this browser....Try Again with different browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@Test
	public void MultiBrowser() throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.get("https://www.redbus.in/");
		//driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[contains(@class,'fl search-box date-box gtm-onwardCalendar')]")).click();
		Thread.sleep(5000);
		List<WebElement> calendarDate = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));
		
		System.out.println(calendarDate.size());

		for(int i=0;i<calendarDate.size();i++)
		{
			String date = calendarDate.get(i).getText();
			
			if(date.equalsIgnoreCase("22"))
			{
				calendarDate.get(i).click();
				System.out.println(date);
				break;
			}
		}
		Thread.sleep(5000);
	}
	
	@Test
	public void Tabs() throws Exception {
		// TODO Auto-generated method stub
		
		driver.get("https://www.naukri.com/");
		
		//driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String parentWindow = driver.getWindowHandle(); //ha
		
		System.out.println("Window Id :" +parentWindow);
		
		driver.findElement(By.xpath("//div[@class='premium-collection swiper-wrapper']/div[1]")).click();
		
		Set<String> allWindowId = driver.getWindowHandles();
		System.out.println(allWindowId);
		for(String child : allWindowId) // ha, ka
		{
			if(!parentWindow.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				WebElement ele = driver.findElement(By.xpath("//*[text()='Save as Alert']"));
				String salert = ele.getText();
				System.out.println(salert);
				Thread.sleep(2000);
				ele.click();
				
				try {
				if(driver.findElement(By.xpath("//div[@class='naukri-drawer right open']")).isDisplayed())
				{
					System.out.println("review Jobs Modal displayed Successfully...");
					Thread.sleep(2000);
					driver.close();
				}
				}
				catch(Exception a)
				{
					System.out.println("Modal not displayed!!!");
				}
			}
		}
		
		Thread.sleep(5000);
	}
	

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}