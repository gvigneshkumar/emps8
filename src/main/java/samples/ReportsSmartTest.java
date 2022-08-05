package samples;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class ReportsSmartTest {
	public static ExtentReports extentReports = new ExtentReports();
	public static ExtentSparkReporter extentSpark = new ExtentSparkReporter("Klovreport.html");
	ExtentSparkReporter failedcases = new ExtentSparkReporter("Failed cases. html");
	ExtentSparkReporter skiped = new ExtentSparkReporter("Skiped casex .html");
	public static WebDriver driver;
	//
	// public static ExtentTest extentTest;
	// public static ExtentTest extentTest = extentReports.createTest("launching
	// url");

	@Test(priority = 1)
	public static void FristClass() throws IOException {
		ExtentTest extentTest = extentReports.createTest("Valied Username Password");
		extentReports.attachReporter(extentSpark);
		System.setProperty("webdriver.chrome.driver", "/home/promantus/eclipse-workspace/Report/exe2/chromedriver");

//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox");
//		options.addArguments("--headless");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--window-size=1920x1080");
//		driver = new ChromeDriver(options);

		//driver.manage().window().maximize();
			   // driver.get("https://www.google.com");
			    driver = new ChromeDriver();
		try {

			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.manage().window().maximize();
			WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
			findElement.sendKeys("vigneshkumar@promantus.com");
			extentTest.log(Status.PASS, "User field is visible UserName is enter");
			WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
			findElement2.sendKeys("4916ui");
			extentTest.info("Password field is present ");
			WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
			findElement3.click();
			extentTest.info(" Sucessfully clicked");
			driver.findElement(By.xpath("//span[text()='SOS Panel ']")).click();
			extentTest.assignAuthor("Kowsika Team");

//			TakesScreenshot screenshot = ((TakesScreenshot) driver);
//			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
//			// String string = screenshotAs.toString();
//			File file = new File("screen" + ".png");
//			FileUtils.copyFile(screenshotAs, file);
//			String string = file.toString();
//			extentTest.addScreenCaptureFromPath(string);
			// extentTest.log(Status.PASS, "Launching testCase is Pass");

			// driver.quit();

		} catch (Exception e) {

			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
			// extentTest.log(Status.PASS, "Launching testCase is Pass");

			TakesScreenshot screenshot1 = ((TakesScreenshot) driver);
			File screenshotAs1 = screenshot1.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file1 = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string1 = file1.toString();
			extentTest.log(Status.FAIL, e);
//			extentTest.log(Status.FAIL, "error occured").addScreenCaptureFromBase64String(string1).getExtent()
//					.addTestRunnerOutput(string1);
			extentTest.addScreenCaptureFromPath(string1);

		}
		driver.quit();
	}

	@Test(priority = 2)
	public void WrongPass() throws IOException {
		ExtentTest extentTest = extentReports.createTest("Valied UserName Invalied PassWord");
		System.setProperty("webdriver.chrome.driver", "/home/promantus/eclipse-workspace/Report/exe2/chromedriver");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox");
//		options.addArguments("--headless");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--window-size=1920x1080");
//		driver = new ChromeDriver(options);
		  driver = new ChromeDriver();

		try {
			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.manage().window().maximize();
			WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
			findElement.sendKeys("vigneshkumar@promantus.com");
			extentTest.log(Status.PASS, " UserName field is visible Sucessfully enter a UserName ");
			WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
			findElement2.sendKeys(" 12345 ");
			extentTest.info(" Password field is present ");
			WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
			findElement3.click();
			extentTest.info(" Sucessfully clicked login Button ");
			extentTest.assignCategory(" Selenium Testing ");
			System.out.println(" test case 2 is completed sucessfully ");

		} catch (Exception e) {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
		}
		System.err.println(" test case 2 is completed Having one issue ");

		driver.quit();
	}

	@Test(priority = 3)
	public void WrongUserName() throws IOException {
		ExtentTest extentTest = extentReports.createTest(" Invalied UserName Valied PassWord ");
		System.setProperty("webdriver.chrome.driver", "/home/promantus/eclipse-workspace/Report/exe2/chromedriver");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox");
//		options.addArguments("--headless");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--window-size=1920x1080");
//		driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		try {
			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.manage().window().maximize();
			WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
			findElement.sendKeys("vignesh@promantus.com");
			extentTest.log(Status.PASS, " User field is visible UserName is enter ");
			WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
			findElement2.sendKeys("4916ui");
			extentTest.info("Password field is present ");
			WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
			findElement3.click();
			extentTest.info(" Sucessfully clicked");
			extentTest.assignCategory("Selenium Testing");
			System.out.println("test case 3 is completed sucessfully");

		} catch (Exception e) {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
			System.err.println("test case 3 is completed Having one issue");
		}

		driver.quit();
	}

	@Test(priority = 4)
	public void emptyUserName() throws IOException {
		ExtentTest extentTest = extentReports.createTest("Empty Username Correct password");
		System.setProperty("webdriver.chrome.driver", "/home/promantus/eclipse-workspace/Report/exe2/chromedriver");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox");
//		options.addArguments("--headless");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--window-size=1920x1080");
//		driver = new ChromeDriver(options);
		 driver = new ChromeDriver();
		try {

			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.manage().window().maximize();
			WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
			findElement.sendKeys("  ");
			extentTest.log(Status.PASS, "User field is visible UserName is enter");
			WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
			findElement2.sendKeys("4916ui");
			extentTest.info("Password field is present ");
			WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
			findElement3.click();
			driver.findElement(By.xpath("//span[text()='SOS Panel ']")).click();

			extentTest.info(" Sucessfully clicked");
			extentTest.assignCategory("Selenium Testing");
			System.out.println("test case 4 is completed sucessfully");

		} catch (Exception e) {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
			extentTest.log(Status.FAIL, "error occures 4");
			extentTest.log(Status.FAIL, e);
			System.err.println("test case 4 is completed Having one issue");

		}

		driver.quit();
	}

	@Test(priority = 5)
	public void emptyPass() throws IOException {
		ExtentTest extentTest = extentReports.createTest("Correct username and Empty Password");
		System.setProperty("webdriver.chrome.driver", "/home/promantus/eclipse-workspace/Report/exe2/chromedriver");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox");
//		options.addArguments("--headless");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--window-size=1920x1080");
//		driver = new ChromeDriver(options);
		 driver = new ChromeDriver();
		try {
			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.manage().window().maximize();
			WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
			findElement.sendKeys("vigneshkumar@promantus.com");
			extentTest.log(Status.PASS, "User field is visible UserName is enter");
			WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
			findElement2.sendKeys("   ");
			extentTest.info("Password field is present ");
			WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
			findElement3.click();
			extentTest.info(" Sucessfully clicked");
			System.out.println("test case 5 is completed sucessfully");
		} catch (Exception e) {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
			System.err.println("test case 5 is completed Having one issue");

		}

		driver.quit();

	}

	@Test(priority = 6)
	public void bothEmptyField() throws IOException {
		ExtentTest extentTest = extentReports.createTest("Both field are empty ");

		System.setProperty("webdriver.chrome.driver", "/home/promantus/eclipse-workspace/Report/exe2/chromedriver");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox");
//		options.addArguments("--headless");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--window-size=1920x1080");
//		driver = new ChromeDriver(options);
		 driver = new ChromeDriver();
		try {
			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.manage().window().maximize();
			WebElement findElement = driver.findElement(By.xpath("//input[@name='username']"));
			findElement.sendKeys("  ");
			extentTest.log(Status.PASS, "User field is visible UserName is enter");
			WebElement findElement2 = driver.findElement(By.xpath("//input[@type='password']"));
			findElement2.sendKeys("  ");
			extentTest.info("Password field is present ");
			WebElement findElement3 = driver.findElement(By.xpath("//span[text()='Login']"));
			findElement3.click();
			extentTest.info(" Sucessfully clicked");
			extentTest.assignCategory("Selenium Testing");
			extentTest.assignAuthor(" Kowsika Team ");
			extentTest.assignDevice("chrome").getExtent();
			System.out.println("test case 6 is completed sucessfully");

		} catch (Exception e) {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
			System.err.println("test case 6 is completed Having one issue");

		}

		driver.quit();
	}

	@Test(priority = 7)
	public void forgetPassWord() throws IOException {
		System.setProperty("webdriver.chrome.driver", "/home/promantus/eclipse-workspace/Report/exe2/chromedriver");
		ExtentTest extentTest = extentReports.createTest("Forget PassWord ");
//		ChromeOptions options = new ChromeOptions();
//	    options.addArguments("--no-sandbox");
//	    options.addArguments("--headless");
//	    options.addArguments("--disable-dev-shm-usage");
//	    options.addArguments("--window-size=1920x1080");
//	    driver = new ChromeDriver(options);
		driver = new ChromeDriver();

		try {
			driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");
			driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
			extentTest.log(Status.PASS, "Click forget password ");
			System.out.println("test case 7 is completed sucessfully");
		} catch (Exception e) {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			// String string = screenshotAs.toString();
			File file = new File("screen" + ".png");
			FileUtils.copyFile(screenshotAs, file);
			String string = file.toString();
			extentTest.addScreenCaptureFromPath(string);
			System.err.println("test case 7 is completed Having one issue");

		}
		driver.quit();

	}

	@BeforeTest
	public void beforeTest() throws IOException {
//		extentTest.skip("made skip");
//		extentTest.assignAuthor("kowsika").assignCategory("testing team");

	}

	@AfterTest
	public void afterTest() {
		extentReports.flush();
	}

	@BeforeMethod
	public void beforemethod() throws IOException {
		// extentTest.log(Status.FAIL, "before method is not executed ").getStatus();
		// System.out.println("hello value ");

	}

	@AfterMethod
	public void afterMethod() {
		// extentTest.log(Status.PASS, "sucessfully launch before method");
		// System.out.println("hello 2 ");
	}

}
