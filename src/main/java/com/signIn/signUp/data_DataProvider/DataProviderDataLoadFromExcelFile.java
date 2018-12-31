package com.signIn.signUp.data_DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderDataLoadFromExcelFile {
	
	public static Object[][] dataProvderDatasFromExcelFile(String file, int sheetNo) throws IOException
	{
		File f=new File(file);
		FileInputStream fs=new FileInputStream(f);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet= workbook.getSheetAt(sheetNo);
		
		Object [][]datas=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=1; i<=sheet.getLastRowNum(); i++)
		{
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++)
			{
				XSSFCell cell=sheet.getRow(i).getCell(j);
				switch (cell.getCellType())
				{
				case STRING:
					datas[i-1][j]=cell.getStringCellValue();
					break;
					
				case NUMERIC:
					datas[i-1][j]=cell.getNumericCellValue();
					break;
					
				case BOOLEAN:
					datas[i-1][j]=cell.getBooleanCellValue();
					break;
				
				}
				
			}
			
		}
		return datas;
	}

}
