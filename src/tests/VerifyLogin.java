package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import pages.SD04_TransactionResponse_page;
import pages.SD04_page;
import pages.SD_Menu_Page;
import pages.homeScreen_online;
import pages.txn_searchPage;
import pages.welcomeToMiser_loginScreen;
import pages.welcome_Login;
import utilities.captureScreen;

public class VerifyLogin {
	WebDriver driver;
	
	@Test(priority = 1)
	public void verifyLogin() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://E3019815:Shivbaba@5@mdtdeskgenp.fisstaging.local/MiserTeller/Account/MiserProcessInfo");
		welcomeToMiser_loginScreen wc = new welcomeToMiser_loginScreen(driver);
		// wc.setUserID("e3019815");
		wc.ClickSubmitBtn();
		welcome_Login login = new welcome_Login(driver);
		login.verifyLoginScreen();
		login.enterCashBox("9999");
		//Thread.sleep(5000);
		login.clickSignOnBtn();
		homeScreen_online home = new homeScreen_online(driver);
		captureScreen capture = new captureScreen(driver);
		capture.captureScreenshot("HomeScreenView");
		home.clickBusinessView();
		home.verifyLogin();
		capture.captureScreenshot("UserloggedIn");
		// home.clickSignOff();

	}

	public void VerifyUserHost() throws IOException {
		txn_searchPage txn_search = new txn_searchPage(driver);
		txn_search.enter_txn_no("9411");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement txn_header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='label']")));
		// txn_header.click();
		System.out.println("transaction is visible to user");
		captureScreen capture = new captureScreen(driver);
		capture.captureScreenshot("Transaction_9411_View");
	}

	@Test(priority = 2)
	public void verify_SD() throws IOException, InterruptedException {
		txn_searchPage txn_search = new txn_searchPage(driver);
		txn_search.enter_txn_no("SD");
		SD_Menu_Page SD_menu = new SD_Menu_Page(driver);
		SD_menu.verifyTxn();
		captureScreen capture = new captureScreen(driver);
		capture.captureScreenshot("SD_menu_View");
		SD_menu.click_SD04();
		
		SD04_page txn_page = new SD04_page(driver);
		txn_page.verifyTxn_Title();
		
		capture.captureScreenshot("Transaction_9411_View");
		txn_page.enter_BoxNo("1");
		txn_page.Click_SubmitBtn();
		SD04_TransactionResponse_page response = new SD04_TransactionResponse_page(driver);
		response.verifyTxn_response();
		capture.captureScreenshot("Transaction_response");
		response.click_first_row();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		response.click_CloseBtn();
		
		
		

	}
	@Test(priority = 3)
	public void closeApp() throws IOException
	{
		homeScreen_online home = new homeScreen_online(driver);
		home.clickSignOff();
		captureScreen capture = new captureScreen(driver);
		capture.captureScreenshot("SignOff_confirmationScreen");
	}
}
