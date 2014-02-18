package org.openqa.selenium.test;

import java.io.File;
import java.util.ArrayList;
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
import org.openqa.selenium.common.Config;
import org.openqa.selenium.common.SeleniumUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class NavigationTest {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
    public void CheckNavigation(WebDriver driver) 
     {
	
			
			SeleniumUtils selenium = new SeleniumUtils();
			
			selenium.clikandwait(driver, Config.baseUrl, 7);
			driver.manage().deleteAllCookies();     // delete all cookies
			
			List linkText = getLinkText(driver,Config.navLinkCSS);
			
			for (int i = 0; i < linkText.size(); i++) {
				
				if (i > 0) // First time bbc home page is already open.
				   selenium.clikandwait(driver, Config.baseUrl, 7);
				
				String linkName = (String) linkText.get(i);
				driver.findElement(By.linkText(linkName)).click();
				Reporter.log("Click on "+ linkName + ". New Page title set to "+driver.getTitle());
				
				(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleContains(linkName));
				
								
				selenium.TakeScreenshot(driver,Config.navOutDir ,linkName);

			}
			// Close the browser
			driver.close();
		
	}
   
    public List getLinkText(WebDriver driver,String cssSelectorString) {

		ArrayList navLinkText = new ArrayList<>();
		// List<WebElement> linkList = mydriver.findElements(By
		// .cssSelector("ul#blq-nav-main > li > a"));

		List<WebElement> linkList = driver.findElements(By
				.cssSelector(cssSelectorString));

		int numberOfElementsFound = getNumberOfElementsFound(driver,By
				.cssSelector(cssSelectorString));
       
		for (int pos = 0; pos < numberOfElementsFound; pos++) {
			try {
				
				if (getElementWithIndex(driver,By.cssSelector(cssSelectorString), pos).isDisplayed()) {
                
                	
					navLinkText.add(getElementWithIndex(driver,
							By.cssSelector(cssSelectorString), pos).getText());
					System.out.println(getElementWithIndex(driver,By.cssSelector(cssSelectorString),pos).getText());

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return navLinkText;
	}

	public int getNumberOfElementsFound(WebDriver driver,By by) {
		return driver.findElements(by).size();
	}

	public WebElement getElementWithIndex(WebDriver driver,By by, int pos) throws Exception {
		try {
			return driver.findElements(by).get(pos);

		}

		catch (Exception ex) {
			throw ex;
		}

	}
}
