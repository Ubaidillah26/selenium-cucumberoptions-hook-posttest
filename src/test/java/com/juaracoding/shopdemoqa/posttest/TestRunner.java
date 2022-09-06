package com.juaracoding.shopdemoqa.posttest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

 @CucumberOptions(tags = "",
		 		features={"src/test/resources/1.Login.shop.demoqa.features","src/test/resources/2.Checkout.shop.demoqa.feature"},
				glue="",
				plugin={"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"})
 
public class TestRunner extends AbstractTestNGCucumberTests{

 }
