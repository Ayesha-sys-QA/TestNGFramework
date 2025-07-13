# TestNG Automation Framework

This repository showcases an automated testing framework using Java, Selenium WebDriver, TestNG, and Maven. It reflects best practices for reusable test structure, reporting, and test suite management.

## 🔧 Technologies Used
- Java 17+
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- ExtentReports (via Listener)
- Properties File for Config

## 📁 Project Structure
src/test/java/
├── com.test.base → Base setup classes
├── com.test.testcases → TestNG test classes
├── com.test.pages → Page Object classes
├── com.test.utils → Utility classes (config reader, Excel, reports)


Other folders:
- `configs/` → Contains `configuration.properties`
- `screenshots/` → Test failure screenshots (if used)
- `test-output/` → Generated reports (ExtentReports)
- `testng.xml` → Main test suite runner

## ✅ Key Features
- Login and Add Employee test flow
- Soft and Hard Assertions
- Grouping, Priority, Dependencies
- DataProvider usage
- ExtentReports with Listener integration

## 🧪 How to Run
1. Clone this repo
2. Run any suite file (`testng.xml`, `addEmp.xml`, etc.) from Eclipse or terminal
3. Open `test-output/ExtentReport.html` for detailed test results

## 📸 Example Report
_Add a screenshot here if desired for recruiter visibility_



