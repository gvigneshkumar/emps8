package baseMethod;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	static ExtentReports extentReports = new ExtentReports();
	ExtentSparkReporter extentSpark = new ExtentSparkReporter("Klovreport.html");
	static ExtentTest extentTest = extentReports.createTest("launching url");
	public static WebDriver driver = new ChromeDriver();

	public static void screenShort(String ScreenShortFilename) throws IOException {

		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		// String string = screenshotAs.toString();
		File file = new File(ScreenShortFilename);
		FileUtils.copyFile(screenshotAs, file);
		String string = file.toString();
		extentTest.addScreenCaptureFromPath(string);

	}
}
