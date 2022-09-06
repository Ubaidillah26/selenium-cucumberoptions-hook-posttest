package com.juaracoding.shopdemoqa.posttest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.juaracoding.shopdemoqa.driversingleton.DriverSingleton;
import com.juaracoding.shopdemoqa.posttest24.Login;
import com.juaracoding.shopdemoqa.utils.Constant;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class TestLogin {

	public static WebDriver driver;
	private static ExtentTest extentTest;
	private Login login;
	
	public TestLogin() {
		driver = Hook.driver;
		extentTest = Hook.extentTest;
	}
	
	@When("User invalid Login")
	public void user_invalid_login() {
		driver = DriverSingleton.getDriver();
		driver.get(Constant .URLPostTest);
		extentTest.log(LogStatus.PASS, "User invalid Login");
	}
	
	@And("user enter username password")
	public void user_enter_username_password() {
		login.login("ubaidillah.jobs@gmail.com", "ubai123456789");
		extentTest.log(LogStatus.PASS, "User enter username password");
	}
	
	@And("user click button login")
	public void user_click_button_login() {
		login.clickLogin();
		extentTest.log(LogStatus.PASS, "User click button login");
	}
	
	@Then("validate page with scenario")
	public void validate_page_with_scenario(String isValid) {
		if (isValid.equalsIgnoreCase("valid")) {
			String actual = login.validate(isValid);
			assertTrue(actual.contains("your account"));
		}else if(isValid.equalsIgnoreCase("invalid")) {
			String actual = login.validate(isValid);
			assertTrue(actual.contains("is incorrect"));
			extentTest.log(LogStatus.PASS, "User page with scenario");
		}
	}
	
	@After
	public void closeBrowser() {
		delay(1);
		DriverSingleton.closeObjectInstance();
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
	

