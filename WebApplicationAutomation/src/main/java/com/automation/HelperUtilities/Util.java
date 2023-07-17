package com.automation.HelperUtilities;

import java.io.File;

public class Util 
{
	public  static String getRelativePath() 
	{
		String currentDirectory = new File(".").getAbsolutePath();
		currentDirectory=currentDirectory.substring(0,currentDirectory.length()-2);	
	    return currentDirectory;	
	}
	public static void loadPropertyFile(String fileName)
	{
		
	}
}
