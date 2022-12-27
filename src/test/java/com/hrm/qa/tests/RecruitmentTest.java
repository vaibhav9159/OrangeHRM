package com.hrm.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import com.hrm.qa.Listeners.AllureTestListener;
import com.hrm.qa.base.BaseTest;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.pages.RecruitmentPage;
import com.hrm.qa.Listeners.RetryAnalyzer;
import com.hrm.qa.utilties.Utils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({AllureTestListener.class})
public class RecruitmentTest extends BaseTest{
	
	LoginPage login;
	HomePage home;
	RecruitmentPage recruitment;
	static WebDriver driver;
	
	public RecruitmentTest()
	{
		super();
	} 
	
	@BeforeMethod
	public void launchApplication()
	{
		launchBrowser();
		login = new LoginPage();
		home = new HomePage();
		recruitment= new RecruitmentPage();
		login.enterLoginCredentials(prop.getProperty("username"), prop.getProperty("password"));
		login.clickLoginButton();
		recruitment= home.recruitmentTabClick();
	}
	
	@Test(priority=1, retryAnalyzer=RetryAnalyzer.class)
	@Description("verify Recruitment Page Title allure desc")
	@Severity(SeverityLevel.NORMAL)
	@Story("validate Title story")
	public void validateRecruitmentPageTitle() throws InterruptedException
	{
		boolean recTitle = recruitment.validateTitle();
		String titleText = recruitment.getPageTitleText();
		Assert.assertTrue(recTitle);
		Thread.sleep(1000);
		Assert.assertEquals(titleText, "Recruitments"); 
		Thread.sleep(1000);
	}
	
	@DataProvider
	public Object[][] getCandidateCreateTestData() throws EncryptedDocumentException, IOException
	{
		Object data [][] = Utils.getCandidateTestData("createcandidate");  // pass the sheet name in param
		return data;
	} 
	
	
	@Test(priority=2, dataProvider="getCandidateCreateTestData")
	@Description("verify create Candidate data")
	@Severity(SeverityLevel.CRITICAL)
	@Story("validate create CandidateData story")
	public void enterCandidateCredentials(String FirstName, String LastName, String VacancyType, String Email, String ContactNumber, String Notes)
			throws InterruptedException
	{	
		recruitment.clickAddButton();
		Thread.sleep(1000);
		recruitment.enterCandidateFirstName(FirstName);
		recruitment.enterCandidateLastName(LastName);
		recruitment.clickSubmitButton1();
		recruitment.selectVacancyType(VacancyType).click();
		Thread.sleep(1000);
		recruitment.enterEmail(Email);
		Thread.sleep(1000);
		recruitment.enterContactNum(ContactNumber);
		Thread.sleep(1000);
		recruitment.enterNotes(Notes);	
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	} 
	
}
