package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;
import com.neotech.utils.BrowserSetup;

public class DashboardPageElements {
	
	@FindBy(id = "ohrm-small-logo")
	public WebElement logo;
	
	@FindBy(id= "account-name")
	public WebElement account_name;

	public DashboardPageElements() {
		
		PageFactory.initElements(BaseClass.driver,this);
		
		
		
	}
}
