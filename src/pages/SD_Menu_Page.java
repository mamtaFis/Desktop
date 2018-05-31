package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SD_Menu_Page {
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(text(),'Safe Deposit Box Menu (SD)')]")
	private WebElement txn_title;
	
	@FindBy(xpath="//label[contains(text(),'History Inquiry')]")
	private WebElement history_inquiry_SD004;
	
	
	public void verifyTxn()
	{
		if(txn_title.isDisplayed())
		{
			System.out.println("SD main menu is visible to user");
		}
	}
	
	
	public SD_Menu_Page(WebDriver driver)
	{
	    this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click_SD04()
	{
		history_inquiry_SD004.click();
		System.out.println("SD transaction opened up");
	}

}
