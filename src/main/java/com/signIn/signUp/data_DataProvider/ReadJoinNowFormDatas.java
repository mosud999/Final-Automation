package com.signIn.signUp.data_DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ReadJoinNowFormDatas {
	
	@DataProvider(name="joinNowFormData")
	public Object[][] joinNowFormDataRead() throws IOException
	{
		Object [][] signUpData=DataProviderDataLoadFromExcelFile.dataProvderDatasFromExcelFile("C:\\Users\\User\\workspace\\Nike.Automation\\joinNow_form_datas.xlsx", 0);
		return signUpData;
	}

}
