package com.java.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {

	WebDriver driver;
	 public void AddNewCustomer() {
		 
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	
	
	@FindBy(xpath="//*[text()='New Customer']") WebElement newCutomer;
	@FindBy(name="name")WebElement custName;
	@FindBy(name="rad1") WebElement custGender;
	@FindBy(name="dob") WebElement DateOfBirth;
	@FindBy(name="addr") WebElement Address;
	@FindBy(name="city") WebElement City;
	@FindBy(name="state") WebElement State;
	@FindBy(name="pinno") WebElement Pin;
	@FindBy(name="telephoneno") WebElement telephoneNumber;
	@FindBy(name="emailid") WebElement emailId;
	@FindBy(name="sub") WebElement Submit;
	
	
	
	
	
}
