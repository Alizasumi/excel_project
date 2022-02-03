package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddContactPage extends BasePage {

	public AddContactPage(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Add Contact')]")
	WebElement addContactElement;
	@FindBy(how = How.XPATH, using = "//input[@name='account']")
	WebElement fullNameElement;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement companyNameElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement emailElement;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement phoneNumberElement;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement addressElement;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement cityElement;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement stateElement;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement zipElement;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement countryElement;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement saveAccountElement;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),' Create Auto Login URL')]")
	WebElement summaryOnProfileElement;

	public void verifyAddContactPage() {
		Assert.assertEquals(addContactElement.getText(), "Add Contact", "wrong page");
	}
	String generatedName;
	public void insertFullName(String name) {
		generatedName = name + generateRandomNo(999);
		fullNameElement.sendKeys(generatedName);
	}

	public void selectCompany(String company) {
		selectFromDropDown(companyNameElement, company);
	}

	public void insertEmail(String email) {
		emailElement.sendKeys(generateRandomNo(999) + email);
	}

	public void insertPhone(String phone) {
		phoneNumberElement.sendKeys(phone + generateRandomNo(999));
	}

	public void insertAddress(String address) {
		addressElement.sendKeys(address);
	}

	public void insertCity(String city) {
		cityElement.sendKeys(city);
	}

	public void insertState(String state) {
		stateElement.sendKeys(state);
	}

	public void insertZip(String zip) {
		zipElement.sendKeys(zip);
	}

	public void insertCountryElement(String country) {
		selectFromDropDown(countryElement, country);
	}

	public void clickOnsaveButton() {
		saveAccountElement.click();
	}

	public void vrifiedProfilePage() {
		waitForElement(driver, 5, summaryOnProfileElement);
//	Assert.assertEquals(summaryOnProfileElement.getText(), "Create Auto Login URL", "wrong page");

	}
	
	

	// tbody/tr[1]/td[3]
	// tbody/tr[2]/td[3]
	// tbody/tr[3]/td[3]
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	String beforeXpath = "//tbody/tr[";
	String AfterXpath = "]/td[3]";
	String afterXpathDelete="]/td[3]/following-sibling::td[4]/a[2]";
	

	public void verifyEnteredNameAndDelete() {
		for (int i = 1; i <= 10; i++) {
			String enteredName = driver.findElement(By.xpath(beforeXpath + i + AfterXpath)).getText();
			/*System.out.println(enteredName);
			Assert.assertEquals(enteredName, generatedName, "entered name doesn't exist");
			*/
			if(enteredName.contains(generatedName)) {
				driver.findElement(By.xpath(beforeXpath+i +afterXpathDelete)).click();
			}
			
			break;
		}

	}

}
