package page.tests;

import org.testng.annotations.*;

import page.object.models.PageLogin;
import util.TestBase;

public class TestPage extends TestBase {
	
	PageLogin page;
	
	@BeforeMethod
	public void testConfig() {
		page = new PageLogin(driver);
	}
	
	@Test(priority = 1)
	public void navigateTo() {
		page.driver.get("https://www.google.com/");
	}
	
	@Test(priority = 2)
	public void clickImFeelingLucky() {
		page.getFeelingLucky().click();
	}
	
}
