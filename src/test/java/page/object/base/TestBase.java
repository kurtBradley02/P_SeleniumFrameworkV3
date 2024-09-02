package page.object.base;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.ddt.Excel;
import page.object.base.PageBase;
import page.reports.ReportJira;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestBase {

	public WebDriver driver;

	@BeforeTest()
	public void setup() {
		WebDriverManager.chromedriver().driverVersion("127.0.6533.120").setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() throws InterruptedException, IOException {
		Thread.sleep(3000);
		driver.quit();
	}

	public WebElement explicitWait(By locator) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement click(WebElement elem) throws IOException {		
		try {
			elem.click();
			return elem;
		}catch(Exception e) {
			ReportJira.generate("", driver, e);
			throw e;
		}		
	}
	
	public WebElement sendKeys(WebElement elem, String value) throws IOException {		
		try {
			elem.sendKeys(value);
			return elem;
		}catch(Exception e) {
			ReportJira.generate("", driver, e);
			throw e;
		}		
	}

}
