package com.obsqura.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static String projectpath;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileInputStream fi;
	public static XSSFRow row;
	public static XSSFCell cell;
	public String getCellValue(int i,int j) throws IOException {
	 projectpath=System.getProperty("user.dir");
	
		workbook=new XSSFWorkbook(projectpath+"\\src\\test\\resources\\com\\obsqura\\files\\Sample.xlsx");
		sheet =workbook.getSheet("Sheet1");
		Row r=sheet.getRow(i);
		Cell c=r.getCell(j);
		return c.getStringCellValue();
		
		
	} 
	public static int getRowCount(String xlfile,String xlsheet) throws IOException {
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
		
	}
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException {
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
		
	}
	
	
	}

