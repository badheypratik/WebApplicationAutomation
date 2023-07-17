//package com.automation.HelperUtilities;
//
//public class ReportUtil 
//{
//
//}
package com.automation.HelperUtilities;

import java.io.File;
import java.util.List;
//import com.Report.data.InputsToExecuteTC;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

 
 
public class ExtentReportsClass
{
    
	ExtentHtmlReporter htmlReporter ;
    ExtentReports extent;
    public ExtentReportsClass() {
        //System.out.println("In Ctor");
        // TODO Auto-generated method stub
        try {
            htmlReporter = new ExtentHtmlReporter(Util.getRelativePath()+"\\Report.html");
        }
        catch (Exception ex) {
            //System.out.println("in Catch");
            //System.out.println(ex.getMessage());
        }
         
         //System.out.println("html created");
         extent = new ExtentReports();
         extent.attachReporter(htmlReporter);
    }
public void WriteReport(List<String> Steps) {
    // TODO Auto-generated method stub
    // initialize the HtmlReporter
        
        // attach only HtmlReporter
    //System.out.println("Skipped Ctor");
    
        
        ExtentTest test = extent.createTest(Steps.toArray()[0].toString().split(" ")[0] ,Steps.toArray()[0].toString().split(" ")[0]);
        
            for (String step : Steps) {
                //System.out.println(step);
                if(step.contains("Pass"))
                    test.pass(step);
                else
                    test.fail(step);
                
            }
            
            
            
        
        
        
        
        
        
        
        extent.flush();
        
        
    
}
}