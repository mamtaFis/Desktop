package rough;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calender {
	public static void main(String[] args) 
	{
	
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://jqueryui.com/datepicker/");
		
	
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ui-datepicker-div']")));
		
		driver.switchTo().frame(0);
		WebElement calender = driver.findElement(By.xpath("//input[@class='hasDatepicker']"));
		calender.click();
		List<WebElement> dates = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']//td"));
		for(WebElement date : dates)
		{
			String value = date.getText();
			if(value.equalsIgnoreCase("26"))
			{
				date.click();
			}
			
		}
		
	}
	

}
