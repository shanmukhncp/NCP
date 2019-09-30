package com.qfund.ncp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TX342F_CreateAccount {
	WebDriver driver;
	ExtentTest test;

	By EMAIL_ID_TXT = By.id("emailId1");
	By Password_TXT = By.id("password");
	By Register_BTN = By.id("register");

	public TX342F_CreateAccount(WebDriver driver) {
		this.driver = driver;

	}

	public void createAccount(String Email_Address, String Password,
			ExtentTest test) throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_ID_TXT));
		driver.findElement(EMAIL_ID_TXT).sendKeys(Email_Address);
		test.log(LogStatus.PASS, "Entered 'email id' as: " + Email_Address
				+ " in Create Account page");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Password_TXT));
		driver.findElement(Password_TXT).sendKeys(Password);
		test.log(LogStatus.PASS, "Entered 'password' as: " + Password
				+ " in Create Account page");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Register_BTN));

		driver.findElement(Register_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on 'Continue' button in Create Account page");
		Thread.sleep(500);
	}
}
