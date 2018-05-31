package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReturnBoxToService {
	
	@FindBy(id="ISD-ACCT-BR")
	private WebElement branch_number;
	
	@FindBy(id="ISD-ACCT-BOX")
	private WebElement original_box_number;	

	@FindBy(id="label")
	private WebElement txnTitle;

	public void enterBranchNumber(String number)
	{
		branch_number.sendKeys(number);
	}

	public void enterOriginalBoxNumber(String number)
	{
		original_box_number.sendKeys(number);
	}
	
	public void verifyTitle(String title)
	{
		if((txnTitle.getText()).equalsIgnoreCase(title))
		{
			System.out.println("Transaction title is correctly visible: "+txnTitle.getText());
		}
	}

	
}
