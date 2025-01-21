package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class WorkersPage {
WebDriver driver;
GeneralUtilities utilities= new GeneralUtilities();
	

    public WorkersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Workers']")
    WebElement workersMenu;

    @FindBy(xpath = "//a[text()='Create Worker']")
    WebElement createWorkerMenu;

    @FindBy(id = "worker-title")
    WebElement titleDropDown;

   
    public void clickWorkersMenu() {
        utilities.clickOnElement(workersMenu);
    }

    public void clickCreateWorkerMenu() {
        utilities.clickOnElement(createWorkerMenu);
    }

    public void selectOption(String option) {
		/*
		 * Select dropdown = new Select(titleDropDown);
		 * dropdown.selectByVisibleText(title);
		 */
    	utilities.getDropDown(titleDropDown,option);
    }

    public String getSelectedOPtion() {
		/*
		 * Select dropdown = new Select(titleDropDown); return
		 * dropdown.getFirstSelectedOption().getText();
		 */
    	return utilities.getDropDownGetMethod(titleDropDown);
    }
    
    public void selectOptions(List<String>options) {
    	utilities.getDropDownMultipleValue(titleDropDown,options);
    }
    public List<String> getSelectOptions() {
    	return utilities.getDropDownMultipleValueGetMethod(titleDropDown);
    }
    
    
}
