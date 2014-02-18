package org.openqa.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.common.Config;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.test.NavigationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BBC_TestCases {
	
	WebDriver driver;
  @Test
  public void NavigationTestCase() throws Exception {
	  
	 try
	 {
	  NavigationTest  navtest = new NavigationTest();
	  navtest.CheckNavigation(driver);
	  Assert.assertTrue(true);
	 }
	 catch (Exception ex)
	 {
		 ex.printStackTrace();
		 Assert.fail();
	 }
	  
	 
  }
  @BeforeClass
  public void beforeClass() {
	  
	  
	  if(!Config.initFlag)
		       Config.InitializeProperties();
	 
	  if(Config.driverType.equalsIgnoreCase("FireFox"))
	                           driver = new FirefoxDriver();
	  else
	  {
	     System.setProperty("webdriver.chrome.driver", Config.driverProperty);
	      driver = new ChromeDriver(); 
	  }   
	 // 
	  
	 
	  
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  
  }

  @AfterSuite
  public void afterSuite() {
	  
	 
  }

}
