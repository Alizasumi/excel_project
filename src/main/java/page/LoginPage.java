package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	WebDriver driver;
	
	// Login data
	String USER_NAME = "demo@techfios.com";
	String PASSWORD = "abc123";
	
	By userNameField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");
	By signInButtonField = By.xpath("//button[@type='submit']");

	@FindBy (how =How.XPATH,using = "//input[@id='username']") WebElement userNameElement;
	@FindBy (how = How.XPATH,using = "//input[@id='password']") WebElement passwordElement;
	@FindBy (how = How.XPATH,using = "//button[@type='submit']") WebElement signInButtonElement;
	
	//its better to go with individual methods
	public void insertUserName(String userName) {
		userNameElement.sendKeys(userName);
	}
	public void insertPassword(String password) {
		passwordElement.sendKeys(password);
	}
	public void clickOnSignInButton() {
		signInButtonElement.click();
	}
	
/*	public void loginTest(String userName, String password) {
		userNameElement.sendKeys(userName);
		passwordElement.sendKeys(password);
		signInButtonElement.click();
	}
*/

}
