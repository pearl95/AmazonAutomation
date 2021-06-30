package com.AmazonAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AmazonAutomation.base.TestBaseAmazon;

public class PaymentPage extends TestBaseAmazon{
	
	@FindBy(xpath="//span[text()='Add Debit/Credit/ATM Card']")
	WebElement newCreditCardRadioButton;
	
	
	@FindBy(xpath="//a[text()='Add a credit or debit card']")
	WebElement newCreditCardlink;
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement cardNumber;
	

	@FindBy(xpath="//select[@name='ppw-expirationDate_month']")
	WebElement monthDropdown;
	
	@FindBy(xpath="//select[@name='ppw-expirationDate_year']")
	WebElement yearDropdown;
	
	
	@FindBy(xpath="//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
	WebElement addCardButton;
	
	@FindBy(xpath="//span[text()='Card number is not correct.']")
	WebElement verificationError;
	
	
	@FindBy(xpath="//input[@type='password']")
	WebElement cvvfield;
	
	@FindBy(xpath="(//input[@type='password'])[5]")
	WebElement cvvfieldmain;
	
	
	
	
	
	
	@FindBy(xpath="//input[@title='Place Your Order and Pay']")
	WebElement placeOrder;
	
	
	
			
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePaymentPageTitle() {
		return driver.getTitle();
	}
	
	public void addCard(String cardNumberValue,String monthValue,String yearValue,String cvv) throws InterruptedException {
		
		
		Thread.sleep(1000);
		newCreditCardRadioButton.click();
		Thread.sleep(1000);
		newCreditCardlink.click();
		Thread.sleep(5000);
		
		driver.switchTo().frame(0);
		cardNumber.sendKeys(cardNumberValue);
		
		Select drpMonth = new Select(monthDropdown);
		drpMonth.selectByVisibleText(monthValue);
		Thread.sleep(1000);
		Select drpYear = new Select(yearDropdown);
		drpYear.selectByVisibleText(yearValue);
		
		addCardButton.click();
	}
		
	//	if(driver.getPageSource().contains("Enter CVV"))
		//{
			//cvvfield.sendKeys(cvv);
		//}////
	
	public boolean verifyCard() {
		
		try {
			
		
		if(verificationError.isDisplayed()) {
			return false;
		}
		else {
			return true;
		}
			
		}catch(NoSuchElementException e) {
		return false;
		}
		
		
	}

		

	}

		

	
		


