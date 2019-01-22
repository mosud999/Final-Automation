package com.nike.allpages.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nike.all_pages.HomePage;
import com.nike.utilities.BaseClass;
import com.nike.utilities.SharedMethods;
import com.signIn.signUp.data_DataProvider.ReadJoinNowFormDatas;
import com.signIn.signUp.data_DataProvider.ReadLoginData;
import com.signIn.signUp.data_DataProvider.ReadSearchingData;

import page.manager.PageObjectManager;

public class HomepageTest extends BaseClass{
	
	PageObjectManager pageObjectManager;
	HomePage homePage;
	
	/*
	@Test

	public void homePageTest1() throws InterruptedException
	{
		pageObjectManager=new PageObjectManager(driver);
		homePage=pageObjectManager.getHomePage();
		homePage.homePage_UrlVerification();
		homePage.homePage_LogoCheck();
		homePage.typeOnSearchBox();
		//homePage.mouseHoverOnMenMenu();
		//homePage.clickOnColdWeatherEssentialSubMenu();
		//homePage.homePage_SearchBoxFunctionalityCheck();
		//homePage.homePage_BrokenLinksCheck();
	}*/
	
	
	
	 /* Read and Check datas by using data provider */
	/*
	@Test(dataProvider="loginData", dataProviderClass=ReadLoginData.class)
	public void homePageTest2(Object userName, Object password)
	{	pageObjectManager=new PageObjectManager(driver);
		homePage.homePage_ClickOnLoginButton();
		homePage.homePage_LoginInfoVerification(userName, password);
		homePage.homePage_ClickOnLoginFormCloseButton();	
	}
	*/
	
	/* For data provider, if you create diifferent class for @DataProvider then you have to add that class also; */
	/* To read any excel sheet always create a new one, do not copy from existing one; otherwise it will throw an exception;*/
	
	/*@Test(dataProvider="joinNowFormData", dataProviderClass=ReadJoinNowFormDatas.class) 
	public void homePageTest3(Object email, Object password, Object firstName, Object lastName, Object joinInDateOfBirthElement, Object countries)
	{	pageObjectManager=new PageObjectManager(driver);
	    homePage=pageObjectManager.getHomePage();
		homePage.homePage_ClickOnLoginButton();
		homePage.homePage_ClickOnJoinNowButton();
		homePage.homePage_joinNowFormVerification(email,password, firstName, lastName, joinInDateOfBirthElement, countries);
		homePage.homePage_ClickOnJoinNowFormCloseButton();
		
	
	}*/
	
	@Test(dataProvider="readSearchingData", dataProviderClass=ReadSearchingData.class)
	public void homePageTest1(Object searchingData, Object expectedSearchingUrl) throws InterruptedException
	{
		pageObjectManager=new PageObjectManager(driver);
		homePage=pageObjectManager.getHomePage();
		//homePage.homePage_UrlVerification();
		//homePage.homePage_LogoCheck();
		homePage.typeOnSearchBox(searchingData, expectedSearchingUrl);
		
	}
	
	
	
	


}
