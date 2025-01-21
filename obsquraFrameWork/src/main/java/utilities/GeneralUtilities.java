package utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	public String getElementText(WebElement element)
	{
		String text=element.getText();
		
		return text;
		

	}

	public String getToolTipValue(WebElement element) 
	{
		String toolTipValue=element.getDomAttribute("title");
		return toolTipValue;
	}
	public boolean getCheckBoxStatus(WebElement element) 
	{
		boolean checkBoxstatus=element.isSelected();
		return checkBoxstatus;
	}
	public void forSendKeys(WebElement element,String value)
	{
		element.sendKeys(value);
		
		
	}
	public void clickOnElement(WebElement element)
	{
		element.click();
			
	}
	public void getDropDown(WebElement element,String value)
	{
		Select op=new Select(element);
		op.selectByVisibleText(value);
			
	}
	public String getDropDownGetMethod(WebElement element)
	{
		Select op=new Select(element);
		//op.selectByVisibleText(value);
		return op.getFirstSelectedOption().getText();
			
	}
	public void getDropDownMultipleValue(WebElement element,List<String>options)
	{
		Select mulOp=new Select(element);
		for(String op:options)
		{
			mulOp.selectByVisibleText(op);
		}
			
	}
	public List<String> getDropDownMultipleValueGetMethod(WebElement element)
	{
		Select mulOp=new Select(element);
		List<String>options=new ArrayList<>();
		List<WebElement> ele=mulOp.getAllSelectedOptions();
		for(WebElement op:ele)
		{
			options.add(op.getText());
		}
		return options;	
	}
}
