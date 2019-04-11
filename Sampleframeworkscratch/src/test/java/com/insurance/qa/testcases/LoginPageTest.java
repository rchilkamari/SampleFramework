package com.insurance.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.insurance.qa.base.TestBase;
import com.insurance.qa.webpages.HomePage;
import com.insurance.qa.webpages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		
		super(); // To call all the initialization from Base
		homePage = new HomePage();
		
		 loginPage = new LoginPage();
		
	}
	

	@BeforeSuite
	
	public void setUp() {
		
		initialization();
		
		logger=report.createTest("Login to application");
		
		 
		 	
	}
	
	
	@Test(priority=1)
	
	public void loginPageTitle() {
		
		String title = loginPage.ValidatePageTitle();
		Assert.assertEquals(title, "Insurance Broker System - Login");		
		
	}
	
	@Test(priority=2)
	
	public void validatelogo() {
		
		boolean flag = loginPage.Validatelogo();
		Assert.assertTrue(flag);
		
		
	}
	
	@Test(priority=3)
	
	public void logoTextTest() {
		
		String logoText = loginPage.ValidatelogoText();
		Assert.assertEquals(logoText, "Demo Site");
		logger.pass("Logo validation success");
		
	}
	
	@Test(priority=4)
	
	public void LoginTest() {
		logger.info("Starting Application");
		
		
		homePage =loginPage.login(prop.getProperty("login"), prop.getProperty("password"));
		logger.pass("Login Success");
		
	}
	
	
	

	
	
	
	
	
	

}
