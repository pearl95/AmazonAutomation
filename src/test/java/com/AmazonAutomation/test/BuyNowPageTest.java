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

public class BuyNowPageTest extends TestBaseAmazon{
	
	HomePage homePage;
	LoginPage loginPage;
	ProductSearchPage productSearchPage;
	BuyNowPage buyNowPage;
	PaymentPage paymentPage;
	
	public BuyNowPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {
		
		initialization();
		homePage= new HomePage(); 
		loginPage =homePage.homeSignInClick();
		Thread.sleep(1000);
		Map<String,String>exceldata=TestExcelUtil.getData();
		productSearchPage =loginPage.signInAmazon(exceldata.get("username"),exceldata.get("password"));
		
		buyNowPage= productSearchPage.ProductSearchAndClick(exceldata.get("product"));
		
	}
	
	
	@Test(priority=1)
	public void buyNowPageTitleTest() throws InterruptedException
	{
		log.info("****************** starting test case 1 ***********************");
		
		
		
		buyNowPage.childWindowChange();
		String title = buyNowPage.validateBuyNowPageTitle();
		Assert.assertEquals(title, prop.getProperty("buyNowPageTitle"),"Buy Now Page Title is not matched");
		
		
		
		log.info("******** ending test case ******************");
	}
	
	@Test(priority=2)
	public void buyNowClick() throws IOException, InterruptedException
	{
		log.info("****************** starting test case 2 ***********************");
		
		
		
		buyNowPage.childWindowChange();
		paymentPage= buyNowPage.BuyNowClick();
		
		
		
		log.info("******** ending test case ******************");
	}
	
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		
		
		
		
		
		log.info("************* Browser is closed *************************");
	}
	

}
