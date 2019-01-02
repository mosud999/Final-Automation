package com.nike.allpages.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.nike.all_pages.HomePage;
import com.nike.utilities.SharedMethods;

public class TestTest {
	WebDriver driver;
	@Test() 
	public void homePageTest3()
	{	
		System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.spicejet.com/");
		String dateVal="10-02-2008";
		WebElement e=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
		
		//input[@Id='ctl00_mainContent_view_date1']
		  
		
		JavascriptExecutor js=((JavascriptExecutor) driver);
		//js.executeScript("document.getElementById('ctl00_mainContent_view_date1').value='"+dateVal+"';", e);
		js.executeScript("arguments[0].setAttribute('id='ctl00_mainContent_view_date1']','"+dateVal+"');", e);
		
	
	
	}
	
	/*@Test
	 public void m(){
		  
		  System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("http://www.spicejet.com/");
		  driver.manage().window().maximize();
		  
		  String dateVal="11-09-2000";
		  WebElement e=driver.findElement(By.xpath("//input[@class='custom_date_pic required picker-first home-date-pick valid']"));
		 // WebElement f=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
		 String d="ctl00_mainContent_view_date1";


		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("document.getElementById('ctl00_mainContent_view_date1').value='"+dateVal+"';", e, d);
		  //js.executeScript("document.getElementById('"+id+"').textContent='"+date+"';");
		  
		  
		  
		 }
	*/

}
