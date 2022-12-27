package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.BaseTest;

public class HomePage extends BaseTest{
	
	
	@FindBy(xpath="//*[@href='/web/index.php/admin/viewAdminModule']//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	WebElement adminTab;
	
	@FindBy(xpath="//*[@href='/web/index.php/admin/viewAdminModule']//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	WebElement adminTitle;
	
	@FindBy(xpath="//*[@class='oxd-main-menu-item-wrapper']//*[@href='/web/index.php/pim/viewPimModule']"
			+ "//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	WebElement pimTab;
	
	@FindBy(xpath="//*[@href='/web/index.php/leave/viewLeaveModule']//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	WebElement leaveTab;
	
	@FindBy(xpath="//*[@href='/web/index.php/recruitment/viewRecruitmentModule']")
	WebElement recruitmentTab;
	
	//create constructor
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String validateAdminHeader()
	{	
		adminTab.click();
		return adminTitle.getText();
	}
	
	public PIMPage PIMPageClick()
	{	
		pimTab.click();
		return new PIMPage();
	}
	
	public LeavePage leaveTabClick()
	{
		leaveTab.click();
		return new LeavePage();
	}
	
	public RecruitmentPage recruitmentTabClick()
	{
		recruitmentTab.click();
		return new RecruitmentPage();
		
	}
	
}
