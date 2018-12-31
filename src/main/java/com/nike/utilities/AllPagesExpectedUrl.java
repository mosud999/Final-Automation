package com.nike.utilities;

import java.io.IOException;
import java.util.Properties;

public class AllPagesExpectedUrl {
	
	static Properties expectedUrlsFile;
	
	public static Properties allPagesExpectedUrl()
	{
	
			
			try {
				expectedUrlsFile = ReadConfigFile.readConfigFile("C:\\Users\\User\\workspace\\Nike.Automation\\expectedData.properties");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return expectedUrlsFile;
		
		
	}

}
