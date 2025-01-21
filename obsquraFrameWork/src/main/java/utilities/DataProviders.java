package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import lombok.Data;

public class DataProviders {

	@DataProvider(name="LoginData")
	public Object[][] getData() throws IOException
	{
		String path=".\\src\\main\\resources\\Book1.xlsx";
		ExcelUtilities xlutil=new ExcelUtilities(path);
		
		int totalRows=xlutil.getRowCount("Sheet1");
		int totalCol=xlutil.getCellCount("Sheet1",1);
		
		Object[][] loginData=new Object[totalRows][totalCol];
		
		for(int i=1;i<totalRows;i++)
		{
			for(int j=0;j<totalCol;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}
}
