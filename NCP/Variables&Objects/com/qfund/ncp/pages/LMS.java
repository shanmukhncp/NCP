package com.qfund.ncp.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.qfund.ncp.utils.*;

@SuppressWarnings("unused")
public class LMS {

	WebDriver driver;
	ExtentTest test;
	int rnum;
	String LMS_APP_URL="https://192.168.2.200/ncp/";
	By LMS_UserName_TXT = By.name("loginRequestBean.userId");
	By LMS_Password_TXT = By.name("loginRequestBean.password");
	By LMS_Login_BTN = By.name("login");
	By LMS_DirectlendMgmt_TAB = By.xpath("//*[@id='4d']/img");
	By LMS_ApplicationMgmt_Menu = By.xpath("//*[@id='172']/a");
	By LMS_ApplicationQueue_Menu = By.xpath("//*[@id='90401']/a");
	By LMS_CSO_ID_DRP = By.id("csoIdSel");
	By LMS_LoanStatus_DRP = By.id("loanStatus");
	By LMS_Search_BTN = By.id("submitBtn");
	By LMS_GO_BTN = By.name("SubmitBtn");
	By LMS_IdVerification_LINK = By.id("id1");
	By LMS_IdReceived_CHK = By.id("received1");
	By LMS_IdVerified_CHK = By.id("verify1");
	By LMS_AddrVerification_LINK = By.id("id3");
	By LMS_AdrReceived_CHK = By.id("received2");
	By LMS_AdrVerified_CHK = By.id("verify3");
	By LMS_CellPhone_LINK = By.id("id5");
	By LMS_CellPhoneReceived_CHK = By.id("cellPhoneReceived");
	By LMS_CellPhoneVerified_CHK = By.id("verify5");
	By LMS_HomePhone_LINK = By.id("id4");
	By LMS_HomePhoneReceived_CHK = By.id("homePhoneReceived");
	By LMS_HomePhoneVerified_CHK = By.id("verify4");
	By LMS_Complete1_BTN = By.id("submit1");
	By LMS_ProofOfIncome_LINK = By.id("id6");
	By LMS_IncomeReceived_CHK = By.id("received3");
	By LMS_IncomeVerified_CHK = By.id("verify6");
	By LMS_Supervisor_LINK = By.id("id9");
	By LMS_SupervisorReceived_CHK = By.id("received5");
	By LMS_SupervisorVerified_CHK = By.id("verify8");
	By LMS_WorkPhone_LINK = By.id("id10");
	By LMS_WorkPhoneReceived_CHK = By.name("verificationRequestBean.received11");
	By LMS_WorkPhoneVerified_CHK = By.id("workPhoneVerified");
	By LMS_Complete2_BTN = By.id("submit2");
	By LMS_BankDetails_LINK = By.id("id11");
	By LMS_BankDetailsReceived_CHK = By.id("received6");
	By LMS_BankDetailsVerified_CHK = By.id("verify9");
	By LMS_Complete3_BTN = By.id("submit3");
	By LMS_SubmitForUnderwriting_BTN = By.id("savetwo");
//By LMS_UploadDoc_BTN = By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table[2]/tbody/tr[3]/td/input[4]");
	By LMS_UploadDoc_BTN = By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table[2]/tbody/tr[2]/td/input[1]");
	By LMS_UploadDoc_BTN_USPS =	By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[2]/tbody/tr/td/input");				 
	By PENDING_FUNDING_SEARCH_BTN = By.id("submitBtn");
	By WEB_TABLE_LOAN_BTN = By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td");
	By GO_BTN = By.xpath(
			"/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[" + rnum + "]/td[12]/input");
	By VIEW_PDA_DOCUMENT_BTN = By
			.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table[2]/tbody/tr[3]/td/input[4]");
	By ACCEPT_PDA_BTN = By.xpath("//*[@id='acceptRadio']");
	By SUBMIT_PDA_BTN = By.xpath("//*[@id='showDocuments']/td/table[2]/tbody/tr[3]/td[2]/input");
	By OK_BTN = By.xpath("//*[@id='showSuccess']/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td/input");
	By DISBURSE_FUNDS_BTN = By.xpath("//*[@id='printCheck10' and @type='button' and @value='Disburse Funds']");
	By OK_DISBURSE_FUNDS_BTN = By
			.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input");
	By DISPLAYED_LOAN_ORIGINATED_MSG = By
			.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/strong");
	By LOGOUT_BTN = By.xpath("//*[@id='7d']");
	By html_Table = By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td");
	By successMessage=By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/strong");
	By successOk_Btn=By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input");
	By htmlTable_Rows = By.tagName("tr");
	By htmlTable_Columns = By.tagName("td");
	By loanstatus_LBL = By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]");
	By acceptPDA_rad = By.xpath("//input[@id='acceptRadio']");
	By submitPDA_btn = By.id("btnSubmit");
	
	public LMS(WebDriver driver) {
		this.driver = driver;
	}

	// Method for LMS Login
	public void LMS_Login(String LMS_APP_URL, String LMS_UserName, String LMS_Password, ExtentTest test) {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(LMS_APP_URL);
		driver.get(LMS_APP_URL);
		test.log(LogStatus.PASS, "LMS Application Launched is: "+LMS_APP_URL);

		driver.findElement(LMS_UserName_TXT).sendKeys(LMS_UserName);
		test.log(LogStatus.PASS, "LMS Username entetred is: " + LMS_UserName);

		driver.findElement(LMS_Password_TXT).sendKeys(LMS_Password);
		test.log(LogStatus.PASS, "LMS Password entetred is: " + LMS_Password);

		driver.findElement(LMS_Login_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Submit button in LMS Login screen");
	}

	public void LMS_PendingVerification(String csoSelect,String LoanNum, ExtentTest test) throws InterruptedException {
		
		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		driver.switchTo().frame(top);
		driver.findElement(LMS_DirectlendMgmt_TAB).click();
		test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		Actions a = new Actions(driver);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		Thread.sleep(500);
		a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		//driver.switchTo().defaultContent();
		//driver.switchTo().frame(mainFrame);
		WebElement main=driver.findElement(By.name("main"));

		driver.switchTo().frame(main);
		Thread.sleep(500);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS, "CSO selected is: "+csoSelect);
		System.out.println(csoSelect);
		
		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(2);
		test.log(LogStatus.PASS, "Loan Status selected is: Pending Verification");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		Thread.sleep(500);

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
										+ rnum + "]/td[12]/input"))
								.click();
						
						System.out.println(" Loan Number matched. current row num " + rnum);
						Thread.sleep(500);

						String pv = "Pending Verification";
						String Loansts = driver
								.findElement(By
										.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
								.getText();

						if (Loansts.equalsIgnoreCase(pv)) {
							System.out.println(pv);
							test.log(LogStatus.PASS, "Loan is in 'Pending Verification' status");
						}
						Thread.sleep(500);
						driver.findElement(LMS_GO_BTN).click();
						test.log(LogStatus.PASS,
								"Clicked on Go Button for the loan record displayed in search results");

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		// Verification Screen
		// Customer Information section

		Thread.sleep(500);

		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.elementToBeClickable(LMS_IdVerification_LINK));
//		driver.findElement(LMS_IdVerification_LINK).click();
//		test.log(LogStatus.PASS, "Clicked on ID Verification hyperlink under Customer Information section");
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.findElement(
//				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
//		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
//
//		driver.switchTo().window(winHandleBefore);
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(mainFrame);
//		driver.switchTo().frame(main);
		driver.findElement(LMS_IdReceived_CHK).click();
		test.log(LogStatus.PASS, "Clicked on ID Verification-Received checkbox under Customer Information section");
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_IdVerified_CHK));
		driver.findElement(LMS_IdVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on ID Verification - Verify checkbox under Customer Information section");

		Thread.sleep(500);

//		driver.findElement(LMS_AddrVerification_LINK).click();
//		test.log(LogStatus.PASS, "Clicked on Address Verification hyperlink under Customer Information section");
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.findElement(
//				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
//		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
//		driver.switchTo().window(winHandleBefore);
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(mainFrame);
//		driver.switchTo().frame(main);
		driver.findElement(LMS_AdrReceived_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Address Verification-Received checkbox under Customer Information section");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_AdrVerified_CHK));

		driver.findElement(LMS_AdrVerified_CHK).click();
		test.log(LogStatus.PASS,
				"Clicked on Address Verification - Verify checkbox under Customer Information section");

		Thread.sleep(500);
//		if (driver.findElement(LMS_HomePhoneReceived_CHK).isSelected()) {
//			test.log(LogStatus.PASS, "Clicked on Cell Phone Verified checkbox Customer Information section");
//		} else {
//
//			driver.findElement(LMS_HomePhone_LINK).click();
//			test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr hyperlink under Customer Information section");
//
//			for (String winHandle : driver.getWindowHandles()) {
//				driver.switchTo().window(winHandle);
//			}
//			driver.findElement(
//					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
//					.click();
//			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
//			driver.switchTo().window(winHandleBefore);
//
//		}
//
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(mainFrame);
//		driver.switchTo().frame(main);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verify5")));
//
//		driver.findElement(LMS_HomePhoneVerified_CHK).click();
//		test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr - - Received checkbox under Customer Information section");
//
//		Thread.sleep(500);
//		if (driver.findElement(LMS_CellPhoneReceived_CHK).isSelected()) {
//			test.log(LogStatus.PASS, "Clicked on Cell Phone Verified checkbox Customer Information section");
//		} else {
//
//			driver.findElement(LMS_CellPhone_LINK).click();
//			test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr hyperlink under Customer Information section");
//
//			for (String winHandle : driver.getWindowHandles()) {
//				driver.switchTo().window(winHandle);
//			}
//			driver.findElement(
//					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
//					.click();
//			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
//			driver.switchTo().window(winHandleBefore);
//
//		}
//
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(mainFrame);
//		driver.switchTo().frame(main);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verify5")));
//
//		driver.findElement(LMS_CellPhoneVerified_CHK).click();
//		test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr - - Received checkbox under Customer Information section");

		driver.findElement(LMS_Complete1_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Complete button for Customer Information section");

		// **********Employer Information section

		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
//		driver.findElement(LMS_ProofOfIncome_LINK).click();
//		test.log(LogStatus.PASS, "Clicked on Proof of Income hyperlink under Employer Information section");
//
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.findElement(
//				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
//		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
//		driver.switchTo().window(winHandleBefore);
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(mainFrame);
//		driver.switchTo().frame(main);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ProofOfIncome_LINK));
//
//		driver.findElement(LMS_ProofOfIncome_LINK).click();
//		test.log(LogStatus.PASS, "Clicked on Proof of Income - Received checkbox under Employer Information section");

		driver.findElement(LMS_IncomeReceived_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Proof of Income - Received checkbox under Employer Information section");
		driver.findElement(LMS_IncomeVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Proof of Income - Verify checkbox under Employer Information section");

		Thread.sleep(500);
//		if (driver.findElement(LMS_SupervisorReceived_CHK).isSelected()) {
//			test.log(LogStatus.PASS, "Clicked on Supervisor - Received checkbox under Employer Information section");
//		} else {
//
//			driver.findElement(LMS_Supervisor_LINK).click();
//			test.log(LogStatus.PASS, "Clicked on Supervisor hyperlink under Employer Information section");
//
//			for (String winHandle : driver.getWindowHandles()) {
//				driver.switchTo().window(winHandle);
//			}
//			driver.findElement(
//					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
//					.click();
//			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
//			driver.switchTo().window(winHandleBefore);
//
//		}
//
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(mainFrame);
//		driver.switchTo().frame(main);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_SupervisorVerified_CHK));
//
//		driver.findElement(LMS_SupervisorVerified_CHK).click();
//		test.log(LogStatus.PASS, "Clicked on Supervisor - Verify checkbox under Employer Information section");
//
//		Thread.sleep(500);
//
//		if (driver.findElement(LMS_WorkPhoneReceived_CHK).isSelected()) {
//			test.log(LogStatus.PASS, "Clicked on Work Phone Nbr Received Checkbox under Employer Information section");
//		} else {
//
//			driver.findElement(LMS_WorkPhone_LINK).click();
//			test.log(LogStatus.PASS, "Clicked on Work Phone Nbr hyperlink under Employer Information section");
//
//			for (String winHandle : driver.getWindowHandles()) {
//				driver.switchTo().window(winHandle);
//			}
//			driver.findElement(
//					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
//					.click();
//			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
//			driver.switchTo().window(winHandleBefore);
//		}
//
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(mainFrame);
//		driver.switchTo().frame(main);
//		driver.findElement(LMS_WorkPhoneVerified_CHK).click();
//		test.log(LogStatus.PASS, "Clicked on Work Phone Nbr - Verify checkbox under Employer Information section");

		driver.findElement(LMS_Complete2_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Complete button for Employer Information section");

		// Banking Details section

		Thread.sleep(500);
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(mainFrame);
//		driver.switchTo().frame(main);
//
//		driver.findElement(LMS_BankDetails_LINK).click();
//		test.log(LogStatus.PASS, "Clicked on Bank Statement - Received checkbox under Banking Details section");
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
//		driver.findElement(
//				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
//		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
//		driver.switchTo().window(winHandleBefore);
//
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(mainFrame);
//		driver.switchTo().frame(main);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verify9")));
//
//		driver.findElement(LMS_BankDetailsVerified_CHK).click();
//		test.log(LogStatus.PASS, "Clicked on Bank Statement - Verify checkbox under Banking Details section");
//
//		driver.findElement(LMS_Complete3_BTN).click();
//		test.log(LogStatus.PASS, "Clicked on 'Complete' button for Banking Details section");

		driver.findElement(LMS_SubmitForUnderwriting_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Submit for Underwriting' button in Verification screen");

	}

	public void LMS_PendingVerification_USPS(String LoanNum, ExtentTest test) throws InterruptedException {
		
		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.switchTo().frame(top);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(LMS_DirectlendMgmt_TAB));
		driver.findElement(LMS_DirectlendMgmt_TAB).click();
		test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		Actions a = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		Thread.sleep(500);
		a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(500);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByVisibleText("USPS - OH");
		test.log(LogStatus.PASS, "CSO selected is: USPS - OH");

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(2);
		test.log(LogStatus.PASS, "Loan Status selected is: Pending Verification");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		Thread.sleep(500);

		try {
			WebElement htmltable = driver
					.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td"));

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
										+ rnum + "]/td[13]/input"))
								.click();
						System.out.println(" Loan Number matched. current row num " + rnum);
						Thread.sleep(500);

						String pv = "Pending Verification";
						String Loansts = driver
								.findElement(By
										.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
								.getText();

						if (Loansts.equalsIgnoreCase(pv)) {
							System.out.println(pv);
							test.log(LogStatus.PASS, "Loan is in 'Pending Verification' status");
						}
						Thread.sleep(500);
						driver.findElement(LMS_GO_BTN).click();
						test.log(LogStatus.PASS,
								"Clicked on Go Button for the loan record displayed in search results");

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		// Verification Screen
		// Customer Information section

		Thread.sleep(500);

		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.elementToBeClickable(LMS_IdVerification_LINK));
		driver.findElement(LMS_IdReceived_CHK).click();
		test.log(LogStatus.PASS, "Clicked on ID Received checkbox under Customer Information section");

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(mainFrame);
		// driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_IdVerified_CHK));
		driver.findElement(LMS_IdVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on ID Verification - Verify checkbox under Customer Information section");

		Thread.sleep(500);

		if (driver.findElement(LMS_AdrReceived_CHK).isSelected()) {
			test.log(LogStatus.PASS, "Clicked on Address Received Checkbox under Customer Information section");
		} else {
			driver.findElement(LMS_AdrReceived_CHK).click();
			test.log(LogStatus.PASS, "Clicked on Address Received Checkbox under Customer Information section");
		}

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(mainFrame);
		// driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_AdrVerified_CHK));

		driver.findElement(LMS_AdrVerified_CHK).click();
		test.log(LogStatus.PASS,
				"Clicked on Address Verification - Verify checkbox under Customer Information section");

		Thread.sleep(500);
		if (driver.findElement(LMS_CellPhoneReceived_CHK).isSelected()) {
			test.log(LogStatus.PASS, "Clicked on Cell Phone Received checkbox Customer Information section");
		} else {

			driver.findElement(LMS_CellPhoneReceived_CHK).click();
			test.log(LogStatus.PASS, "Clicked on Cell Phone Received checkbox Customer Information section");

		}

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(mainFrame);
		// driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_CellPhoneVerified_CHK));

		driver.findElement(LMS_CellPhoneVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr - - Received checkbox under Customer Information section");

		driver.findElement(LMS_Complete1_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Complete button for Customer Information section");

		// Banking Details section

		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);

		driver.findElement(LMS_BankDetailsReceived_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Bank Statement - Received checkbox under Banking Details section");

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(mainFrame);
		// driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_BankDetailsVerified_CHK));

		driver.findElement(LMS_BankDetailsVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Bank Statement - Verify checkbox under Banking Details section");

		driver.findElement(LMS_Complete3_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Complete' button for Banking Details section");

		driver.findElement(LMS_SubmitForUnderwriting_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Submit' button in Verification screen");

	}

	public void LMS_PendingVerification_VA(String LoanNum, String csoSelect, ExtentTest test) throws InterruptedException {
		
		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		
		driver.switchTo().frame(top);
		driver.findElement(LMS_DirectlendMgmt_TAB).click();
		test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		WebElement main = driver.findElement(By.name("main"));
		driver.switchTo().frame(main);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_CSO_ID_DRP));
		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		Thread.sleep(2000);
		CSO.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS, "CSO selected is:  "+csoSelect);


		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(2);
		test.log(LogStatus.PASS, "Loan Status selected is: Pending Verification");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");
		
		Thread.sleep(500);

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
										+ rnum + "]/td[14]/input"))
								.click();
						System.out.println(" Loan Number matched. current row num " + rnum);
						Thread.sleep(500);

						String pv = "Pending Verification";
						String Loansts = driver
								.findElement(By
										.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
								.getText();

						if (Loansts.equalsIgnoreCase(pv)) {
							System.out.println(pv);
							test.log(LogStatus.PASS, "Loan is in 'Pending Verification' status");
						}
						Thread.sleep(500);
						driver.findElement(LMS_GO_BTN).click();
						test.log(LogStatus.PASS,
								"Clicked on Go Button for the loan record displayed in search results");

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		// Verification Screen
		// Customer Information section

		Thread.sleep(500);

		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.elementToBeClickable(LMS_IdReceived_CHK));
		driver.findElement(LMS_IdReceived_CHK).click();
		test.log(LogStatus.PASS, "Clicked on ID Received checkbox under Customer Information section");

		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_IdVerified_CHK));
		driver.findElement(LMS_IdVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on ID Verification - Verify checkbox under Customer Information section");

		Thread.sleep(500);

		if (driver.findElement(LMS_AdrReceived_CHK).isSelected()) {
			test.log(LogStatus.PASS, "Clicked on Address Received Checkbox under Customer Information section");
		} else {
			driver.findElement(LMS_AdrReceived_CHK).click();
			test.log(LogStatus.PASS, "Clicked on Address Received Checkbox under Customer Information section");
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_AdrVerified_CHK));

		driver.findElement(LMS_AdrVerified_CHK).click();
		test.log(LogStatus.PASS,
				"Clicked on Address Verification - Verify checkbox under Customer Information section");

		Thread.sleep(500);
//		if (driver.findElement(LMS_CellPhoneReceived_CHK).isSelected()) {
//			test.log(LogStatus.PASS, "Clicked on Cell Phone Received checkbox Customer Information section");
//		} else {
//
//			driver.findElement(LMS_CellPhoneReceived_CHK).click();
//			test.log(LogStatus.PASS, "Clicked on Cell Phone Received checkbox Customer Information section");
//
//		}

		/*wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_CellPhoneVerified_CHK));

		driver.findElement(LMS_CellPhoneVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr - - Received checkbox under Customer Information section");*/

		driver.findElement(LMS_Complete1_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Complete button for Customer Information section");

		// **********Employer Information section
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_IncomeReceived_CHK));

		driver.findElement(LMS_IncomeReceived_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Proof of Income - Received checkbox under Employer Information section");
		Thread.sleep(500);
		driver.findElement(LMS_IncomeVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Proof of Income - Verify checkbox under Employer Information section");
		Thread.sleep(500);
//		if (driver.findElement(LMS_SupervisorReceived_CHK).isSelected()) {
//			test.log(LogStatus.PASS, "Displayed on Supervisor - Received checkbox under Employer Information section");
//		} else {
//			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(LMS_SupervisorReceived_CHK)));
//			driver.findElement(LMS_SupervisorReceived_CHK).click();
//			test.log(LogStatus.PASS, "Clicked on Supervisor - Received checkbox under Employer Information section");
//
//		}

//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(LMS_SupervisorVerified_CHK)));
//		driver.findElement(LMS_SupervisorVerified_CHK).click();
//		test.log(LogStatus.PASS, "Clicked on Supervisor - Verify checkbox under Employer Information section");
//		Thread.sleep(500);
//		try
//		{
//		if (driver.findElement(LMS_WorkPhoneReceived_CHK).isSelected()) {
//				test.log(LogStatus.PASS, "Clicked on Work Phone Nbr Received Checkbox under Employer Information section");
//			} else {
//				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(LMS_WorkPhoneReceived_CHK)));
//				driver.findElement(LMS_WorkPhoneReceived_CHK).click();
//				test.log(LogStatus.PASS, "Clicked on Work Phone Nbr Received Checkbox under Employer Information section");
//
//			}
//		}
//		catch (Exception e)
//		{
//			System.out.println(e.getMessage());
//			System.out.println(e.getStackTrace());
//		}
		

//		driver.findElement(LMS_WorkPhoneVerified_CHK).click();
//		test.log(LogStatus.PASS, "Clicked on Work Phone Nbr - Verify checkbox under Employer Information section");

		driver.findElement(LMS_Complete2_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Complete button for Employer Information section");

		// Banking Details section

		Thread.sleep(500);
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(mainFrame);
//		driver.switchTo().frame(main);
//
//		driver.findElement(LMS_BankDetailsReceived_CHK).click();
//		test.log(LogStatus.PASS, "Clicked on Bank Statement - Received checkbox under Banking Details section");
//
//		// driver.switchTo().defaultContent();
//		// driver.switchTo().frame(mainFrame);
//		// driver.switchTo().frame(main);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_BankDetailsVerified_CHK));
//
//		driver.findElement(LMS_BankDetailsVerified_CHK).click();
//		test.log(LogStatus.PASS, "Clicked on Bank Statement - Verify checkbox under Banking Details section");
//
//		driver.findElement(LMS_Complete3_BTN).click();
//		test.log(LogStatus.PASS, "Clicked on 'Complete' button for Banking Details section");

		driver.findElement(LMS_SubmitForUnderwriting_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Submit' button in Verification screen");

	}

	public void LMS_ReadyToEsign(String CP_NewPswd, String csoSelect, String eSignCustName, String LoanNum, String CustomerPortal_URL,
			String CP_Username, String CP_ConfirmNewPswd, ExtentTest test) throws InterruptedException {
		
		//WebElement top=driver.findElement(By.id("topFrame"));
		driver.switchTo().defaultContent();
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		
		
		
		WebDriverWait wait=new WebDriverWait(driver,60);
		driver.switchTo().frame(mainFrame);
		Actions a = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(2000);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		WebElement main=driver.findElement(By.name("main"));
		driver.switchTo().frame(main);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated((LMS_CSO_ID_DRP)));
		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		
		CSO.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS, "CSO selected is: "+csoSelect);

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(1);
		test.log(LogStatus.PASS, "Loan Status selected is: Ready to E-Sign");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						String LoanSts = driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[" + rnum + "]/td[6]")).getText();
						test.log(LogStatus.PASS, "Current Loan status is : " + LoanSts);
						System.out.println("Loan Number matched. current row num is " + rnum);
						System.out.println("Loan Status is " + LoanSts);

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		/*
		 * String LoanSts = driver .findElement( By.xpath(
		 * "/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"
		 * )) .getText(); String re = "Ready to E-Sign"; if
		 * (LoanSts.equalsIgnoreCase(re)) { test.log(LogStatus.PASS,
		 * "Loan is in 'Ready to E-Sign' status"); }
		 */

	}

	public void LMS_ReadyToEsign_USPS(String CP_NewPswd, String csoSelect, String eSignCustName, String LoanNum,
			String CustomerPortal_URL, String CP_Username, String CP_ConfirmNewPswd, ExtentTest test)
			throws InterruptedException {
		
		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		
		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(500);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS, "CSO selected is: FWA-GO");

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(1);
		test.log(LogStatus.PASS, "Loan Status selected is: Ready to E-Sign");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						String LoanSts = driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[" + rnum + "]/td[13]"))
								.getText();
						test.log(LogStatus.PASS, "Current Loan status is : " + LoanSts);
						System.out.println("Loan Number matched. current row num is " + rnum);
						System.out.println("Loan Status is " + LoanSts);

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		/*
		 * String LoanSts = driver .findElement( By.xpath(
		 * "/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"
		 * )) .getText(); String re = "Ready to E-Sign"; if
		 * (LoanSts.equalsIgnoreCase(re)) { test.log(LogStatus.PASS,
		 * "Loan is in 'Ready to E-Sign' status"); }
		 */

	}

	public void LMS_ReadyToEsign_VA(String CP_NewPswd, String csoSelect, String eSignCustName, String LoanNum, String CustomerPortal_URL,
			String CP_Username, String CP_ConfirmNewPswd, ExtentTest test) throws InterruptedException {

		
		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		
		
		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(500);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS, "CSO selected is: "+csoSelect);

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(1);
		test.log(LogStatus.PASS, "Loan Status selected is: Ready to E-Sign");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						String LoanSts = driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[" + rnum + "]/td[13]"))
								.getText();
						test.log(LogStatus.PASS, "Current Loan status is : " + LoanSts);
						System.out.println("Loan Number matched. current row num is " + rnum);
						System.out.println("Loan Status is " + LoanSts);

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		/*
		 * String LoanSts = driver .findElement( By.xpath(
		 * "/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"
		 * )) .getText(); String re = "Ready to E-Sign"; if
		 * (LoanSts.equalsIgnoreCase(re)) { test.log(LogStatus.PASS,
		 * "Loan is in 'Ready to E-Sign' status"); }
		 */

	}

	public void Disburse_Funds(String LoanNum, String csoSelect, ExtentTest test) throws InterruptedException {

		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.switchTo().frame(top);
		driver.findElement(LMS_DirectlendMgmt_TAB).click();
		test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		Actions a1 = new Actions(driver);
		a1.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(500);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS, "CSO selected is: "+csoSelect);

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(3);
		test.log(LogStatus.PASS, "Loan Status selected is: Pending Funding");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {

						String pf = "Pending Funding";
						String Loansts = driver
								.findElement(By
										.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
								.getText();
						if (Loansts.equalsIgnoreCase(pf)) {

							test.log(LogStatus.PASS, "Loan is in Pending Funding status");
						}

						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
										+ rnum + "]/td[14]/input"))
								.click();
					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		// driver.findElement(LMS_GO_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Go Button for the loan record displayed in search results");

		String winHandleBefore6 = driver.getWindowHandle();
		driver.findElement(LMS_UploadDoc_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Upload Document Button in Loan Summary screen");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// Loan Agreement Upload
		driver.findElement(By.id("doc101")).click();
		test.log(LogStatus.PASS,
				"Clicked on Loan Agreement Document checkbox in Allotment Lending document upload process screen");

		WebElement uploadElement = driver.findElement(By.name("uploadDocs[9]"));

		// enter the file path onto the file-selection input field

		String fileName="pdf-sample1.pdf";
		String uploadDocPath=System.getProperty("user.dir")+"/Upload Documents/" +fileName;
		uploadElement.sendKeys(uploadDocPath);
		test.log(LogStatus.PASS, "Uploaded PDA Agreement Document");

		Thread.sleep(500);
		driver.findElement(By
				.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[13]/td[2]/label/input[2]"))
				.click();
		test.log(LogStatus.PASS, "Clicked on Submit button in document upload process screen");

		driver.findElement(By.id("button")).click();
		test.log(LogStatus.PASS, "Clicked on Ok button Confirmation Pop-up");

		driver.switchTo().window(winHandleBefore6);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);

		Thread.sleep(500);
		if (driver.findElement(By.id("printCheck10")).isEnabled()) {
			test.log(LogStatus.PASS, "Disburse Funds button is enabled");
		}

		driver.findElement(By.id("printCheck10")).click();
		test.log(LogStatus.PASS, "Clicked on Disburse Funds button in Loan Summary screen");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")));
		if (driver
				.findElement(
						By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input"))
				.isDisplayed()) {
			test.log(LogStatus.PASS, "Loan originated successfully");
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")));
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();
		driver.switchTo().window(winHandleBefore6);
		Thread.sleep(2000);
	}

	public void Disburse_Funds_USPS(String LoanNum, ExtentTest test) throws InterruptedException {

		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.switchTo().frame(top);
		driver.findElement(LMS_DirectlendMgmt_TAB).click();
		test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		Actions a1 = new Actions(driver);
		a1.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(500);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByIndex(8);
		test.log(LogStatus.PASS, "CSO selected is: FWA-GO");

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(3);
		test.log(LogStatus.PASS, "Loan Status selected is: Pending Verification");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {

						String pf = "Pending Funding";
						String Loansts = driver
								.findElement(By
										.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
								.getText();
						if (Loansts.equalsIgnoreCase(pf)) {

							test.log(LogStatus.PASS, "Loan is in Pending Funding status");
						}

						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
										+ rnum + "]/td[13]/input"))
								.click();
					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		// driver.findElement(LMS_GO_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Go Button for the loan record displayed in search results");

		String winHandleBefore6 = driver.getWindowHandle();
		driver.findElement(LMS_UploadDoc_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Upload Document Button in Loan Summary screen");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// Loan Agreement Upload
		driver.findElement(By.id("doc19")).click();
		test.log(LogStatus.PASS, "Clicked on checkbox in Allotment Lending document upload process screen");

		WebElement uploadElement = driver.findElement(By.name("uploadDocs[8]"));

		// enter the file path onto the file-selection input field

		String fileName="pdf-sample1.pdf";
		String uploadDocPath=System.getProperty("user.dir")+"/Upload Documents/" +fileName;
		uploadElement.sendKeys(uploadDocPath);
		test.log(LogStatus.PASS, "Uploaded Allotment Document in Allotment Lending document upload process pop-up");

		Thread.sleep(500);
		driver.findElement(By
				.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[15]/td[2]/label/input[2]"))
				.click();
		test.log(LogStatus.PASS, "Clicked on Submit button in document upload process screen");

		driver.findElement(By.id("button")).click();
		test.log(LogStatus.PASS, "Clicked on Ok button Confirmation Pop-up");

		driver.switchTo().window(winHandleBefore6);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);

		Thread.sleep(500);
		if (driver.findElement(By.id("printCheck10")).isEnabled()) {
			test.log(LogStatus.PASS, "Disburse Funds button is enabled");
		}

		driver.findElement(By.id("printCheck10")).click();
		test.log(LogStatus.PASS, "Clicked on Disburse Funds button in Loan Summary screen");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")));
		if (driver
				.findElement(
						By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input"))
				.isDisplayed()) {
			test.log(LogStatus.PASS, "Loan originated successfully");
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")));
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();
		driver.switchTo().window(winHandleBefore6);
	}

	public void Disburse_Funds_VA(String LoanNum, ExtentTest test) throws InterruptedException {

		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.switchTo().frame(top);
		driver.findElement(LMS_DirectlendMgmt_TAB).click();
		test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		Actions a1 = new Actions(driver);
		a1.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(LMS_ApplicationQueue_Menu));
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(1000);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByIndex(9);
		test.log(LogStatus.PASS, "CSO selected is: FWA-GO");

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(3);
		test.log(LogStatus.PASS, "Loan Status selected is: Pending Funding");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {

						String pf = "Pending Funding";
						String Loansts = driver
								.findElement(By
										.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
								.getText();
						if (Loansts.equalsIgnoreCase(pf)) {

							test.log(LogStatus.PASS, "Loan is in Pending Funding status");
						}

						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
										+ rnum + "]/td[13]/input"))
								.click();
					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		// driver.findElement(LMS_GO_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Go Button for the loan record displayed in search results");

		String winHandleBefore6 = driver.getWindowHandle();
		driver.findElement(LMS_UploadDoc_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Upload Document Button in Loan Summary screen");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// Loan Agreement Upload
		driver.findElement(By.id("doc19")).click();
		test.log(LogStatus.PASS, "Clicked on checkbox in Allotment Lending document upload process screen");

		WebElement uploadElement = driver.findElement(By.name("uploadDocs[8]"));

		// enter the file path onto the file-selection input field

		String fileName="pdf-sample1.pdf";
		String uploadDocPath=System.getProperty("user.dir")+"/Upload Documents/" +fileName;
		uploadElement.sendKeys(uploadDocPath);
		test.log(LogStatus.PASS, "Uploaded Allotment Document in Allotment Lending document upload process pop-up");

		Thread.sleep(500);
		driver.findElement(By
				.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[15]/td[2]/label/input[2]"))
				.click();
		test.log(LogStatus.PASS, "Clicked on Submit button in document upload process screen");

		driver.findElement(By.id("button")).click();
		test.log(LogStatus.PASS, "Clicked on Ok button Confirmation Pop-up");

		driver.switchTo().window(winHandleBefore6);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);

		Thread.sleep(500);
		if (driver.findElement(By.id("printCheck10")).isEnabled()) {
			test.log(LogStatus.PASS, "Disburse Funds button is enabled");
		}

		driver.findElement(By.id("printCheck10")).click();
		test.log(LogStatus.PASS, "Clicked on Disburse Funds button in Loan Summary screen");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")));
		if (driver
				.findElement(
						By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input"))
				.isDisplayed()) {
			test.log(LogStatus.PASS, "Loan originated successfully");
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")));
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();
		driver.switchTo().window(winHandleBefore6);
	}

	public void LMS_PendingVerification_HRB_Loans(String LMS_APP_URL, String csoSelect, String LMS_UserName, String LMS_Password,
			String LoanNum, ExtentTest test) throws InterruptedException {
		
		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		
		driver.switchTo().frame(top);
		driver.findElement(LMS_DirectlendMgmt_TAB).click();
		test.log(LogStatus.PASS, "Clicked on Direct Lend Mgmt Tab");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(500);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS, "CSO selected is: HR Buttler");

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(2);
		test.log(LogStatus.PASS, "Loan Status selected is: Pending Verification");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		Thread.sleep(500);

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
										+ rnum + "]/td[13]/input"))
								.click();
						System.out.println(" Loan Number matched. current row num " + rnum);
						Thread.sleep(500);

						String pv = "Pending Verification";
						String Loansts = driver
								.findElement(By
										.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
								.getText();

						if (Loansts.equalsIgnoreCase(pv)) {
							System.out.println(pv);
							test.log(LogStatus.PASS, "Loan is in 'Pending Verification' status");
						}
						Thread.sleep(500);
						driver.findElement(LMS_GO_BTN).click();
						test.log(LogStatus.PASS,
								"Clicked on Go Button for the loan record displayed in search results");

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		// Verification Screen
		// Customer Information section

		Thread.sleep(500);

		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.elementToBeClickable(LMS_IdVerification_LINK));
		driver.findElement(LMS_IdVerification_LINK).click();
		test.log(LogStatus.PASS, "Clicked on ID Verification hyperlink under Customer Information section");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");

		driver.switchTo().window(winHandleBefore);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_IdVerified_CHK));
		driver.findElement(LMS_IdVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on ID Verification - Verify checkbox under Customer Information section");

		Thread.sleep(500);

		driver.findElement(LMS_AddrVerification_LINK).click();
		test.log(LogStatus.PASS, "Clicked on Address Verification hyperlink under Customer Information section");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
		driver.switchTo().window(winHandleBefore);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_AdrVerified_CHK));

		driver.findElement(LMS_AdrVerified_CHK).click();
		test.log(LogStatus.PASS,
				"Clicked on Address Verification - Verify checkbox under Customer Information section");

		Thread.sleep(500);
		if (driver.findElement(LMS_HomePhoneReceived_CHK).isSelected()) {
			test.log(LogStatus.PASS, "Clicked on Cell Phone Verified checkbox Customer Information section");
		} else {

			driver.findElement(LMS_HomePhone_LINK).click();
			test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr hyperlink under Customer Information section");

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			driver.findElement(
					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
					.click();
			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
			driver.switchTo().window(winHandleBefore);

		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verify5")));

		driver.findElement(LMS_HomePhoneVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr - - Received checkbox under Customer Information section");

		Thread.sleep(500);
		if (driver.findElement(LMS_CellPhoneReceived_CHK).isSelected()) {
			test.log(LogStatus.PASS, "Clicked on Cell Phone Verified checkbox Customer Information section");
		} else {

			driver.findElement(LMS_CellPhone_LINK).click();
			test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr hyperlink under Customer Information section");

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			driver.findElement(
					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
					.click();
			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
			driver.switchTo().window(winHandleBefore);

		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verify5")));

		driver.findElement(LMS_CellPhoneVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr - - Received checkbox under Customer Information section");

		driver.findElement(LMS_Complete1_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Complete button for Customer Information section");

		// **********Employer Information section

		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		driver.findElement(LMS_ProofOfIncome_LINK).click();
		test.log(LogStatus.PASS, "Clicked on Proof of Income hyperlink under Employer Information section");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
		driver.switchTo().window(winHandleBefore);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ProofOfIncome_LINK));

		driver.findElement(LMS_ProofOfIncome_LINK).click();
		test.log(LogStatus.PASS, "Clicked on Proof of Income - Received checkbox under Employer Information section");

		driver.findElement(LMS_IncomeVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Proof of Income - Verify checkbox under Employer Information section");

		Thread.sleep(500);
		if (driver.findElement(LMS_SupervisorReceived_CHK).isSelected()) {
			test.log(LogStatus.PASS, "Clicked on Supervisor - Received checkbox under Employer Information section");
		} else {

			driver.findElement(LMS_Supervisor_LINK).click();
			test.log(LogStatus.PASS, "Clicked on Supervisor hyperlink under Employer Information section");

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			driver.findElement(
					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
					.click();
			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
			driver.switchTo().window(winHandleBefore);

		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_SupervisorVerified_CHK));

		driver.findElement(LMS_SupervisorVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Supervisor - Verify checkbox under Employer Information section");

		Thread.sleep(500);

		if (driver.findElement(LMS_WorkPhoneReceived_CHK).isSelected()) {
			test.log(LogStatus.PASS, "Clicked on Work Phone Nbr Received Checkbox under Employer Information section");
		} else {

			driver.findElement(LMS_WorkPhone_LINK).click();
			test.log(LogStatus.PASS, "Clicked on Work Phone Nbr hyperlink under Employer Information section");

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			driver.findElement(
					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
					.click();
			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
			driver.switchTo().window(winHandleBefore);
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		driver.findElement(LMS_WorkPhoneVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Work Phone Nbr - Verify checkbox under Employer Information section");

		driver.findElement(LMS_Complete2_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Complete button for Employer Information section");

		// Banking Details section

		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);

		driver.findElement(LMS_BankDetails_LINK).click();
		test.log(LogStatus.PASS, "Clicked on Bank Statement - Received checkbox under Banking Details section");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
		driver.switchTo().window(winHandleBefore);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verify9")));

		driver.findElement(LMS_BankDetailsVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Bank Statement - Verify checkbox under Banking Details section");

		driver.findElement(LMS_Complete3_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Complete' button for Banking Details section");

		driver.findElement(LMS_SubmitForUnderwriting_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Submit for Underwriting' button in Verification screen");

	}

	public void LMS_ReadyToEsign_HRB_Loans(String CP_NewPswd, String csoSelect,  String eSignCustName, String LoanNum,
			String CustomerPortal_URL, String CP_Username, String CP_ConfirmNewPswd, ExtentTest test)
			throws InterruptedException {

		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		
		
		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(500);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS, "CSO selected is: HR Buttler");

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(1);
		test.log(LogStatus.PASS, "Loan Status selected is: Ready to E-Sign");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						String LoanSts = driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[" + rnum + "]/td[13]"))
								.getText();
						test.log(LogStatus.PASS, "Current Loan status is : " + LoanSts);
						System.out.println("Loan Number matched. current row num is " + rnum);
						System.out.println("Loan Status is " + LoanSts);

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		

	}

	public void Disburse_Funds_HRB_loans(String LoanNum, String UploadDocPath, ExtentTest test) throws InterruptedException {

		
		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		
		driver.switchTo().frame(top);
		driver.findElement(LMS_DirectlendMgmt_TAB).click();
		test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		Actions a1 = new Actions(driver);
		a1.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(1000);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(1000);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByIndex(3);
		test.log(LogStatus.PASS, "CSO selected is: HR Buttler");

		Thread.sleep(1000);
		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(3);
		test.log(LogStatus.PASS, "Loan Status selected is: Pending Funding");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(html_Table));

		try {
			WebElement htmltable = driver
					.findElement(html_Table);
						
			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 3; rnum < rows.size(); rnum++) {
				System.out.println("current row num required " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum <= 2; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						//
						String pf = "Pending Funding";
						String Loansts = driver
								.findElement(By
										.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
								.getText();
						if (Loansts.equalsIgnoreCase(pf)) {

							test.log(LogStatus.PASS, "Loan is in Pending Funding status");
						}
						
						System.out.println("current row num " + rnum);
						driver.findElement(

								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
										+ rnum + "]/td[13]/input"))
								.click();
						

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}

				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		// driver.findElement(LMS_GO_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Go Button for the loan record displayed in search results");

		String winHandleBefore6 = driver.getWindowHandle();
		driver.findElement(LMS_UploadDoc_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Upload Document Button in Loan Summary screen");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// Loan Agreement Upload
		driver.findElement(By.id("doc101")).click();
		test.log(LogStatus.PASS,
				"Clicked on PDA Agreement Document checkbox in Allotment Lending document upload process screen");
		Thread.sleep(500);
		WebElement uploadElement = driver.findElement(By.name("uploadDocs[9]"));

		// enter the file path onto the file-selection input field

//		String A = "C:\\Users\\shanmukha.p\\Pictures\\sp12.png";
		uploadElement.sendKeys(UploadDocPath);
		test.log(LogStatus.PASS, "Uploaded Loan Agreement Document");

		
		driver.findElement(By
				.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[13]/td[2]/label/input[2]"))
				.click();
		
		test.log(LogStatus.PASS, "Clicked on Submit button in Allotment Lending document upload process screen");
		Thread.sleep(500);
		driver.findElement(By.id("button")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Ok button Confirmation Pop-up");

		driver.switchTo().window(winHandleBefore6);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);

		Thread.sleep(500);
		if (driver.findElement(By.id("printCheck10")).isEnabled()) {
			test.log(LogStatus.PASS, "Disburse Funds button is enabled");
		}

		driver.findElement(By.id("printCheck10")).click();
		test.log(LogStatus.PASS, "Clicked on Disburse Funds button in Loan Summary screen");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(500);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")));
		if (driver
				.findElement(
						By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input"))
				.isDisplayed()) {
			test.log(LogStatus.PASS, "Loan originated successfully");
			Thread.sleep(1000);
		}
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")));
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();
		driver.switchTo().window(winHandleBefore6);
	}
	public void LMS_PendingVerification_EMP_Loans(String LMS_APP_URL, String csoSelect, String LMS_UserName, String LMS_Password,
			String LoanNum, ExtentTest test) throws InterruptedException {
		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		
		driver.switchTo().frame(top);
		driver.findElement(LMS_DirectlendMgmt_TAB).click();
		test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(500);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS, "CSO selected is: CareWorks");

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(2);
		test.log(LogStatus.PASS, "Loan Status selected is: Pending Verification");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		Thread.sleep(500);

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
										+ rnum + "]/td[13]/input"))
								.click();
						System.out.println(" Loan Number matched. current row num " + rnum);
						Thread.sleep(500);

						String pv = "Pending Verification";
						String Loansts = driver
								.findElement(By
										.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
								.getText();

						if (Loansts.equalsIgnoreCase(pv)) {
							System.out.println(pv);
							test.log(LogStatus.PASS, "Loan is in 'Pending Verification' status");
						}
						Thread.sleep(500);
						driver.findElement(LMS_GO_BTN).click();
						test.log(LogStatus.PASS,
								"Clicked on Go Button for the loan record displayed in search results");

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		// Verification Screen
		// Customer Information section

		Thread.sleep(500);

		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.elementToBeClickable(LMS_IdVerification_LINK));
		driver.findElement(LMS_IdVerification_LINK).click();
		test.log(LogStatus.PASS, "Clicked on ID Verification hyperlink under Customer Information section");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");

		driver.switchTo().window(winHandleBefore);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_IdVerified_CHK));
		driver.findElement(LMS_IdVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on ID Verification - Verify checkbox under Customer Information section");

		Thread.sleep(500);

		driver.findElement(LMS_AddrVerification_LINK).click();
		test.log(LogStatus.PASS, "Clicked on Address Verification hyperlink under Customer Information section");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
		driver.switchTo().window(winHandleBefore);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_AdrVerified_CHK));

		driver.findElement(LMS_AdrVerified_CHK).click();
		test.log(LogStatus.PASS,
				"Clicked on Address Verification - Verify checkbox under Customer Information section");

		Thread.sleep(500);
		if (driver.findElement(LMS_HomePhoneReceived_CHK).isSelected()) {
			test.log(LogStatus.PASS, "Clicked on Cell Phone Verified checkbox Customer Information section");
		} else {

			driver.findElement(LMS_HomePhone_LINK).click();
			test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr hyperlink under Customer Information section");

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			driver.findElement(
					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
					.click();
			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
			driver.switchTo().window(winHandleBefore);

		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verify5")));

		driver.findElement(LMS_HomePhoneVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr - - Received checkbox under Customer Information section");

		Thread.sleep(500);
		if (driver.findElement(LMS_CellPhoneReceived_CHK).isSelected()) {
			test.log(LogStatus.PASS, "Clicked on Cell Phone Verified checkbox Customer Information section");
		} else {

			driver.findElement(LMS_CellPhone_LINK).click();
			test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr hyperlink under Customer Information section");

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			driver.findElement(
					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
					.click();
			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
			driver.switchTo().window(winHandleBefore);

		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verify5")));

		driver.findElement(LMS_CellPhoneVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Cell Phone Nbr - - Received checkbox under Customer Information section");

		driver.findElement(LMS_Complete1_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Complete button for Customer Information section");

		// **********Employer Information section

		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		driver.findElement(LMS_ProofOfIncome_LINK).click();
		test.log(LogStatus.PASS, "Clicked on Proof of Income hyperlink under Employer Information section");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
		driver.switchTo().window(winHandleBefore);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ProofOfIncome_LINK));

		driver.findElement(LMS_ProofOfIncome_LINK).click();
		test.log(LogStatus.PASS, "Clicked on Proof of Income - Received checkbox under Employer Information section");

		driver.findElement(LMS_IncomeVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Proof of Income - Verify checkbox under Employer Information section");

		Thread.sleep(500);
		if (driver.findElement(LMS_SupervisorReceived_CHK).isSelected()) {
			test.log(LogStatus.PASS, "Clicked on Supervisor - Received checkbox under Employer Information section");
		} else {

			driver.findElement(LMS_Supervisor_LINK).click();
			test.log(LogStatus.PASS, "Clicked on Supervisor hyperlink under Employer Information section");

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			driver.findElement(
					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
					.click();
			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
			driver.switchTo().window(winHandleBefore);

		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_SupervisorVerified_CHK));

		driver.findElement(LMS_SupervisorVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Supervisor - Verify checkbox under Employer Information section");

		Thread.sleep(500);

		if (driver.findElement(LMS_WorkPhoneReceived_CHK).isSelected()) {
			test.log(LogStatus.PASS, "Clicked on Work Phone Nbr Received Checkbox under Employer Information section");
		} else {

			driver.findElement(LMS_WorkPhone_LINK).click();
			test.log(LogStatus.PASS, "Clicked on Work Phone Nbr hyperlink under Employer Information section");

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			driver.findElement(
					By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input"))
					.click();
			test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
			driver.switchTo().window(winHandleBefore);
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		driver.findElement(LMS_WorkPhoneVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Work Phone Nbr - Verify checkbox under Employer Information section");

		driver.findElement(LMS_Complete2_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Complete button for Employer Information section");

		// Banking Details section

		Thread.sleep(500);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);

		driver.findElement(LMS_BankDetails_LINK).click();
		test.log(LogStatus.PASS, "Clicked on Bank Statement - Received checkbox under Banking Details section");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td/input")).click();
		test.log(LogStatus.PASS, "Clicked on ok button in Doc Info window");
		driver.switchTo().window(winHandleBefore);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verify9")));

		driver.findElement(LMS_BankDetailsVerified_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Bank Statement - Verify checkbox under Banking Details section");

		driver.findElement(LMS_Complete3_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Complete' button for Banking Details section");

		driver.findElement(LMS_SubmitForUnderwriting_BTN).click();
		test.log(LogStatus.PASS, "Clicked on 'Submit for Underwriting' button in Verification screen");

	}

	public void LMS_ReadyToEsign_EMP_Loans(String CP_NewPswd, String csoSelect, String eSignCustName, String LoanNum,
			String CustomerPortal_URL, String CP_Username, String CP_ConfirmNewPswd, ExtentTest test)
			throws InterruptedException {
		
		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(500);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS, "CSO selected is: CareWorks");

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(1);
		test.log(LogStatus.PASS, "Loan Status selected is: Ready to E-Sign");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 2; rnum < rows.size(); rnum++) {
				System.out.println("current row num " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum == 1; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						// rnum = rnum + 1;
						System.out.println("current row num " + rnum);
						String LoanSts = driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[" + rnum + "]/td[13]"))
								.getText();
						test.log(LogStatus.PASS, "Current Loan status is : " + LoanSts);
						System.out.println("Loan Number matched. current row num is " + rnum);
						System.out.println("Loan Status is " + LoanSts);

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}
				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}


	}

	public void Disburse_Funds_EMP_loans(String LoanNum, ExtentTest test) throws InterruptedException {
		
		WebElement top=driver.findElement(By.id("topFrame"));
		WebElement mainFrame=driver.findElement(By.id("mainFrame"));
		WebElement main=driver.findElement(By.name("main"));
		
		driver.switchTo().frame(top);
		driver.findElement(LMS_DirectlendMgmt_TAB).click();
		test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(mainFrame);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
		Actions a1 = new Actions(driver);
		a1.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

		Thread.sleep(500);
		driver.findElement(LMS_ApplicationQueue_Menu).click();
		test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);
		Thread.sleep(500);

		Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
		CSO.selectByIndex(1);
		test.log(LogStatus.PASS, "CSO selected is: CareWorks");

		Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
		LoanStatus.selectByIndex(3);
		test.log(LogStatus.PASS, "Loan Status selected is: Pending Verification");

		driver.findElement(LMS_Search_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Search Button");

		try {
			WebElement htmltable = driver
					.findElement(html_Table);

			// Getting Loan from search results
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			int count = 0;
			count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
					.size();
			for (int rnum = 3; rnum < rows.size(); rnum++) {
				System.out.println("current row num required " + rnum);
				List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
				System.out.println("columns Count " + columns.size());

				for (int cnum = 1; cnum <= 2; cnum++)// columns.size()
				{
					String LoanNumber = columns.get(cnum).getText();
					System.out.println("Application Loannumber " + LoanNumber);
					System.out.println("LoanNumberTestData " + LoanNum);

					if (LoanNumber.equals(LoanNum)) {
						//
						String pf = "Pending Funding";
						String Loansts = driver
								.findElement(By
										.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
								.getText();
						if (Loansts.equalsIgnoreCase(pf)) {

							test.log(LogStatus.PASS, "Loan is in Pending Funding status");
						}
						
						System.out.println("current row num " + rnum);
						driver.findElement(

								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
										+ rnum + "]/td[13]/input"))
						
								.click();

					} else {
						System.out.println("No Loan Number matched.current row num " + rnum);
					}

				}
			}

			Thread.sleep(500);
		}

		catch (Exception E) {
			System.out.println("Exception");
		}

		// driver.findElement(LMS_GO_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Go Button for the loan record displayed in search results");

		String winHandleBefore6 = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(LMS_UploadDoc_BTN));
		driver.findElement(LMS_UploadDoc_BTN).click();
		test.log(LogStatus.PASS, "Clicked on Upload Document Button in Loan Summary screen");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// Loan Agreement Upload
		driver.findElement(By.id("doc101")).click();
		test.log(LogStatus.PASS,
				"Clicked on PDA Agreement Document checkbox in Allotment Lending document upload process screen");
		Thread.sleep(500);
		WebElement uploadElement = driver.findElement(By.name("uploadDocs[9]"));

		// enter the file path onto the file-selection input field

		String fileName="pdf-sample1.pdf";
		String uploadDocPath=System.getProperty("user.dir")+"/Upload Documents/" +fileName;
		uploadElement.sendKeys(uploadDocPath);
		test.log(LogStatus.PASS, "Uploaded Loan Agreement Document");


		driver.findElement(By
				.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[13]/td[2]/label/input[2]"))
				.click();
		
		test.log(LogStatus.PASS, "Clicked on Submit button in Allotment Lending document upload process screen");
		Thread.sleep(500);
		driver.findElement(By.id("button")).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on Ok button Confirmation Pop-up");

		driver.switchTo().window(winHandleBefore6);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		driver.switchTo().frame(main);

		Thread.sleep(500);
		if (driver.findElement(By.id("printCheck10")).isEnabled()) {
			test.log(LogStatus.PASS, "Disburse Funds button is enabled");
		}

		driver.findElement(By.id("printCheck10")).click();
		test.log(LogStatus.PASS, "Clicked on Disburse Funds button in Loan Summary screen");
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(500);

		if (driver
				.findElement(
						By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input"))
				.isDisplayed()) {
			test.log(LogStatus.PASS, "Loan originated successfully");
		}

		driver.findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();
		driver.switchTo().window(winHandleBefore6);
	}




public void Disb_Funds(String LoanNum, String csoSelect, ExtentTest test) throws InterruptedException {

	
	WebElement top=driver.findElement(By.id("topFrame"));
	WebElement mainFrame=driver.findElement(By.id("mainFrame"));
	WebElement main=driver.findElement(By.name("main"));
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	Thread.sleep(2000);
	driver.switchTo().frame(top);
	driver.findElement(LMS_DirectlendMgmt_TAB).click();
	test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");
	driver.switchTo().defaultContent();

	driver.switchTo().frame(mainFrame);
	wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
	Actions a1 = new Actions(driver);
	a1.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

	Thread.sleep(1000);
	driver.findElement(LMS_ApplicationQueue_Menu).click();
	test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

	driver.switchTo().defaultContent();
	driver.switchTo().frame(mainFrame);
	driver.switchTo().frame(main);
	Thread.sleep(2000);

	Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
	CSO.selectByVisibleText(csoSelect);
	test.log(LogStatus.PASS, "CSO selected is: "+csoSelect);

	Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
	LoanStatus.selectByIndex(3);
	test.log(LogStatus.PASS, "Loan Status selected is: Pending Funding");

	driver.findElement(LMS_Search_BTN).click();
	test.log(LogStatus.PASS, "Clicked on Search Button");
	
	String parent = driver.getWindowHandle();
	System.out.println("parent window id is: "+parent);
/*	try {
		WebElement htmltable = driver
				.findElement(html_Table);

		// Getting Loan from search results
		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

		int count = 0;
		count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
				.size();
		for (int rnum = 2; rnum < rows.size(); rnum++) {
			System.out.println("current row num " + rnum);
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
			System.out.println("columns Count " + columns.size());

			for (int cnum = 1; cnum == 1; cnum++)// columns.size()
			{
				String LoanNumber = columns.get(cnum).getText();
				System.out.println("Application Loannumber " + LoanNumber);
				System.out.println("LoanNumberTestData " + LoanNum);

				if (LoanNumber.equals(LoanNum)) {

					String pf = "Pending Funding";
					String Loansts = driver
							.findElement(By
									.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
							.getText();
					if (Loansts.equalsIgnoreCase(pf)) {

						test.log(LogStatus.PASS, "Loan is in Pending Funding status");
					}

					// rnum = rnum + 1;
					System.out.println("current row num " + rnum);
					driver.findElement(
							By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
									+ rnum + "]/td[13]/input"))
							.click();
					
				} else {
					System.out.println("No Loan Number matched.current row num " + rnum);
				}
			}
		}

		Thread.sleep(500);
	}

	catch (Exception E) {
		System.out.println("Exception");
	}

	// driver.findElement(LMS_GO_BTN).click();
	test.log(LogStatus.PASS, "Clicked on Go Button for the loan record displayed in search results");
	Thread.sleep(5000);
	
//	Set<String> ids=driver.getWindowHandles();
//	java.util.Iterator<String> it=ids.iterator();
//	String parentid=it.next();
//	String childid=it.next();
//	driver.switchTo().window(childid);
//	wait.until(ExpectedConditions.elementToBeClickable(LMS_UploadDoc_BTN));
//	driver.findElement(LMS_UploadDoc_BTN).click();
	
	String childWindow = driver.getWindowHandle();
	System.out.println("Child id is: "+childWindow);
	Set <String>winHandle1 = driver.getWindowHandles();
	System.out.println("winwinHandle"+winHandle1);
	for (String winHandle : driver.getWindowHandles()) {
		
		if(!parent.equalsIgnoreCase(winHandle))
		{
			
		driver.switchTo().window(winHandle);
		String wintitle=driver.switchTo().window(winHandle).getTitle();
		WebElement embedframe = driver.findElement(By.tagName("embed"));
		driver.switchTo().frame(embedframe);
		driver.findElement(LMS_UploadDoc_BTN).click();
		
	test.log(LogStatus.PASS, "Clicked on Upload Document Button in Loan Summary screen");
		}
	}
	
	String childWindow1 = driver.getWindowHandle();
	for (String winHandle : driver.getWindowHandles()) {
		if(!winHandle.equalsIgnoreCase(parent)&&!winHandle.equalsIgnoreCase(childWindow1))
		{
		driver.switchTo().window(winHandle);
	
	// Loan Agreement Upload
	driver.findElement(By.id("doc101")).click();
	test.log(LogStatus.PASS,
			"Clicked on Loan Agreement Document checkbox in Allotment Lending document upload process screen");

	WebElement uploadElement = driver.findElement(By.name("uploadDocs[9]"));

	// enter the file path onto the file-selection input field

	String fileName="pdf-sample1.pdf";
	String uploadDocPath=System.getProperty("user.dir")+"/Upload Documents/" +fileName;
	uploadElement.sendKeys(uploadDocPath);
	test.log(LogStatus.PASS, "Uploaded PDA Agreement Document");

	Thread.sleep(500);
	driver.findElement(By.xpath("//input[@type='button' and @value='Submit']")).click();
	test.log(LogStatus.PASS, "Clicked on Submit button in document upload process screen");

	driver.findElement(By.id("button")).click();
	test.log(LogStatus.PASS, "Clicked on Ok button Confirmation Pop-up");
		}
	}
	
	driver.switchTo().window(parent);

	driver.switchTo().defaultContent();
	driver.switchTo().frame(mainFrame);
	driver.switchTo().frame(main);*/
	
try {
WebElement htmltable = driver
		.findElement(html_Table);

// Getting Loan from search results
List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

int count = 0;
count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
		.size();
for (int rnum = 2; rnum < rows.size(); rnum++) {
	System.out.println("current row num " + rnum);
	List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
	System.out.println("columns Count " + columns.size());

	for (int cnum = 1; cnum == 1; cnum++)// columns.size()
	{
		String LoanNumber = columns.get(cnum).getText();
		System.out.println("Application Loannumber " + LoanNumber);
		System.out.println("LoanNumberTestData " + LoanNum);

		if (LoanNumber.equals(LoanNum)) {

			String pf = "Pending Funding";
			String Loansts = driver
					.findElement(By
							.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
					.getText();
			if (Loansts.equalsIgnoreCase(pf)) {

				test.log(LogStatus.PASS, "Loan is in Pending Funding status");
			}

			// rnum = rnum + 1;
			System.out.println("current row num " + rnum);
			driver.findElement(
					By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
							+ rnum + "]/td[13]/input"))
					.click();
		} else {
			System.out.println("No Loan Number matched.current row num " + rnum);
		}
	}
}

Thread.sleep(500);
}

catch (Exception E) {
System.out.println("Exception");
}

for (String winHandle : driver.getWindowHandles()) {
	if(!parent.equalsIgnoreCase(winHandle))
	{	
		driver.switchTo().window(winHandle);
		WebElement embedframe= driver.findElement(By.tagName("embed"));
		driver.switchTo().frame(embedframe);

	Thread.sleep(500);
	if (driver.findElement(By.id("printCheck10")).isEnabled()) {
		test.log(LogStatus.PASS, "Disburse Funds button is enabled");
	driver.findElement(By.id("printCheck10")).click();
	test.log(LogStatus.PASS, "Clicked on Disburse Funds button in Loan Summary screen");
	Thread.sleep(5000);
//	driver.switchTo().defaultContent();
		
	}
}
}
String childWindow2=driver.getWindowHandle();
	for (String winHandle : driver.getWindowHandles()) {
		if(!childWindow2.equalsIgnoreCase(winHandle) && !winHandle.equalsIgnoreCase(parent) )
		{	
			driver.switchTo().window(winHandle);

Thread.sleep(500);

if (driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).isDisplayed()) {
	test.log(LogStatus.PASS, "Loan originated successfully");
	driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input")).click();
	Thread.sleep(5000);
}
		}
driver.switchTo().window(parent);

}
}




public void upload_Docs(String LoanNum, String csoSelect, ExtentTest test) throws InterruptedException {

	WebElement top=driver.findElement(By.id("topFrame"));
	WebElement mainFrame=driver.findElement(By.id("mainFrame"));
	WebElement main=driver.findElement(By.name("main"));
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	Thread.sleep(5000);
	driver.switchTo().frame(top);
	driver.findElement(LMS_DirectlendMgmt_TAB).click();
	test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");
	driver.switchTo().defaultContent();

	driver.switchTo().frame(mainFrame);
	wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
	Actions a1 = new Actions(driver);
	a1.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

	Thread.sleep(1000);
	driver.findElement(LMS_ApplicationQueue_Menu).click();
	test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

	driver.switchTo().defaultContent();
	driver.switchTo().frame(mainFrame);
	driver.switchTo().frame(main);
	Thread.sleep(2000);

	Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
	CSO.selectByVisibleText(csoSelect);
	test.log(LogStatus.PASS, "CSO selected is: Veterans Affairs - OH");

	Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
	LoanStatus.selectByIndex(3);
	test.log(LogStatus.PASS, "Loan Status selected is: Pending Funding");

	driver.findElement(LMS_Search_BTN).click();
	test.log(LogStatus.PASS, "Clicked on Search Button");
	
	String parent = driver.getWindowHandle();
	System.out.println("parent window id is: "+parent);
	try {
		WebElement htmltable = driver
				.findElement(html_Table);

		// Getting Loan from search results
		List<WebElement> rows = htmltable.findElements(htmlTable_Rows);

		int count = 0;
		count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
				.size();
		for (int rnum = 2; rnum < rows.size(); rnum++) {
			System.out.println("current row num " + rnum);
			List<WebElement> columns = rows.get(rnum).findElements(htmlTable_Columns);
			System.out.println("columns Count " + columns.size());

			for (int cnum = 1; cnum == 1; cnum++)// columns.size()
			{
				String LoanNumber = columns.get(cnum).getText();
				System.out.println("Application Loannumber " + LoanNumber);
				System.out.println("LoanNumberTestData " + LoanNum);

				if (LoanNumber.equals(LoanNum)) {

					String pf = "Pending Funding";
					String Loansts = driver.findElement(loanstatus_LBL).getText();
					if (Loansts.equalsIgnoreCase(pf)) {

						test.log(LogStatus.PASS, "Loan is in Pending Funding status");
					}

					// rnum = rnum + 1;
					System.out.println("current row num " + rnum);
					driver.findElement(
							By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
									+ rnum + "]/td[14]/input"))
							.click();
					
				} else {
					System.out.println("No Loan Number matched.current row num " + rnum);
				}
			}
		}

		Thread.sleep(500);
	}

	catch (Exception E) {
		System.out.println("Exception");
	}

	test.log(LogStatus.PASS, "Clicked on Go Button for the loan record displayed in search results");
	Thread.sleep(1000);
	
	
	String childWindow = driver.getWindowHandle();
	System.out.println("Child id is: "+childWindow);
	Set <String>winHandle1 = driver.getWindowHandles();
	System.out.println("winwinHandle"+winHandle1);
	for (String winHandle : driver.getWindowHandles()) {
		
		if(!parent.equalsIgnoreCase(winHandle))
		{
			
		driver.switchTo().window(winHandle);
		String wintitle=driver.switchTo().window(winHandle).getTitle();
		WebElement embedframe = driver.findElement(By.tagName("embed"));
		driver.switchTo().frame(embedframe);
		driver.findElement(LMS_UploadDoc_BTN_USPS).click();
		
	test.log(LogStatus.PASS, "Clicked on Upload Document Button in Loan Summary screen");
		}
	}
	driver.switchTo().defaultContent();
	String childWindow1 = driver.getWindowHandle();
	for (String winHandle : driver.getWindowHandles()) {
		if(!winHandle.equalsIgnoreCase(parent)&&!winHandle.equalsIgnoreCase(childWindow1))
		{
		driver.switchTo().window(winHandle);
	
	// Loan Agreement Upload
//	driver.findElement(By.id("doc101")).click();
//	test.log(LogStatus.PASS,"Clicked on Loan Agreement Document checkbox in Allotment Lending document upload process screen");

	WebElement uploadElement = driver.findElement(By.name("uploadDocs[9]"));

	// enter the file path onto the file-selection input field

	String fileName="pdf-sample1.pdf";
	String uploadDocPath=System.getProperty("user.dir")+"/Upload Documents/" +fileName;
	uploadElement.sendKeys(uploadDocPath);
	test.log(LogStatus.PASS, "Uploaded PDA Agreement Document");

	Thread.sleep(500);
	driver.findElement(By.xpath("//input[@type='button' and @value='Submit']")).click();
	test.log(LogStatus.PASS, "Clicked on Submit button in document upload process screen");

	driver.findElement(By.id("button")).click();
	test.log(LogStatus.PASS, "Clicked on Ok button Confirmation Pop-up");
		}
		driver.switchTo().window(parent);
	}
}




public void authorisedDisbFunds(String LoanNum, String csoSelect, ExtentTest test) throws InterruptedException {

	
	WebElement top=driver.findElement(By.id("topFrame"));
	WebElement mainFrame=driver.findElement(By.id("mainFrame"));
	WebElement main=driver.findElement(By.name("main"));
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	Thread.sleep(5000);
	driver.switchTo().frame(top);
	driver.findElement(LMS_DirectlendMgmt_TAB).click();
	test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");
	driver.switchTo().defaultContent();

	driver.switchTo().frame(mainFrame);
	wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
	Actions a1 = new Actions(driver);
	a1.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

	Thread.sleep(1000);
	driver.findElement(LMS_ApplicationQueue_Menu).click();
	test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

	driver.switchTo().defaultContent();
	driver.switchTo().frame(mainFrame);
	driver.switchTo().frame(main);
	Thread.sleep(2000);

	Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
	CSO.selectByVisibleText(csoSelect);
	test.log(LogStatus.PASS, "CSO selected is: "+csoSelect);

	Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
	LoanStatus.selectByIndex(3);
	test.log(LogStatus.PASS, "Loan Status selected is: Pending Funding");

	driver.findElement(LMS_Search_BTN).click();
	test.log(LogStatus.PASS, "Clicked on Search Button");
	
	String parent = driver.getWindowHandle();
	System.out.println("parent window id is: "+parent);
	try {
		WebElement htmltable = driver
				.findElement(html_Table);

		// Getting Loan from search results
		List<WebElement> rows = htmltable.findElements(htmlTable_Rows);

		int count = 0;
		count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
				.size();
		for (int rnum = 2; rnum < rows.size(); rnum++) {
			System.out.println("current row num " + rnum);
			List<WebElement> columns = rows.get(rnum).findElements(htmlTable_Columns);
			System.out.println("columns Count " + columns.size());

			for (int cnum = 1; cnum == 1; cnum++)// columns.size()
			{
				String LoanNumber = columns.get(cnum).getText();
				System.out.println("Application Loannumber " + LoanNumber);
				System.out.println("LoanNumberTestData " + LoanNum);

				if (LoanNumber.equals(LoanNum)) {

					String pf = "Pending Funding";
					String Loansts = driver.findElement(loanstatus_LBL).getText();
					if (Loansts.equalsIgnoreCase(pf)) {

						test.log(LogStatus.PASS, "Loan is in Pending Funding status");
					}

					// rnum = rnum + 1;
					System.out.println("current row num " + rnum);
					driver.findElement(
							By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
									+ rnum + "]/td[14]/input"))
							.click();
					
				} else {
					System.out.println("No Loan Number matched.current row num " + rnum);
				}
			}
		}
		test.log(LogStatus.PASS, "Clicked on 'Go' button for the loan record");
		Thread.sleep(500);
	}

		catch (Exception E) {
			System.out.println("Exception");
			}

	String parentwindow = driver.getWindowHandle();

	for (String handle : driver.getWindowHandles()) {

		if (!handle.equalsIgnoreCase(parentwindow)) {

			driver.switchTo().window(handle);
			
			WebElement embedFrame=driver.findElement(By.tagName("embed"));
			driver.switchTo().frame(embedFrame);
			
			wait.until(ExpectedConditions.elementToBeClickable(acceptPDA_rad));
			driver.findElement(acceptPDA_rad).click();
			Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Accept PDA document' radio button in View PDA Document Page");

			driver.findElement(submitPDA_btn).click();
			Thread.sleep(500);
			test.log(LogStatus.PASS,
					"Clicked on 'Submit' button in View PDA Document Page");
	/*Alert alert=driver.switchTo().alert();
	alert.accept();*/
	
		}

	}

	driver.switchTo().window(parentwindow);

	driver.switchTo().frame(top);
//
//	driver.findElement(By.id("7d")).click();
//	test.log(LogStatus.PASS, "Loan Originated Successfully");
}
public void LMS_LatestPendingVerification_USPS(String LoanNum, ExtentTest test) throws InterruptedException {
	
	WebElement top=driver.findElement(By.id("topFrame"));
	WebElement mainFrame=driver.findElement(By.id("mainFrame"));
	
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
	driver.switchTo().frame(top);
	Thread.sleep(1000);
	wait.until(ExpectedConditions.elementToBeClickable(LMS_DirectlendMgmt_TAB));
	driver.findElement(LMS_DirectlendMgmt_TAB).click();
	test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");

	driver.switchTo().defaultContent();

	driver.switchTo().frame(mainFrame);
	Actions a = new Actions(driver);
	wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
	Thread.sleep(500);
	a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

	Thread.sleep(500);
	driver.findElement(LMS_ApplicationQueue_Menu).click();
	test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

	driver.switchTo().defaultContent();
	driver.switchTo().frame(mainFrame);
	WebElement main=driver.findElement(By.name("main"));

	driver.switchTo().frame(main);
	Thread.sleep(500);

	Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
	CSO.selectByVisibleText("USPS - OH");
	test.log(LogStatus.PASS, "CSO selected is: USPS - OH");

	Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
	LoanStatus.selectByIndex(2);
	test.log(LogStatus.PASS, "Loan Status selected is: Pending Verification");

	driver.findElement(LMS_Search_BTN).click();
	test.log(LogStatus.PASS, "Clicked on Search Button");

	Thread.sleep(500);

	try {
		WebElement htmltable = driver
				.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td"));

		// Getting Loan from search results
		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

		int count = 0;
		count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
				.size();
		for (int rnum = 2; rnum < rows.size(); rnum++) {
			System.out.println("current row num " + rnum);
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
			System.out.println("columns Count " + columns.size());

			for (int cnum = 1; cnum == 1; cnum++)// columns.size()
			{
				String LoanNumber = columns.get(cnum).getText();
				
				System.out.println("Application Loannumber " + LoanNumber);
				System.out.println("LoanNumberTestData " + LoanNum);

				if (LoanNumber.equals(LoanNum)) {
					// rnum = rnum + 1;
					System.out.println("current row num " + rnum);
					driver.findElement(
							By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
									+ rnum + "]/td[14]/input"))
							.click();
					System.out.println(" Loan Number matched. current row num " + rnum);
					Thread.sleep(500);

					String pv = "Pending Verification";
					String Loansts = driver
							.findElement(By
									.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
							.getText();

					if (Loansts.equalsIgnoreCase(pv)) {
						System.out.println(pv);
						test.log(LogStatus.PASS, "Loan is in 'Pending Verification' status");
					}
					Thread.sleep(500);
					driver.findElement(LMS_GO_BTN).click();
					test.log(LogStatus.PASS,
							"Clicked on Go Button for the loan record displayed in search results");

				} else {
					System.out.println("No Loan Number matched.current row num " + rnum);
				}
			}
		}

		Thread.sleep(500);
	}

	catch (Exception E) {
		System.out.println(E);
	}

	// Verification Screen
	// Customer Information section

	Thread.sleep(500);

	String winHandleBefore = driver.getWindowHandle();
	driver.switchTo().defaultContent();
	driver.switchTo().frame(mainFrame);
	driver.switchTo().frame(main);
	wait.until(ExpectedConditions.elementToBeClickable(LMS_IdVerification_LINK));
	driver.findElement(LMS_IdReceived_CHK).click();
	test.log(LogStatus.PASS, "Clicked on ID Received checkbox under Customer Information section");

	// driver.switchTo().defaultContent();
	// driver.switchTo().frame(mainFrame);
	// driver.switchTo().frame(main);
	wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_IdVerified_CHK));
	driver.findElement(LMS_IdVerified_CHK).click();
	test.log(LogStatus.PASS, "Clicked on ID Verification - Verify checkbox under Customer Information section");

	Thread.sleep(500);

	if (driver.findElement(LMS_AdrReceived_CHK).isSelected()) {
		test.log(LogStatus.PASS, "Clicked on Address Received Checkbox under Customer Information section");
	} else {
		driver.findElement(LMS_AdrReceived_CHK).click();
		test.log(LogStatus.PASS, "Clicked on Address Received Checkbox under Customer Information section");
	}

	
	wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_AdrVerified_CHK));

	driver.findElement(LMS_AdrVerified_CHK).click();
	test.log(LogStatus.PASS,
			"Clicked on Address Verification - Verify checkbox under Customer Information section");

	Thread.sleep(500);
	
	driver.findElement(LMS_Complete1_BTN).click();
	test.log(LogStatus.PASS, "Clicked on Complete button for Customer Information section");

	// Banking Details section

	Thread.sleep(500);
	driver.switchTo().defaultContent();
	driver.switchTo().frame(mainFrame);
	driver.switchTo().frame(main);

	wait.until(ExpectedConditions.elementToBeClickable(LMS_SubmitForUnderwriting_BTN));
	driver.findElement(LMS_SubmitForUnderwriting_BTN).click();
	Thread.sleep(500);
	test.log(LogStatus.PASS, "Clicked on 'Submit' button in Verification screen");

}
public void PendingVerificationOlBnk(String csoSelect,String LoanNum, ExtentTest test) throws InterruptedException {
	
	WebElement top=driver.findElement(By.id("topFrame"));
	WebElement mainFrame=driver.findElement(By.id("mainFrame"));
	WebDriverWait wait = new WebDriverWait(driver, 100);
	
	driver.switchTo().frame(top);
	driver.findElement(LMS_DirectlendMgmt_TAB).click();
	test.log(LogStatus.PASS, "Clicked on Derect Lend Mgmt Tab");

	driver.switchTo().defaultContent();

	driver.switchTo().frame(mainFrame);
	Actions a = new Actions(driver);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(LMS_ApplicationMgmt_Menu));
	Thread.sleep(500);
	a.moveToElement(driver.findElement(LMS_ApplicationMgmt_Menu)).build().perform();

	Thread.sleep(500);
	driver.findElement(LMS_ApplicationQueue_Menu).click();
	test.log(LogStatus.PASS, "Clicked on Application Queue Submenu under Application Mgmt menu");

	//driver.switchTo().defaultContent();
	//driver.switchTo().frame(mainFrame);
	WebElement main=driver.findElement(By.name("main"));

	driver.switchTo().frame(main);
	Thread.sleep(500);

	Select CSO = new Select(driver.findElement(LMS_CSO_ID_DRP));
	CSO.selectByVisibleText(csoSelect);
	test.log(LogStatus.PASS, "CSO selected is: "+csoSelect);
	System.out.println(csoSelect);
	
	Select LoanStatus = new Select(driver.findElement(LMS_LoanStatus_DRP));
	LoanStatus.selectByIndex(2);
	test.log(LogStatus.PASS, "Loan Status selected is: Pending Verification");

	driver.findElement(LMS_Search_BTN).click();
	test.log(LogStatus.PASS, "Clicked on Search Button");

	Thread.sleep(500);

	try {
		WebElement htmltable = driver
				.findElement(html_Table);

		// Getting Loan from search results
		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
System.out.println("Rows"+rows.size());
		int count = 0;
		count = driver.findElements(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/tr"))
				.size();
		for (int rnum = 2; rnum < rows.size(); rnum++) {
			System.out.println("current row num " + rnum);
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
			System.out.println("columns Count " + columns.size());

			for (int cnum = 1; cnum == 1; cnum++)// columns.size()
			{
				String LoanNumber = columns.get(cnum).getText();
				System.out.println("Application Loannumber " + LoanNumber);
				System.out.println("LoanNumberTestData " + LoanNum);

				if (LoanNumber.equals(LoanNum)) {
					// rnum = rnum + 1;
					System.out.println("current row num " + rnum);
					driver.findElement(
							By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["
									+ rnum + "]/td[12]/input"))
							.click();
					
					System.out.println(" Loan Number matched. current row num " + rnum);
					Thread.sleep(500);

					String pv = "Pending Verification";
					String Loansts = driver
							.findElement(By
									.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[6]"))
							.getText();

					if (Loansts.equalsIgnoreCase(pv)) {
						System.out.println(pv);
						test.log(LogStatus.PASS, "Loan is in 'Pending Verification' status");
					}
					Thread.sleep(500);
					driver.findElement(LMS_GO_BTN).click();
					test.log(LogStatus.PASS,
							"Clicked on Go Button for the loan record displayed in search results");

				} else {
					System.out.println("No Loan Number matched.current row num " + rnum);
				}				
			}
			
		}
	}

	catch (Exception E) {
		System.out.println("Exception");
	}
}
public void pendVeriOlBnk(ExtentTest test) throws Exception{
	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.elementToBeClickable(By.id("received6")));
	driver.findElement(By.id("received6")).click();
	test.log(LogStatus.PASS, "Clicked on 'received' checkbox in pending verification screen");
	driver.findElement(By.id("verify9")).click();
	test.log(LogStatus.PASS, "Clicked on 'Verified' checkbox in pending verification screen");
	driver.findElement(By.id("submit3")).click();
	test.log(LogStatus.PASS, "Clicked on 'complete' button in pending verification screen");
	driver.findElement(By.id("savetwo")).click();
	test.log(LogStatus.PASS, "Clicked on 'Submit' button in pending verification screen");
	Thread.sleep(500);
	driver.switchTo().defaultContent();
}
}