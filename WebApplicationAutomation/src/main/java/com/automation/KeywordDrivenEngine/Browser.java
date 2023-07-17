package com.automation.KeywordDrivenEngine;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.HelperUtilities.Util;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser 
{
	public static WebDriver webDriver = null;
	public static WebDriver InitializeBrowser(String requiredBrowser) 
	{
		try
		{
			switch(requiredBrowser)
			{
				case "Chrome":
				{
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
					WebDriverManager.chromedriver().driverVersion("111.0.5563.65").setup();
					System.setProperty("webdriver.chrome.driver", Util.getRelativePath()+"\\chromedriver.exe");
					webDriver = new ChromeDriver(options);
//					System.setProperty("webdriver.chrome.driver", Util.getRelativePath()+"\\chromedriver.exe");
//					webDriver = new ChromeDriver(); 
				}
				break;
				case "IE":
				{
//					System.setProperty("webdriver.ie.driver", Util.getRelativePath()+"\\IEDriverServer.exe");				
//					DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//					caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
//					caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//					caps.setCapability("ignoreZoomSetting", true);
//					caps.setCapability("ignoreProtectedModeSettings", true);
//					caps.setPlatform(Platform.VISTA);
//					caps.setCapability("nativeEvents", false); 
//					webDriver = new InternetExplorerDriver(caps); 
				}
			}
			return webDriver;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
	}
}
