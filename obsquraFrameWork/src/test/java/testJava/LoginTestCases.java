package testJava;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.DashBoard;
//import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import elementRepository.LoginPage1;

public class LoginTestCases extends BaseClass {
	@Test(priority=1,groups= {"sanity"})
	public void verifyLoginFeatureIsValidWithCredential() {
		LoginPage1 lp = new LoginPage1(driver);
		/*
		 * lp.inputUsername("carol"); lp.inputPassword("1q2w3e4r");
		 * lp.clickLoginButton();
		 */
		//lp.login("carol", "1q2w3e4r");

		DashBoard dp = lp.login(p.getProperty("username"), p.getProperty("pwd"));

		String actual = dp.getTextOfWelcomeText();
		

		String expected = "Welcome to Payroll Application";

		Assert.assertEquals(actual, expected, "Actual text is not match with expected text");
	}
}
