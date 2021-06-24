package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

	/**
	 * Access the main system url
	 */
	public void accessLoginPage() {
		accessUrl(baseURL);
	}

	/**
	 * Compare url to see if it's login url
	 */
	public Boolean compareUrlToLoginPage() {
		String currentUrl = getCurrentUrl();
		return currentUrl.contentEquals(baseURL);
	}

	/**
	 * Fill out the username
	 * 
	 */
	public void insertUsername(String text) {
		By username = By.id("username");
		waitForElementToBeVisible(username, MAX_TIME);
		writeTextInField(username, text);
	}

	/**
	 * Fill out the password
	 * 
	 * @param text the password
	 */
	public void insertPassword(String text) {
		By password = By.id("password");
		writeTextInField(password, text);
	}

	/**
	 * Press login button
	 * 
	 * @param text the password
	 * @throws InterruptedException
	 */
	public void clickLogin() throws InterruptedException {
		clickElement(By.xpath("//button"));
	}

	/**
	 * Erro no login
	 */
	public void errorLogin() {
		elementExists(By.xpath("//div[@class='flash error']"), true);
	}

}