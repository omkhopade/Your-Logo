package com.Logo.qa.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Logo.qa.Base.TestBase;

public class testUtils extends TestBase {

	public static long pageload= 40;
	public static long implicitlywait=20;
	public static Workbook book;
	public static Sheet sheet;
	public static FileInputStream file=null;
	
	
	
	public static void takeScreenShots()  
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		try {
			FileUtils.copyFile(src,new File("D:\\Selenium\\Automation Testing\\Logo\\ScreenShots\\"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static Object[][] getTestData(String sheetname)
	{
		
		try {
			file= new FileInputStream("D:\\Selenium\\Automation Testing\\Logo\\src\\main\\java\\com\\Logo\\qa\\TestData\\TestData.xlsx");
		}catch(FileNotFoundException e)
		{
		 System.out.println("Wrong file present in path ");	
		}
		
		try {
			book = WorkbookFactory.create(file);
		}
		catch (InvalidFormatException e) {
			// TODO: handle exception
		}
		 catch (IOException e) {
			// TODO: handle exception
		}
		sheet=book.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) 
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
}
