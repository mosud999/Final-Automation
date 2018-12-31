package com.nike.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	
	// Code for loading the configuration file;
	public static Properties readConfigFile(String config_file) throws IOException
	{
		File file=new File(config_file);
		FileInputStream fileStream=new FileInputStream(file);
		Properties properties=new Properties();
		properties.load(fileStream);
		return properties;
	
		
	}

}
