package Winwire.Maddies.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Winwire.Maddies.Helper.Assertion.VerificationHelper;
import Winwire.Maddies.Helper.Logger.LoggerHelper;
import Winwire.Maddies.Helper.browserConf.Configu.ObjectReader;
import Winwire.Maddies.Helper.wait.WaitHelper;
import Winwire.Maddies.TestBase.TestBase;

public class MaddiesloginPage {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);

	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id=\"mvcforum-nav\"]/ul/li[2]/a")
	WebElement Login;
	
	@FindBy(xpath = "//*[@id=\"UserName\"]")
	WebElement emailAddress;

	@FindBy(xpath = "//*[@id=\"Password\"]")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"btnSubmit\"]")
	WebElement submitLogin;

	@FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[2]/div[1]/h2")
	WebElement successMsgObject;

	@FindBy(xpath="//*[@id=\"align-padding\"]/div/img")
	WebElement Avatarimg;
	
	@FindBy(xpath="//*[@id=\"dropdown-menu\"]/li[6]/a")
	WebElement logout;
	
	public MaddiesloginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(Login, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		TestBase.logExtentReport(" Maddies Login Page Object Created");
	}

	public void clickOnSignInLink(){
		log.info("clicked on sign in link...");
		logExtentReport("clicked on sign in link...");
		Login.click();
	}
	
	public void enterEmailAddress(String emailAddress) {
		log.info("entering email address...." + emailAddress);
		logExtentReport("entering email address...." + emailAddress);
		this.emailAddress.sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		log.info("entering password...." + password);
		logExtentReport("entering password...." + password);
		this.password.sendKeys(password);
	}

	public MaddiesHomePage clickOnSubmitButton() {
		log.info("clicking on submit button...");
		logExtentReport("clicking on submit button...");
		submitLogin.click();
		return new MaddiesHomePage(driver);
	}

	public boolean verifySuccessLoginMsg() {
		return new VerificationHelper(driver).isDisplayed(successMsgObject);
	}

	public void loginToApplication(String emailAddress, String password) {
		clickOnSignInLink();
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
		//logout();
	}

	public void logout(){
		Avatarimg.click();
		logout.click();
		log.info("clicked on logout link");
		waitHelper.waitForElement(Login, ObjectReader.reader.getExplicitWait());
	}
	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
	}

}
