package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import library.FoundationPage;


public class Regression extends FoundationPage{
//	MethodLibrary library = new MethodLibrary(driver);
	
	@Test
	public void ABTesting() {
		driver.findElement(By.xpath("//*[@id='content']/ul/li[1]/a")).click();
		String text = driver.getTitle();
		assertEquals(text, text.contains("Also known as split testing"));
	}

	@Test 
	public void basicAuthorization() {
		driver.findElement(By.xpath("//*[@id='content']/ul/li[2]/a")).click();
		driver.close();
		driver.quit();
	}

	@Test
	public void avatarImage() {
		driver.findElement(By.xpath("//*[@id='content']/ul/li[3]/a")).click();
		WebElement brokenImagesTxt = driver.findElement(By.xpath("//*[@id='content']/div/h3"));
		System.out.println("The title is " + brokenImagesTxt.getText());
		assertEquals(brokenImagesTxt, "Broken Images");
		WebElement avatarImg = driver.findElement(By.xpath("//*[@src='img/avatar-blank.jpg']"));
		assertEquals(avatarImg, avatarImg);
	}

	@Test
	public void checkboxes() throws Exception {
		driver.findElement(By.xpath("//*[@id='content']/ul/li[5]/a")).click();
		Thread.sleep(3000);
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


	@Test
	public void dragAndDrop() throws Exception{
		driver.findElement(By.xpath("//*[@id='content']/ul/li[8]/a")).click();
		Thread.sleep(3000);
		WebElement w = driver.findElement(By.id("column-a"));
		WebElement e = driver.findElement(By.id("column-b"));
		Actions act = new Actions(driver);
		act.dragAndDrop(w, e).build().perform();
}
	
	@Test
	public void dropDown() throws Exception {
		driver.findElement(By.xpath("//*[@id='content']/ul/li[9]/a")).click();
		Thread.sleep(3000);
		try {
			Select element = new Select(driver.findElement(By.xpath("//*[@id='dropdown']")));
			element.selectByVisibleText("Option 1");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	@Test
	public void fileUpload()throws Exception{
		driver.findElement(By.xpath("//*[@id='content']/ul/li[15]/a")).click();
		Thread.sleep(3000);
		WebElement fileUpload = driver.findElement(By.xpath("//*[@id='file-upload']"));
		fileUpload.sendKeys("C:\\leapwork.AutomationStudio.exe");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='file-submit']")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		assertEquals(driver.getTitle(), title);	
	}
	
}

