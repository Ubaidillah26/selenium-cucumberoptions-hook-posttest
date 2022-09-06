package com.juaracoding.shopdemoqa.posttest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.juaracoding.shopdemoqa.driversingleton.DriverSingleton;
import com.juaracoding.shopdemoqa.posttest24.PlaceOrder;
import com.juaracoding.shopdemoqa.posttest24.Search;
import com.juaracoding.shopdemoqa.utils.Constant;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class TestShopping {

	WebDriver  driver;
	private static ExtentTest extentTest;
	private Search search;
	private PlaceOrder placeOrder;
	
	public TestShopping() {
		driver = Hook.driver;
		extentTest = Hook.extentTest;
	}
	
	@When("user navigate to web page")
	public void user_navigate_to_web_page() {
		driver = DriverSingleton.getDriver();
		driver.get(Constant.URLPostTest);
		extentTest.log(LogStatus.PASS, "User navigate to web page");
	}
	
	@And("search item")
	public void search_item() {
		search.searchItem("pink");
		extentTest.log(LogStatus.PASS, "search item");
	}
	
	@And("add item")
	public void add_item() {
		placeOrder.detailProduct("pink");
		placeOrder.checkOut();
		extentTest.log(LogStatus.PASS, "add item");
	}
	
	@And("user filling billing detail")
	public void user_filling_billing_detail() {
		placeOrder.billingDetails();
		placeOrder.terms();
		extentTest.log(LogStatus.PASS, "user filling billing detail");
	}
	
	@And("user place order")
	public void user_place_order() {
		placeOrder.placeOrder();
		extentTest.log(LogStatus.PASS, "user place order");
	}
	
	@Then("validate scenario")
	public void validate_scenario(String isValid) {
		if (isValid.equalsIgnoreCase(isValid)) {
			String actual = placeOrder.getSuccessMessage();
			assertTrue(actual.contains("Your order has been received"));
			extentTest.log(LogStatus.PASS, "validate scenario");
		}
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
