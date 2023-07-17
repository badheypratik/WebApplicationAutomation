package com.automation.KeywordDrivenEngine;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import com.automation.HelperUtilities.ExcelUtil;
import com.automation.HelperUtilities.ExtentReportsClass;
import com.automation.HelperUtilities.InputsToExecuteTC;
import com.automation.HelperUtilities.InputsToInitiateTC;

public class EngineOperations
{	public static LocalDate endDateToVerify;
	static ExtentReportsClass Report = new ExtentReportsClass();
	public static List<InputsToExecuteTC> TCStepsExecutionStatus = new ArrayList<InputsToExecuteTC>();
	public static void executeAutomatedTCs(String webApplicationToTest)
	{
		try		
		{
			System.out.println("****Engine execution started****");
			List<InputsToInitiateTC> TCToExecute = ExcelUtil.getTestcasesToExecute().stream().filter((p)->p.isExecute.equals("Y")).collect(Collectors.toList());
			System.out.println("NO OF TESTCASES TO EXECUTE = "+TCToExecute.size());		
			List<InputsToExecuteTC> TCSteps = ExcelUtil.getTestcaseStepsToExecute();
			System.out.println("TOTAL TCs STEPS COUNT = "+TCSteps.size());	
			for (int i=0; i<TCToExecute.size(); i++) 
			{
				if(!(Browser.InitializeBrowser(TCToExecute.get(i).requiredBrowser).equals(null)))
				{
				    String CurrentTCId = TCToExecute.get(i).AutomationId;
					System.out.println("EXECUTING TESTCASE = "+TCToExecute.get(i).AutomationId);
					System.out.println("INITIALIZED BROWSER");
					List<InputsToExecuteTC> TCStepsToExecute = TCSteps.stream().filter((p)->p.AutomationId.equals(CurrentTCId)).collect(Collectors.toList());
					System.out.println("NO OF STEPS TO EXECUTE FOR TC "+TCToExecute.get(i).AutomationId+" = "+TCStepsToExecute.size());
					for(int j = 0; j < TCStepsToExecute.size(); j++)
					{
							try 
							{		
								 Class<MasterActions> maCls = (Class<MasterActions>) Class.forName("com.automation.KeywordDrivenEngine.MasterActions");
								 Class[] constructorMA = new Class[] { String.class, String.class,String.class,String.class,String.class};							         
								 Object[] constArgs = new Object[] { TCStepsToExecute.get(j).ActionToPerform,TCStepsToExecute.get(j).LocatorType,TCStepsToExecute.get(j).LocatorValue,TCStepsToExecute.get(j).TestData,TCStepsToExecute.get(j).Screenshot};
						         try 
						         {
						        	 String mma = TCStepsToExecute.get(j).ActionToPerform;
						        	 Constructor maConst = maCls.getConstructor(constructorMA);
						             MasterActions ma = (MasterActions) maConst.newInstance(constArgs);
						             Class noparams[] = {};		
						             
						             Method method = maCls.getMethod(TCStepsToExecute.get(j).ActionToPerform, noparams);
						             TCStepsToExecute.get(j).ActionStepResult = (String) method.invoke(ma);
						             System.out.println("Action :: "+TCStepsToExecute.get(j).ActionToPerform+" On ::"+TCStepsToExecute.get(j).LocatorValue+" Result :: "+TCStepsToExecute.get(j).ActionStepResult);
						             
						             
						         }
						         catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) 
						         {
						             e.printStackTrace();
						         } 				         
							} 
							catch (Exception e) 
							{
								e.printStackTrace();
							} 		
					}				
					for(int k = 0 ; k < TCStepsToExecute.size() ; k++)
					{
						TCStepsExecutionStatus.add(TCStepsToExecute.get(k));
					}
					TCStepsToExecute.clear();
					//ExcelUtil.TestcaseStepsToExecute.clear();
				}				
			}			
			System.out.println("****Engine execution finished****");
			for (InputsToInitiateTC testcase : TCToExecute)
			{
				List<String> allSteps = null;
				try 
				{
					allSteps = InputsToExecuteTC.getAllTestSteps(testcase.AutomationId, EngineOperations.TCStepsExecutionStatus);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			    Report.WriteReport(allSteps);
			} 
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}	
}
