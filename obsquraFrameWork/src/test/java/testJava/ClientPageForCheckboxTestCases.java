package testJava;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.ClientPageForCheckbox;
//import elementRepository.ClientsPage1;
import elementRepository.LoginPage1;
import utilities.BaseClass;

public class ClientPageForCheckboxTestCases extends BaseClass{
  @Test
  public void verifyCheckBoxIsSelectedOrNotInClientMenu() {
	  LoginPage1 loginPage = new LoginPage1(driver);
	  ClientPageForCheckbox cp = new ClientPageForCheckbox(driver);
		loginPage.login("carol", "1q2w3e4r");

		cp.clickClientsMenu();
		cp.clickCreateClient();
		cp.clickRequirePOCheckBox();
		boolean actualResult = cp.isRequirePOCheckBoxSelected();
		boolean expectedResult = true;

		Assert.assertEquals(actualResult, expectedResult, "Checkbox is not selected");
  }
}
