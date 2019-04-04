package com.insurance.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.insurance.qa.utility.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
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
		
		
		
		
	}
	
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/Drivers/chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if(browserName.equals("IE")) {
			
			System.setProperty("webdriver.InternerExplorer.driver",System.getProperty("user.dir") +"/Drivers/IEDriverServer.exe");
			driver =new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	

}
