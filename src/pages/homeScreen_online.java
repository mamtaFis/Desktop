package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homeScreen_online {
	WebDriver driver;
	
	
   @FindBy(xpath="//*[@id='dvBusinessTellerView']//input")
	public WebElement businessViewInputBox;
   
   @FindBy(xpath="//a[contains(text(),'Sign Off')]")
  	public WebElement SignOffLInk;
   
   @FindBy(xpath="//*[@class='ui-dialog-buttonset']//*[text()='Yes']")
   private WebElement signOff_YesLink;
	
   public void clickBusinessView()
   {
	   businessViewInputBox.click();
   }
   
   public void clickSignOff()
   {
	   SignOffLInk.click();
	   signOff_YesLink.click();
   }
   
   public void verifyLogin()
   {
	   if(businessViewInputBox.isDisplayed())
	   {
		   System.out.println("Business view input box is visible, so User is logged-in");
	   }
   }
   
   public homeScreen_online(WebDriver driver)
	{
	    this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
