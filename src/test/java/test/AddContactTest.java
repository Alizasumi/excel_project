package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {
	
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("testData\\TF_TestData.xlsx");
	

	// Login data
	String FULL_NAME=exlRead.getCellData("AddContactInfo", "Full Name", 2);
	String COMPANY_NAME=exlRead.getCellData("AddContactInfo", "Company Name", 2);
	String EMAIL=exlRead.getCellData("AddContactInfo", "Email", 2);
	String PHONE=exlRead.getCellData("AddContactInfo", "Phone", 2);
	String ADDRESS=exlRead.getCellData("AddContactInfo", "Address", 2);
	String CITY=exlRead.getCellData("AddContactInfo", "City", 2);
	String COUNTRY=exlRead.getCellData("AddContactInfo", "Country", 2);
	String STATE=exlRead.getCellData("AddContactInfo", "State", 2);
	String Zip=exlRead.getCellData("AddContactInfo", "Zip", 2);
	
	
	@Test
	public void validUserShouldBeAbletoAddCustomer() {
		driver =BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.insertUserName("demo@techfios.com");
		login.insertPassword("abc123");
		login.clickOnSignInButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnADDCustomerButton();
		
		AddContactPage addContactPage= PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.verifyAddContactPage();
		addContactPage.insertFullName(FULL_NAME);
		addContactPage.selectCompany(COMPANY_NAME);
		addContactPage.insertEmail(EMAIL);
		addContactPage.insertPhone(PHONE);
		addContactPage.insertAddress(ADDRESS);
		addContactPage.insertCity(CITY);
		addContactPage.insertState(STATE);
		addContactPage.insertZip(Zip);
		addContactPage.insertCountryElement(COUNTRY);
		addContactPage.clickOnsaveButton();
		addContactPage.vrifiedProfilePage();
		
		dashboardPage.clickOnListCustomerButton();
		
		//addContactPage.verifyEnteredName();
		addContactPage.verifyEnteredNameAndDelete();
	
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
