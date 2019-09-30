package com.qfund.ncp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TX342F_Almostdone {

	WebDriver driver;
	ExtentTest test;

	By ROUTING_NUMBER_TXT = By.name("routingnbr");
	By RE_ACCOUNT_NUMBER_TXT= By.name("reaccno");
	By RE_ROUTING_NUMBER_TXT= By.name("reroutingnbr");
	By BANK_NAME_TXT = By.name("bankname");
	By ACCOUNT_NUMBER_TXT = By.name("accno");
	By ACCOUNT_TYPE_RADIO = By
			.id("acnttype2");
	By WHERE_CAN_I_FIND_THESE_NUMBERS_BTN = By
			.xpath("/html/body/div[1]/div[2]/div/form/div/div[1]/div[3]/div/p/a/u");
	By NXT_BTN = By.id("nextButton");

	public TX342F_Almostdone(WebDriver driver) {
		this.driver = driver;
	}

	public void almostDone(String RoutingNum, String AccountNum, ExtentTest test)
			throws InterruptedException {

		driver.findElement(ROUTING_NUMBER_TXT).sendKeys(RoutingNum);
		test.log(LogStatus.PASS, "Entered routing number as: " + RoutingNum
				+ " in almostDone page");
		driver.findElement(RE_ROUTING_NUMBER_TXT).sendKeys(RoutingNum);
		test.log(LogStatus.PASS, "Re-entered routing number as: " + RoutingNum
				+ " in almostDone page");
		driver.findElement(ACCOUNT_NUMBER_TXT).sendKeys(AccountNum);
		test.log(LogStatus.PASS, "Entered account number as: " + AccountNum
				+ " in almostDone page");
		driver.findElement(RE_ACCOUNT_NUMBER_TXT).sendKeys(AccountNum);
		test.log(LogStatus.PASS, "Re-entered account number as: " + AccountNum
				+ " in almostDone page");
		driver.findElement(ACCOUNT_TYPE_RADIO).click();
		test.log(LogStatus.PASS,
				"Clicked on account type radio button as 'Savings' in almostDone page");
		Thread.sleep(500);
		driver.findElement(NXT_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Next' button in almostDone page");
		Thread.sleep(500);

	}

}
