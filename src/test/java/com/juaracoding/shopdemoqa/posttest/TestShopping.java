package com.juaracoding.shopdemoqa.posttest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.juaracoding.shopdemoqa.driversingleton.DriverSingleton;
import com.juaracoding.shopdemoqa.posttest24.PlaceOrder;
import com.juaracoding.shopdemoqa.posttest24.Search;
import com.juaracoding.shopdemoqa.utils.Constant;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class TestShopping {

	public static WebDriver  driver;
	private Search search;
	private PlaceOrder placeOrder;
	
	public TestShopping() {
		driver = Hook.driver;
	}
	
	@When("user navigate to web page")
	public void user_navigate_to_web_page() {
		driver = DriverSingleton.getDriver();
		driver.get(Constant.URLPostTest);
	}
	
	@And("search item")
	public void search_item() {
		search.searchItem("pink");
	}
	
	@And("add item")
	public void add_item() {
		placeOrder.detailProduct("pink");
		placeOrder.checkOut();
	}
	
	@And("user filling billing detail")
	public void user_filling_billing_detail() {
		placeOrder.billingDetails();
		placeOrder.terms();
	}
	
	@And("user place order")
	public void user_place_order() {
		placeOrder.placeOrder();
	}
	
	@Then("validate scenario")
	public void validate_scenario(String isValid) {
		if (isValid.equalsIgnoreCase(isValid)) {
			String actual = placeOrder.getSuccessMessage();
			assertTrue(actual.contains("Your order has been received"));
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
