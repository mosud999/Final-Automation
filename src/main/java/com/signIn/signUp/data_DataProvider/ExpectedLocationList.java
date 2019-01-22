package com.signIn.signUp.data_DataProvider;

import java.io.IOException;

public class ExpectedLocationList {
	
	public static Object[][] expectedLocationList() throws IOException
	{
		Object[][] serachData=DataProviderDataLoadFromExcelFile.dataProvderDatasFromExcelFile("C:\\Users\\User\\workspace\\Nike.Automation\\locationsList.xlsx", 0);
		return serachData;
	}

}
