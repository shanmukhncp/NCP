package com.qfund.ncp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TX342F_Income {
	WebDriver driver;
	ExtentTest test;
	By NAME_OF_EMPLOYER_TXT=By.name("empname");
	By NET_PAY_FROM_PAYSTUB_TXT=By.name("netpay");
	By PAY_FREQUENCT_DRP =By.name("payFreq");
	By DATE_OF_MONTH_CHK=By.id("empl10");
	By DATE_OF_MONTH_DRP=By.id("income1st0");
	By MONTHLY_INCOME_ADDITIONAL_TXT =By.xpath("//*[@id='other']/div[1]/input");
	By SOURCE_OF_INCOME_ADDITIONAL_TXT=By.xpath("//*[@id='other']/div[2]/input");
	By ADD_ANOTHER_INCOME_CHK=By.id("inlineCheckbox11");
	By MONTHLY_INCOME_2 =By.xpath("//*[@id='checkboxid']/div[1]/input");
	By SOURCE_OF_INCOME_2=By.xpath("//*[@id='checkboxid']/div[2]/input");
	By NXT_BTN=By.xpath("/html/body/div[1]/div[3]/div/div/p/button");
	
	
	public TX342F_Income(WebDriver driver) {
		this.driver=driver;
	}

	public void income(String Employer, String Net_Pay,String Additonal_Income,String Additonal_Income_Source,String Additonal_Income_2,String Additonal_Income_Source_2,ExtentTest test) throws InterruptedException{
		String Employer1;
		Employer1 = driver.findElement(NAME_OF_EMPLOYER_TXT).getAttribute(
				"value");
		if(Employer1.equalsIgnoreCase(Employer)){
			test.log(LogStatus.PASS,
					"Employer name auto populated as: " + Employer1);
		} 
		else {
			test.log(LogStatus.FAIL,
					"Employer name not auto populated as: " + Employer1);
		}
		driver.findElement(NET_PAY_FROM_PAYSTUB_TXT).sendKeys(Net_Pay);
		test.log(LogStatus.PASS, "Enterd Net_Pay $"+Net_Pay+  " in INCOME page");
		Select pay_freq=new Select(driver.findElement(PAY_FREQUENCT_DRP));
		pay_freq.selectByVisibleText("Monthly");
		test.log(LogStatus.PASS, "Selected pay frequency as 'Monthly' in INCOME page");
		driver.findElement(DATE_OF_MONTH_CHK).click();
		test.log(LogStatus.PASS, "Clicked on 'date of month checkbox' in INCOME page");
		Thread.sleep(500);
		Select date_mnth=new Select(driver.findElement(DATE_OF_MONTH_DRP));
		date_mnth.selectByVisibleText("16th");
		test.log(LogStatus.PASS, "Selected Date of month to repay as '16th' in INCOME page");
		driver.findElement(MONTHLY_INCOME_ADDITIONAL_TXT).sendKeys(Additonal_Income);
		test.log(LogStatus.PASS, "Entered monthly income additional as $"+Additonal_Income+ " in INCOME page");
		driver.findElement(SOURCE_OF_INCOME_ADDITIONAL_TXT).sendKeys(Additonal_Income_Source);
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Entered additonal Source of Income as: "+Additonal_Income_Source+ " in INCOME page");
		driver.findElement(ADD_ANOTHER_INCOME_CHK).click();
		test.log(LogStatus.PASS, "Clicked on 'add another income checkbox' in INCOME page");
		driver.findElement(MONTHLY_INCOME_2).sendKeys(Additonal_Income_2);
		test.log(LogStatus.PASS, "Entered monthly income additional 2 as $"+Additonal_Income_2+" in INCOME page");
		driver.findElement(SOURCE_OF_INCOME_2).sendKeys(Additonal_Income_Source_2);
		test.log(LogStatus.PASS, "Entered addtional Source of Income 2 as: "+Additonal_Income_Source_2+ "in INCOME page");
		Thread.sleep(500);
		driver.findElement(NXT_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Next' button in INCOME page");
		Thread.sleep(500);
		
		
	}
	public void income_BiWeekly(String Employer,String Net_Pay,String Additonal_Income,String Additonal_Income_Source,String Additonal_Income_2,String Additonal_Income_Source_2,ExtentTest test) throws InterruptedException{
		String Employer1;
		Employer1 = driver.findElement(NAME_OF_EMPLOYER_TXT).getAttribute(
				"value");
		System.out.println(Employer1);

		if(Employer1.equalsIgnoreCase(Employer)){
			test.log(LogStatus.PASS,
					"Employer name auto populated as: " + Employer1);
		} 
		else {
			test.log(LogStatus.FAIL,
					"Employer name not auto populated as: " + Employer1);
		}
		driver.findElement(NET_PAY_FROM_PAYSTUB_TXT).sendKeys(Net_Pay);
		test.log(LogStatus.PASS, "Enterd Net_Pay $"+Net_Pay+  " in INCOME page");
		Select s1=new Select(driver.findElement(PAY_FREQUENCT_DRP));
		s1.selectByVisibleText("Bi - Weekly");
		test.log(LogStatus.PASS, "Selected pay frequency as 'Bi - Weekly' in INCOME page");
		driver.findElement(By.name("incomeWeekPaid0")).click();
		test.log(LogStatus.PASS, "Selected pay day as 'Tuesday' in INCOME page");
		Thread.sleep(500);
		driver.findElement(By.name("biwk1")).click();
		test.log(LogStatus.PASS, "Selected next pay date in INCOME page");
		Thread.sleep(500);
		driver.findElement(MONTHLY_INCOME_ADDITIONAL_TXT).sendKeys(Additonal_Income);
		test.log(LogStatus.PASS, "Entered monthly income additional as $"+Additonal_Income+ " in INCOME page");
		driver.findElement(SOURCE_OF_INCOME_ADDITIONAL_TXT).sendKeys(Additonal_Income_Source);
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Entered additonal Source of Income as: "+Additonal_Income_Source+ " in INCOME page");
		driver.findElement(ADD_ANOTHER_INCOME_CHK).click();
		test.log(LogStatus.PASS, "Clicked on 'add another income checkbox' in INCOME page");
		driver.findElement(MONTHLY_INCOME_2).sendKeys(Additonal_Income_2);
		test.log(LogStatus.PASS, "Entered monthly income additional 2 as $"+Additonal_Income_2+" in INCOME page");
		driver.findElement(SOURCE_OF_INCOME_2).sendKeys(Additonal_Income_Source_2);
		test.log(LogStatus.PASS, "Entered addtional Source of Income 2 as: "+Additonal_Income_Source_2+ "in INCOME page");
		Thread.sleep(500);
		driver.findElement(NXT_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Next' button in INCOME page");
		Thread.sleep(500);
		
		
	}
	
	public void income_SemiMonthly(String Employer,String Net_Pay,String Additonal_Income,String Additonal_Income_Source,String Additonal_Income_2,String Additonal_Income_Source_2,ExtentTest test) throws InterruptedException{
		String Employer1;
		Employer1 = driver.findElement(NAME_OF_EMPLOYER_TXT).getAttribute(
				"value");
		System.out.println(Employer1);

		if(Employer1.equalsIgnoreCase(Employer)){
			test.log(LogStatus.PASS,
					"Employer name auto populated as: " + Employer1);
		} 
		else {
			test.log(LogStatus.FAIL,
					"Employer name not auto populated as: " + Employer1);
		}
		driver.findElement(NET_PAY_FROM_PAYSTUB_TXT).sendKeys(Net_Pay);
		test.log(LogStatus.PASS, "Enterd Net_Pay $"+Net_Pay+  " in INCOME page");
		Select s=new Select(driver.findElement(PAY_FREQUENCT_DRP));
		s.selectByVisibleText("Semi - Monthly");
		test.log(LogStatus.PASS, "Selected pay frequency as 'Semi - Monthly' in INCOME page");
		driver.findElement(By.id("incomeWeekNxtPaydt20")).click();
		test.log(LogStatus.PASS, "Selected pay date as 'The 1st and 15th day of each month' in INCOME page");
		Thread.sleep(500);
		driver.findElement(MONTHLY_INCOME_ADDITIONAL_TXT).sendKeys(Additonal_Income);
		test.log(LogStatus.PASS, "Entered monthly income additional as $"+Additonal_Income+ " in INCOME page");
		driver.findElement(SOURCE_OF_INCOME_ADDITIONAL_TXT).sendKeys(Additonal_Income_Source);
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Entered additonal Source of Income as: "+Additonal_Income_Source+ " in INCOME page");
		driver.findElement(ADD_ANOTHER_INCOME_CHK).click();
		test.log(LogStatus.PASS, "Clicked on 'add another income checkbox' in INCOME page");
		driver.findElement(MONTHLY_INCOME_2).sendKeys(Additonal_Income_2);
		test.log(LogStatus.PASS, "Entered monthly income additional 2 as $"+Additonal_Income_2+" in INCOME page");
		driver.findElement(SOURCE_OF_INCOME_2).sendKeys(Additonal_Income_Source_2);
		test.log(LogStatus.PASS, "Entered addtional Source of Income 2 as: "+Additonal_Income_Source_2+ "in INCOME page");
		Thread.sleep(500);
		driver.findElement(NXT_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Next' button in INCOME page");
		Thread.sleep(500);
		
		
	}
	public void incomeWeekly(String Employer,String Net_Pay,String Additonal_Income,String Additonal_Income_Source,String Additonal_Income_2,String Additonal_Income_Source_2,ExtentTest test) throws InterruptedException{
		String Employer1;
		Employer1 = driver.findElement(NAME_OF_EMPLOYER_TXT).getAttribute(
				"value");
		System.out.println(Employer1);

		if(Employer1.equalsIgnoreCase(Employer)){
			test.log(LogStatus.PASS,
					"Employer name auto populated as: " + Employer1);
		} 
		else {
			test.log(LogStatus.FAIL,
					"Employer name not auto populated as: " + Employer1);
		}
		driver.findElement(NET_PAY_FROM_PAYSTUB_TXT).sendKeys(Net_Pay);
		test.log(LogStatus.PASS, "Enterd Net_Pay $"+Net_Pay+  " in INCOME page");
		Select s2=new Select(driver.findElement(PAY_FREQUENCT_DRP));
		s2.selectByVisibleText("Weekly");
		test.log(LogStatus.PASS, "Selected pay frequency as 'Weekly' in INCOME page");
		driver.findElement(By.name("incomeWeeklyDay0")).click();
		test.log(LogStatus.PASS, "Selected pay day of the week  as 'Wednesday' in INCOME page");
		Thread.sleep(500);
		driver.findElement(MONTHLY_INCOME_ADDITIONAL_TXT).sendKeys(Additonal_Income);
		test.log(LogStatus.PASS, "Entered monthly income additional as $"+Additonal_Income+ " in INCOME page");
		driver.findElement(SOURCE_OF_INCOME_ADDITIONAL_TXT).sendKeys(Additonal_Income_Source);
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Entered additonal Source of Income as: "+Additonal_Income_Source+ " in INCOME page");
		driver.findElement(ADD_ANOTHER_INCOME_CHK).click();
		test.log(LogStatus.PASS, "Clicked on 'add another income checkbox' in INCOME page");
		driver.findElement(MONTHLY_INCOME_2).sendKeys(Additonal_Income_2);
		test.log(LogStatus.PASS, "Entered monthly income additional 2 as $"+Additonal_Income_2+" in INCOME page");
		driver.findElement(SOURCE_OF_INCOME_2).sendKeys(Additonal_Income_Source_2);
		test.log(LogStatus.PASS, "Entered addtional Source of Income 2 as: "+Additonal_Income_Source_2+ "in INCOME page");
		Thread.sleep(500);
		driver.findElement(NXT_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Next' button in INCOME page");
		Thread.sleep(500);	
	}
	public void incomeOlbnk(ExtentTest test,String Net_Pay) throws InterruptedException{
		
		driver.findElement(By.linkText("Twice a month")).click();
		test.log(LogStatus.PASS, "Selected pay frequency is bi-weekly in income page");
		driver.findElement(By.name("incomeWeekNxtPaydt0")).click();
		test.log(LogStatus.PASS, "selected 'The 1st and 15th day of each month' checkbox in income page");
		driver.findElement(By.name("estYearSal")).clear();
		driver.findElement(By.name("estYearSal")).sendKeys(Net_Pay);
		test.log(LogStatus.PASS, "Entered income amount is: "+Net_Pay);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/form/div/div[2]/p/button")).click();
		test.log(LogStatus.PASS, "Clicked on next button in income page");
		
	}
}