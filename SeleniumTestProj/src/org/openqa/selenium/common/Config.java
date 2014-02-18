package org.openqa.selenium.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.internal.PropertiesFile;

public class Config {
	
 public static boolean initFlag = false;
 public static String driverType;
 public static String driverProperty;
 public static String baseUrl;
 public static String navLinkCSS;
 public static String navOutDir;
	
	public static void InitializeProperties()
	{
		
		Properties prop = new Properties();
		InputStream input = null;
	 
		try 
		{
	 
			input = new FileInputStream("C:\\Users\\Nilang\\workspace\\SeleniumTestProj\\bin\\org\\openqa\\selenium\\common\\config.properties");
	       	prop.load(input);
	        initFlag = true;
	        
	        driverType = prop.getProperty("Driver.Type");
	        driverProperty = prop.getProperty("Driver.Property");
	        baseUrl = prop.getProperty("Driver.Url");
	        navLinkCSS = prop.getProperty("Navigation.LinkCSS");
	        navOutDir = prop.getProperty("Navigation.Output.Dir");
	        		
			// get the property value and print it ou"t
			System.out.println(driverType);
			System.out.println(driverProperty);
			System.out.println(baseUrl);
	 
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		} 
		finally 
		{
			if (input != null) 
			{
				try
				{
					input.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			
		}
		
	}	
			


}
