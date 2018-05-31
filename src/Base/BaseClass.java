package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {
	WebDriver driver;
	@BeforeSuite
	public WebDriver OpenApplication()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://E3019815:Shivbaba@5@mdtdeskgenp.fisstaging.local/MiserTeller/Account/MiserProcessInfo");
		return driver;
	}
	
	@AfterSuite
	public void closeApplication()
	{
		
	}
	
	
}
