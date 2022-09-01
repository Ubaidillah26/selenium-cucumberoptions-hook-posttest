package com.juaracoding.shopdemoqa.posttest;

import org.openqa.selenium.WebDriver;

import com.juaracoding.shopdemoqa.driversingleton.DriverSingleton;
import com.juaracoding.shopdemoqa.utils.Constant;

import io.cucumber.java.*;

public class Hook {

public static WebDriver  driver;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(Constant .CHROME);
		driver = DriverSingleton.getDriver();
	}
	
	@After
	public static void closeBrowser() {
		delay(3);
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
