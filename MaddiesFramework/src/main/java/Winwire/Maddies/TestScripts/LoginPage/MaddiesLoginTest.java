package Winwire.Maddies.TestScripts.LoginPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Winwire.Maddies.Helper.Assertion.AssertionHelper;
import Winwire.Maddies.Helper.Logger.LoggerHelper;
import Winwire.Maddies.Helper.browserConf.Configu.ObjectReader;
import Winwire.Maddies.PageObject.MaddiesloginPage;
import Winwire.Maddies.TestBase.TestBase;

public class MaddiesLoginTest extends TestBase {
	
private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	@Test(description="Login test with valid credentials")
	public void testLoginToApplication(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		MaddiesloginPage maddiesloginPage = new MaddiesloginPage(driver);
		
		maddiesloginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		
		boolean status = maddiesloginPage.verifySuccessLoginMsg();
		
		AssertionHelper.updateTestStatus(status);
		maddiesloginPage.logout();
}
}
