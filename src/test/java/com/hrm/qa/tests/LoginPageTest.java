package com.hrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.BaseTest;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest{

	LoginPage login;
	HomePage home;

	public LoginPageTest()
	{
		super();
	}
		
	@BeforeMethod
	public void launchApplication()
	{	
		launchBrowser(); 
		login = new LoginPage();
	}
	
	@Test(priority=1)
	public void validateLoginPageTitle() throws InterruptedException
	{
		String title = login.validatePageTitle();
		AssertJUnit.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void validateLoginButtonIsPresentAndEnabled()
	{
		AssertJUnit.assertTrue(login.loginButtonDisplay());
	}
	
	@Test(priority=3)
	public void enterCredentials() throws InterruptedException
	{
		login.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		home = login.clickLoginButton();	
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
