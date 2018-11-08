package Winwire.Maddies.TestScripts.registration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Winwire.Maddies.Helper.Assertion.AssertionHelper;
import Winwire.Maddies.Helper.Logger.LoggerHelper;
import Winwire.Maddies.Helper.browserConf.Configu.ObjectReader;
import Winwire.Maddies.PageObject.LoginPage;
import Winwire.Maddies.PageObject.MyAccountPage;
import Winwire.Maddies.PageObject.RegistrationPage;
import Winwire.Maddies.TestBase.TestBase;


public class RegistrationTest extends TestBase{
	
	private final Logger log = LoggerHelper.getLogger(RegistrationTest.class);
	LoginPage loginPage;
	RegistrationPage register;
	MyAccountPage myAccountPage;
	
	@Test
	public void testRegistration(){
		// go to application
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		loginPage = new LoginPage(driver);
		loginPage.clickOnSignInLink();
		loginPage.enterRegistrationEmail();
		
		register = loginPage.clickOnCreateAnAccount();
		
		// enter registration data
		register.setMrRadioButton();
		register.setFirstName("firstName");
		register.setLastname("lastname");
		register.setPassword("password");
		register.setAddress("address");
		register.setDay("5");
		register.setMonth("June");
		register.setYear("2017");
		register.setYourAddressFirstName("yourAddressFirstName");
		register.setYourAddressLastName("yourAddressLastName");
		register.setYourAddressCompany("yourAddressCompany");
		register.setYourAddressCity("yourAddressCity");
		register.setYourAddressState("Alaska");
		register.setYourAddressPostCode("99501");
		register.setMobilePhone("9999999999");
		register.setAddressAlias("addressAlias");
		register.clickRegistration();
		
		myAccountPage = new MyAccountPage(driver);
		boolean status = myAccountPage.isYourAccountPageMessage();
		
		AssertionHelper.updateTestStatus(status);
	}
}
