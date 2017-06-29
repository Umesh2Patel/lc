package leetcode.com.qa;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class FetchExcelFile {
	private WebDriver webDriver;
	private String baseURL;

	@BeforeMethod
	public void beforeMethod() {
		ChromeDriverManager.getInstance().setup();
		webDriver = new ChromeDriver();
		baseURL = "https://confluence.walmart.com/pages/viewpage.action?spaceKey=SABMI&title=O.+POC+-+Regression+Validation";
		webDriver.get(baseURL);
		webDriver.manage().window().maximize();
	}

	@Test
	public void fetchExcelFileFromConfluence() throws InterruptedException {
		Thread.sleep(3000);
		webDriver.findElement(By.cssSelector("#os_username")).sendKeys("vn0u7yz");
		webDriver.findElement(By.cssSelector("#os_password")).sendKeys("Walmart5");
		webDriver.findElement(By.cssSelector("#loginButton")).click();
		webDriver.findElement(By.cssSelector("#action-menu-link")).click();
		webDriver.findElement(By.cssSelector("#view-attachments-link")).click();
		webDriver.findElement(By.xpath(".//*[@id='attachment-187010005']/td[8]/ul/li[1]/a/span")).click();
		webDriver.findElement(By.xpath(".//*[@id='panel1']/table/tbody/tr[5]/td[4]")).click();
		
		Thread.sleep(3000);
		
	}

	@AfterMethod
	public void afterMethod() {
		webDriver.quit();
	}

}
