package com.AmazonAutomation.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.AmazonAutomation.base.TestBaseAmazon;

public class TestExcelUtil extends TestBaseAmazon{
	
	public static Map<String,String> getData() throws IOException{
		HashMap<String, String> excel= new HashMap<String, String> ();
		
		try {
			FileInputStream fs = new FileInputStream(prop.getProperty("excelsheetpath"));
			//Creating a workbook
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			for(int i=0;i<5;i++) {
				excel.put(sheet.getRow(0).getCell(i).toString(),sheet.getRow(1).getCell(i).toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		return excel;
	}


}
