package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using="//h2[contains(text(),' Dashboard ')]") WebElement dashBoardElement;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Customers')]") WebElement customerElement;
	@FindBy(how = How.XPATH, using="//a[contains(text(),'Add Customer')]") WebElement addCustoemrElement;
	@FindBy(how = How.XPATH, using="//a[contains(text(),'List Customers')]") WebElement listCustoemrElement;

	public void verifyDashboardPage() {
		Assert.assertEquals(dashBoardElement.getText(), "Dashboard", "wrong page");
	}

	public void clickOnCustomerButton() {
		customerElement.click();
	}
	public void clickOnADDCustomerButton() {
		addCustoemrElement.click();
	}
	public void clickOnListCustomerButton() {
		listCustoemrElement.click();
	}
}
