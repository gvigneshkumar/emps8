package baseMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReportsNew {
	public static WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void getUrl() {
		System.setProperty("webdriver.chrome.driver", "/home/promantus/eclipse-workspace/Report/exe/chromedriver");
		// driver = new ChromeDriver();
		driver.get("https://dashboard-emps.g10.pw/organization/transport-manager/login");

	}

//	@Test
//	public void CrtloginNamePass() {
//
//	}

	@Test
	public void CrtNameWrongPass() {
		driver.get("https://www.google.com/");
	}

	@AfterTest
	public void generatReport() {
		System.out.println("value");
	}
}
