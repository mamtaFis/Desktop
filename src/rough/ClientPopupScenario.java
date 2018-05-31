package rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientPopupScenario {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("http://E3019815:Shivbaba@5@mdtdeskgenp.fisstaging.local/MiserTeller/Account/MiserProcessInfo");
		//driver.findElement(By.id("")).sendKeys("");
		driver.findElement(By.id("btnContinueSignOn")).click();
		driver.findElement(By.id("CashBoxNumber")).sendKeys("9999");
		driver.findElement(By.id("btnSignOn")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.id("tranSearchText")).click();
		driver.findElement(By.id("tranSearchText")).sendKeys("SD31");
		System.out.println("sd31 transaction getting open");
		/*driver.findElement(By.id("btnSearchTran")).click();
		driver.findElement(By.id("clientSearchER")).click();*/
		
	}

}
