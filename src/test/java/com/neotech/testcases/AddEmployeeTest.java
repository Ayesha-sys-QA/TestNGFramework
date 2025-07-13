package com.neotech.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.neotech.testbase.Listener;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ExcelUtility;


//If you encounter a test is null issues when running from the class, its because this need the Listener to run
// @Listeners(Listener.class)
public class AddEmployeeTest extends CommonMethods {

	/*
	 Create AddEmployeeTest.java similar to Homework1.java under com/neotech/lesson04 package in TestNG project.
	 
	Follow Page Object Model design pattern, don't find any elements inside the test method!

	Create a Test Method named addEmployee with the following steps:
	Login into the application
	Navigate to PIM and Add Employee
	Provide First Name and Last Name
	Create Login Details
	Provide User Name and Password
	Save the Employee
	Verify Employee has been added successfully
	
	This test method should belong to addEmp group.
	By using @DataProvider, add 3 different employees using Excel.xlsx file.
	
	Create an xml file named addEmp.xml similar to smoke.xml file and execute the xml file.
	*/
	
	
	@Test(dataProvider="excelData", groups= {"addEmployee", "regression"})
	public void addEmployee(String firstName, String lastName, String location, String username, String password)
	{
		/*  NO LONGER NEEEDED - USING PageInitializer
		LoginPageElements loginPage = new LoginPageElements();
		DashboardPageElements dashboardPage = new DashboardPageElements();
		AddEmployeePageElements addEmployeePage = new AddEmployeePageElements();
		PersonalDetailsPageElements personalDetailsPage = new PersonalDetailsPageElements();
		
		
		
		
		*/
		
		test.info("Testing for adding employee: " + firstName + " " + lastName);
		
		
		
		test.info("Logging in....");
		//login to application 
		loginPage.adminLogin();
		
		//Navigate to PIM and Add Employee
		click(dashboardPage.PIM);
		click(dashboardPage.addEmployeeLink);
		
		//Wait for the add employee form to show up
		
		waitForVisibility(addEmployeePage.firstName);
		
		
		test.info("Adding the employee....");
		//Provide First Name and Last Name
		
		sendText(addEmployeePage.firstName, firstName);
		sendText(addEmployeePage.lastName, lastName);
		
		String empId = addEmployeePage.employeeId.getDomProperty("value");
		
		selectDropdown(addEmployeePage.location, location);
		
		//Create Login Details
		click(addEmployeePage.loginDetailsToggle);
		
		sendText(addEmployeePage.username, username);
		sendText(addEmployeePage.password, password);
		sendText(addEmployeePage.confirmPassword, password);
		
		
		wait(2);
		
		click(addEmployeePage.saveBtn);
		
		
		//wait for the personal details page 
		
		waitForVisibility(personalDetailsPage.firstName);
		
		
		//get the employee ID to make sure it is the employee I added
		String actualEmployeeId = personalDetailsPage.employeeId.getDomProperty("value");
		
		test.info("Validating the employee is added...");
		Assert.assertEquals(actualEmployeeId,empId, "Employee ID did not match!!!");
		
	}
	
	@DataProvider
	public Object[][] excelData()
	{
		String path = System.getProperty("user.dir") + "/src/test/resources/testdata/Excel - EmployeeWithLocation.xlsx";
		return ExcelUtility.excelIntoArray(path, "Employee" );
	}
	
}



