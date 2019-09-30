package com.qfund.ncp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TX342F_Identify_you_Part1 {

	WebDriver driver;
	ExtentTest test;

	By SSN_TXT = By.id("ssn");
	By Birth_Date_TXT = By.id("dob");
	By offerPopUp=By.xpath("//div[@id='offerPopUp']/div/div/div[3]/div/div[1]/button");
	By Part1_NXT_BTN = By
			.xpath("/html/body/div[1]/div[2]/div/div/form/div[1]/p/button");

	public TX342F_Identify_you_Part1(WebDriver driver) {
		this.driver = driver;
	}

	public void identifyYouPart1(String SSN, String DOB1, String DOB2,
			String DOB3, String Employer,ExtentTest test) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(SSN_TXT).sendKeys(SSN);
		test.log(LogStatus.PASS, "Entered SSN: " + SSN
				+ " in Identify part 1 page");
			Thread.sleep(500);
		
			WebDriverWait wait=new WebDriverWait(driver,60);

			wait.until(ExpectedConditions.visibilityOfElementLocated(Birth_Date_TXT));

		driver.findElement(Birth_Date_TXT).sendKeys(
				DOB1 + "" + DOB2 + "" + DOB3);
		test.log(LogStatus.PASS, "Entered Date of Birth as: " + DOB1 + "/"
				+ DOB2 + "/" + DOB3 + " in Identify part 1 page");
		Thread.sleep(500);
			
		if(!Employer.equalsIgnoreCase("I do not see my employer")){
			driver.findElement(offerPopUp).click();
		}
		else if(Employer.equalsIgnoreCase("I do not see my employer")){
			driver.findElement(Part1_NXT_BTN).click();
			test.log(LogStatus.PASS,"Clicked on 'Next' button in Identify part 1 page");
		}
	}
	public void iAmUsCitizen(ExtentTest test){
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox1")));
		driver.findElement(By.id("checkbox1")).click();
		test.log(LogStatus.PASS,
				"Clicked on 'I am US Citizen' checkbox in Identify part 1 page");
		driver.findElement(Part1_NXT_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on 'Next' button in Identify part 1 page");
		
	}
	public void iAmNotUsCitizen(ExtentTest test){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox2")));
		driver.findElement(By.id("checkbox2")).click();
		test.log(LogStatus.PASS,
				"Clicked on 'I am not US Citizen' checkbox in Identify part 1 page");
		driver.findElement(Part1_NXT_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on 'Next' button in Identify part 1 page");
		
	}

}
