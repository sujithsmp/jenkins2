package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ClientPage {
	
	WebDriver driver;
	GeneralUtilities utilities= new GeneralUtilities();
	public ClientPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Clients']")
	WebElement clientsMenu;
	@FindBy(xpath="//table//tbody//tr[1]//td[6]//a[@title='Update']")
	WebElement toolTipValue;
	
	public void clickClientsMenu() {
		utilities.clickOnElement(clientsMenu);
		//return new ClientPage(driver);
    }
	
	public String getEditButtonToolTipValue() {
		return utilities.getToolTipValue(toolTipValue);
	}

}
