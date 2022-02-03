package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;


public class LoginTest {
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("testData\\TF_TestData.xlsx");
	

	// Login data
	String USER_NAME=exlRead.getCellData("LoginInfo", "UserName", 2);
	String Password=exlRead.getCellData("LoginInfo", "Password", 2);
	
	
	// inheritance //object// by the name of the class
	@Test
	public void verifiedUserShouldBeAbleToLogin() {
		
		driver =BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.insertUserName(USER_NAME);
		login.insertPassword(Password);
		login.clickOnSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnADDCustomerButton();
		//BrowserFactory.tearDown();
		
		
	}

}
