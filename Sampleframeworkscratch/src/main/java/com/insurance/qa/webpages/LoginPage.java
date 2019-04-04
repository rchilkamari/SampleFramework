package com.insurance.qa.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.insurance.qa.base.TestBase;

public class LoginPage extends TestBase {
	//WebDriver driver;
	
	//PageFactory-OR
	
	@FindBy(id="email")
	WebElement Txtlogin;
	
	@FindBy(id="password")
	WebElement Txtpassword;
	
	@FindBy(name="submit")
	WebElement Btnlogin;
	
	@FindBy(linkText="Register")
	WebElement LnkRegister;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
	WebElement Gurulogo;
	
	@FindBy(xpath ="//div[@id='site-name']/a[1]")
	WebElement LogoText;
	
	public LoginPage() {
		
		PageFactory.initElements(driver,this);
		
		
	}
	
	public String ValidatePageTitle() {
		
		return driver.getTitle();
	}
	
	
	public boolean Validatelogo() {
		return Gurulogo.isDisplayed();
		
	}

	public String ValidatelogoText() {
		
		return LogoText.getText();
	}
	
	public HomePage login(String uname,String pwd) {
		
		Txtlogin.sendKeys(uname);
		Txtpassword.sendKeys(pwd);
		Btnlogin.click();
		return new HomePage();
	}
	
}
