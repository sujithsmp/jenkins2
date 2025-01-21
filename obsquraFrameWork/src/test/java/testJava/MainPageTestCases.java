package testJava;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.MainPage;
//import TestNg

public class MainPageTestCases extends BaseClass {
	
  
	  @Test(priority = 1,groups= {"regression"},retryAnalyzer=testJava.RetryAnalyzer.class)
		public void clickResetItHyperlinkAndVerifyTextOfSendButton() {
			MainPage mp = new MainPage(driver);
			mp.clickOnResetHyperLink();
			String actualText = mp.getSendButtontext();
			Assert.assertEquals(actualText, "Send", "Text is incorrect...");
		}

		@Test(priority = 2,groups= {"regression"})
		public void clickResetItHyperlinkAndVerifyFontTypeOfSendButtonText() {
			MainPage mp = new MainPage(driver);
			mp.clickOnResetHyperLink();
			String actualFontType = mp.checkCssValueOfSendButton();
			Assert.assertEquals(actualFontType, "Overpass, sans-serif", "Font type is incorrect...");
		}
	  
	  
  }
  
  

