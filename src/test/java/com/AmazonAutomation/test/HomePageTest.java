package com.AmazonAutomation.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AmazonAutomation.base.TestBaseAmazon;
import com.AmazonAutomation.pages.HomePage;
import com.AmazonAutomation.pages.LoginPage;




public class HomePageTest extends TestBaseAmazon{
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
		homePage= new HomePage(); 
	}
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		log.info("****************** starting test case 1 ***********************");
		
		
		
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, prop.getProperty("title"),"Home Page Title is not matched");
		
		
		
		log.info("******** ending test case ******************");
	}
	
	@Test(priority=2)
	public void homePageSignIn() throws InterruptedException, IOException {
		
		
		log.info("****************** starting test case 2 ***********************");
	
		
		loginPage =homePage.homeSignInClick();
		
		
		
		log.info("******** ending test case ******************");
	}
	
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		
		
		log.info("************* Browser is closed *************************");
	}

}
