package com.qfund.ncp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LendlyProducts {
	 
		WebDriver driver;
		ExtentTest test;
		By STEP_1_REVIEWANDSIGN_BTN = By.xpath("//html/body/div[1]/div[3]/div/div/form/div[1]/div/button");

	public LendlyProducts(WebDriver driver){
		this.driver = driver;
	}
public void apr99(ExtentTest test) throws InterruptedException{
	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div/div/form/div[1]/div/div[6]/button")));
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/form/div[1]/div/div[6]/button")).click();
	test.log(LogStatus.PASS, "Selected product is APR 99%");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[4]/p/button")));
	driver.findElement(By.xpath("/html/body/div[1]/div[4]/p/button")).click();
	test.log(LogStatus.PASS, "Clicked on 'Yes' button for 'Are you exempt from backup withholding of interest by the IRS?' in confirmation page");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pdfAgr")));
	WebElement pdfAgr=driver.findElement(By.id("pdfAgr"));
	driver.switchTo().frame(pdfAgr);
	//driver.findElement(By.xpath("//*[@id='viewerContainer']")).click();

	for(int i=1;i<=55;i++){
		driver.findElement(By.xpath("//*[@id='viewerContainer']")).sendKeys(Keys.PAGE_DOWN);
	System.out.println("Loop"+i);
	}
	test.log(LogStatus.PASS, "scrolled down entire 'New Personal Deposit Account Application' document");
	
	if(driver.findElement(By.xpath("//*[@id='pageContainer9']/div[2]/div[92]")).isDisplayed()){
		System.out.println("LA Displayed");
	}
	driver.switchTo().defaultContent();
	driver.findElement(By.id("checkbox1")).click();
	test.log(LogStatus.PASS, "clicked on terms and conditions checkbox in confirmation page");
	driver.findElement(By.id("checkbox2")).click();
	test.log(LogStatus.PASS, "clicked on Answers to questions checkbox in confirmation page");
	wait.until(ExpectedConditions.elementToBeClickable(By.id("printPayrollDoc")));
	driver.findElement(By.id("printPayrollDoc")).click();
	test.log(LogStatus.PASS, "clicked on submit button in confirmation page");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pdfAgrElec")));
	WebElement pdfAgrElec=driver.findElement(By.id("pdfAgrElec"));
	driver.switchTo().frame(pdfAgrElec);
	driver.findElement(By.xpath("//*[@id='viewerContainer']")).click();
	driver.findElement(By.xpath("//*[@id='viewerContainer']")).sendKeys(Keys.PAGE_DOWN);
	driver.findElement(By.xpath("//*[@id='viewerContainer']")).sendKeys(Keys.PAGE_DOWN);
	driver.findElement(By.xpath("//*[@id='viewerContainer']")).sendKeys(Keys.PAGE_DOWN);
	driver.findElement(By.xpath("//*[@id='viewerContainer']")).sendKeys(Keys.PAGE_DOWN);
	driver.findElement(By.xpath("//*[@id='viewerContainer']")).sendKeys(Keys.PAGE_DOWN);
	driver.findElement(By.xpath("//*[@id='viewerContainer']")).sendKeys(Keys.PAGE_DOWN);
	test.log(LogStatus.PASS, "scrolled down entire 'Consent to Electronic Communications' document");
	if(driver.findElement(By.xpath("//*[@id='pageContainer2']/div[2]/div[195]")).isDisplayed()){
		System.out.println("CTEM Displayed");
	}
	driver.switchTo().defaultContent();
	driver.findElement(By.id("checkboxElecId")).click();
	test.log(LogStatus.PASS, "clicked on 'I have read the Electronic Statement Disclosure Agreement' checkbox in consentElectComm page");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='subBtnn']")));
	driver.findElement(By.xpath("//*[@id='subBtnn']")).click();
	test.log(LogStatus.PASS, "clicked on submit button in consentElectComm page");
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='printDiv']/div/form/div[2]/div[2]/p/button")));
	driver.findElement(By.xpath("//*[@id='printDiv']/div/form/div[2]/div[2]/p/button")).click();
	test.log(LogStatus.PASS, "clicked on ' Continue to my loan' button in 'Congratulations page'");
	wait.until(ExpectedConditions.elementToBeClickable(STEP_1_REVIEWANDSIGN_BTN));
	
}
public void apr199(ExtentTest test){
	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rccDepositDivId']/div/div[6]/button")));
	driver.findElement(By.xpath("//*[@id='rccDepositDivId']/div/div[6]/button")).click();
	test.log(LogStatus.PASS, "Selected product is APR 199%");
}
public String loanInfo(ExtentTest test){
	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div/div/strong/strong/div/div/div[1]/div/span/strong")));
	String string=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/strong/strong/div/div/div[1]/div/span/strong")).getText();
	System.out.println(string.length());       
	String loanNumber=string.substring(string.length()-8, string.length());
	test.log(LogStatus.PASS, "Generated Loan number "+loanNumber);
System.out.println(loanNumber);
	return loanNumber;
}
}
