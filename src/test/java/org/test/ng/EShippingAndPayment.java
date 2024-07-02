package org.test.ng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class EShippingAndPayment extends BaseClass {

	public static SoftAssert s;

	@Test(priority = 26, groups = "smoke")
	public static void shippingAccept() {

		String url = pageCurrentUrl();
		System.out.println("URL: " + url);

		Assert.assertEquals("http://www.automationpractice.pl/index.php?controller=order", url);

		if (url.startsWith("http")) {
			WebElement down = driver.findElement(By.xpath("(//a[text()='T-shirts'])[2]"));
			scrollDown(down);
			WebElement click = driver.findElement(By.xpath("//input[@type='checkbox']"));
			clickMethod(click);
		}

		else {
			System.out.println("URL is Wrong");
		}

		WebElement buttonClick = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		clickMethod(buttonClick);

	}

	@Test(priority = 28, groups = "smoke")
	public static void choosePayment() {

		WebElement down = driver.findElement(By.xpath("//span[text()=' Payment']"));
		scrollDown(down);
		WebElement click = driver.findElement(By.xpath("//a[@title='Pay by check.']"));
		clickMethod(click);

	}

	@Test(priority = 29, groups = "smoke")
	public static void confirmOrder() {

		String url = pageCurrentUrl();
		System.out.println("URL: " + url);

		s = new SoftAssert();
		s.assertEquals("http://www.automationpractice.pl" + "/index.php?fc=module&module=cheque&controller=payment",
				url);

		if (url.contains("fc=module&module")) {

			WebElement down = driver.findElement(By.xpath("//h1[text()='Order summary']"));
			scrollDown(down);
			WebElement click = driver.findElement(By.xpath("//span[text()='I confirm my order']"));
			clickMethod(click);

		}

		else {
			System.out.println("URL is Wrong");
		}

	}

	@Test(priority = 30, groups = "smoke")
	public static void orderScreenshot() throws IOException {

		WebElement down = driver.findElement(By.xpath("//h1[text()='Order confirmation']"));
		scrollDown(down);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\ADMIN\\eclipse-workspace"
				+ "\\AutomationProjectTestNG\\Screenshot\\OrderConfirmationSnap.png");
		FileUtils.copyFile(source, destination);

	}

}