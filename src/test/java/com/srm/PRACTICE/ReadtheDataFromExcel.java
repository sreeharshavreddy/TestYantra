package com.srm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadtheDataFromExcel 
{   
	@Test
   public void Readthedataexcle() throws IOException
   {
	   FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx"); 
	   Workbook book = WorkbookFactory.create(fis);
	   Sheet sh = book.getSheet("Sheet1");
	        Row row = sh.getRow(0);
	        Cell cell = row.getCell(1);
	        String string = cell.getStringCellValue();
	        System.out.println(string);
   }
}
