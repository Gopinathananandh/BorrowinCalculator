package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun=true,features = "src\\test\\resources\\Feature\\TC1_BorrowCalcuator.feature",monochrome = true,plugin = { "pretty",
"json:target/cucumber.json" }, strict = true, snippets = SnippetType.CAMELCASE,glue = "com.stepdefinition")

/**
 * 
 * @author 
 * @creationDate 03/10/2022
 * @Description integrated Module executed in TestRunnerClass 
 *
 */

public class TestRunner {

	@AfterClass
	public static void afterClass() {

		com.report.Reporting.generateJVMReport(System.getProperty("user.dir") + "/target/cucumber.json");

	
}
}
