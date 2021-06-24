package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.Data;
import maps.BaseMap;

public class BasePage implements Data {

	public BasePage() {
		super();
	}

	/**
	 * Access the given url
	 * 
	 * @param link Url to be accessed
	 */
	public void accessUrl(String link) {
		getDriver().get(link);
	}
	
	/**
	 * Get current url
	 * 
	 */
	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

	/**
	 * Write a text in a field
	 * 
	 * @param locator Field locator where the text will by typed
	 * @param text   Text to be typed
	 */
	public void writeTextInField(By locator, String text) {
		getDriver().findElement(locator).sendKeys(text);
	}

	/**
	 * Click on a element
	 * 
	 * @param locator Element locator
	 */
	public void clickElement(By locator) {
		WebElement element = getDriver().findElement(locator);
		moveToElementJS(element);
		element.click();
	}

	/**
	 * Click on an element using a JS function
	 * 
	 * @param locator Element locator
	 */
	public void clickElementJS(By locator) {
		WebElement element = getDriver().findElement(locator);
		JavascriptExecutor ex = (JavascriptExecutor) getDriver();
		moveToElementJS(element);
		ex.executeScript("arguments[0].click()", element);
	}

	/**
	 * Forced wait
	 * 
	 * @param time Time is seconds
	 */
	public void forcedWait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Wait for an element to be clickable
	 * 
	 * @param locator Element locator
	 * @param time    Max waiting time
	 */
	public void waitForElementToBeClickable(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * Wait for an element to be visible
	 * 
	 * @param locator Element locator
	 * @param time    Max waiting time
	 */
	public void waitForElementToBeVisible(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(getDriver(), time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Validate if an element exists and is displayed, or if it does not exist
	 * 
	 * @param locator     Element locator
	 * @param shouldExist True or false
	 * 
	 * @return True or false
	 */
	public boolean elementExists(By locator, boolean shouldExist) {
		if (shouldExist) {
			waitForElementToBeVisible(locator, MAX_TIME);
			return getDriver().findElements(locator).size() > 0 && getDriver().findElement(locator).isDisplayed();
		} else {
			waitForElementToBeVisible(locator, MIN_TIME);
			return getDriver().findElements(locator).size() == 0;
		}
	}

	/**
	 * Click on a button by text
	 * 
	 * @param text Text on the button
	 */
	public void clickButtonByText(String text) {
		By button = BaseMap.elementByTypeAndText("button", text);
		waitForElementToBeClickable(button, MAX_TIME);
		clickElementJS(button);
	}

	/**
	 * Move to an element before interacting with it, using JavaScript
	 * 
	 * @param element Web element
	 */
	public void moveToElementJS(WebElement element) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	/**
	 * Scroll to the bottom of the page 
	 */
	public void scrollToPageBottom(){
		((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
}