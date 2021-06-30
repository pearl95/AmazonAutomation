package com.AmazonAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AmazonAutomation.base.TestBaseAmazon;

public class LoginPage extends TestBaseAmazon{
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement userNameField;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement signInButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public ProductSearchPage signInAmazon(String username,String password) throws InterruptedException 
	{	
	
		userNameField.sendKeys(username);
		continueButton.click();

		passwordField.sendKeys(password);
		signInButton.click();
		
		return new ProductSearchPage();
		
	}

}
