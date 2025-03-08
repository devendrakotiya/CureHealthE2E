package Devendra.CureHealthE2E;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BaseTest {
	WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"src\\main\\java\\Devendra\\CureHealthE2E\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriver driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			// firefox code here
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			// edge code here
		}
		
		driver.manage().window().maximize();
		return driver;
		
	}
	
	
}
