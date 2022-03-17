package com.srm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDatafromExcelSheet
{
   @Test
   public void Passdatafromexceltest() throws Throwable
   {
	   //step:1 Select excel file
	   FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	   // step:2 Operator excel
	    Workbook wb = WorkbookFactory.create(fis);
	    //step:3 select sheet
	    Sheet sh =  wb.getSheet("Sheet1");
	    //step:4 get the row
	    Row row = sh.getRow(0);
	    //step:5 create cell to write new data
	    Cell ce = row.createCell(9);
	    //set a cell value
	    ce.setCellValue("tc_1000");
	    //open file in write mode
	    FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Data.xlsx");
	    wb.write(fos);
	 }
     }
