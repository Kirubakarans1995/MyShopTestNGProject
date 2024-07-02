package org.login;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass extends BaseClass {
	
	@BeforeClass
	public static void befClass() {
		chromeBrowser();
		launchUrl("http://www.automationpractice.pl/index.php");
		maxWindow();
		applyImplicitWait(10);
	}
	
	@Test(priority = 2)
	public static void signInClick() {
		WebElement clickSignIn = driver.findElement(By.xpath("//a[@class='login']"));
		clickMethod(clickSignIn);
		WebElement down = driver.findElement(By.xpath("//a[@title='Blog']"));
		scrollDown(down);
	}
	
	@Test(priority = 5,dataProvider = "SampleData")
	public static void enterValues(String email, String pass) {
				
			WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email']"));
			clickMethod(txtEmail);
			fillTextBox(txtEmail, email);
			WebElement txtPass = driver.findElement(By.xpath("//input[@id='passwd']"));
			clickMethod(txtPass);
			fillTextBox(txtPass, pass);
			WebElement submit = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
			clickMethod(submit);
			WebElement click = driver.findElement(By.xpath("//input[@id='email']"));
			clickDouble(click);
			clickMethod(click);
			clearField(click);
			WebElement click1 = driver.findElement(By.xpath("//input[@id='passwd']"));
			clickDouble(click1);
			clickMethod(click1);
			clearField(click1);
								
	}
	
	
	@DataProvider(name = "SampleData")
	public Object[][] data() {
		return new Object[][] {
		{"test123@gmail.com" , "test123"},
		{"test234@gmail.com" , "test234"},
		{"test345@gmail.com" , "test345"},
		{"test456@gmail.com" , "test456"},
		};
	}
	
//	@AfterClass
//	public static void aftClass() {
//		driver.quit();
//	}
	
	

}