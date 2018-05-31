package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class welcomeToMiser_loginScreen {
	WebDriver driver;

	
	@FindBy(xpath = "//*[@id='UserInformation']") 	
	 private WebElement UserId;
	
	
	@FindBy(id="btnContinueSignOn")
	private WebElement ContinueBtn;
	
	
	public void setUserID(String username)
	{
		UserId.sendKeys(username);
	}
	
	public void ClickSubmitBtn()
	{
		ContinueBtn.click();
	}
	 
	
	public welcomeToMiser_loginScreen(WebDriver driver)
	{
	    this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
