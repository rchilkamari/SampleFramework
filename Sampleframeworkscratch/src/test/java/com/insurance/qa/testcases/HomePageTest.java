package com.insurance.qa.testcases;

import org.testng.annotations.Test;

import com.insurance.qa.base.TestBase;
import com.insurance.qa.webpages.HomePage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	
	
	@Test
	
	public void HomePageTestFlow() {
		
		homePage = new HomePage();
		
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
