package org.openqa.selenium.common;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class SeleniumUtils {
	
	
	public void clikandwait(WebDriver driver,String url,long timeout)

	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	
	public void TakeScreenshot(WebDriver driver, String filePath, String fileName) 
	{
		try
		{
		   Reporter.log("Taking Screen Shot of " + fileName);
		    File screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		     FileUtils.copyFile(screenshot, new File(
				filePath+"\\"+ fileName));
		}
		catch (IOException ex)

		{
			Reporter.log("Error in taking Screen Shot of " + fileName);
			ex.printStackTrace();
		}	
		
		
			
	   }	
	}

