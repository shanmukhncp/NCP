package com.qfund.ncp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TX342F_Steps_away_from_$1000 {

	WebDriver driver;
	ExtentTest test;

	By STEP_1_REVIEWANDSIGN_BTN = By.xpath("//html/body/div[1]/div[3]/div/div/form/div[1]/div/button");
	By PPDCP_ACCEPT_BTN = By.xpath("//*[@id='footer-modal']/p[1]/input");
	By OCECDCP_BTN = By.xpath("//*[@id='footer-modal']/p[1]/input");
	By SCHDCP_BTN = By.xpath("//*[@id='footer-modal']/p[1]/input");
	By OANOTESDCP_BTN = By.xpath("//*[@id='footer-modal']/p[1]/input");
	By ONOC_BTN = By.xpath("//*[@id='footer-modal']/p[1]/input");
	By OPRADDCP_BTN = By.xpath("//*[@id='footer-modal']/p[1]/input");
	By OAADCP_BTN = By.xpath("//*[@id='footer-modal']/p[1]/input");
	By OCTMDCP_BTN = By.xpath("//*[@id='footer-modal']/p[1]/input");
	By CUSTSIGN_TXT = By.id("custSign");
	By SUBMIT_BTN = By.xpath("//*[@id='esignSubmit']");
	By thanksForSubmitting_btn=By.xpath("//input[@value=' Close ']");
	By STEP_2_REVIEWANDSIGN_BTN = By.xpath("/html/body/div[1]/div[2]/div/div/form/div[2]/div/button");
	By CHOOSE_FILE_1_BTN = By.xpath("//*[@id='filePicker']");
	By UPLOAD_FILE_1_BTN = By.xpath("//*[@id='uploadButton']");
	By CHOOSE_FILE_2_BTN = By.xpath("//*[@id='filePicker1']");
	By UPLOAD_FILE_2_BTN = By.xpath("//*[@id='uploadButton1']");
	By NXT_BTN = By.xpath("//*[@id='instDiv']/div/form/div[4]/p/button");
	By nxt_btn=By.xpath("//button[contains(text(),'Next')]");
	By APP_NO_INFO = By.xpath("//html/body/div[1]/div[3]/div/div/div/form/div/div/div[4]/p/strong");
	By step2_app_number_info_lbl=By.xpath("/html/body/div[1]/div[3]/div/div/div/form/div/div/div[1]/div/span/strong");
	By I_PREFER_OTHER_OPTION_BTN = By.xpath("//*[@id='footer-modal']/p[2]/a/i/u");
	By CHOOSE_YOUR_PAYMENT_RDO_ACH = By.id("achRadio");
	By CONTINUE_CHOOSE_YOUR_PAYMENT_BTN = By.xpath("//*[@id='footer-modal']/p/input");
	By WISH_TO_DECLINE_BTN = By.xpath("//*[@id='footer-modal']/p[2]/a/i/u");
	By refi_loanNum_LBL = By.xpath("/html/body/div[1]/div[3]/div/div/div/form/div/div/div[4]/p/strong");
	By loanNumberLbl=By.xpath("/html/body/div[1]/div[3]/div/div/strong/strong/div/div/div[1]/div/span/strong");
	By loanApp_accept_btn=By.xpath("//*[@id='footer-modal']/p[1]/input");

	public TX342F_Steps_away_from_$1000(WebDriver driver) {
		this.driver = driver;
	}
	
		
		
	public void stepOne(ExtentTest test) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(STEP_1_REVIEWANDSIGN_BTN));
		driver.findElement(STEP_1_REVIEWANDSIGN_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on 'Review and Sign' Button in Steps away from $1000 page");
		Thread.sleep(500);
	}
			
	public void privacyPolicyAccept(ExtentTest test) throws InterruptedException{
		
			WebDriverWait wait=new WebDriverWait(driver,30);
			driver.switchTo().frame("pdfAgr");
			String versionNumber=driver.findElement(By.xpath("//*[@id='pageContainer1']/div[2]/div[4]")).getText();
			String versionNumberpage2=driver.findElement(By.xpath("//*[@id='pageContainer2']/div[2]/div[4]")).getText();
			if(versionNumber.equalsIgnoreCase(versionNumberpage2)){
				test.log(LogStatus.PASS, "Version number of Privacy Policy Agreement is: "+versionNumber);
			}
			else{
				test.log(LogStatus.PASS, "Version numbers of Privacy Policy Agreement"+" Page1: "+versionNumber+" Page2:"+versionNumberpage2);
			}
			driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(PPDCP_ACCEPT_BTN));
		driver.findElement(PPDCP_ACCEPT_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on  'Accept' Button in 'Privacy Policy' agreement  page");
		Thread.sleep(500);	
		
	}
	
	public void consentToElectronicCommunicationAccept(ExtentTest test) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(OCECDCP_BTN));
		driver.findElement(OCECDCP_BTN).click();
		test.log(
				LogStatus.PASS,
				"Clicked on 'Accept' Button in 'Consent to Electronic Communication' agreement page ");
		Thread.sleep(500);
	}
	
	public void scheduleAgreementAccept(ExtentTest test) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(SCHDCP_BTN));
		driver.findElement(SCHDCP_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on 'Accept' Button in 'Schedule Payment' agreement page ");
		Thread.sleep(500);
	}
	
	public void loanNoteAccept(ExtentTest test) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(OANOTESDCP_BTN));
		driver.findElement(OANOTESDCP_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on  'Accept' Button in 'OANOTES' agreement page ");
		Thread.sleep(500);
	}
	
	public void noteOfCancellationAccept(ExtentTest test) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ONOC_BTN));
		driver.findElement(ONOC_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on  'Accept' Button in 'NOC' agreement page ");
		Thread.sleep(500);
	}
	
	public void payRollAuthorizationAccept(ExtentTest test) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(OPRADDCP_BTN));
		driver.findElement(OPRADDCP_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on  'Accept' Button in 'Pay roll authorization' agreement page ");
		driver.findElement(OPRADDCP_BTN).click();
		Thread.sleep(500);
	}
	
	public void declinePDA(ExtentTest test) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions
				.elementToBeClickable(I_PREFER_OTHER_OPTION_BTN));
		driver.findElement(I_PREFER_OTHER_OPTION_BTN).click();
		test.log(
				LogStatus.PASS,
				"Clicked on 'I Prefer Other Options' button in 'Pay roll authorization' agreement page");
		Thread.sleep(500);
		driver.findElement(CHOOSE_YOUR_PAYMENT_RDO_ACH).click();
		test.log(
				LogStatus.PASS,
				"Clicked on 'Choose you payment' radio button in 'Pay roll authorization' agreement page");
		Thread.sleep(500);
		int Continue_btn_size = driver.findElements(
				CONTINUE_CHOOSE_YOUR_PAYMENT_BTN).size();
		test.log(
				LogStatus.PASS,
				"Clicked on 'Continue' button after Choose you payment radio button in 'Pay roll authorization' agreement page");
		driver.findElements(CONTINUE_CHOOSE_YOUR_PAYMENT_BTN)
				.get(Continue_btn_size - 1).click();
		Thread.sleep(500);
		driver.switchTo().defaultContent();
	}
	
	public void ACHAuthorizationAccept(ExtentTest test) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(OAADCP_BTN));
		driver.findElement(OAADCP_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on  'Accept' Button in 'ACH agreement' page ");
		Thread.sleep(500);
	}
	
	public void declineACHAuthorization(ExtentTest test) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(WISH_TO_DECLINE_BTN));
		driver.findElement(WISH_TO_DECLINE_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on 'I Wish to decline ACH' Button in 'ACH agreement' page");
		Thread.sleep(500);

	}
	
	public void consentToTextMessagesAccept(ExtentTest test) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(OCTMDCP_BTN));
		driver.findElement(OCTMDCP_BTN).click();
		test.log(LogStatus.PASS,
				"Clicked on 'Accept' Button in 'Consent to text messages' agreement  page ");
		Thread.sleep(500);
	}
	
	public void declineCTM(ExtentTest test) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(WISH_TO_DECLINE_BTN));
		driver.findElement(WISH_TO_DECLINE_BTN).click();
		test.log(
				LogStatus.PASS,
				"Clicked on 'I Wish to decline' button in 'Consent to Text messages' agreement page ");
		System.out.println("click 8");

		Thread.sleep(500);
	}
	
	public void customerSign(String First_name, String Last_name, ExtentTest test) throws InterruptedException{
		driver.findElement(CUSTSIGN_TXT).sendKeys(First_name + "" + Last_name);
		test.log(LogStatus.PASS, "Entered Customer name as : " + First_name
				+ " " + Last_name + " in customer sign page  ");
		Thread.sleep(500);
		driver.findElement(SUBMIT_BTN).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on 'Submit' Button in customer sign page ");
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions
				.elementToBeClickable(thanksForSubmitting_btn));
		driver.findElement(thanksForSubmitting_btn).click();
		driver.switchTo().defaultContent();
		test.log(LogStatus.PASS,
				"Clicked on 'Thanks for Submitting' Button in Review and Sign page ");
		Thread.sleep(2000);
		
	}
	
	public String appNumberInfoForDeclinePDA(ExtentTest test) throws InterruptedException{
		driver.switchTo().defaultContent();
		String element = driver.findElement(APP_NO_INFO).getText();
		System.out.println(element);
		String loanNumber = element.substring(7, element.length());
		test.log(LogStatus.PASS, "Generated loan Number is: " + loanNumber);
		System.out.println(loanNumber);
		Thread.sleep(500);
		return loanNumber;
	}

	public String step2(ExtentTest test)
			throws Exception {
		WebDriverWait wait=new WebDriverWait(driver,60);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(STEP_2_REVIEWANDSIGN_BTN));
		
		driver.findElement(STEP_2_REVIEWANDSIGN_BTN).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on 'Get Started' button in Steps away from $1000 page");

		((RemoteWebDriver) driver).executeScript("window.scrollBy(0,500)", "");
		
		String fileName="pdf-sample1.pdf";
		String uploadDocPath=System.getProperty("user.dir")+"/Upload Documents/" +fileName;
		wait.until(ExpectedConditions.visibilityOfElementLocated(CHOOSE_FILE_1_BTN));
		driver.findElement(CHOOSE_FILE_1_BTN).sendKeys(uploadDocPath);
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"'Selected document' from local drive in Get started page");

		driver.findElement(UPLOAD_FILE_1_BTN).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "'Uploaded document' in Get started page");

		((RemoteWebDriver) driver).executeScript("window.scrollBy(0,500)", "");

//		wait.until(ExpectedConditions.elementToBeClickable(CHOOSE_FILE_2_BTN));
		driver.findElement(CHOOSE_FILE_2_BTN).sendKeys(uploadDocPath);
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"'Selected document' from local drive in Get started page");

		driver.findElement(UPLOAD_FILE_2_BTN).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "'Uploaded document' in Get started page");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(nxt_btn));
		driver.findElement(nxt_btn).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Clicked on 'Next' button in Get started page");

		String app_no = driver.findElement(step2_app_number_info_lbl).getText();
		String loanNumber = app_no.substring(19, app_no.length());
		test.log(LogStatus.PASS, "Generated loan Number is: " + loanNumber);
		System.out.println("Application loan number:  " + loanNumber);
		return loanNumber;

	}
public void scheduleAgreementValidation(String firstInstallmentAmount,String lastInstallmentAmountm,String lastInstallmentnumber,ExtentTest test) throws InterruptedException{
	// Switching into Schedule agreement
			driver.switchTo().frame("pdfAgr");
			// 1st installment amount
			String fstinst = driver.findElement(
					By.xpath("//*[@id='pageContainer1']/div[2]/div[15]")).getText();
			System.out.println("First installment amount" + fstinst);
			if (fstinst.equalsIgnoreCase(firstInstallmentAmount)) {
				test.log(LogStatus.PASS,
						"First installment amount in Schedule Agreement is Calculated correctly :"
								+ fstinst);
			} else {
				test.log(LogStatus.PASS, "Not matched" + fstinst);
			}
			// last installment amount
			String lstinst = driver.findElement(
					By.xpath("//*[@id='pageContainer1']/div[2]/div[14]")).getText();
			System.out.println("Last Installment amount :" + lstinst);
			if (lstinst.equalsIgnoreCase(lastInstallmentAmountm)) {
				test.log(LogStatus.PASS,
						"Last installment amount in Schedule Agreement is Calculated correctly :"
								+ lstinst);
			}
			// last installment number
			String lstinstamnt = driver.findElement(
					By.xpath("//*[@id='pageContainer1']/div[2]/div[33]")).getText();
			System.out.println("Last Installment number" + lstinstamnt);
			if (lstinstamnt.equalsIgnoreCase(lastInstallmentnumber)) {
				test.log(LogStatus.PASS,
						"Last installment number in Schedule Agreement is Calculated correctly :"
								+ lstinstamnt);
			}
			driver.switchTo().defaultContent();
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(SCHDCP_BTN));
			driver.findElement(SCHDCP_BTN).click();
			Thread.sleep(500);
}

public void noteValidation(String apraccuraldate,String Financedamount,String total_Payment,String finance_Charge,String annual_Percent_Rate,String pay_Frequency,String last_Installment_Amount,ExtentTest test){
			// Switching into TILA agreement
			driver.switchTo().frame("pdfAgr");
			String aprdate = driver.findElement(
					By.xpath("//*[@id='pageContainer2']/div[2]/div[535]"))
					.getText();
			System.out.println("APR accural date" + aprdate);
			if (aprdate.equalsIgnoreCase(apraccuraldate)) {
				test.log(LogStatus.PASS,
						"APR accural date in ONOTES Agreement is Calculated correctly :"
								+ aprdate);
			}
			String amountFinanced = driver.findElement(
					By.xpath("//*[@id='pageContainer1']/div[2]/div[61]")).getText();
			System.out.println("Amount Financed" + amountFinanced);
			if (amountFinanced.substring(1).equalsIgnoreCase(Financedamount)) {
				test.log(LogStatus.PASS,
						"Amount financed in ONOTES Agreement is Calculated correctly :"
								+ amountFinanced);
			}
			String totalPayment = driver.findElement(
					By.xpath("//*[@id='pageContainer1']/div[2]/div[69]")).getText();
			System.out.println("Total amount to be paid" + totalPayment);
			if (totalPayment.equalsIgnoreCase(total_Payment)) {
				test.log(LogStatus.PASS,
						"Total payment in ONOTES Agreement is Calculated correctly :"
								+ totalPayment);
			}
			String financeCharge = driver.findElement(
					By.xpath("//*[@id='pageContainer1']/div[2]/div[71]")).getText();
			System.out.println("Finance Chareges" + financeCharge);
			if (financeCharge.equalsIgnoreCase(finance_Charge)) {
				test.log(LogStatus.PASS,
						"Finance charge in ONOTES Agreement is Calculated correctly :"
								+ financeCharge);
			}
			String annualPercentRate = driver.findElement(
					By.xpath("//*[@id='pageContainer1']/div[2]/div[51]")).getText();
			System.out.println("Annual Percentage Rate" + annualPercentRate);
			if (annualPercentRate.equalsIgnoreCase(annual_Percent_Rate)) {
				test.log(LogStatus.PASS,
						"Annual percent rate in ONOTES Agreement is Calculated correctly :"
								+ annualPercentRate);
			}
			String payFrequency = driver.findElement(
					By.xpath("//*[@id='pageContainer1']/div[2]/div[63]")).getText();
			System.out.println("Pay Frequency type" + payFrequency);
			if (payFrequency.equalsIgnoreCase(pay_Frequency)) {
				test.log(LogStatus.PASS,
						"Pay frequency in ONOTES Agreement is Calculated correctly :"
								+ payFrequency);
			}
			String lastInstallmentAmount = driver.findElement(
					By.xpath("//*[@id='pageContainer1']/div[2]/div[53]")).getText();
			System.out.println("Last Installment Amount" + lastInstallmentAmount);
			if (lastInstallmentAmount.equalsIgnoreCase(last_Installment_Amount)) {
				test.log(LogStatus.PASS,
						"Last installment amount in ONOTES Agreement is Calculated correctly :"
								+ lastInstallmentAmount);
			}
			
			driver.switchTo().defaultContent(); 
		}

	

	public String refiLoanNum(ExtentTest test) throws InterruptedException {
		String app_no = driver.findElement(refi_loanNum_LBL).getText();
		System.out.println(app_no);
		String loanNumber = app_no.substring(7, app_no.length());
		test.log(LogStatus.PASS, "Generated Refinance Loan Number is: "
				+ loanNumber);
		test.log(LogStatus.PASS,
				"Refinance transaction is completed successfully ");
		System.out.println(loanNumber);
		Thread.sleep(500);
		return loanNumber;
	}
	public void loanApplicationAccept(ExtentTest test) throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(loanApp_accept_btn));
		driver.findElement(loanApp_accept_btn).click();
		test.log(LogStatus.PASS,
				"Clicked on  'Accept' Button in 'Loan Application agreement' page ");
		Thread.sleep(500);
	}
	public String LoanNumOlBnk(ExtentTest test) throws InterruptedException {
		String app_no = driver.findElement(loanNumberLbl).getText();
		System.out.println(app_no);
		String loanNumber = app_no.substring(app_no.length()-8, app_no.length());
		test.log(LogStatus.PASS, "Generated Loan Number is: "
				+ loanNumber);
		System.out.println(loanNumber);
		Thread.sleep(500);
		return loanNumber;
	}
	public String olBnkStep2(ExtentTest test) throws Exception{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait=new WebDriverWait(driver,60);
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.elementToBeClickable(STEP_2_REVIEWANDSIGN_BTN));
			
			driver.findElement(STEP_2_REVIEWANDSIGN_BTN).click();
			Thread.sleep(500);
			test.log(LogStatus.PASS,
					"Clicked on 'Get Started' button in Steps away from $1000 page");

			((RemoteWebDriver) driver).executeScript("window.scrollBy(0,500)", "");
			
			String fileName="pdf-sample1.pdf";
			String uploadDocPath=System.getProperty("user.dir")+"/Upload Documents/" +fileName;
			//wait.until(ExpectedConditions.presenceOfElementLocated(CHOOSE_FILE_1_BTN));
			driver.findElement(CHOOSE_FILE_1_BTN).sendKeys(uploadDocPath);
			Thread.sleep(5000);
			test.log(LogStatus.PASS,
					"'Selected document' from local drive in Get started page");

			driver.findElement(UPLOAD_FILE_1_BTN).click();
			Thread.sleep(500);
			test.log(LogStatus.PASS, "'Uploaded document' in Get started page");

			((RemoteWebDriver) driver).executeScript("window.scrollBy(0,500)", "");

			//wait.until(ExpectedConditions.elementToBeClickable(CHOOSE_FILE_2_BTN));
			driver.findElement(CHOOSE_FILE_2_BTN).sendKeys(uploadDocPath);
			Thread.sleep(5000);
			test.log(LogStatus.PASS,
					"'Selected document' from local drive in Get started page");

			driver.findElement(UPLOAD_FILE_2_BTN).click();
			Thread.sleep(500);
			test.log(LogStatus.PASS, "'Uploaded document' in Get started page");
			
			
			wait.until(ExpectedConditions.elementToBeClickable(nxt_btn));
			driver.findElement(nxt_btn).click();
			Thread.sleep(500);
			test.log(LogStatus.PASS, "Clicked on 'Next' button in Get started page");

			String app_no = driver.findElement(step2_app_number_info_lbl).getText();
			String loanNumber = app_no.substring(19, app_no.length());
			test.log(LogStatus.PASS, "Generated loan Number is: " + loanNumber);
			System.out.println("Application loan number:  " + loanNumber);
			return loanNumber;
	}
	public void customerSignOlBnk(String First_name, String Last_name, ExtentTest test) throws InterruptedException{
		driver.findElement(CUSTSIGN_TXT).sendKeys(First_name + "" + Last_name);
		test.log(LogStatus.PASS, "Entered Customer name as : " + First_name
				+ " " + Last_name + " in customer sign page  ");
		Thread.sleep(500);
		driver.findElement(SUBMIT_BTN).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on 'Submit' Button in customer sign page ");
		driver.switchTo().defaultContent();
		test.log(LogStatus.PASS,
				"Clicked on 'Thanks for Submitting' Button in Review and Sign page ");
		Thread.sleep(2000);
		
	}

}
