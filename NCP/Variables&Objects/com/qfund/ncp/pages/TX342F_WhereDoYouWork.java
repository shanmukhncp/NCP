package com.qfund.ncp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TX342F_WhereDoYouWork {
	WebDriver driver;
	ExtentTest test;

	By next1_Btn = By.xpath("//*[@id='work1']/div/button");
	By month_Drp = By.name("month");
	By year_Drp = By.name("year");
	By next2_Btn = By.id("workedNext");
	By next_Btn	=	By.xpath("//*[@id='work1']/div/button");	 
	By employerName_Lbl = By.id("tags");

	public TX342F_WhereDoYouWork(WebDriver driver) {

		this.driver = driver;

	}

	public String employeeDetails(String Employer, ExtentTest test) throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(employerName_Lbl));
		driver.findElement(employerName_Lbl).clear();
		driver.findElement(employerName_Lbl).sendKeys(Employer);
		test.log(LogStatus.PASS, "Employer name selected as: "
				+ Employer);

		driver.findElement(next1_Btn).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on 'Next' button in 'Where do you work' screen after employer selection");
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(month_Drp));
		Select month = new Select(driver.findElement(month_Drp));
		month.selectByIndex(1);
		test.log(LogStatus.PASS, "Start month selected is: 'January'");

		wait.until(ExpectedConditions.visibilityOfElementLocated(year_Drp));
		Select year = new Select(driver.findElement(year_Drp));
		year.selectByIndex(5);
		test.log(LogStatus.PASS, "Start year selected is: '2014'");

		wait.until(ExpectedConditions.visibilityOfElementLocated(next2_Btn));
		driver.findElement(next2_Btn).click();
		Thread.sleep(500);
		test.log(
				LogStatus.PASS,
				"Clicked on 'Next' button in 'Where do you work screen' after selecting start month and start year");
		return Employer;
	}
	public void selectEmployer(ExtentTest test,String employerName) throws InterruptedException{
		
		driver.findElement(By.id("tags")).sendKeys(employerName);
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Entered employer name as: "+employerName);
		
		
		driver.findElement(next1_Btn).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,"Clicked on 'Next' button in 'Where do you work' screen after employer selection");

		Select month = new Select(driver.findElement(month_Drp));
		month.selectByIndex(1);
		test.log(LogStatus.PASS, "Start month selected is: 'January'");

		Select year = new Select(driver.findElement(year_Drp));
		year.selectByIndex(5);
		test.log(LogStatus.PASS, "Start year selected is: '2014'");

		driver.findElement(next2_Btn).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,"Clicked on 'Next' button in 'Where do you work' screen after selecting start month and start year");					
	}

public String employeeDetailsWithPromeCode(String Employer,String promoCode, ExtentTest test) throws InterruptedException {
	
	WebDriverWait wait=new WebDriverWait(driver,100);
	wait.until(ExpectedConditions.visibilityOfElementLocated(employerName_Lbl));
	driver.findElement(employerName_Lbl).clear();
	driver.findElement(employerName_Lbl).sendKeys(Employer);
	test.log(LogStatus.PASS, "Employer name selected as: "
			+ Employer);

	driver.findElement(next1_Btn).click();
	Thread.sleep(500);
	test.log(LogStatus.PASS,
			"Clicked on 'Next' button in 'Where do you work' screen after employer selection");

	driver.findElement(By.id("PromoCode")).sendKeys(promoCode);;
	test.log(LogStatus.PASS, "Entered Promocode is: "+promoCode);
	
//	Select month = new Select(driver.findElement(month_Drp));
//	month.selectByIndex(1);
//	test.log(LogStatus.PASS, "Start month selected is: 'January'");
//
//	Select year = new Select(driver.findElement(year_Drp));
//	year.selectByIndex(5);
//	test.log(LogStatus.PASS, "Start year selected is: '2014'");

	driver.findElement(next2_Btn).click();
	Thread.sleep(500);
	test.log(
			LogStatus.PASS,
			"Clicked on 'Next' button in 'Where do you work screen' after selecting start month and start year");
	return Employer;
}
}