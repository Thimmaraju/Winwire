package Winwire.Maddies.PageObject;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Winwire.Maddies.Helper.Logger.LoggerHelper;
import Winwire.Maddies.Helper.browserConf.Configu.ObjectReader;
import Winwire.Maddies.Helper.wait.WaitHelper;
import Winwire.Maddies.TestBase.TestBase;

public class MaddiesRegistrationPage {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(MaddiesRegistrationPage.class);
	WaitHelper waitHelper;


	@FindBy(xpath="//*[@id=\"PersonalProfile_Email\"]")
	WebElement emailAddress;
	
	@FindBy(xpath="//*[@id=\"PersonalProfile_Password\"]")
	WebElement password;
		
	@FindBy(xpath="//*[@id=\"PersonalProfile_ConfirmPassword\"]")
	WebElement confirmpassword;
	
	@FindBy(xpath="//*[@id=\"PersonalProfile_ScreenName\"]")
	WebElement screenname;
	
	
	@FindBy(xpath="//*[@id=\"btnSubmit\"]")
	WebElement submit;
	
	public MaddiesRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(submit,ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("Maddies RegistrationPage object created...");
		new TestBase().getNavigationScreen(driver);
	}
	
	public void setEmailAddress(String emailAddress) {
		log.info("entering emailAddress.." + emailAddress);
		TestBase.logExtentReport("entering emailAddress.." + emailAddress);
		this.emailAddress.sendKeys(emailAddress);
	}
	
	public void setPassword(String password) {
		log.info("entering password.." + password);
		TestBase.logExtentReport("entering password.." + password);
		this.password.sendKeys(password);
	}
	
	public void setPasswordconf(String confpassword) {
		log.info("entering password.." + password);
		TestBase.logExtentReport("entering password.." + password);
		this.confirmpassword.sendKeys(confpassword);
	}
	
	public void setScreenname(String Screenname) {
		log.info("entering firstName.." + Screenname);
		TestBase.logExtentReport("entering Screenname.." + Screenname);
		this.screenname.sendKeys(Screenname);
	}

	public void clickOnSubmit() {
		log.info("clicked on Submit Button.." + submit);
		TestBase.logExtentReport("clicked on registration.." + submit);
		this.submit.click();
	}
}
