package com.nike.all_pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SelectYourLocationPage {

	WebDriver driver;

	@FindBy(xpath = "//span[@class='lang-tunnel__region-name-text']")
	List<WebElement> actualCountriesNameElement;

	/*----------Constructor---------*/
	public SelectYourLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}/*----------End of Constructor---------*/

	/*----------Start of countriesNameVerification---------*/
	public void countriesNameVerification() {
		String[] expectedCountriesNameElement = { "NORTH AMERICA", "SOUTH AMERICA", "EUROPE", "ASIA PACIFIC",
				"MIDDLE EAST", "AFRICA" };
		
		ArrayList actList = countriesActualNamesFromWebsite(actualCountriesNameElement);
		ArrayList expList = countriesExpectedNamesListFromFile(expectedCountriesNameElement);

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

	public ArrayList<String> countriesExpectedNamesListFromFile(String[] expectedCountriesNames) {
		ArrayList<String> expectedList = new ArrayList<String>();
		for (String e1 : expectedCountriesNames) {
			expectedList.add(e1);
			System.out.println(e1);
		}
		return expectedList;
	}

}/*----------End of countriesNameVerification---------*/
