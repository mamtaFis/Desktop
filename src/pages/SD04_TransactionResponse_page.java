package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SD04_TransactionResponse_page {
	WebDriver driver;

	@FindBy(xpath = "//table[@id='table1537']/tbody/tr/td")
	private List<WebElement> table_data;
	
	@FindBy(xpath="//*[@id=\"1\"]/td[1]")
	private WebElement first_row;

	@FindBy(id = "btnPrint")
	private WebElement preview_Btn;

	@FindBy(id = "btnDetailClose")
	private WebElement close_Btn;

	public void click_previewBtn() {
		preview_Btn.click();

	}

	public void click_CloseBtn() {
		close_Btn.click();

	}

	public void verifyTxn_response() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(preview_Btn));
		if (preview_Btn.isDisplayed()) {
			System.out.println("Transaction response is now visible to end user");
		} else
			System.out.println("response not visible");
	}

	public void click_first_row() {
		first_row.click();
		System.out.println(first_row.getText());
	}

	public SD04_TransactionResponse_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
