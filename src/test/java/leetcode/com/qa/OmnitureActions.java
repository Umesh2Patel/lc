package leetcode.com.qa;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.walmart.qa.omniture.ui.V2Cart.OmnitureTestSuites1;

public class OmnitureActions {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OmnitureActions.class);
	static String webElementLocator = null;
	static String elementType = null;
	static String KeyData = null;
	static WebElement element = null;
	
	public static void Click(WebDriver webDriver, int rowNum, Sheet sheet, File file) throws InterruptedException, IOException {
		LOGGER.info("Entering in to Click method");
		ConsoleUtil.waitForPageLoad1(webDriver);
		Thread.sleep(3000);
		webElementLocator = OmnitureExcelDataReader.excelDataReader("Element", rowNum, sheet, file);;
		elementType = OmnitureExcelDataReader.excelDataReader("Element Type", rowNum, sheet, file);
		element = getElement(webDriver, elementType, webElementLocator);
		element.click();
		LOGGER.info("Existing from to Click method");
	}
	
	public static void SendKey(WebDriver webDriver, int rowNum, Sheet sheet, File file) throws InterruptedException, IOException {
		LOGGER.info("Entering in to SendKey method");
		ConsoleUtil.waitForPageLoad1(webDriver);
		Thread.sleep(3000);
		webElementLocator = OmnitureExcelDataReader.excelDataReader("Element", rowNum, sheet, file);;
		KeyData = OmnitureExcelDataReader.excelDataReader("Values", rowNum, sheet, file);
		elementType = OmnitureExcelDataReader.excelDataReader("Element Type", rowNum, sheet, file);
		element = getElement(webDriver, elementType, webElementLocator);
		element.sendKeys(KeyData);
		LOGGER.info("Existing from to SendKey method");
	}
	
	public static void LoadBasePage(WebDriver webDriver, int rowNum, Sheet sheet, File file) {
		LOGGER.info("Entering in to LoadBasePage method");
		ConsoleUtil.waitForPageLoad1(webDriver);
		webElementLocator = OmnitureExcelDataReader.excelDataReader("Element", rowNum, sheet, file);;
		webDriver.get(webElementLocator);
		LOGGER.info("Existing from to LoadBasePage method");
	}

	public static void HoverorClick(WebDriver webDriver, int rowNum, Sheet sheet, File file) throws InterruptedException, IOException {
		LOGGER.info("Entering in to HoverorClick method");
		ConsoleUtil.waitForPageLoad1(webDriver);
		Thread.sleep(3000);
		webElementLocator = OmnitureExcelDataReader.excelDataReader("Element", rowNum, sheet, file);
		elementType = OmnitureExcelDataReader.excelDataReader("Element Type", rowNum, sheet, file);
		element = getElement(webDriver, elementType, webElementLocator);
		element.click();
		LOGGER.info("Existing from to HoverorClick method");
	}
	
	public static void CheckBox(WebDriver webDriver, int rowNum, Sheet sheet, File file) throws InterruptedException, IOException {
		LOGGER.info("Entering in to CheckBox method");
		ConsoleUtil.waitForPageLoad1(webDriver);
		Thread.sleep(3000);
		webElementLocator = OmnitureExcelDataReader.excelDataReader("Element", rowNum, sheet, file);
		elementType = OmnitureExcelDataReader.excelDataReader("Element Type", rowNum, sheet, file);
		element = getElement(webDriver, elementType, webElementLocator);
		element.click();
		LOGGER.info("Existing from to CheckBox method");
	}
	
	public static void KeyDown(WebDriver webDriver, int rowNum, Sheet sheet, File file) throws InterruptedException, IOException {
		LOGGER.info("Entering in to KeyDown method");
		ConsoleUtil.waitForPageLoad1(webDriver);
		Thread.sleep(3000);
		webElementLocator = OmnitureExcelDataReader.excelDataReader("Element", rowNum, sheet, file);
		elementType = OmnitureExcelDataReader.excelDataReader("Element Type", rowNum, sheet, file);
		element = getElement(webDriver, elementType, webElementLocator);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(1);
		LOGGER.info("Existing from to KeyDown method");
	}
	
	private static WebElement getElement(WebDriver webDriver, String elementType2, String webElementLocator2) throws IOException {
		LOGGER.info("Entering in to getElement method");
		if(elementType2.toUpperCase().equals("CSS SELECTOR")){
			element = webDriver.findElement(By.cssSelector(webElementLocator2));
		}else if(elementType2.toUpperCase().equals("XPATH")){
			element = webDriver.findElement(By.xpath(webElementLocator2));	
		}else if(elementType2.toUpperCase().equals("LINKTEXT")){
			element = webDriver.findElement(By.linkText(webElementLocator2));
		}else if(elementType2.toUpperCase().equals("ID")){
			element = webDriver.findElement(By.id(webElementLocator2));
		}else{
			throw new IOException(elementType2 +" does not match with any element type format");
		}

		return element;
	}

}
