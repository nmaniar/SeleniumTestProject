package org.openqa.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Selenium;

public class WeatherContainerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.bbc.com");
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("edit")));
		driver.findElement(By.className("edit")).click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("searchPanelSearch")));
		WebElement searchText = driver.findElement(By.className("searchPanelSearch"));
		searchText.sendKeys("Oval, Greater London");
		driver.findElement(By.className("submit")).click();;
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.textToBePresentInElement(By.tagName("a"),"Oval, Greater London" ));
		driver.quit();
		
		
	}
	
	

}
