package org.openqa.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  driver = new FirefoxDriver();
	  driver.get("http://www.bbc.com");
  }

  @AfterSuite
  public void afterSuite() {
	  
	  driver.quit();
  }

}
