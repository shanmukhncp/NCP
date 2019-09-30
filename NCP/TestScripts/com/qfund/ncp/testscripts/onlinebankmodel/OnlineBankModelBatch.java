package com.qfund.ncp.testscripts.onlinebankmodel;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import com.qfund.ncp.pages.LMS;
import com.qfund.ncp.pages.LendlyProducts;
import com.qfund.ncp.pages.TX342F_AddressDetails;
import com.qfund.ncp.pages.TX342F_Almostdone;
import com.qfund.ncp.pages.TX342F_AppLaunch;
import com.qfund.ncp.pages.TX342F_ContactDetails;
import com.qfund.ncp.pages.TX342F_CreateAccount;
import com.qfund.ncp.pages.TX342F_Identify_you_Part1;
import com.qfund.ncp.pages.TX342F_Identify_you_Part2;
import com.qfund.ncp.pages.TX342F_Income;
import com.qfund.ncp.pages.TX342F_LMS;
import com.qfund.ncp.pages.TX342F_Review;
import com.qfund.ncp.pages.TX342F_Steps_away_from_$1000;
import com.qfund.ncp.pages.TX342F_WhereDoYouWork;
import com.qfund.ncp.utils.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OnlineBankModelBatch {
	static ExtentReports reports;
	ExtentTest test;
	WebDriver driver;

	@BeforeClass
	public synchronized void initialize() throws Exception {
		
		String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
		
		String filename = "Online_Bank_Model  " + timestamp + ".html";
		reports = new ExtentReports(System.getProperty("user.dir")
				+ "/ExecutionReports/"+ "/Online Bank Model/"+ filename, true);
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	 
		
		driver.manage().deleteAllCookies();	
	}
	
	
	@Test(priority=0)
	public void usCitizen99APR() throws Exception {

	
		
		test = reports.startTest(
"Online_Bank_Model_TS_001","New Loan_OH state_Select US Citizen checkbox --> Select APR 99% product --> Originate Loan");
		
		String FileName = "OnlineBankModel.xls";
		Excel TestData = new Excel(System.getProperty("user.dir")
				+ "/Testdata/" + FileName);
		int lastrow = TestData.getLastRow("TS_001");
		String sheetName = "TS_001";
		for (int row = 2; row <= lastrow; row++) {
			
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				
				String Email_Address = TestData.getCellData(sheetName,
						"Email_Address", row);
				String Password = TestData.getCellData(sheetName, "Password",
						row);
				String First_name = TestData.getCellData(sheetName,
						"First_name", row);
				String Last_name = TestData.getCellData(sheetName, "Last_name",
						row);
				String Address = TestData
						.getCellData(sheetName, "Address", row);
				String Apt = TestData.getCellData(sheetName, "Apt", row);
				String ZipCode = TestData
						.getCellData(sheetName, "ZipCode", row);
				String City = TestData.getCellData(sheetName, "City", row);
				String Address1 = TestData.getCellData(sheetName, "Address1",
						row);
				String Apt1 = TestData.getCellData(sheetName, "Apt1", row);
				String ZipCode1 = TestData.getCellData(sheetName, "ZipCode1",
						row);
				String City1 = TestData.getCellData(sheetName, "City1", row);
				String Phone = TestData.getCellData(sheetName, "Phone", row);
				String ID_number = TestData.getCellData(sheetName, "ID_number",
						row);
				String Expiration_Date1 = TestData.getCellData(sheetName,
						"Expiration_Date1", row);
				String Expiration_Date2 = TestData.getCellData(sheetName,
						"Expiration_Date2", row);
				String Expiration_Date3 = TestData.getCellData(sheetName,
						"Expiration_Date3", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String DOB1 = TestData.getCellData(sheetName, "DOB1", row);
				String DOB2 = TestData.getCellData(sheetName, "DOB2", row);
				String DOB3 = TestData.getCellData(sheetName, "DOB3", row);

				String Net_Pay = TestData
						.getCellData(sheetName, "Net_Pay", row);
				
				String AccountNum = TestData.getCellData(sheetName,
						"AccountNum", row);
				String RoutingNum = TestData.getCellData(sheetName,
						"RoutingNum", row);
				String LMS_UserName = TestData.getCellData(sheetName,
						"LMS_UserName", row);
				String LMS_Password = TestData.getCellData(sheetName,
						"LMS_Password", row);
				String selectState=TestData.getCellData(sheetName, "selectState", row);
				String csoSelect=TestData.getCellData(sheetName, "csoSelect", row);

				String authLMS_URL=TestData.getCellData(sheetName, "authLMS_URL", row);
				String Employer=TestData.getCellData(sheetName, "Employer", row);	
				String Issue_Date3=TestData.getCellData(sheetName, "Issue_Date3", row);	
				String Issue_Date2=TestData.getCellData(sheetName, "Issue_Date2", row);	
				String Issue_Date1=TestData.getCellData(sheetName, "Issue_Date3", row);	
				String authLMS_userName = TestData.getCellData(sheetName,
						"authLMS_userName", row);
				String authLMS_password = TestData.getCellData(sheetName,
						"authLMS_password", row);			
				
				TX342F_AppLaunch appLaunch=new TX342F_AppLaunch(driver);
				appLaunch.appLaunch(test, AppURL);
				

				TX342F_WhereDoYouWork wdw = new TX342F_WhereDoYouWork(driver);
				wdw.employeeDetails(Employer, test);
				
				

				TX342F_CreateAccount cac = new TX342F_CreateAccount(driver);
				cac.createAccount(Email_Address, Password, test);

			

				TX342F_ContactDetails cd = new TX342F_ContactDetails(driver);
				cd.contactDetails(First_name, Last_name, Phone, test);

				TX342F_AddressDetails ad = new TX342F_AddressDetails(driver);
				ad.addressDetails(selectState, Address, Apt, ZipCode, City, test);
				ad.differentAddressDetails(selectState, Address1, Apt1, ZipCode1, City1, test);
				ad.addressNext(test);
				ad.months0To6(test);

				

				TX342F_Identify_you_Part1 id1 = new TX342F_Identify_you_Part1(driver);

				id1.identifyYouPart1(SSN, DOB1, DOB2, DOB3, Employer, test);;
				id1.iAmUsCitizen(test);

				
				TX342F_Identify_you_Part2 id2 = new TX342F_Identify_you_Part2(driver);
		id2.identifyYouPart2(Employer, ID_number, Expiration_Date1, Expiration_Date2, Expiration_Date3, test, Issue_Date3, Issue_Date2, Issue_Date1);;

				
				TX342F_Income inc = new TX342F_Income(driver);
				inc.incomeOlbnk(test, Net_Pay);
				
				
				TX342F_Almostdone almtdn = new TX342F_Almostdone(driver);

				almtdn.almostDone(RoutingNum, AccountNum, test);

				
				TX342F_Review rev = new TX342F_Review(driver);
				rev.review(test);

				LendlyProducts lp=new LendlyProducts(driver);
				lp.apr99(test);
				TX342F_Steps_away_from_$1000 s=new TX342F_Steps_away_from_$1000(driver);
				s.stepOne(test);
				s.loanApplicationAccept(test);
				s.scheduleAgreementAccept(test);
				s.loanNoteAccept(test);
				s.noteOfCancellationAccept(test);
				s.payRollAuthorizationAccept(test);
				s.ACHAuthorizationAccept(test);
				s.customerSignOlBnk(First_name, Last_name, test);
				String loanNumber = s.olBnkStep2(test);
				System.out.println(loanNumber);
				if (loanNumber != null && !"".equalsIgnoreCase(loanNumber)
						&& !"null".equalsIgnoreCase(loanNumber)) {
				
					TX342F_LMS lms=new TX342F_LMS(driver);
					lms.lmsLogin(authLMS_URL, LMS_UserName, LMS_Password, test);
					lms.authorizedDocsValidationOlBnkAuth(csoSelect, loanNumber, test);
					lms.authorizedLmsLogin(authLMS_URL, authLMS_userName, authLMS_password, test);
					lms.authorizedDisburseFundsOlBnk(csoSelect, loanNumber, test);
				}
				else {
					test.log(LogStatus.FAIL, "Loan number not generated");
				}
			}
			
		}
	}
	
	@Test(priority=1)
	public void usCitizen199APROhio() throws Exception {

	
		
		test = reports.startTest(
"Online_Bank_Model_TS_002","New Loan_OH state_Select US Citizen checkbox --> Select APR 199% product --> Originate Loan");
		
		String FileName = "OnlineBankModel.xls";
		Excel TestData = new Excel(System.getProperty("user.dir")
				+ "/TestData/" + FileName);
		int lastrow = TestData.getLastRow("TS_002");
		String sheetName = "TS_002";
		for (int row = 2; row <= lastrow; row++) {
			
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				
				String Email_Address = TestData.getCellData(sheetName,
						"Email_Address", row);
				String Password = TestData.getCellData(sheetName, "Password",
						row);
				String First_name = TestData.getCellData(sheetName,
						"First_name", row);
				String Last_name = TestData.getCellData(sheetName, "Last_name",
						row);
				String Address = TestData
						.getCellData(sheetName, "Address", row);
				String Apt = TestData.getCellData(sheetName, "Apt", row);
				String ZipCode = TestData
						.getCellData(sheetName, "ZipCode", row);
				String City = TestData.getCellData(sheetName, "City", row);
				String Address1 = TestData.getCellData(sheetName, "Address1",
						row);
				String Apt1 = TestData.getCellData(sheetName, "Apt1", row);
				String ZipCode1 = TestData.getCellData(sheetName, "ZipCode1",
						row);
				String City1 = TestData.getCellData(sheetName, "City1", row);
				String Phone = TestData.getCellData(sheetName, "Phone", row);
				String ID_number = TestData.getCellData(sheetName, "ID_number",
						row);
				String Expiration_Date1 = TestData.getCellData(sheetName,
						"Expiration_Date1", row);
				String Expiration_Date2 = TestData.getCellData(sheetName,
						"Expiration_Date2", row);
				String Expiration_Date3 = TestData.getCellData(sheetName,
						"Expiration_Date3", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String DOB1 = TestData.getCellData(sheetName, "DOB1", row);
				String DOB2 = TestData.getCellData(sheetName, "DOB2", row);
				String DOB3 = TestData.getCellData(sheetName, "DOB3", row);

				String Net_Pay = TestData
						.getCellData(sheetName, "Net_Pay", row);
				
				String AccountNum = TestData.getCellData(sheetName,
						"AccountNum", row);
				String RoutingNum = TestData.getCellData(sheetName,
						"RoutingNum", row);
				String LMS_UserName = TestData.getCellData(sheetName,
						"LMS_UserName", row);
				String LMS_Password = TestData.getCellData(sheetName,
						"LMS_Password", row);
				String selectState=TestData.getCellData(sheetName, "selectState", row);
				String csoSelect=TestData.getCellData(sheetName, "csoSelect", row);

				String authLMS_URL=TestData.getCellData(sheetName, "authLMS_URL", row);
				String Employer=TestData.getCellData(sheetName, "Employer", row);	
				String Issue_Date3=TestData.getCellData(sheetName, "Issue_Date3", row);	
				String Issue_Date2=TestData.getCellData(sheetName, "Issue_Date2", row);	
				String Issue_Date1=TestData.getCellData(sheetName, "Issue_Date3", row);	

				TX342F_AppLaunch appLaunch=new TX342F_AppLaunch(driver);
				appLaunch.appLaunch(test, AppURL);
				

				TX342F_WhereDoYouWork wdw = new TX342F_WhereDoYouWork(driver);
				wdw.employeeDetails(Employer, test);
				
				

				TX342F_CreateAccount cac = new TX342F_CreateAccount(driver);
				cac.createAccount(Email_Address, Password, test);

			

				TX342F_ContactDetails cd = new TX342F_ContactDetails(driver);
				cd.contactDetails(First_name, Last_name, Phone, test);

				TX342F_AddressDetails ad = new TX342F_AddressDetails(driver);
				ad.addressDetails(selectState, Address, Apt, ZipCode, City, test);
				ad.differentAddressDetails(selectState, Address1, Apt1, ZipCode1, City1, test);
				ad.addressNext(test);
				ad.months0To6(test);

				

				TX342F_Identify_you_Part1 id1 = new TX342F_Identify_you_Part1(driver);

				id1.identifyYouPart1(SSN, DOB1, DOB2, DOB3, Employer, test);;
				id1.iAmUsCitizen(test);

				
				TX342F_Identify_you_Part2 id2 = new TX342F_Identify_you_Part2(driver);
		id2.identifyYouPart2(Employer, ID_number, Expiration_Date1, Expiration_Date2, Expiration_Date3, test, Issue_Date3, Issue_Date2, Issue_Date1);;

				
				TX342F_Income inc = new TX342F_Income(driver);
				inc.incomeOlbnk(test, Net_Pay);
				
				
				TX342F_Almostdone almtdn = new TX342F_Almostdone(driver);

				almtdn.almostDone(RoutingNum, AccountNum, test);

				
				TX342F_Review rev = new TX342F_Review(driver);
				rev.review(test);

				LendlyProducts lp=new LendlyProducts(driver);
				lp.apr199(test);
				String loanNumber=lp.loanInfo(test);

				
				if (loanNumber != null && !"".equalsIgnoreCase(loanNumber)
						&& !"null".equalsIgnoreCase(loanNumber)) {
				
					LMS lmsa=new LMS(driver);
					lmsa.LMS_Login(authLMS_URL, LMS_UserName, LMS_Password, test);
					lmsa.PendingVerificationOlBnk(csoSelect, loanNumber, test);
					lmsa.pendVeriOlBnk(test);
				}
				else {
					test.log(LogStatus.FAIL, "Loan number not generated");
				}
				//Returning customer
				
				appLaunch.appLaunch(test, AppURL);			
				
				wdw.employeeDetails(Employer, test);
				
				cac.createAccount(Email_Address, Password, test);
				
				TX342F_Steps_away_from_$1000 s=new TX342F_Steps_away_from_$1000(driver);
				s.stepOne(test);
				s.loanApplicationAccept(test);
				s.scheduleAgreementAccept(test);
				s.loanNoteAccept(test);
				s.noteOfCancellationAccept(test);
				s.ACHAuthorizationAccept(test);
				s.consentToTextMessagesAccept(test);
				s.customerSignOlBnk(First_name, Last_name, test);
				if(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/form/div/div/div[2]/button")).isDisplayed()){
					test.log(LogStatus.PASS, "Loan Originated Successfully");
					
					driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/a")).click();
				}
			}
		}
	}
	
	@Test(priority=2)
	public void nonUsCitizen199APROhio() throws Exception {

	
		
		test = reports.startTest(
"Online_Bank_Model_TS_003","New Loan_OH state_Select Non-US Citizen checkbox --> Select APR 199% product --> Originate Loan");
		
		String FileName = "OnlineBankModel.xls";
		Excel TestData = new Excel(System.getProperty("user.dir")
				+ "/TestData/" + FileName);
		int lastrow = TestData.getLastRow("TS_003");
		String sheetName = "TS_003";
		for (int row = 2; row <= lastrow; row++) {
			
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				
				String Email_Address = TestData.getCellData(sheetName,
						"Email_Address", row);
				String Password = TestData.getCellData(sheetName, "Password",
						row);
				String First_name = TestData.getCellData(sheetName,
						"First_name", row);
				String Last_name = TestData.getCellData(sheetName, "Last_name",
						row);
				String Address = TestData
						.getCellData(sheetName, "Address", row);
				String Apt = TestData.getCellData(sheetName, "Apt", row);
				String ZipCode = TestData
						.getCellData(sheetName, "ZipCode", row);
				String City = TestData.getCellData(sheetName, "City", row);
				String Address1 = TestData.getCellData(sheetName, "Address1",
						row);
				String Apt1 = TestData.getCellData(sheetName, "Apt1", row);
				String ZipCode1 = TestData.getCellData(sheetName, "ZipCode1",
						row);
				String City1 = TestData.getCellData(sheetName, "City1", row);
				String Phone = TestData.getCellData(sheetName, "Phone", row);
				String ID_number = TestData.getCellData(sheetName, "ID_number",
						row);
				String Expiration_Date1 = TestData.getCellData(sheetName,
						"Expiration_Date1", row);
				String Expiration_Date2 = TestData.getCellData(sheetName,
						"Expiration_Date2", row);
				String Expiration_Date3 = TestData.getCellData(sheetName,
						"Expiration_Date3", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String DOB1 = TestData.getCellData(sheetName, "DOB1", row);
				String DOB2 = TestData.getCellData(sheetName, "DOB2", row);
				String DOB3 = TestData.getCellData(sheetName, "DOB3", row);

				String Net_Pay = TestData
						.getCellData(sheetName, "Net_Pay", row);
				
				String AccountNum = TestData.getCellData(sheetName,
						"AccountNum", row);
				String RoutingNum = TestData.getCellData(sheetName,
						"RoutingNum", row);
				String LMS_UserName = TestData.getCellData(sheetName,
						"LMS_UserName", row);
				String LMS_Password = TestData.getCellData(sheetName,
						"LMS_Password", row);
				String selectState=TestData.getCellData(sheetName, "selectState", row);
				String csoSelect=TestData.getCellData(sheetName, "csoSelect", row);

				String authLMS_URL=TestData.getCellData(sheetName, "authLMS_URL", row);
				String Employer=TestData.getCellData(sheetName, "Employer", row);	
				String Issue_Date3=TestData.getCellData(sheetName, "Issue_Date3", row);	
				String Issue_Date2=TestData.getCellData(sheetName, "Issue_Date2", row);	
				String Issue_Date1=TestData.getCellData(sheetName, "Issue_Date3", row);	


				TX342F_AppLaunch appLaunch=new TX342F_AppLaunch(driver);
				appLaunch.appLaunch(test, AppURL);
				

				TX342F_WhereDoYouWork wdw = new TX342F_WhereDoYouWork(driver);
				wdw.employeeDetails(Employer, test);
				
				

				TX342F_CreateAccount cac = new TX342F_CreateAccount(driver);
				cac.createAccount(Email_Address, Password, test);

			

				TX342F_ContactDetails cd = new TX342F_ContactDetails(driver);
				cd.contactDetails(First_name, Last_name, Phone, test);

				TX342F_AddressDetails ad = new TX342F_AddressDetails(driver);
				ad.addressDetails(selectState, Address, Apt, ZipCode, City, test);
				ad.differentAddressDetails(selectState, Address1, Apt1, ZipCode1, City1, test);
				ad.addressNext(test);
				ad.months0To6(test);

				

				TX342F_Identify_you_Part1 id1 = new TX342F_Identify_you_Part1(driver);

				id1.identifyYouPart1(SSN, DOB1, DOB2, DOB3, Employer, test);;
				id1.iAmNotUsCitizen(test);

				
				TX342F_Identify_you_Part2 id2 = new TX342F_Identify_you_Part2(driver);
		id2.identifyYouPart2(Employer, ID_number, Expiration_Date1, Expiration_Date2, Expiration_Date3, test, Issue_Date3, Issue_Date2, Issue_Date1);;

				
				TX342F_Income inc = new TX342F_Income(driver);
				inc.incomeOlbnk(test, Net_Pay);
				
				
				TX342F_Almostdone almtdn = new TX342F_Almostdone(driver);

				almtdn.almostDone(RoutingNum, AccountNum, test);

				
				TX342F_Review rev = new TX342F_Review(driver);
				rev.review(test);

				LendlyProducts lp=new LendlyProducts(driver);
				lp.apr199(test);
				String loanNumber=lp.loanInfo(test);

				
				if (loanNumber != null && !"".equalsIgnoreCase(loanNumber)
						&& !"null".equalsIgnoreCase(loanNumber)) {
				
					LMS lmsa=new LMS(driver);
					lmsa.LMS_Login(authLMS_URL, LMS_UserName, LMS_Password, test);
					lmsa.PendingVerificationOlBnk(csoSelect, loanNumber, test);
					lmsa.pendVeriOlBnk(test);
				}
				else {
					test.log(LogStatus.FAIL, "Loan number not generated");
				}
				//Returning customer
				
				appLaunch.appLaunch(test, AppURL);			
				
				wdw.employeeDetails(Employer, test);
				
				cac.createAccount(Email_Address, Password, test);
				
				TX342F_Steps_away_from_$1000 s=new TX342F_Steps_away_from_$1000(driver);
				s.stepOne(test);
				s.loanApplicationAccept(test);
				s.scheduleAgreementAccept(test);
				s.loanNoteAccept(test);
				s.noteOfCancellationAccept(test);
				s.ACHAuthorizationAccept(test);
				s.consentToTextMessagesAccept(test);
				s.customerSignOlBnk(First_name, Last_name, test);
				if(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/form/div/div/div[2]/button")).isDisplayed()){
					test.log(LogStatus.PASS, "Loan Originated Successfully");
					
					driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/a")).click();
					Thread.sleep(500);
				}
			}
		}
	}

	@Test(priority=3)
	public void usCitizen99APROhio() throws Exception {

	
		
		test = reports.startTest(
"Online_Bank_Model_TS_004","New Loan_California state_Select US Citizen checkbox --> Select APR 99% product --> Originate Loan");
		
		String FileName = "OnlineBankModel.xls";
		Excel TestData = new Excel(System.getProperty("user.dir")
				+ "/TestData/" + FileName);
		int lastrow = TestData.getLastRow("TS_004");
		String sheetName = "TS_004";
		for (int row = 2; row <= lastrow; row++) {
			
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				
				String Email_Address = TestData.getCellData(sheetName,
						"Email_Address", row);
				String Password = TestData.getCellData(sheetName, "Password",
						row);
				String First_name = TestData.getCellData(sheetName,
						"First_name", row);
				String Last_name = TestData.getCellData(sheetName, "Last_name",
						row);
				String Address = TestData
						.getCellData(sheetName, "Address", row);
				String Apt = TestData.getCellData(sheetName, "Apt", row);
				String ZipCode = TestData
						.getCellData(sheetName, "ZipCode", row);
				String City = TestData.getCellData(sheetName, "City", row);
				String Address1 = TestData.getCellData(sheetName, "Address1",
						row);
				String Apt1 = TestData.getCellData(sheetName, "Apt1", row);
				String ZipCode1 = TestData.getCellData(sheetName, "ZipCode1",
						row);
				String City1 = TestData.getCellData(sheetName, "City1", row);
				String Phone = TestData.getCellData(sheetName, "Phone", row);
				String ID_number = TestData.getCellData(sheetName, "ID_number",
						row);
				String Expiration_Date1 = TestData.getCellData(sheetName,
						"Expiration_Date1", row);
				String Expiration_Date2 = TestData.getCellData(sheetName,
						"Expiration_Date2", row);
				String Expiration_Date3 = TestData.getCellData(sheetName,
						"Expiration_Date3", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String DOB1 = TestData.getCellData(sheetName, "DOB1", row);
				String DOB2 = TestData.getCellData(sheetName, "DOB2", row);
				String DOB3 = TestData.getCellData(sheetName, "DOB3", row);

				String Net_Pay = TestData
						.getCellData(sheetName, "Net_Pay", row);
				
				String AccountNum = TestData.getCellData(sheetName,
						"AccountNum", row);
				String RoutingNum = TestData.getCellData(sheetName,
						"RoutingNum", row);
				String LMS_UserName = TestData.getCellData(sheetName,
						"LMS_UserName", row);
				String LMS_Password = TestData.getCellData(sheetName,
						"LMS_Password", row);
				String selectState=TestData.getCellData(sheetName, "selectState", row);
				String csoSelect=TestData.getCellData(sheetName, "csoSelect", row);

				String authLMS_URL=TestData.getCellData(sheetName, "authLMS_URL", row);
				String Employer=TestData.getCellData(sheetName, "Employer", row);	
				String Issue_Date3=TestData.getCellData(sheetName, "Issue_Date3", row);	
				String Issue_Date2=TestData.getCellData(sheetName, "Issue_Date2", row);	
				String Issue_Date1=TestData.getCellData(sheetName, "Issue_Date3", row);	
				String authLMS_userName = TestData.getCellData(sheetName,
						"authLMS_userName", row);
				String authLMS_password = TestData.getCellData(sheetName,
						"authLMS_password", row);			
				
				TX342F_AppLaunch appLaunch=new TX342F_AppLaunch(driver);
				appLaunch.appLaunch(test, AppURL);
				

				TX342F_WhereDoYouWork wdw = new TX342F_WhereDoYouWork(driver);
				wdw.employeeDetails(Employer, test);
				
				

				TX342F_CreateAccount cac = new TX342F_CreateAccount(driver);
				cac.createAccount(Email_Address, Password, test);

			

				TX342F_ContactDetails cd = new TX342F_ContactDetails(driver);
				cd.contactDetails(First_name, Last_name, Phone, test);

				TX342F_AddressDetails ad = new TX342F_AddressDetails(driver);
				ad.addressDetails(selectState, Address, Apt, ZipCode, City, test);
				ad.differentAddressDetails(selectState, Address1, Apt1, ZipCode1, City1, test);
				ad.addressNext(test);
				ad.months0To6(test);

				

				TX342F_Identify_you_Part1 id1 = new TX342F_Identify_you_Part1(driver);

				id1.identifyYouPart1(SSN, DOB1, DOB2, DOB3, Employer, test);;
				id1.iAmUsCitizen(test);

				
				TX342F_Identify_you_Part2 id2 = new TX342F_Identify_you_Part2(driver);
		id2.identifyYouPart2(Employer, ID_number, Expiration_Date1, Expiration_Date2, Expiration_Date3, test, Issue_Date3, Issue_Date2, Issue_Date1);;

				
				TX342F_Income inc = new TX342F_Income(driver);
				inc.incomeOlbnk(test, Net_Pay);
				
				
				TX342F_Almostdone almtdn = new TX342F_Almostdone(driver);

				almtdn.almostDone(RoutingNum, AccountNum, test);

				
				TX342F_Review rev = new TX342F_Review(driver);
				rev.review(test);

				LendlyProducts lp=new LendlyProducts(driver);
				lp.apr99(test);
				TX342F_Steps_away_from_$1000 s=new TX342F_Steps_away_from_$1000(driver);
				s.stepOne(test);
				s.loanApplicationAccept(test);
				s.scheduleAgreementAccept(test);
				s.loanNoteAccept(test);
				s.noteOfCancellationAccept(test);
				s.payRollAuthorizationAccept(test);
				s.ACHAuthorizationAccept(test);
				s.customerSignOlBnk(First_name, Last_name, test);
				String loanNumber = s.olBnkStep2(test);
				System.out.println(loanNumber);
				if (loanNumber != null && !"".equalsIgnoreCase(loanNumber)
						&& !"null".equalsIgnoreCase(loanNumber)) {
				
					TX342F_LMS lms=new TX342F_LMS(driver);
					lms.lmsLogin(authLMS_URL, LMS_UserName, LMS_Password, test);
					lms.authorizedDocsValidationOlBnkAuth(csoSelect, loanNumber, test);
					lms.authorizedLmsLogin(authLMS_URL, authLMS_userName, authLMS_password, test);
					lms.authorizedDisburseFundsOlBnk(csoSelect, loanNumber, test);
				}
				else {
					test.log(LogStatus.FAIL, "Loan number not generated");
				}
			}
			
		}
	}

	@Test(priority=4)
	public void usCitizen199APPRCA() throws Exception {

	
		
		test = reports.startTest(
"Online_Bank_Model_TS_005","New Loan_California state_Select US Citizen checkbox --> Select APR 199% product --> Originate Loan");
		
		String FileName = "OnlineBankModel.xls";
		Excel TestData = new Excel(System.getProperty("user.dir")
				+ "/TestData/" + FileName);
		int lastrow = TestData.getLastRow("TS_005");
		String sheetName = "TS_005";
		for (int row = 2; row <= lastrow; row++) {
			
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				
				String Email_Address = TestData.getCellData(sheetName,
						"Email_Address", row);
				String Password = TestData.getCellData(sheetName, "Password",
						row);
				String First_name = TestData.getCellData(sheetName,
						"First_name", row);
				String Last_name = TestData.getCellData(sheetName, "Last_name",
						row);
				String Address = TestData
						.getCellData(sheetName, "Address", row);
				String Apt = TestData.getCellData(sheetName, "Apt", row);
				String ZipCode = TestData
						.getCellData(sheetName, "ZipCode", row);
				String City = TestData.getCellData(sheetName, "City", row);
				String Address1 = TestData.getCellData(sheetName, "Address1",
						row);
				String Apt1 = TestData.getCellData(sheetName, "Apt1", row);
				String ZipCode1 = TestData.getCellData(sheetName, "ZipCode1",
						row);
				String City1 = TestData.getCellData(sheetName, "City1", row);
				String Phone = TestData.getCellData(sheetName, "Phone", row);
				String ID_number = TestData.getCellData(sheetName, "ID_number",
						row);
				String Expiration_Date1 = TestData.getCellData(sheetName,
						"Expiration_Date1", row);
				String Expiration_Date2 = TestData.getCellData(sheetName,
						"Expiration_Date2", row);
				String Expiration_Date3 = TestData.getCellData(sheetName,
						"Expiration_Date3", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String DOB1 = TestData.getCellData(sheetName, "DOB1", row);
				String DOB2 = TestData.getCellData(sheetName, "DOB2", row);
				String DOB3 = TestData.getCellData(sheetName, "DOB3", row);

				String Net_Pay = TestData
						.getCellData(sheetName, "Net_Pay", row);
				
				String AccountNum = TestData.getCellData(sheetName,
						"AccountNum", row);
				String RoutingNum = TestData.getCellData(sheetName,
						"RoutingNum", row);
				String LMS_UserName = TestData.getCellData(sheetName,
						"LMS_UserName", row);
				String LMS_Password = TestData.getCellData(sheetName,
						"LMS_Password", row);
				String selectState=TestData.getCellData(sheetName, "selectState", row);
				String csoSelect=TestData.getCellData(sheetName, "csoSelect", row);

				String authLMS_URL=TestData.getCellData(sheetName, "authLMS_URL", row);
				String Employer=TestData.getCellData(sheetName, "Employer", row);	
				String Issue_Date3=TestData.getCellData(sheetName, "Issue_Date3", row);	
				String Issue_Date2=TestData.getCellData(sheetName, "Issue_Date2", row);	
				String Issue_Date1=TestData.getCellData(sheetName, "Issue_Date3", row);	

				TX342F_AppLaunch appLaunch=new TX342F_AppLaunch(driver);
				appLaunch.appLaunch(test, AppURL);
				

				TX342F_WhereDoYouWork wdw = new TX342F_WhereDoYouWork(driver);
				wdw.employeeDetails(Employer, test);
				
				

				TX342F_CreateAccount cac = new TX342F_CreateAccount(driver);
				cac.createAccount(Email_Address, Password, test);

			

				TX342F_ContactDetails cd = new TX342F_ContactDetails(driver);
				cd.contactDetails(First_name, Last_name, Phone, test);

				TX342F_AddressDetails ad = new TX342F_AddressDetails(driver);
				ad.addressDetails(selectState, Address, Apt, ZipCode, City, test);
				ad.differentAddressDetails(selectState, Address1, Apt1, ZipCode1, City1, test);
				ad.addressNext(test);
				ad.months0To6(test);

				

				TX342F_Identify_you_Part1 id1 = new TX342F_Identify_you_Part1(driver);

				id1.identifyYouPart1(SSN, DOB1, DOB2, DOB3, Employer, test);;
				id1.iAmUsCitizen(test);

				
				TX342F_Identify_you_Part2 id2 = new TX342F_Identify_you_Part2(driver);
		id2.identifyYouPart2(Employer, ID_number, Expiration_Date1, Expiration_Date2, Expiration_Date3, test, Issue_Date3, Issue_Date2, Issue_Date1);;

				
				TX342F_Income inc = new TX342F_Income(driver);
				inc.incomeOlbnk(test, Net_Pay);
				
				
				TX342F_Almostdone almtdn = new TX342F_Almostdone(driver);

				almtdn.almostDone(RoutingNum, AccountNum, test);

				
				TX342F_Review rev = new TX342F_Review(driver);
				rev.review(test);

				LendlyProducts lp=new LendlyProducts(driver);
				lp.apr199(test);
				String loanNumber=lp.loanInfo(test);

				
				if (loanNumber != null && !"".equalsIgnoreCase(loanNumber)
						&& !"null".equalsIgnoreCase(loanNumber)) {
				
					LMS lmsa=new LMS(driver);
					lmsa.LMS_Login(authLMS_URL, LMS_UserName, LMS_Password, test);
					lmsa.PendingVerificationOlBnk(csoSelect, loanNumber, test);
					lmsa.pendVeriOlBnk(test);
				}
				else {
					test.log(LogStatus.FAIL, "Loan number not generated");
				}
				//Returning customer
				
				appLaunch.appLaunch(test, AppURL);			
				
				wdw.employeeDetails(Employer, test);
				
				cac.createAccount(Email_Address, Password, test);
				
				TX342F_Steps_away_from_$1000 s=new TX342F_Steps_away_from_$1000(driver);
				s.stepOne(test);
				s.loanApplicationAccept(test);
				s.scheduleAgreementAccept(test);
				s.loanNoteAccept(test);
				s.noteOfCancellationAccept(test);
				s.ACHAuthorizationAccept(test);
				s.consentToTextMessagesAccept(test);
				s.customerSignOlBnk(First_name, Last_name, test);
				if(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/form/div/div/div[2]/button")).isDisplayed()){
					test.log(LogStatus.PASS, "Loan Originated Successfully");
					
					driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/a")).click();
				}
			}
		}
	}

	@Test(priority=5)
	public void nonUsCitizen199APRCA() throws Exception {

	
		
		test = reports.startTest(
"Online_Bank_Model_TS_006","New Loan_California state_Select Non-US Citizen checkbox --> Select APR 199% product --> Originate Loan");
		
		String FileName = "OnlineBankModel.xls";
		Excel TestData = new Excel(System.getProperty("user.dir")
				+ "/TestData/" + FileName);
		int lastrow = TestData.getLastRow("TS_006");
		String sheetName = "TS_006";
		for (int row = 2; row <= lastrow; row++) {
			
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				
				String Email_Address = TestData.getCellData(sheetName,
						"Email_Address", row);
				String Password = TestData.getCellData(sheetName, "Password",
						row);
				String First_name = TestData.getCellData(sheetName,
						"First_name", row);
				String Last_name = TestData.getCellData(sheetName, "Last_name",
						row);
				String Address = TestData
						.getCellData(sheetName, "Address", row);
				String Apt = TestData.getCellData(sheetName, "Apt", row);
				String ZipCode = TestData
						.getCellData(sheetName, "ZipCode", row);
				String City = TestData.getCellData(sheetName, "City", row);
				String Address1 = TestData.getCellData(sheetName, "Address1",
						row);
				String Apt1 = TestData.getCellData(sheetName, "Apt1", row);
				String ZipCode1 = TestData.getCellData(sheetName, "ZipCode1",
						row);
				String City1 = TestData.getCellData(sheetName, "City1", row);
				String Phone = TestData.getCellData(sheetName, "Phone", row);
				String ID_number = TestData.getCellData(sheetName, "ID_number",
						row);
				String Expiration_Date1 = TestData.getCellData(sheetName,
						"Expiration_Date1", row);
				String Expiration_Date2 = TestData.getCellData(sheetName,
						"Expiration_Date2", row);
				String Expiration_Date3 = TestData.getCellData(sheetName,
						"Expiration_Date3", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String DOB1 = TestData.getCellData(sheetName, "DOB1", row);
				String DOB2 = TestData.getCellData(sheetName, "DOB2", row);
				String DOB3 = TestData.getCellData(sheetName, "DOB3", row);

				String Net_Pay = TestData
						.getCellData(sheetName, "Net_Pay", row);
				
				String AccountNum = TestData.getCellData(sheetName,
						"AccountNum", row);
				String RoutingNum = TestData.getCellData(sheetName,
						"RoutingNum", row);
				String LMS_UserName = TestData.getCellData(sheetName,
						"LMS_UserName", row);
				String LMS_Password = TestData.getCellData(sheetName,
						"LMS_Password", row);
				String selectState=TestData.getCellData(sheetName, "selectState", row);
				String csoSelect=TestData.getCellData(sheetName, "csoSelect", row);

				String authLMS_URL=TestData.getCellData(sheetName, "authLMS_URL", row);
				String Employer=TestData.getCellData(sheetName, "Employer", row);	
				String Issue_Date3=TestData.getCellData(sheetName, "Issue_Date3", row);	
				String Issue_Date2=TestData.getCellData(sheetName, "Issue_Date2", row);	
				String Issue_Date1=TestData.getCellData(sheetName, "Issue_Date3", row);	

				TX342F_AppLaunch appLaunch=new TX342F_AppLaunch(driver);
				appLaunch.appLaunch(test, AppURL);
				

				TX342F_WhereDoYouWork wdw = new TX342F_WhereDoYouWork(driver);
				wdw.employeeDetails(Employer, test);
				
				

				TX342F_CreateAccount cac = new TX342F_CreateAccount(driver);
				cac.createAccount(Email_Address, Password, test);

			

				TX342F_ContactDetails cd = new TX342F_ContactDetails(driver);
				cd.contactDetails(First_name, Last_name, Phone, test);

				TX342F_AddressDetails ad = new TX342F_AddressDetails(driver);
				ad.addressDetails(selectState, Address, Apt, ZipCode, City, test);
				ad.differentAddressDetails(selectState, Address1, Apt1, ZipCode1, City1, test);
				ad.addressNext(test);
				ad.months0To6(test);

				

				TX342F_Identify_you_Part1 id1 = new TX342F_Identify_you_Part1(driver);

				id1.identifyYouPart1(SSN, DOB1, DOB2, DOB3, Employer, test);
				id1.iAmNotUsCitizen(test);

				
				TX342F_Identify_you_Part2 id2 = new TX342F_Identify_you_Part2(driver);
		id2.identifyYouPart2(Employer, ID_number, Expiration_Date1, Expiration_Date2, Expiration_Date3, test, Issue_Date3, Issue_Date2, Issue_Date1);

				
				TX342F_Income inc = new TX342F_Income(driver);
				inc.incomeOlbnk(test, Net_Pay);
				
				
				TX342F_Almostdone almtdn = new TX342F_Almostdone(driver);

				almtdn.almostDone(RoutingNum, AccountNum, test);

				
				TX342F_Review rev = new TX342F_Review(driver);
				rev.review(test);

				LendlyProducts lp=new LendlyProducts(driver);
				lp.apr199(test);
				String loanNumber=lp.loanInfo(test);

				
				if (loanNumber != null && !"".equalsIgnoreCase(loanNumber)
						&& !"null".equalsIgnoreCase(loanNumber)) {
				
					LMS lmsa=new LMS(driver);
					lmsa.LMS_Login(authLMS_URL, LMS_UserName, LMS_Password, test);
					lmsa.PendingVerificationOlBnk(csoSelect, loanNumber, test);
					lmsa.pendVeriOlBnk(test);
				}
				else {
					test.log(LogStatus.FAIL, "Loan number not generated");
				}
				//Returning customer
				
				appLaunch.appLaunch(test, AppURL);			
				
				wdw.employeeDetails(Employer, test);
				
				cac.createAccount(Email_Address, Password, test);
				
				TX342F_Steps_away_from_$1000 s=new TX342F_Steps_away_from_$1000(driver);
				s.stepOne(test);
				s.loanApplicationAccept(test);
				s.scheduleAgreementAccept(test);
				s.loanNoteAccept(test);
				s.noteOfCancellationAccept(test);
				s.ACHAuthorizationAccept(test);
				s.consentToTextMessagesAccept(test);
				s.customerSignOlBnk(First_name, Last_name, test);
				if(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/form/div/div/div[2]/button")).isDisplayed()){
					test.log(LogStatus.PASS, "Loan Originated Successfully");
					
					driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/a")).click();
				}
			}
		}
	}	
	@Test(priority=6)
	public void usCitizen199APROhioOfferCode() throws Exception {

	
		
		test = reports.startTest(
"Online_Bank_Model_TS_007","New Loan --> OH state --> Select Employer name as -I do not see my employer --> Provide Offer Code --> Originate Loan");
		
		String FileName = "OnlineBankModel.xls";
		Excel TestData = new Excel(System.getProperty("user.dir")
				+ "/TestData/" + FileName);
		int lastrow = TestData.getLastRow("TS_007");
		String sheetName = "TS_007";
		for (int row = 2; row <= lastrow; row++) {
			
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				
				String Email_Address = TestData.getCellData(sheetName,
						"Email_Address", row);
				String Password = TestData.getCellData(sheetName, "Password",
						row);
				String First_name = TestData.getCellData(sheetName,
						"First_name", row);
				String Last_name = TestData.getCellData(sheetName, "Last_name",
						row);
				String Address = TestData
						.getCellData(sheetName, "Address", row);
				String Apt = TestData.getCellData(sheetName, "Apt", row);
				String ZipCode = TestData
						.getCellData(sheetName, "ZipCode", row);
				String City = TestData.getCellData(sheetName, "City", row);
				String Address1 = TestData.getCellData(sheetName, "Address1",
						row);
				String Apt1 = TestData.getCellData(sheetName, "Apt1", row);
				String ZipCode1 = TestData.getCellData(sheetName, "ZipCode1",
						row);
				String City1 = TestData.getCellData(sheetName, "City1", row);
				String Phone = TestData.getCellData(sheetName, "Phone", row);
				String ID_number = TestData.getCellData(sheetName, "ID_number",
						row);
				String Expiration_Date1 = TestData.getCellData(sheetName,
						"Expiration_Date1", row);
				String Expiration_Date2 = TestData.getCellData(sheetName,
						"Expiration_Date2", row);
				String Expiration_Date3 = TestData.getCellData(sheetName,
						"Expiration_Date3", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String DOB1 = TestData.getCellData(sheetName, "DOB1", row);
				String DOB2 = TestData.getCellData(sheetName, "DOB2", row);
				String DOB3 = TestData.getCellData(sheetName, "DOB3", row);

				String Net_Pay = TestData
						.getCellData(sheetName, "Net_Pay", row);
				
				String AccountNum = TestData.getCellData(sheetName,
						"AccountNum", row);
				String RoutingNum = TestData.getCellData(sheetName,
						"RoutingNum", row);
				String LMS_UserName = TestData.getCellData(sheetName,
						"LMS_UserName", row);
				String LMS_Password = TestData.getCellData(sheetName,
						"LMS_Password", row);
				String selectState=TestData.getCellData(sheetName, "selectState", row);
				String csoSelect=TestData.getCellData(sheetName, "csoSelect", row);

				String authLMS_URL=TestData.getCellData(sheetName, "authLMS_URL", row);
				String Employer=TestData.getCellData(sheetName, "Employer", row);	
				String Issue_Date3=TestData.getCellData(sheetName, "Issue_Date3", row);	
				String Issue_Date2=TestData.getCellData(sheetName, "Issue_Date2", row);	
				String Issue_Date1=TestData.getCellData(sheetName, "Issue_Date3", row);	
				String promoCode = TestData.getCellData(sheetName,"promoCode", row);

				TX342F_AppLaunch appLaunch=new TX342F_AppLaunch(driver);
				appLaunch.appLaunch(test, AppURL);
				
				DataAccessManager dam=new DataAccessManager();
				dam.promoCodeUpdate(test);
				TX342F_WhereDoYouWork wdw = new TX342F_WhereDoYouWork(driver);
				wdw.employeeDetailsWithPromeCode(Employer, promoCode, test);
				
				

				TX342F_CreateAccount cac = new TX342F_CreateAccount(driver);
				cac.createAccount(Email_Address, Password, test);

			

				TX342F_ContactDetails cd = new TX342F_ContactDetails(driver);
				cd.contactDetails(First_name, Last_name, Phone, test);

				TX342F_AddressDetails ad = new TX342F_AddressDetails(driver);
				ad.addressDetails(selectState, Address, Apt, ZipCode, City, test);
				ad.differentAddressDetails(selectState, Address1, Apt1, ZipCode1, City1, test);
				ad.addressNext(test);
				ad.months0To6(test);

				

				TX342F_Identify_you_Part1 id1 = new TX342F_Identify_you_Part1(driver);

				id1.identifyYouPart1(SSN, DOB1, DOB2, DOB3, Employer, test);

				
				TX342F_Identify_you_Part2 id2 = new TX342F_Identify_you_Part2(driver);
		id2.identifyYouPart2(Employer, ID_number, Expiration_Date1, Expiration_Date2, Expiration_Date3, test, Issue_Date3, Issue_Date2, Issue_Date1);

				
				TX342F_Income inc = new TX342F_Income(driver);
				inc.incomeOlbnk(test, Net_Pay);
				
				
				TX342F_Almostdone almtdn = new TX342F_Almostdone(driver);

				almtdn.almostDone(RoutingNum, AccountNum, test);

				
				TX342F_Review rev = new TX342F_Review(driver);
				rev.review(test);

				LendlyProducts lp=new LendlyProducts(driver);
			
				String loanNumber=lp.loanInfo(test);

				
				if (loanNumber != null && !"".equalsIgnoreCase(loanNumber)
						&& !"null".equalsIgnoreCase(loanNumber)) {
				
					LMS lmsa=new LMS(driver);
					lmsa.LMS_Login(authLMS_URL, LMS_UserName, LMS_Password, test);
					lmsa.PendingVerificationOlBnk(csoSelect, loanNumber, test);
					lmsa.pendVeriOlBnk(test);
				}
				else {
					test.log(LogStatus.FAIL, "Loan number not generated");
				}
				//Returning customer
				
				appLaunch.appLaunch(test, AppURL);			
				dam.promoCodeUpdate(test);
				wdw.employeeDetailsWithPromeCode(Employer, promoCode, test);

				
				cac.createAccount(Email_Address, Password, test);
				
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/form/div[1]/p/button")).click();
				
				TX342F_Steps_away_from_$1000 s=new TX342F_Steps_away_from_$1000(driver);
				s.stepOne(test);
				s.loanApplicationAccept(test);
				s.scheduleAgreementAccept(test);
				s.loanNoteAccept(test);
				s.noteOfCancellationAccept(test);
				s.ACHAuthorizationAccept(test);
				s.consentToTextMessagesAccept(test);
				s.customerSignOlBnk(First_name, Last_name, test);
				if(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/form/div/div/div[2]/button")).isDisplayed()){
					test.log(LogStatus.PASS, "Loan Originated Successfully");
					
					driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/a")).click();
				}
			}
		}
	}	
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		try {
			if (result.getStatus() == ITestResult.FAILURE) {

				// To capture screenshot path and store the path of the
				// screenshot in the string "screenshotPath"
				// We do pass the path captured by this method in to the extent
				// reports using "logger.addScreenCapture" method.
				String screenshotPath = OnlineBankModelBatch.getScreenshot(
						driver, result.getName());
				// String screenshotPath =
				// NCPFinanceEmployee_Scenarios.CaptureScreenShotWithTestStepNameUsingRobotClass(result.getName());
				// To add it in the extent report
				String newLine = System.getProperty("line.separator");
				test.log(LogStatus.FAIL,
						"Test Case Failed is : " + result.getName() + newLine
								+ " Exception is : " + result.getThrowable()
								+ " " + test.addScreenCapture(screenshotPath));

				try {

					// Check the presence of alert
					Alert alert = driver.switchTo().alert();
					// Alert present; set the flag
					// presentFlag = true;
					// if present consume the alert
					alert.accept();
					// ( Now, click on ok or cancel button )

				} catch (NoAlertPresentException ex) {
					// Alert not present
					ex.printStackTrace();
				}

			} else if (result.getStatus() == ITestResult.SKIP) {
				test.log(LogStatus.SKIP,
						"Test Case Skipped is " + result.getName());
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(LogStatus.PASS, result.getName()
						+ " Test Case is Passed");
			}
			// reports.endTest(test);
			reports.flush();
			// Call close() at the very end of your session to clear all
			// resources.
			// If any of your test ended abruptly causing any side-affects (not
			// all logs sent to ExtentReports, information missing), this method
			// will ensure that the test is still appended to the report with a
			// warning message.
			// You should call close() only once, at the very end (in
			// @AfterSuite for example) as it closes the underlying stream.
			// Once this method is called, calling any Extent method will throw
			// an error.
			// close() - To close all the operation
			// driver.quit();
			// ending test
			// endTest(logger) : It ends the current test and prepares to create
			// HTML report
			// reports.endTest(test);
		} catch (Exception E) {

		}
	}

	public static String getScreenshot(WebDriver driver, String screenshotName)
			throws Exception {
		try {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss")
					.format(new Date());
			// Creating Robot class object
			Robot robotClassObject = new Robot();

			// Get screen size
			Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit()
					.getScreenSize());

			// Capturing screenshot by providing size
			BufferedImage tmp = robotClassObject
					.createScreenCapture(screenSize);

			// Defining destination file path
			String path = System.getProperty("user.dir")
					+ "/ExecutionReports/LOC/FailedTestsScreenshots/"
					+ screenshotName + dateName + ".png";

			// To copy temp image in to permanent file
			ImageIO.write(tmp, "png", new File(path));
			return path;

		} catch (Exception e) {
			System.out.println("Some exception occured." + e.getMessage());
			return "";
		}

	}

	@AfterMethod
	@AfterTest
	public void tearDown() throws IOException {
		// Ending Test
		reports.endTest(test);

		// writing everything into HTML report
		reports.flush();
//		driver.manage().deleteAllCookies();
//		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe"); 
//		char c='"';
//		String cacheInternal=""+c+"%LOCALAPPDATA%/Google/Chrome/User Data/*.*"+c;
//		String cacheClear="erase "+cacheInternal+" /f /s /q";
//		Runtime.getRuntime().exec(cacheClear);
	}

	@AfterClass
	public void quit() {
		// Closing browser
		 //driver.quit();

	}

}

