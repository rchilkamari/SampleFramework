package com.insurance.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.insurance.qa.base.TestBase;
import com.insurance.qa.webpages.HomePage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	WebDriver driver;
	
	
	@Test
	
	public void HomePageTestFlow() {
		
		homePage = new HomePage(driver);
		
		homePage.SelectQuote();
		homePage.SetWindScreen();
		homePage.EnterIncidents();
		homePage.EnterRegistration();
		homePage.EnterAnMileage();
		homePage.EnterEstValue();
		homePage.SelectParkingLoc();
		homePage.SelectPolicyStart();				
		
	}
	
	

}
