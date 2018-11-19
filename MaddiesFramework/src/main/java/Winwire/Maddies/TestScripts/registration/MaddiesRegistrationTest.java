package Winwire.Maddies.TestScripts.registration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Winwire.Maddies.Helper.Assertion.AssertionHelper;
import Winwire.Maddies.Helper.Logger.LoggerHelper;
import Winwire.Maddies.Helper.browserConf.Configu.ObjectReader;
import Winwire.Maddies.PageObject.AgreetermsnConditionsPage;
import Winwire.Maddies.PageObject.LoginPage;
import Winwire.Maddies.PageObject.MaddiesRegistrationPage;
import Winwire.Maddies.PageObject.MaddiesloginPage;
import Winwire.Maddies.PageObject.MyAccountPage;
import Winwire.Maddies.TestBase.TestBase;

public class MaddiesRegistrationTest extends TestBase {
	private final Logger log = LoggerHelper.getLogger(MaddiesRegistrationTest.class);
	MaddiesloginPage maddiesloginPage;
	MaddiesRegistrationPage  maddiesregister;
	AgreetermsnConditionsPage agreetermsPage;

	@Test
	public void testRegistration() throws InterruptedException{
		// go to application
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		maddiesloginPage = new MaddiesloginPage(driver);
		Thread.sleep(4000);
		maddiesloginPage.clickOnRegister();
		
				
		// enter registration data
		maddiesregister = new MaddiesRegistrationPage(driver);
		maddiesregister.setEmailAddress("testregi@gmail.com");
		maddiesregister.setPassword("123456");
		maddiesregister.setPasswordconf("123456");
		maddiesregister.setScreenname("ScTestRegi");
		maddiesregister.clickOnSubmit();
				
		//myAccountPage = new MyAccountPage(driver);
		//boolean status = myAccountPage.isYourAccountPageMessage();
		
		//AssertionHelper.updateTestStatus(status);
	}
}
