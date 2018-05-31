package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReverseArchivedBox {
	
	@FindBy(id="BRANCH-NBR")
	private WebElement branch;
	
	@FindBy(id="ISD-ACCT-BOX")
	private WebElement original_box_number;
	
	@FindBy(id="label")
	private WebElement txnTitle;
	
	
	
	public void enterBranch(String number)
	{
		branch.sendKeys(number);
	}
	
	public void enterOriginalBoxNumber(String number)
	{
		original_box_number.sendKeys(number);
	}

	public void verifyTitle(String title)
	{
		if((txnTitle.getText()).contentEquals(title))
		{
			
			System.out.println("ReverseArchivedBox Transaction title is correctly visible: "+txnTitle.getText());
		}
	}

}
