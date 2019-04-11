package com.insurance.qa.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.insurance.qa.base.TestBase;

public class HomePage extends TestBase  {
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/h4[1]")
	WebElement SignedIn;
	
	@FindBy(linkText="Home")
	WebElement TabHome;
	
	@FindBy(linkText="Request Quotation")
	WebElement TabReqQuo;
	
	@FindBy(linkText="Retrieve Quotation")
	WebElement TabRetQuot;
	
	@FindBy(linkText="Profile")
	WebElement TabPro;

	@FindBy(linkText="Edit Profile")
	WebElement TabEditPro;
	
	@FindBy(id="quotation_breakdowncover")
	WebElement LstQuotBreakdown;
	
	@FindBy(id="quotation_windscreenrepair_t")
	WebElement RadWindscreenrepairY;
	
	@FindBy(id="quotation_windscreenrepair_f")
	WebElement RadWindscreenrepairN;
	
	@FindBy (id="quotation_incidents")
	WebElement TxtIncidents;
	
	@FindBy (id="quotation_vehicle_attributes_registration")
	WebElement TxtRegistration;
	
	@FindBy (id="quotation_vehicle_attributes_mileage")
	WebElement TxtAnnualMileage;
	
	@FindBy (id="quotation_vehicle_attributes_value")
	WebElement TxtEstimatedVakue;
	
	@FindBy (id="quotation_vehicle_attributes_parkinglocation")
	WebElement LstParking;
	
	@FindBy (name="year")
	WebElement Lstyear;
	
	@FindBy (name="month")
	WebElement Lstmonth;
	
	@FindBy(name="date")
	WebElement Lstdate;
	
	@FindBy(xpath="//input[@value='Calculate Premium']")
	WebElement BtnCalculatePremium;	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);	
		
		
	}
	
	public String ValidateLogin() {
		
		return SignedIn.getText();
		
	}
	
	public void ValidateRequestQuotation() {		
		
		TabReqQuo.click();				
		
	}
	
	public void SelectQuote() {
		
		Select Quote =new Select(LstQuotBreakdown);
		Quote.selectByValue("Roadside");		
		
	}
	
	public void SetWindScreen() {
		
		RadWindscreenrepairY.click();
		
	}
	
	public void EnterIncidents() {
		
		TxtIncidents.sendKeys("Testing");
		
	}
	
	public void EnterRegistration() {
		
		TxtRegistration.sendKeys("Testing");
		
	}
	public void EnterAnMileage() {
	
		TxtAnnualMileage.sendKeys("Testing");
	
	}
	public void EnterEstValue() {
	
		TxtEstimatedVakue.sendKeys("Testing");
	
	}
	
	public void SelectParkingLoc() {
		
		Select ParkLoc = new Select(LstParking);
		
		ParkLoc.selectByValue("Street/Road");
	}
	
	public void SelectPolicyStart() {
		
		Select Polyear = new Select(Lstyear);
		Select Polmonth = new Select(Lstmonth);
		Select Polday = new Select(Lstdate);
		
		Polyear.selectByValue("2019");
		Polmonth.selectByValue("May");
		Polday.selectByValue("6");			
		BtnCalculatePremium.click();
	}
	
	
}


