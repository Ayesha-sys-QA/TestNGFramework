package com.neotech.testcases;

import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.test.pages.LoginPageElements;

public class LoginTest extends CommonMethods {
	
	@Test
	public void validLogin() {
		LoginPageElements login = new LoginPageElements();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		
		click(login.loginBtn);
		
		
	}

}
