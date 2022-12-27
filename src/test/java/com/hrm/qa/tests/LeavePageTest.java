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

public class LeavePageTest extends BaseTest{
	
	LoginPage login;
	HomePage home;
	PIMPage pim;
	LeavePage leave;

	public LeavePageTest()
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
		leave = home.leaveTabClick();
	}
	
	
	@Test(priority=1)
	public void validateLeavePageTabClickAndTitle() throws InterruptedException
	{
		String leaveTitle = leave.validateLeavePageTitle();
		AssertJUnit.assertEquals(leaveTitle, "Leave");
	}
	
	@Test(priority=2)
	public void selectLeaveMemeberCheckbox() throws InterruptedException
	{
		Thread.sleep(2000);
		leave.selectLeaveMemberCheckbox("Charlie  Carter");	
		leave.selectLeaveMemberCheckbox("Anthony  Nolan");	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	} 
	
}
