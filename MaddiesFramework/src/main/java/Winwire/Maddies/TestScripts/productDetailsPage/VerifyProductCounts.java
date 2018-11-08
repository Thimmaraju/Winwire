package Winwire.Maddies.TestScripts.productDetailsPage;

import org.testng.annotations.Test;

import Winwire.Maddies.Helper.Assertion.AssertionHelper;
import Winwire.Maddies.PageObject.ApplicationText;
import Winwire.Maddies.PageObject.LoginPage;
import Winwire.Maddies.PageObject.NavigationMenu;
import Winwire.Maddies.PageObject.ProductCategoryPage;
import Winwire.Maddies.TestBase.TestBase;


public class VerifyProductCounts extends TestBase{
	
	LoginPage loginPage;
	NavigationMenu navigationMenu;
	
	@Test
	public void testVerifyProductCounts(){
		
		navigationMenu = new NavigationMenu(driver);
		ProductCategoryPage pCate = navigationMenu.clickOnMenu(navigationMenu.womenMenu);
		
		pCate.selectColor(ApplicationText.Orange);
		int count = pCate.getTotalProducts();
		
		if(count==3){
			AssertionHelper.markPass();
		}
		else{
			AssertionHelper.markFail("product count is not matching");
		}
	}
}
