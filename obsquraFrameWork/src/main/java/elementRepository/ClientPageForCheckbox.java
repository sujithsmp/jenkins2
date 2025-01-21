package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ClientPageForCheckbox {
	WebDriver driver;
	GeneralUtilities utilities= new GeneralUtilities();

    @FindBy(xpath = "//a[text()='Clients']")
    WebElement clientsMenu;

    @FindBy(xpath = "//a[text()='Create Client']")
    WebElement createClientButton;

    @FindBy(id = "client-require_po")
    WebElement requirePOCheckBox;

   
    public ClientPageForCheckbox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    public void clickClientsMenu() {
        utilities.clickOnElement(clientsMenu);
    }

    public void clickCreateClient() {
    	utilities.clickOnElement(createClientButton);
    }

    public void clickRequirePOCheckBox() {
    	utilities.clickOnElement(requirePOCheckBox);
    }

    public boolean isRequirePOCheckBoxSelected() {
        return utilities.getCheckBoxStatus(requirePOCheckBox);
    }


}
