package com.nike.allpages.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nike.all_pages.HomePage;
import com.nike.utilities.BaseClass;
import com.signIn.signUp.data_DataProvider.ReadJoinNowFormDatas;
import com.signIn.signUp.data_DataProvider.ReadLoginData;

public class HomepageTest extends BaseClass{
	
	HomePage homePage;

	/*@Test
	public void homePageTest1()
	{
		homePage=new HomePage(driver);
		//homePage.homePage_UrlVerification();
		//homePage.homePage_LogoCheck();
		//homePage.homePage_SearchBoxFunctionalityCheck();
		//homePage.homePage_BrokenLinksCheck();
	}
	*/
	/*
	@Test(dataProvider="loginData", dataProviderClass=ReadLoginData.class)
	public void homePageTest2(Object userName, Object password)
	{	
		homePage.homePage_ClickOnLoginButton();
		homePage.homePage_LoginInfoVerification(userName, password);
		homePage.homePage_ClickOnLoginFormCloseButton();	
	}*/
	
	@Test(dataProvider="joinNowFormData", dataProviderClass=ReadJoinNowFormDatas.class) // if data provider from different class we haveto mention the class name
	public void homePageTest3(Object email,Object password,Object firstName,Object lastName)
	{	
		homePage=new HomePage(driver);
		homePage.homePage_ClickOnLoginButton();
		homePage.homePage_ClickOnJoinNowButton();
		homePage.homePage_joinNowFormVerification(email,password,firstName,lastName);
		homePage.homePage_ClickOnJoinNowFormCloseButton();
	
	}


}
