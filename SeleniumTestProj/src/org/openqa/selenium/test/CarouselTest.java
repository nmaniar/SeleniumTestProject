package org.openqa.selenium.test;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty7.webapp.WebInfConfiguration;

import com.google.common.base.Predicate;

public class CarouselTest {

	public static void main(String[] args) {
		try {

			WebDriver driver = new FirefoxDriver();
			driver.get("http://www.bbc.com");
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			String cssSelectorString = "ol#promo2_carousel_items_items > li ";
			List<WebElement> linkList = driver.findElements(By.cssSelector(cssSelectorString));
			int totalCount = linkList.size();
			int currentIndex = Integer.parseInt(driver.findElement(By.cssSelector(".carousel .carousel_itemList li.active")).getAttribute("rel"));
			
			for( int i=0; i< totalCount ; i++)
			{
				WebElement nextElement = driver.findElement(By.cssSelector("div .nav_left"));
				nextElement.click();
				//(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeSelected(By.cssSelector(".carousel .carousel_itemList li.active")));
				int selectedIndex = Integer.parseInt(driver.findElement(By.cssSelector(".carousel .carousel_itemList li.active")).getAttribute("rel"));
				System.out.println("SelectedIndex == "+ selectedIndex);
			
				//System.out.println("currentIndex == "+currentIndex+"  newIndex == "+newIndex );
				//currentIndex = newIndex;
				
			}
			
			
			// Close the browser
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	}

