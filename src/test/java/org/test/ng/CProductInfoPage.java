package org.test.ng;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CProductInfoPage extends BaseClass {

	public static SoftAssert s;

	@Test(priority = 10, groups = "smoke")
	public static void sizeSelect() {

		String currentUrl = pageCurrentUrl();
		System.out.println("URL: " + currentUrl);

		s = new SoftAssert();
		s.assertEquals("http://www.automationpractice.pl" + "/index.php?id_product=6&controller=product", currentUrl);

		WebElement down = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		scrollDown(down);

		WebElement select = driver.findElement(By.xpath("//select[@name='group_1']"));
		selectMethodByVisibleText(select, "L");

	}

	@Test(priority = 11, groups = "smoke")
	public static void viewPictures() {

		WebElement click = driver.findElement(By.xpath("//i[@class='icon-repeat']"));
		clickMethod(click);
		WebElement click1 = driver.findElement(By.xpath("(//img[@class='img-responsive'])[2]"));
		clickMethod(click1);
		WebElement nextClick = driver.findElement(By.xpath("//a[@title='Next']"));
		clickDouble(nextClick);
		clickMethod(nextClick);
		WebElement close = driver.findElement(By.xpath("//a[@title='Close']"));
		clickMethod(close);

	}

	@Test(priority = 15, groups = "smoke")
	public static void quantityIncrease() {

		String title = pageTitle();
		System.out.println("Title: " + title);

		s = new SoftAssert();
		s.assertEquals("Printed Summer Dress - My Shop", title);

		if (title.endsWith("Shop")) {

			WebElement up = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
			scrollUp(up);
			WebElement click = driver.findElement(By.xpath("//i[@class='icon-plus']"));
			clickMethod(click);

		}

		else {
			System.out.println("Title is Wrong");
		}

	}

	@Test(priority = 17, groups = "smoke")
	public static void addProductToCart() {

		WebElement down = driver.findElement(By.xpath("//a[@title='Blog']"));
		scrollDown(down);
		String attribute = down.getAttribute("title");
		System.out.println("Attribute Value of Title is " + attribute);

		if (attribute.contains("Blog")) {
			WebElement click = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
			clickMethod(click);
		}

		else {
			System.out.println("Attribute Value is Wrong");
		}

		WebElement click1 = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
		clickMethod(click1);

	}

}