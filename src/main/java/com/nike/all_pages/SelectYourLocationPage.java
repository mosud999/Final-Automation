package com.nike.all_pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import org.testng.Reporter;
import com.signIn.signUp.data_DataProvider.ExpectedLocationList;

public class SelectYourLocationPage extends LoadableComponent<SelectYourLocationPage> {

	WebDriver driver;

	@FindBy(xpath = "//span[@class='lang-tunnel__region-name-text']")
	List<WebElement> actualCountriesNameElement;

	/*----------Constructor---------*/
	public SelectYourLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}/*----------End of Constructor---------*/

	/*----------Start of countriesNameVerification---------*/
	public void countriesNameVerification() throws IOException {
		
		
		ArrayList actList = countriesActualNamesFromWebsite(actualCountriesNameElement);
		ArrayList expList = countriesExpectedNamesListFromFile();

		int actualCountriesNumber = actList.size();
		int expectedCountriesNumber = expList.size();

		if (actualCountriesNumber == expectedCountriesNumber) 
		{
			Iterator actualIterator = actList.iterator();
			Iterator expectedIterator = expList.iterator();

			while (actualIterator.hasNext() && expectedIterator.hasNext()) {

				Object obj1 = actualIterator.next();
				Object obj2 = expectedIterator.next();

				if (obj1.equals(obj2)) {
					Reporter.log("Actual Country " + obj1 + " is equal to Expected Country " + obj2, true);
				} else
				{
					Reporter.log("Actual Country " + obj1 + " is not matched Expected Country " + obj2, true);
				}

			}

		} else {
			Reporter.log("Actual country names number does not matched with Expected", true);
		}

	}

	public ArrayList<String> countriesActualNamesFromWebsite(List<WebElement> actualCountriesNames) {
		ArrayList<String> actualList = new ArrayList<String>();
		for (WebElement e : actualCountriesNames) {

			String aNames = e.getText();
			actualList.add(aNames);
		}
		return actualList;
	}

	public ArrayList<String> countriesExpectedNamesListFromFile() throws IOException {
		ArrayList<String> expectedList = new ArrayList<String>();
		Object[][] a=ExpectedLocationList.expectedLocationList();
		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<a[i].length; j++)
			{
				expectedList.add(a[i][j].toString());
			}
		}
		return expectedList;
	}

	/*----------Start of countriesNameVerification page verification---------*/
	@Override
	protected void isLoaded() throws Error 
	{	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.nike.com/language_tunnel";
		Assert.assertTrue(actualUrl.equals(expectedUrl));
		Reporter.log("Loaded Page Title is : " +actualUrl, true);
	}

	@Override
	protected void load() throws Error 
	{
		driver.get("https://www.nike.com/us/en_us");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		driver.navigate().to("https://www.nike.com/us/en_us");
		Reporter.log("Unloaded Current Page ", true);
			
	}
  }/*----------End of countriesNameVerification---------*/
