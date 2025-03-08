package Devendra.CureHealthE2E;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Devendra.CureHealthE2E.PageObjects.AppointmentPage;
import Devendra.CureHealthE2E.PageObjects.LandingPage;

public class MakeAppointment extends BaseTest{

		@Test
		public void Makeappt() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		LandingPage l = new LandingPage(driver);
		l.goTo();
		String userName = driver.findElement(By.xpath("//input[@value='John Doe']")).getAttribute("value");
		String pass = driver.findElement(By.xpath("//input[@value='ThisIsNotAPassword']")).getAttribute("value");
		l.loginPage(userName, pass);
		
		
		AppointmentPage ap = new AppointmentPage(driver);
		ap.Facility("Hongkong CURA Healthcare Center");
		ap.healthPrograms("Medicare");
		ap.AppointmentDate("15/03/2011");
		
		System.out.println(driver.findElement(By.xpath("//h2")).getText());
		Thread.sleep(1000);
		driver.close();
		}
}
