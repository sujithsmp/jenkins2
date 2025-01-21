package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	WebDriver driver;
	public MainPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='reset it']")
	WebElement resetHyperlink;
	@FindBy(xpath="//button[text()='Send']")
	WebElement sendButton;
	
	public void clickOnResetHyperLink()
	{
		resetHyperlink.click();
	}
	
	public String getSendButtontext()
	{
		String actualResult=sendButton.getText();
		return actualResult;
	}
	public String checkCssValueOfSendButton()
	{
		String cssValue=sendButton.getCssValue("font-family");;
		return cssValue;
	}
}
