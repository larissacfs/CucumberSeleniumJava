package pages;

import org.openqa.selenium.By;

import maps.SecureAreaMap;

public class SecureAreaPage extends BasePage {

	SecureAreaMap secureAreaMap;
	
	/**
	 * Access the main system url
	 */
	public void accessLoginPage() {
		accessUrl(baseURL);
	}

	/**
	 * confirm that we're at the Secure Area
	 * 
	 */
	public void confirmInSecureArea() {
		elementExists(By.xpath("//h2[text()=' Secure Area']"), true);
		elementExists(By.xpath("//h4[text()='Welcome to the Secure Area. When you are done click logout below.']"), true);
	}

}