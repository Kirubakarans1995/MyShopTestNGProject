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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterPassing extends BaseClass {
	
	@BeforeClass
	public static void befClass() {
		chromeBrowser();
		launchUrl("http://www.automationpractice.pl/index.php");
		maxWindow();
		applyImplicitWait(10);
	}
	
	@Test(priority = -10)
	public static void signInClick() {
		WebElement clickSignIn = driver.findElement(By.xpath("//a[@class='login']"));
		clickMethod(clickSignIn);
		WebElement down = driver.findElement(By.xpath("//a[@title='Blog']"));
		scrollDown(down);
	}
	
	@Parameters({"email","password"})
	@Test(priority = 10)
	public static void passValues(String email, String pass) {
		WebElement textEmail = driver.findElement(By.xpath("//input[@id='email']"));
		clickMethod(textEmail);
		fillTextBox(textEmail, email);
		WebElement textPass = driver.findElement(By.xpath("//input[@id='passwd']"));
		clickMethod(textPass);
		fillTextBox(textPass, pass);
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
	}
	
	@Test(priority = 13)
	public static void screenshotMyAccount() throws IOException {
		WebElement down = driver.findElement(By.xpath("//a[@title='Blog']"));
		scrollDown(down);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\ADMIN\\eclipse-workspace\\"
				+ "AutomationProjectTestNG\\Screenshot\\MyAccountSnap.png");
		FileUtils.copyFile(source, destination);
	}
	
//	@AfterClass
//	public static void aftClass() {
//		driver.quit();
//	}

}