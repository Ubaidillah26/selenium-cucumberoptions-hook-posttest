package com.juaracoding.shopdemoqa.utils;

public enum TestScenarios {

	T1("User valid Login"),
	T2("User invalid Login"),
	T3("user add item");
	
	private String testName;
	
	TestScenarios(String value) {
		testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
	
}
