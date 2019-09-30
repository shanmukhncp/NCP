package com.qfund.ncp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TX342F_AppLaunch {
	WebDriver driver;
	By loanAmount_btn=By.xpath("//*[@id='carousel1']/div/div/div/a");
	By state_drp=By.id("validationCustom03");
	By next_btn=By.id("homeNext");
	By nextButton_btn = By.id("homeNext1");
	
	public TX342F_AppLaunch(WebDriver driver){
		this.driver=driver;
	}
	
	public void appLaunch(ExtentTest test,String AppURL) throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(AppURL);
		test.log(LogStatus.PASS, " Application Launched With "+AppURL+" URL");
		
		
				
	}
	
	public void loanAmount(ExtentTest test){
		
		WebDriverWait wait=new WebDriverWait(driver,30);		
		wait.until(ExpectedConditions.elementToBeClickable(loanAmount_btn));
		driver.findElement(loanAmount_btn).click();
		test.log(LogStatus.PASS, "Where do you live?? screen loaded");
	}
	
	public void whereDoYouLive(String selectState,ExtentTest test){
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(state_drp));
		Select state = new Select(driver.findElement(state_drp));
		state.selectByVisibleText(selectState);
		test.log(LogStatus.PASS, "State selected is: "+selectState);
		
		wait.until(ExpectedConditions.elementToBeClickable(next_btn));
		driver.findElement(next_btn).click();
		test.log(LogStatus.PASS,
				"Clicked on 'Next' button in Where do you live screen");
	}
	
	public void whereDoYouLiveOtherThanTexas(ExtentTest test){
		
		Select state = new Select(driver.findElement(By
				.id("validationCustom03")));
		state.selectByVisibleText("Indiana");
	test.log(LogStatus.PASS, "State selected is: 'Indiana'");
	driver.findElement(By.id("homeNext")).click();
	test.log(LogStatus.PASS,
			"Clicked on 'Next' button in 'Where do you live' screen");
	test.log(LogStatus.PASS, "NOAA document displayed.Because,the customer is not from the state 'Texas'");
	
	}
}
