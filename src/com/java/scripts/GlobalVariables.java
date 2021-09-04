package com.java.scripts;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GlobalVariables {

	public static WebDriver driver;

	public static HashMap<String, String> ConfigData;

	public static String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "//Drivers//chromedriver.exe";

	public static String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "//Drivers//geckodriver.exe";

	public static String QAConfigPath = System.getProperty("user.dir") + "//Configaration//QA.properties";
	public static String DEVConfigPath = System.getProperty("user.dir") + "//Configaration//DEV.properties";
	public static String SITConfigPath = System.getProperty("user.dir") + "//Configaration//SIT.properties";
	public static String UATConfigPath = System.getProperty("user.dir") + "//Configaration//UAT.properties";
	public static String REGRESSIONConfigPath = System.getProperty("user.dir")
			+ "//Configaration//REGRESSION.properties";
}
