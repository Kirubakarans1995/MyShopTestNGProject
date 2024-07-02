package org.test.ng;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class BProductListPage extends BaseClass {

	@Test(priority = 4, groups = "smoke")
	public static void sortProducts() {

		String title = pageTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals("Summer Dresses - My Shop", title);

		if (title.contains("Dresses")) {
			WebElement down = driver.findElement(By.xpath("//p[text()='Catalog']"));
			scrollDown(down);
			WebElement select = driver.findElement(By.xpath("//select[@id='selectProductSort']"));
			selectMethodByVisibleText(select, "Price: Highest first");
		}

		else {
			System.out.println("Title is Wrong");
		}

	}

	@Test(priority = 7, groups = "smoke")
	public static void productSelect() {

		WebElement down = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", down);
		// scrollDown(down);
		WebElement clickProduct = driver.findElement(By.xpath("(//a[@class='product-name'])[2]"));
		clickProduct.click();

	}

}
