package Devendra.CureHealthE2E.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='txt-username']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@id='txt-password']")
	WebElement pass;
	
	@FindBy(css="button[class='btn btn-default']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@id='btn-make-appointment']")
	WebElement MakeAppointment;
	
	public void loginPage(String username, String password)
	{
		Username.sendKeys(username);
		pass.sendKeys(password);
		loginButton.click();
	}
	
	
	
	public void goTo()
	{
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		MakeAppointment.click();
	}
	
	
}
