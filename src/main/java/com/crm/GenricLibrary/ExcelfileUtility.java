package com.crm.GenricLibrary;

import java.awt.geom.IllegalPathStateException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of read the data from excel
 * @author ADMIN
 *
 */
public class ExcelfileUtility
{
   public String readthedatafroExcel(String SheetName,int rowno,int cellNo) throws Throwable
   {
	   FileInputStream fis = new FileInputStream(IpathofContrants.Excelpath);
	  Workbook book = WorkbookFactory.create(fis);
	  Sheet sheet = book.getSheet(SheetName);
	 Row row = sheet.getRow(rowno);
	 Cell cel = row.getCell(cellNo);
	 String value = cel.getStringCellValue();  
	 return value;
   }
   /**
    * This class consists of write data in Excel
    * @param SheetName
    * @param rowno
    * @param cellNo
    * @throws Throwable
    */
		   
   public void writedataintoExacel(String SheetName,int rowno,int cellNo) throws Throwable
   {
	   FileInputStream fis = new FileInputStream(IpathofContrants.Excelpath);
		  Workbook book = WorkbookFactory.create(fis);
		  Sheet sheet = book.getSheet(SheetName);
		  Row row = sheet.getRow(rowno);
		  Cell cel = row.createCell(cellNo);
		  
		  
		  FileOutputStream fis1= new FileOutputStream(IpathofContrants.Excelpath);
		  book.write(fis1);
   }
   /**
    * This method will return all row number
    * @param sheetname
    * @return
    * @throws Throwable
    */
   public int getrowcount(String sheetname) throws Throwable
   {
	   FileInputStream fis = new FileInputStream(IpathofContrants.Excelpath);
	  Workbook book = WorkbookFactory.create(fis);
	  Sheet shee= book.getSheet(sheetname);
	  int row = shee.getLastRowNum();
	  return row;
   }
   /**
	 * This method will read multiple data from excel sheet with the help of sheetname
	 * and return 2 dimensional object [][]
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathofContrants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i = 0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	
	}
}
