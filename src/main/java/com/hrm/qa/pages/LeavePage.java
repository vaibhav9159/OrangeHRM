package com.hrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.BaseTest;

public class LeavePage extends BaseTest{

	@FindBy(xpath="//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	WebElement leavePageTitle;	
	
	public LeavePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLeavePageTitle()
	{
		leavePageTitle.click();
		return leavePageTitle.getText();
	}
	
	public void selectLeaveMemberCheckbox(String name)
	{
		 driver.findElement(By.xpath("//*[text()='"+name+"']//parent::div[@class='oxd-table-cell oxd-padding-cell']"
				+ "//parent::div[@class='oxd-table-row oxd-table-row--with-border']"
				+ "//div[@class='oxd-table-cell oxd-padding-cell']//div[@class='oxd-table-card-cell-checkbox']//div")).click();
	}
	
}
