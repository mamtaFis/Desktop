package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class welcome_Login {
	WebDriver driver;

	@FindBy(xpath="//*[@id='PIN']")
	private WebElement PIN;
	
	@FindBy(xpath="//*[@id='CashBoxNumber']")
	private WebElement CashBox;
	
	@FindBy(xpath="//*[@id='CashBoxNumber']")
	private WebElement BeginningCash;
	
	@FindBy(xpath="//*[text()='Offline']")
	private WebElement OfflineBtn;
	
	@FindBy(xpath="//*[@id='btnSignOn']")
	private WebElement SignOnBtn;
	
	@FindBy(xpath="//*[@id='btnCancel']")
	private WebElement CancelBtn;
	
	@FindBy(xpath="//*[@id='PostingDate']")
	private WebElement PostingDate;
	
	@FindBy(xpath="//*[contains(text(),'INVALID POST DT!')]")
	private WebElement invaliPostDateText;
	
	@FindBy(xpath="//*[contains(text(),'OK')]")
	private WebElement OkBtn_onInvalidDTPopup;
	
	
	//*[contains(text(),'OK')]
	public void enterPin(String pin)
	{
		PIN.sendKeys(pin);
	}
	
	public void enterCashBox(String number)
	{
		CashBox.sendKeys(number);
	}
	
	public void enterPostingdate(String date)
	{
		PostingDate.sendKeys(date);
	}
	
	public void clickSignOnBtn()
	{
		SignOnBtn.click();
		/*if(invaliPostDateText.isDisplayed())
		{
			OkBtn_onInvalidDTPopup.click();
		}*/
		
			
	}
	
	public void clickCancelBtn()
	{
		CancelBtn.click();
	}
	
	public void verifyLoginScreen()
	 {
		 if(CashBox.isDisplayed())
		 {
			 System.out.println("Test Update :: User is on next login screen");
		 }
		 else {
			 System.out.println();
		 }
		assertTrue(CashBox.isDisplayed());
	 }
	
	
	
	public welcome_Login(WebDriver driver)
	{
	    this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
