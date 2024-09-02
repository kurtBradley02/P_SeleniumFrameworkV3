package page.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import page.object.base.TestBase;
import page.object.models.PageLogin;
import page.reports.ReportJira;



public class TestPage extends TestBase{
	
	PageLogin page;
	
	@BeforeMethod
	public void testConfig() {
		page = new PageLogin(driver);
	}
	
	@Test(priority = 1)
	public void navigateTo() {
		page.driver.get("file:///C:/Users/kurtb/OneDrive/Desktop/Login.html");
	}
	
	@Test(priority = 2)
	public void userCanLoginWithValidCredentials() throws InterruptedException, IOException
	{
		try {
		
			page.getUsername().sendKeys("admin");
			page.getPassword().sendKeys("123456");
			page.getLoginButton().click();
			
			WebElement successLabel = explicitWait(By.xpath("//*[@id=\"successModal\"]/div/h3"));
			
			assertEquals(successLabel.getText(), "Login Success");
		}catch(Exception e) {
			ReportJira.generate("userCanLoginWithValidCredentials", driver, e);
			
			throw e;
		}

	}
}
