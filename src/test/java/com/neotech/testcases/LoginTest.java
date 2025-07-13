package com.neotech.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class LoginTest extends CommonMethods {

	/*	Open chrome browser
		Go to "https://hrm.neotechacademy.com/"
		Login to the application
		Add 3 different Employees and Create Login Details by providing:
		First Name
		Last Name
		Username
		Password
		Verify Employee has been added successfully and take screenshot (you must have 3 different screenshots)
		Close the browser
		Specify a group for this test case, add it into specific suite and execute from the xml file.
*/
	
	@Test(dataProvider="getData", groups = {"homework4", "smoke"})
	public void addEmployee(String firstName, String lastName, String username, String password)
	{
		//we can use this line to make sure that the link between the method and the data provider is ok!!!
		//	System.out.println(firstName + " " + lastName + " " + username + " " + password);
		
		//login 
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.xpath("//button")));
		
		//Go to add Employee
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
		click(driver.findElement(By.linkText("Add Employee")));
		
		//it takes a while to load the add employee form, so we will wait for it 
		waitForVisibility(By.id("first-name-box"));
		
		//enter new employee data 
		sendText(driver.findElement(By.id("first-name-box")), firstName);
		sendText(driver.findElement(By.id("last-name-box")), lastName);
		
		//we could always get this info with the rest of the data 
		selectDropdown(driver.findElement(By.id("location")), "Canadian Regional HQ");
		
		
		//show the login details 
		click(driver.findElement(By.xpath("//div[@class='custom-control custom-switch']")));
		
		//send the login data
		sendText(driver.findElement(By.id("username")), username);
		sendText(driver.findElement(By.id("password")), password); 
		sendText(driver.findElement(By.id("confirmPassword")), password);

		
		//save employee details 
		wait(2);
		click(driver.findElement(By.id("modal-save-button")));
		
		//verify employee details 
		
		//if we take a screenshot right away, we can notice that the info takes a bit to show, so then the screenshot 
		//could happen before the info is shown, hence, useless. So lets wait for the info to show. 
		
		waitForVisibility(By.id("firstName"));
		
		//Lets assert the employee name is the same as the added employee
		
		String actualFirstName = driver.findElement(By.id("firstName")).getDomProperty("value");
		Assert.assertEquals(actualFirstName, firstName, "Employee first name does NOT match!!!!");
		
		
		//take a screenshot: 
	/*	
		//First way: we could do all the steps here
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(source, new File("screenshots/" + firstName + "_" + lastName +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		//we have done this so many times, and we dont want to keep doing this....
		
		//Second way: create a method (on CommonMethods class)
		
		String filename = firstName + "_" + lastName;
		takeScreenshot(filename);
	
	}
	
	
	@DataProvider(name="getData")
	public Object[][] createData()
	{
		Object[][] data = {
				{"EMP001", "L_EMP001", "emp_name_0011111", "empLEMP001!!!"},
				{"EMP002", "L_EMP002", "emp_name_0022222", "empLEMP002!!!"},
				{"EMP003", "L_EMP003", "emp_name_0033333", "empLEMP003!!!"},
		};
		
		return data;
	}
	
	@DataProvider(name="excelData")
	public Object[][] getExcelData()
	{
		
		String filePath = System.getProperty("user.dir") + "/testdata/Excel.xlsx";
		String sheetName = "Employee";
		
		return ExcelUtility.excelIntoArray(filePath, sheetName);
	}
	
	
}