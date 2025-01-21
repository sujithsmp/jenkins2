package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	FileInputStream file;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow r;
	XSSFCell c;
	String path;
	
	public ExcelUtilities(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{
		file=new FileInputStream(path);
		wb=new XSSFWorkbook(file);
		sheet=wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		wb.close();
		file.close();
		return rowCount;
	}
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		file=new FileInputStream(path);
		wb=new XSSFWorkbook(file);
		sheet=wb.getSheet(sheetName);
		/*
		 * r=sheet.getRow(rowNum); int ColCount=r.getLastCellNum();
		 */
		int ColCount=sheet.getRow(rownum).getLastCellNum();
		wb.close();
		file.close();
		return ColCount;
	}
	
	public String getCellData(String sheetName,int rownum, int colnum) throws IOException
	{
		file=new FileInputStream(path);
		wb=new XSSFWorkbook(file);
		sheet=wb.getSheet(sheetName);
		r=sheet.getRow(rownum);
		c=r.getCell(colnum);
		String data;
		
		//DataFormatter formatter=new DataFormatter();
		data=c.toString();
	/*
	 * try { data=formatter.formatCellValue(c); } catch(Exception e) { data=" "; }
	 */
		wb.close();
		file.close();
		return data;
	}

}
