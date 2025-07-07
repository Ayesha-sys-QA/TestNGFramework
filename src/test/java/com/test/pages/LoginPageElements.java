package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;
import com.neotech.utils.BrowserSetup;

public class LoginPageElements  {
	
	@FindBy(id="txtUsername")
	public WebElement username;
	@FindBy(id="txtPassword")
	public WebElement password;
	@FindBy(xpath="//button")
	public WebElement loginBtn;
	@FindBy(id ="txtPassword-error")
	public WebElement password_error;
	@FindBy(css="div.toast-message")
	public WebElement texterror;
	
	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	

}
