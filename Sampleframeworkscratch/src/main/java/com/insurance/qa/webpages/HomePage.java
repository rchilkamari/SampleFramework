package com.insurance.qa.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.insurance.qa.base.TestBase;

public class HomePage extends TestBase  {
	
	WebDriver driver;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/h4[1]")
	@CacheLookup
	WebElement SignedIn;
	
	@FindBy(linkText="Home")
	@CacheLookup
	WebElement TabHome;
	
	@FindBy(linkText="Request Quotation")
	@CacheLookup
	WebElement TabReqQuo;
	
	@FindBy(linkText="Retrieve Quotation")
	@CacheLookup
	WebElement TabRetQuot;
	
	@FindBy(linkText="Profile")
	@CacheLookup
	WebElement TabPro;

	@FindBy(linkText="Edit Profile")
	@CacheLookup
	WebElement TabEditPro;
	
	@FindBy(id="quotation_breakdowncover")
	@CacheLookup
	WebElement LstQuotBreakdown;
	
	@FindBy(id="quotation_windscreenrepair_t")
	@CacheLookup
	WebElement RadWindscreenrepairY;
	
	@FindBy(id="quotation_windscreenrepair_f")
	@CacheLookup
	WebElement RadWindscreenrepairN;
	
	@FindBy (id="quotation_incidents")
	@CacheLookup
	WebElement TxtIncidents;
	
	@FindBy (id="quotation_vehicle_attributes_registration")
	@CacheLookup
	WebElement TxtRegistration;
	
	@FindBy (id="quotation_vehicle_attributes_mileage")
	@CacheLookup
	WebElement TxtAnnualMileage;
	
	@FindBy (id="quotation_vehicle_attributes_value")
	@CacheLookup
	WebElement TxtEstimatedVakue;
	
	@FindBy (id="quotation_vehicle_attributes_parkinglocation")
	@CacheLookup
	WebElement LstParking;
	
	@FindBy (name="year")
	@CacheLookup
	WebElement Lstyear;
	
	@FindBy (name="month")
	@CacheLookup
	WebElement Lstmonth;
	
	@FindBy(name="date")
	@CacheLookup
	WebElement Lstdate;
	
	@FindBy(xpath="//input[@value='Calculate Premium']")
	@CacheLookup
	WebElement BtnCalculatePremium;	
	
	public HomePage(WebDriver driver) {
		
		this.driver =driver;
		
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


