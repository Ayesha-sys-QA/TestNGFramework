package com.neotech.testbase;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;
import com.test.pages.PageInitializer;

public class BaseClass {

	public static WebDriver driver;

	// extent report objects
	public static ExtentSparkReporter sparkReport;
	public static ExtentReports report;
	public static ExtentTest test;

	/**
	 * This method is used to generate the report after all tests are executed. It
	 * uses ExtentReports to create a report of the test execution.
	 */
	@BeforeTest(alwaysRun = true)
	public void generateReport() {
		sparkReport = new ExtentSparkReporter(Constants.REPORT_FILEPATH);
		sparkReport.config().setReportName("Neotech Test Automation Report");
		sparkReport.config().setDocumentTitle("Neotech Test Automation");
		sparkReport.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(sparkReport);
	}

	/**
	 * This method is used to flush the report after all tests are executed. It
	 * ensures that all the test results are written to the report file.
	 */
	@AfterTest(alwaysRun = true)
	public void flushReport() {
		report.flush();
	}

	/*
	 * This method opens the browser and navigates to the url in configs file
	 */
	@BeforeMethod(alwaysRun = true)
	public static void setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String browser = ConfigsReader.getProperty("browser");

		switch (browser.toLowerCase()) {
		case "chrome": {
			driver = new ChromeDriver();
			break;
		}
		case "firefox": {
			driver = new FirefoxDriver();
			break;
		}
		case "edge": {
			driver = new EdgeDriver();
			break;
		}
		default:
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		String url = ConfigsReader.getProperty("url");
		driver.get(url);
		
		PageInitializer.initialize();
	}

	/*
	 * This methods closes the browser
	 */
	@AfterMethod(alwaysRun = true)
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
