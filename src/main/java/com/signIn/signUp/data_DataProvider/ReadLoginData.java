package com.signIn.signUp.data_DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ReadLoginData {
	
	@DataProvider(name="loginData")
	public Object[][] loginDataRead() throws IOException
	{
		Object[][] loginData=DataProviderDataLoadFromExcelFile.dataProvderDatasFromExcelFile("C:\\Users\\User\\workspace\\Nike.Automation\\login_acess_datas.xlsx", 0);
		return loginData;
	}

}
