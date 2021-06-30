package com.AmazonAutomation.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AmazonAutomation.base.TestBaseAmazon;


public class BuyNowPage extends TestBaseAmazon{
	
	@FindBy(xpath="//input[@id='buy-now-button']")
	WebElement buyNowButton;
	
	public BuyNowPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateBuyNowPageTitle() {
		return driver.getTitle();
	}
	
	
	public PaymentPage BuyNowClick() throws InterruptedException {
		Thread.sleep(1000);
		buyNowButton.click();
		
		return new PaymentPage();
	}
	
	
public PaymentPage childWindowChange() throws InterruptedException{
		
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}
		}
		
		return new PaymentPage();
		}

}
