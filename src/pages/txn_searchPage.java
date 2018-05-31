package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class txn_searchPage {
WebDriver driver;

	   @FindBy(id="tranSearchText")
		public WebElement Txn_no_inputField;	
	
	   @FindBy(id="btnSearchTran")
		public WebElement Txn_search_btn;	
	   
	   public void enter_txn_no(String no)
	   {
		   Txn_no_inputField.click();
		   Txn_no_inputField.sendKeys(no);
		   Txn_search_btn.click();
	   }
	
	   
	 public txn_searchPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
}
