package Winwire.Maddies.TestScripts.LoginPage;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Winwire.Maddies.Helper.Assertion.AssertionHelper;
import Winwire.Maddies.Helper.Logger.LoggerHelper;
import Winwire.Maddies.Helper.browserConf.Configu.ObjectReader;
import Winwire.Maddies.PageObject.MaddiesHomePage;
import Winwire.Maddies.PageObject.MaddiesloginPage;
import Winwire.Maddies.TestBase.TestBase;

public class MaddiesLoginWithDataDrivenApproach extends TestBase{
	
	private final Logger log = LoggerHelper.getLogger(MaddiesLoginWithDataDrivenApproach.class);
	
	MaddiesloginPage maddiesloginpage;
	MaddiesHomePage maddiesHomePage;
	
	
	@DataProvider(name="testData")
	public Object[][] testData(){
		Object[][] data = getExcelData("testData.xlsx","Maddieslogindata");
		return data;
	}
	@BeforeClass
	public void beforeClass(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		maddiesloginpage = new MaddiesloginPage(driver);
	}
	@Test(dataProvider="testData")
	public void loginTest(String userName, String password, String runMode){
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("Run mode for this set of data is marked N");
		}
		maddiesloginpage.loginToApplication(userName, password);
		boolean status = maddiesloginpage.verifySuccessLoginMsg();
		AssertionHelper.updateTestStatus(status);
		maddiesloginpage.logout();
	}
}