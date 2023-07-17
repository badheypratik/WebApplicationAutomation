package com.automation.HelperUtilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table;

//import Test.java.ExcelReaderCls.ExcelSheetReader;

public class ExcelUtil 
{
	public static List<InputsToInitiateTC> TestcaseToExecute = new ArrayList<InputsToInitiateTC>();
	public static List<InputsToExecuteTC> TestcaseStepsToExecute = new ArrayList<InputsToExecuteTC>();
	public static XSSFSheet excelSheet;
	public ExcelUtil()
	{
		try 
		{
			HSSFWorkbook excelRepository = new HSSFWorkbook(new FileInputStream(new File(Util.getRelativePath()+WebAppInitializer.regressionsuitpath)));
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		} 	
	}
	public ExcelUtil(String excelSheetName)
	{
		try 
		{
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(Util.getRelativePath()+WebAppInitializer.regressionsuitpath)));
			excelSheet = workbook.getSheet(excelSheetName);
//			HSSFWorkbook excelRepository = new HSSFWorkbook(new FileInputStream(new File(Util.getRelativePath()+"\\HV_TestCases_Selenium.xlsx")));
//			excelSheet = excelRepository.getSheet(excelSheetName);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		} 	
	}
	public  static XSSFSheet getAllAutomatedTestcases() 
	{
		try 
		{
			ExcelUtil repository = new ExcelUtil("TestCaseSummry"); 
			return excelSheet;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return null;
		} 		
	}
	public static List<InputsToInitiateTC> getTestcasesToExecute() 
	{
		try 
		{
			ExcelUtil repository = new ExcelUtil("TestCaseSummry");
			int aa = excelSheet.getLastRowNum();
			int aaa = excelSheet.getFirstRowNum();
			for (int i = 1; i <=excelSheet.getLastRowNum()-excelSheet.getFirstRowNum(); i++) 
			{
				Row automatedTC=excelSheet.getRow(i);
				String AutomationId=automatedTC.getCell(0).toString();
				String isExecute=automatedTC.getCell(1).toString();
				String requiredBrowser=automatedTC.getCell(2).toString();	
					try	{TestcaseToExecute.add(new InputsToInitiateTC(AutomationId,isExecute,requiredBrowser,null));}
					catch (Exception ex) {} 					
			}
			System.out.println("Total automated testcases count = "+TestcaseToExecute.size());
			return TestcaseToExecute;
		} 
		catch (Exception ex)
		{
			return null;
			}		
	}
	public static List<InputsToExecuteTC> getTestcaseStepsToExecute() 
	{
		try 
		{
			ExcelUtil repository = new ExcelUtil("TestCases"); 
				for (int i = 1; i <=excelSheet.getLastRowNum()-excelSheet.getFirstRowNum(); i++) 
				{//System.out.println(i);
					Row automatedTC=excelSheet.getRow(i);
					String AutomationId=automatedTC.getCell(0).toString();
						String ActionToPerform = automatedTC.getCell(3).toString();
						String LocatorType = automatedTC.getCell(5).toString();
						String LocatorValue = automatedTC.getCell(4).toString();
						String TestData = automatedTC.getCell(6).toString();
						String Screenshot = automatedTC.getCell(7).toString();	
						TestcaseStepsToExecute.add(new InputsToExecuteTC(AutomationId, ActionToPerform, LocatorType, LocatorValue, TestData, Screenshot, null));
						
				}
			return TestcaseStepsToExecute;	
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return null;
		} 		
	}
}
