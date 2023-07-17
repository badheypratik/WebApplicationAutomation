package com.automation.HVAtests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import com.automation.HelperUtilities.ExcelUtil;
import com.automation.HelperUtilities.ExtentReportsClass;
import com.automation.HelperUtilities.InputsToExecuteTC;
import com.automation.HelperUtilities.InputsToInitiateTC;
import com.automation.HelperUtilities.WebAppInitializer;
import com.automation.KeywordDrivenEngine.EngineOperations;
import com.google.common.collect.Table;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;

public class RegressionTest
{	
  @Test
  public void Test() throws MessagingException, IOException 
  { 
	  WebAppInitializer.InitializeInputParameters();
	  EngineOperations.executeAutomatedTCs(WebAppInitializer.webApplicationToTest);
  }
}

