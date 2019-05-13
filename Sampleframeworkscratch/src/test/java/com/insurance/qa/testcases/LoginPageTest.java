package com.insurance.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.insurance.qa.base.TestBase;
import com.insurance.qa.utilities.ReadConfig;
import com.insurance.qa.webpages.HomePage;
import com.insurance.qa.webpages.LoginPage;
import com.sun.media.jfxmedia.logging.Logger;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ReadConfig readconfig;
	
	public LoginPageTest() {	
		
		super(); // To call all the initialization from Base
		homePage = new HomePage();
		
		 loginPage = new LoginPage();
		 readconfig = new ReadConfig();
		 
	}

	
	@Test(priority=1)
	
	public void loginPageTitle() {
		
		logger.info("Logo validation success");
		
		String title = loginPage.ValidatePageTitle();
		
		Assert.assertEquals(title, "Insurance Broker System - Login");		
		
	}
	
	@Test(priority=4)
	
	public void validatelogo() {
		
		boolean flag = loginPage.Validatelogo();
		Assert.assertTrue(flag);
		
		
	}
	
	@Test(priority=2)
	
	public void logoTextTest() {
		
		String logoText = loginPage.ValidatelogoText();
		Assert.assertEquals(logoText, "Demo Site");
		//logger.pass("Logo validation success");
		
	}
	
	@Test(priority=3)
	
	public void LoginTest() {
		logger.info("Starting Application");
		
		
		homePage =loginPage.login(readconfig.getUsername(), readconfig.getPassword());
		//logger.pass("Login Success");
		
	}
	
	
	

	
	
	
	
	
	

}
