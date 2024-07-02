package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver; static Actions a; static Robot r; static Select s;
	
	public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void edgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	public static void firefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
	
	public static void maxWindow() {
		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static String pageCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public static void btnClick(WebElement element) {
		element.click();
	}
	
	public static WebElement locateByXpath(String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;
	}
	
	public static void fillTextBox(WebElement element, String keys) {
		element.sendKeys(keys);
	}
	
	public static void clickMethod(WebElement element) {
		element.click();
	}
	
	public static void clearField(WebElement element) {
		element.clear();
	}
	
	public static void mouseHover(WebElement reference) {
		a = new Actions(driver);
		a.moveToElement(reference).perform();
	}
	
	public static void dragDrop(WebElement start, WebElement end) {
		a = new Actions(driver);
		a.dragAndDrop(start, end).perform();
	}
	
	public static void clickDouble(WebElement target) {
		a = new Actions(driver);
		a.doubleClick(target);
	}
	
	public static void copy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	
	public static void paste() throws AWTException { 
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	
	public static String readFromExcel(String sheetName, int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\AutomationProjectTestNG\\Excel\\Your Cart Login Cred.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet(sheetName);
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		
		String name;
		if(type == 1) {
			name = c.getStringCellValue();
		}
		
		else if(DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			
			SimpleDateFormat sim = new SimpleDateFormat("dd/MM/YYYY");
			name = sim.format(date);
		}
		
		else {
			double d = c.getNumericCellValue();
			
			long l = (long)d;
			name = String.valueOf(l);
		}
		
		return name;
		
		
		
	}
	
	public static void getDateAndTime() {
		Date d = new Date();
		System.out.println(d);
	}
	
	public static void selectMethodByValue(WebElement reference, String value) {
		s = new Select(reference);
		s.selectByValue(value);
	}
	
	public static void selectMethodByVisibleText(WebElement reference, String value) {
		s = new Select(reference);
		s.selectByVisibleText(value);
	}
	
	public static void sleep(int milliSeconds) throws InterruptedException {
		Thread.sleep(milliSeconds);
	}
	
	public static void linkClick(WebElement link) {
		link.click();
	}
	
	public static void enteringNewWindow() {
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		
		for (String eachId : allId) {
			
			if(!eachId.equals(parentId)) {
				driver.switchTo().window(eachId);
			}
			
		}
	}
	
	
	public static void alert() {
		Alert a = driver.switchTo().alert();
	}
	
	
	public static void applyImplicitWait(int duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
	
	public static void scrollDown(WebElement reference) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", reference);
	}
	
	public static void scrollUp(WebElement reference) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", reference);
	}
	
	public static void clickJS(WebElement reference) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", reference);
	}
	
	public static void getValueJS(WebElement reference) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].getAttribute('value')", reference);
	}
	
	
	
	
	
	
	
	
	

}
