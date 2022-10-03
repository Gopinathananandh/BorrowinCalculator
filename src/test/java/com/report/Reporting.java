package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author
 * @creationDate 03/10/2022
 * @Description Making report for borrow calculator Automation 
 *
 */
public class Reporting {

	/**
	 * 
	 * @param jsonFile
	 * @creationDate 03/10/2022
	 * @Description generate JVM Report 
	 */
	public static void generateJVMReport(String jsonFile) {

		File file=new File(System.getProperty("user.dir")+"/target");
		
		Configuration config= new Configuration(file, "Home loan borrowing calculator");
		
		config.addClassifications("OS", "Windows11");
		config.addClassifications("Browser", "Chrome");
		config.addClassifications("Version", "10");
		config.addClassifications("Sprint", "33");
		
		List<String> jsonfiles= new ArrayList<String>();
		jsonfiles.add(jsonFile);
		
		ReportBuilder builder= new ReportBuilder(jsonfiles, config);
		
		builder.generateReports();
		
		
	}
}
