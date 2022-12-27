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
import com.hrm.qa.pages.LeavePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.PIMPage;

public class HomePageTest extends BaseTest{
	
	LoginPage login;
	HomePage home;
	PIMPage pim;
	LeavePage leave;

	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void launchApplication()
	{	
		launchBrowser();
		login = new LoginPage();
		pim = new PIMPage();
		leave = new LeavePage();
		login.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		home = login.clickLoginButton();	
	}
	
	@Test(priority=1)
	public void validateHomePageTitle()
	{
		String title = home.validateHomePageTitle();
		AssertJUnit.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void validateAdminHeadeClickAndTitle() throws InterruptedException
	{
		String adminTitle = home.validateAdminHeader();
		Thread.sleep(2000);
		AssertJUnit.assertEquals(adminTitle, "Admin");
	}
	
	@Test(priority=3)
	public void validatePimPageTabClickAndTitle() throws InterruptedException
	{
		String pimTitle = pim.validatePimPageHeaderTitle();
		Thread.sleep(2000);
		AssertJUnit.assertEquals(pimTitle, "PIM");
	}
	
	@Test(priority=4)
	public void validateLeavePageTabClickAndTitle() throws InterruptedException
	{
		String leaveTitle = leave.validateLeavePageTitle();
		Thread.sleep(2000);
		AssertJUnit.assertEquals(leaveTitle, "Leave");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	} 
	
}
