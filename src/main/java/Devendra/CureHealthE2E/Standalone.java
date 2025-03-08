package Devendra.CureHealthE2E;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Standalone {

	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();
		
		//GETTEXT()  - IS NOT WORKING THERE BECAUSE IT IS ONLY USE WITH DIV,SPAN,P
		String userName = driver.findElement(By.xpath("//input[@value='John Doe']")).getAttribute("value");
		
		String pass = driver.findElement(By.xpath("//input[@value='ThisIsNotAPassword']")).getAttribute("value");
		
		System.out.println(userName);
		System.out.println(pass);
		
		
		driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys(pass);
		driver.findElement(By.cssSelector("button[class='btn btn-default']")).click();
		// drop down handle
		WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
		Select select = new Select(facility);
		select.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		List<WebElement> radiobuttons = driver.findElements(By.xpath("//label/input[@name='programs']"));
		for(WebElement program : radiobuttons)
		{
			if(program.getAttribute("value").equals("None"))
			{
				System.out.println(program.getAttribute("value"));
				program.click();
				break;
			}
		}
		WebElement dates = driver.findElement(By.id("txt_visit_date"));
		dates.click();
		dates.sendKeys("15/03/2011");
		driver.findElement(By.id("txt_comment")).sendKeys("Appointment booked with Selenium Automation");
		driver.findElement(By.id("btn-book-appointment")).click();
		
		System.out.println(driver.findElement(By.xpath("//h2")).getText());
		
		Thread.sleep(3000);
		
//		driver.close();
		
		
		
		
	}

}
