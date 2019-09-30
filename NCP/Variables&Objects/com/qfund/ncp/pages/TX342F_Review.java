package com.qfund.ncp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TX342F_Review {

	WebDriver driver;
	ExtentTest test;

	By NXT_BTN = By
			.xpath("/html/body/div[1]/div[3]/div[1]/form/div/div[2]/p/button");
	By STEP_1_REVIEWANDSIGN_BTN = By
			.xpath("//html/body/div[1]/div[3]/div/div/form/div[1]/div/button");

	public TX342F_Review(WebDriver driver) {
		this.driver = driver;
	}

	public void review(ExtentTest test) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 100);
		

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(NXT_BTN)).sendKeys(Keys.PAGE_DOWN);
		wait.until(ExpectedConditions.elementToBeClickable(NXT_BTN));
		driver.findElement(NXT_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Submit' button in Review page");
	//	Thread.sleep(10000);
		//wait.until(ExpectedConditions.elementToBeClickable(STEP_1_REVIEWANDSIGN_BTN));
	}
	public String appInfo(ExtentTest test){
		String appText=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/div/div[1]/div/span/strong")).getText();
		System.out.println(appText);
		String loanNumber=appText.substring(19);
		System.out.println(loanNumber);
		return loanNumber;
	}

}
