package Winwire.Maddies.TestScripts.LoginPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Winwire.Maddies.Helper.Assertion.AssertionHelper;
import Winwire.Maddies.Helper.Logger.LoggerHelper;
import Winwire.Maddies.Helper.browserConf.Configu.ObjectReader;
import Winwire.Maddies.PageObject.LoginPage;
import Winwire.Maddies.TestBase.TestBase;


public class LoginTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	@Test(description="Login test with valid credentials")
	public void testLoginToApplication(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		
		boolean status = loginPage.verifySuccessLoginMsg();
		
		AssertionHelper.updateTestStatus(status);
	}
}
