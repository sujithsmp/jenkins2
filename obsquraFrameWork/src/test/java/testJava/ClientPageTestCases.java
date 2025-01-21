package testJava;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.ClientPage;
import elementRepository.DashBoard;
//import elementRepository.ClientsPage;
import elementRepository.LoginPage1;
import utilities.BaseClass;

public class ClientPageTestCases extends BaseClass {
  @Test(priority=2,groups= {"regression"})
 public void verifyLoginFeatureAndToolTipValueOfEditButton() {
			LoginPage1 lp = new LoginPage1(driver);
			DashBoard db=lp.login("carol", "1q2w3e4r");

			ClientPage cp=db.clickClientsMenu();
			String actualResult = cp.getEditButtonToolTipValue();
			String expectedResult = "Update";
			Assert.assertEquals(actualResult, expectedResult, Constant.errorMessageVerifyClientTestCase);
  }
}
