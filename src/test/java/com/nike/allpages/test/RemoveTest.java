package com.nike.allpages.test;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.listeners.customizing.report.TestNGListeners;
import com.nike.all_pages.HomePage;
import com.nike.utilities.BaseClass;
import com.nike.utilities.SharedMethods;
import com.signIn.signUp.data_DataProvider.ReadJoinNowFormDatas;
import com.signIn.signUp.data_DataProvider.ReadLoginData;
import com.signIn.signUp.data_DataProvider.ReadSearchingData;

import page.manager.PageObjectManager;


@Listeners(TestNGListeners.class)
public class RemoveTest extends BaseClass{
	
	//PageObjectManager pageObjectManager;
	HomePage homePage;
	
	
	@Test
	public void homePageTest1() throws InterruptedException
	{
		//pageObjectManager=new PageObjectManager(driver);
		homePage=new HomePage(driver);
		//homePage=pageObjectManager.getHomePage();
		homePage.homePage_UrlVerification();
		homePage.homePage_LogoCheck();
		//homePage.typeOnSearchBox();
		//homePage.mouseHoverOnMenMenu();
		//homePage.clickOnColdWeatherEssentialSubMenu();
		//homePage.homePage_SearchBoxFunctionalityCheck();
		//homePage.homePage_BrokenLinksCheck();
	}
	

}
