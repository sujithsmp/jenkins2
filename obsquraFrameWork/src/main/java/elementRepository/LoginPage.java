package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="loginform-username")
	WebElement userName;
	
	@FindBy(id="loginform-password")
	WebElement passWord;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	
	public void inputUsername(String name)
	{
		//driver.findElement(userName).sendKeys("carol");
		userName.sendKeys(name);
	}
	
	public void inputPassword(String password)
	{
		//driver.findElement(passWord).sendKeys("1q2w3e4r");
		passWord.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		//driver.findElement(loginButton).click();
		loginButton.click();
	}

}
