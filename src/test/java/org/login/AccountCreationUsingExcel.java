package org.login;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountCreationUsingExcel extends BaseClass {
	
	@BeforeClass
	public static void befClass() {
		
		chromeBrowser();
		maxWindow();
		launchUrl("http://www.automationpractice.pl/index.php");
		applyImplicitWait(8);
		
	}
	
	@Test(priority = -5)
	public static void clickSignIn() {
		
		WebElement signInButton = driver.findElement(By.xpath("//a[@class='login']"));
		clickMethod(signInButton);
		WebElement scrollDown = driver.findElement(By.xpath("//a[@title='Blog']"));
		scrollDown(scrollDown);
		
	}
	
	@Test(priority = 0)
	public static void passEmail() throws IOException {
		
		WebElement clickField = driver.findElement(By.xpath("//input[@name='email_create']"));
		clickMethod(clickField);
		fillTextBox(clickField, readFromExcel("Register", 3, 0));
		WebElement clickCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		clickMethod(clickCreate);
		
	}
	
	@Test(priority = 2)
	public static void fillPersonalInfo() throws IOException {
		
		WebElement down = driver.findElement(By.xpath("//h1[text()='Create an account']"));
		scrollDown(down);
		WebElement genderClick = driver.findElement(By.xpath("//input[@id='id_gender1']"));
		clickMethod(genderClick);
		WebElement firstName = driver.findElement(By.xpath("//input[@name='customer_firstname']"));
		clickMethod(firstName);
		fillTextBox(firstName, readFromExcel("Register", 3, 1));
		WebElement lName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		clickMethod(lName);
		fillTextBox(lName, readFromExcel("Register", 3, 2));
		WebElement pass = driver.findElement(By.xpath("//input[@name='passwd']"));
		clickMethod(pass);
		fillTextBox(pass, readFromExcel("Register", 3, 3));
		WebElement selectDay = driver.findElement(By.xpath("//select[@id='days']"));
		selectMethodByValue(selectDay, "1");
		WebElement selectMonth = driver.findElement(By.xpath("//select[@id='months']"));
		selectMethodByValue(selectMonth, "1");
		WebElement selectYear = driver.findElement(By.xpath("//select[@id='years']"));
		selectMethodByValue(selectYear, "2001");
		WebElement submit = driver.findElement(By.xpath("//button[@name='submitAccount']"));
		clickMethod(submit);
				
	}
	
	@Test(priority = 5)
	public static void snapRegisterAccount() throws IOException {
		
		WebElement down = driver.findElement(By.xpath("//h1[text()='My account']"));
		scrollDown(down);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\ADMIN\\eclipse-workspace\\"
				+ "AutomationProjectTestNG\\Screenshot\\AccountCreationSnap.png");
		FileUtils.copyFile(source, destination);
		
	}
	
//	@AfterClass
//	public static void afeClass() {
//		driver.quit();
//	}

}