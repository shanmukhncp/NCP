package com.qfund.ncp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TX342F_Identify_you_Part2 {

	WebDriver driver;
	ExtentTest test;
	By ID_TYPE_ID_DRP = By.id("validationCustom03");
	By ID_STATE_ISSUED_DRP = By.name("category1");
	By ID_NUMBER_TXT = By.name("idNum");
	By ID_EXPIRATION_DATE = By.id("expDate");
	By ID_NXT_BTN = By.id("color-btn");

	public TX342F_Identify_you_Part2(WebDriver driver) {
		this.driver = driver;
	}

	public void identifyYouPart2(String Employer,String ID_number, String Expiration_Date1,
			String Expiration_Date2, String Expiration_Date3, ExtentTest test,String Issue_Date3,String Issue_Date2,String Issue_Date1)
			throws InterruptedException {
		Thread.sleep(500);
		Select id_type = new Select(driver.findElement(ID_TYPE_ID_DRP));
		test.log(LogStatus.PASS,
				"Selected Id type as 'Passport' in Identify you Part2 page");
		id_type.selectByVisibleText("Passport");
		Thread.sleep(500);
		Select state_issued = new Select(
				driver.findElement(ID_STATE_ISSUED_DRP));
		state_issued.selectByVisibleText("Texas");
		test.log(LogStatus.PASS,
				"Selected state as 'Texas' in Identify you Part2 page");
		driver.findElement(ID_NUMBER_TXT).sendKeys(ID_number);
		test.log(LogStatus.PASS, "Entered Id number as: " + ID_number
				+ " in Identify you Part2 page");
		if(!Employer.equalsIgnoreCase("I do not see my employer")){
		driver.findElement(By.id("issueDate")).sendKeys(Issue_Date1 + "" + Issue_Date2 + ""
						+ Issue_Date3);
		test.log(LogStatus.PASS, "Entered Issued date as: "
				+ Issue_Date1 + "/" + Issue_Date2 + "/"
				+ Issue_Date3 + " in Identify you Part2 page");
		}
		driver.findElement(ID_EXPIRATION_DATE).sendKeys(
				Expiration_Date1 + "" + Expiration_Date2 + ""
						+ Expiration_Date3);
		test.log(LogStatus.PASS, "Entered Expiration date as: "
				+ Expiration_Date1 + "/" + Expiration_Date2 + "/"
				+ Expiration_Date3 + " in Identify you Part2 page");
		
		driver.findElement(ID_NXT_BTN).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on 'Next' button in Identify you Part2 page ");
		

	}
	
	
	
	
	
	
	
	
	
}
