package com.AmazonAutomation.test;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AmazonAutomation.base.TestBaseAmazon;
import com.AmazonAutomation.pages.BuyNowPage;
import com.AmazonAutomation.pages.HomePage;
import com.AmazonAutomation.pages.LoginPage;
import com.AmazonAutomation.pages.PaymentPage;
import com.AmazonAutomation.pages.ProductSearchPage;
import com.AmazonAutomation.util.TestExcelUtil;

public class PaymentPageTest extends TestBaseAmazon{
	
	HomePage homePage;
	LoginPage loginPage;
	ProductSearchPage productSearchPage;
	BuyNowPage buyNowPage;
	PaymentPage paymentPage;
	
	
	public PaymentPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {
		
		initialization();
		homePage= new HomePage(); 
		Thread.sleep(1000);
		loginPage =homePage.homeSignInClick();
		Thread.sleep(1000);
		Map<String,String>exceldata=TestExcelUtil.getData();
		productSearchPage =loginPage.signInAmazon(exceldata.get("username"),exceldata.get("password"));
		
		buyNowPage= productSearchPage.ProductSearchAndClick(exceldata.get("product"));
		buyNowPage.childWindowChange();
		paymentPage= buyNowPage.BuyNowClick();
		
	}
	
	
	@Test(priority=1)
	public void paymentPageTitleTest() throws InterruptedException
	{
		log.info("****************** starting test case 1 ***********************");
		
		
		
	
		String title = paymentPage.validatePaymentPageTitle();
		Assert.assertEquals(title, prop.getProperty("paymentPageTitle"),"Payment Page Title is not matched");
		
		
		
		log.info("******** ending test case ******************");
	}
	
	
	@Test(priority=2)
	public void paymentActivity() throws IOException, InterruptedException
	{
		log.info("****************** starting test case 2 ***********************");
		
		paymentPage.addCard(prop.getProperty("cardNumber"), prop.getProperty("monthValue"), prop.getProperty("yearValue"),prop.getProperty("cvv"));
		
		String text =paymentPage.verifyCard();
		Assert.assertEquals(text, "Card number is not correct.","card number is valid");
		
		log.info("******** ending test case ******************");
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		
		
		log.info("************* Browser is closed *************************");
	}

}
