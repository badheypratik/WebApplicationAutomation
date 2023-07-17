package com.automation.HelperUtilities;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.KeywordDrivenEngine.EngineOperations;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;

public class screnshotcls 
{
	public static String screshotpath;
	public static WebDriver driver;
	public static String TestCasePriority;
	public static String TestCaseName;
	public static int TestCaseStapeNo;
	public screnshotcls(WebDriver mydriver) 	
	{
		driver=mydriver;
		try
    	{	
	        File scrshot=((TakesScreenshot)mydriver).getScreenshotAs(OutputType.FILE);
	    	//String myscreshotpath=Healthview.path+"\\ECGManagerAuto\\seleniumscreenshot\\"+Healthview.TestCaseName.toString()+"\\"+Healthview.TestCaseName.toString()+"_"+"Step#"+(Healthview.TestCaseStapeNo)+".png";
//	        String myscreshotpath=Util.getRelativePath()+"\\"+EngineOperations.mma +".png";
	        //Files.copy(scrshot, new File(myscreshotpath));
//	        screnshotcls.screshotpath=myscreshotpath;       
    	}
		catch(Exception e)
		{
			System.out.println("Exception in screenshot Action : "+e);
//			MasterActionsOld.ExceptionMessage="Exception in screenshot Action : "+e.getMessage().toString();
			if(TestCasePriority.equalsIgnoreCase("P1"))
			{
//				MasterActionsOld.TestCasePriorityRep=true;
			    mydriver.close();
		    }
		}
	}

	public static void compareImage(WebDriver driver, String fileB) 
	{
		screnshotcls screnshotcls=new screnshotcls(driver);
		File fileA=new File( screnshotcls.screshotpath);
		System.out.println("File 1 ::  "+fileA);
		System.out.println("File 2 ::  "+fileB);
		Image image1 = Toolkit.getDefaultToolkit().getImage(screnshotcls.screshotpath);
        Image image2 = Toolkit.getDefaultToolkit().getImage(fileB);
	    float percentage = 0;
	    try 
        {    
            PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);
 
            int[] data1 = null;
 
            if (grab1.grabPixels()) 
            {
                int width = grab1.getWidth();
                int height = grab1.getHeight();
                data1 = new int[width * height];
                data1 = (int[]) grab1.getPixels();
            } 
            int[] data2 = null;
            if (grab2.grabPixels()) 
            {
                int width = grab2.getWidth();
                int height = grab2.getHeight();
                data2 = new int[width * height];
                data2 = (int[]) grab2.getPixels();
            }
            System.out.println("Pixels equal: " + java.util.Arrays.equals(data1, data2));
            if(java.util.Arrays.equals(data1, data2))
            {
            	System.out.println("Images are similar");
            }
            else
            {
            	System.out.println("Images are not similar");
            } 
        } 
	    catch (InterruptedException e1)
	    {
            e1.printStackTrace();
        }	   
	}
	
	public static void NewWindowScreenShot() throws IOException
	{
		//all window
		List<String> myallWindows = new ArrayList<String> (driver.getWindowHandles());
		//switch to child window
		driver.switchTo().window(myallWindows.get(1));
		screnshotcls screnshotcls=new screnshotcls(driver);
		driver.close();
		driver.switchTo().window(myallWindows.get(0));		
		//System.out.println(browserWindows.get(0));
	}
}



