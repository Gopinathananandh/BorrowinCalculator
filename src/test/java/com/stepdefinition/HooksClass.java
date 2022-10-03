package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * 
 * @author 
 * @creationDate 03/10/2022
 * @Description Hook class
 *
 */
public class HooksClass extends BaseClass{


	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @creationDate 03/10/2022
	 * @Description this method run before every scenario
	 */
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {

		getDriver(getPropertyFileValue("browserType"));
		loadUrl(getPropertyFileValue("url"));
		implicitWait(30);
	}

	/**
	 * 
	 * @param scenario
	 * @creationDate 03/10/2022
	 * @Description this method run after every scenario
	 */

	@After
	public void afterScenario(Scenario scenario) {

		TakesScreenshot takescScreenshot = (TakesScreenshot) driver;
		byte[] bs = takescScreenshot.getScreenshotAs(OutputType.BYTES);
		scenario.embed(bs, "hy");

		closeallWindows();
	}
	
}
