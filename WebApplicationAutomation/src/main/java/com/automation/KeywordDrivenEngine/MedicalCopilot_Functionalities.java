package com.automation.KeywordDrivenEngine;

import com.automation.HelperUtilities.screnshotcls;

public class MedicalCopilot_Functionalities extends MasterActions
{

	public MedicalCopilot_Functionalities(String Action, String LT, String LV, String TD, String Ss) throws Exception 
	{
		super(Action, LT, LV, TD, Ss);
		// TODO Auto-generated constructor stub
	}
	public String  BacktoURl()
	{
		
		try
		{
			 System.out.println("%%%%%%%%%% Called derived class method %%%%%%%%%%%%");
			
			Browser.webDriver.navigate().back();
			testStepResult="Pass";
		}
		
		catch(Exception e)
		{
			    System.out.println("Exception in clickButton Action : "+e);
			    //TestCaseStapeStatus="Pass";
			    ExceptionMessage="Exception in clickButton Action :   "+e.getMessage().toString();
			    if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
			    if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	//MasterActions.TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
		}
				
		return testStepResult;
	}
}
