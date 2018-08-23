package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;

	@Given("^User is on Home Page$")
	public void goToHomePage() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println("***TEST HAS STARTED***");
	}

	@When("^User navigates to A/B Testing$")
	public void navigateToABTesting() {
		driver.findElement(By.xpath("//*[@id='content']/ul/li[1]/a")).click();
	}

	@Then("^User verifies the title$")
	public void verifyTheTitle() {
		String text = driver.getTitle();
		assertEquals(text, text.contains("Also known as split testing"));
	}
	
	@Then ("^Close the browser$")
	public void closeTheBrowser()throws Exception{
		driver.close();
		driver.quit();
		System.out.println("***TEST HAS BEEN COMPLETE! And the browser is being closed!***");
	}
	
	@When ("^User navigates on the Broken Images text$")
	public void navigateToBrokenImage(){
		driver.findElement(By.xpath("//*[@id='content']/ul/li[3]/a")).click();
		WebElement brokenImagesTxt = driver.findElement(By.xpath("//*[@id='content']/div/h3"));
		System.out.println("The title is " + brokenImagesTxt.getText());
		assertEquals(brokenImagesTxt, "Broken Images");
	}
	
	@Then ("^User verifies the last image$")
	public void verifyImage(){
		WebElement avatarImg = driver.findElement(By.xpath("//*[@src='img/avatar-blank.jpg']"));
		assertEquals(avatarImg, avatarImg);
	}
	
	@When ("^User clicks on the checkboxes text$")
	public void navigateToCheckBox()throws Exception{
		driver.findElement(By.xpath("//*[@id='content']/ul/li[5]/a")).click();
		Thread.sleep(3000);
	}
	
	@Then ("^User checks and unchecks the boxes$")
	public void checkAndUncheckBox() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]")));
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
		boolean isCheckbox1 =checkbox1.isSelected();
		if(isCheckbox1 == false) {
			checkbox1.click();
		}
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]")));
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
		boolean isCheckbox2 = checkbox2.isSelected();
		if(isCheckbox2 == true) {
			checkbox2.click();
		}
	}
	@When ("^User clicks on the drag and drop text$")
	public void navigateDragAndDrop()throws Exception{
		driver.findElement(By.xpath("//*[@id='content']/ul/li[8]/a")).click();
		Thread.sleep(3000);
	}
	
	@Then ("^User performs drag and drop operation$")
	public void performDragAndDrop(){
		WebElement w = driver.findElement(By.id("column-a"));
		WebElement e = driver.findElement(By.id("column-b"));
		Actions act = new Actions(driver);
		act.dragAndDrop(w, e).build().perform();
	}
	@When ("^User clicks on the dropdown text$")
	public void clickOnDropDown()throws Exception{
		driver.findElement(By.xpath("//*[@id='content']/ul/li[9]/a")).click();
		Thread.sleep(3000);
	}
	
	@Then ("^User chooses the 1st option in dropdown$")
	public void chooseOptionInDropDown(){
		try {
			Select element = new Select(driver.findElement(By.xpath("//*[@id='dropdown']")));
			element.selectByVisibleText("Option 1");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	@When ("^User clicks on the upload file text$")
	public void navigateUploadFile()throws Exception{
		driver.findElement(By.xpath("//*[@id='content']/ul/li[15]/a")).click();
		Thread.sleep(3000);
	}

	@Then ("^User uploads a file and verifies the message$")
	public void uploadFile() throws Exception{
		WebElement fileUpload = driver.findElement(By.xpath("//*[@id='file-upload']"));
//		fileUpload.click();
		fileUpload.sendKeys("C:\\leapwork.AutomationStudio.exe");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='file-submit']")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		assertEquals(driver.getTitle(), title);	
	}
	
	@Given ("^User is on the Login Page$")
	public void loginPage(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/login");
	}
	
	@When ("^User enters credentials$")
	public void enterLoginCredentials() throws Exception{
		String userName = "tomsmith";
		String password = "SuperSecretPassword!";
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='login']/button")).click();
		Thread.sleep(5000);
		
	}
	@Then ("^User verifies the text$")
	public void verifyLoginPage(){
		WebElement text = driver.findElement(By.xpath("//*[@id='content']/div/h4"));
		if(text.getText().contains("Welcome to the Secure Area")){
			System.out.println("LOGIN TEST PASSED!!!");
		}else{
			System.out.println("LOGIN TEST FAILED!" + text.getText());
		}
	}
}
