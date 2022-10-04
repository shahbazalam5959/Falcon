package com.hrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;
	
	public ConfigDataProvider()
	{
		
		File fileSrc = new File("./config.properties");
		
		try {
		
		FileInputStream fis = new FileInputStream(fileSrc);
		
		prop = new Properties();
		
		prop.load(fis);
		}
		
		catch (Exception e) {
			
			System.out.println("Not able to load Config File"+e.getMessage());
		}
	}
	
	 public String getBrowser()
	 {
		 return prop.getProperty("browser");
	 }
	 
	 public String getStatgingUrl()
	 {
		 System.out.println(prop.getProperty("appUrl"));
		 return prop.getProperty("appUrl");
//		 System.out.println(System.getProperty("APPLICATION_BASE_URL"));
//		 return System.getProperty("APPLICATION_BASE_URL");
	 }
	
	 public String getDataFromConfig(String keyToSearch)
	 {
		 return prop.getProperty(keyToSearch);
	 }
	 
}

