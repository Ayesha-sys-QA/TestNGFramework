# Java + TestNG Automation Framework (HR Portal Sample)


This is a Maven-based TestNG automation framework using Java and Selenium WebDriver. It demonstrates test design with Page Object Model (POM), utility classes, custom listeners, and ExtentReports integration.

## ✅ Features Covered
- Page Object Model
- Login & Add Employee scenarios
- Assertions (Soft and Hard)
- Data-driven testing with DataProvider
- Grouping, prioritization and dependencies
- ExtentReports HTML generation
- Clean test structure for maintainability

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


## 🧪 How to Run
1. Clone this repo
2. Run any suite file (`testng.xml`, `addEmp.xml`, etc.) from Eclipse or terminal
3. Open `test-output/ExtentReport.html` for detailed test results

## 📸 Sample Test Screenshot – Add Employee

This screenshot shows the result of a successful test case for adding an employee in the OrangeHRM demo application using Selenium and TestNG.

![Add Employee Test](https://github.com/Ayesha-sys-QA/TestNGFramework/blob/main/screenshots/passed/addEmployee2025-07-11_21-46-42.png)





