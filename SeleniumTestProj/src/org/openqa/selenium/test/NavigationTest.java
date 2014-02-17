package org.openqa.selenium.test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.CSS;

import org.apache.commons.io.FileUtils;
import org.openqa.jetty.html.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationTest {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
    public void CheckNavigation(WebDriver driver) throws Exception
     {
		try {

			
			String cssSelectorString = "ul#blq-nav-main > li > a";
			GetLinks links = new GetLinks(driver);
			List linkText = links.getLinkText(cssSelectorString);
			
			for (int i = 0; i < linkText.size(); i++) {
				
				driver.get("http://www.bbc.com");
				driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				String link = (String) linkText.get(i);
				driver.findElement(By.linkText(link)).click();
				System.out.println(driver.getTitle());
				(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleContains(link));
				//driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				System.out.println("Taking Screen Shot of " + link);
				File screenshot = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File(
						"C:\\Users\\Nilang\\Pictures\\scr_" + link + ".jpg"));

			}
			// Close the browser
			driver.close();
		} catch (Exception e) {
			
			throw e;
		}

	}

}
