package baseMethod;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReportsNewTest extends BaseClass {
	// WebDriver driver = new ChromeDriver();
	@BeforeTest

	@Test
	public void CrtNameWrongPassTest() {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "/home/promantus/eclipse-workspace/Report/exe/chromedriver");
		driver.get("www.google.com");
	}

	@Test
	public void generatReportTest() {
		//driver.get("www.amazon.com");
	}

	@Test
	public void getUrlTest() {
		//driver.get("www.flipkart.com");
	}
}
