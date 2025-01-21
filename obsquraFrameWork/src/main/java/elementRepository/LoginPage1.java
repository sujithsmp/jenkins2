package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage1 {
	GeneralUtilities utilities= new GeneralUtilities();
	WebDriver driver;

    @FindBy(id = "loginform-username")
     WebElement usernameField;

    @FindBy(id = "loginform-password")
     WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public LoginPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DashBoard login(String username, String password) {
		/*
		 * usernameField.sendKeys(username); passwordField.sendKeys(password);
		 * loginButton.click();
		 */
    	utilities.forSendKeys(usernameField,username);
    	utilities.forSendKeys(passwordField,password);
    	utilities.clickOnElement(loginButton);
    	
    	return new DashBoard(driver);
    }

}
