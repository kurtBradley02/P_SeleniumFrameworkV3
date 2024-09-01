package page.object.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.PageBase;

public class PageLogin extends PageBase{

	public PageLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[contains(@text,'Feeling')]")
	WebElement feelingLucky;

	public WebElement getFeelingLucky() {
		return feelingLucky;
	}

	public void setFeelingLucky(WebElement feelingLucky) {
		this.feelingLucky = feelingLucky;
	}
	
	
	

}
