package com.mobiotics.hits.constants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mobiotics.hits.commonpages.LoginPage;
import com.mobiotics.hits.utilities.Reporting;

import generic.Property;

public class BaseTest  implements AutomationConstants {
	public Logger log;
	public static WebDriver driver;
	
	public static String url;
	public static String un;
	public static String pw;
	public static String homePageURL;
	public static String loginPageURL;
	public static long timeout;
	
	public static boolean loginRequired=true;
	public static boolean logoutRequired=true;
	
	public BaseTest() {
		
		log=log.getLogger("LOg_ Logger");
		PropertyConfigurator.configure("log4j.properties");
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	}
	
	public void initFrameWork() {
		log.info("initilizing framework");
		url=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "URL");
		un=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "UN");
		pw=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "PW");
		timeout=Long.parseLong(Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "IMPLICIT"));
	}
	
	@BeforeMethod
	public void initApplication() throws Exception {
		initFrameWork();
		System.setProperty(CHROME_KEY, DRIVER_PATH+CHROME_FILE);
		
		String downloadFilepath = "D:\\HITS_REPORTS";
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_setting.popups", 2);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options= new ChromeOptions();
		
		HashMap<String, Object> chromeOptionsMap=new HashMap<String , Object>();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		options.addArguments("--disable-extentions");
		
		
		DesiredCapabilities desiredcapablities=DesiredCapabilities.chrome();
		desiredcapablities.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		desiredcapablities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		desiredcapablities.setCapability(ChromeOptions.CAPABILITY, options);
		driver= new ChromeDriver(desiredcapablities);
		
		
		driver.manage().window().maximize();
		driver.get(url);
		preCondition();
		log.info("TimeOut:"+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	public void preCondition() throws Exception {
		if(loginRequired) {
			log.info("implicit login");
			LoginPage loginpage=new LoginPage();
			loginpage.setUserName(un);
			loginpage.setPassword(pw);
			
			loginpage.clickToProceed();
			Thread.sleep(5000);
			String title=driver.getTitle();
			if(title.contains("Dashboard"))
				
			{
				log.info("user successfully logged in");
			}
			
			else
			{
				log.info("I' reseting the password");
				
			}
			loginRequired=true;
		}
	}
	
	@AfterMethod
	public void shutDown() {
		//driver.quit();
	}
	
	public void postCondition() {
		if(logoutRequired)
		{
			log.info("Implicit logout");
			
		}
		
		
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	

}
