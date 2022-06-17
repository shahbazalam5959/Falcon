package com.hrm.testscript;
import java.util.List;
import org.openqa.selenium .By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium. chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/select-menu");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//Working with dropdown
		
		Select sl = new Select(driver.findElement(By.xpath("//Select[@id='oldSelectMenu']")));
		
		String url = driver.getCurrentUrl();   //Capturing url and validating the expected endpoint
		System.out.println(url);
		if(url.contains("select-menummmmm"))
		{
			System.out.println("Test Passed!!!");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		
		sl.selectByVisibleText("Black");
		Thread.sleep(4000);
		sl.selectByValue("4");
		
		List<WebElement> lst =sl.getOptions();  // It will capture all the webElement of dd  int arr[] = {1,2,45}
		for(int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i).getText());  //Printing all the webelement text
		}
		for(int i=0;i<lst.size();i++)  //Iterating through eash webelemnt
		{
			WebElement wht =lst.get(i);
			String col=wht.getText();
		if(col.equals("White"))      // Checking the expected element at runtime
			{
			sl.selectByIndex(i);
			break;
			}
		}
		
		Thread.sleep(3000);
		
		driver.close();
		
		//driver.quit();
	}

}
