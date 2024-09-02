package page.test.execute;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import page.util.base.TestBase;
import page.util.ddt.Excel;
import page.object.models.PageLogin;
import page.util.reports.ReportJira;



public class TestPage extends TestBase{
	
	PageLogin page;
	
	@BeforeMethod
	public void testConfig() {
		page = new PageLogin(driver);
		page.driver.get("file:///C:/Users/kurtb/OneDrive/Desktop/Login.html");
	}

	@Test(priority = 1)
	public void userLoginValidCredentials() throws InterruptedException, IOException
	{
		sendKeys(page.getUsername(),Excel.read("LoginScenario", 1, 2));
		sendKeys(page.getPassword(),Excel.read("LoginScenario", 1, 3));
		click(page.getLoginButton());
	}
	
	@Test(priority = 2)
	public void userLoginInvalidUsername() throws InterruptedException, IOException
	{
		sendKeys(page.getUsername(),Excel.read("LoginScenario", 2, 2));
		sendKeys(page.getPassword(),Excel.read("LoginScenario", 2, 3));
		click(page.getLoginButton());
	}
}
