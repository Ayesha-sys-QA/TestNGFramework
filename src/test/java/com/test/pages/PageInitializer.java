package com.test.pages;

import com.neotech.testbase.BaseClass;
import com.test.pages.AddEmployeePageElements;
import com.test.pages.DashboardPageElements;
import com.test.pages.LoginPageElements;
import com.test.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass {

	
	public static LoginPageElements loginPage;
	public static DashboardPageElements dashboardPage;
	public static AddEmployeePageElements addEmployeePage;
	public static PersonalDetailsPageElements personalDetailsPage;
	
	
	public static void initialize()
	{
		loginPage = new LoginPageElements();
		dashboardPage = new DashboardPageElements();
		addEmployeePage = new AddEmployeePageElements();
		personalDetailsPage = new PersonalDetailsPageElements();
	}

}