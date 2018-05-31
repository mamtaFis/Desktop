package rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class sample1 {
	public WebDriver driver;
	
	@Test
	public void sampletest()
	{
		System.out.println("hey its dummy test");
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.navigate().to("http://mdtdeskgenp.fisstaging.local/MiserTeller/Transactor/MISERMain");
		
	}

}
