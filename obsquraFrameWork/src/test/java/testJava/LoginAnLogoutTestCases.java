package testJava;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.DashBoard;
import elementRepository.LoginPage1;
import utilities.DataProviders;

public class LoginAnLogoutTestCases extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class )
	public void loginAndLogOff(String username,String Password,String status) {
		try {
	LoginPage1 lp = new LoginPage1(driver);
	
	
 //login
	DashBoard db = lp.login(username, Password);
	
	//dashboard
	String actual = db.getTextOfWelcomeText();
	

	String expected = "Welcome to Payroll Application";
	System.out.println(actual);
	
	
	if(status.equalsIgnoreCase("Valid"))
	{
		if(actual.equals(expected))
		{
			db.logout();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	if(status.equalsIgnoreCase("invalid"))
	{
		if(actual.equals(expected))
		{
			db.logout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
		
	}
	

	/*
	 * Assert.assertEquals(actual, expected,
	 * "Actual text is not match with expected text");
	 * 
	 * //logout db.logout();
	 */
		}
		catch(Exception e)
		{
		 Assert.fail();
		}
	
	

	}
}
