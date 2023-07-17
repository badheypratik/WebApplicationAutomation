package com.automation.HelperUtilities;
//package com.automation.HVAtests;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import org.asynchttpclient.util.Assertions;
public class AutoAssert 
{
 public static boolean Assert(String actualResul, String ExpectedResult) 
 {
	 boolean testResult = true;
	 try
	 {
		 if(!actualResul.equals(ExpectedResult))
		 {
			 testResult = false;
			 throw new Exception();
		 }
		 
		 
	 }
	 catch(Exception ex)
	 {
		 System.out.println(ex.getMessage());
		 testResult = false;
		 
	 }	
	 return testResult;
 }
 public static boolean Assert(boolean actualResul, boolean ExpectedResult) 
 {
	 boolean testResult = true;
	 try
	 {
		 if(!(actualResul == ExpectedResult))
		 {
			 throw new Exception();
		 }	 
	 }
	 catch(Exception ex)
	 {
		 testResult = false;
		 
	 }	
	 return testResult;
 }
}
