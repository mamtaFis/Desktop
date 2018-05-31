package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SD04_page {
	WebDriver driver;

	
	@FindBy(xpath = "//*[@id='label']")
	private WebElement txn_title;

	@FindBy(xpath = "//*[@id='ISD-ACCT-BR']")
	private WebElement Branch_number;

	@FindBy(xpath = "//*[@id='ISD-ACCT-BOX']")
	private WebElement Box_number;

	@FindBy(xpath = "//*[@id='btnSubmit']")
	private WebElement Submit_Btn;

	@FindBy(xpath = "//*[@id='btnSup']")
	private WebElement Security_Btn;

	@FindBy(xpath = "//*[@id='btnCleareAll']")
	private WebElement ClearAll_Btn;

	@FindBy(xpath = "//*[@id='btnCancel']")
	private WebElement Cancel_Btn;

	public void verifyTxn_Title()
	{
		String expected_title = "History Inquiry (SD04)";
		String actual_title = txn_title.getText();
		System.out.println(actual_title);
		//assertTrue((actual_title.equalsIgnoreCase(expected_title)));
	}
	
	public void enter_BranchNo(String no) {
		Branch_number.sendKeys(no);
	}

	public void enter_BoxNo(String no) {
		Box_number.sendKeys(no);
	}

	public void Click_SubmitBtn() {
		Submit_Btn.click();
	}

	public void Click_CancelBtn() {
		Cancel_Btn.click();
	}

	public void Click_clearAllBtn() {
		ClearAll_Btn.click();
	}

	public void Click_securityBtn() {
		Security_Btn.click();
	}

	public SD04_page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
