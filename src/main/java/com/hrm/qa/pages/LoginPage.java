package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.BaseTest;

public class LoginPage extends BaseTest{

	
	//page factory elements 
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement userPassword;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement loginButton;
	
	//create constructor of this class
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterLoginCredentials(String usr, String pwd)
	{
		userName.sendKeys(usr);
		userPassword.sendKeys(pwd);
	}
	
	public boolean loginButtonDisplay()
	{
		return loginButton.isDisplayed();
	}
	
	public HomePage clickLoginButton()
	{
		loginButton.click();
		return new HomePage();
	}
	
	
}
