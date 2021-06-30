package com.AmazonAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AmazonAutomation.base.TestBaseAmazon;

public class HomePage extends TestBaseAmazon {
	
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	WebElement hoverSignIn;
	
	@FindBy(xpath="//span[text()='Sign in']")
	WebElement signInButton;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage homeSignInClick() throws InterruptedException
	{	
		
		Actions act=new Actions(driver);
		act.moveToElement(hoverSignIn).build().perform();
		Thread.sleep(1000);
	
		signInButton.click();
		return new LoginPage();
		
	}

}
