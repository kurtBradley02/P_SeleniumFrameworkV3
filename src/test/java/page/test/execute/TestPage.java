package page.test.execute;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;

import groovyjarjarasm.asm.commons.Method;
import page.util.base.TestBase;
import page.util.ddt.Excel;
import page.object.models.PageLogin;
import page.util.reports.ReportJira;



public class TestPage extends TestBase{
	
	PageLogin page;
	
    @BeforeMethod
    public void testConfig(ITestResult result) {
        page = new PageLogin(driver);
        page.driver.get("file:///C:/Users/kurtb/OneDrive/Desktop/Login.html");
        scenario = result.getMethod().getMethodName();
    }

	@Test(priority = 1)
	public void userLoginValidCredentials() throws InterruptedException, IOException
	{		
		sendKeys(page.getUsername(),Excel.read("LoginScenario", 1, 2));
		sendKeys(page.getPassword(),Excel.read("LoginScenario", 1, 3));
		click(page.getLoginButton());
		
		expectedResult(By.xpath("//*[@id=\"successModal\"]/div/h3"), "Login Success");
	}
	
	@Test(priority = 2)
	public void userLoginInvalidUsername() throws InterruptedException, IOException
	{
		sendKeys(page.getUsername(),Excel.read("LoginScenario", 2, 2));
		sendKeys(page.getPassword(),Excel.read("LoginScenario", 2, 3));
		click(page.getLoginButton());
		
		expectedResult(By.xpath("//*[@id=\"failModal\"]/div/h3"), "Login Fail");
	}
}
