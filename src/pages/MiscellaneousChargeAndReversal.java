package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiscellaneousChargeAndReversal {
	WebDriver driver;

	@FindBy(id="ISD-ACCT-BR")
	private WebElement branch_number;
	
	@FindBy(id="ISD-ACCT-BOX")
	private WebElement original_box_number;
	
	@FindBy(id="label")
	private WebElement txnTitle;
	

	public void enterBranchNumber(String no)
	{
		branch_number.sendKeys(no);
	}
	
	public void enterOriginalBoxNumber(String box_no)
	{
		original_box_number.sendKeys(box_no);
	}
	
	public void verifyTitle(String title)
	{
		if((txnTitle.getText()).contentEquals(title))
		{
			
			System.out.println("ReverseArchivedBox Transaction title is correctly visible: "+txnTitle.getText());
		}
	}
	
	public MiscellaneousChargeAndReversal(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
