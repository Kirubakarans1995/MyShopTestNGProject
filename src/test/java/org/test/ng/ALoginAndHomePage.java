package org.test.ng;

import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ALoginAndHomePage extends BaseClass {

	@BeforeClass
	public static void befClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.automationpractice.pl/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = -11, groups = "smoke")
	public static void signInClick() {
		driver.findElement(By.xpath("//a[@class='login']")).click();
	}

	@Test(priority = -3, groups = "smoke")
	public static void signInModule() {
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		clickMethod(email);
		fillTextBox(email, "dominickaran95@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//input[@id='passwd']"));
		clickMethod(pass);
		fillTextBox(pass, "123456789");
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
	}

	@Test(priority = 1, groups = "smoke")
	public static void homeButton() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("URL: " + currentUrl);
		Assert.assertEquals(currentUrl, "http://www.automationpractice.pl/index.php?controller=my-account");

		if (currentUrl.startsWith("http")) {
			WebElement homeClick = driver.findElement(By.xpath("//span[text()=' Home']"));
			clickMethod(homeClick);
		}

		else {
			System.out.println("URL is Invalid");
		}

	}

	@Test(priority = 3, groups = "smoke")
	public static void categoryClick() {

		WebElement mouseHover = driver.findElement(By.xpath("//a[text()='Women']"));
		mouseHover(mouseHover);

		driver.findElement(By.xpath("(//a[text()='Summer Dresses'])[1]")).click();

	}

	// @AfterClass
	// public static void aftclass() {
	// driver.quit();
	// }

}