package org.test.ng;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DProductCartSummary extends BaseClass {

	public static SoftAssert s;

	@Test(priority = 19, groups = "smoke")
	public static void checkoutSummary() {

		String url = pageCurrentUrl();
		System.out.println("URL: " + url);

		if (url.contains("controller=order")) {
			WebElement down = driver.findElement(By.xpath("//h1[@id='cart_title']"));
			scrollDown(down);
			WebElement click = driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]"));
			clickMethod(click);
		}

		else {
			System.out.println("URL is Wrong");
		}

	}

	@Test(priority = 23, groups = "smoke")
	public static void confirmAddress() {

		String title = pageTitle();
		System.out.println("Title: " + title);

		s = new SoftAssert();
		s.assertEquals("Order - My Shop", title);

		if (title.startsWith("Order")) {
			WebElement down = driver.findElement(By.xpath("//h3[text()='Your delivery address']"));
			scrollDown(down);
			WebElement textBox = driver.findElement(By.xpath("//textarea[@name='message']"));
			fillTextBox(textBox, "Please deliver the order ASAP");
			driver.findElement(By.xpath("//button[@name='processAddress']")).click();
		}

		else {
			System.out.println("Invalid Title");
		}

	}

}