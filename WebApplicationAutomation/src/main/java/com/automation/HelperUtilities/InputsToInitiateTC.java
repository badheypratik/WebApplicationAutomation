package com.automation.HelperUtilities;

public class InputsToInitiateTC 
{
	public String AutomationId;
	public String isExecute;
	public String requiredBrowser;
	public String TestCaseResult;
	
	public InputsToInitiateTC(String TCID, String ExecuteionStatus, String Browser, String Result)
	{
		this.AutomationId = TCID;
		this.isExecute = ExecuteionStatus;
		this.requiredBrowser = Browser;
		this.TestCaseResult = Result;
	}
}
