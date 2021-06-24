package maps;

import org.openqa.selenium.By;

public class BaseMap {

	/**
	 * Creates a locator by xpath in the format: //type[text()='text']
	 * Example: type = button, text = Accept -> Returns //button[text()='Accept']
	 * 
	 * @param type Element DOM type, example: span, div, button...
	 * @param text The text in the element
	 * 
	 * @return The locator by xpath
	 */
	public static By elementByTypeAndText(String type, String text) {
		return By.xpath("//" + type + "[text()='" + text + "']");
	}
}
