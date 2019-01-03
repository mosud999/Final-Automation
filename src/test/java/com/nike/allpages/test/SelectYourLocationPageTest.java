package com.nike.allpages.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nike.all_pages.HomePage;
import com.nike.all_pages.SelectYourLocationPage;
import com.nike.utilities.BaseClass;
import com.nike.utilities.SharedMethods;
import com.signIn.signUp.data_DataProvider.ReadJoinNowFormDatas;
import com.signIn.signUp.data_DataProvider.ReadLoginData;

import page.manager.PageObjectManager;

public class SelectYourLocationPageTest extends BaseClass{
	
	PageObjectManager pageObjectManager;
	HomePage homePage;
	SelectYourLocationPage selectYourLocationPage;
	
	@Test
	public void homePageTest1()
	{
		pageObjectManager=new PageObjectManager(driver);
		homePage=pageObjectManager.getHomePage();
		selectYourLocationPage=homePage.clickOnSelectLocationButton();
		selectYourLocationPage.countriesNameVerification();
	}

}
