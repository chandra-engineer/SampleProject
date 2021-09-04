package com.java.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Configuration {

	public static WebDriver driver;

	public static HashMap<String, String> configData;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void launchApplication(String browser, String env) {
		try {

			browser = (browser != null ? browser : "chrome");

			switch (browser.trim().toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", GlobalVariables.CHROME_DRIVER_PATH);
				driver = new ChromeDriver();
				break;

			case "FireFox":
				System.setProperty("webdriver.chrome.driver", GlobalVariables.FIREFOX_DRIVER_PATH);
				driver = new ChromeDriver();
				break;

			default:
				break;
			}

			String filepath = ConfigFilePath(env);
			configData = readValuesFromConfig(filepath);

			String url = configData.get("baseUrl");
			System.out.println(url);
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public HashMap<String, String> readValuesFromConfig(String filaPath) {
		HashMap<String, String> configData = new HashMap<String, String>();
		Properties pro;
		try {

			File src = new File(filaPath);

			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

			Set<Object> allKeys = pro.keySet();

			for (Object key : allKeys) {

				Object keyValue = pro.get(key);

				configData.put(key.toString().trim(), keyValue.toString().trim());

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println(" Config Data " + configData);
		return configData;

	}

	public String ConfigFilePath(String env) {

		String path = null;

		switch (env.trim().toLowerCase()) {

		case "qa":

			path = GlobalVariables.QAConfigPath;

			break;

		case "dev":

			path = GlobalVariables.DEVConfigPath;

			break;

		case "sit":

			path = GlobalVariables.SITConfigPath;

			break;

		case "uat":

			path = GlobalVariables.UATConfigPath;

			break;
		case "regression":

			path = GlobalVariables.REGRESSIONConfigPath;

			break;

		default:

			System.out.println(" Please provide the valide Environment ");

			break;
		}
		System.out.println(" Config File path " + path);
		return path;

	}

	@org.testng.annotations.AfterSuite
	public void AfterSuite() {
		driver.close();
		driver.quit();
	}

}
