package com.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.java.scripts.Configuration;

public class LoginPage extends Configuration {

//	WebDriver driver;

	@SuppressWarnings("static-access")
	
	LoginPage() {

		this.driver=super.driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(name = "uid")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(name = "btnLogin")
	WebElement loginButton;

	@Test
	public void LoginIntoApplication() {
		PageFactory.initElements(driver, this);
		try {
			username.click();
			username.clear();
			username.click();
			username.sendKeys(configData.get("username"));
			password.click();
			password.clear();
			password.click();
			password.sendKeys(configData.get("password"));
			loginButton.isDisplayed();
			loginButton.click();

			String logout = driver.findElement(By.xpath("//a[text()='Log out']")).getText();

			if (logout.equals("Log out")) {
				System.out.println("Login Page is successfully launched ");
			} else {
				System.out.println("Unabled to login the Application");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
