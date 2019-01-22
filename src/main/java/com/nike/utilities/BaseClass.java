package com.nike.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {

	 public static WebDriver driver;

	/*----------Start of Before Test---------*/
	@BeforeTest
	public void openBrowser() throws IOException {
		Properties configPath = ReadConfigFile
				.readConfigFile("C:\\Users\\User\\workspace\\Nike.Automation\\config.properties");
		String configBrowser = configPath.getProperty("browser");
		String configEnviroment = configPath.getProperty("environment");

		if (configBrowser.equals("chrome")) {
			/*----------Start of if statement (browser)---------*/

			if (configEnviroment.equals("qa")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Bittech\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
		

			}
		} else if (configBrowser.equals("firefox")) {
			if (configEnviroment.equals("qa")) {
				// firefox code will be placed here
			}
		} else if (configBrowser.equals("ie")) {
			if (configEnviroment.equals("qa")) {
				// ie browser code will be placed here
			}
		} else {
			System.out.println("Undefined Browser");
		}
		/*----------End of if statement (browser)---------*/

		/* Website url calling from config file; */
		driver.get(configPath.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/*---------Screenshot method-------------*/
		public File screentshotCaptureMethod(String failedMethods) {
			
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destination = new File("C:\\Users\\User\\workspace\\Nike.Automation\\screenshot\\" + failedMethods + ".jpg");
			try {
				FileUtils.copyFile(src, destination);
				
				

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return destination;
		}
		
		/*--------- End Screenshot method-------------*/
	
	/*----------End of Before Test---------*/

	/*----------Start of After Test---------*/
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	/*----------End of After Test---------*/

}
