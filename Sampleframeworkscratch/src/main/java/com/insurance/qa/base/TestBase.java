package com.insurance.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.insurance.qa.utilities.ReadConfig;
import com.insurance.qa.utilities.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	//public static Properties prop;
//	public static ExtentReports report;
	//public static WebDriver driver;
	public static Logger logger;
	
	ReadConfig readConfig = new ReadConfig();
	@Parameters("browser")
	
	/*public TestBase() {		
		
		try {
		prop =new Properties();
		FileInputStream Fis;
		
			Fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/insurance/qa/config/config.properties");
			prop.load(Fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}*/
	
	@BeforeClass
	
	public void initialization(String br) {		
		
		logger = Logger.getLogger("Insurance Banking");
		PropertyConfigurator.configure("Log4j.properties");
	
		
		/*ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/report.html"));
		report = new ExtentReports();
		report.attachReporter(extent);		*/	
		
		logger.info("Browser called");
		
		//String browserName=prop.getProperty("browser");
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
			driver =new ChromeDriver();
		}
		else if(br.equals("IE")) {
			
			System.setProperty("webdriver.ie.driver",readConfig.getIEPath() );			
			
			driver =new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_WAIT,TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));
		driver.get(readConfig.getApplicationURL());
		
	}
	
	@AfterClass
	
	public void tearDown() {
		
		driver.quit();
		
	}
}
