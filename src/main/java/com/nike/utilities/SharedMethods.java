package com.nike.utilities;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SharedMethods {

	/*----------Explicit wait for element---------*/
	public static WebElement explicitWaitForElement(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
		return e;
	}

	/*----------Click on Element---------*/
	public static void clickOnElement(WebElement element, WebDriver driver) {
		explicitWaitForElement(element, driver).click();
	}

	/*----------Mouse Hover on Element---------*/
	public static void mouseHover(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}



	/*----------Broken Links Checking ---------*/
	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() == 200) {
				//System.out.println(linkUrl + " - " + httpURLConnection.getResponseCode());
			} else if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {

		}
	}/*----------End of Broken Links Checking ---------*/
	
	public static void type(WebElement element, WebDriver driver, String text)
	{
		explicitWaitForElement(element, driver).sendKeys(text,Keys.ENTER);
	}

}
