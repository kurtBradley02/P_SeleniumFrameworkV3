package page.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import page.ddt.Excel;
import page.object.base.TestBase;
import page.object.models.PageLogin;
import page.reports.ReportJira;



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
		try {
		
			page.getUsername().sendKeys(Excel.read("LoginScenario", 1, 2));
			page.getPassword().sendKeys(Excel.read("LoginScenario", 1, 3));
			page.getLoginButton().click();
			
			WebElement successLabel = explicitWait(By.xpath("//*[@id=\"successModal\"]/div/h3"));
			
			assertEquals(successLabel.getText(), "Login Success");
		}catch(Exception e) {
			ReportJira.generate("userCanLoginWithValidCredentials", driver, e);
			
			throw e;
		}

	}
	
	@Test(priority = 2)
	public void userLoginInvalidUsername() throws InterruptedException, IOException
	{
		try {
		
			page.getUsername().sendKeys(Excel.read("LoginScenario", 2, 2));
			page.getPassword().sendKeys(Excel.read("LoginScenario", 2, 3));
			page.getLoginButton().click();
			
			WebElement failLabel = explicitWait(By.xpath("//*[@id=\"failModal\"]/div/h3"));
			
			assertEquals(failLabel.getText(), "Login Fail");
		}catch(Exception e) {
			ReportJira.generate("userCanLoginWithValidCredentials", driver, e);
			
			throw e;
		}

	}
}
