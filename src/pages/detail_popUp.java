package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class detail_popUp {
	
	@FindBy(xpath="//*[contains(text(),'Preview')]")
	private WebElement previewBtn;
	
	@FindBy(id="btnDetailClose")
	private WebElement CloseBtn;
	
	public void click_previewBtn()
	{
		previewBtn.click();
	}
	
	public void click_CloseBtn()
	{
		CloseBtn.click();
	}
	

}
