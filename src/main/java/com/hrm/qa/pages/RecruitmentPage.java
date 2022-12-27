package com.hrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.BaseTest;

import io.qameta.allure.Step;

public class RecruitmentPage extends BaseTest{

	@FindBy(css="button[class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addButton;
	
	@FindBy(xpath="//*[@name='firstName']")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(css="h6[class*='breadcrumb-module']")
	WebElement recruitmentTitle;
	
	@FindBy(xpath="//*[@class='oxd-select-text oxd-select-text--active']")
	WebElement submitButton1;
	
	@FindBy(xpath="//*[@class='oxd-input oxd-input--active' and @placeholder='Type here'][1]")
	WebElement email;
	
	@FindBy(xpath="//*[@class='oxd-input-group oxd-input-field-bottom-space']//div[2]"
				+ "//input[@placeholder='Type here' and @class='oxd-input oxd-input--active']")
	WebElement contactNum;
	
	@FindBy(css="textarea[class*='textarea']")
	WebElement notesText;
	
	@FindBy(css="*[class*='breadcrumb-module']")
	WebElement  pageTitleText;
	
	public RecruitmentPage()
	{
		PageFactory.initElements(driver, this);
	}
	@Step("addButton step")
	public void clickAddButton()
	{
		addButton.click();
	}
	@Step("enterCandidateFirstName step")
	public String enterCandidateFirstName(String firstname)
	{
		firstName.sendKeys(firstname);
		return firstname;
		
	}
	@Step("enterCandidateLastName step")
	public String enterCandidateLastName(String lastname)
	{
		lastName.sendKeys(lastname);
		return lastname;	
	}

	@Step("validateTitle step")
	public boolean validateTitle()
	{
		return recruitmentTitle.isDisplayed();
		
	}
	@Step("clickSubmitButton1 step")
	public void clickSubmitButton1()
	{ 
		submitButton1.click();
	}
	@Step("selectVacancyType step")
	public WebElement selectVacancyType(String vacancyType)
	{
	return	driver.findElement(By.xpath("//*[@role='listbox']//div[@role='option']//span[text()='"+vacancyType+"']"));

	}
	@Step("enterEmail step")
	public String enterEmail(String useremail)
	{
		email.sendKeys(useremail);
		return useremail;
	}
	@Step("enterContactNum step")
	public String enterContactNum(String contactnumber)
	{
		contactNum.sendKeys(contactnumber);
		return (contactnumber);
	}
	@Step("enterNotes step")
	public String enterNotes(String Notes)
	{
		notesText.sendKeys(Notes);
		return (Notes);

	}
	@Step("pageTitle text")
	public String getPageTitleText()
	{
		return pageTitleText.getText();
	}
	
}
