package core;

public class Configurations {
	public static Browsers browser = Browsers.CHROME;

	public enum Browsers {
		CHROME, FIREFOX
	}

	// Project base directories
	public static String userDir = System.getProperty("user.dir");
	
	// Drivers path. Make sure to add ".exe" if you are using Windows based OS
	public static String chromeDriverPath = System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver";
	public static String firefoxDriverPath = System.getProperty("user.dir") + "/src/main/resources/driver/geckodriver";

}
