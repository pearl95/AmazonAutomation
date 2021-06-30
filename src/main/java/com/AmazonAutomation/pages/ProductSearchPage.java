package com.AmazonAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AmazonAutomation.base.TestBaseAmazon;

public class ProductSearchPage extends TestBaseAmazon{
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement productSearchField;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement searchButton;
	
	@FindBy(linkText="Samsung Galaxy M31 (Ocean Blue, 8GB RAM, 128GB Storage)")
	WebElement productName;
	
	public ProductSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateProductSearchPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateProductSearchPageUser() {
		return driver.getPageSource().contains(prop.getProperty("user"));
	}
	
	public BuyNowPage ProductSearchAndClick(String product) throws InterruptedException {
		Thread.sleep(1000);
	
		
		productSearchField.sendKeys(product);
		Thread.sleep(1000);
		searchButton.click();
		productName.click();
		return new BuyNowPage();
		
	}

}
