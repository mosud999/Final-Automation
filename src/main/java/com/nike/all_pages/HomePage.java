package com.nike.all_pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.nike.utilities.AllPagesExpectedUrl;
import com.nike.utilities.ReadConfigFile;
import com.nike.utilities.SharedMethods;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//span[@class='nsg-glyph--swoosh gnav-bar--home-logo']")
	WebElement logoElement;
	
	@FindBy(xpath="//input[@class='global-search-input mod-ncss-input pt2-sm pr8-sm pl12-sm pb2-sm u-rounded']") 
	WebElement searchBarElement;
	
	@FindBy(xpath="//button[@class='js-rootItem js-navItem']") 
	WebElement loginButtonElement;
	
	@FindBy(xpath="//input[@type='email' and @placeholder='Email']") 
	WebElement loginEmailBoxElement;
	
	@FindBy(xpath="//input[@type='password' and @placeholder='Password']") 
	WebElement loginPasswordBoxElement;
	
	@FindBy(xpath="//div[@class='modal-window-class nsg-bg--white exp-unite-modal-window']//div[@class='modal-close-glyph nsg-glyph--x']")
	WebElement loginFormCloseElement;
	
	@FindBy(xpath="//a[text()='Join now.']")
	WebElement joinNowButtonElement;
	
	@FindBy(xpath="//div[@class='modal-window-class nsg-bg--white exp-unite-modal-window']//div[@class='modal-close-glyph nsg-glyph--x']")
    WebElement joinNowFormCloseButtonElement;
	
	@FindBy(xpath="//input[@type='email' and @placeholder='Email']")
	WebElement joinInFormEmailElement;
	
	@FindBy(xpath="//input[@type='password' and @autocomplete='new-password' ]")
	WebElement joinInFormPasswordElement;
	
	@FindBy(xpath="//input[@type='text' and @placeholder='First Name']")
	WebElement joinInFormFirstNameElement;
	
	@FindBy(xpath="//input[@type='text' and @placeholder='Last Name']")
	WebElement joinInFormLastNameElement;
	
	@FindBy(xpath="//input[@name='dateOfBirth']")
	WebElement joinInDateOfBirthElement;
	
	@FindBy(xpath="//select[@name='country' and @data-componentname='country']")
	WebElement joinInCountrySelection;
	
	
	/*----------Constructor---------*/
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}/*----------End of Constructor---------*/

	
	/*----------HomePage url verification---------*/
	public void homePage_UrlVerification(){
		String actualHomepageUrl = driver.getCurrentUrl();
		Properties expectedUrl=AllPagesExpectedUrl.allPagesExpectedUrl();
		String homepageExpectedUrl = expectedUrl.getProperty("homepage_expected_url");
		Assert.assertEquals(actualHomepageUrl, homepageExpectedUrl, "Incorrect Homepage Url");
		Reporter.log("Homepage Verified", true); /* true to print on the console; Without boolean condition Log will just generate report */
	}/*----------End of HomePage url verification---------*/

	/*----------Start of HomePage Logo Check---------*/
	public void homePage_LogoCheck() {
		boolean logoDisplayed = logoElement.isDisplayed();
		Assert.assertTrue(logoDisplayed);
		Reporter.log("Logo displayed", true); /* true to print on the console; Without boolean condition Log will just generate report */
	}/*----------End of HomePage Logo Check---------*/

	/*----------HomePage Broken Links Check---------*/
	public void homePage_BrokenLinksCheck() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));

		System.out.println("Homepage Total links are: " + links.size());

		List<WebElement> activeLinks = new ArrayList<WebElement>();

		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).getAttribute("href") != null
					&& (!links.get(i).getAttribute("href").contains("javascript")))
			/* javascript links are excluded that's why kept not equal */
			{
				activeLinks.add(links.get(i));
			}
		}

		System.out.println("Homepage active links are: " + activeLinks.size());

		for (int j = 0; j < activeLinks.size(); j++) 
		{
			try {
				String linkUrl = activeLinks.get(j).getAttribute("href");
				URL url = new URL(linkUrl);
				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
				// httpURLConnection.setConnectTimeout(3000);
				httpURLConnection.connect();
				String response = httpURLConnection.getResponseMessage();
				Reporter.log(activeLinks.get(j).getAttribute("href") + " ----> " + response, true); /* true to print on the console; Without boolean condition Log will just generate report */
				httpURLConnection.disconnect();
				} catch (Exception e) 
				{
	
				}
		}
	}/*----------End of HomePage Links Check---------*/
	
	/*----------Start of searchBoxFunctionalityCheck---------*/
	public void homePage_SearchBoxFunctionalityCheck()
	{
		SharedMethods.type(searchBarElement, driver, "Men");
		String actualSearhPageTile=driver.getTitle();
		Reporter.log(actualSearhPageTile, true); /* true to print on the console; Without boolean condition Log will just generate report */
		driver.navigate().back();
	}/*----------End of searchBoxFunctionalityCheck---------*/
	
	
	/*----------Start of homePage_ClickOnLoginButton---------*/
	public void homePage_ClickOnLoginButton()
	{
		SharedMethods.clickOnElement(loginButtonElement, driver);	
	}/*----------End of homePage_ClickOnLoginButton---------*/
	
	
	/*----------Start of homePage_LoginInfoVerification---------*/
	public void homePage_LoginInfoVerification(Object userName, Object password)
	{
		loginEmailBoxElement.sendKeys(userName.toString());
		loginPasswordBoxElement.sendKeys(password.toString());		
	}/*----------End of homePage_LoginInfoVerification---------*/
	
	public void homePage_ClickOnLoginFormCloseButton()
	{
		SharedMethods.clickOnElement(loginFormCloseElement, driver);
	}
	
	
	/*----------Start of homePage_ClickOnJoinNowButton---------*/
	public void homePage_ClickOnJoinNowButton()
	{
		SharedMethods.clickOnElement(joinNowButtonElement, driver);	
	}/*----------End of homePage_ClickOnJoinNowButton---------*/
	
	
	/*----------Start of homePage_joinNowFormVerification---------*/
	public void homePage_joinNowFormVerification
		(Object email, Object password, Object firstName, Object lastName, Object dateOfBirth, Object countries )
	{
		joinInFormEmailElement.sendKeys(email.toString());
		joinInFormPasswordElement.sendKeys(password.toString());
		joinInFormFirstNameElement.sendKeys(firstName.toString());
		joinInFormLastNameElement.sendKeys(lastName.toString());
		joinInDateOfBirthElement.sendKeys(dateOfBirth.toString());
		SharedMethods.dropdownHandling(joinInCountrySelection, countries);
	}/*----------End of homePage_joinNowFormVerification---------*/
	
	/*----------Start of homePage_ClickOnJoinNowFormCloseButton---------*/
	public void homePage_ClickOnJoinNowFormCloseButton()
	{
		SharedMethods.clickOnElement(joinNowFormCloseButtonElement, driver);	
	}/*----------End of homePage_ClickOnJoinNowFormCloseButton---------*/
	

}
