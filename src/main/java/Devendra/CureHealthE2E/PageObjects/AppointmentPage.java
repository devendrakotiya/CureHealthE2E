package Devendra.CureHealthE2E.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {

	WebDriver driver;
	public AppointmentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id='combo_facility']")
	WebElement facility;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkbox;
	@FindBy(xpath="//label/input[@name='programs']")
	List<WebElement> radiobuttons;
	@FindBy(id="txt_visit_date")
	WebElement dates;
	@FindBy(id="txt_comment")
	WebElement comment;
	@FindBy(id="btn-book-appointment")
	WebElement bookAppointment;
	
	public void Facility(String Fac)
	{
		Select select = new Select(facility);
		select.selectByVisibleText(Fac);
		
	}
	
	public void healthPrograms(String options)
	{
		checkbox.click();
		for(WebElement program : radiobuttons)
		{
			if(program.getAttribute("value").equals(options))
			{
				System.out.println(program.getAttribute("value"));
				program.click();
				break;
			}
		}
	}
	
	public void AppointmentDate(String date) {
		dates.click();
		dates.sendKeys(date);
		comment.sendKeys("Appointment booked with Selenium Automation");
		bookAppointment.click();
	}
}
