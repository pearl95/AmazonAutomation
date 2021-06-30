package com.AmazonAutomation.test;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AmazonAutomation.base.TestBaseAmazon;
import com.AmazonAutomation.pages.HomePage;
import com.AmazonAutomation.pages.LoginPage;
import com.AmazonAutomation.pages.ProductSearchPage;
import com.AmazonAutomation.util.TestExcelUtil;


public class LoginPageTest extends TestBaseAmazon{
	
	HomePage homePage;
	LoginPage loginPage;
	ProductSearchPage productSearchPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		homePage= new HomePage(); 
		loginPage =homePage.homeSignInClick();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		log.info("****************** starting test case 1 ***********************");
		
		
		
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("loginPageTitle"),"Login Page Title is not matched");
		
		
		
		log.info("******** ending test case ******************");
	}
	
	@Test(priority=2)
	public void loginPageSignIn() throws InterruptedException, IOException {
		
		
		log.info("****************** starting test case 2 ***********************");
	
		Map<String,String>exceldata=TestExcelUtil.getData();
		productSearchPage =loginPage.signInAmazon(exceldata.get("username"),exceldata.get("password"));
		
		
		
		log.info("******** ending test case ******************");
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		
		
		log.info("************* Browser is closed *************************");
	}


}
