package org.openqa.selenium.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GetLinks {

	WebDriver mydriver = null;

	public GetLinks(WebDriver driver) {
		mydriver = driver;
	}

	public void getanddisplayLinks() {

		try {

			List<WebElement> componentList = mydriver.findElements(By
					.cssSelector("ul#blq-nav-main > li > a"));

			int numberOfElementsFound = getNumberOfElementsFound(By
					.cssSelector("ul#blq-nav-main > li > a"));

			for (int pos = 0; pos < numberOfElementsFound; pos++) {

				try {

					if (getElementWithIndex(
							By.cssSelector("ul#blq-nav-main > li > a"), pos)
							.isDisplayed()) {

						// getElementWithIndex(By.tagName("a"), pos).click();
						WebElement element = getElementWithIndex(
								By.cssSelector("ul#blq-nav-main > li > a"), pos);
						element.click();

						mydriver.navigate().to("http://www.bbc.com");

						System.out.println("Page title is: "
								+ mydriver.getTitle());
						;

					}
				} catch (Exception ex) {
					System.out.println("Error at index " + pos);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List getLinkText(String cssSelectorString) {

		ArrayList navLinkText = new ArrayList<>();
		// List<WebElement> linkList = mydriver.findElements(By
		// .cssSelector("ul#blq-nav-main > li > a"));

		List<WebElement> linkList = mydriver.findElements(By
				.cssSelector(cssSelectorString));

		int numberOfElementsFound = getNumberOfElementsFound(By
				.cssSelector(cssSelectorString));
       
		for (int pos = 0; pos < numberOfElementsFound; pos++) {
			try {
				
				if (getElementWithIndex(By.cssSelector(cssSelectorString), pos).isDisplayed()) {
                
                	
					navLinkText.add(getElementWithIndex(
							By.cssSelector(cssSelectorString), pos).getText());
					System.out.println(getElementWithIndex(By.cssSelector(cssSelectorString),pos).getText());

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return navLinkText;
	}

	public int getNumberOfElementsFound(By by) {
		return mydriver.findElements(by).size();
	}

	public WebElement getElementWithIndex(By by, int pos) throws Exception {
		try {
			return mydriver.findElements(by).get(pos);

		}

		catch (Exception ex) {
			throw ex;
		}

	}
}
