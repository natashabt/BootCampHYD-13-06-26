//use for loop for entire content.

package com.DataDrivenTestingUsingApache;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTestDemo {
	
	public static void main(String[] args) throws IOException {
		 File src = new File("C:\\ApacheTestData\\Data.xlsx");
		 FileInputStream fis = new FileInputStream(src);
		 
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 XSSFSheet sheet1 = wb.getSheetAt(0);
		 
		 int rows = sheet1.getLastRowNum();
		 
		 for(int i = 0; i<=rows; i++) {
			 String data = sheet1.getRow(i).getCell(0).getStringCellValue();
			 System.out.println("Data from Row is ..." + i + " " + data);
		 }
		 
	}

}
