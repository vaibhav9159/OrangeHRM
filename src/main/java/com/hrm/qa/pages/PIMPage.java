package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.BaseTest;

public class PIMPage extends BaseTest{
	
	@FindBy(xpath="//*[@href='/web/index.php/pim/viewPimModule']//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	WebElement pimTitle;
	
	public PIMPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatePimPageTitle()
	{
		return driver.getTitle();
	}
	
	public String validatePimPageHeaderTitle()
	{		pimTitle.click();
		return pimTitle.getText();
		 
	}
	
	
	
}
