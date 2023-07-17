package com.automation.KeywordDrivenEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Alert;

//import Test.java.MasterClsPkg.MasterActions;
//import Test.java.TestCases.Medicopilot;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.HelperUtilities.AutoAssert;
import com.automation.HelperUtilities.InputsToExecuteTC;
import com.automation.HelperUtilities.Util;
import com.automation.HelperUtilities.WebAppInitializer;
import com.automation.HelperUtilities.screnshotcls;
import com.google.common.base.Predicate;
public class MasterActions 
{
	public LocalDate endDateToVerify;
	public String Old_Text,Prvs_Text,parentWindowHandleq,AddNewSubscriptionEndDate,AddNewSubscriptionSendTimeUnit,AddNewSubscriptionSendTime,inactiveUserStatus = null,selectQueryResult,RLSaftercopy,RLSbeforcopy,Current_Pwd,LocatorValue, LocatorType, TestData, testStepResult,TestCasePriority,Screenshot,currentTenantName,AddNewSubscriptionStartDate,ID,ExceptionMessage="Working as per exp. res.",PropertiesFile =Util.getRelativePath()+WebAppInitializer.propertyfilename;
	public static String VerifyNewSubscriptionEndDate;
	public int UsrMgtTblRwCount,UsrMgtTblRwNo;
	public Properties prop=new Properties();
	public FileInputStream finp=new FileInputStream(PropertiesFile);
	public boolean flag=false,TestCasePriorityRep=false, isUserTypeDropDownVisible = false,CheckSessionIdforSignInSignOut = false, isCPcopied = false;
	public WebElement DivAddedByAuto=null;
	public List<String> siteMagtList=new ArrayList<String>(); 
	public List<String> contentMgtList=new ArrayList<String>(); 
	public static Select dropdown;
	public MasterActions(String Action,String LT,String LV,String TD,String Ss) throws Exception
	{
		prop.load(finp);
		LocatorType = LT;
		LocatorValue = LV;		
		TestData = TD;
		Screenshot = Ss;
	}  
	public String getID() 
	{
		return ID;
	}
	public void setID(String iD) 
	{
		ID = iD;
	}
//	public String OutlookEmail() throws Exception {
//	    Properties props = System.getProperties();
//	    props.setProperty("mail.store.protocol", "imap");
//	    props.setProperty("mail.imap.ssl.enable", "true");
//	    props.setProperty("mail.imaps.partialfetch", "false");
//	    props.put("mail.mime.base64.ignoreerrors", "true");
//
//	    Session mailSession = Session.getInstance(props);
//	    mailSession.setDebug(true);
//	    Store store = mailSession.getStore("imap");
//	    store.connect("outlook.office365.com", "YOUREMAILADDRESS", "YOUR PASSWORD");
//
//
//	    Folder folder = store.getFolder("INBOX");
//	    folder.open(Folder.READ_ONLY);
//
//	    System.out.println("Total Message:" + folder.getMessageCount());
//	    System.out.println("Unread Message:" + folder.getUnreadMessageCount());
//	    Message messages[] = folder.search(new FlagTerm(new Flags(Flag.SEEN), false));
//	    messages = folder.getMessages();
//
//	    for (Message mail : messages) {         
//
//
//
//	            System.out.println("*********************************");
//	            System.out.println("MESSAGE : \n");
//
//	            System.out.println("Subject: " + mail.getSubject());
//	            System.out.println("From: " + mail.getFrom()[0]);
//	            System.out.println("To: " + mail.getAllRecipients()[0]);
//	            System.out.println("Date: " + mail.getReceivedDate());
//	            System.out.println("Size: " + mail.getSize());
//	            System.out.println("Flags: " + mail.getFlags());
//	            System.out.println("ContentType: " + mail.getContentType());
//	            //System.out.println("Body: \n" + ((Object) mail).getEmailBody(mail));    
//	            System.out.println("*******************************");          
//
//	    }
//	}
	public String  assignMD() 
    { 
		String AssignMD; 
		AssignMD=prop.getProperty(LocatorValue);
		String [] AssignMD1=AssignMD.split("1");
		AssignMD=AssignMD1[0];
		System.out.println(AssignMD);
		for (int i=0;i<50;i++)
		{
			String AssignMD2=AssignMD+i+"T0']";
			if(Browser.webDriver.findElements(By.xpath(AssignMD2)).size() > 0)
			{
				System.out.println(Browser.webDriver.findElements(By.xpath(AssignMD2)).size());
				WebElement ele=Browser.webDriver.findElement(By.xpath(AssignMD2));
				String locator=Browser.webDriver.findElement(By.xpath(AssignMD2)).getText();
				System.out.println(locator);
				System.out.println(TestData);				   
				System.out.println(TestData.equalsIgnoreCase(locator));
				if(TestData.equals(locator))
				{
					System.out.println("hi"); 
					ele.click();
					testStepResult="Pass";
					break;
				}
			}		
		}
		return testStepResult;
	}
	
	public String  IsCheckboxSelected() 
    { 
		
				try {
					String ChkState = Boolean.toString(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).isSelected());
					
					if(ChkState.equalsIgnoreCase(TestData))
					{
						
						testStepResult="Pass";
						
					}
					else
					{
						
						testStepResult="Fail";
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
		
		return testStepResult;
    }
	public String Windows_AlertHandler()
	{
		try
		{
			System.out.println("alertMessage");
			Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
			System.out.println("alertMessage2");
			Thread.sleep(5000);
			Runtime.getRuntime().exec("D:\\Medico");
			System.out.println("alertMessage5");
			Thread.sleep(5000);
			Set<String> allWindows=Browser.webDriver.getWindowHandles();
			System.out.println("alertMessage3");
			System.out.println("alertMessage4");
			System.out.println("dsd"+Browser.webDriver.getTitle());
			System.out.println("alertMessage5");
			System.out.println("alertMessage1");
			if(TestData.equalsIgnoreCase("Y"))
			{ 
				System.out.println("alertMessage2");
				Alert alert = Browser.webDriver.switchTo().alert() ;
				System.out.println("alertMessage3");
				//To Do//((Object) alert).authenticateUsing(new UsernameAndPassword("akhil.sharma@lxi.lumedx.com","Shukla_002"));
				Browser.webDriver.switchTo().defaultContent() ; 
				System.out.println("alertMessage4");
				testStepResult="Pass";
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					System.out.println("alertMessage2");
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
			}
			else if(TestData.equalsIgnoreCase("N"))
			{
				System.out.println("alertMessage3");
				org.openqa.selenium.Alert alert1 = Browser.webDriver.switchTo().alert();
				alert1.dismiss();
				testStepResult="Pass";
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
			}
		}
		catch(Exception e)
		{	
			System.out.println("alertMessage4");
		    System.out.println("Exception in AlertAccept Action : "+e);
		    testStepResult="Pass";
		    if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
		    if(TestCasePriority.equalsIgnoreCase("P1"))
	    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
	    	}
		}
		return testStepResult;
	}
	public String Readlogfile()
	{
		try
		{
			File f1=new File("\\\\medicalcoint.dev.lumedx.com\\Logs"); //Creation of File Descriptor for input file
		    File[] files =  f1.listFiles();
		    File lastModifiedFile = files[0];
		    for (int i = 1; i < files.length; i++) 
		    {
		    	if (lastModifiedFile.lastModified() < files[i].lastModified()) 
		    	{
		    		lastModifiedFile = files[i];
		        }
		     }
			 System.out.println("sd"+lastModifiedFile);
			 FileReader fr = new FileReader(lastModifiedFile);  //Creation of File Reader object
			 String[] words=null;  //Intialize the word Array   
			 BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
			 //Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
			 String s;     
			 String input="2020-01-09 09:47:16,256 [(null)] [(null)] [380] DEBUG MedicalCopilot.IDP.Controllers.Account.AccountController - Geting list of forms from ApolloDB for UserId:'DefaultAuthenticated@testapporchardoauth2'.";   // Input word to be searched
			 int count1=0;   //Intialize the word to zero
			 while((s=br.readLine())!=null)   //Reading Content from the file
			 {
				 words=s.split("\n");  //Split the word using space
			     for (String word : words) 
			     {
			    	 if (word.equals(input))   //Search for the given word
			         {
			    		 count1++;    //If Present increase the count by one
			         }
			     }
			 }
			 if(count1!=0)  //Check for count not equal to zero
			 {
				 System.out.println("The given word is present in the file");
			 }
			 else
			 {
				 System.out.println("The given word is not present in the file");
			 }
			 fr.close();
			 if(Screenshot.equalsIgnoreCase("Y"))
			 {
				 screnshotcls obj=new screnshotcls(Browser.webDriver);
			 }
		}
		catch(Exception e)
		{
			System.out.println("Exception in CompareTxt Action : "+e);
			testStepResult="Pass";
		    if(Screenshot.equalsIgnoreCase("Y"))
			{
		    	screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
		    if(TestCasePriority.equalsIgnoreCase("P1"))
	    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
	    	}
		}
		return testStepResult;
	}

	
	public String  Broswertab()
{

	try
	{
		((JavascriptExecutor)Browser.webDriver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(Browser.webDriver.getWindowHandles());
		Browser.webDriver.switchTo().window(tabs.get(1));
		Browser.webDriver.get("http://google.com");
		
		testStepResult="Pass";
		
	}
	catch(AssertionError e)
	{
		System.out.println("Fail");
		System.out.println("hii");
		testStepResult="Fail";
		System.out.println("hii1");
		// MasterActions.ExceptionMessage="Exception in CheckBoxUnSelect Action : "+e.getMessage().toString();
		 if(Screenshot.equalsIgnoreCase("Y"))
			{	System.out.println("hii2");
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
			System.out.println("hii3");
		System.out.println(e.getMessage());
		System.out.println("hii4");
		if(TestCasePriority.equalsIgnoreCase("P1"))
    	{
			Browser.webDriver.close();
    	}
	}
	catch(Exception e)
	{	System.out.println("hii5");
		    System.out.println("Exception in CheckBoxUnSelect Action : "+e);
			System.out.println("hii6");
			testStepResult="Pass";
			System.out.println("hii7");
		    ExceptionMessage="Exception in CheckBoxUnSelect Action : "+e.getMessage().toString();
			System.out.println("hii7");
		    if(Screenshot.equalsIgnoreCase("Y"))
			{	System.out.println("hii8");
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
		    if(TestCasePriority.equalsIgnoreCase("P1"))
	    	{	System.out.println("hii9");
	    	//MasterActions.TestCasePriorityRep=true;
	    	Browser.webDriver.close();
	    	}
	}return testStepResult;
}
	
	public String  clickButtonemmded()
{
	//System.out.println("I m in CLICKBUTTON"+LocatorValue+"  "+LocatorType);
	try
	{
		
		
		
		
		Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
	
		testStepResult="Pass";
		
	
			 
		
	}
	catch(Exception e)
	{
		try
		{
		    WebElement element = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
			JavascriptExecutor js = (JavascriptExecutor)Browser.webDriver; 
			js.executeScript("arguments[0].click();", element); 
			testStepResult="Pass";
			
			if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
		}
			catch(Exception e1)
			{
				testStepResult="Pass";
				System.out.println("Exception in clickButton Action : "+e1);
				
			}
	}
	return testStepResult;		
	
}

//	public String  logout()
//{
//	try
//	{
//	((JavascriptExecutor)Browser.webDriver).executeScript("LogOut('../Login.aspx?State=Logout')");
//	//Medicopilot.TestCaseStapeStatus="Pass";
//	if(Screenshot.equalsIgnoreCase("Y"))
//	{
//		screnshotcls obj=new screnshotcls(Browser.webDriver);
//	}
//	}
//	catch(Exception e)
//	{
////		System.out.println("Exception in logout Action : "+e);
////		Medicopilot.TestCaseStapeStatus="Fail";
////		 MasterActions.ExceptionMessage="Exception in logout Action : "+e.getMessage().toString();
////		 if(Screenshot.equalsIgnoreCase("Y"))
////			{
////				screnshotcls obj=new screnshotcls(driver);
////			}
////		if(Medicopilot.TestCasePriority.equalsIgnoreCase("P1"))
////    	{
////    	MasterActions.TestCasePriorityRep=true;
////    	driver.close();
//    	}
//	}
//	return testStepResult;
//}
	public String  WaitforElementToClick() 
	{ 
		
			boolean flag=false;int count=0;
			//System.out.println(Long.parseLong(TestData));
			System.out.println("hiii1waitt");
			
		  //WebDriverWait wait=new WebDriverWait(driver,3);
		  WebDriverWait wait = new WebDriverWait(Browser.webDriver, Duration.ofSeconds(10));    
		  By elem_dynamic = By.id("dynamic-element");
		  wait.until(ExpectedConditions.presenceOfElementLocated(elem_dynamic));
		  while(!flag && count<=30)
			  {
		  try// System.out.println("hiii12");
		  {
			  
		 WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(Browser.webDriver.findElement(getObject(LocatorValue, LocatorType))));
		 flag=true;
		 System.out.println("flag="+flag);
		 ele.click();
		 testStepResult="Pass";
		  }
		  catch(Exception e)
		  {
			  if((count==5) &&(flag==false))
				{
					  testStepResult="Fail";
						//System.out.println("Exception in clickButton Action   "+e);
					//ExceptionMessage="Exception in clickButton Action   "+e.getMessage().toString();
						if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
						if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
							TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				}
						break;	
				}
			  
			  else  if(!flag || count<3000)
			  {
			  flag=false;
			  count++;
			  System.out.println("hjCount="+count);
			  }
			  else
			  {
			  testStepResult="Fail";
				System.out.println("Exception in clickButton Action   "+e);
				//ExceptionMessage="Exception in clickButton Action   "+e.getMessage().toString();
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
				if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
			  }
		  }
				  
			  
		// System.out.println("hiii123");
		
			//	System.out.println("hiii1234");
		
		}
		  return testStepResult;
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
		
		

 
	 public String  WaitforElementToAlert() 
 { 
		{
			
		///###@@@@@@@@@############//
			if(LocatorValue.equals("CheckPopUp")) 
			{
				  
		          try		
		          {org.openqa.selenium.Alert alert = Browser.webDriver.switchTo().alert();      	
		          String alertMessage= Browser.webDriver.switchTo().alert().getText();	
		          System.out.println("Alert Message   "+alertMessage);
		          alert.accept();
		        	  if(alertMessage.equals(TestData))
		        	  {
		        		  //AutoAssert.Assert(alertMessage,TestData);
			        	  testStepResult="Pass";
			        	  System.out.println(testStepResult);
		        	  }
		        	  else
		        	  {
		        		  //AutoAssert.Assert(alertMessage,TestData);
			        	  testStepResult="Fail";
			        	  System.out.println(testStepResult);
		        	  }
		        	  
		          }
		          catch(Exception e)
		          {
		        	  testStepResult="Fail";
		        	  System.out.println(testStepResult);
		          }
			}
			  
			else if(LocatorValue.equals("CheckMoveToPopUp")) 
			{
				  boolean isMessageCorrect = false;
				  String [] moveToMsgDetails = TestData.split("#");
				  org.openqa.selenium.Alert alert = Browser.webDriver.switchTo().alert();      	
		          String alertMessage= Browser.webDriver.switchTo().alert().getText();	
		          System.out.println("Alert Message   "+alertMessage);
		          alert.accept();
		          try		
		          {
		        	  if(alertMessage.contains(moveToMsgDetails[0]) || alertMessage.contains(moveToMsgDetails[1]) || alertMessage.contains(moveToMsgDetails[2]))
		        	  {
		        		  isMessageCorrect = true;
		        	  }
		        	  else
		        	  {
		        		  isMessageCorrect = false;
		        	  }
		        	  AutoAssert.Assert(isMessageCorrect,true);
		        	  testStepResult="Pass";
		        	  System.out.println(testStepResult);
		          }
		          catch(Exception e)
		          {
		        	  testStepResult="Fail";
		        	  System.out.println(testStepResult);
		          }
			}
			else if(LocatorValue.equals("CheckCopyToPopUp")) 
			{org.openqa.selenium.Alert alert = Browser.webDriver.switchTo().alert();      	
	          String alertMessage= Browser.webDriver.switchTo().alert().getText();	
	          System.out.println("Alert Message   "+alertMessage);
	          alert.accept();
	          try		
	          {
	        	  AutoAssert.Assert(alertMessage,TestData);
	        	  
	        	  testStepResult="Pass";
	        	  System.out.println(testStepResult);
	          }
	          catch(Exception e)
	          {
	        	  testStepResult="Fail";
	        	  System.out.println(testStepResult);
	          }
	          
	          
				  //boolean isMessageCorrect = false;
				  //String [] moveToMsgDetails = TestData.split("#");
				  //org.openqa.selenium.Alert alert = Browser.webDriver.switchTo().alert();      	
		          //String alertMessage= Browser.webDriver.switchTo().alert().getText();	
		          //System.out.println("Alert Message   "+alertMessage);
		          //alert.accept();
		          //try		
		          //{
		        	//  if(alertMessage.contains(moveToMsgDetails[0]) || alertMessage.contains(moveToMsgDetails[1]) || alertMessage.contains(moveToMsgDetails[2]) || alertMessage.contains(moveToMsgDetails[3]))
		        	  //{
		        		//  isMessageCorrect = true;
		        	  //}
		        	  ///else
		        	  //{
		        		//  isMessageCorrect = false;
		        	  //}
		        	  //AutoAssert.Assert(isMessageCorrect,true);
		        	  //testStepResult="Pass";
		        	  //System.out.println(testStepResult);
		          //}
		          //catch(Exception e)
		          //{
		        	//  testStepResult="Fail";
		        	  //System.out.println(testStepResult);
		          //}
			}  
			//###########@@@@@@@@@@@@@###############//
			else
			{
				boolean flag=false;int count=0;
				  
				  while(!flag && count<=3)
					  {
				  try
				  {
					  //WebDriverWait wait=new WebDriverWait(driver,2);
					  WebDriverWait wait = new WebDriverWait(Browser.webDriver, Duration.ofSeconds(10));    
					  By elem_dynamic = By.id("dynamic-element");
					  wait.until(ExpectedConditions.presenceOfElementLocated(elem_dynamic));
					  org.openqa.selenium.Alert alert = Browser.webDriver.switchTo().alert();  
					  String alertMessage= Browser.webDriver.switchTo().alert().getText();
				 wait.until(ExpectedConditions.alertIsPresent());
				 //org.openqa.selenium.Alert alert = Browser.webDriver.switchTo().alert();
		      	//	update is executed
		          System.out.println("alertMessage2");
		          //String alertMessage= Browser.webDriver.switchTo().alert().getText();	
		          if(TestCasePriority.equalsIgnoreCase("P0"))
		          {try
		          {
		        	  AutoAssert.Assert(alertMessage,TestData);
		        	  testStepResult="Pass";
		          }
		            catch(Exception e)
		          {
		            	
		          }
		          }
		          System.out.println("alertMessage3");
		   	   System.out.println(alertMessage);
		   	  Thread.sleep(5000);
		      	alert.accept();
				 
				 flag=true;
				 System.out.println("flag="+flag);
				// ele.click();
				  }
				  catch(Exception e)
				  {
					  if((count==3) &&(flag==false))
						{
							  testStepResult="Fail";
								//System.out.println("Exception in clickButton Action   "+e);
							   //ExceptionMessage="Exception in clickButton Action   "+e.getMessage().toString();
								
								if(TestCasePriority.equalsIgnoreCase("P1"))
						    	{
						    	TestCasePriorityRep=true;
						    	//Browser.webDriver.close();
						}
								break;	
						}
					  
					  else  if(!flag || count<3)
					  {
					  flag=false;
					  count++;
					  System.out.println("hjCount="+count);
					  }
					  else
					  {
					    testStepResult="Fail";
						System.out.println("Exception in clickButton Action   "+e);
						ExceptionMessage="Exception in clickButton Action   "+e.getMessage().toString();
						//if(Screenshot.equalsIgnoreCase("Y"))
						//{
							//screnshotcls obj=new screnshotcls(Browser.webDriver);
						//}
						if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	//Browser.webDriver.close();
				    	}
						
						  
					  }
				// System.out.println("hiii123");
				
					//	System.out.println("hiii1234");
				  
				  }
					  }
			}
	          
		}
		return testStepResult;
			  
		

 }
	 public String   WaitforElementToSettext() 
 { 
		{
			boolean flag=false;int count=0;
			//System.out.println(Long.parseLong(TestData));
			//System.out.println("hiii1");
			
		  //WebDriverWait wait=new WebDriverWait(driver,3000);
		  WebDriverWait wait = new WebDriverWait(Browser.webDriver, Duration.ofSeconds(10));    
		  By elem_dynamic = By.id("dynamic-element");
		  wait.until(ExpectedConditions.presenceOfElementLocated(elem_dynamic));
		  while(!flag && count<=3000)
			  {
		  
			  try// System.out.println("hiii12");
		  {
			  
		 WebElement ele= wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(getObject(LocatorValue, LocatorType)));
		 
		// wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(Browser.webDriver.findElement(getObject(LocatorValue, LocatorType)))));
		 flag=true;
		 Browser.webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//	Thread.sleep(3000);
		 ele.sendKeys(TestData);
		 System.out.println("hiitenant");
		
	
		 
		 System.out.println("flag="+flag);
		 testStepResult="Pass";
	
		  }
		  catch(StaleElementReferenceException | ElementNotInteractableException  e)
		  {
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(getObject(LocatorValue, LocatorType)));#Revisit
			  flag=false;
			  System.out.println("hiiankita45");
			  count++;
			  System.out.println("Count "+count);
		  }
		  catch(Exception e)
		  {
			  if(!flag && count<3000)
			  {
			  flag=false;
			  count++;
			  System.out.println("Count="+count);
			  }
			  else
			  {
			  testStepResult="Fail";
				System.out.println("Exception in clickButton Action   "+e);
				ExceptionMessage="Exception in clickButton Action   "+e.getMessage().toString();
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
				if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
			  }
		  }
				  
			  }
		// System.out.println("hiii123");
		
			//	System.out.println("hiii1234");
		
		}
		return testStepResult;
		

 }
	 public String   ImageVerification() 
 { 
		
			
			  try// System.out.println("hiii12");
			  {
			
			WebElement ImageFile = Browser.webDriver.findElement(getObject(LocatorValue, LocatorType));
			
			//#Revisit//Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
			
			//Boolean ImagePresent = (Boolean) ((JavascriptExecutor)Browser.webDriver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
//	        if (!ImagePresent)
//	        {
//	             System.out.println("Image not displayed.");
//	             testStepResult="Fail";
//	        }
//	        else
//	        {
//	            System.out.println("Image displayed.");
//	        }

			
	        testStepResult="Pass";
			  }
			  catch (java.lang.NullPointerException exception)
			 
			  {
			  // Catch NullPointerExceptions.
				  System.out.println(exception.getMessage());
				  testStepResult="Fail";
			  }
				catch(ElementNotInteractableException e)
				{
					System.out.println(e.getMessage());
				}
		  
		  catch(Exception e)
		  {
			  
			  testStepResult="Fail";
				System.out.println("Exception in clickButton Action   "+e);
				ExceptionMessage="Exception in clickButton Action   "+e.getMessage().toString();
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
				if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
			  
		  }
				  
		
		
		
		
			  return testStepResult;
		

 }
	 public String   WaitforPageLoad() throws Exception 
 { 
		
		//WebDriverWait wait=new WebDriverWait(driver,30);
		  WebDriverWait wait = new WebDriverWait(Browser.webDriver, Duration.ofSeconds(10));    
		  By elem_dynamic = By.id("dynamic-element");
		  wait.until(ExpectedConditions.presenceOfElementLocated(elem_dynamic));
		  wait.until(ExpectedConditions.elementToBeClickable(Browser.webDriver.findElement(getObject(LocatorValue, LocatorType)))).click();
			
			//Browser.webDriver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		  //new WebDriverWait(driver, Duration.ofSeconds(70)).until((Predicate<WebDriver>) wd ->((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	
		return testStepResult;
			
		

 }
	 public String   SwitchToNewTabInChrom() 
 { 
		
			Actions action= new Actions(Browser.webDriver);
			action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
			action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		
		return testStepResult;
		
		
		

 }
	 public String   IsSelected() 
 { 
			
			String flag1="false";
        	try
        	{
        		if(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).isSelected())
        		{
        			flag1="true";
        		}
        		
        	
        		AutoAssert.Assert(flag1,TestData);
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			testStepResult="Fail";
    			 ExceptionMessage="Exception in ElementExist Action   "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
    			System.out.println(e.getMessage());
    			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
    		}
			catch(Exception e)
			{
				    System.out.println("Exception in ElementExist Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in ElementExist Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        
        	return testStepResult;
		
		

 }
	 public String   VerifyPatientGrid() 
 { 
			boolean flag=false;int count=0;
			try
			{
		List<WebElement> elements=Browser.webDriver.findElements(getObject(LocatorValue, LocatorType));
		if(elements.size()>0)
		{
			for(WebElement column : elements)
			{
				if(column.getText().equals(TestData))
				{
				   flag=true;	
				   count++;
				}
				else
				{
					flag=false;
				}
				
			}
			if(count==elements.size() && flag==true)
			{
				System.out.println("Pass");
	    		testStepResult="Pass";
	    		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
			     	
			}
			else
			{
				System.out.println("Failed");
    		testStepResult="Fail";
			}
				
			
		}
		else 
		{
			flag=false;
		}
			
			
		}
			catch(ElementNotInteractableException e)
			{testStepResult="Fail";
				System.out.println(e.getMessage());
			}
			catch(Exception e)
			{testStepResult="Fail";
				System.out.println(e.getMessage());
			}
		
		
			return testStepResult;
		

 }
	 public String   uploadsultAttribute() 
 { 
		{
			
		
			String ActualValue2;
	        
	        	try
	        	{
	        	ActualValue2=Browser.webDriver.findElement(getObject(LocatorValue, LocatorType)).getAttribute("value");
	        	       
	    		AutoAssert.Assert(ActualValue2,TestData); 
	    		System.out.println("Pass");
	    		testStepResult="Pass";
	    		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
	    		}

			
				catch(AssertionError e)
				{
					    System.out.println("Fail");
					    testStepResult="Fail";
					    ExceptionMessage="Exception in verifyResult Action   "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    System.out.println("Exception in verifyResult Action   "+e);
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
					    }
	            catch(Exception e)
	    		{
	    			System.out.println("Fail");
	    			testStepResult="Fail";
	    			 ExceptionMessage="Exception in verifyResult Action   "+e.getMessage().toString();
	    			 if(Screenshot.equalsIgnoreCase("Y"))
	 				{
	 					screnshotcls obj=new screnshotcls(Browser.webDriver);
	 				}
	    			System.out.println(e.getMessage());
	    			if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
	    		}
	        	return testStepResult;
					    }
	           
		

 }
	 public String   SelectAll() 
 { 
{
			
			try{
			Actions action=new Actions(Browser.webDriver);
			action.moveToElement(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType))).click();
			action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();
			testStepResult="Pass";
		}catch(Exception e)
		{
			System.out.println("Fail");
			testStepResult="Fail";
			System.out.println("Exception in Compare Image action" + e.getMessage());
			if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
			if(TestCasePriority.equalsIgnoreCase("P1"))
	    	{
	    	TestCasePriorityRep=true;
	    	Browser.webDriver.close();
	    	}
		}
			return testStepResult;
		}
		

 }
	 public String   SendKeyboardKeys() 
 { 
		{					
					try{
						if(TestData.equals("TopicTenant"))
						{int x=1;
							while ( x<=1){
								Actions act1 = new Actions(Browser.webDriver);
								act1.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB).build().perform();
								System.out.println("@@@@@ Sent TAB Key @@@@@");
								  x++;
								}
						}
						else
						{
							Actions act1 = new Actions(Browser.webDriver);
							act1.sendKeys(Keys.TAB).build().perform();
							act1.sendKeys(Keys.ENTER).build().perform();
						}
						testStepResult="Pass";				
				}catch(Exception e)
				{
					System.out.println("Fail");
					testStepResult="Fail";
					System.out.println("Exception in Compare Image action" + e.getMessage());
					if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
				}
					return testStepResult;
				}	
		

 }
	 public String   SendKeyDownToDropdown() 
 { 
		{					
					try{
						Actions act1 = new Actions(Browser.webDriver);
						act1.sendKeys(Keys.DOWN).build().perform();
						act1.sendKeys(Keys.RETURN).build().perform();
						//element.sendKeys(Keys.DOWN, Keys.RETURN);
						testStepResult="Pass";
										
				}catch(Exception e)
				{
					System.out.println("Fail");
					testStepResult="Fail";
					System.out.println("Exception in Compare Image action" + e.getMessage());
					if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
				}
					return testStepResult;	
				}
		

 }
	 public String   SendKeyboardEnterKey() 
 { 
		{					
					try{
					Actions act1 = new Actions(Browser.webDriver);
					act1.sendKeys(Keys.ENTER).build().perform();
					testStepResult="Pass";
					//act1.sendKeys(Keys.ENTER).build().perform();					
				}catch(Exception e)
				{
					System.out.println("Fail");
					testStepResult="Fail";
					System.out.println("Exception in Compare Image action" + e.getMessage());
					if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
				}
					return testStepResult;
				}	
		

 }
	 public String   SendTABKeyboardKey() 
	 { 
			{
						
						try{
						//Actions action=new Actions(Browser.webDriver);
						//action.moveToElement(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType))).click();
						//action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();
						
						Actions act1 = new Actions(Browser.webDriver);
						//act1.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB).build().perform();
						
							//Actions act1 = new Actions(Browser.webDriver);
						act1.sendKeys(Keys.TAB).build().perform();
						//act1.sendKeys(Keys.ENTER).build().perform();	
							act1.sendKeys(Keys.ENTER).build().perform();						
							testStepResult="Pass";
						
						//Actions act2 = new Actions(Browser.webDriver);
						
						//Actions act3 = new Actions(Browser.webDriver);
						//act3.sendKeys(Keys.TAB).build().perform();
						//Actions act4 = new Actions(Browser.webDriver);
						//act4.sendKeys(Keys.TAB).build().perform();
						//Actions act5 = new Actions(Browser.webDriver);
						//act5.sendKeys(Keys.TAB).build().perform();
						//act.sendKeys(Keys.ENTER).build().perform();
						//act.release();
						//act.sendKeys(Keys.TAB).build().perform();
						//act.sendKeys(Keys.TAB).build().perform();
						//act.sendKeys(Keys.TAB).build().perform();
						//act.sendKeys(Keys.TAB).build().perform();
						//act.sendKeys(Keys.RETURN).build().perform();
						
					}
						catch(Exception e)
					{
						System.out.println("Fail");
						testStepResult="Fail";
						System.out.println("Exception in Compare Image action" + e.getMessage());
						if(Screenshot.equalsIgnoreCase("Y"))
							{
								screnshotcls obj=new screnshotcls(Browser.webDriver);
							}
						if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
					}
						return testStepResult;
					}
			

	 }
	 public String   SendKeyboardStringKeys() 
 { 
		{
					
					try{
					//Actions action=new Actions(Browser.webDriver);
					//action.moveToElement(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType))).click();
					//action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).perform();
					
					Actions act1 = new Actions(Browser.webDriver);
					//act1.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB).build().perform();
					if(TestData.equals("Content_Display_Name"))
					{
						//Actions act1 = new Actions(Browser.webDriver);
					act1.sendKeys(Keys.TAB).build().perform();
					//act1.sendKeys(Keys.ENTER).build().perform();	
						act1.sendKeys("ACPack").build().perform();						
					}
					else if(TestData.equals("TopicTenant"))
					{
						act1.sendKeys(prop.getProperty(TestData)).build().perform();
					}
					else
					{
						act1.sendKeys("shyam").build().perform();
					}
					
					//Actions act2 = new Actions(Browser.webDriver);
					
					//Actions act3 = new Actions(Browser.webDriver);
					//act3.sendKeys(Keys.TAB).build().perform();
					//Actions act4 = new Actions(Browser.webDriver);
					//act4.sendKeys(Keys.TAB).build().perform();
					//Actions act5 = new Actions(Browser.webDriver);
					//act5.sendKeys(Keys.TAB).build().perform();
					//act.sendKeys(Keys.ENTER).build().perform();
					//act.release();
					//act.sendKeys(Keys.TAB).build().perform();
					//act.sendKeys(Keys.TAB).build().perform();
					//act.sendKeys(Keys.TAB).build().perform();
					//act.sendKeys(Keys.TAB).build().perform();
					//act.sendKeys(Keys.RETURN).build().perform();
					testStepResult="Pass";
				}catch(Exception e)
				{
					System.out.println("Fail");
					testStepResult="Fail";
					System.out.println("Exception in Compare Image action" + e.getMessage());
					if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
				}
					return testStepResult;
				}
		

 }
	 public String   compareImage1() 
 { 
		{
			
			try{
			screnshotcls sc = new screnshotcls(Browser.webDriver);	
			screnshotcls.compareImage(Browser.webDriver,TestData); 
			
			testStepResult="Pass";
			if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			 }
			}catch(Exception e)
			{
				System.out.println("Fail");
				testStepResult="Fail";
				System.out.println("Exception in Compare Image action" + e.getMessage());
				if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
				if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
			}
			return testStepResult;
		}
		
		

 }
	 public String   clickButton() 
 { 
		{
			//System.out.println("I m in CLICKBUTTON"+LocatorValue+"  "+LocatorType);
			try
			{
				
				


        
				if(TestData.equalsIgnoreCase("Selectpatient"))
				{
					
					// element = this.getObject(LocatorValue,LocatorType);
					 
					//WebDriverWait wait = new WebDriverWait(driver, 10);
					 
					//element = wait.until(ExpectedConditions.elementToBeClickable(LocatorValue));
					 
					//element.click();
					 
					
					
					String id=getID();
		            Browser.webDriver.findElement(By.id(id)).click();	
		            testStepResult="Pass";
				}
				
				else 
				{	
					if(LocatorValue.equals("HeaderOptInMessageandTopicManagement"))
					{
						WebElement wb = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
						//wb.click();
						String a = wb.getText();
						wb.sendKeys(Keys.TAB);
						testStepResult="Pass";
					}
					else if(LocatorValue.equals("Edit_button"))
		        	{
		        		String TempActualValue = null;
		        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("/html/body/div[2]/table/tbody"));
		        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRolesList.size();
		        		System.out.println("Total number of Client resources = "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			if(UsrMgtTblRwCount == 1)
		        			{
		        				TempActualValue=Browser.webDriver.findElement(this.getObject("ClientID",LocatorType)).getText();
		        				System.out.println("Cliet resource to edit = "+TempActualValue);
			        			Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
			        			testStepResult="Pass";
		        			}
		        			else
		        			{
		        				TempActualValue=Browser.webDriver.findElement(this.getObject("ClientID_MultipleRows",LocatorType)).getText();
		        				
		        				if(TempActualValue.contains((TestData)))
			        			{
		        					System.out.println("Cliet resource to edit = "+TempActualValue);
			        				Browser.webDriver.findElement(this.getObject("Edit_button_multiplerows",LocatorType)).click();
			        				testStepResult="Pass";			        				
			        				break;
			        			}
		        			}		        			
		        		}
		        	}
					else if(LocatorValue.equals("UnBlockUserFromMultiple"))
					{
						String TempActualValue = null, InactiveUserName = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[6]/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		if(UsrMgtTblRwCount==1)
		        		{
		        			Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
		        		}
		        		else
		        		{
		        			for(int i=1;i<=UsrMgtTblRwCount;i++)
			        		{
			        			UsrMgtTblRwNo = i;
			        			InactiveUserName=Browser.webDriver.findElement(this.getObject("InactiveUserName",LocatorType)).getText();
			        			System.out.println(InactiveUserName);
			        			System.out.println(TestData);
			        			if(InactiveUserName.contains((TestData)))
			        			{		        				
			        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
			        				testStepResult="Pass";	
			        				break;
			        			}
			        		}	
		        		}
		        			        	
					}
					else if(LocatorValue.equals("BlockInactiveUser"))
					{
						String TempActualValue = null, InactiveUserName = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[6]/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		if(UsrMgtTblRwCount==1)
		        		{
		        			Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
		        		}
		        		else
		        		{
		        			for(int i=1;i<=UsrMgtTblRwCount;i++)
			        		{
			        			UsrMgtTblRwNo = i;
			        			InactiveUserName=Browser.webDriver.findElement(this.getObject("InactiveUserName",LocatorType)).getText();
			        			System.out.println(InactiveUserName);
			        			System.out.println(TestData);
			        			if(InactiveUserName.contains((TestData)))
			        			{		        				
			        				Browser.webDriver.findElement(this.getObject("BlockInactiveUserFromMultiple",LocatorType)).click();
			        				testStepResult="Pass";
			        				break;
			        			}
			        		}	
		        		}
		        				        	
					}
					else if(LocatorValue.equals("UnBlockBlockedUser"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[3]/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject("userAddedByAutomation",LocatorType)).getText();
		        			System.out.println(TestData);
		        			System.out.println(TempActualValue);
		        			if(TempActualValue.contains((TestData)))
		        			{		        				
		        				Browser.webDriver.findElement(this.getObject("UnBlockUser",LocatorType)).click();
		        				testStepResult="Pass";
		        				break;
		        			}
		        		}
		        		
					}
					else if(LocatorValue.equals("deleteUserAddedByAutomation"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[3]/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject("userAddedByAutomation",LocatorType)).getText();
		        			if(TempActualValue.contains((TestData)))
		        			{
		        				System.out.println("Username   "+ TempActualValue);
		        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
		        				testStepResult="Pass";
		        				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
		            			System.out.println(sdf.format(System.currentTimeMillis()));
		        				if(Screenshot.equalsIgnoreCase("Y"))
		        				{
		        					screnshotcls obj=new screnshotcls(Browser.webDriver);
		        				}
		        				//break;
		        			}
		        		}	
		        		
					}
					else if(LocatorValue.equals("ContentPackReleaseVersionLink"))
					{
						String contentpackGroupname = null, contentpackName = null;
						String [] ContentPackDetails = TestData.split("#");
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[2]/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			contentpackGroupname=Browser.webDriver.findElement(this.getObject("ContentPackGroupName",LocatorType)).getText();
		        			contentpackName=Browser.webDriver.findElement(this.getObject("ContentPackName",LocatorType)).getText();
		        			String a = ContentPackDetails[0];
		        			String b = ContentPackDetails[1];
		        			String c = ContentPackDetails[2];
		        			if(contentpackGroupname.equals(ContentPackDetails[0]) && contentpackName.equals(ContentPackDetails[1]))
		        			{        				
		        				if(Browser.webDriver.findElement(this.getObject("modelContentReleaseVersionHeader",LocatorType)).isDisplayed()) 
		        				{
			        				String ActualCPVersion = Browser.webDriver.findElement(this.getObject("model_content_pack_version",LocatorType)).getText();
			        				if(ActualCPVersion.equals(ContentPackDetails[2]))
			        				{
			        					Browser.webDriver.findElement(this.getObject("model_content_pack_version",LocatorType)).click();
			        					testStepResult="Pass";
			        					break;
			        				}
		        				}
		        			}
		        		}
		        		
					}
					else if(LocatorValue.equals("deleteNewSiteApprover"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[3]/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject("NewSiteApproverName",LocatorType)).getText();
		        			if(TempActualValue.contains((TestData)))
		        			{
		        				System.out.println("Username   "+ TempActualValue);
		        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
		        				testStepResult="Pass";
		        				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
		            			System.out.println(sdf.format(System.currentTimeMillis()));
		        				if(Screenshot.equalsIgnoreCase("Y"))
		        				{
		        					screnshotcls obj=new screnshotcls(Browser.webDriver);
		        				}
		        				//break;
		        			}
		        		}	
		        		
					}
					else if(LocatorValue.equals("selectValueToAssignOrder"))
					{
						String TempActualValue = null;
						String [] testDataDetails = TestData.split("#");
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"ddlSection\"]"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("option"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(WebElement ageValue :  TotalRowsList)
		        		{
		        			//UsrMgtTblRwNo = i;
		        			TempActualValue=ageValue.getText();
		        			System.out.println("Username   "+ TempActualValue);
		        			if(TempActualValue.equals((testDataDetails[0])))
		        			{
		        				
		        				ageValue.click();
		        				//*[@id="txtSortOrder"]
		        				WebElement orderTextBox = Browser.webDriver.findElement(By.xpath("//*[@id=\"txtSortOrder\"]"));
		        				orderTextBox.clear();
		        				orderTextBox.sendKeys(testDataDetails[1]);
		        				testStepResult="Pass";
		        				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
		            			System.out.println(sdf.format(System.currentTimeMillis()));
		        				if(Screenshot.equalsIgnoreCase("Y"))
		        				{
		        					screnshotcls obj=new screnshotcls(Browser.webDriver);
		        				}
		        				break;
		        			}
		        		}
		        		
					}
					else if(LocatorValue.equals("manageDataTable"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[3]/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject("dataTableName",LocatorType)).getText();
		        			if(TempActualValue.contains((TestData)))
		        			{
		        				System.out.println("Username   "+ TempActualValue);
		        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
		        				testStepResult="Pass";
		        				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
		            			System.out.println(sdf.format(System.currentTimeMillis()));
		        				
		        				break;
		        			}
		        		}
		        		
					}
					else if(LocatorValue.equals("resendResetPassword"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"modal-body\"]/div/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject("userToResendResetPassword",LocatorType)).getText();
		        			if(TempActualValue.contains((TestData)))
		        			{
		        				System.out.println("Username   "+ TempActualValue);
		        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
		        				testStepResult="Pass";
		        				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
		            			System.out.println(sdf.format(System.currentTimeMillis()));
		        				if(Screenshot.equalsIgnoreCase("Y"))
		        				{
		        					screnshotcls obj=new screnshotcls(Browser.webDriver);
		        				}
		        				//break;
		        				
		        			}
		        		}
		        		
					}
					else if(LocatorValue.equals("resetUserPassword"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[3]/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject("userAddedByAutomation",LocatorType)).getText();
		        			if(TempActualValue.contains((TestData)))
		        			{
		        				System.out.println("Username   "+ TempActualValue);
		        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
		        				testStepResult="Pass";
		        				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
		            			System.out.println(sdf.format(System.currentTimeMillis()));
		        				if(Screenshot.equalsIgnoreCase("Y"))
		        				{
		        					screnshotcls obj=new screnshotcls(Browser.webDriver);
		        				}
		        				//break;
		        			}
		        		}
		        		
					}
					else if(LocatorValue.equals("deleteContentpackPublishedByAutomation"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[5]/div/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject("ContentpackPublishedByAutomation",LocatorType)).getText();
		        			System.out.println("Username   "+ TempActualValue);
		        			if(TempActualValue.equals((TestData)))
		        			{
		        				System.out.println("Username   "+ TempActualValue);
		        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
		        				testStepResult="Pass";
		        				
		        				
		        				break;
		        			}
		        		}
		        		
					}
					else if(LocatorValue.equals("Pickanaccount"))
					{
						//String [] privilegeDetails= TestData.split("#"); 
	            		WebElement userList = Browser.webDriver.findElement(By.xpath("//*[@id=\"tilesHolder\"]"));
	            		System.out.println(userList.getText());
	            		List<WebElement>Totalusers = userList.findElements(By.xpath("//div[@role='listitem']"));
	            		UsrMgtTblRwCount = Totalusers.size();
	            		System.out.println("Total users are   "+ UsrMgtTblRwCount);
	            		for(WebElement user  : Totalusers)
	            		{
	            			System.out.println(user.getText());  
	            			if(user.getText().equals(TestData))
	            			{
	            				user.click();
	            				testStepResult="Pass";
	            				break;
	            			}
	            		}
					}
					else if(LocatorValue.equals("selectContentPackToMove"))
					{
						String contentpackGroupname = null, contentpackName = null;
						String [] ContentPackDetails = TestData.split("#");
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[2]/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			contentpackGroupname=Browser.webDriver.findElement(this.getObject("ContentPackGroupName",LocatorType)).getText();
		        			contentpackName=Browser.webDriver.findElement(this.getObject("ContentPackName",LocatorType)).getText();
		        			String a = ContentPackDetails[0];
		        			String b = ContentPackDetails[1];
		        			if(contentpackGroupname.equals(ContentPackDetails[0]) && contentpackName.equals(ContentPackDetails[1]))
		        			{
		        				
		        				Browser.webDriver.findElement(this.getObject("ContentPackMoveBtn",LocatorType)).click();
		        				testStepResult="Pass";		        					
		        				break;
		        			}
		        		}
					}
					else if(LocatorValue.equals("selectContentPackToCopy"))
					{
						String contentpackGroupname = null, contentpackName = null;
						String [] ContentPackDetails = TestData.split("#");
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[2]/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			contentpackGroupname=Browser.webDriver.findElement(this.getObject("ContentPackGroupName",LocatorType)).getText();
		        			contentpackName=Browser.webDriver.findElement(this.getObject("ContentPackName",LocatorType)).getText();
		        			String a = ContentPackDetails[0];
		        			String b = ContentPackDetails[1];
		        			if(contentpackGroupname.equals(ContentPackDetails[0]) && contentpackName.equals(ContentPackDetails[1]))
		        			{
		        				
		        				Browser.webDriver.findElement(this.getObject("ContentPackCopyBtn",LocatorType)).click();
		        				testStepResult="Pass";		        					
		        				break;
		        			}
		        		}
					}
					else if(LocatorValue.equals("selectContentPackToDelete"))
					{
						int counter = 0;
						boolean isclickedDelete = false;
		        		String TempActualValue = null, fullUsername = null;
		        		String [] testdataDetails = TestData.split("#");
		        		int CPGroupCount;
		        		boolean CPGroupUpdated = false;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[2]/div/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(WebElement CPG  : TotalRowsList)
		        		{
		        			counter++;
		        			List<WebElement>CPGroup = CPG.findElements(By.tagName("td"));
		        			CPGroupCount = CPGroup.size();
		        			System.out.println("No.Of td's in current tr   "+ CPGroupCount);
		        			if(CPGroupCount == 10)
		        			{
		        				String grpname = CPG.getText();
		        				System.out.println(grpname);
		        				System.out.println(testdataDetails[0]);
		        				if(grpname.equals(testdataDetails[0])) 
		        				{
		        					for(int i = counter;i<=UsrMgtTblRwCount;i++)
		        					{
		        						UsrMgtTblRwNo = i;
		        						TempActualValue=Browser.webDriver.findElement(this.getObject("ContentpackPublishedByAutomation",LocatorType)).getText();
		        	        			if(TempActualValue.contains(testdataDetails[1]))
		        	        			{
		        	        				Browser.webDriver.findElement(this.getObject("deleteContentpackPublishedByAutomation",LocatorType)).click();
		    		        				testStepResult="Pass";
		    		        				isclickedDelete = true;

		        	        				break; 
		        	        			}
		        					}
		        				}
		        			}
		        			if(isclickedDelete)
		        			{
		        				break;
		        			}
		        		}
		        		
					}
					else if(LocatorValue.equals("selectContentPackToEdit"))
					{
						int counter = 0;
						boolean isclickedDelete = false;
		        		String TempActualValue = null, fullUsername = null;
		        		String [] testdataDetails = TestData.split("#");
		        		int CPGroupCount;
		        		boolean CPGroupUpdated = false;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[2]/div/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(WebElement CPG :  TotalRowsList)
		        		{
		        			counter++;
		        			List<WebElement>CPGroup = CPG.findElements(By.tagName("td"));
		        			CPGroupCount = CPGroup.size();
		        			System.out.println("No.Of td's in current tr   "+ CPGroupCount);
		        			if(CPGroupCount == 10)
		        			{
		        				String grpname = CPG.getText();
		        				System.out.println(grpname);
		        				System.out.println(testdataDetails[0]);
		        				if(grpname.equals(testdataDetails[0])) 
		        				{
		        					for(int i = counter;i<=UsrMgtTblRwCount;i++)
		        					{
		        						UsrMgtTblRwNo = i;
		        						TempActualValue=Browser.webDriver.findElement(this.getObject("ContentpackPublishedByAutomation",LocatorType)).getText();
		        	        			if(TempActualValue.contains(testdataDetails[1]))
		        	        			{
		        	        				Browser.webDriver.findElement(this.getObject("editContentpackPublishedByAutomation",LocatorType)).click();
		    		        				testStepResult="Pass";
		    		        				isclickedDelete = true;

		        	        				break; 
		        	        			}
		        					}
		        				}
		        			}
		        			if(isclickedDelete)
		        			{
		        				break;
		        			}
		        		}
		        		
					}
					else if(LocatorValue.equals("selectContentPackGroup"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("option"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject("ContentPackGroup",LocatorType)).getText();
		        			if(TempActualValue.contains((TestData)))
		        			{
		        				System.out.println("Username   "+ TempActualValue);
		        				Browser.webDriver.findElement(this.getObject("ContentPackGroup",LocatorType)).click();
		        				testStepResult="Pass";
		        				
		        				
		        				break;
		        			}
		        		}
					}
					else if(LocatorValue.equals("selectContentPackGroupToCopy"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("li"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject("ContentPackGroupToCopy",LocatorType)).getText();
		        			if(TempActualValue.contains((TestData)))
		        			{
		        				System.out.println("Username   "+ TempActualValue);
		        				Browser.webDriver.findElement(this.getObject("ContentPackGroupToCopy",LocatorType)).click();
		        				testStepResult="Pass";
		        				
		        				
		        				break;
		        			}
		        		}
					}
					else if(LocatorValue.equals("selectContentPackToReplace"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("Option"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(WebElement CPToReplace :  TotalRowsList)
		        		{
		        			
		        			TempActualValue=CPToReplace.getText();
		        			System.out.println("Username   "+ TempActualValue);
		        			System.out.println("Username   "+ TestData);
		        			if(TempActualValue.contains((TestData)))
		        			{
		        				System.out.println("Username   "+ TempActualValue);
		        				CPToReplace.click();
		        				testStepResult="Pass";
		        				
		        				
		        				break;
		        			}
		        		}
					}
					else if(LocatorValue.equals("deleteTenantAddedByAutomation"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div/div/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject("tenantAddedByAutomation",LocatorType)).getText();
		        			if(TempActualValue.contains((TestData)))
		        			{
		        				System.out.println("Username   "+ TempActualValue);
		        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
		        				testStepResult="Pass";
		        				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
		            			System.out.println(sdf.format(System.currentTimeMillis()));
		        				if(Screenshot.equalsIgnoreCase("Y"))
		        				{
		        					screnshotcls obj=new screnshotcls(Browser.webDriver);
		        				}
		        				//break;
		        			}
		        		}
			        	
					}
					else if(LocatorValue.equals("editTenant"))
					{
						if(TestData.equals("Tenant"))
						{
							String tenantToEdit=prop.getProperty("Tenant");
							String [] tenantDetails = tenantToEdit.split(" ");
							String TempActualValue = null;
			        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div/div/table/tbody"));
			        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
			        		UsrMgtTblRwCount = TotalRowsList.size();
			        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
			        		for(int i=1;i<=UsrMgtTblRwCount;i++)
			        		{
			        			UsrMgtTblRwNo = i;
			        			TempActualValue=Browser.webDriver.findElement(this.getObject("tenantAddedByAutomation",LocatorType)).getText();
			        			System.out.println(tenantDetails[0]);
			        			System.out.println(TempActualValue);
			        			if(TempActualValue.equals(tenantDetails[0]))
			        			{
			        				System.out.println("Username   "+ TempActualValue);
			        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
			        				testStepResult="Pass";
			        				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
			            			System.out.println(sdf.format(System.currentTimeMillis()));
			        				if(Screenshot.equalsIgnoreCase("Y"))
			        				{
			        					screnshotcls obj=new screnshotcls(Browser.webDriver);
			        				}
			        				//break;
			        			}
			        		}
						}
						else
						{
							String TempActualValue = null;
			        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div/div/table/tbody"));
			        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
			        		UsrMgtTblRwCount = TotalRowsList.size();
			        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
			        		for(int i=1;i<=UsrMgtTblRwCount;i++)
			        		{
			        			UsrMgtTblRwNo = i;
			        			TempActualValue=Browser.webDriver.findElement(this.getObject("tenantAddedByAutomation",LocatorType)).getText();
			        			if(TempActualValue.contains((TestData)))
			        			{
			        				System.out.println("Username   "+ TempActualValue);
			        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
			        				testStepResult="Pass";
			        				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
			            			System.out.println(sdf.format(System.currentTimeMillis()));
			        				if(Screenshot.equalsIgnoreCase("Y"))
			        				{
			        					screnshotcls obj=new screnshotcls(Browser.webDriver);
			        				}
			        				//break;
			        			}
			        		}
						}				
					}
					else if(LocatorValue.equals("subscriptionToEmailList"))
					{
						if(TestData.equals("NA"))
						{
							WebElement TogetRows = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
			        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("input"));
			        		UsrMgtTblRwCount = TotalRowsList.size();
			        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
			        		for(int i=0;i<=UsrMgtTblRwCount;i++)
			        		{
			        			System.out.println(TotalRowsList.get(i).getText());
			        			TotalRowsList.get(i).click();
			        			testStepResult="Pass";
			        		}
						}
						else
						{
							WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"emailList\"]/div[3]/ul")); 
			        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("li"));
			        		UsrMgtTblRwCount = TotalRowsList.size();
			        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
			        		for(WebElement idItem  : TotalRowsList)
			        		{ 
			        			
			        			System.out.println(idItem.getText());
			        			System.out.println(TestData);
			        			if(idItem.getText().equals(TestData))
			        			{
			        				idItem.click();
			        				testStepResult="Pass";
			        				break;
			        			}
			        			
			        			
			        		}
						}  				
		        		
		        		
					}
					else if(LocatorValue.equals("editUserAddedByAutomation"))
					{
						String TempActualValue = null;
		        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[3]/table/tbody"));
		        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRowsList.size();
		        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject("userAddedByAutomation",LocatorType)).getText();
		        			if(TempActualValue.contains((TestData)))
		        			{
		        				System.out.println("Username   "+ TempActualValue);
		        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
		        				testStepResult="Pass";
		        				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
		            			System.out.println(sdf.format(System.currentTimeMillis()));
		        				if(Screenshot.equalsIgnoreCase("Y"))
		        				{
		        					screnshotcls obj=new screnshotcls(Browser.webDriver);
		        				}
		        				//break;
		        			}
		        		}
			        	
					}
					else if(LocatorValue.equals("automationUserPrivilegeGroup"))
		        	{
		        		String TempActualValue = null;
		        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"SelectedRoles\"]"));
		        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("option"));
		        		UsrMgtTblRwCount = TotalRolesList.size();
		        		System.out.println("Total number of Roles in the list are   "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
		        			if(TempActualValue.contains((TestData)))
		        			{
		        				System.out.println("Role   "+ TempActualValue);
		        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
		        				testStepResult="Pass";
		        				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
		            			System.out.println(sdf.format(System.currentTimeMillis()));
		        				if(Screenshot.equalsIgnoreCase("Y"))
		        				{
		        					screnshotcls obj=new screnshotcls(Browser.webDriver);
		        				}
		        				//break;
		        			}
		        		}
		        	}
					
					else if(LocatorValue.equals("UpdateSubscription"))
		        	{
		        		String TempActualValue = null;
		        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainView\"]/div[2]/div[4]/table/tbody"));
		        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRolesList.size();
		        		System.out.println("Total number of Subscriptions = "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			if(UsrMgtTblRwCount == 1)
		        			{
		        				TempActualValue=Browser.webDriver.findElement(this.getObject("subscriptionAdded",LocatorType)).getText();
		        				
		        				System.out.println("Subscription to update = "+TempActualValue);
			        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
			        				testStepResult="Pass";
			        				
			            			
			        				if(Screenshot.equalsIgnoreCase("Y"))
			        				{
			        					screnshotcls obj=new screnshotcls(Browser.webDriver);
			        				}
			        			
		        			}
		        			else
		        			{
		        				TempActualValue=Browser.webDriver.findElement(this.getObject("multipleSubscriptionAdded",LocatorType)).getText();
		        				
		        				if(TempActualValue.contains((TestData)))
			        			{
		        					System.out.println("Subscription to update = "+TempActualValue);
			        				Browser.webDriver.findElement(this.getObject("MultipleSubscriptionEditBtn",LocatorType)).click();
			        				testStepResult="Pass";			        				
			        				if(Screenshot.equalsIgnoreCase("Y"))
			        				{
			        					screnshotcls obj=new screnshotcls(Browser.webDriver);
			        				}
			        				break;
			        			}
		        			}
		        			
		        			
		        			
		        			
		        		}
		        	}
					else if(LocatorValue.equals("DeleteSubscription"))
		        	{
		        		String TempActualValue = null;
		        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainView\"]/div[2]/div[4]/table/tbody"));
		        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRolesList.size();
		        		System.out.println("Total number of Subscriptions = "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			if(UsrMgtTblRwCount == 1)
		        			{
		        				TempActualValue=Browser.webDriver.findElement(this.getObject("subscriptionAdded",LocatorType)).getText();
		        				
		        				System.out.println("Subscription to delete = "+TempActualValue);
			        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
			        				testStepResult="Pass";
			        				
			            			
			        				if(Screenshot.equalsIgnoreCase("Y"))
			        				{
			        					screnshotcls obj=new screnshotcls(Browser.webDriver);
			        				}
			        			
		        			}
		        			else
		        			{
		        				TempActualValue=Browser.webDriver.findElement(this.getObject("multipleSubscriptionAdded",LocatorType)).getText();
		        				
		        				if(TempActualValue.contains((TestData)))
			        			{
		        					System.out.println("Subscription to delete = "+TempActualValue);
			        				Browser.webDriver.findElement(this.getObject("MultipleSubscriptionDeleteBtn",LocatorType)).click();
			        				testStepResult="Pass";			        				
			        				if(Screenshot.equalsIgnoreCase("Y"))
			        				{
			        					screnshotcls obj=new screnshotcls(Browser.webDriver);
			        				}
			        				break;
			        			}
		        			}		        			
		        		}
		        	}
					else if(LocatorValue.equals("ViewSubscription"))
					{
						String TempActualValue = null;
		        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainView\"]/div[2]/div[4]/table/tbody"));
		        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("tr"));
		        		UsrMgtTblRwCount = TotalRolesList.size();
		        		System.out.println("Total number of Subscriptions = "+ UsrMgtTblRwCount);
		        		for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			if(UsrMgtTblRwCount == 1)
		        			{
		        				TempActualValue=Browser.webDriver.findElement(this.getObject("subscriptionAdded",LocatorType)).getText();
		        				
		        				System.out.println("Subscription to view = "+TempActualValue);
			        				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
			        				testStepResult="Pass";
			        				
			            			
			        				if(Screenshot.equalsIgnoreCase("Y"))
			        				{
			        					screnshotcls obj=new screnshotcls(Browser.webDriver);
			        				}
			        			
		        			}
		        			else
		        			{
		        				TempActualValue=Browser.webDriver.findElement(this.getObject("multipleSubscriptionAdded",LocatorType)).getText();
		        				
		        				if(TempActualValue.contains((TestData)))
			        			{
		        					System.out.println("Subscription to view = "+TempActualValue);
			        				Browser.webDriver.findElement(this.getObject("MultipleSubscriptionViewLink",LocatorType)).click();
			        				testStepResult="Pass";			        				
			        				if(Screenshot.equalsIgnoreCase("Y"))
			        				{
			        					screnshotcls obj=new screnshotcls(Browser.webDriver);
			        				}
			        				break;
			        			}
		        			}		        			
		        		}
					}
					
				//###########################//	
					else
					{
						Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
						testStepResult="Pass";
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
		    			System.out.println(sdf.format(System.currentTimeMillis()));
		    			if(LocatorValue.equals("Managment_console"))
						{
							Browser.webDriver.navigate().refresh();
						}
					}
				
				 
				}
				
			}
			catch(ElementNotInteractableException e)
			{
				try
				{
				    WebElement element = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
					//JavascriptExecutor js = (JavascriptExecutor)Browser.webDriver; #Revisit
					//js.executeScript("arguments[0].click();", element); 
					testStepResult="Fail";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
        			System.out.println(sdf.format(System.currentTimeMillis()));
        			if(LocatorValue.equals("Managment_console"))
					{
						Browser.webDriver.navigate().refresh();
						testStepResult="Pass";
					}
					if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				}
					catch(Exception e1)
					{
						testStepResult="Fail";
						System.out.println("Exception in clickButton Action   "+e1);
						ExceptionMessage="Exception in clickButton Action   "+e1.getMessage().toString();
						if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
						if(LocatorValue.equals("Managment_console"))
						{
							Browser.webDriver.navigate().refresh();
							testStepResult="Pass";
						}
						if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
					}
			}
			catch(Exception e)
			{
				    
				    if(LocatorValue.equals("Managment_console"))
					{
						Browser.webDriver.navigate().refresh();
						testStepResult="Pass";
					}
				    else
				    {
				    //ExceptionMessage="Exception in clickButton Action     "+e.getMessage().toString();
				    System.out.println("Exception in clickButton Action   "+e);
				    
				    testStepResult="Fail";
				    }
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
					
			
		}
		
		return testStepResult;
		

 }
	 public String   clickButton1() 
 { 
		{
			//System.out.println("I m in CLICKBUTTON"+LocatorValue+"  "+LocatorType);
			try
			{
				
				


        
				if(TestData.equalsIgnoreCase("Selectpatient"))
				{
					
					// element = this.getObject(LocatorValue,LocatorType);
					 
					//WebDriverWait wait = new WebDriverWait(driver, 10);
					 
					//element = wait.until(ExpectedConditions.elementToBeClickable(LocatorValue));
					 
					//element.click();
					 
					
					
					String id=getID();
		            Browser.webDriver.findElement(By.id(id)).click();	
		            testStepResult="Pass";
				}
				
				else 
				{
					
				Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				testStepResult="Pass";
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				 }
				 
				}
			}
			catch(ElementNotInteractableException e)
			{
				try
				{
				    WebElement element = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
//					JavascriptExecutor js = (JavascriptExecutor)Browser.webDriver; #Revisit
//					js.executeScript("arguments[0].click();", element); 
					testStepResult="Fail";
					
					if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				}
					catch(Exception e1)
					{
						testStepResult="Fail";
						System.out.println("Exception in clickButton Action   "+e1);
						ExceptionMessage="Exception in clickButton Action   "+e1.getMessage().toString();
						if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
						if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
					}
			}
			catch(Exception e)
			{
				    System.out.println("Exception in clickButton Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in clickButton Action     "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
					
			
		}
		
		return testStepResult;
		

 }
	 public String   AlertHandler() 
 { 
        {
        	try
        	{
       		 System.out.println("alertMessage");

            

         // wait = new WebDriverWait(driver, 15);
            // wait.until(ExpectedConditions.alertIsPresent());
             System.out.println("alertMessage1");
             // Wait for Alert to be present
      
          //   org.openqa.selenium.Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
             // Wait for Alert to be present
      
            // Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
            
             
        		System.out.println("alertMessage1");
        	if(TestData.equalsIgnoreCase("Y"))
        	{
        		 System.out.println("alertMessage");
        org.openqa.selenium.Alert alert = Browser.webDriver.switchTo().alert();
    		
        String alertMessage= Browser.webDriver.switchTo().alert().getText();	
 	   System.out.println(alertMessage);
 	  Thread.sleep(5000);
    	alert.accept();
        		WebElement currentElement = Browser.webDriver.switchTo().activeElement();
        		String id=currentElement.getAttribute("id");
        		System.out.println(id);
    	
    	testStepResult="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{System.out.println("alertMessage2");
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
        	}
    		else if(TestData.equalsIgnoreCase("N"))
    		{System.out.println("alertMessage3");
    			org.openqa.selenium.Alert alert1 = Browser.webDriver.switchTo().alert();
        		//update is executed
        		alert1.dismiss();
        		testStepResult="Pass";
        		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
    		}
        	}
			catch(Exception e)
			{System.out.println("alertMessage4");
				    System.out.println("Exception in AlertAccept Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in AlertAccept Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        }
        return testStepResult;
		  

 }
	 
public String   SelectQuery() 
{ 
	try
	{ 
//				System.out.println("hiii"+TestData);
	        	String [] data1=TestData.split("#");
//	        	System.out.println("hiii"+data1[0]);
//	        	System.out.println("hiii"+data1[1]);
	            String User=prop.getProperty("LCT_ServerName");                           
	            //System.out.println("hiii");	                                     
				String PWD=prop.getProperty("LCT_dbpassword");  
				//System.out.println("hiii");
				String ServerName=prop.getProperty("LCT_ServerName"); 
				//System.out.println("hiii");
				String Database=prop.getProperty("LCT_databaseName");  
				//System.out.println("hiii3");
				String Query=data1[0];
				//System.out.println("hiii2");
				String ExpectedResult1=data1[1];
				String ExpectedResult2=null;
				String ExpectedResult3=null;
				String ExpectedResult4=null;
				String ExpectedResult5=null;
				if(CheckSessionIdforSignInSignOut)
				{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
	    			//System.out.println(sdf.format(System.currentTimeMillis()));
	    			String [] TodaysDateTime=sdf.format(System.currentTimeMillis()).toString().split(" ");
					ExpectedResult2=TodaysDateTime[0];
				}
				else
				{
					try
					{
						ExpectedResult2=data1[2];
						ExpectedResult3=data1[3];
						ExpectedResult4=data1[4];
						ExpectedResult5=data1[5];
					}
					catch(Exception e)
					{
						
					}
				}
				
				//System.out.println("hiii1");
			//	System.out.println(ServerName);
				//System.out.println(User);
				//System.out.println(PWD);
	        	Connection con=MyDbConnection(User,PWD,ServerName,Database);
	        	//System.out.println("hiiiwew");
	        	String tenantname=prop.getProperty("Tenant");
	        	if(Query.contains("$") && !Query.contains("TenantFeatures"))
	        	{
	        		if(Query.indexOf("$")==Query.length() - 1)
	        		{
	        			Query = Query.substring(0, Query.length() - 1)+"'"+tenantname+"'";
		        		//System.out.println(Query);
	        		}
	        		
	        		else if(!(Query.indexOf("$")==Query.length() - 1) && !currentTenantName.equals(null))
	        		{
	        			Query = Query.replace("$", tenantname);
	        			//System.out.println(Query);
	        		}
	        		
	        	}
	        	else if(Query.contains("$") && Query.contains("TenantFeatures"))
	        	{
	        		Query = Query.replace("$", tenantname);
        			//System.out.println(Query);
	        	}
	        	Statement stmt=con.createStatement();
	        	System.out.println(Query);
	        	ResultSet rs=stmt.executeQuery(Query);
	        	//System.out.println("Query Result"+rs.getString(2));
	        	while(rs.next())
	        	{
	        		if(CheckSessionIdforSignInSignOut)
	        		{
	        		String a1 = rs.getString(1);
	        		String a2 = rs.getString(2);
	        		String a3 = rs.getString(3);
	        			AutoAssert.Assert(ExpectedResult1,rs.getString(1)); 
	        			if(rs.getString(2).contains(ExpectedResult2))
	        			{
	        				ExpectedResult2 = "yes";
	        			}
			        	AutoAssert.Assert(ExpectedResult2,"yes");
			        	if(!rs.getString(3).equals(null))
	        			{
	        				ExpectedResult3 = "yes";
	        			}
			        	AutoAssert.Assert(ExpectedResult3,"yes");
		        		Current_Pwd=rs.getString(3);
	        		}
	        		else if(Query.contains("Version"))
	        		{
	        			try		
	        			{
//	        				System.out.println("ExpectedResult   "+ExpectedResult1);
//		        			System.out.println("ActualResult   "+rs.getString(1));
		        			AutoAssert.Assert(ExpectedResult1,rs.getString(1)); 
	        			}
	        			catch(Exception e)
	        			{
	        				
	        			}
	        			
	        		}
	        		else if(Query.contains("TenantId") && !Query.contains("KeyValue"))
	        		{
	        			try		
	        			{
//	        				System.out.println("ExpectedResult   "+ExpectedResult1);
//		        			System.out.println("ActualResult   "+rs.getString(1));
		        			String ActualResult ;
		        			if(!ExpectedResult1.equals(null) && !rs.getString(1).equals(null))
		        			{
		        				ExpectedResult1 = "True";
		        				ActualResult = "True";
		        				currentTenantName = rs.getString(1);
		        				if(!isCPcopied)
		        				{
		        					RLSbeforcopy = rs.getString(1);
		        					isCPcopied = true;
		        				}
		        				else
		        				{
		        					RLSaftercopy = rs.getString(1);
		        				}
		        				
		        			}
		        			else
		        			{
		        				ExpectedResult1 = "False";
		        				ActualResult = "False";
		        			}
		        			AutoAssert.Assert(ExpectedResult1,ActualResult); 
		        			
	        			}
	        			catch(Exception e)
	        			{
	        				
	        			}
	        			
	        		}
	        		else if(Query.contains("KeyValue"))
	        		{
	        			try		
	        			{
//	        				System.out.println("ExpectedResult   "+ExpectedResult1);
//		        			System.out.println("ActualResult   "+rs.getString(1));
		        			String ActualResult ;
		        			if(!ExpectedResult1.equals(null) && !rs.getString(1).equals(null))
		        			{
		        				ExpectedResult1 = "True";
		        				ActualResult = "True";
		        				selectQueryResult = rs.getString(1);
		        			}
		        			else
		        			{
		        				ExpectedResult1 = "False";
		        				ActualResult = "False";
		        			}
		        			AutoAssert.Assert(ExpectedResult1,ActualResult); 
		        			
	        			}
	        			catch(Exception e)
	        			{
	        				
	        			}
	        			
	        		}
	        		else if(Query.contains("BlockUnblockUsers"))
	        		{
	        			try		
	        			{
//	        				System.out.println("ExpectedResult   "+ExpectedResult1);
//		        			System.out.println("ActualResult   "+rs.getString(1));
		        			String ActualResult = rs.getString(1);
		        			if(ExpectedResult1.equals(ActualResult))
		        			{
		        				ExpectedResult1 = "True";
		        				ActualResult = "True";
		        				inactiveUserStatus = rs.getString(1);
		        			}
		        			else
		        			{
		        				ExpectedResult1 = "False";
		        				ActualResult = "False";
		        			}
		        			AutoAssert.Assert(ExpectedResult1,ActualResult); 
		        			
	        			}
	        			catch(Exception e)
	        			{
	        				
	        			}
	        		}
	        		else
	        		{
	        			try
	        			{
	        				AutoAssert.Assert(ExpectedResult1,rs.getString(1)); 
//	        				System.out.println(ExpectedResult1);
//	        				System.out.println(rs.getString(1));
				        	AutoAssert.Assert(ExpectedResult2,rs.getString(2)); 
				        	AutoAssert.Assert(ExpectedResult3,rs.getString(3)); 
				        	AutoAssert.Assert(ExpectedResult4,rs.getString(4)); 
				        	AutoAssert.Assert(ExpectedResult5,rs.getString(5));
			        		Current_Pwd=rs.getString(3);
	        			}
	        			catch(Exception e)
	                    {
	                  
	                  	
	                  }
	        		}
	        		
//	        		System.out.println("Query Result"+Current_Pwd);
	        		break;
	        	}
	        	
	        	 
	        	//System.out.println("ExpectedResult"+ExpectedResult1);
	        	testStepResult="Pass";
	        	CheckSessionIdforSignInSignOut = false;
	        
	      }
	      catch(NullPointerException e)
            {
          
          	System.out.println("Patient is not correct  or deleted");
          	 testStepResult="Fail";
          }
          
	      catch(AssertionError e)
  		{
  			System.out.println("Fail");
  			testStepResult="Fail";
  			 ExceptionMessage="Exception in CheckBoxUnSelect Action   "+e.getMessage().toString();
  			 if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
  			System.out.println(e.getMessage());
  			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
  		}
			catch(Exception e)
			{
				    System.out.println("Exception in CheckBoxUnSelect Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in CheckBoxUnSelect Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
	        	
	        	
	        	
	      return testStepResult;
		

 }
public String   LPTDBSelectQuery() 
{ 
	try
	{ 
	        	String [] data1=TestData.split("#");
	            String User=prop.getProperty("LCT_ServerName");                           
				String PWD=prop.getProperty("LCT_dbpassword");  
				String ServerName=prop.getProperty("LCT_ServerName"); 
				String Database=prop.getProperty("LCT_databaseName");  
				String Query=data1[0];
				String ExpectedResult1=data1[1];
				String ExpectedResult2=null;
				String ExpectedResult3=null;
				String ExpectedResult4=null;
				String ExpectedResult5=null;
				if(CheckSessionIdforSignInSignOut)
				{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
	    			System.out.println(sdf.format(System.currentTimeMillis()));
	    			String [] TodaysDateTime=sdf.format(System.currentTimeMillis()).toString().split(" ");
					ExpectedResult2=TodaysDateTime[0];
				}
				else
				{
					try
					{
						ExpectedResult2=data1[2];
						ExpectedResult3=data1[3];
						ExpectedResult4=data1[4];
						ExpectedResult5=data1[5];
					}
					catch(Exception e)
					{
						
					}
				}
				Connection con=MylptDbConnection(User,PWD,ServerName,Database);
	        	String tenantname=prop.getProperty("Tenant");
	        	if(Query.contains("$") && !Query.contains("TenantFeatures"))
	        	{
	        		if(Query.indexOf("$")==Query.length() - 1)
	        		{
	        			Query = Query.substring(0, Query.length() - 1)+"'"+tenantname+"'";
		        		System.out.println(Query);
	        		}
	        		
	        		else if(!(Query.indexOf("$")==Query.length() - 1) && !currentTenantName.equals(null))
	        		{
	        			Query = Query.replace("$", tenantname);
	        			System.out.println(Query);
	        		}
	        		
	        	}
	        	else if(Query.contains("$") && Query.contains("TenantFeatures"))
	        	{
	        		Query = Query.replace("$", tenantname);
        			System.out.println(Query);
	        	}
	        	Statement stmt=con.createStatement();
	        	System.out.println(Query);
	        	ResultSet rs=stmt.executeQuery(Query);
	        	while(rs.next())
	        	{
	        		if(CheckSessionIdforSignInSignOut)
	        		{
	        		String a1 = rs.getString(1);
	        		String a2 = rs.getString(2);
	        		String a3 = rs.getString(3);
	        			AutoAssert.Assert(ExpectedResult1,rs.getString(1)); 
	        			if(rs.getString(2).contains(ExpectedResult2))
	        			{
	        				ExpectedResult2 = "yes";
	        			}
			        	AutoAssert.Assert(ExpectedResult2,"yes");
			        	if(!rs.getString(3).equals(null))
	        			{
	        				ExpectedResult3 = "yes";
	        			}
			        	AutoAssert.Assert(ExpectedResult3,"yes");
		        		Current_Pwd=rs.getString(3);
	        		}
	        		else if(Query.contains("Version"))
	        		{
	        			try		
	        			{
	        				System.out.println("ExpectedResult   "+ExpectedResult1);
		        			System.out.println("ActualResult   "+rs.getString(1));
		        			AutoAssert.Assert(ExpectedResult1,rs.getString(1)); 
	        			}
	        			catch(Exception e)
	        			{
	        				
	        			}
	        			
	        		}
	        		else if(Query.contains("TenantId") && !Query.contains("KeyValue"))
	        		{
	        			try		
	        			{
	        				System.out.println("ExpectedResult   "+ExpectedResult1);
		        			System.out.println("ActualResult   "+rs.getString(1));
		        			String ActualResult ;
		        			if(!ExpectedResult1.equals(null) && !rs.getString(1).equals(null))
		        			{
		        				ExpectedResult1 = "True";
		        				ActualResult = "True";
		        				currentTenantName = rs.getString(1);
		        				if(!isCPcopied)
		        				{
		        					RLSbeforcopy = rs.getString(1);
		        					isCPcopied = true;
		        				}
		        				else
		        				{
		        					RLSaftercopy = rs.getString(1);
		        				}
		        				
		        			}
		        			else
		        			{
		        				ExpectedResult1 = "False";
		        				ActualResult = "False";
		        			}
		        			AutoAssert.Assert(ExpectedResult1,ActualResult); 
		        			
	        			}
	        			catch(Exception e)
	        			{
	        				
	        			}
	        			
	        		}
	        		else if(Query.contains("KeyValue"))
	        		{
	        			try		
	        			{
	        				System.out.println("ExpectedResult   "+ExpectedResult1);
		        			System.out.println("ActualResult   "+rs.getString(1));
		        			String ActualResult ;
		        			if(!ExpectedResult1.equals(null) && !rs.getString(1).equals(null))
		        			{
		        				ExpectedResult1 = "True";
		        				ActualResult = "True";
		        				selectQueryResult = rs.getString(1);
		        			}
		        			else
		        			{
		        				ExpectedResult1 = "False";
		        				ActualResult = "False";
		        			}
		        			AutoAssert.Assert(ExpectedResult1,ActualResult); 
		        			
	        			}
	        			catch(Exception e)
	        			{
	        				
	        			}
	        			
	        		}
	        		else if(Query.contains("BlockUnblockUsers"))
	        		{
	        			try		
	        			{
	        				System.out.println("ExpectedResult   "+ExpectedResult1);
		        			System.out.println("ActualResult   "+rs.getString(1));
		        			String ActualResult = rs.getString(1);
		        			if(ExpectedResult1.equals(ActualResult))
		        			{
		        				ExpectedResult1 = "True";
		        				ActualResult = "True";
		        				inactiveUserStatus = rs.getString(1);
		        			}
		        			else
		        			{
		        				ExpectedResult1 = "False";
		        				ActualResult = "False";
		        			}
		        			AutoAssert.Assert(ExpectedResult1,ActualResult); 
		        			
	        			}
	        			catch(Exception e)
	        			{
	        				
	        			}
	        		}
	        		else
	        		{
	        			try
	        			{
	        				AutoAssert.Assert(ExpectedResult1,rs.getString(1)); 
	        				System.out.println(ExpectedResult1);
	        				System.out.println(rs.getString(1));
				        	AutoAssert.Assert(ExpectedResult2,rs.getString(2)); 
				        	AutoAssert.Assert(ExpectedResult3,rs.getString(3)); 
				        	AutoAssert.Assert(ExpectedResult4,rs.getString(4)); 
				        	AutoAssert.Assert(ExpectedResult5,rs.getString(5));
			        		Current_Pwd=rs.getString(3);
	        			}
	        			catch(Exception e)
	                    {
	                  
	                  	
	                  }
	        		}
	        		
	        		System.out.println("Query Result"+Current_Pwd);
	        		break;
	        	}
	        	testStepResult="Pass";
	        	CheckSessionIdforSignInSignOut = false;
	      }
	      catch(NullPointerException e)
            {
          
          	System.out.println("Patient is not correct  or deleted");
          	 testStepResult="Fail";
          }
          
	      catch(AssertionError e)
  		{
  			System.out.println("Fail");
  			testStepResult="Fail";
  			 ExceptionMessage="Exception in CheckBoxUnSelect Action   "+e.getMessage().toString();
  			 if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
  			System.out.println(e.getMessage());
  			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
  		}
			catch(Exception e)
			{
				    System.out.println("Exception in CheckBoxUnSelect Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in CheckBoxUnSelect Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
	        	
	        	
	        	
	      return testStepResult;
		

 }
	 public String   CheckBoxUnSelect() 
 { 
        {
        
        	try
        	{
        		if(LocatorValue.equals("PrivilegeTypes"))
        		{
        			String [] privilegeDetails= TestData.split("#") ;
            		WebElement TogetRows = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
            		System.out.println(TogetRows.getText()); 
            		List<WebElement>TotalRowsList = TogetRows.findElements(By.xpath("//div[@class='accordion-toggle headtab ng-scope']"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(WebElement CPG  : TotalRowsList)
            		{
            			System.out.println(CPG.getText());  
            			if(CPG.getText().equals(privilegeDetails[0]))
            			{
            				List<WebElement>TotalspanList = CPG.findElements(By.xpath("//div[@class='child_tab1 ng-scope']"));
                    		int spanCount = TotalspanList.size();
                    		System.out.println("Total number of Rows in the table are   "+ spanCount);
                    		for(WebElement CP :  TotalspanList)
                    		{
                    			System.out.println(CP.getText());
                    			System.out.println(privilegeDetails[1]);
                    			if(CP.getText().equals(privilegeDetails[1]))
                    			{
                    				WebElement privilegeChkBox = CP.findElement(By.tagName("input"));
                    				System.out.println(privilegeChkBox.isSelected());
                    				if(privilegeChkBox.isSelected())
                            		{                    					
                    					privilegeChkBox.click();
                    					testStepResult="Pass";
                            			break;
                            		}
                            		else
                            		{                            			
                            			testStepResult="Pass";	
                                		break;
                            		}
                    			}
                    		}
            			}
            		}
        		}
        		else if(LocatorValue.equals("MainPrivilegeType"))
        		{
        			//String [] privilegeDetails= TestData.split("#") ;
            		WebElement TogetRows = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
            		System.out.println(TogetRows.getText()); 
            		List<WebElement>TotalRowsList = TogetRows.findElements(By.xpath("//div[@class='accordion-toggle headtab ng-scope']"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(WebElement CPG :  TotalRowsList)
            		{
            			System.out.println(CPG.getText());  
            			if(CPG.getText().equals(TestData))
            			{
            				
                    				WebElement privilegeChkBox = CPG.findElement(By.tagName("input"));
                    				System.out.println(privilegeChkBox.isSelected());
                    				if(privilegeChkBox.isSelected())
                            		{                    					
                    					privilegeChkBox.click();	
                    					testStepResult="Pass";
                            			break;
                            		}
                            		else
                            		{                            			
                                		
                                		break;
                            		}
                    			
            			}
            		}
        		}
        		else
        		{
        			if(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).isSelected())
            		{
            			
            			Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();
            			testStepResult="Pass";
            		}
            		else
            		{
            			System.out.println("Hii");
            			testStepResult="Pass";
            		}
        		}   		

        		
        	
        		//testStepResult="Pass";
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			testStepResult="Fail";
    			 ExceptionMessage="Exception in CheckBoxUnSelect Action   "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
    			System.out.println(e.getMessage());
    			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
    		}
			catch(Exception e)
			{
				    System.out.println("Exception in CheckBoxUnSelect Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in CheckBoxUnSelect Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        }
        return testStepResult;
		

 }
	 public String   CheckBoxSelect() 
 { 
        {
        
        	try
        	{
        		if(LocatorValue.equals("PrivilegeTypes"))
        		{
        			String [] privilegeDetails= TestData.split("#") ;
            		WebElement TogetRows = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
            		System.out.println(TogetRows.getText()); 
            		List<WebElement>TotalRowsList = TogetRows.findElements(By.xpath("//div[@class='accordion-toggle headtab ng-scope']"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(WebElement CPG  : TotalRowsList)
            		{
            			System.out.println(CPG.getText());  
            			if(CPG.getText().equals(privilegeDetails[0]))
            			{
            				List<WebElement>TotalspanList = CPG.findElements(By.xpath("//div[@class='child_tab1 ng-scope']"));
                    		int spanCount = TotalspanList.size();
                    		System.out.println("Total number of Rows in the table are   "+ spanCount);
                    		for(WebElement CP  : TotalspanList)
                    		{
                    			System.out.println(CP.getText());
                    			System.out.println(privilegeDetails[1]);
                    			if(CP.getText().equals(privilegeDetails[1]))
                    			{
                    				WebElement privilegeChkBox = CP.findElement(By.tagName("input"));
                    				System.out.println(privilegeChkBox.isSelected());
                    				if(privilegeChkBox.isSelected())
                            		{                    					
                            			System.out.println("Hii");
                            			break;
                            		}
                            		else
                            		{                            			
                                		privilegeChkBox.click();	
                                		break;
                            		}
                    			}
                    		}
            			}
            		}
        		}
        		else if(LocatorValue.equals("MainPrivilegeType"))
        		{
        			//String [] privilegeDetails= TestData.split("#") ;
            		WebElement TogetRows = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
            		System.out.println(TogetRows.getText()); 
            		List<WebElement>TotalRowsList = TogetRows.findElements(By.xpath("//div[@class='accordion-toggle headtab ng-scope']"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(WebElement CPG  : TotalRowsList)
            		{
            			System.out.println(CPG.getText());  
            			if(CPG.getText().equals(TestData))
            			{
            				
                    				WebElement privilegeChkBox = CPG.findElement(By.tagName("input"));
                    				System.out.println(privilegeChkBox.isSelected());
                    				if(privilegeChkBox.isSelected())
                            		{                    					
                            			System.out.println("Hii");
                            			break;
                            		}
                            		else
                            		{                            			
                                		privilegeChkBox.click();	
                                		break;
                            		}
                    			
            			}
            		}
        		}
        		else
        		{
        			if(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).isSelected())
            		{
            			System.out.println("Hii");
            			
            		}
            		else
            		{
            			Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).click();	
            		}
        		}   		

        		
        	
        		testStepResult="Pass";
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			testStepResult="Fail";
    			 ExceptionMessage="Exception in CheckBoxUnSelect Action   "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
    			System.out.println(e.getMessage());
    			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
    		}
			catch(Exception e)
			{
				    System.out.println("Exception in CheckBoxUnSelect Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in CheckBoxUnSelect Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        }
        return testStepResult;
		

 }
	 public String   ElementExist() 
 { 
        {
        	String actres="false";
        	try
        	{
        		if(LocatorValue.equals("MainPrivilegeType"))
        		{
        			String [] TestDataDetails= TestData.split("#") ;
            		WebElement TogetRows = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
            		//System.out.println(TogetRows.getText()); 
            		List<WebElement>TotalRowsList = TogetRows.findElements(By.xpath("//div[@class='accordion-toggle headtab ng-scope']"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(WebElement CPG  : TotalRowsList)
            		{
            			System.out.println(CPG.getText());  
            			System.out.println(TestDataDetails[0]);
            			if(CPG.getText().equals(TestDataDetails[0]))
            			{
            				if(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).isDisplayed())
                    		{
                    			actres="true";
                    			TestData=TestDataDetails[1];
                    			break;
                    		}	
            			}
            		}
        		}
        		else
        		{
        			if(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).isDisplayed())
            		{
            			actres="true";
            		}
        		}
        		
        		AutoAssert.Assert(actres,TestData); 
        	
        		testStepResult="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			testStepResult="Fail";
    			 ExceptionMessage="Exception in ElementExist Action   "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
    			System.out.println(e.getMessage());
    			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
    		}
			catch(Exception e)
			{
				    System.out.println("Exception in ElementExist Action   "+e);
				    if(LocatorValue.equals("PowerbiProUser"))
	        		{
				    	testStepResult="Pass";
	        		}
				    else
				    {
				    	testStepResult="Fail";
				    }
				    
				    ExceptionMessage="Exception in ElementExist Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        }
        return testStepResult;
        
        

 }
	 public String   IsCheckBox() 
 { 
        {
        	String actres="false";
        	try
        	{
        		if(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).isSelected())
        		{
        			actres="true";
        		}
        		AutoAssert.Assert(actres,TestData); 
        	
        		testStepResult="Pass";
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			testStepResult="Fail";
    			 ExceptionMessage="Exception in IsCheckBox Action   "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
    			System.out.println(e.getMessage());
    			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
    		}
			catch(Exception e)
			{
				    System.out.println("Exception in ElementExist Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in ElementExist Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        }
        return testStepResult;
        

 }
	 public String   VerifyURL() 
 { 
        {
        	
        	try
        	{
        		System.out.println("sdsds"+TestData);
        		if(TestData.equals("fd"))
        		{
        			System.out.println("sdsdsewe"+TestData);
        		String URL = Browser.webDriver.getCurrentUrl();
        		System.out.println("sdsdsewe"+URL);
        		AutoAssert.Assert(URL, prop.getProperty("Url") );
        		}
        		else
        		{
        			String URL = Browser.webDriver.getCurrentUrl();
            		AutoAssert.Assert(URL, prop.getProperty("Url1") );
        		}
        		testStepResult="Pass";
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
        	}
        	catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			testStepResult="Fail";
    			 ExceptionMessage="Exception in IsCheckBox Action   "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
    			System.out.println(e.getMessage());
    			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
    		}
			catch(Exception e)
			{
				    System.out.println("Exception in ElementExist Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in ElementExist Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        }
        return testStepResult;
 

 }
	 public String   SetTextPassword() 
 { 
            
        	try
        	{
            Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(Current_Pwd);
            testStepResult="Pass";
            
            if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
            
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in setText Action   "+e);
				    testStepResult="Fail";
				    System.out.println("Ashok    Status is   "+testStepResult);
				    ExceptionMessage="Exception in setText Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    					    	
				    	}
			}
        	return testStepResult;
            
        

 }
	 public String   CompareTxt() 
 { 
        {
        	try
        	{
        		String[] ss=LocatorValue.split("#");
			 	
			 	
        		Browser.webDriver.findElement(By.id(ss[0])).click();
        	    String omdcomment=Browser.webDriver.findElement(By.id(ss[0])).getText();
        		//System.out.println("Header interp details     "+omdcomment);
        		//Thread.sleep(5000);
        		
        		// check whether exist or not so test will not fail with any user(for FMD this tab is not visible)
        		if(Browser.webDriver.findElement(By.id("tabmemoInterprepations_T1T")).isDisplayed())
        		{
        		Browser.webDriver.findElement(By.id("tabmemoInterprepations_T1T")).click();
        		}
        		
        		Thread.sleep(5000);
        		Browser.webDriver.findElement(By.id(ss[1])).click();
        		String fmdcomment=Browser.webDriver.findElement(By.id(ss[1])).getText();
        		//System.out.println("FMD details     "+fmdcomment);
        		Thread.sleep(4000);
        		//System.out.println("Result is    "+omdcomment.contains(fmdcomment));
        		if(!(omdcomment.contains(fmdcomment)))
        		{
        			testStepResult="True";
        		}
        		else
        		{
        			testStepResult="Fail";
        		}
        		
        	if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in CompareTxt Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in CompareTxt Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        }
        return testStepResult;
        
        
        

 }
	 public String   RtClkOp() 
 { 
            
        	try
        	{
        		
        		
        		if(LocatorValue.equals("divisionAddedByAutomation"))
        		{
        			String[] testDataItem = TestData.split("#");
        			String TempActualValue = null;
            		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[4]/div/div/div/div"));
            		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("a"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(int i=1;i<=UsrMgtTblRwCount;i++)
            		{
            			UsrMgtTblRwNo = i;
            			TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
            			TempActualValue=TempActualValue.trim();
            			System.out.println(TempActualValue);
            			if(TempActualValue.trim().contains((testDataItem[0].trim())))
            			{
            				WebElement webele=Browser.webDriver.findElement(this.getObject(LocatorValue, LocatorType));
            				DivAddedByAuto = webele;
            				System.out.println("DivAddedByAuto   "+DivAddedByAuto.getText());
                    		String webelmnt = webele.getText();
                    		System.out.println("Locatervalue"+LocatorValue);
                    		System.out.println("LocaterType"+LocatorType);
                    		System.out.println(webelmnt);
                    		Actions oAction = new Actions(Browser.webDriver);
                    		oAction.moveToElement(webele);
                    		//To perform right click
                    		oAction.contextClick(webele).build().perform();
                    		//To select menu after right click
                    		Thread.sleep(20000);
                    		if(testDataItem[1].equals("Add"))
                    		{
                    			WebElement elementOpen = Browser.webDriver.findElement(this.getObject("contextMenuAddHospital", LocatorType));
                    			elementOpen.click();
                    		}
                    		else if(testDataItem[1].equals("Delete"))
                    		{
                    			WebElement elementOpen = Browser.webDriver.findElement(this.getObject("contextMenuDeleteHospital", LocatorType)); 
                    			elementOpen.click();
                    		}
                    		else if(testDataItem[1].equals("Update"))
                    		{
                    			WebElement elementOpen = Browser.webDriver.findElement(this.getObject("Name_Update_User1", LocatorType)); 
                    			elementOpen.click();
                    		}
                    		else
                    		{
                    			Thread.sleep(20000);
                    		}
                    		
            			}
            		}    			
               		 
            		
        		}
        		else if(LocatorValue.equals("hospitalAddedByAutomation"))
        		{
        			String[] testDataItem = TestData.split("#");
        			String TempActualValue = null;
            		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[4]/div/div/div/div"));
            		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("a"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(int i=1;i<=UsrMgtTblRwCount;i++)
            		{
            			UsrMgtTblRwNo = i;
            			try
            			{
            				TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
            			}
            			catch(Exception e)
            			{
            				
            			}
            			
            			TempActualValue=TempActualValue.trim();
            			System.out.println(TempActualValue);
            			if(TempActualValue.trim().contains((testDataItem[0].trim())))
            			{
            				WebElement webele=Browser.webDriver.findElement(this.getObject(LocatorValue, LocatorType));
            				DivAddedByAuto = webele;
            				System.out.println("DivAddedByAuto   "+DivAddedByAuto.getText());
                    		String webelmnt = webele.getText();
                    		System.out.println("Locatervalue"+LocatorValue);
                    		System.out.println("LocaterType"+LocatorType);
                    		System.out.println(webelmnt);
                    		Actions oAction = new Actions(Browser.webDriver);
                    		oAction.moveToElement(webele);
                    		//To perform right click
                    		oAction.contextClick(webele).build().perform();
                    		//To select menu after right click
                    		if(testDataItem[1].equals("Update"))
                    		{
                    			WebElement elementOpen = Browser.webDriver.findElement(this.getObject("contextMenuAddHospital", LocatorType));
                    			elementOpen.click();
                    		}
                    		else if(testDataItem[1].equals("UpdateLCT"))
                    		{
                    			WebElement elementOpen = Browser.webDriver.findElement(this.getObject("Name_Update_User1", LocatorType)); 
                    			elementOpen.click();
                    		}  
                    		else if(testDataItem[1].equals("Delete"))
                    		{
                    			WebElement elementOpen = Browser.webDriver.findElement(this.getObject("contextMenuDeleteHospital", LocatorType)); 
                    			elementOpen.click();
                    		}                    		
                    		
            			}
            		}    			
               		 
            		
        		}
        		else
        		{
        			//String[] intp=LocatorValue.split("#");
            		//System.out.println(intp[0]+"..............................."+intp[1]);
            	//	WebElement webele=Browser.webDriver.findElement(this.getObject(intp[0], LocatorType));
            		WebElement webele=Browser.webDriver.findElement(this.getObject(LocatorValue, LocatorType));
            		System.out.println("Locatervalue"+LocatorValue);
            		System.out.println("LocaterType"+LocatorType);
            		Actions oAction = new Actions(Browser.webDriver);
            		oAction.moveToElement(webele);
            		//To perform right click
            		oAction.contextClick(webele).build().perform(); 
            		//To select menu after right click
            		WebElement elementOpen = Browser.webDriver.findElement(this.getObject(LocatorValue, LocatorType)); 
            		elementOpen.click();
        		}
        		testStepResult="Pass";
            
            if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
            
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in RtClkOp Action   "+e);
				    testStepResult="Fail";
				    System.out.println("Ashok    Status is   "+testStepResult);
				    ExceptionMessage="Exception in RtClkOp Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    					    	
				    	}
			}
        	return testStepResult;
         //below 

 }
//	 public String   not working for  now. throwing error as org.apache.xmlbeans.impl.values.XmlValueDisconnectedException 
//        () 
// {
//
// }
	 public String   SelectDroDwn() 
 { 
            
        	try
        	{
        		WebElement w1=Browser.webDriver.findElement((this.getObject(LocatorValue, LocatorType)));
        		Select s=new Select(w1);
        		//int Index_Of_TestData=Integer.parseInt(TestData);
        		//s.selectByIndex(Index_Of_TestData);
        		
        		try
        		{		
        		s.selectByValue(TestData);
        		System.out.println("done in first attempt    selectByValue");
        		
        		}// org.openqa.selenium.NoSuchElementException
        		catch(org.openqa.selenium.NoSuchElementException e)
        		{
        			System.out.println("Not done in first attempt    selectByValue  "+e);
        			try
        			{
        			s.selectByVisibleText(TestData);
        			System.out.println("done in second attempt    selectByVisibleText");
        			}
        			
        			catch(org.openqa.selenium.NoSuchElementException e1)
        			{
        				System.out.println("Not done in Second attempt    selectByVisibleText  "+e1);
        				int TestData_converInToInt=Integer.parseInt(TestData);
        				s.selectByIndex(TestData_converInToInt);
        				System.out.println("done in third attempt    selectByIndex");
        			}
        			catch(Exception e1)
        			{
        				System.out.println("Second Inner Try Other than NoSuchElementException     "+e1);
        			}
        		}
        		catch(Exception e)
        		{
        			System.out.println("First Outer Try Other than NoSuchElementException     "+e);
        		}
        		
        		
        			           
        		testStepResult="Pass";
            
            if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
            
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in SelectDroDwn Action   "+e);
				    testStepResult="Fail";
				    System.out.println("Ashok    Status is   "+testStepResult);
				    ExceptionMessage="Exception in SelectDroDwn Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    					    	
				    	}
			}
        	return testStepResult;
        
        

 }
	 public String   setText() 
 {            
        	try
        	{
        		if(TestData.equals("NotificationStartDate"))	
	        	{
	        		LocalDate date =  LocalDate.now();        		
	        	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM-dd-YYYY");
	        	    date =  LocalDate.now();
	        	    AddNewSubscriptionStartDate = date.format(formatters);        	    
	        	    System.out.println("Text format " + AddNewSubscriptionStartDate);
	        	    Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(AddNewSubscriptionStartDate);
		            testStepResult="Pass";
		            
		            AddNewSubscriptionSendTime = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
		            AddNewSubscriptionSendTimeUnit = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
	        	}
	        	else if(TestData.equals("NotificationStopDate"))	
	        	{
	        		LocalDate date =  LocalDate.now();        		
	        	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM-dd-YYYY");
	        	    date =  LocalDate.now().plusDays(3);
	        	    AddNewSubscriptionEndDate = date.format(formatters);        	    
	        	    System.out.println("Text format " + AddNewSubscriptionEndDate);
	        	    Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(AddNewSubscriptionEndDate);
		            testStepResult="Pass";
	        	}
	        	else if(TestData.equals("AddNewSubscriptionStartDate"))	
	        	{
	        		LocalDate date =  LocalDate.now();        		
	        	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM-dd-YYYY");
	        	    date =  LocalDate.now();
	        	    AddNewSubscriptionStartDate = date.format(formatters);        	    
	        	    System.out.println("Text format " + AddNewSubscriptionStartDate);
	        	    Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(AddNewSubscriptionStartDate);
		            testStepResult="Pass";
		            
		            AddNewSubscriptionSendTime = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
		            AddNewSubscriptionSendTimeUnit = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
	        	}
	        	else if(TestData.equals("AddNewSubscriptionEndDate"))	
	        	{//endDateToVerify = null;
	        		//EngineOperations EO = new EngineOperations();
	        		LocalDate date =  LocalDate.now();        		
	        	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM-dd-YYYY");
	        	    date =  LocalDate.now().plusDays(3);
	        	    EngineOperations.endDateToVerify = date;
	        	    //endDateToVerify = date;
	        	    AddNewSubscriptionEndDate = date.format(formatters);     
	        	    VerifyNewSubscriptionEndDate = AddNewSubscriptionEndDate;
	        	    System.out.println("Text format " + AddNewSubscriptionEndDate);
	        	    Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(AddNewSubscriptionEndDate);
		            testStepResult="Pass";
	        	}
	        	else if(TestData.equals("UpdateNewSubscriptionEndDate"))	
	        	{//endDateToVerify = null;
	        		//EngineOperations EO = new EngineOperations();
	        		LocalDate date =  LocalDate.now();        		
	        	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM-dd-YYYY");
	        	    date =  LocalDate.now().plusDays(6);
	        	    //endDateToVerify = date;
	        	    EngineOperations.endDateToVerify = date;
	        	    AddNewSubscriptionEndDate = date.format(formatters);        	    
	        	    System.out.println("Text format " + AddNewSubscriptionEndDate);
	        	    Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(AddNewSubscriptionEndDate);
		            testStepResult="Pass";
	        	}
	        	else if(TestData.equals("SubscriptionTimeHours"))	
	        	{
	        	    AddNewSubscriptionSendTime = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
	        	    testStepResult="Pass";
	        	}
	        	else if(TestData.equals("SubscriptionTimeUnit"))	
	        	{
	        	    
		            AddNewSubscriptionSendTimeUnit = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
		            testStepResult="Pass";
	        	}
	        	else
	        	{
		            Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(TestData);
		            testStepResult="Pass";
	        	}        	
	            if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}   
	            
        	}
			catch(Exception e)
			{
				System.out.println("Exception in setText Action   "+e);
				testStepResult="Fail";
				System.out.println("Ashok    Status is   "+testStepResult);
				ExceptionMessage="Exception in setText Action   "+e.getMessage().toString();
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
				if(TestCasePriority.equalsIgnoreCase("P1"))
				{
				   	TestCasePriorityRep=true;
				   	Browser.webDriver.close();
				}
			}
        	return testStepResult;
        

 }
	 public String   clearElementText() 
 {            
        	try
        	{        	
		            Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).clear();
		            testStepResult="Pass";
	        	        	
	            if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				} 
	            
        	}
			catch(Exception e)
			{
				System.out.println("Exception in setText Action   "+e);
				testStepResult="Fail";
				System.out.println("Ashok    Status is   "+testStepResult);
				ExceptionMessage="Exception in setText Action   "+e.getMessage().toString();
				if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
				if(TestCasePriority.equalsIgnoreCase("P1"))
				{
				   	TestCasePriorityRep=true;
				   	Browser.webDriver.close();
				}
			}
        	return testStepResult;
        

 }
	 public String   setTextParameter() 
 { 
            
        	try
        	{
	            Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(prop.getProperty(TestData));
	            testStepResult="Pass";
            
            
            
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in setText Action   "+e);
				    testStepResult="Fail";
				    //System.out.println("Ashok    Status is   "+testStepResult);
				    ExceptionMessage="Exception in setText Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    					    	
				    	}
			}
        	return testStepResult;
        

 }
	 public String   executesqlquery() throws ClassNotFoundException, IOException, SQLException 
	 { 
		String user=prop.getProperty("dbUserName");
		String password=prop.getProperty("dbpassword");
		String database=prop.getProperty("databaseName");
		String Servername=prop.getProperty("ServerName");
		Connection con=MylptDbConnection(user,password,Servername,database);
   		try
   		{
                String [] data=TestData.split("#");
                String dml_action=data[0];
     			String table_name=data[1];
    			String column_name=data[2];
     			String Condition_Name=data[3];
     			String test_data=data[3];
    			System.out.println("dml name1"+table_name);
    			System.out.println("dml name2"+column_name);
    			System.out.println("dml name4"+Condition_Name);
    			System.out.println("dml name6"+dml_action);
    			if(dml_action.equalsIgnoreCase("UPDATE"))
    			{
    				String query;
    				System.out.println("i am in ServerName11");
    				String str2="update $tablename set $keyvalue where $condition";
    				str2 =str2.replace("$tablename",table_name);
                    str2=str2.replace("$keyvalue",column_name); 
                    if(Condition_Name.contains("$"))
                    {
                    	String [] conditions = Condition_Name.split("$");
                    	Condition_Name = Condition_Name.replace("$", currentTenantName);
                    	query=str2.replace("$condition",Condition_Name);
                    }
                    else
                    {
                    	query=str2.replace("$condition",Condition_Name);
                    }
                    if(query.contains("reportnotifications"))
                    {
                    	 LocalDate startDate =  LocalDate.now();        		
                    	 DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    	 startDate =  LocalDate.now().minusDays(2);
                    	 String StartDate = startDate.format(formatters);        	    
                    	 query=query.replace("@SD@",StartDate+" 00:00:00.000");
                    	 System.out.println(query);
                    	 LocalTime currentTime =  LocalTime.now();        		
                    	 DateTimeFormatter Timeformatters = DateTimeFormatter.ofPattern("HH:MM:SS.SSSSSSS");
                    	 currentTime =  LocalTime.now().plusMinutes(13);
                    	 String CurrentTime = currentTime.toString();   
                    	 CurrentTime = CurrentTime.substring(0, CurrentTime.length() - 9);
                    	 query=query.replace("@SRT@",CurrentTime+"0000000");
                    	 System.out.println(query);
                         LocalDate nextRecurrenceDate =  LocalDate.now();        		
                         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             	         String NextRecurrenceDate = nextRecurrenceDate.format(formatter);        	    
                	     query=query.replace("@NRD@",NextRecurrenceDate+" 00:00:00.000");
                         System.out.println(query);
                    }
                    PreparedStatement stmt=con.prepareStatement(query);
    				System.out.println("Query"+query);
    				System.out.println("stmt_Object "+stmt);
    				System.out.println("Query"+query);
        			System.out.println("yes");
        			stmt.executeUpdate();
        			System.out.println("yes");
        			testStepResult="Pass";
    			}
    			else if(dml_action.equalsIgnoreCase("INSERT"))
    			{
    				String str2="insert into $tablename $keyvalue values $testdata";
    				PreparedStatement stmt=con.prepareStatement(str2);
    				System.out.println("Query"+table_name);
    				System.out.println("Query1"+test_data);
    				System.out.println("Query2"+column_name);
    				System.out.println("Query3"+str2);
    				str2 =str2.replace("$tablename",table_name);
                    str2=str2.replace("$keyvalue",column_name); 
                    String query=str2.replace("$testdata",Condition_Name);
                    System.out.println("Query443"+query);
    				stmt.executeUpdate();
        			testStepResult="Pass";
    			}
    			else if(dml_action.equalsIgnoreCase("DELETE"))
    			{
    				System.out.println("i am in ServerName12");
    				String str2="delete from $tablename where $condition";
    				System.out.println("i am in ServerName12");
    				str2 =str2.replace("$tablename",table_name);
    				System.out.println(table_name);
    				System.out.println(column_name);
                    String query=str2.replace("$condition",column_name); 
                    System.out.println("Query1"+query);
    			    if(query.contains("$"))
                    {
    			    	String tenantname=prop.getProperty("Tenant");
                    	query = query.replace("$", tenantname);
                    	System.out.println(query);
                    }
    				PreparedStatement stmt=con.prepareStatement(query);
    				System.out.println("i am in ServerName12"+query);
    				stmt.executeUpdate();
        			testStepResult="Pass";
    			}
    			else if(dml_action.equalsIgnoreCase("CREATE"))
    			{
    				System.out.println("i am in ServerName12");
    				String str2="CREATE Table $tablename ($keyvalue)";
    				System.out.println("i am in ServerName12");
    				str2 =str2.replace("$tablename",table_name);
    				System.out.println("i am in ServerName12");
    				String query=str2.replace("$keyvalue",column_name); 
                   	PreparedStatement stmt=con.prepareStatement(query);
    				System.out.println("i am in ServerName12"+query);
    				stmt.executeUpdate();
        			testStepResult="Pass";
    			}
    			else 
    			System.out.println("Invalid Action!!!!!");
    		}
    		catch(NullPointerException e)
            {
    			System.out.println("Patient is not correct  or deleted");
    			testStepResult="Fail";
            }
    		catch(Exception e)
   			{
			    System.out.println("Exception in setText Action   "+e);
			    testStepResult="Fail";
			    System.out.println("Ashok    Status is   "+testStepResult);
			    ExceptionMessage="Exception in setText Action   "+e.getMessage().toString();
			    if(Screenshot.equalsIgnoreCase("Y"))
			    {
			    	screnshotcls obj=new screnshotcls(Browser.webDriver);
			    }
			    if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();					    	
		    	}
    		}
			return testStepResult;
	 }
	 
	 public String   getText() 
 { 
           
        	try
        	{
            String ActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
            System.out.println("Value is \n" + ActualValue);
            testStepResult="Pass";
            if(Screenshot.equalsIgnoreCase("Y")) 
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in getText Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in getText Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        	return testStepResult;
            
        

 }
public String   getcolor() 
 { 
	try
    { 
       String ActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getCssValue("color");
       AutoAssert.Assert(ActualValue,TestData); 
       System.out.println("Pass");
        		
       System.out.println(ActualValue);
       testStepResult="Pass";
       if(Screenshot.equalsIgnoreCase("Y"))
       {
    	   screnshotcls obj=new screnshotcls(Browser.webDriver);
       }
    }
	catch(Exception e)
	{
				    System.out.println("Exception in getText Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in getText Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
	}
    return testStepResult;
}
	 public String   test() 
 { 
        	System.out.println(Browser.webDriver.findElement(By.xpath(".//*[@id='ctl00_cpb_gridCallbackPanel_gridFilterData_DXDataRow0']/td[8]")).getAttribute("style"));
        	return testStepResult;
        	
        

 }
	 public String   verifyResult() 
	 { 
        String ActualValue1 = null;
        try
        {
	        if(TestData=="confirmed")
	        {
	        	String id=getID();
	        	System.out.println(id);
	        	
	        	ActualValue1=Browser.webDriver.findElement(By.xpath(id)).getAttribute("style");
	        	System.out.println("AcutlaValue"+ActualValue1);
	        }   
	        else
	        {
        	if(LocatorValue.equals("Select_Tenant"))
        	{
        		ActualValue1 = "Tenant dropdown";
        	}
        	else if(LocatorValue.equals("Edit_Name"))
        	{
        		String TempActualValue = null;
        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainView\"]/div[2]/div[4]/table/tbody"));
        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRolesList.size();
        		System.out.println("Total number of Subscriptions = "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			if(UsrMgtTblRwCount == 1)
        			{
        				TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        				System.out.println("Subscription to verify = "+ TempActualValue);
        			}
        			else
        			{
        				TempActualValue=Browser.webDriver.findElement(this.getObject("multipleSubscriptionAdded",LocatorType)).getText();
        				System.out.println("Subscription to verify = "+ TempActualValue);
        			}
        			
        			if(TempActualValue.contains((TestData)))
        			{
        				
        				break;
        			}
        		}
        		ActualValue1 = TempActualValue;
        	}
        	else if(LocatorValue.equals("ViewNextRecurrenceDate"))
        	{
        		String actualNRD = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        	    LocalDate date =  LocalDate.now();
        	    AddNewSubscriptionStartDate = date.format(formatters);
        		String expectedNDR = AddNewSubscriptionStartDate;
        		ActualValue1 = actualNRD;
				TestData = expectedNDR;
				System.out.println("Acutla NextRecurrenceDate = "+ActualValue1);
				System.out.println("Acutla NextRecurrenceDate = "+TestData);
        	}
        	else if(LocatorValue.equals("Principal_Name"))
        	{
        		boolean isNewUserLinkDisabled = false;
    		 	WebElement NewUserLink = Browser.webDriver.findElement(By.xpath("//*[@id=\"UserPrincipalName\"]"));
    		 	String UPN = NewUserLink.getText();
    		 	boolean isUPN = !NewUserLink.isEnabled();
    		 	if(!isUPN)
    		 	{
    		 		isNewUserLinkDisabled = true;
    		 	}
    		 	if(isNewUserLinkDisabled)
        		{
        			ActualValue1 = "True";
					TestData = "True";
        		}
        	}
        	else if(LocatorValue.equals("ChkNewUserLinkDisabled"))
        	{
        		boolean isNewUserLinkDisabled = false;
    		 	WebElement NewUserLink = Browser.webDriver.findElement(this.getObject("New_User_Link",LocatorType));
    		 	if(!NewUserLink.isEnabled())
    		 	{
    		 		isNewUserLinkDisabled = true;
    		 	}
    		 	if(isNewUserLinkDisabled)
        		{
        			ActualValue1 = "True";
					TestData = "True";
        		}
        	}
        	else if(LocatorValue.equals("ChkNewUserLinkEnabled"))
        	{
        		boolean isNewUserLinkEnabled = false;
    		 	WebElement NewUserLink = Browser.webDriver.findElement(this.getObject("New_User_Link",LocatorType));
    		 	if(NewUserLink.isEnabled())
    		 	{
    		 		isNewUserLinkEnabled = true;
    		 	}
    		 	if(isNewUserLinkEnabled)
        		{
        			ActualValue1 = "True";
					TestData = "True";
        		}
        	}
        	else if(LocatorValue.equals("ChkPrivillegeAssignedOrNot"))
    		{
        		boolean isPrivillegeAssignedOrNot = false;
    			String [] privilegeDetails= TestData.split("#") ;
        		WebElement TogetRows = Browser.webDriver.findElement(this.getObject("MainPrivilegeType",LocatorType));
        		System.out.println(TogetRows.getText()); 
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.xpath("//div[@class='accordion-toggle headtab ng-scope']"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(WebElement CPG  : TotalRowsList)
        		{
        			System.out.println(CPG.getText());  
        			if(CPG.getText().equals(privilegeDetails[0]))
        			{
        				List<WebElement>TotalspanList = CPG.findElements(By.xpath("//div[@class='child_tab1 ng-scope']"));
                		int spanCount = TotalspanList.size();
                		System.out.println("Total number of Rows in the table are   "+ spanCount);
                		for(WebElement CP  : TotalspanList)
                		{
                			System.out.println(CP.getText());
                			System.out.println(privilegeDetails[1]);
                			if(CP.getText().equals(privilegeDetails[1]))
                			{
                				WebElement privilegeChkBox = CP.findElement(By.tagName("input"));
                				System.out.println(privilegeChkBox.isSelected());
                				if(privilegeChkBox.isSelected())
                        		{                    					
                					isPrivillegeAssignedOrNot = true;
                        			break;
                        		}
                        		else
                        		{                            			
                        			isPrivillegeAssignedOrNot = false;	
                            		break;
                        		}
                			}
                		}
        			}
        			if(isPrivillegeAssignedOrNot)
            		{                    					
    					//isPrivillegeAssignedOrNot = true;
            			break;
            		}
        		}
        		if(isPrivillegeAssignedOrNot)
        		{
        			ActualValue1 = "True";
					TestData = "True";
        		}
    		}
        	else if(LocatorValue.equals("verifyAssignedTenantsonlyThere"))
        	{
        		String testDataDetails[] = TestData.split("#");
    		 	boolean isAssignedTenantsonlyThere = false;
    		 	WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"ddltenant\"]"));
    		 	List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("option"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(WebElement opt :  TotalRowsList)
        		{
        			System.out.println(testDataDetails[0]);
        			System.out.println(testDataDetails[1]);
        			String tenantName = opt.getText();
        			System.out.println(tenantName);
        			if(tenantName.equals(testDataDetails[0]) || tenantName.equals(testDataDetails[1]))
        			{		
        				isAssignedTenantsonlyThere = true;       					
    					
        			} 	
        		}
        		
        		if(isAssignedTenantsonlyThere)
        		{
        			ActualValue1 = "True";
					TestData = "True";
        		}
        	}
        	else if(LocatorValue.equals("verifyDataFromInactiveGrid"))
        	{
        		String testDataDetails[] = TestData.split("#");
        		String inactiveATUserName = null, inactiveATUserMailID = null, inactiveATUserUsertype = null, inactiveATUserLastLoginDate = null, inactiveATUserDuration = null, inactiveATUserStatus = null;
    		 	boolean isDataCorrectInInactiveUserGrid = false;
    		 	WebElement TogetRows = Browser.webDriver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[6]/table/tbody"));
    		 	List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);        		
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;        			
        			inactiveATUserName = Browser.webDriver.findElement(this.getObject("inactiveATUserName",LocatorType)).getText();
        			inactiveATUserMailID = Browser.webDriver.findElement(this.getObject("inactiveATUserMailID",LocatorType)).getText();
        			inactiveATUserUsertype = Browser.webDriver.findElement(this.getObject("inactiveATUserUsertype",LocatorType)).getText();
        			inactiveATUserLastLoginDate = Browser.webDriver.findElement(this.getObject("inactiveATUserLastLoginDate",LocatorType)).getText();
        			inactiveATUserDuration = Browser.webDriver.findElement(this.getObject("inactiveATUserDuration",LocatorType)).getText();
        			inactiveATUserStatus = Browser.webDriver.findElement(this.getObject("inactiveATUserStatus",LocatorType)).getText();
        				System.out.println(inactiveATUserName);	
        				System.out.println(testDataDetails[0]);	
        				System.out.println(inactiveATUserMailID);
        				System.out.println(testDataDetails[1]);	
        				System.out.println(inactiveATUserUsertype);
        				System.out.println(testDataDetails[2]);	
        				System.out.println(inactiveATUserLastLoginDate);
        				System.out.println(testDataDetails[3]);	
        				System.out.println(inactiveATUserDuration);
        				System.out.println(testDataDetails[4]);	
        				System.out.println(inactiveATUserStatus);
        				System.out.println(testDataDetails[5]);	
	        			if(inactiveATUserName.equals(testDataDetails[0]) && inactiveATUserMailID.equals(testDataDetails[1]) && inactiveATUserUsertype.equals(testDataDetails[2]) && inactiveATUserLastLoginDate.equals(testDataDetails[3]) && inactiveATUserDuration.equals(testDataDetails[4]) && inactiveATUserStatus.equals(testDataDetails[5]))
	        			{		
	        				isDataCorrectInInactiveUserGrid = true;       					
        					
	        			} 	
        		}
        		if(isDataCorrectInInactiveUserGrid)
        		{
        			ActualValue1 = "True";
					TestData = "True";
        		}
        	}
        	else if(LocatorValue.equals("Verify_User_Ex"))
        	{
        		try		
        		{
        			if(!Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).isDisplayed())
            		{
            			ActualValue1 = "True";
    					TestData = "True";					
            		}
        		}
        		catch(Exception e)
        		{
        			System.out.println("Eg. Label Not Displaying under UPN Field   Exception occured");     
        			ActualValue1 = "True";
					TestData = "True";
        		}
        		
        	}
        	else if(LocatorValue.equals("ListOfInactiveUsers"))
        	{
        		String InactiveUserStatus = null;
    		 	boolean isInactiveNblockedUsersExists = false;
    		 	WebElement TogetRows = Browser.webDriver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[6]/table/tbody"));
    		 	List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);        		
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;        			
        				InactiveUserStatus = Browser.webDriver.findElement(this.getObject("BlockedUserStatusFromMultiple",LocatorType)).getText();        				
        				System.out.println(InactiveUserStatus);	 
        				if(!InactiveUserStatus.equals(""))
        				{
        					if(InactiveUserStatus.equals("Unblocked") || InactiveUserStatus.equals("Blocked"))
    	        			{		
    	        				isInactiveNblockedUsersExists = true;      					
    	        			} 	    	        			
        				}
        				else
	        			{
        					InactiveUserStatus = Browser.webDriver.findElement(this.getObject("BlockedUserStatusFromMultiple2",LocatorType)).getText();        				
            				System.out.println(InactiveUserStatus);	 
            				if(InactiveUserStatus.equals("Unblocked") || InactiveUserStatus.equals("Blocked"))
    	        			{		
    	        				isInactiveNblockedUsersExists = true;      					
    	        			}
	        			}
        		}
        		if(isInactiveNblockedUsersExists)
        		{
        			ActualValue1 = "True";
					TestData = "True";
        		}
        	}
        	else if(LocatorValue.equals("ListOfBlockedUsers"))
        	{
        		String InactiveUserStatus = null;
    		 	boolean isInactiveNblockedUsersExists = false;
    		 	WebElement TogetRows = Browser.webDriver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[6]/table/tbody"));
    		 	List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);        		
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;        			
        				InactiveUserStatus = Browser.webDriver.findElement(this.getObject("BlockedUserStatusFromMultiple",LocatorType)).getText();        				
        				System.out.println(InactiveUserStatus);	        			
	        			if(InactiveUserStatus.equals("Blocked"))
	        			{		
	        				isInactiveNblockedUsersExists = true;       					
        					
	        			} 	
        		}
        		if(isInactiveNblockedUsersExists)
        		{
        			ActualValue1 = "True";
					TestData = "True";
        		}
        	}
        	else if(LocatorValue.equals("RefreshNoteOfUserMgt"))
        	{
        		if(Browser.webDriver.findElement(this.getObject("usermngtRefreshNote",LocatorType)).isDisplayed())
        		{
        			ActualValue1 = "True";
					TestData = "True";					
        		}
        	}
        	else if(LocatorValue.equals("RefreshNoteOfDataMgt"))
        	{
        		if(Browser.webDriver.findElement(this.getObject("datamngtRefreshNote",LocatorType)).isDisplayed())
        		{
        			ActualValue1 = "True";
					TestData = "True";					
        		}
        	}
        	else if(LocatorValue.equals("ContentPackVersionDetails"))
        	{
        		String ReleaseVersion = Browser.webDriver.findElement(By.xpath("//*[@id=\"modal-body\"]/div[1]/div[2]/label")).getText();
        		String DataMartVersion = Browser.webDriver.findElement(By.xpath("//*[@id=\"modal-body\"]/div[2]/div[2]/label")).getText();
        		String ContentPackVersion = Browser.webDriver.findElement(By.xpath("//*[@id=\"modal-body\"]/div[3]/div[2]/label")).getText();
        		String [] ContentPackDetails = TestData.split("#");    		
        		if(ReleaseVersion.equals(ContentPackDetails[0]) && DataMartVersion.equals(ContentPackDetails[1]) && ContentPackVersion.equals(ContentPackDetails[2]))
        		{
        			ActualValue1 = "True";
					TestData = "True";
					Browser.webDriver.findElement(this.getObject("CPversionDetailsCloseBtn",LocatorType)).click();
        		}
        	}
        	else if(LocatorValue.equals("ContentPackReleaseVersion"))
			{
				String contentpackGroupname = null, contentpackName = null;
				String [] ContentPackDetails = TestData.split("#");
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[2]/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			contentpackGroupname=Browser.webDriver.findElement(this.getObject("ContentPackGroupName",LocatorType)).getText();
        			contentpackName=Browser.webDriver.findElement(this.getObject("ContentPackName",LocatorType)).getText();
        			String a = ContentPackDetails[0];
        			String b = ContentPackDetails[1];
        			String c = ContentPackDetails[2];
        			if(contentpackGroupname.equals(ContentPackDetails[0]) && contentpackName.equals(ContentPackDetails[1]))
        			{        				
        				if(Browser.webDriver.findElement(this.getObject("modelContentReleaseVersionHeader",LocatorType)).isDisplayed()) 
        				{
	        				String ActualCPVersion = Browser.webDriver.findElement(this.getObject("model_content_pack_version",LocatorType)).getText();
	        				if(ActualCPVersion.equals(ContentPackDetails[2]))
	        				{
	        					ActualValue1 = "True";
	    						TestData = "True";
	        					break;
	        				}
        				}
        			}
        		}
			}
        	else if(LocatorValue.equals("CPVersionInfo"))
			{
				String TempActualValue = null;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[5]/div/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject("ContentpackPublishedByAutomation",LocatorType)).getText();
        			System.out.println("Username   "+ TempActualValue);
        			if(TempActualValue.equals((TestData)))
        			{
        				System.out.println("Username   "+ TempActualValue);
        				
        				WebElement CPReleaseVersion = Browser.webDriver.findElement(this.getObject("CPReleaseVersion",LocatorType));
        				
        				if(CPReleaseVersion.isDisplayed())
        				{
        					if(CPReleaseVersion.getText().equals("1.0.0"))
        					{
        						ActualValue1 = "True";
        						TestData = "True";
        						//testStepResult="Pass";   				
                				
                				break;
        					}
        				}

        				
        			}
        		}
			}
        	else if(LocatorValue.equals("CPInfo"))
			{
				String TempActualValue = null;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[2]/div/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject("ContentpackPublishedByAutomation",LocatorType)).getText();
        			System.out.println("Username   "+ TempActualValue);
        			if(TempActualValue.equals((TestData)))
        			{
        				System.out.println("Username   "+ TempActualValue);
        				WebElement downloadCPIcon = Browser.webDriver.findElement(this.getObject("downloadCP",LocatorType));
        				WebElement uploadCPIcon = Browser.webDriver.findElement(this.getObject("uploadCP",LocatorType));
        				WebElement editCPIcon = Browser.webDriver.findElement(this.getObject("editContentpackPublishedByAutomation",LocatorType));
        				WebElement deleteCPIcon = Browser.webDriver.findElement(this.getObject("deleteContentpackPublishedByAutomation",LocatorType));
        				WebElement CPReleaseVersion = Browser.webDriver.findElement(this.getObject("CPReleaseVersion",LocatorType));
        				WebElement CPType = Browser.webDriver.findElement(this.getObject("CPType",LocatorType));
        				if(downloadCPIcon.isDisplayed() && uploadCPIcon.isDisplayed() && editCPIcon.isDisplayed() && deleteCPIcon.isDisplayed() && CPReleaseVersion.isDisplayed() && CPType.isDisplayed())
        				{
        					if(CPReleaseVersion.getText().equals("") && CPType.getText().equals("Custom"))
        					{
        						ActualValue1 = "True";
        						TestData = "True";
        						//testStepResult="Pass";   				
                				
                				break;
        					}
        				}

        				
        			}
        		}
			}
        	else if(LocatorValue.equals("PipelineScheduleFrequencySetToDaily"))
        	{
        		String TempActualValue1 = null;
        		boolean ispipelineGroupCreatedAndAssigned = false;
        		
        			TempActualValue1=Browser.webDriver.findElement(this.getObject("PipelineScheduleFrequencySetToDaily",LocatorType)).getText();
        			System.out.println(TestData);
        			System.out.println(TempActualValue1);
        			if(TestData.equals(TempActualValue1))
        			{        				
        				
        				ispipelineGroupCreatedAndAssigned = true;
            				//break;
        				
        				
        			}
        		
        		if(ispipelineGroupCreatedAndAssigned)
        		{
        			TempActualValue1 = "True"; 
            		
        		}
        		ActualValue1 = TempActualValue1; 
        		TestData = "True";
        	}
        	else if(LocatorValue.equals("pipelineGroupCreatedAndAssigned"))
        	{
        		String TempActualValue1 = null;
        		boolean ispipelineGroupCreatedAndAssigned = false;
        		
        			TempActualValue1=Browser.webDriver.findElement(this.getObject("PipelinegroupNameOnGrid",LocatorType)).getText();
        			System.out.println(TestData);
        			System.out.println(TempActualValue1);
        			if(TestData.equals(TempActualValue1))
        			{        				
        				
        				ispipelineGroupCreatedAndAssigned = true;
            				//break;
        				
        				
        			}
        		
        		if(ispipelineGroupCreatedAndAssigned)
        		{
        			TempActualValue1 = "True"; 
            		
        		}
        		ActualValue1 = TempActualValue1; 
        		TestData = "True";
        	}
        	else if(LocatorValue.equals("SupportDocumentationTabOpened"))
        	{
        		Set<String> handles=Browser.webDriver.getWindowHandles();
        		System.out.println(handles.size()); 
        		if(handles.size() > 1)
        		{
        			ActualValue1 = "True";
        		}
        	}
        	else if(LocatorValue.equals("verifyPrivilegesInCustomGroup"))
        	{
        		String [] testDataDetails = TestData.split("#");
        		boolean isPrivilegeUnchecked = false;
        		if(LocatorValue.equals(testDataDetails[0]))
        		{
        			//String [] privilegeDetails= TestData.split("#") ;
            		WebElement TogetRows = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
            		System.out.println(TogetRows.getText()); 
            		List<WebElement>TotalRowsList = TogetRows.findElements(By.xpath("//div[@class='accordion-toggle headtab ng-scope']"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(WebElement CPG :  TotalRowsList)
            		{
            			System.out.println(CPG.getText());  
            			if(CPG.getText().equals(testDataDetails[1]))
            			{
            				List<WebElement>TotalspanList = CPG.findElements(By.xpath("//div[@class='child_tab1 ng-scope']"));
                    		int spanCount = TotalspanList.size();
                    		System.out.println("Total number of Rows in the table are   "+ spanCount);
                    		for(WebElement CP :  TotalspanList)
                    		{
                    			System.out.println(CP.getText());
                    			System.out.println(testDataDetails[2]);
                    			if(CP.getText().equals(testDataDetails[2]))
                    			{
                    				WebElement privilegeChkBox = CP.findElement(By.tagName("input"));
                    				System.out.println(privilegeChkBox.isSelected());
                    				if(privilegeChkBox.isSelected())
                            		{                    					
                    					isPrivilegeUnchecked = true;
                            			break;
                            		}
                            		else
                            		{                            			
                            			isPrivilegeUnchecked = false;
                            			break;
                            		}
                    			}
                    		}
            			}
            		}
        		}
        		if(!isPrivilegeUnchecked)
        		{
        			ActualValue1 = "True"; 
	        		TestData = "True";
        		}
        	}
        	else if(LocatorValue.equals("HVATimeOutMessage"))
        	{
        		 	String TempActualValue = null,TempExpectedValue = null;
        		 	boolean isTimeOutMessageDisplayed = false;
        			TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			TempExpectedValue = TestData;
        			System.out.println(TempActualValue);
        			System.out.println(TempExpectedValue);
        			if(TempActualValue.equals(TempExpectedValue))
        			{       				
        				isTimeOutMessageDisplayed = true;
            			//break;#Revisite
        			}
        		
	        		if(isTimeOutMessageDisplayed)
	        		{
	        			TempActualValue = "True"; 	            		
	        		}
	        		ActualValue1 = TempActualValue; 
	        		TestData = "True";
        	}
        	else if(LocatorValue.equals("BlockedInactiveUser"))
        	{
        		 	String TempActualValue = null,InactiveUserName = null,InactiveUserStatus = null;
        		 	boolean isInactiveUserBlocked = false;
        		 	WebElement TogetRows = Browser.webDriver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[6]/table/tbody"));
        		 	List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		
            		if(UsrMgtTblRwCount==1)
            		{
            			TempActualValue=Browser.webDriver.findElement(this.getObject("BlockedUserStatus",LocatorType)).getText();
            			System.out.println(TempActualValue);
            			System.out.println(TestData);
            			if(TempActualValue.equals(TestData))
            			{            				
            				isInactiveUserBlocked = true;
                			//break;#Revisite           				
            			}     	        		
            		}
            		else
            		{
            			String []testDataDetails = TestData.split("#");
            			for(int i=1;i<=UsrMgtTblRwCount;i++)
		        		{
		        			UsrMgtTblRwNo = i;
		        			InactiveUserName=Browser.webDriver.findElement(this.getObject("InactiveUserName",LocatorType)).getText();
		        			System.out.println(InactiveUserName);
		        			System.out.println(testDataDetails[0]);
		        			if(InactiveUserName.contains((testDataDetails[0])))
		        			{		        				
		        				InactiveUserStatus = Browser.webDriver.findElement(this.getObject("BlockedUserStatusFromMultiple",LocatorType)).getText();
		        				
		        				System.out.println(InactiveUserStatus);
			        			System.out.println(testDataDetails[1]);
			        			if(InactiveUserStatus.equals((testDataDetails[1])))
			        			{		
			        				try
			        				{
			        					if(inactiveUserStatus.equals(testDataDetails[1]))
			        					{
			        						isInactiveUserBlocked = true;
				        					break;
			        					}
			        				}
			        				catch(Exception ex)
			        				{
			        					isInactiveUserBlocked = true;
			        					break;
			        				}
		        					
		        					
			        			}
		        				
		        			}
		        		}	
            		}
            		
            		if(isInactiveUserBlocked)
	        		{
	        			TempActualValue = "True"; 
	            		
	        		}
	        		ActualValue1 = TempActualValue; 
	        		
	        		TestData = "True";
        			
        	}
        	else if(LocatorValue.equals("UnBlockedBlockedUser"))
        	{
        		String TempActualValue = null, TempActualValue1 = null;
        		boolean isDatabaseUserAdded = false;
        		String [] testdataDetails = TestData.split("#");
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[3]/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject("userAddedByAutomation",LocatorType)).getText();
        			System.out.println(testdataDetails[0]);
        			System.out.println(TempActualValue);
        			if(TempActualValue.contains((testdataDetails[0])))
        			{        				
        				TempActualValue1 = Browser.webDriver.findElement(this.getObject("UserStatus",LocatorType)).getText();
        				System.out.println(TempActualValue1);        				
            			System.out.println(testdataDetails[1]);
            			if(TempActualValue1.contains((testdataDetails[1])))
            			{
            				isDatabaseUserAdded = true;
            				break;
        				}
        				
        			}
        		}
        		if(isDatabaseUserAdded)
        		{
        			TempActualValue1 = "True"; 
            		
        		}
        		ActualValue1 = TempActualValue1; 
        		TestData = "True";
        	}
        	else if(LocatorValue.equals("dbUserAddedByAutomation"))
        	{
        		String TempActualValue = null, TempActualValue1 = null;
        		boolean isDatabaseUserAdded = false;
        		String [] testdataDetails = TestData.split("#");
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[3]/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject("userAddedByAutomation",LocatorType)).getText();
        			System.out.println(testdataDetails[0]);
        			System.out.println(TempActualValue);
        			if(TempActualValue.contains((testdataDetails[0])))
        			{        				
        				TempActualValue1 = Browser.webDriver.findElement(this.getObject("isDatabaseUser",LocatorType)).getText();
        				System.out.println(TempActualValue1);        				
            			System.out.println(testdataDetails[1]);
            			if(TempActualValue1.contains((testdataDetails[1])))
            			{
            				isDatabaseUserAdded = true;
            				break;
        				}
        				
        			}
        		}
        		if(isDatabaseUserAdded)
        		{
        			TempActualValue1 = "True"; 
            		
        		}
        		ActualValue1 = TempActualValue1; 
        		TestData = "True";
        	}
        	else if(LocatorValue.equals("NewTopicAdded"))
        	{
        		boolean isNewTopicAdded = false;
        		String TempActualValue1 = null, TempActualValue2 = null, TempActualValue3 = null, TempActualValue4 = null;
        		String [] TestDataDetails = TestData.split("#");
        		WebElement NewTopicName = Browser.webDriver.findElement(this.getObject("NewTopicName",LocatorType));
        		WebElement NewTopicDisplayName = Browser.webDriver.findElement(this.getObject("NewTopicDisplayName",LocatorType));
        		WebElement NewTopicDescription = Browser.webDriver.findElement(this.getObject("NewTopicDescription",LocatorType));
        		
        		TempActualValue1=NewTopicName.getText();
        		TempActualValue2=NewTopicDisplayName.getText();
        		TempActualValue3=NewTopicDescription.getText();
        			
        		System.out.println(TempActualValue1);
        		System.out.println(TempActualValue2);
        		System.out.println(TempActualValue3);
       			System.out.println(TestDataDetails[0]);
       			System.out.println(TestDataDetails[1]);
        			if(TempActualValue1.equals(TestDataDetails[0])  &&  TempActualValue2.equals(TestDataDetails[0]) && TempActualValue3.equals(TestDataDetails[0]))
        			{
        				
        				isNewTopicAdded = true;
        				
        			}
        			else
        			{
        				isNewTopicAdded = false;
        			}
        		
         		if(isNewTopicAdded)
        		{
         			TempActualValue4 = "True";
        		}  
        		ActualValue1 = TempActualValue4; 
        		TestData = TestDataDetails[1];
        	}
        	else if(LocatorValue.equals("NotificationPopupOnCustomerLogin"))
        	{
        		boolean NotificationPopupOnCustomerLoginExist = false;
        		String TempActualValue1 = null, TempActualValue2 = null, TempActualValue3 = null, TempActualValue4 = null;
        		String [] TestDataDetails = TestData.split("#");
        		WebElement TogetRoles = Browser.webDriver.findElement(this.getObject("NotificationPopup",LocatorType));
        		WebElement TotalRolesList1 = TogetRoles.findElement(By.tagName("h4"));
        		WebElement TotalRolesList2 = TogetRoles.findElement(By.tagName("p"));
        		
        			TempActualValue1=TogetRoles.getText();
        			TempActualValue2=TotalRolesList1.getText();
        			TempActualValue3=TotalRolesList2.getText();
        			
        			System.out.println(TempActualValue1);
        			System.out.println(TempActualValue2);
        			System.out.println(TempActualValue3);
        			System.out.println(TestDataDetails[0]);
        			System.out.println(TestDataDetails[1]);
        			if(TogetRoles.isDisplayed() && TempActualValue2.equals(TestDataDetails[0]) && TempActualValue3.equals(TestDataDetails[0]))
        			{
        				
        				NotificationPopupOnCustomerLoginExist = true;
        				
        			}
        			else
        			{
        				NotificationPopupOnCustomerLoginExist = false;
        			}
        		
         		if(NotificationPopupOnCustomerLoginExist)
        		{
         			TempActualValue4 = "True";
        		}  
        		ActualValue1 = TempActualValue4; 
        		TestData = TestDataDetails[1];
        	}
        	else if(LocatorValue.equals("NewNotificationWithAllTenantAdded"))
        	{
        		String notificationName = null, notificationTenant = null, TempActualValue = null;
        		boolean notificationExist = false;
        		String [] testDataDetails = TestData.split("#");
        		
        		notificationName=Browser.webDriver.findElement(this.getObject("Notification",LocatorType)).getText();
        		notificationTenant=Browser.webDriver.findElement(this.getObject("NotificationTenant",LocatorType)).getText();
        			
        		System.out.println(notificationName);
        		System.out.println(testDataDetails[0]);
        		System.out.println(notificationTenant);
        		System.out.println(testDataDetails[1]);
        			
        		if(notificationName.equals(testDataDetails[0]) && notificationTenant.equals(testDataDetails[1]))
        		{
        			notificationExist = true; 
        		}
        		else
        		{
        			notificationExist = false; 
        		}
        		
        		if(notificationExist)
        		{
        			TempActualValue = "True";
        		}
        		else
        		{
        			TempActualValue = "False";
        		}
        		ActualValue1 = TempActualValue;
        		TestData = testDataDetails[2];
        		System.out.println("Username   "+ ActualValue1);
        	}
        	else if(LocatorValue.equals("ACCPCISTSAdultRegistryControlTablesAdded"))
        	{
        		boolean ACCPCIRegistryControlTablesExist = false,STAdultRegistryControlTablesExist = false;
        		String TempActualValue = null;
        		String [] TestDataDetails = TestData.split("#");
        		WebElement TogetRoles = Browser.webDriver.findElement(this.getObject("SelectModule",LocatorType));
        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("option"));
        		UsrMgtTblRwCount = TotalRolesList.size();
        		System.out.println("Total number of Roles in the list are   "+ UsrMgtTblRwCount);
        		for(WebElement moduleOptions :  TotalRolesList)
        		{
        			//UsrMgtTblRwNo = i;
        			TempActualValue=moduleOptions.getText();
        			System.out.println(TempActualValue);
        			System.out.println(TestDataDetails[0]);
        			System.out.println(TestDataDetails[1]);
        			if(TempActualValue.equals(TestDataDetails[0]) || TempActualValue.equals(TestDataDetails[1]))
        			{
        				if(TempActualValue.equals("ACC PCI Registry Control Tables"))
        				{
        					ACCPCIRegistryControlTablesExist = true;
        				}
        				else if(TempActualValue.equals("STS Adult Registry Control Tables"))
        				{
        					STAdultRegistryControlTablesExist = true;
        				}
        			}
        		}
        		if(ACCPCIRegistryControlTablesExist && STAdultRegistryControlTablesExist)
        		{
        			TempActualValue = "True";
        		}  
        		ActualValue1 = TempActualValue; 
        		TestData = TestDataDetails[2];
        	}
        	else if(LocatorValue.equals("NewSiteApproverName"))
        	{
        		String TempActualValue = null, fullUsername = null;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[3]/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			System.out.println(TempActualValue);
        			System.out.println(TestData);
        			if(TempActualValue.contains((TestData)))
        			{
        				break;
        			}
        		}
	            ActualValue1 = TempActualValue; 		
	        	System.out.println("Username   "+ ActualValue1);
        	}
        	else if(LocatorValue.equals("ageValueShouldAppearAsPerAssignedOrder"))
			{
				String TempActualValue = null;
				boolean isOrderAssigned = false;
				String [] testDataDetails = TestData.split("#");
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"ddlSection\"]"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("option"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(WebElement ageValue :  TotalRowsList)
        		{
        			TempActualValue=ageValue.getText();
            		if(TempActualValue.equals((testDataDetails[0])))
        			{
            			ageValue.click();
            			WebElement orderTextBox = Browser.webDriver.findElement(By.xpath("//*[@id=\"txtSortOrder\"]"));
            			
            			//orderTextBox.click();
            			String Order = orderTextBox.getAttribute("value");
            			if(Order.equals((testDataDetails[1])))
            			{
            				isOrderAssigned = true;
            				break;
            			}    				
        			}
        		}
        		
        		if(isOrderAssigned)
        		{
        			ActualValue1 = "Pass";
        			TestData = testDataDetails[2];
        		}
        		else
        		{
        			ActualValue1 = "Fail";
        			TestData = "Fail";
        		}
        	}
        	else if(LocatorValue.equals("userToResendResetPassword"))
        	{
        		String TempActualValue = null;
        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"modal-body\"]/div/table/tbody"));
        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRolesList.size();
        		System.out.println("Total number of Roles in the list are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			if(TempActualValue.contains((TestData)))
        			{
        				
        				break;
        			}
        		}
        		String [] UserDetails = TempActualValue.split("@");
            	ActualValue1 = UserDetails[0];
            	System.out.println("Username   "+ ActualValue1);
        		//ActualValue1 = TempActualValue;
        	}
        	else if(LocatorValue.equals("configuredDataSourcesToHospital"))
        	{
        		String TempActualValue = null;
        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"HospitalDataSourceSettings\"]/tbody"));
        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRolesList.size();
        		System.out.println("Total number of Roles in the list are   "+ UsrMgtTblRwCount);
        		if(UsrMgtTblRwCount == 1) 
        		{
        			TempActualValue=Browser.webDriver.findElement(this.getObject("configuredDataSourceType",LocatorType)).getText();
        		}   
        		ActualValue1 = TempActualValue;
        	}
        	else if(LocatorValue.equals("checkContentpackMovedToNewGroupInPCPPage"))
        	{
        		int counter = 0;
        		String TempActualValue = null, fullUsername = null;
        		String [] testdataDetails = TestData.split("#");
        		int CPGroupCount;
        		boolean CPGroupUpdated = false;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[2]/div/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(WebElement CPG  : TotalRowsList)
        		{
        			counter++;
        			List<WebElement>CPGroup = CPG.findElements(By.tagName("td"));
        			CPGroupCount = CPGroup.size();
        			System.out.println("No.Of td's in current tr   "+ CPGroupCount);
        			if(CPGroupCount == 10)
        			{
        				String grpname = CPG.getText();
        				if(grpname.equals(testdataDetails[0])) 
        				{
        					for(int i = counter;i<=UsrMgtTblRwCount;i++)
        					{
        						UsrMgtTblRwNo = i;
        						TempActualValue=Browser.webDriver.findElement(this.getObject("ContentpackPublishedByAutomation",LocatorType)).getText();
        	        			if(TempActualValue.contains(testdataDetails[1]))
        	        			{
        	        				CPGroupUpdated = true;
        	        				break; 
        	        			}
        					}
        				}
        			}
        			
        		}
        		if(CPGroupUpdated)
        		{
        			ActualValue1 = "True";
        			TestData = testdataDetails[2];
        		}
        		else
        		{
        			ActualValue1 = "False";
        		}
        	
        	}
        	else if(LocatorValue.equals("checkContentpackCopiedToNewGroupInPCPPage"))
        	{
        		int counter = 0;
        		String TempActualValue = null, fullUsername = null;
        		String [] testdataDetails = TestData.split("#");
        		int CPGroupCount;
        		boolean CPGroupUpdated = false;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[5]/div/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(WebElement CPG  : TotalRowsList)
        		{
        			counter++;
        			List<WebElement>CPGroup = CPG.findElements(By.tagName("td"));
        			CPGroupCount = CPGroup.size();
        			System.out.println("No.Of td's in current tr   "+ CPGroupCount);
        			if(CPGroupCount == 10)
        			{
        				String grpname = CPG.getText();
        				System.out.println(grpname);
        				System.out.println(testdataDetails[0]);
        				if(grpname.equals(testdataDetails[0])) 
        				{
        					for(int i = counter;i<=UsrMgtTblRwCount;i++)
        					{
        						UsrMgtTblRwNo = i;
        						TempActualValue=Browser.webDriver.findElement(this.getObject("ContentpackPublishedByAutomation",LocatorType)).getText();
        	        			if(TempActualValue.contains(testdataDetails[1]))
        	        			{
        	        				CPGroupUpdated = true;
        	        				break; 
        	        			}
        					}
        				}
        			}
        			
        		}
        		if(CPGroupUpdated)
        		{
        			ActualValue1 = "True";
        			TestData = testdataDetails[2];
        		}
        		else
        		{
        			ActualValue1 = "False";
        		}
        	
        	}
        	else if(LocatorValue.equals("checkContentpackMovedToNewGroup"))
			{
        		boolean ismovedToNewGroup = false;
				String contentpackGroupname = null, contentpackName = null;
				String [] ContentPackDetails = TestData.split("#");
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[2]/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			contentpackGroupname=Browser.webDriver.findElement(this.getObject("ContentPackGroupName",LocatorType)).getText();
        			contentpackName=Browser.webDriver.findElement(this.getObject("ContentPackName",LocatorType)).getText();
        			String a = ContentPackDetails[0];
        			String b = ContentPackDetails[1];
        			if(contentpackName.equals(ContentPackDetails[0]) && contentpackGroupname.equals(ContentPackDetails[1]))
        			{
        				ismovedToNewGroup = true;	        					
        				break;
        			}
        		}
        		if(ismovedToNewGroup)
        		{
        			ActualValue1 = "True";
        			TestData = ContentPackDetails[2];
        		}
        		else
        		{
        			ActualValue1 = "False";
        		}
			}
        	else if(LocatorValue.equals("automationUserPrivilegeGroup"))
        	{
        		String TempActualValue = null;
        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"SelectedRoles\"]"));
        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("option"));
        		UsrMgtTblRwCount = TotalRolesList.size();
        		System.out.println("Total number of Roles in the list are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			if(TempActualValue.contains((TestData)))
        			{
        				
        				break;
        			}
        		}
        		ActualValue1 = TempActualValue;
        	}
        	else if(LocatorValue.equals("subscriptionAdded"))
        	{
        		String TempActualValue = null;
        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainView\"]/div[2]/div[4]/table/tbody"));
        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRolesList.size();
        		System.out.println("Total number of Subscriptions = "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			if(UsrMgtTblRwCount == 1)
        			{
        				TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        				System.out.println("Subscription to verify = "+ TempActualValue);
        			}
        			else
        			{
        				TempActualValue=Browser.webDriver.findElement(this.getObject("multipleSubscriptionAdded",LocatorType)).getText();
        				System.out.println("Subscription to verify = "+ TempActualValue);
        			}
        			
        			if(TempActualValue.contains((TestData)))
        			{
        				
        				break;
        			}
        		}
        		ActualValue1 = TempActualValue;
        	}
        	else if(LocatorValue.equals("SubscriptionReportFormate"))
        	{
        		String TempActualValue = null;
        		String [] testdata = TestData.split("#");
        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainView\"]/div[2]/div[4]/table/tbody"));
        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRolesList.size();
        		System.out.println("Total number of Subscriptions = "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			if(UsrMgtTblRwCount == 1)
        			{
        				TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        				System.out.println("Actual report type = "+ TempActualValue);
        			}
        			else
        			{
        				TempActualValue=Browser.webDriver.findElement(this.getObject("multipleSubscriptionAdded",LocatorType)).getText();
        				System.out.println("Subscription name = "+ TempActualValue);
        			
        			
	        			if(TempActualValue.contains((testdata[0])))
	        			{
	        				TempActualValue=Browser.webDriver.findElement(this.getObject("MultipleSubscriptionReportFormate",LocatorType)).getText();
	        				System.out.println("Actual report type = "+ TempActualValue);
	        				
	        					break;
	        						
	        				
	        			}
	        			}
        		}
        		ActualValue1 = TempActualValue;
        		TestData = testdata[1];
        		System.out.println("Expected report type = "+ TestData);
        	}
        	else if(LocatorValue.equals("SubscriptionUpdatedBy"))
			{
				String TempActualValue = null;
				String [] testdata = null;
				try
				{
					testdata = TestData.split("#");
				}
				catch(Exception ex)
				{
					
				}
				
        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainView\"]/div[2]/div[4]/table/tbody"));
        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRolesList.size();
        		System.out.println("Total number of Subscriptions = "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			if(UsrMgtTblRwCount == 1)
        			{
        				TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        					if(Screenshot.equalsIgnoreCase("Y"))
	        				{
	        					screnshotcls obj=new screnshotcls(Browser.webDriver);
	        				}
	        				System.out.println("Actual Subscription UpdatedBy = "+TempActualValue);
	        				System.out.println("Expected Subscription UpdatedBy = "+testdata[1]);
	        				ActualValue1 = TempActualValue;
	                		TestData = testdata[1];
	                		testStepResult="Pass";
        			}
        			else
        			{
        				TempActualValue=Browser.webDriver.findElement(this.getObject("multipleSubscriptionAdded",LocatorType)).getText();
        				if(TempActualValue.contains(testdata[0]))
	        			{
        					System.out.println("Subscription name = "+TempActualValue);
        					TempActualValue=Browser.webDriver.findElement(this.getObject("MultipleSubscriptionUpdatedBy",LocatorType)).getText();
	        				testStepResult="Pass";			        				
	        				if(Screenshot.equalsIgnoreCase("Y"))
	        				{
	        					screnshotcls obj=new screnshotcls(Browser.webDriver);
	        				}
	        				ActualValue1 = TempActualValue;
	        				TestData = testdata[1];
	        				break;
	        			}
        				System.out.println("Actual Subscription UpdatedBy = "+TempActualValue);
        				System.out.println("Expected Subscription UpdatedBy = "+testdata[1]);
        				
                		
        			}		        			
        		}
			}
        	else if(LocatorValue.equals("checkRLSpropertyforCopiedContentPack"))
        	{
        		String [] RLSpropetiesbeforcopy = RLSbeforcopy.split(",");
        		String [] RLSpropetiesaftercopy = RLSaftercopy.split(",");
        		String actvalue1 = null,actvalue2 = null;
        		for(String RLSB :  RLSpropetiesbeforcopy)
        		{
        			if(RLSB.contains("RLS"))
        			{ 
        				String [] propertyValue = RLSB.split(" ");
        				actvalue1 = propertyValue[1];
        				
        				break;
        			}
        		}
        		for(String RLSA  : RLSpropetiesaftercopy)
        		{
        			if(RLSA.contains("RLS"))
        			{ 
        				String [] propertyValue = RLSA.split(" ");
        				actvalue2 = propertyValue[1];
        				break;
        			}
        		}
        		if(actvalue1.equals(actvalue2))
        		{
        			ActualValue1 = "True";
        		}
        		else
        		{
        			ActualValue1 = "False";
        		}        		
        	}
        	else if(LocatorValue.equals("Edit_User_Icon"))
        	{
        		String TempActualValue = null;
        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[3]/table/tbody"));
        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.xpath("//img[@src='images/edit.png']"));
        		UsrMgtTblRwCount = TotalRolesList.size();
        		System.out.println("Total number of Roles in the list are   "+ UsrMgtTblRwCount);
        		
        			if(UsrMgtTblRwCount>0)
        			{
        				
        				ActualValue1 = "true";
        			}
        			else
        			{
        				ActualValue1 = "false";
        			}
        		
        	}
        	else if(LocatorValue.equals("subscriptionToEmailValidationMsg"))
        	{
        		
        		String TempActualValue = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        		ActualValue1 = TempActualValue;
        		System.out.println(ActualValue1);
        	System.out.println("Username   "+ ActualValue1);
        	}
        	else if(LocatorValue.equals("checkLeftSideMenu"))
        	{
        		boolean isSiteManagementTabExist = false, isContentManagementTabExist = false;
        		String TempActualValue = null, fullUsername = null;
        		WebElement siteManagementList = Browser.webDriver.findElement(By.xpath("//*[@id=\"siteMgmtLinks\"]/ul"));
        		WebElement contentManagementList = Browser.webDriver.findElement(By.xpath("//*[@id=\"contentMgmt\"]/ul"));
        		List<WebElement>siteManagementListItems = siteManagementList.findElements(By.tagName("li"));
        		List<WebElement>contentManagementListItems = contentManagementList.findElements(By.tagName("li"));
        		int siteManagementListItemsCount = siteManagementListItems.size();
        		int contentManagementListItemsCount = contentManagementListItems.size();
        		int siteManagementListCount = siteMagtList.size();
        		int contentManagementListCount = contentMgtList.size();
        		int i=0,j=0;
        		System.out.println("siteManagementListItemsCount   "+ siteManagementListItemsCount);
        		System.out.println("contentManagementListItemsCount   "+ contentManagementListItemsCount);
        		if(siteManagementListItemsCount == siteManagementListCount)
    			{
        			for (WebElement siteManagementItem :  siteManagementListItems) 
            		{        			
            			System.out.println(siteManagementItem.getText());
            			
            			        			
                			System.out.println(siteMagtList.get(i));
                			
                			if(siteManagementItem.getText().equals(siteMagtList.get(i)))
                			{
                				isSiteManagementTabExist = true;
                			}
                			else
                			{
                				isSiteManagementTabExist = false;
                				break;
                			}
                			i++;
    				} 
    			}        		 
        		System.out.println("@@"); 
        		if(contentManagementListItemsCount == contentManagementListCount)
        		{
        			for (WebElement contentManagementItem :  contentManagementListItems) 
            		{        			
            			System.out.println(contentManagementItem.getText());
            			
            			        			
                			System.out.println(contentMgtList.get(j));
                			
                			if(contentManagementItem.getText().equals(contentMgtList.get(j)))
                			{
                				isContentManagementTabExist = true;
                			}
                			else
                			{
                				isContentManagementTabExist = false;
                				break;
                			}
                			j++;
    				}
        		}
        		if(isSiteManagementTabExist && isContentManagementTabExist)
        		{
        			ActualValue1 = "TabExists";
        		}
        		else
        		{
        			ActualValue1 = "TabNotExists";
        		}
        		
        	siteMagtList.clear();
        	contentMgtList.clear();
        	}
        	else if(LocatorValue.equals("verifyLinkReplacedWithIcon"))
        	{
        		String TempActualValue = null, fullUsername = null;
        		boolean iconsExistsInTenantManagementGrid = false,editIconExistsInTenantManagementGrid = false,deleteIconExistsInTenantManagementGrid = false;
        		boolean iconsExistsInUserManagementGrid = false,editIconExistsInUserManagementGrid = false,deleteIconExistsInUserManagementGrid = false,resetpswrdIconExistsInUserManagementGrid = false,lockIconExistsInUserManagementGrid=false;
        		boolean iconsExistsInGroupContentManagementGrid = false,editIconExistsInGroupContentManagementGrid = false;
        		boolean iconsExistsInPublishContentPackGrid = false, refreshIconExistsInPublishContentPackGrid = false, downloadIconExistsInPublishContentPackGrid = false, uploadIconExistsInPublishContentPackGrid = false, deleteIconExistsInPublishContentPackGrid = false, editIconExistsInPublishContentPackGrid = false;
        		boolean iconsExistsInModelContentManagementGrid = false,downloadIconExistsInModelContentManagementGrid = false, copyIconExistsInModelContentManagementGrid = false, movetoIconExistsInModelContentManagementGrid = false, releasenoteIconExistsInModelContentManagementGrid =false;
        		if(TestData.equals("TenantManagementGrid"))
        		{
        			WebElement tenantManagementGrid = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div/div/table/tbody"));
            		List<WebElement>TotalRowsList = tenantManagementGrid.findElements(By.tagName("tr"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(WebElement row  : TotalRowsList)
            		{
            			List<WebElement>TotalIcons = row.findElements(By.tagName("img"));
            			for(WebElement Icon  : TotalIcons)
                		{
            				String tenantManagementGridIcon = Icon.getAttribute("src");
                			System.out.println(tenantManagementGridIcon);
                			if(tenantManagementGridIcon.contains("edit.png") || tenantManagementGridIcon.contains("delete.png"))
                			{
                				if(tenantManagementGridIcon.contains("edit.png"))
                				{
                					editIconExistsInTenantManagementGrid = true;
                				}
                				else if(tenantManagementGridIcon.contains("delete.png"))
                				{
                					deleteIconExistsInTenantManagementGrid = true;
                				}
                			}
                		}
            			break;
            		}
            		if(editIconExistsInTenantManagementGrid && deleteIconExistsInTenantManagementGrid)
            		{
            			iconsExistsInTenantManagementGrid = true;
            		}
        		}
        		else if(TestData.equals("UserManagementGrid"))
        		{
        			WebElement UserManagementGrid = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[3]/table/tbody"));
            		List<WebElement>TotalRowsList = UserManagementGrid.findElements(By.tagName("tr"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(WebElement row :  TotalRowsList)
            		{
            			List<WebElement>TotalIcons = row.findElements(By.tagName("img"));
            			for(WebElement Icon  : TotalIcons)
                		{
            				String UserManagementGridIcon = Icon.getAttribute("src");
                			System.out.println(UserManagementGridIcon);
                			if(UserManagementGridIcon.contains("edit.png") || UserManagementGridIcon.contains("delete.png") || UserManagementGridIcon.contains("resetpswrd.png"))
                			{
                				if(UserManagementGridIcon.contains("edit.png"))
                				{
                					editIconExistsInUserManagementGrid = true;
                				}
                				else if(UserManagementGridIcon.contains("delete.png"))
                				{
                					deleteIconExistsInUserManagementGrid = true;
                				}
                				else if(UserManagementGridIcon.contains("resetpswrd.png"))
                				{
                					resetpswrdIconExistsInUserManagementGrid = true;
                				}
                				else if(UserManagementGridIcon.contains("lock.png"))
                				{
                					lockIconExistsInUserManagementGrid = true;
                				}
                			}
                		}
            			break;
            		}
            		if(editIconExistsInUserManagementGrid && deleteIconExistsInUserManagementGrid && resetpswrdIconExistsInUserManagementGrid)
            		{
            			iconsExistsInUserManagementGrid = true;
            		}
        		}
        		else if(TestData.equals("GroupContentManagementGrid"))
        		{
        			WebElement GroupContentManagementGrid = Browser.webDriver.findElement(By.xpath("//*[@id=\"SectionManagement\"]/div/table/tbody"));
            		List<WebElement>TotalRowsList = GroupContentManagementGrid.findElements(By.tagName("tr"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(WebElement row  : TotalRowsList)
            		{
            			List<WebElement>TotalIcons = row.findElements(By.tagName("img"));
            			for(WebElement Icon  : TotalIcons)
                		{
            				String GroupContentManagementGridIcon = Icon.getAttribute("src");
                			System.out.println(GroupContentManagementGridIcon);
                			if(GroupContentManagementGridIcon.contains("edit.png"))
                			{
                				if(GroupContentManagementGridIcon.contains("edit.png"))
                				{
                					editIconExistsInGroupContentManagementGrid = true;
                				}                				
                			}
                		}
            			break;
            		}
            		if(editIconExistsInGroupContentManagementGrid)
            		{
            			iconsExistsInGroupContentManagementGrid = true;
            		}
        		}
        		else if(TestData.equals("PublishContentPackGrid"))
        		{
        			int CPGroupCount;	        			        		
	        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[2]/div/table/tbody"));
	        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
	        		UsrMgtTblRwCount = TotalRowsList.size();
	        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
	        		for(WebElement CPG  : TotalRowsList)
	        		{
	        			List<WebElement>CPGroup = CPG.findElements(By.tagName("td"));
	        			CPGroupCount = CPGroup.size();
	        			System.out.println("No.Of td's in current tr   "+ CPGroupCount);
	        			if(CPGroupCount == 13)
	        			{
	        				List<WebElement>TotalIcons = CPG.findElements(By.tagName("img"));
	        				for(WebElement Icon  : TotalIcons)
	                		{
	            				String PublishContentPackGridIcon = Icon.getAttribute("src");
	                			System.out.println(PublishContentPackGridIcon);
	                			if(PublishContentPackGridIcon.contains("refresh.png") || PublishContentPackGridIcon.contains("download.png") || PublishContentPackGridIcon.contains("upload.png") || PublishContentPackGridIcon.contains("delete.png") || PublishContentPackGridIcon.contains("edit.png"))
	                			{
	                				if(PublishContentPackGridIcon.contains("refresh.png"))
	                				{
	                					refreshIconExistsInPublishContentPackGrid = true;
	                				}
	                				else if(PublishContentPackGridIcon.contains("download.png"))
	                				{
	                					downloadIconExistsInPublishContentPackGrid = true;
	                				} 
	                				else if( PublishContentPackGridIcon.contains("upload.png"))
	                				{
	                					uploadIconExistsInPublishContentPackGrid = true;
	                				} 
	                				else if(PublishContentPackGridIcon.contains("delete.png"))
	                				{
	                					deleteIconExistsInPublishContentPackGrid = true;
	                				} 
	                				else if(PublishContentPackGridIcon.contains("edit.png"))
	                				{
	                					editIconExistsInPublishContentPackGrid = true;
	                				} 
	                			}
	                		}
	        				break;
	        			}
	        			
	        		}
	        		if(refreshIconExistsInPublishContentPackGrid && downloadIconExistsInPublishContentPackGrid && uploadIconExistsInPublishContentPackGrid && deleteIconExistsInPublishContentPackGrid && editIconExistsInPublishContentPackGrid)
	        		{
	        			iconsExistsInPublishContentPackGrid = true;
	        		}
        		}
        		else if(TestData.equals("ModelContentManagementGrid"))
        		{
        			
        			WebElement ModelContentManagementGrid = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[2]/table/tbody"));
            		List<WebElement>TotalRowsList = ModelContentManagementGrid.findElements(By.tagName("tr"));
            		UsrMgtTblRwCount = TotalRowsList.size();
            		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
            		for(WebElement row  : TotalRowsList)
            		{
            			List<WebElement>TotalIcons = row.findElements(By.tagName("img"));
            			for(WebElement Icon :  TotalIcons)
                		{
            				String ModelContentManagementGridIcon = Icon.getAttribute("src");
                			System.out.println(ModelContentManagementGridIcon);
                			if(ModelContentManagementGridIcon.contains("download.png") || ModelContentManagementGridIcon.contains("copy.png") || ModelContentManagementGridIcon.contains("moveto.png") || ModelContentManagementGridIcon.contains("releasenote.png"))
                			{
                				if(ModelContentManagementGridIcon.contains("download.png"))
                				{
                					downloadIconExistsInModelContentManagementGrid = true;
                				}
                				else if(ModelContentManagementGridIcon.contains("copy.png"))
                				{
                					copyIconExistsInModelContentManagementGrid = true;
                				}
                				else if(ModelContentManagementGridIcon.contains("moveto.png"))
                				{
                					movetoIconExistsInModelContentManagementGrid = true;
                				}
                				else if(ModelContentManagementGridIcon.contains("releasenote.png"))
                				{
                					releasenoteIconExistsInModelContentManagementGrid = true;
                				}
                			}
                		}
            			break;
            		}
            		if(downloadIconExistsInModelContentManagementGrid && copyIconExistsInModelContentManagementGrid && movetoIconExistsInModelContentManagementGrid && releasenoteIconExistsInModelContentManagementGrid)
            		{
            			iconsExistsInModelContentManagementGrid = true;
            		}
        		}
        		
        		if(iconsExistsInTenantManagementGrid || iconsExistsInUserManagementGrid || iconsExistsInGroupContentManagementGrid || iconsExistsInPublishContentPackGrid || iconsExistsInModelContentManagementGrid)
        		{
        			ActualValue1 = "True";
        			TestData = "True";
        		}
        		
        	}
        	else if(LocatorValue.equals("userAddedByAutomation"))
        	{
        		String TempActualValue = null, fullUsername = null;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[3]/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			if(TestData.contains("verifyUserWithAdditionalDomain"))
                	{
        				if(TestData.contains((TempActualValue)))
            			{
            				fullUsername = TempActualValue; 
            			}
                	}
        			else
        			{
        				if(TempActualValue.contains((TestData)))
            			{
            				fullUsername = TempActualValue; 
            			}
        			}
        			
        		}
        		//ActualValue1 = TempActualValue; 		
        	String [] UserDetails = fullUsername.split("@");
        	String [] testDataDetails = TestData.split("@");
        	ActualValue1 = UserDetails[0];
        	if(TestData.contains("verifyUserWithAdditionalDomain"))
        	{
        		TestData = testDataDetails[0];
        	}
        	System.out.println("Username   "+ ActualValue1);
        	}
        	else if(LocatorValue.equals("ContentpackPublishedByAutomation"))
        	{
        		String TempActualValue = null, fullUsername = null;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[5]/div/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			if(TempActualValue.equals((TestData)))
        			{
        				fullUsername = TempActualValue; 
        				break;
        			}
        		}
        		//ActualValue1 = TempActualValue; 		
        	//String [] UserDetails = fullUsername;
        	ActualValue1 = fullUsername;
        	System.out.println("Username   "+ ActualValue1);
        	}
        	else if(LocatorValue.equals("tenantAddedByAutomation"))
        	{
        		String TempActualValue = null, fullUsername = null;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div/div/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			if(TempActualValue.contains((TestData)))
        			{
        				fullUsername = TempActualValue; 
        			}
        		}
        		//ActualValue1 = TempActualValue; 		
        	String [] UserDetails = fullUsername.split("@");
        	ActualValue1 = UserDetails[0];
        	System.out.println("Username   "+ ActualValue1);
        	}
        	else if(LocatorValue.equals("roleToUserAddedByAutomation"))
        	{
        		String [] testInputs = TestData.split("#");
        		String TempActualValue, TempActualValue1= null;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[3]/table/tbody"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject("userAddedByAutomation",LocatorType)).getText();
        			if(TempActualValue.contains((testInputs[0])))
        			{
        				System.out.println("Username   "+ TempActualValue);
        				TempActualValue1=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        				if(TempActualValue1.equals((testInputs[1])))
            			{
        					TestData = testInputs[1];
        					break;
            			}
        			}
        		}
        		ActualValue1 = TempActualValue1;
        	}
        	else if(LocatorValue.equals("divisionAddedByAutomation"))
        	{
        		String TempActualValue = null;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[4]/div/div/div/div"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("a"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			TempActualValue=TempActualValue.trim();
        			System.out.println(TempActualValue);
        			System.out.println(TestData);
        			if(TempActualValue.trim().contains((TestData.trim())))
        			{
        				ActualValue1 = TempActualValue; 
        			}
        		}
        		ActualValue1 = TempActualValue; 		
        	//String [] UserDetails = TempActualValue.split("@");
        	//ActualValue1 = UserDetails[0];
        	System.out.println("Username   "+ ActualValue1);
        	}
        	else if(LocatorValue.equals("hospitalAddedByAutomation"))
        	{
        		String TempActualValue = null;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[4]/div/div/div/div"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("a"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			try
        			{
        				TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			}
        			catch(Exception e)
        			{
        				
        			}
        			
        			TempActualValue=TempActualValue.trim();
        			System.out.println(TempActualValue);
        			if(TempActualValue.trim().contains((TestData.trim())))
        			{
        				ActualValue1 = TempActualValue; 
        			}
        		}
        		ActualValue1 = TempActualValue; 		
        	//String [] UserDetails = TempActualValue.split("@");
        	//ActualValue1 = UserDetails[0];
        	System.out.println("Username   "+ ActualValue1);
        	}
        	else if(LocatorValue.equals("hospitalLocationAddedByAutomation"))
        	{
        		String TempActualValue = null;
        		WebElement TogetRows = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainVeiw\"]/div/div[2]/div[4]/div/div/div/div"));
        		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("a"));
        		UsrMgtTblRwCount = TotalRowsList.size();
        		System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			try
        			{
        				TempActualValue=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			}
        			catch(Exception e)
        			{
        				
        			}
        			
        			TempActualValue=TempActualValue.trim();
        			System.out.println(TempActualValue);
        			if(TempActualValue.trim().contains((TestData.trim())))
        			{
        				ActualValue1 = TempActualValue; 
        			}
        		}
        		ActualValue1 = TempActualValue; 		
        	//String [] UserDetails = TempActualValue.split("@");
        	//ActualValue1 = UserDetails[0];
        	System.out.println("Username   "+ ActualValue1);
        	}
        	else if(LocatorValue.equals("Enable_Browser"))
        	{
        		ActualValue1 = "Enable Browser Restrictions";
        	}
        	else if(LocatorValue.equals("BrowserDetailsGrid"))
        	{
        		ActualValue1 = "Supported Browser List";
        	}
        	else if(LocatorValue.equals("CheckExactVersionHeader"))
        	{
        		ActualValue1 = "Check Exact Version";
        	}
        	else if(LocatorValue.equals("AllowAccessHeader"))
        	{
        		ActualValue1 = "Allow Access";
        	}
        	else if(LocatorValue.equals("SaveBrowserDetailsBtn"))
        	{
        		ActualValue1 = "Save Browser Details Button";
        	}
        	else if(LocatorValue.equals("SelectModule"))
        	{
        		ActualValue1 = "Module dropdown";
        	}
        	else if(LocatorValue.equals("DataManageHeader"))
        	{
        		ActualValue1 = "Manage";
        	}
        	else if(LocatorValue.equals("DataEditHeader"))
        	{
        		ActualValue1 = "Edit";
        	}
        	else if(LocatorValue.equals("DataRowsCountHeader"))
        	{
        		ActualValue1 = "Rows Count";
        	}
        	else if(LocatorValue.equals("DataControlTableDisplayNameHeader"))
        	{
        		ActualValue1 = "Control Table Display Name";
        	}
        	else if(LocatorValue.equals("DataControlTableNameHeader"))
        	{
        		ActualValue1 = "Control Table Name";
        	}
        	else if(LocatorValue.equals("DataModuleControlTable"))
        	{
        		ActualValue1 = "Control Table";
        	}
        	//else if(LocatorValue.equals("User_Type"))
        	//{
        		//if(isUserTypeDropDownVisible)
        		//{
        			//ActualValue1 = "Visible";
        		//}
        		//else
        		//{
        			//ActualValue1 = "Invisible";
        		//}
        		//isUserTypeDropDownVisible = false;
        	//}
        	else if(LocatorValue.equals("NewSubscriptionStartDate"))
        	{
        		TestData = AddNewSubscriptionStartDate;
        		System.out.println("TestData   "+TestData);
        		String ActualValue = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        		String [] ActualValueSplit = ActualValue.split(" : ");
        		ActualValue1 = ActualValueSplit[1];
        		System.out.println("Raw ActualValue   "+ActualValue1);
        		
        		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        	    SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
        	    String ds2 = sdf2.format(sdf1.parse(ActualValue1));
        	    ActualValue1 = ds2;
        	    System.out.println("ActualValue   "+ActualValue1); //will be 30/06/2007
        	}
        	else if(LocatorValue.equals("NewSubscriptionEndDate"))
        	{
        		 //ed = new EngineOperations();
        		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        		
       	 String StartDate = EngineOperations.endDateToVerify.format(formatters);        	    
       	 
       	TestData = StartDate;
//        		LocalDate date =  LocalDate.now();        		
//    	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    	    date =  LocalDate.now().plusDays(3);
//    	    AddNewSubscriptionEndDate = date.format(formatters);
    	    
        		
        		System.out.println("TestData   "+TestData);
        		String ActualValue = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        		String [] ActualValueSplit = ActualValue.split(" : ");
        		ActualValue1 = ActualValueSplit[1];
        		System.out.println("Raw ActualValue   "+ActualValue1);
        		
//        		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        	    SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
//        	    String ds2 = sdf2.format(sdf1.parse(ActualValue1));
//        	    ActualValue1 = ds2;
        		System.out.println("TestData   "+TestData); //will be 30/06/2007
        	    System.out.println("ActualValue   "+ActualValue1); //will be 30/06/2007
        	}
        	else if(LocatorValue.equals("SubscriptionUpdatedDate"))
        	{
        		
          	    //*****************************************************************//
        	    String TempActualValue = null;
				String testdata = null;
				
				LocalDate currentDate =  LocalDate.now();        		
        	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        	    testdata = EngineOperations.endDateToVerify.format(dateFormatter);
        		
        		WebElement TogetRoles = Browser.webDriver.findElement(By.xpath("//*[@id=\"mainView\"]/div[2]/div[4]/table/tbody"));
        		List<WebElement>TotalRolesList = TogetRoles.findElements(By.tagName("tr"));
        		UsrMgtTblRwCount = TotalRolesList.size();
        		System.out.println("Total number of Subscriptions = "+ UsrMgtTblRwCount);
        		for(int i=1;i<=UsrMgtTblRwCount;i++)
        		{
        			UsrMgtTblRwNo = i;
        			if(UsrMgtTblRwCount == 1)
        			{
        				String ActualValue = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
            		String [] ActualValueSplit = ActualValue.split("T");
            		ActualValue1 = ActualValueSplit[0];
            		//System.out.println("Raw ActualValue   "+ActualValue1);
            		
            		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            	    SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
            	    String ds2 = sdf1.format(sdf1.parse(ActualValue1));
            	    ActualValue1 = ds2;
            	    TestData = testdata;
            	    //System.out.println("ActualValue   "+ActualValue1); //will be 30/06/2007
            	    
        				
	        				System.out.println("Actual SubscriptionUpdatedDate = "+ActualValue1);
	        				System.out.println("Expected SubscriptionUpdatedDate = "+TestData);
	        				
	                		
        			}
        			else
        			{
        				TempActualValue=Browser.webDriver.findElement(this.getObject("multipleSubscriptionAdded",LocatorType)).getText();
        				if(TempActualValue.contains(TestData))
	        			{
        					//System.out.println("Subscription name = "+TempActualValue);
        					TempActualValue=Browser.webDriver.findElement(this.getObject("MultipleSubscriptionUpdatedDate",LocatorType)).getText();
        					String [] ActualValueSplit = TempActualValue.split("T");
                    		ActualValue1 = ActualValueSplit[0];
	        				testStepResult="Pass";			        				
	        				if(Screenshot.equalsIgnoreCase("Y"))
	        				{
	        					screnshotcls obj=new screnshotcls(Browser.webDriver);
	        				}
	        				
	                		TestData = testdata;
	        				break;
	        			}
        				System.out.println("Actual SubscriptionUpdatedDate = "+TempActualValue);
        				System.out.println("Expected SubscriptionUpdatedDate = "+testdata);
        				
        			}		        			
        		}
        	    
        	}
        	else
        	{
        		if(LocatorValue.equals("NewSubscriptionTimeZone") || LocatorValue.equals("NewSubscriptionFrequency") || LocatorValue.equals("NewSubscriptionSendTime") || LocatorValue.equals("NewSubscriptionDay"))
        		{
        			ActualValue1=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			String [] ActualValueSplit = ActualValue1.split(" : ");
            		ActualValue1 = ActualValueSplit[1];
            		System.out.println("Raw ActualValue   "+ActualValue1);
        		}
        		else if(LocatorValue.equals("persona_type"))
        		{WebElement temp = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
				//Select fruits = new Select(Browser.webDriver.findElement(By.id("fruits")));
				//dd=temp;
				Select s = new Select(temp);
				WebElement option= s.getFirstSelectedOption();
				s.selectByValue(TestData);
				 ActualValue1 = option.getText();
				 
//				Select select = new Select(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)));
//					 WebElement option = select.getFirstSelectedOption();
//					 ActualValue1 = option.getText();
//					 System.out.println("Persona Type ActualValue1   " + ActualValue1);
        		}
        		else if(LocatorValue.equals("Select_UsrMgtNewUserDomainName"))
        		{
        			 Select select = new Select(Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)));
					 WebElement option = select.getFirstSelectedOption();
					 ActualValue1 = option.getText();
					 System.out.println("UserDomainName   " + ActualValue1);
        		}
        		else
        		{
        			ActualValue1=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        			
        			
        		}
            //ActualValue1=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH mm ss.SSS");
        	}
            }
            try
    		{
            	if(LocatorValue.equals("Select_UsrMgtNewUserDomainName"))
            	{
            		if(ActualValue1.contains(".com #"))
            		{
            			System.out.println("Pass");
                		testStepResult="Pass";
            		}
            		else
            		{
            			System.out.println("Fail");
                		testStepResult="Fail";
            		}            		
            	}
            	
            	else
            	{
            		//AutoAssert.Assert(ActualValue1,TestData); 
            		if(AutoAssert.Assert(ActualValue1,TestData))
            		{
            			testStepResult= "Pass";
            		}
            		else
            		{
            			testStepResult= "Fail";
            		}
            		
            		System.out.println(testStepResult);
            	}
    		
    		
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
    		}catch(AssertionError e)
    		{
    			
    			if(LocatorValue.equals("SubscriptionDisplayName"))
    			{
    				System.out.println("Pass");
    				testStepResult="Pass";
    			}
    			else
    			{
    				System.out.println("Fail");
    				testStepResult="Fail";
    			}
    			//testStepResult="Fail";
    			 ExceptionMessage="Exception in verifyResult Action   "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
    			System.out.println(e.getMessage());
    			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
    		}
        	}
			catch(Exception e)
			{
				if(LocatorValue.equals("SubscriptionDisplayName"))
				{
					System.out.println("Pass");
					testStepResult="Pass";
				}
				else
				{
				//System.out.println("Fail");
				//testStepResult="Fail";
			//}
				    System.out.println("Fail");
				    testStepResult="Fail";
				    ExceptionMessage="Exception in verifyResult Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    System.out.println("Exception in verifyResult Action   "+e);
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}}
			}
        	
        	return testStepResult;
        

 }
	 public String   verifyResultParameter() 
 { 
        	String ActualValueparameter = null;
        	String ActualValue1 = null;
        	try{
        if(TestData=="confirmed")
        {
        	String id=getID();
        	System.out.println(id);
        	
        	ActualValue1=Browser.webDriver.findElement(By.xpath(id)).getAttribute("style");
        	System.out.println("AcutlaValue"+ActualValue1);
        }   
        else{
        	
        	ActualValueparameter=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        	TestData=prop.getProperty(TestData);
        System.out.println("sd"+TestData);    
        }
            try
    		{
    		AutoAssert.Assert(ActualValueparameter,TestData); 
    		System.out.println("Pass");
    		testStepResult="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
    		}catch(AssertionError e)
    		{
    			System.out.println("Pass");
    			testStepResult="Fail";
    			 ExceptionMessage="Exception in verifyResult Action   "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
    			System.out.println(e.getMessage());
    			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
    		}
        	}
			catch(Exception e)
			{
				    System.out.println("Pass");
				    testStepResult="Fail";
				    ExceptionMessage="Exception in verifyResult Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    System.out.println("Exception in verifyResult Action   "+e);
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        	
        	return testStepResult;
        

 }
	 public String   verifyResultTenant() 
 { 
        	String ActualValueT;
        	try{
        if(TestData=="confirmed")
        {
        	String id=getID();
        	System.out.println(id);
        	
        	ActualValueT=Browser.webDriver.findElement(By.xpath(id)).getAttribute("style");
        	System.out.println("AcutlaValue"+ActualValueT);
        }   
        else{
        	
            ActualValueT=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
        
            }
            try
    		{
    		AutoAssert.Assert(ActualValueT,prop.getProperty(TestData)); 
    		System.out.println("Pass");
    		testStepResult="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
    		}catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			testStepResult="Fail";
    			 ExceptionMessage="Exception in verifyResult Action   "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
    			System.out.println(e.getMessage());
    			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
    		}
        	}
			catch(Exception e)
			{
				    System.out.println("Fail");
				    testStepResult="Fail";
				    ExceptionMessage="Exception in verifyResult Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    System.out.println("Exception in verifyResult Action   "+e);
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        	return testStepResult;

        

 }
	 public String   SP_Assertion() 
 { 
        	String ActualValue21;
            String  previous11 = "PREVIOUS ECG"
    				+"\n" +"ABERRANT;";
    				//+ "\n" +"\n" +"Confirmed by  Dr OMD123 On 12 Jul 2017 2255" ;          	
            
            try{ActualValue21=Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).getText();
            	AutoAssert.Assert(ActualValue21,previous11);
            	testStepResult="Pass";
            }
             catch(Exception e)
            {
            	 System.out.println("exception");
            	 testStepResult="Fail";
             }
    		System.out.println("Previous text box values are matcghing");
            return testStepResult;   
            /*try
    		{
    		
    		
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
    		}catch(AssertionError e)
    		{
    			System.out.println("Fail");
    			testStepResult="Fail";
    			 ExceptionMessage="Exception in verifyResult Action   "+e.getMessage().toString();
    			 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
    			System.out.println(e.getMessage());
    			if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
    		}
		
			catch(Exception e)
			{
				    System.out.println("Fail");
				    testStepResult="Fail";
				    ExceptionMessage="Exception in verifyResult Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    System.out.println("Exception in verifyResult Action   "+e);
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}   */      
            
            //        

 }
	 public String   screenshot() 
 { 
//        	
//        	try
//        	{
//        		
//    		 
//            File scrshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        	
//            FileUtils.copyFile(scrshot, new File("c \\seleniumscreenshot\\"+Healthview.TestCaseName.toString()+"\\"+Healthview.TestCaseName.toString()+"_"+"Step#"+(Healthview.TestCaseStapeNo-1)+".png"));
//            testStepResult="Pass";
//        	}
//			catch(Exception e)
//			{
//				    System.out.println("Exception in screenshot Action   "+e);
//				    testStepResult="Fail";
//				    ExceptionMessage="Exception in screenshot Action   "+e.getMessage().toString();
//				    if(TestCasePriority.equalsIgnoreCase("P1"))
//			    	{
//			    	TestCasePriorityRep=true;
//			    	Browser.webDriver.close();
//			    	}
//			}
//            
//            break;
             
        return testStepResult;

 }
	 public String   IntializeBrowser() 
 { 
        {
//        	if(	TestCasePriority.equalsIgnoreCase("IE"))
//        	{
//        	
//        }
//        	else
//        	{
        	//ChromeOptions options = new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*");
//			WebDriverManager.chromedriver().driverVersion("111.0.5563.65").setup();
        		System.setProperty("webdriver.chrome.driver", Util.getRelativePath()+"\\chromedriver.exe");
        		Browser.webDriver = new ChromeDriver(); 
				testStepResult="Pass";
				
				
				
				
				
//        	}
        }
        return testStepResult;

 }
	 public String   launchBrowser() 
 { 
        	
        	try
        	{System.out.println(Browser.webDriver);
        		
        		if (Browser.webDriver.equals("ChromeDriver  chrome on XP (null)"))
{                 System.out.println(" i am in IF");
        		System.setProperty("webdriver.chrome.driver", Util.getRelativePath()+"\\chromedriver.exe");
				WebDriver webDriver = new ChromeDriver(); 
        		Thread.sleep(30000);
        		
} 
            Browser.webDriver.get(prop.getProperty(TestData));
            Browser.webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    		Browser.webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    		Browser.webDriver.manage().window().maximize();
    		Browser.webDriver.manage().deleteAllCookies();
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
    		testStepResult="Pass";
        	}
			catch(Exception e)
			{
				    System.out.println("Exception in LaunchBrowser Action   "+e);
				    testStepResult="Fail";
				    ExceptionMessage="Exception in LaunchBrowser Action   "+e.getMessage().toString();
				    if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
				    if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
			}
        	return testStepResult;
            
        

 }
	 public String   closeBrowser() 
 { 
        	
        	try {
		        System.out.println("wewe1");
        		
	        	 System.out.println("wewe3");
	        	Thread.sleep(400);	
	        	try {
	        		Browser.webDriver.close();
	        		Thread.sleep(5000);	
		        //	Browser.webDriver.quit();
		     // driver=null;
		        	
		        	Thread.sleep(5000);	
		        	testStepResult="Pass";
		        	org.openqa.selenium.Alert alert = Browser.webDriver.switchTo().alert();
        	  	 if(!(alert == null))
        	  	 {
        	  		alert.accept();
        	  	 }
        	  	 else
        	  	 {
        	  		Browser.webDriver.close();
        	  	 }
	        	}
	        	catch(Exception e)
				{}		
        		} 
				
				catch(Exception e)
				{
					    System.out.println("Exception in closeBrowser Action   "+e);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in closeBrowser Action   "+e.getMessage().toString();
					    //Browser.webDriver.close();
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
        	return testStepResult;
            
            

            
        

 }
	 public String   logout() 
 { 
	        {
	        	try
	        	{
	        	((JavascriptExecutor)Browser.webDriver).executeScript("LogOut('../Login.aspx?State=Logout')");
	        	testStepResult="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
	        	}
	        	catch(Exception e)
	        	{
	        		System.out.println("Exception in logout Action   "+e);
	        		testStepResult="Fail";
	        		 ExceptionMessage="Exception in logout Action   "+e.getMessage().toString();
	        		 if(Screenshot.equalsIgnoreCase("Y"))
	 				{
	 					screnshotcls obj=new screnshotcls(Browser.webDriver);
	 				}
	        		if(TestCasePriority.equalsIgnoreCase("P1"))
			    	{
			    	TestCasePriorityRep=true;
			    	Browser.webDriver.close();
			    	}
	        	}
	        }
	        return testStepResult;
        

 }
	 public String   RelaunchChromeBrowser() 
 { 
        {
        	try
        	{
        		testStepResult="Pass";
        	}
        	catch(Exception e)
        	{
        		System.out.println("Exception in logout Action   "+e);
        		testStepResult="Fail";
        		 ExceptionMessage="Exception in logout Action   "+e.getMessage().toString();
        		 if(Screenshot.equalsIgnoreCase("Y"))
 				{
 					screnshotcls obj=new screnshotcls(Browser.webDriver);
 				}
        		if(TestCasePriority.equalsIgnoreCase("P1"))
		    	{
		    	TestCasePriorityRep=true;
		    	Browser.webDriver.close();
		    	}
        	}
        }
        return testStepResult;
        

 }
	 public String   SLEEP() 
 { 
	        {
	        	try
	        	{
	        	long sleeptime=Long.parseLong(TestData);
	        	Thread.sleep(sleeptime);
	        	System.out.println("In sleep mode");
	        	testStepResult="Pass";
	        	//if(Screenshot.equalsIgnoreCase("Y"))
				//{
					//screnshotcls obj=new screnshotcls(Browser.webDriver);
				//}
	        	} catch (NumberFormatException nfe) 
	        	{
	                System.out.println("NumberFormatException  in SLEEP Action " + nfe.getMessage());
	                testStepResult="Fail";
	                ExceptionMessage="NumberFormatException  in SLEEP Action " +nfe.getMessage().toString();
	                //if(Screenshot.equalsIgnoreCase("Y"))
					//{
						//screnshotcls obj=new screnshotcls(Browser.webDriver);
					//}
	            }
	        	catch(Exception e)
				{
					    System.out.println("Exception in SLEEP Action   "+e);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in SLEEP Action   "+e.getMessage().toString();
					    //if(Screenshot.equalsIgnoreCase("Y"))
						//{
							//screnshotcls obj=new screnshotcls(Browser.webDriver);
						//}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        }
	        return testStepResult;
	        
	        

 }
	 public String   TAB() 
 { 
	        {
	        	try
	        	{
	        	Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).sendKeys(Keys.TAB);
	        	testStepResult="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in TAB Action   "+e);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in TAB Action   "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        }
	        return testStepResult;
	        
	        
	        

 }
	 public String   ClrText() 
 { 
	        {
	        	try
	        	{
	        	Browser.webDriver.findElement(this.getObject(LocatorValue, LocatorType)).clear();
	        	testStepResult="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ClrText Action   "+e);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in ClrText Action   "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        }
	        return testStepResult;
        
	        

 }
	 public String   SwitchToFrame() 
 { 
	        {
	        	if(TestData.equalsIgnoreCase("Parent"))
	        	{
	        		//After you done with child window
	        		try
		        	{
	        		System.out.println("Current value is "+parentWindowHandleq);
	        		Browser.webDriver.switchTo().window(parentWindowHandleq);
	        		testStepResult="Pass";
		        	if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
		        	}
		        	
					catch(Exception e)
					{
						    System.out.println("Exception in SwitchFrame Action   "+e);
						    testStepResult="Fail";
						    ExceptionMessage="Exception in SwitchFrame Action   "+e.getMessage().toString();
						    
						    if(Screenshot.equalsIgnoreCase("Y"))
							{
								screnshotcls obj=new screnshotcls(Browser.webDriver);
							}
						    if(TestCasePriority.equalsIgnoreCase("P1"))
					    	{
					    	TestCasePriorityRep=true;
					    	Browser.webDriver.close();
					    	}
					}
		        }
	        	else if(TestData.equalsIgnoreCase("Child"))
	        	{
	        		
	        		try
		        	{
	        		
	        		screnshotcls screnshotcls=new screnshotcls(Browser.webDriver);
	        		screnshotcls.NewWindowScreenShot();
	        		testStepResult="Pass";
//		        	if(Screenshot.equalsIgnoreCase("Y"))
//					{
//						screnshotcls obj=new screnshotcls(Browser.webDriver);
//					}
		        	}
		        	
					catch(Exception e)
					{
						    System.out.println("Exception in SwitchFrame Action   "+e);
						    testStepResult="Fail";
						    ExceptionMessage="Exception in SwitchFrame Action   "+e.getMessage().toString();
						    //Healthview.FailedError=ExceptionMessage;
						    if(Screenshot.equalsIgnoreCase("Y"))
							{
								screnshotcls obj=new screnshotcls(Browser.webDriver);
							}
						    if(TestCasePriority.equalsIgnoreCase("P1"))
					    	{
					    	TestCasePriorityRep=true;
					    	Browser.webDriver.close();
					    	}
					}
		        }
	        	
	        	else
	        	{
	        	try
	        	{
	        	String parentWindowHandle1 = Browser.webDriver.getWindowHandle();	
	        	parentWindowHandleq=parentWindowHandle1;
	        	System.out.println("while first time captured value is "+parentWindowHandleq);
	        	Browser.webDriver.switchTo().frame(prop.getProperty(LocatorValue));
	        	testStepResult="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
	        	}
	        	
				catch(Exception e)
				{
					    System.out.println("Exception in SwitchFrame Action   "+e);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in SwitchFrame Action   "+e.getMessage().toString();
					    
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        	}
	        	
	        	        	
	        }
	        return testStepResult;

        
	        

 }
	 public String   ActionClick() 
 { 
	        {
	        	try
	        	{
	        	Actions actions = new Actions(Browser.webDriver);
	    		WebElement subMenu = Browser.webDriver.findElement(this.getObject(LocatorValue, LocatorType));
	    		actions.moveToElement(subMenu);
	    		actions.click().build().perform();
	    		testStepResult="Pass";
	    		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ActionClick Action   "+e);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in ActionClick Action   "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        }
	        return testStepResult;
	        
	        

 }
	 public String   ParentFrame() 
 { 
	        {
	        	try
	        	{
	        	Browser.webDriver.switchTo().parentFrame();
	        	testStepResult="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ParentFrame Action   "+e);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in ParentFrame Action   "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        	        	
	        }
	        return testStepResult;
	        
	        

 }
	 public String   DropdownSelect() 
	 { 
		 String [] testInputs = null;
	     WebElement dd = null;
		 try
		 {			
			 try
			 {
				 if(LocatorValue.equals("contentPackSubscriptionDivision"))
				 {
					 testInputs = TestData.split("#");
					 WebElement TogetRows = Browser.webDriver.findElement(this.getObject("contentPackSubscriptionDivision",LocatorType));
			         List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("select"));
			         UsrMgtTblRwCount = TotalRowsList.size();
			         for(int i=1;i<=UsrMgtTblRwCount;i++)
			         {
			        	 System.out.println(TotalRowsList.get(i).getAttribute("id"));
			        	 if(TotalRowsList.get(i).getAttribute("id").equals(testInputs[0]))
			        	 {
			        		 dropdown=new Select(TotalRowsList.get(i));
			        		 break;
			        	 }
			         }			        		
			         System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
				 }
				 else if(LocatorValue.equals("OptInMessagesTenant"))
				 {
					 WebElement TogetRows = Browser.webDriver.findElement(this.getObject("divTenants",LocatorType));
					 WebElement TotalRowsList = TogetRows.findElement(By.tagName("select"));
					 System.out.println(TotalRowsList.getAttribute("id"));
					 dropdown=new Select(TotalRowsList);
					 System.out.println("Total number of Rows in the table are   "+ UsrMgtTblRwCount);
				 }
				 else
				 {
					 System.out.println("Yes1");
					 WebElement temp = Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType));
					 dd=temp;
				 }
			 }
			 catch(Exception e)
			 {
				 System.out.println("Ankits inner exc    "+e);		
			 }
			 if(LocatorValue.equals("contentPackSubscriptionDivision"))
			 {
				 System.out.println(testInputs[1]);
				 System.out.println(prop.getProperty(testInputs[1]));
				 if(testInputs[1].equals("Tenant"))
				 {
					 dropdown.selectByVisibleText(prop.getProperty(testInputs[1]));
				 }
				 else
				 {
					 dropdown.selectByVisibleText(testInputs[1]);
				 }
			 }
			 else
			 {
				 if(LocatorValue.equals("OptInMessagesTenant"))
				 { 
					 String a = prop.getProperty(TestData);
					 dropdown.selectByValue(prop.getProperty(TestData));
					 dropdown.selectByVisibleText(prop.getProperty(TestData));
				 }
				 else
				 {
					 Select s = new Select(dd);
					 String td = prop.getProperty(TestData);
					 s.selectByValue(TestData);
				 }
			 }
			 testStepResult="Pass";
			 if(Screenshot.equalsIgnoreCase("Y"))
			 {
				 screnshotcls obj=new screnshotcls(Browser.webDriver);
			 }
		 }
		 catch(NullPointerException e)
		 {
			 System.out.println("Ankits inner exc    "+e);
		 }				
		 catch(Exception e)
		 {
			 System.out.println("Exception in clickButton Action   "+e);
			 testStepResult="Fail";
			 ExceptionMessage="Exception in clickButton Action     "+e.getMessage().toString();
			 if(Screenshot.equalsIgnoreCase("Y"))
			 {
				 screnshotcls obj=new screnshotcls(Browser.webDriver);
			 }
			 if(TestCasePriority.equalsIgnoreCase("P1"))
			 {
				 TestCasePriorityRep=true;
				 Browser.webDriver.close();
			 }
		 }	
		 return testStepResult;
	 }
	 
	 
	 public String   JavascriptExecutor() 
 { 
	        {
	        	try
	        	{
	        		((JavascriptExecutor)Browser.webDriver).executeScript(prop.getProperty(LocatorValue));
	        		testStepResult="Pass";
		        	if(Screenshot.equalsIgnoreCase("Y"))
					{
						screnshotcls obj=new screnshotcls(Browser.webDriver);
					}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in JavascriptExecutor Action   "+e);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in JavascriptExecutor Action   "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        }
	        return testStepResult;
	        
	        
	        

 }
	 public String   Mousehover() 
 { 
	        {
	        	
	        	 WebElement menuOption;
				try {
					menuOption = Browser.webDriver.findElement(this.getObject(LocatorValue, LocatorType));
					Actions action1 = new Actions(Browser.webDriver);
		            action1.moveToElement(menuOption).build().perform();
		            testStepResult="Pass";
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		            
	        	try
	        	{
	        	
	           
	            
	    		testStepResult="Pass";
	    		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ActionClick Action   "+e);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in ActionClick Action   "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        }
	        return testStepResult;
	        
	        

 }
	 public String   Tooltip() 
 { 
	        {
	        	try
	        	{
	        		WebElement toolTipEle = Browser.webDriver.findElement(this.getObject(LocatorValue, LocatorType));
	        		 // Get the Tool Tip Text
	        		//Actions action = new Actions(Browser.webDriver);
	        		//action.moveToElement(toolTipEle);
	        		//toolTipEle.
	        		Thread.sleep(2000); 
	        		String toolTipTxt = toolTipEle.getText();
	        		    System.out.println("Exception Tool Tip Action   "+toolTipTxt);
	        		    AutoAssert.Assert(toolTipTxt,TestData); 
	        		    System.out.println("Pass"+toolTipTxt);
	        		    Thread.sleep(20000);
	            		System.out.println("Pass");
	          
	    		testStepResult="Pass";
	    		if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
	        	}
	        	catch(NullPointerException e)
	        	{
	        		{
					    System.out.println("Exception in ActionClick Action   ");
					
					    testStepResult="Fail";
					   
					    if(Screenshot.equalsIgnoreCase("Y"))
						{System.out.println("HiiiAnkita   ");
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        		
	        	}
	        	
				catch(Exception e)
				{
					    System.out.println("Exception in ActionClick Action   ");
					
					    testStepResult="Fail";
					    ExceptionMessage="Exception in ActionClick Action   "+e.getMessage().toString();
					
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
					    	
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        }
	        return testStepResult;
	        
	        
	        

 }
	 public String   upload() 
 { 
	        {
	        	
	        	try
	        	{
	        		
	  WebElement subMenu = Browser.webDriver.findElement(this.getObject(LocatorValue, LocatorType));
	  
	  
	  subMenu.sendKeys(prop.getProperty("Filepath"));
	    	
	    	//Thread.sleep(10000);
	        		System.out.println("LocatorValue"+LocatorValue);	
	    	//Browser.webDriver.findElement(By.xpath(".//*[@id='ctl00_cpb_dxpcUpload_UploadControl_TextBox0_Input']")).click();    	
	    	System.out.println("LocatorValue"+LocatorValue);
	    	System.out.println("Locatortype"+LocatorType);
	    	//	subMenu.click();
	    		//subMenu.sendKeys("D /Test/Test1.docx");
	    	//	StringSelection ss = new StringSelection("D /Test/Test1.docx");
//	    	s	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//	    		Robot robot = new Robot();
//
//	    		robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
//	    		robot.keyPress(java.awt.event.KeyEvent.VK_V);
//	    		robot.keyRelease(java.awt.event.KeyEvent.VK_V);
//	    		robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
//	    		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//	    		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	    		testStepResult="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ActionClick Action   "+e);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in ActionClick Action   "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        }
	        return testStepResult;
	        

 }
	 public String   upload1() 
 { 
	        {
	        	
	        	boolean flag11=false;int count1=0;
	        	boolean flag2=false;int count2=0;
			//System.out.println(Long.parseLong(TestData));
			//System.out.println("hiii1");
			
	        	
		 
		  WebDriverWait wait = new WebDriverWait(Browser.webDriver, Duration.ofSeconds(10));    
		  By elem_dynamic = By.id("dynamic-element");
		  wait.until(ExpectedConditions.presenceOfElementLocated(elem_dynamic));
	        	try
	        	{
	        		
	        		for (int i=0;i<200;i++)
	        		{
	    		
	    		    
	    		 WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(Browser.webDriver.findElement(By.xpath(prop.getProperty("Upload_Publish_Content"))))); 
	    		ele.click();	
	    			
	        	/////////////////////////////////////////////////////	
	  WebElement subMenu = Browser.webDriver.findElement(this.getObject(LocatorValue, LocatorType));
	  subMenu.sendKeys(prop.getProperty("Filepath"));
	  Thread.sleep(5000);
	    ///////////////////////////////////PUblish Content Pack//////////////////////////////	
	//  Browser.webDriver.findElement(By.xpath(prop.getProperty("Publish"))).
	  
    
         WebElement ele1= wait.until(ExpectedConditions.elementToBeClickable(Browser.webDriver.findElement(By.xpath(prop.getProperty("Publish")))));

       System.out.println("flag2="+flag2);
       ele1.click();	
	
	 //////////////////////////////Handel Alert////////////////////////////////////       		
	  System.out.println("flag2dfghdf");
	
	  wait.until(ExpectedConditions.alertIsPresent());
	   org.openqa.selenium.Alert alert = Browser.webDriver.switchTo().alert();	
	   System.out.println("flag2dfghdf");
       String alertMessage= Browser.webDriver.switchTo().alert().getText();
       System.out.println("flag2dfghdf");
	   System.out.println(alertMessage);
	   System.out.println("flag2dfghdf");
	   
  	   alert.accept();
	   ////////////////////////////////////Assertion////////////////////////////    		
	        	
  	  Thread.sleep(15000);
      String Act1="Download";
      String Act2="Upload New";
      String Act3="Delete";
      String Act4="Edit";
      String tk=Browser.webDriver.findElement(By.xpath(prop.getProperty("Download_publishcontent"))).getText();
      System.out.println(Browser.webDriver.findElement(By.xpath(prop.getProperty("Download_publishcontent"))).getText());
		AutoAssert.Assert(tk,Act1); 
		System.out.println("Download link is present");

		AutoAssert.Assert(Browser.webDriver.findElement(By.xpath(prop.getProperty("Upload_Publish_Content"))).getText(),Act2);
		System.out.println("Upload new link link is present");
		
		
		AutoAssert.Assert(Browser.webDriver.findElement(By.xpath(prop.getProperty("Delete_Publish_Content"))).getText(),Act3);
		System.out.println("Delete link is present");
		AutoAssert.Assert(Browser.webDriver.findElement(By.xpath(prop.getProperty("Edit_Content_Pack"))).getText(),Act4);
		System.out.println("Edit link is present");
	    	testStepResult="Pass";
    		if(Screenshot.equalsIgnoreCase("Y"))
			{
				screnshotcls obj=new screnshotcls(Browser.webDriver);
			}
	        		}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in ActionClick Action   "+e);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in ActionClick Action   "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        }
	        	
	        return testStepResult;

 }
	 public String   ManagmentConsoleloop() 
 { 
	        {
	        	
	        	boolean flag11=false;int count1=0;
	        	boolean flag2=false;int count2=0;
			   	
		  
		  WebDriverWait wait = new WebDriverWait(Browser.webDriver, Duration.ofSeconds(10));    
		  By elem_dynamic = By.id("dynamic-element");
		  wait.until(ExpectedConditions.presenceOfElementLocated(elem_dynamic));       	
	        	try
	        	{
	        		
	        		for (int i=0;i<200;i++)
	        		{  
	        			
        		//	System.setProperty("webBrowser.webDriver.chrome.driver", Healthview.path+"\\Used\\Chrome\\chromeBrowser.webDriver.exe");
           		//WebDriver driver = new ChromeDriver();
       			Thread.sleep(10000);
                Browser.webDriver.get(prop.getProperty("Url"));
                Browser.webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	        		Browser.webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        		Browser.webDriver.manage().window().maximize();
	        		Browser.webDriver.manage().deleteAllCookies();
	        		System.out.println("hiiohihoihioho");
	        	//Thread.sleep(40000);
	        		Browser.webDriver.findElement(By.xpath(prop.getProperty("SignIn"))).click();
	        		//Browser.webDriver.findElement(By.xpath(prop.getProperty("UserName"))).sendKeys(prop.getProperty("lctUser"));
	        		
	        	//	Thread.sleep(10000);
	        		System.out.println("hii");
	        		Browser.webDriver.findElement(By.xpath(prop.getProperty("Login_again"))).click();
	        		//Thread.sleep(10000);
	        		//Browser.webDriver.findElement(By.xpath(prop.getProperty("Next"))).click();
	        		System.out.println("hii");
	        		//Thread.sleep(10000);
	        		Browser.webDriver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("lctPwd"));
	        		//Browser.webDriver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("Pwd1"));
	        		System.out.println("hii");
	        		//Thread.sleep(5000);
	        		Browser.webDriver.findElement(By.xpath(prop.getProperty("Next"))).click();
	        		//Thread.sleep(5000);
	        		System.out.println("hii");
	        		Browser.webDriver.findElement(By.xpath(prop.getProperty("Next1"))).click();
	        		//Thread.sleep(45000);
	        		System.out.println("hii");
	    		Browser.webDriver.findElement(By.xpath(prop.getProperty("Managment_console"))).click();
	    		System.out.println("hii");
	    	    System.out.println("Clicked on managment console"+i);
	 //Thread.sleep(35000);
	 Browser.webDriver.findElement(By.xpath(prop.getProperty("SignOut"))).click();
     System.out.println("SignOut from Apllication");
    
     testStepResult="Pass";
       System.out.println("Close Browser");
	
	        		}
	        	}
	        	catch(Exception ns)
				{
					    System.out.println("Exception in ActionClick Action   "+ns);
					    testStepResult="Fail";
					    ExceptionMessage="Exception in ActionClick Action   "+ns.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	//Browser.webDriver.close();
				    	}
				}
	        }
	        	
		
	        return testStepResult;
	        
	        

 }
	 public String   GVRSelectCheckbox() throws Exception 
 { 
	        {
	        
	        	// Grab the table
	/*        Thread.sleep(5000);
	        System.out.println("Start");
			WebElement table = Browser.webDriver.findElement(By.id(prop.getProperty(LocatorValue)));

			// Now get all the TR elements from the table
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			ArrayList al=new ArrayList<>();
			
			// And iterate over them, getting the cells
			for (WebElement row   allRows) 
			 {
			 List<WebElement> cells = row.findElements(By.tagName("td"));
			 for (WebElement cell   cells) 
			 {
				
				
				if(cell.getText().length()>1)
				{
					//System.out.println("Value is   "+cell.getText() +"      "+cell.getText().length());
					al.add(cell.getText());
				}
				
				
			}
			 	String[] ss=TestData.split("#");
			 	String date2=ss[1].replace("/", "-");
			 	if(al.contains(ss[0]) && (al.contains(ss[1]) ||al.contains(date2)))
				{
					System.out.println("Matching        "+al);
					al.clear();
					//System.out.println("After clear         "+al);
					Browser.webDriver.findElement(By.id(row.getAttribute("id"))).click();
					break;
				}
			 	al.clear();
			 	ss=null;
              GVRSelect(SwitchCaseActionName, LocatorType, LocatorValue, TestData, Screenshot);
		
			// System.out.println("==============================================================================");
				 
			 }*/
	        	WebElement row;
	        	flag=true;
	            try{
	            
	            
	        	row=GVRSelect(LocatorType, LocatorValue, TestData, Screenshot);
	            String str=row.getAttribute("id");
	            int len=str.length();
	            //int t=str.indexOf('9');
	           // System.out.println(t);
	            System.out.println(row);
	            String str1= str.substring(52,len);
	            System.out.println(str1);
	            String id="ctl00_cpb_gridCallbackPanel_gridFilterData_DXSelBtn";
	            id=id.concat(str1);
	            id=id.concat("_D");
	            System.out.println(id);
	            setID(id);
	            WebElement ele4=Browser.webDriver.findElement(By.id(id));
	            
	     	   ele4.click();
	     	  testStepResult="Pass";
	     	   //ele4.click();
	        	
	            }
	            catch(NullPointerException e)
  	            {
	            
	            	System.out.println("Patient is not correct  or deleted");
	            	 testStepResult="Fail";
	            }
	            
	            
	            
	            
	            
	            
	            
	       
	        }
        
	        
	        return testStepResult;
 }
	 public String   GVRSelectpatient() throws Exception 
 { 
	        {
	        
	        	// Grab the table
	/*        Thread.sleep(5000);
	        System.out.println("Start");
			WebElement table = Browser.webDriver.findElement(By.id(prop.getProperty(LocatorValue)));

			// Now get all the TR elements from the table
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			ArrayList al=new ArrayList<>();
			
			// And iterate over them, getting the cells
			for (WebElement row   allRows) 
			 {
			 List<WebElement> cells = row.findElements(By.tagName("td"));
			 for (WebElement cell   cells) 
			 {
				
				
				if(cell.getText().length()>1)
				{
					//System.out.println("Value is   "+cell.getText() +"      "+cell.getText().length());
					al.add(cell.getText());
				}
				
				
			}
			 	String[] ss=TestData.split("#");
			 	String date2=ss[1].replace("/", "-");
			 	if(al.contains(ss[0]) && (al.contains(ss[1]) ||al.contains(date2)))
				{
					System.out.println("Matching        "+al);
					al.clear();
					//System.out.println("After clear         "+al);
					Browser.webDriver.findElement(By.id(row.getAttribute("id"))).click();
					break;
				}
			 	al.clear();
			 	ss=null;
              GVRSelect(SwitchCaseActionName, LocatorType, LocatorValue, TestData, Screenshot);
		
			// System.out.println("==============================================================================");
				 
			 }*/
	        	WebElement row;
	        	flag=true;
	            try{
	            
	            
	        	row=GVRSelect(LocatorType, LocatorValue, TestData, Screenshot);
	            
	        	row.click();
	        	 testStepResult="Pass";
	            }
	            catch(NullPointerException e)
	            {
	            	System.out.println("Patient is not correct  or deleted");
	            	 testStepResult="Fail";
	            }
	            
	            
	            
	            
	            
	            
	            
	       
	        }
	        return testStepResult;
	        

 }
	 public String   Submit() 
 { 
	        {
	        	try
	        	{
	        	Browser.webDriver.findElement(this.getObject(LocatorValue,LocatorType)).submit();
	        	testStepResult="Pass";
	        	if(Screenshot.equalsIgnoreCase("Y"))
				{
					screnshotcls obj=new screnshotcls(Browser.webDriver);
				}
	        	}
				catch(Exception e)
				{
					    System.out.println("Exception in Submit Action   "+e);
					    testStepResult="Fail";
					    //ExceptionMessage="Exception in TAB Action   "+e.getMessage().toString();
					    if(Screenshot.equalsIgnoreCase("Y"))
						{
							screnshotcls obj=new screnshotcls(Browser.webDriver);
						}
					    if(TestCasePriority.equalsIgnoreCase("P1"))
				    	{
				    	TestCasePriorityRep=true;
				    	Browser.webDriver.close();
				    	}
				}
	        }
	        
	        	
	        return testStepResult;
        	


 }
	 public String   GVRADTSelect() throws Exception 
 { 
{
	WebElement row;
	// Grab the table
/*        Thread.sleep(5000);
System.out.println("Start");
WebElement table = Browser.webDriver.findElement(By.id(prop.getProperty(LocatorValue)));

// Now get all the TR elements from the table
List<WebElement> allRows = table.findElements(By.tagName("tr"));
ArrayList al=new ArrayList<>();

// And iterate over them, getting the cells
for (WebElement row   allRows) 
 {
 List<WebElement> cells = row.findElements(By.tagName("td"));
 for (WebElement cell   cells) 
 {
	
	
	if(cell.getText().length()>1)
	{
		//System.out.println("Value is   "+cell.getText() +"      "+cell.getText().length());
		al.add(cell.getText());
	}
	
	
}
 	String[] ss=TestData.split("#");
 	String date2=ss[1].replace("/", "-");
 	if(al.contains(ss[0]) && (al.contains(ss[1]) ||al.contains(date2)))
	{
		System.out.println("Matching        "+al);
		al.clear();
		//System.out.println("After clear         "+al);
		Browser.webDriver.findElement(By.id(row.getAttribute("id"))).click();
		break;
	}
 	al.clear();
 	ss=null;
  GVRSelect(SwitchCaseActionName, LocatorType, LocatorValue, TestData, Screenshot);

// System.out.println("==============================================================================");
	 
 }*/
       String name;
	 
	  try
	  {
	 flag=true;
	 row=GVRSelect(LocatorType, LocatorValue, TestData, Screenshot);
	 String id=row.getAttribute("id");
	 name=id;
	 name=name.concat("']/td[8]");
	  id=id.concat("']/td[8]/a/span/u");
	  String id1=".//*[@id='";
	  id=id1.concat(id);
	  name=id1.concat(name);
	  //setID(name); 
	  System.out.println(id);
	  
	
	  WebElement ele4=Browser.webDriver.findElement(By.xpath(id));
	   ele4.click();
	   ele4.click();
	   testStepResult="Pass";
	  }
	  catch(NullPointerException e)
        {
      	System.out.println("Patient is not correct  or deleted");
      	 testStepResult="Fail";
      }
      
      
}
return testStepResult;



}



	
public  String SP_verification(){
		/*Prvs_Text= Browser.webDriver.findElement(By.id("memoPreviousECGMDInterpretation")).getText();
		Old_Text = Browser.webDriver.findElement(By.id("memoOldestECGMDInterpretation")).getText();*/
			
		String previous = "PREVIOUS ECG"
				+"\n" +"ABERRANT";
				//+ "\n" +"\n" +"Confirmed by  Dr OMD123 On 12 Jul 2017 2255" ;
		
		String Oldest = "OLDEST ECG"
				+"\n" +"High Fever;"
				+"\n" + "HighFever;";
		try
		{
		if(previous.equals(Prvs_Text) && (Oldest.equals(Old_Text))){
			testStepResult="Pass";
			System.out.println("\n Pass");
		}else{testStepResult="Fail";
			System.out.println("\n Fail");
		}
		}catch(Exception e)
		{testStepResult="Fail";
			System.out.println("Exception handled" + e);
		}
		return testStepResult;
	}
		private By getObject(String LocatorValue,String LocatorType) throws Exception
		{
			Properties prop=new Properties();
		    FileInputStream finp=new FileInputStream(PropertiesFile);
		    prop.load(finp);
		    String [] param;
		    String xpath;
	        //Find by xpath
			if(LocatorType.equalsIgnoreCase("XPATH"))
	        {
				param=LocatorValue.split("#");
			
				if(LocatorValue.split("#").length<2)
				{
					
				//	System.out.println("HIIIIIIIIIIAnkita "+LocatorValue.split("#").length);
				 xpath=prop.getProperty(param[0]);
	           // return By.xpath(LocatorValue);
				
				if(LocatorValue.equals("Edit_button_multiplerows")||LocatorValue.equals("ClientID_MultipleRows")||LocatorValue.equals("MultipleSubscriptionUpdatedBy") || LocatorValue.equals("MultipleSubscriptionUpdatedDate") || LocatorValue.equals("MultipleSubscriptionReportFormate") || LocatorValue.equals("MultipleSubscriptionViewLink") || LocatorValue.equals("MultipleSubscriptionDeleteBtn") || LocatorValue.equals("MultipleSubscriptionEditBtn") || LocatorValue.equals("inactiveATUserName") || LocatorValue.equals("inactiveATUserMailID") || LocatorValue.equals("inactiveATUserUsertype") || LocatorValue.equals("inactiveATUserLastLoginDate") || LocatorValue.equals("inactiveATUserDuration") || LocatorValue.equals("inactiveATUserStatus") || LocatorValue.equals("BlockedUserStatusFromMultiple2") || LocatorValue.equals("UnBlockUserFromMultiple") || LocatorValue.equals("BlockedUserStatusFromMultiple") || LocatorValue.equals("BlockInactiveUserFromMultiple") || LocatorValue.equals("InactiveUserName") || LocatorValue.equals("UnBlockUser") || LocatorValue.equals("UserStatus") || LocatorValue.equals("isDatabaseUser") || LocatorValue.equals("deleteNewSiteApprover") || LocatorValue.equals("NewSiteApproverName") || LocatorValue.equals("dataTableName") || LocatorValue.equals("manageDataTable") || LocatorValue.equals("resetUserPassword") || LocatorValue.equals("multipleSubscriptionAdded") || LocatorValue.equals("editTenant") || LocatorValue.equals("editContentpackPublishedByAutomation") || LocatorValue.equals("ContentPackGroupToCopy")|| LocatorValue.equals("ContentPackGroupNameInPCPPage") || LocatorValue.equals("ContentPackGroup") || LocatorValue.equals("deleteContentpackPublishedByAutomation") || LocatorValue.equals("ContentpackPublishedByAutomation") || LocatorValue.equals("deleteTenantAddedByAutomation") || LocatorValue.equals("tenantAddedByAutomation") || LocatorValue.equals("roleToUserAddedByAutomation") || LocatorValue.equals("userAddedByAutomation") || LocatorValue.equals("deleteUserAddedByAutomation") || LocatorValue.equals("automationUserPrivilegeGroup") || LocatorValue.equals("editUserAddedByAutomation") || LocatorValue.equals("divisionAddedByAutomation") || LocatorValue.equals("hospitalAddedByAutomation")||LocatorValue.equals("hospitalLocationAddedByAutomation"))
				{
					String[]temp = xpath.split("#");
					xpath = temp[0]+String.valueOf(UsrMgtTblRwNo)+temp[1];
					//for(int i=0;i<UsrMgtTblRwCount;i++)
					//{
				/*	System.out.println(UsrMgtTblRwNo);
						xpath=prop.getProperty(param[0]);
						String ss = String.valueOf(UsrMgtTblRwNo);
						System.out.println(ss);
						char s = (char)(UsrMgtTblRwNo + '0');
						System.out.println(s);
						xpath=xpath.replace('#', s);*/
						System.out.println(xpath);
					//}
					 
				}
				
		//////////
				 
							 
							 
							 /////////////
				return By.xpath(xpath);
				}
				else
				{
					//System.out.println("HIIIIIIIIIIAnkita "LocatorValue.split("#").length);
					 xpath=prop.getProperty(param[0]).replace("@param", param[1]);
					
					 
					 
					 
					 
					return By.xpath(xpath);
				}
					
	        }
	        //find by class
	        else if(LocatorType.equalsIgnoreCase("CLASSNAME"))
	        {
	             
	            return By.className(LocatorValue);
	             
	        }
	        //find by name
	        else if(LocatorType.equalsIgnoreCase("NAME"))
	        {
	             
	            return By.name(LocatorValue);
	             
	        }
	        //Find by css
	        else if(LocatorType.equalsIgnoreCase("CSS"))
	        {
	             
	            return By.cssSelector(LocatorValue);
	             
	        }
	        //find by link
	        else if(LocatorType.equalsIgnoreCase("LINK"))
	        {
	             
	            return By.linkText(LocatorValue);
	             
	        }
			//find by ID
	        else if(LocatorType.equalsIgnoreCase("ID"))
	        {
	             
	           // return By.id(LocatorValue);
	            return By.id(prop.getProperty(LocatorValue));
	             
	        }
	        //find by partial link
	        else if(LocatorType.equalsIgnoreCase("PARTIALLINK"))
	        {
	             
	            return By.partialLinkText(LocatorValue);
	             
	        }else
	        	
	        
	        {
	            throw new Exception("Wrong object type");
	        }
	   
	}

	public <E> WebElement GVRSelect(String LocatorType,String LocatorValue,String TestData,String Screenshot)  throws Exception
	
	{
		WebElement ele=null;
		Properties prop=new Properties();
	    FileInputStream finp=new FileInputStream(PropertiesFile);
	    prop.load(finp);
		 Thread.sleep(5000);
		 WebElement row1=null;
	        System.out.println("Start");
			WebElement table = Browser.webDriver.findElement(By.id(prop.getProperty(LocatorValue)));

			// Now get all the TR elements from the table
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			ArrayList al=new ArrayList<E>();
			
			
		
			System.out.println("hii");			
			// And iterate over them, getting the cells
			try
		 	{
			for (WebElement row :  allRows) 
			 {
				System.out.println("hii1*******" + row.getText());
			 List<WebElement> cells = row.findElements(By.tagName("td"));
			 for (WebElement cell :  cells) 
			 {
				 System.out.println("hii2");
				
				if(cell.getText().length()>1)
				{
					System.out.println("Value is   "+cell.getText() +"      "+cell.getText().length());
					al.add(cell.getText());
					
				}
				
				
			}
			 	String[] ss=TestData.split("#");
			 	System.out.println(ss[0] + "\thiii7"+ ss[1] );
			 	String date2=ss[1].replace("/", "-");
			 	System.out.println("hi6");
			 	
			 	if(al.contains(ss[0]) && (al.contains(ss[1]) ||al.contains(date2)))
				{
					System.out.println("Matching        "+al);
					al.clear();
					//System.out.println("After clear         "+al);
					/* WebElement ele=Browser.webDriver.findElement(By.id(row.getAttribute("id")));*/
					System.out.println("hiii8"+row.getAttribute("id"));
					
					//row.click();
					/*Browser.webDriver.findElement(By.xpath(".//*[@id='ctl00_cpb_gridCallbackPanel_gridFilterData_DXDataRow9'/td[8]/a/span/u")).click();
					System.out.println(row.getText());*/
					
					 row1=row;
					 setID(row.getAttribute("id"));
					 break;
				}
			 	
			 	
			 	al.clear();
			 	ss=null;
			
		flag=true;
		testStepResult="Pass";
	}
		 	}
			
		 	catch(NullPointerException e)
           {
           	System.out.println("Patient is not correct  or deleted");
           	 testStepResult="Fail";
           }
           
			return row1;


}

	private Connection MyDbConnection(String user1,String dbpwd,String servername,String dbname) throws ClassNotFoundException, IOException, SQLException
	{
		Properties prop=new Properties();
		FileInputStream finp=new FileInputStream(PropertiesFile);
	    prop.load(finp);
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String dbURL = "jdbc:sqlserver://sqlsrvdmalptat.database.windows.net:1433;database=sqldblpt;user=sqlsrvadmin;password=LdxH@althCl0ud20200820@sqllpt;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=60";	
        System.out.println(dbURL);
		Connection conn=null;
    	try
    	{
    		conn = DriverManager.getConnection(dbURL);
    	} 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
    	}
    	if (conn!= null) 
    	{
    		System.out.println("Connected");
		}
    	return conn;
	}
	private Connection MylptDbConnection(String user1,String dbpwd,String servername,String dbname) throws ClassNotFoundException, IOException, SQLException
	{
//		/////1july2022
//		Properties prop=new Properties();
//		FileInputStream finp=new FileInputStream(PropertiesFile);
//	    prop.load(finp);
////	    String url="jdbc:sqlserver://tcp:sqlsrvdmalptat.database.windows.net:1433;database=sqldblpt;user=sqlsrvadmin;password=LdxH@althCl0ud20200820@sqllpt;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=60;";
//////	               "jdbc:sqlserver://fabrikam.database.windows.net:1433;database=fiber;user=raisa;password=testpass;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//////	    String un="sqlsrvadmin";
//////	    String pwd="LdxH@althCl0ud20200820@sqllpt";
////	    Connection connection = DriverManager.getConnection(url);
////	    System.out.println("Database connection test: " + connection.getCatalog());
////		String user=prop.getProperty(user1);
////		String password=prop.getProperty(dbpwd);
////		String database=prop.getProperty(dbname);
////		String Servername=prop.getProperty(servername);
////		
////		String script6="..\\ECGManagerAuto\\Workbook\\HW\\Testdata_final.sql";
//		//String script7="..\\ECGManagerAuto\\Workbook\\HW\\trigger_add_user and assigned group.sql";
//	                //com.microsoft.sqlserver.jdbc.SQLServerDriver
//	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//	   // Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//	//	System.out.println(servername.split("\\.").length);
//		String dbURL = "jdbc:sqlserver://"+servername+" 1433;database="+dbname+";user="+user1+"@"+servername.split("\\.")[0]+";password="+dbpwd+";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;integratedSecurity=true;";
//	//	System.out.println(servername.split(".")[0]);
//		System.out.println(dbURL);
//		Connection conn=null;
//    		try
//    		{//DriverManager.registerDriver(SQLServerDriver());    
//    		//Connection connection = DriverManager.getConnection(connectionUrl);
//    			//DriverManager.registerDriver(SQLServerDriver());
//    			conn = DriverManager.getConnection(dbURL);
//    		} catch (SQLException e) {
//    			// TODO Auto-generated catch block
//    			e.printStackTrace();
//    		}
//    		if (conn!= null) {
//    		    System.out.println("Connected");
//		
//	}
//    		return conn;
//	}
////1july2022
	
		Properties prop=new Properties();
		FileInputStream finp=new FileInputStream(PropertiesFile);
	    prop.load(finp);
	
//		String user=prop.getProperty(user1);
//		String password=prop.getProperty(dbpwd);
//		String database=prop.getProperty(dbname);
//		String Servername=prop.getProperty(servername);
//		
//		String script6="..\\ECGManagerAuto\\Workbook\\HW\\Testdata_final.sql";
		//String script7="..\\ECGManagerAuto\\Workbook\\HW\\trigger_add_user and assigned group.sql";
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	//	System.out.println(servername.split("\\.").length);
//lptcorrectstring//String dbURL = "jdbc:sqlserver://"+servername+":1433;database="+dbname+";user="+user1+"@"+servername.split("\\.")[0]+";password="+dbpwd+";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
            	    //correctDBstring//String dbURL = "jdbc:sqlserver://sqlsrvdmalptat.database.windows.net:1433;database=sqldblpt;user=sqlsrvadmin;password=LdxH@althCl0ud20200820@sqllpt;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=60";	
            	    String dbURL = "jdbc:sqlserver://sqlsrvdmalptstagcn.database.windows.net:1433;database=sqldblpt;user=sqlsrvadmin;password=LdxH@althCl0ud20230420@sqllpt;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=60";
            	    //	System.out.println(servername.split(".")[0]);
		System.out.println(dbURL);
		Connection conn=null;
    		try
    		{
    			conn = DriverManager.getConnection(dbURL);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		if (conn!= null) {
    		    System.out.println("Connected");
		
	}
    		return conn;
	}

 }
	