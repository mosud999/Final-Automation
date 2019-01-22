package com.signIn.signUp.data_DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ReadSearchingData {
	
	@DataProvider(name="readSearchingData")
	public Object[][] readSearchingData() throws IOException
	{
		Object[][] searchingData=DataProviderDataLoadFromExcelFile.dataProvderDatasFromExcelFile("C:\\Users\\User\\workspace\\Nike.Automation\\searchingExpectedData.xlsx", 0);
		return searchingData;
		
	}

}
