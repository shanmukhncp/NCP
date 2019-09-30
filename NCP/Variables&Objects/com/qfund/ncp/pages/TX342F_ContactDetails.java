package com.qfund.ncp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TX342F_ContactDetails {
	WebDriver driver;
	ExtentTest test;

	By Fname_TXT = By.name("fname");
	By Lname_TXT = By.name("lname");
	By Suffix_DRP = By.id("validationCustom03");
	By Type_DRP = By.name("category");
	By Phone_TXT = By.name("phone");
	By SMSTerms_CHK = By
			.xpath("//html/body/div[1]/div[2]/div/div/form/div/div/div[3]/ul/li[1]/div/label");
	By Next_BTN = By.id("contNext");

	public TX342F_ContactDetails(WebDriver driver) {
		this.driver = driver;
	}

	public void contactDetails(String First_name, String Last_name,
			String Phone, ExtentTest test) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Fname_TXT));
		driver.findElement(Fname_TXT).sendKeys(First_name);
		test.log(LogStatus.PASS, "Entered 'firstName' as " + First_name
				+ " in Contact Details page");
		driver.findElement(Lname_TXT).sendKeys(Last_name);
		test.log(LogStatus.PASS, "Entered 'lastName' as " + Last_name
				+ " in Contact Details page");

		Select suffix = new Select(driver.findElement(Suffix_DRP));
		suffix.selectByVisibleText("Sr.");
		test.log(LogStatus.PASS,
				"Selected suffix as 'Sr.' in Contact Details page");

		Select type = new Select(driver.findElement(Type_DRP));
		type.selectByVisibleText("Home");
		test.log(LogStatus.PASS,
				"Selected Phone Type as 'Home' in Contact Details page");

		driver.findElement(Phone_TXT).sendKeys(Phone);
		test.log(LogStatus.PASS, "Entered Phone number is: " + Phone
				+ " in Contact Details page");
//
//		driver.findElement(SMSTerms_CHK).click();
//		test.log(LogStatus.PASS,
//				"Clicked on 'SMS terms CheckBox' in Contact Details page");
//		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(Next_BTN));
		driver.findElement(Next_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on 'Next' button in Contact Details page");
		Thread.sleep(500);

	}
}
