package com.automation.HelperUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class WebAppInitializer 
{
	public static String webApplicationToTest = null, regressionsuitpath = null, propertyfilename = null;
	public WebAppInitializer()
	{

	}
	
	public static void InitializeInputParameters() throws IOException
	{
		try 
		{
			Properties prop=new Properties();
			FileInputStream finp;
			finp = new FileInputStream(Util.getRelativePath()+"\\src\\main\\java\\com\\automation\\Configurations\\Web_App_Configurations.properties");
			prop.load(finp);
			String ExecuteHVAregressionsuit = prop.getProperty("ExecuteHVAregressionsuit");
		    String ExecuteMedicopilotregressionsuit = prop.getProperty("ExecuteMedicopilotregressionsuit");
	        if(ExecuteHVAregressionsuit.equalsIgnoreCase("Yes"))
	        {
	        	webApplicationToTest = "HVA";
	        	regressionsuitpath = prop.getProperty("HVAregressionsuit");
	        	propertyfilename = prop.getProperty("HVApropertyfile");
	        }
			else if(ExecuteMedicopilotregressionsuit.equals("Yes"))
			{
				webApplicationToTest = "HVA";
	        	regressionsuitpath = prop.getProperty("Medicopilotregressionsuit");
	        	propertyfilename = prop.getProperty("Medicopilotpropertyfile");
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}	    	
    }
}

