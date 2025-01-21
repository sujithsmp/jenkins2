package testJava;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.DashBoard;
import elementRepository.LoginPage1;
import elementRepository.WorkersPage;

public class WorkersPageTest extends BaseClass{
  @Test(priority=3,groups= {"sanity"})
  public void verifyAnyOptionFromTitleDropDownInsideWorkerMenu() throws InterruptedException {
	  LoginPage1 loginPage = new LoginPage1(driver);
	  //WorkersPage wp = new WorkersPage(driver);

		DashBoard db=loginPage.login("carol", "1q2w3e4r");
		WorkersPage wp=db.clickWorkersMenu();
		wp.clickWorkersMenu();
		wp.clickCreateWorkerMenu();
		wp.selectOption("Mr");

		Thread.sleep(1000);
		String actualResult = wp.getSelectedOPtion();
		String expectedResult = "Mr";
		Assert.assertEquals(actualResult, expectedResult);
		
		/*
		 * Thread.sleep(1000); List<String> selectOptions=new ArrayList<>();
		 * selectOptions.add("Mr"); selectOptions.add("Ms");
		 * wp.selectOptions(selectOptions); List<String>
		 * actualSelected=wp.getSelectOptions(); Assert.assertEquals(actualSelected,
		 * selectOptions);
		 * 
		 * Assert.assertEquals(actualResult, expectedResult,
		 * "Actual selected option and expected option do not match");
		 */
  }
}
