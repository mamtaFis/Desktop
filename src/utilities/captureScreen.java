package utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class captureScreen {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		//captureScreenshot("test");
	}
	
	public  void captureScreenshot(String filename) throws IOException
	{
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screen+shots/"+filename+".jpg"));
	}
	
	public captureScreen(WebDriver driver)
	{
	this.driver = driver;
	}

}
