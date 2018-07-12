//test controlled by mamta gupta

package tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.BaseClass;
import pages.MiscellaneousChargeAndReversal;
import pages.ReturnBoxToService;
import pages.SD04_TransactionResponse_page;
import pages.SD04_page;
import pages.SD_Menu_Page;
import pages.UtilitiesMenu;
import pages.homeScreen_online;
import pages.txn_searchPage;
import pages.welcomeToMiser_loginScreen;
import pages.welcome_Login;
import utilities.ExcelMethods;
import utilities.captureScreen;
import utilities.common_buttons;
import utilities.excelReading;

public class VerifyLogin {

	

	common_buttons wait = new common_buttons(base.Driver);
	

	@Test(priority=1)
	public void a_verifyLogin() throws InterruptedException, IOException {
		System.out.println("First method execution");
		
		
		base.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		base.Driver.manage().window().maximize();
		base.Driver.get("http://E3019815:Shivbaba@5@mdtdeskgenp.fisstaging.local/miserteller?ClientComputerName=DEL1-LTC1X3PH2");
		welcomeToMiser_loginScreen wc = new welcomeToMiser_loginScreen(base.Driver);
		
		wc.ClickSubmitBtn();
		welcome_Login login = new welcome_Login(base.Driver);
		//login.verifyLoginScreen();
		login.enterCashBox("9999");
		wait.waitUntilElementisvisible();
		login.clickSignOnBtn();
		homeScreen_online home = new homeScreen_online(base.Driver);
		captureScreen capture = new captureScreen(base.Driver);
		capture.captureScreenshot("HomeScreenView");
		
		wait.waitUntilElementisvisible();
		//home.clickBusinessView();
		//home.verifyLogin();
		capture.captureScreenshot("UserloggedIn");
		// home.clickSignOff();

	}

	
	@Test(priority=3)
	public void verify_SD() throws IOException, InterruptedException {
		System.out.println("third method execution");
		txn_searchPage txn_search = new txn_searchPage(base.Driver);
		wait.waitUntilElementisvisible();
		txn_search.enter_txn_no("SD");
		SD_Menu_Page SD_menu = new SD_Menu_Page(base.Driver);
		wait.waitUntilElementisvisible();
		SD_menu.verifyTxn();
		captureScreen capture = new captureScreen(base.Driver);
		capture.captureScreenshot("SD_menu_View");
		SD_menu.click_SD04();
		wait.waitUntilElementisvisible();

		SD04_page txn_page = new SD04_page(base.Driver);
		String title = txn_page.verifyTxn_Title();
		
		capture.captureScreenshot("Transaction_9411_View");
		excelReading reading = new excelReading();
		txn_page.enter_BoxNo("1");
		txn_page.Click_SubmitBtn();
		wait.waitUntilElementisvisible();
		SD04_TransactionResponse_page response = new SD04_TransactionResponse_page(base.Driver);
		response.verifyTxn_response();
		wait.waitUntilElementisvisible();
		capture.captureScreenshot("Transaction_response");
		response.click_first_row();
		base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		response.click_CloseBtn();
		wait.waitUntilElementisvisible();
		System.out.println("Third method execution has been stopped");
	}

@Test(priority=4)
	public void verifyReturnBoxToServicePage() throws InterruptedException {
		System.out.println("Fourth method execution");
		ReturnBoxToService returnBox = new ReturnBoxToService(base.Driver);
		txn_searchPage txn_search = new txn_searchPage(base.Driver);
		txn_search.enter_txn_no("SD27");
		wait.waitUntilElementisvisible();
		returnBox.enterOriginalBoxNumber("45");
		wait.waitUntilElementisvisible();
		common_buttons buttons = new common_buttons(base.Driver);
		buttons.clickSubmitBtn();
		returnBox.verifyResponse();
		System.out.println("Fourth method execution has been stopped");

	}

	@Test(priority=5)
	public void verifyMiscellaneousChargeAndReversal() throws InterruptedException
	{
		System.out.println("Fifth method execution");
		txn_searchPage txn_search = new txn_searchPage(base.Driver);
		
		txn_search.enter_txn_no("SD30");
		common_buttons buttons = new common_buttons(base.Driver);
		MiscellaneousChargeAndReversal reversal = new MiscellaneousChargeAndReversal(base.Driver);
		wait.waitUntilElementisvisible();
		reversal.clearBranchNumber();
		wait.waitUntilElementisvisible();
		buttons.clickSubmitBtn();
		wait.waitUntilElementisvisible();
		reversal.verifyErrorMessages();
			
		reversal.enterBranchNumber("001");
		reversal.enterOriginalBoxNumber("469");
		
		buttons.clickSubmitBtn();
		reversal.verifyRevesalScreen();
		reversal.selectTransaction();
		wait.waitUntilElementisvisible();
		reversal.enterTransactionAmount();
		buttons.clickSubmitBtn();
		wait.waitUntilElementisvisible();
		reversal.verifyTransactionAccepted();
		buttons.clickPreviewBtn();
		wait.waitUntilElementisvisible();
		buttons.clickPreviewPopupCloseBtn();
		wait.waitUntilElementisvisible();
		buttons.clickCloseBtn();
		System.out.println("fifth method execution has been stopped");
		
		
	}
	
	@Test(priority=6)
	public void c_verifyDupWithData() throws InterruptedException, AWTException
	{
		System.out.println("sixth method execution");
		System.out.println("Going to start execution of third method");
		common_buttons buttons = new common_buttons(base.Driver);
		wait.waitUntilElementisvisible();
		buttons.verifyHomeScreen();
		buttons.clickDupWithoutDataBtn();
		MiscellaneousChargeAndReversal reversal = new MiscellaneousChargeAndReversal(base.Driver);
		reversal.verifyDupWithoutDataBtn();
		System.out.println("dup without data verified");
		wait.waitUntilElementisvisible();
		buttons.clickDupWithDataBtn();
		reversal.verifyDupWithDataBtn();
		reversal.verifyDupWithDataContent();
		wait.waitUntilElementisvisible();
		UtilitiesMenu menu = new UtilitiesMenu(base.Driver);
		System.out.println("going to click on journal summary shortcut ");
		menu.clickJouranlSummary();
		System.out.println("journal summary has been opened up");
		
		
		
	}
	
	

	@Test(priority=7)
	public void closeApp() throws IOException, InterruptedException {
		 System.out.println("going to execute second mthod");
		homeScreen_online home = new homeScreen_online(base.Driver);
		wait.waitUntilElementisvisible();
		home.clickSignOff();
		captureScreen capture = new captureScreen(base.Driver);
		capture.captureScreenshot("SignOff_confirmationScreen");
		
	}

	
	
	
	
}





























