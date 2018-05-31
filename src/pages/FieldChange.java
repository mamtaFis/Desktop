package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FieldChange {
WebDriver driver;

	@FindBy(id="label")
	private WebElement txnTitle;
	
	@FindBy(id="ISD-ACCT-BR")
	private WebElement branch;
	
	@FindBy(id="ISD-ACCT-BOX")
	private WebElement box;	

	@FindBy(id="ISD-FIELD-NBR(01)")
	private WebElement field_number;
	
	@FindBy(id="ISD-OLD-DATA-NBR")
	private WebElement old_data;
	
	@FindBy(id="ISD-NEW-DATA-NBR")
	private WebElement new_data;
	

	public void enterBranchNumber(String branch_number)
	{
		branch.sendKeys(branch_number);
	}

	public void enterBox(String box_number)
	{
		box.sendKeys(box_number);
	}

	public void enterFieldNumber(String field_no)
	{
		field_number.sendKeys(field_no);
	}
	
	public void enterOldData(String old_key)
	{
		old_data.sendKeys(old_key);
	}
	
	public void enterNewData(String new_key)
	{
		new_data.sendKeys(new_key);
	}
	
	public void verifyTitle(String title)
	{
		if((txnTitle.getText()).equalsIgnoreCase(title))
		{
			System.out.println("Transaction title is correctly visible: "+txnTitle.getText());
		}
	}

	public FieldChange(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
