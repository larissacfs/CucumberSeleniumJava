package utils;

import static core.DriverFactory.getDriver;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeScreenshotUtils {	
	@Rule
	public static TestName testName = new TestName();

	private static String folder = DataAndTimeUtils.getTime();

	public TakeScreenshotUtils() {
		createFolder();
	}

	/**
	 * Take a screenshot
	 * 
	 * @param step The name of the file you want to save
	 */
	public static void TakeScreenshot(String step, String scenario) {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, 
					new File(
							System.getProperty("user.dir") + 
							"/src/main/resources/screenshots/" + folder + "/" + scenario + "/" +  step + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the folder to insert all screenshots that are being take in a scenario
	 */
	private void createFolder() {
		File file = new File(folder);
		file.mkdir();
	}

}
