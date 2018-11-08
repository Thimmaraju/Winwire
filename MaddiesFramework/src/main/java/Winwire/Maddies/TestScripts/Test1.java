package Winwire.Maddies.TestScripts;

import org.testng.annotations.Test;

import Winwire.Maddies.Helper.Assertion.AssertionHelper;
import Winwire.Maddies.TestBase.TestBase;


public class Test1 extends TestBase{

	
	@Test
	public void testLogin(){
		AssertionHelper.markPass();
	}
	
	@Test
	public void testLogin1(){
		AssertionHelper.markFail();
	}
	
	@Test
	public void testLogin2(){
		AssertionHelper.markPass();
	}
	
	@Test
	public void testLogin3(){
		AssertionHelper.markFail();
	}
}
