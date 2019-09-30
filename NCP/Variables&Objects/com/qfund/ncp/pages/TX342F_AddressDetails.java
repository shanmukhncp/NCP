package com.qfund.ncp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TX342F_AddressDetails {
	WebDriver driver;
	ExtentTest test;

	By AD_Address_TXT = By.name("street");
	By AD_Apt_TXT = By.name("apt");
	By AD_Zip_TXT = By.id("zip-code");
	By AD_State_DRP = By.id("state");
	By AD_City_TXT = By.name("city");
	By AD_DiffMailADr_CHK = By.xpath("//*[@id='inlineCheckbox11']");
	By AD_Address1_TXT = By.name("street1");
	By AD_Apt1_TXT = By.name("apt1");
	By AD_Zip1_TXT = By.id("zip-code1");
	By AD_State1_DRP = By.xpath("//*[@id='checkboxid']/div[4]/select");
	By AD_City1_TXT = By.name("city1");
	By AD_Next_BTN = By.xpath("//*[@id='addrBtn']/button");
	By AD_0to6Mons_BTN = By.xpath("	//*[@id='longLive']/div/div/p[1]/input[1]");
	By AD_6to12Year_BTN = By.xpath("//*[@id='longLive']/div/div/p[1]/input[2]");
	By AD_1to2Year_BTN = By.xpath("//*[@id='longLive']/div/div/p[1]/input[3]");
	By AD_2PlusYear_BTN = By.xpath("//*[@id='longLive']/div/div/p[2]/input");
	By AD_Next1_BTN = By.xpath("//*[@id='addrBtn']/button");

	public TX342F_AddressDetails(WebDriver driver) {
		this.driver = driver;
	}

	public void addressDetails(String selectState,String Address, String Apt, String ZipCode,
			String City, ExtentTest test) throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AD_Address_TXT));
		driver.findElement(AD_Address_TXT).sendKeys(Address);
		test.log(LogStatus.PASS, "Entered 'Street address' as: " + Address
				+ " in Address Details page");
		
		driver.findElement(AD_Apt_TXT).sendKeys(Apt);
		test.log(LogStatus.PASS, "Entered 'Apartment' details as " + Apt
				+ " in Address Details page");
		
		driver.findElement(AD_Zip_TXT).sendKeys(ZipCode);
		test.log(LogStatus.PASS, "Entered 'ZipCode' is: " + ZipCode
				+ " in Address Details page");
		
		Select state = new Select(driver.findElement(AD_State_DRP));
		state.selectByVisibleText(selectState);
		test.log(LogStatus.PASS,
				"Selected state as: "+selectState+" from dropdown in Address Details page");
		
		driver.findElement(AD_City_TXT).sendKeys(City);
		test.log(LogStatus.PASS, "Entered 'City' as: " + City
				+ " in Address Details page");
	}
	
	public void differentAddressDetails(String selectState,String Address1, String Apt1,
			String ZipCode1, String City1, ExtentTest test)
			throws InterruptedException {
		
		
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AD_DiffMailADr_CHK));
		
		driver.findElement(AD_DiffMailADr_CHK).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on 'differentMailAddress Checkbox'");
		
		driver.findElement(AD_Address1_TXT).sendKeys(Address1);
		test.log(LogStatus.PASS, "Entered 'Street address' as: " + Address1
				+ " in Address Details page");
		
		driver.findElement(AD_Apt1_TXT).sendKeys(Apt1);
		test.log(LogStatus.PASS, "Entered 'Apartment details' as: " + Apt1
				+ " in Address Details page");
		
		driver.findElement(AD_Zip1_TXT).sendKeys(ZipCode1);
		test.log(LogStatus.PASS, "Entered 'ZipCode' is: " + ZipCode1
				+ " in Address Details page");
		
		Select state1 = new Select(driver.findElement(AD_State1_DRP));
		test.log(LogStatus.PASS,
				"Selected state as: "+selectState+" from dropdown in Address Details page");
		state1.selectByVisibleText(selectState);
		Thread.sleep(500);
		
		driver.findElement(AD_City1_TXT).sendKeys(City1);
		test.log(LogStatus.PASS, "Entered 'City' as: " + City1
				+ " in Address Details page");
	}

public void addressNext(ExtentTest test) throws InterruptedException {

	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.visibilityOfElementLocated(AD_Next_BTN));
	
	
	driver.findElement(AD_Next_BTN).click();
		test.log(
				LogStatus.PASS,
				"Clicked on 'Next' button in Address Details page before how long you live button");
		Thread.sleep(500);
	}

	public void months0To6(ExtentTest test) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,60);
		
	((RemoteWebDriver) driver).executeScript("window.scrollBy(0,1000)", "");
	wait.until(ExpectedConditions.visibilityOfElementLocated(AD_0to6Mons_BTN));
		driver.findElement(AD_0to6Mons_BTN).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on '0-6 months' button(how long you live) in Address Details page");

		WebElement element = driver.findElement(AD_Next1_BTN);
		Actions action = new Actions(driver);	
		action.moveToElement(element).sendKeys(Keys.PAGE_DOWN).build()
		.perform();
		Thread.sleep(500);
		int btn_size = driver.findElements(
				By.xpath("//*[@id='addrBtn']/button")).size();
	
	WebElement element1=driver.findElements(By.xpath("//*[@id='addrBtn']/button"))
				.get(btn_size - 1);
	element1.click();
		test.log(LogStatus.PASS,
				"Clicked on 'Next' button in Address Details page");
		Thread.sleep(500);

	}

	public void months6To12(ExtentTest test) throws InterruptedException {

		driver.findElement(AD_6to12Year_BTN).click();
		Thread.sleep(500);
		driver.findElement(AD_Next1_BTN).click();
		Thread.sleep(500);

	}

	public void months1To2(ExtentTest test) throws InterruptedException {

		driver.findElement(AD_1to2Year_BTN).click();
		Thread.sleep(500);
		driver.findElement(AD_Next1_BTN).click();
		Thread.sleep(500);

	}

	public void months2Plus(ExtentTest test) throws InterruptedException {

		driver.findElement(AD_2PlusYear_BTN).click();
		Thread.sleep(500);
		driver.findElement(AD_Next1_BTN).click();
		Thread.sleep(500);

	}

}
