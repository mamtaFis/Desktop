package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class tc01_Ie {
	WebDriver driver;
	
	@Test
	public void OpenApp()
	{
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");

		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}

}
