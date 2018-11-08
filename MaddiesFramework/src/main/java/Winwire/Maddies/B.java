package Winwire.Maddies;


import org.testng.Assert;
import org.testng.annotations.Test;

import Winwire.Maddies.TestBase.TestBase;


public class B extends TestBase{
	int i = 1;
	
	@Test
	public void testLoginB(){
		if(i == 3){
			Assert.assertTrue(true);	
		}
		else{
			System.out.println(i);
			i++;
			Assert.assertTrue(false);	
		}	
	}

}
