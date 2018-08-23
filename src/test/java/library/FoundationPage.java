package library;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FoundationPage {
	
	public static WebDriver driver;

	@Before
	public void beforeEachTest() throws Exception {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println("***TEST HAS STARTED***");

	}

	@After
	public void afterEachTest() throws Exception {
		Thread.sleep(5000);
			driver.close();
			driver.quit();
			System.out.println("***TEST HAS BEEN COMPLETE***");
	}
}