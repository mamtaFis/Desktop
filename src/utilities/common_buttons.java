package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class common_buttons {
	WebDriver common_buttons_driver;

	@FindBy(id = "btnSubmit")
	private WebElement submitBtn;

	@FindBy(id = "btnSup")
	private WebElement securityBtn;

	@FindBy(id = "btnCleareAll")
	private WebElement clearAllBtn;

	@FindBy(id = "btnCancel")
	private WebElement cancelBtn;

	@FindBy(id="inputInfo")
	private WebElement infoIcon;
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}

	public void clickSecurityBtn() {
		securityBtn.click();
	}

	public void clickClearAllBtn() {
		clearAllBtn.click();
	}

	public void clickCancelBtn() {
		cancelBtn.click();
	}
	
	public void clickInfoIcon() {
		infoIcon.click();
	}

	public common_buttons(WebDriver driver)
	{
		this.common_buttons_driver = driver;
		PageFactory.initElements(driver, this);
	}
}
