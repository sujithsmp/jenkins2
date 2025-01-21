package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashBoard {
WebDriver driver;
GeneralUtilities utilities= new GeneralUtilities();
	
	public DashBoard(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
	}
	
	@FindBy(xpath="//p[text()='Welcome to Payroll Application']")
	WebElement welcomeText;
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement logoutdropdown;
	@FindBy(xpath="//a[@class='logout-btn']")
	WebElement logoutButton;
	@FindBy(xpath="//a[text()='Clients']")
	WebElement clientsMenu;
	 @FindBy(xpath = "//a[text()='Workers']")
	    WebElement workersMenu;

	
	
	public String getTextOfWelcomeText()
	{
		try
		{
		return utilities.getElementText(welcomeText);
		}
		catch(Exception e)
		{
			return "false";
		}

	}
	public void logout()
	{
		 utilities.clickOnElement(logoutdropdown);
		 utilities.clickOnElement(logoutButton);

	}
	public ClientPage clickClientsMenu() {
		utilities.clickOnElement(clientsMenu);
		return new ClientPage(driver);
    }
	 public WorkersPage clickWorkersMenu() {
	        utilities.clickOnElement(workersMenu);
	        return new WorkersPage(driver);
	    }
	

}
