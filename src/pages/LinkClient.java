package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkClient {
	WebDriver driver;

	@FindBy(id = "label")
	private WebElement txnTitle;
	
	@FindBy(id="ICF-CIF-NBR")
	private WebElement ClientNumber;
	
	@FindBy(id="clientSearchER")
	private WebElement ClientSearchBtn;
	
	@FindBy(id="ISD-ACCT-BR")
	private WebElement Branch;
	
	@FindBy(id="ISD-ACCT-BOX")
	private WebElement Box;

	public void enterClientNumber(String no)
	{
		ClientNumber.sendKeys(no);
	}
	public void verifyTitle(String title) {
		if ((txnTitle.getText()).contentEquals(title)) {

			System.out.println("ReverseArchivedBox Transaction title is correctly visible: " + txnTitle.getText());
		}
	}

	public LinkClient(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
