package com.juaracoding.shopdemoqa.posttest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;


import com.juaracoding.shopdemoqa.driversingleton.DriverSingleton;
import com.juaracoding.shopdemoqa.utils.Constant;
import com.juaracoding.shopdemoqa.utils.TestScenarios;
import com.juaracoding.shopdemoqa.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.*;

public class Hook {

public static WebDriver  driver;
public static ExtentTest extentTest;
public static ExtentReports reports = new ExtentReports("target/extent-reports.html");

	@Before
	public void setUp() {
		DriverSingleton.getInstance(Constant .CHROME);
		driver = DriverSingleton.getDriver();
		TestScenarios[] tests = TestScenarios.values();
		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}
	
	@AfterStep
	public void getResultStatus(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			String screenshotPath = Utils.getScreenshot(driver, scenario.getName().replace(" ", " "));
			extentTest.log(LogStatus.FAIL, scenario.getName()+"\n"+extentTest.addScreenCapture(screenshotPath));
		}
	}
	
	@After
	public void closeBrowser() {
		reports.endTest(extentTest);
		reports.flush();
	} 
	
	static void delay(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
