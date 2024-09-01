package util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.PageBase;

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
}
