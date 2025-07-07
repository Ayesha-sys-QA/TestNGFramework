package com.neotech.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	private static Workbook book;
	private static Sheet sheet;
	
	
	/**
	 * This will initialize a workbook object given the filepath.
	 * 
	 * @param filePath
	 */
	private static void openExcel(String filePath)
	{
		try {
			FileInputStream fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will initialize the sheet by loading a sheet from the workbook using the given sheetName
	 * 
	 * @param sheetName
	 */
	private static void loadSheet(String sheetName)
	{
		sheet = book.getSheet(sheetName);
	}

	/**
	 * This method returns the row count on the current sheet.
	 * 
	 * @return
	 */
	private static int rowCount()
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	/**
	 * This method will return the column count of a given rowIndex in the current sheet.
	 * 
	 * @param rowIndex
	 * @return
	 */
	private static int colCount(int rowIndex)
	{
		return sheet.getRow(rowIndex).getLastCellNum();
	}
	
	/**
	 * This method returns the cell data as a String given the row and column indices.
	 * 
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 */
	private static String cellData(int rowIndex, int colIndex)
	{
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
	
	
	public static Object[][] excelIntoArray(String filePath, String sheetName)
	{
		//open the file: filePath
		openExcel(filePath);
		
		
		//load the sheet: sheetName
		loadSheet(sheetName);
		
		
		//get the number of rows 
		int rowNumber = rowCount();

		
		//get the number of cols 
		int colNumber = colCount(0);
		
	
		
		//fill out the array by using a nested for loop to go through all the elements....
		
		Object[][] data = new Object[rowNumber - 1][colNumber]; //I dont need to get the header
		
		for(int row = 1; row < rowNumber; row++)
		{
			for (int col = 0; col < colNumber; col ++)
			{

				//on the first run: 
				//row = 1, col = 0 --> but I need to fill the cell 0, 0 on data: data[row-1][col]
				data[row-1][col] = cellData(row, col);
			}
			
		}
		
		return data;
		
	}
	

}
