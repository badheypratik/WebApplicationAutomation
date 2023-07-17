package com.automation.HelperUtilities;
import java.util.ArrayList;
import java.util.List;
public class InputsToExecuteTC 
{
	public static List<InputsToExecuteTC> lstSteps =  new ArrayList<InputsToExecuteTC>();
	public String AutomationId,	ActionToPerform, LocatorType, LocatorValue, TestData, Screenshot, ActionStepResult;	
	public InputsToExecuteTC(String AutomationId, String ActionToPerform,String LocatorType,String LocatorValue,String TestData,String Screenshot, String ActionStepResult)
	{
		this.AutomationId = AutomationId;
		this.ActionToPerform = ActionToPerform;
		this.LocatorType = LocatorType;
		this.LocatorValue = LocatorValue;
		this.TestData = TestData;
		this.Screenshot = Screenshot;
		this.ActionStepResult = ActionStepResult;
	}
	
	public InputsToExecuteTC() 
	{
		System.out.println("In plan constructor");
		int automationID = 0;
		for (int i = 0; i < 5; i++) 
		{

			lstSteps.add(new InputsToExecuteTC(String.valueOf(automationID+ 1) ,"Action","LocatorType","Locator Value", "TestData","Screenshot", "Pass"));
			automationID++;
		}
	}
	
	public static List<String> getAllTestSteps( String testCaseID , List<InputsToExecuteTC> lstSteps)
	{
		List<String> allSteps = new ArrayList<String>();		
		for (InputsToExecuteTC inputsToExecuteTC : lstSteps) 
		{			
				if(inputsToExecuteTC.AutomationId.equals(testCaseID) && !inputsToExecuteTC.ActionToPerform.equals("SLEEP"))
				{
					allSteps.add(inputsToExecuteTC.Join());
				}
		}
		return allSteps;
	}
	
	public String Join() 
	{
		//return AutomationId + " " + ActionToPerform + " " + LocatorType + " " + LocatorValue + " " + TestData + " " + ActionStepResult + " " + Screenshot ;
		//return AutomationId + " " + ActionToPerform + " " + LocatorValue + " " + TestData + " " + ActionStepResult;
		return AutomationId + " " + ActionToPerform + " " + LocatorValue + " " + ActionStepResult;
	}
}