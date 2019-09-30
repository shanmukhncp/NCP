package com.qfund.ncp.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TX342F_LMS {
	
	WebDriver driver;
	ExtentTest test;
	int rnum;
	By username_txt = By.xpath("//*[@name='loginRequestBean.userId']");
	By password_txt = By.xpath("//*[@name='loginRequestBean.password']");
	By login_btn = By.xpath("//*[@name='login']");
	By directLendMgmt_btn = By.xpath("//*[@id='4d']/img");
	By applicationMgmt_btn = By.xpath("//*[@id='172']/a");
	By applicationQueue_btn = By.xpath("//*[@id='90401']/a");
	By cso_drp = By.id("csoIdSel");
	By loanStatus_drp = By.id("loanStatus");
	By applicationQueueSearch_btn = By.id("submitBtn");
	By searchResults_webTbl = By
			.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td");
	By viewPDADoc_btn = By.xpath("//input[@value='View PDA Document']");
	By acceptPDA_rad = By.xpath("//input[@id='acceptRadio']");
	By submitPDA_btn = By.id("btnSubmit");
	By uploadDocs_btn = By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[2]/tbody/tr/td/input");
	By uploadDocsBtnOlBnk=By.xpath("//*[@id='docButtons']/input[1]");                            
	By docUpload_btn = By.id("doc101");
	By docUploadSubmit_btn = By
			.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[13]/td[2]/label/input[2]");
	By docUploadPDA_btn = By.name("uploadDocs[9]");

	By docUploadOk_btn = By.xpath("//*[@id='button']");
	By Ok_btn = By
			.xpath("//*[@id='showSuccess']/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td/input");
	By disburseFunds_btn = By
			.xpath("//*[@id='printCheck10' and @type='button' and @value='Disburse Funds']");
	By loanOriginationOk_btn = By
			.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input");
	By loanOrigination_msg = By
			.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/strong");
	By logout_btn = By.xpath("//*[@id='7d']");

	public TX342F_LMS(WebDriver driver) {
		this.driver = driver;
	}
	public void lmsLogin(String LMS_APP_URL, String LMS_UserName,
			String LMS_Password, ExtentTest test) throws InterruptedException {
		
		driver.get(LMS_APP_URL);
		test.log(LogStatus.PASS, "'LMS application' Launched");

		driver.manage().window().maximize();
		driver.findElement(username_txt).sendKeys(LMS_UserName);
		test.log(LogStatus.PASS, "LMS application 'Username' entered as: "
				+ LMS_UserName);

		driver.findElement(password_txt).sendKeys(LMS_Password);
		test.log(LogStatus.PASS, "LMS application 'Password' entered as: "
				+ LMS_Password);

		driver.findElement(login_btn).click();
		test.log(LogStatus.PASS,
				"Clicked on 'Submit' button in LMS Login screen");
		Thread.sleep(500);
	}

	public void disburseFunds(String csoSelect,String loanNumber,ExtentTest test) throws InterruptedException,
			StaleElementReferenceException {
		WebDriverWait wait=new WebDriverWait(driver,60);
		
		WebElement topFrame = driver.findElement(By.id("topFrame"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(topFrame));
		driver.switchTo().frame(topFrame);

		driver.findElement(directLendMgmt_btn).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on 'Direct Lend Mgmt' page in LMS application page");

		driver.switchTo().defaultContent();
		WebElement mainFrame = driver.findElement(By.id("mainFrame"));
		driver.switchTo().frame(mainFrame);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(applicationMgmt_btn));
		Actions appmgmt = new Actions(driver);
		appmgmt.moveToElement(driver.findElement(applicationMgmt_btn)).build()
				.perform();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(applicationQueue_btn));
		driver.findElement(applicationQueue_btn).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on 'Application Queue' button under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		WebElement main = driver.findElement(By.name("main"));
		driver.switchTo().frame(main);

		wait.until(ExpectedConditions.visibilityOfElementLocated(cso_drp));
		Select cso = new Select(driver.findElement(cso_drp));
		cso.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS,"CSO selected as: "+ csoSelect +" in Application Queue page");

		Select loanStatus = new Select(driver.findElement(loanStatus_drp));
		loanStatus.selectByIndex(3);
		test.log(LogStatus.PASS,
				"Loan Status selected as: 'Pending Funding' in Application Queue page");

		driver.findElement(applicationQueueSearch_btn).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on 'Submit' button in Application Queue page");

		
			WebElement htmltable = driver.findElement(searchResults_webTbl);

			// Picking Loan from WebTable
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			for (rnum = 3; rnum < rows.size(); rnum++) {

				List<WebElement> columns = rows.get(rnum).findElements(
						By.tagName("td"));

				for (int i = 1; i <= 1; i++)// columns.size()
				{
					String lmsLoanNumber = columns.get(i).getText();

					if (lmsLoanNumber.equalsIgnoreCase(loanNumber)) {

						test.log(LogStatus.PASS,
								"'Searched for loan number' in pending funding search results");

						driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]"
										+ "/td/table/tbody/tr["
										+ rnum
										+ "]/td[13]/input")).click();
				
						Thread.sleep(500);
						test.log(LogStatus.PASS,
								"Clicked on 'Go' button in search results web table ");

						wait.until(ExpectedConditions
								.elementToBeClickable(viewPDADoc_btn));
						driver.findElement(viewPDADoc_btn).click();
						Thread.sleep(500);
						test.log(LogStatus.PASS,
								"Clicked on 'View PDA document' button in Disburse Funds screen");

						String parentwindow = driver.getWindowHandle();

						for (String handle : driver.getWindowHandles()) {

							if (!handle.equalsIgnoreCase(parentwindow)) {

								driver.switchTo().window(handle);

								driver.switchTo().frame("mainFrame");

								wait.until(ExpectedConditions
										.elementToBeClickable(acceptPDA_rad));
								driver.findElement(acceptPDA_rad).click();
								Thread.sleep(500);
								test.log(LogStatus.PASS,
										"Clicked on 'Accept PDA document' radio button in View PDA Document Page");

								driver.findElement(submitPDA_btn).click();
								Thread.sleep(500);
								test.log(LogStatus.PASS,
										"Clicked on 'Submit' button in View PDA Document Page");

								driver.findElement(Ok_btn).click();
								test.log(LogStatus.PASS,
										"Clicked on 'Ok' button in View PDA Document Page");
							}

						}

						driver.switchTo().window(parentwindow);

						driver.switchTo().frame(mainFrame);

						driver.switchTo().frame(main);

						// Click through JavaScriptExecutor
						WebElement element = driver
								.findElement(disburseFunds_btn);
						JavascriptExecutor ex = (JavascriptExecutor) driver;
						ex.executeScript("arguments[0].click()", element);
						Thread.sleep(500);
						test.log(LogStatus.PASS,
								"Clicked on 'Disburse Funds' button in Disburse Funds screen");

						String parentwindow1 = driver.getWindowHandle();
						for (String handle : driver.getWindowHandles()) {

							if (!handle.equalsIgnoreCase(parentwindow1)) {
								driver.switchTo().window(handle);

								if (driver.findElement(loanOrigination_msg)
										.isDisplayed()) {
									test.log(LogStatus.PASS,
											"Texas 342F Loan Originated Successfully");
									String Success = driver.findElement(
											loanOrigination_msg).getText();
									test.log(LogStatus.PASS,
											"Loan origination success message displayed as: "
													+ Success);
								}
								driver.findElement(loanOriginationOk_btn)
										.click();
								test.log(
										LogStatus.PASS,
										"Clicked on 'Ok' button in success screen of disburse funds button pop-up screen");
								driver.switchTo().window(parentwindow1);
								Thread.sleep(500);

							}

						}

					}

				}
			}
		}

	public void disburseFundsWithoutPDA(String csoSelect,String loanNumber, ExtentTest test) throws InterruptedException {

		WebElement topFrame = driver.findElement(By.id("topFrame"));
		driver.switchTo().frame(topFrame);

		driver.findElement(directLendMgmt_btn).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on 'Direct Lend Mgmt' page in LMS application page");

		driver.switchTo().defaultContent();
		WebElement mainFrame = driver.findElement(By.id("mainFrame"));
		driver.switchTo().frame(mainFrame);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(applicationMgmt_btn));
		Actions appmgmt = new Actions(driver);
		appmgmt.moveToElement(driver.findElement(applicationMgmt_btn)).build()
				.perform();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(applicationQueue_btn));
		driver.findElement(applicationQueue_btn).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on 'Application Queue' button under Application Mgmt menu");

		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainFrame);
		WebElement main = driver.findElement(By.name("main"));
		driver.switchTo().frame(main);

		wait.until(ExpectedConditions.visibilityOfElementLocated(cso_drp));
		Select cso = new Select(driver.findElement(cso_drp));
		cso.selectByVisibleText(csoSelect);
		test.log(LogStatus.PASS,
				"CSO selected as: "+csoSelect+" in Application Queue page");

		Select loanStatus = new Select(driver.findElement(loanStatus_drp));
		loanStatus.selectByIndex(3);
		test.log(LogStatus.PASS,
				"Loan Status selected as: 'Pending Funding' in Application Queue page");

		driver.findElement(applicationQueueSearch_btn).click();
		Thread.sleep(500);
		test.log(LogStatus.PASS,
				"Clicked on 'Submit' button in Application Queue page");

		try {
			WebElement htmltable = driver.findElement(searchResults_webTbl);

			// Picking Loan from WebTable
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			for (rnum = 3; rnum < rows.size(); rnum++) {

				List<WebElement> columns = rows.get(rnum).findElements(
						By.tagName("td"));

				for (int i = 1; i <= 1; i++)// columns.size()
				{
					String lmsLoanNumber = columns.get(i).getText();

					if (lmsLoanNumber.equalsIgnoreCase(loanNumber)) {

						test.log(LogStatus.PASS,
								"'Searched for loan number' in pending funding search results");

						driver.findElement(
								By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]"
										+ "/td/table/tbody/tr["
										+ rnum
										+ "]/td[14]/input")).click();
						Thread.sleep(500);
						test.log(LogStatus.PASS,
								"Clicked on 'Go' button in search results web table ");
					

					String parentwindow1 = driver.getWindowHandle();
					System.out.println(parentwindow1);
					for (String handle : driver.getWindowHandles()) {

						if (!handle.equalsIgnoreCase(parentwindow1)) {
							driver.switchTo().window(handle);
						
							System.out.println(driver.getWindowHandle());
							WebElement embedFrame=driver.findElement(By.tagName("embed"));
							driver.switchTo().frame(embedFrame);
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(disburseFunds_btn));
							WebElement element = driver.findElement(disburseFunds_btn);
							JavascriptExecutor ex = (JavascriptExecutor) driver;
							ex.executeScript("arguments[0].click()", element);
//							driver.findElement(disburseFunds_btn).click();
							Thread.sleep(500);
							test.log(LogStatus.PASS,"Clicked on 'Disburse Funds' button in Disburse Funds screen");
						
						}
			
					}
					String parentWindow2=driver.getWindowHandle();
					for (String handle : driver.getWindowHandles()) {
						
					if(!handle.equalsIgnoreCase(parentWindow2)&& !handle.equalsIgnoreCase(parentwindow1)){
						driver.switchTo().window(handle);
						System.out.println(handle);
						if (driver.findElement(loanOrigination_msg)
								.isDisplayed()) {
							test.log(LogStatus.PASS,"Loan Originated Successfully");
							String Success = driver.findElement(loanOrigination_msg).getText();
							test.log(LogStatus.PASS,"Loan origination success message displayed as: "+ Success);
						}
						driver.findElement(loanOriginationOk_btn).click();
						test.log(LogStatus.PASS,"Clicked on 'Ok' button in success screen of disburse funds button pop-up screen");
						Thread.sleep(5000);
						driver.switchTo().window(parentWindow2);
						driver.switchTo().defaultContent();
						
						WebElement embedFrame=driver.findElement(By.tagName("embed"));
						driver.switchTo().frame(embedFrame);
						driver.findElement(By.id("printCheck10OK")).click();
						Thread.sleep(5000);
						driver.switchTo().window(parentwindow1);
						driver.switchTo().defaultContent();
						System.out.println(driver.getWindowHandle());
					}
					
				
					}
				}
			}
		}
		}
		catch (Exception E) {

			E.printStackTrace();
		}

	}
	
    public void authorizedDocumentValidation(String csoSelect,String loanNumber,ExtentTest test) throws InterruptedException,
	StaleElementReferenceException {

WebElement topFrame = driver.findElement(By.id("topFrame"));
driver.switchTo().frame(topFrame);

driver.findElement(directLendMgmt_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Direct Lend Management' page in LMS application page");

driver.switchTo().defaultContent();
WebElement mainFrame = driver.findElement(By.id("mainFrame"));
driver.switchTo().frame(mainFrame);

WebDriverWait wait = new WebDriverWait(driver, 30);

Actions appmgmt = new Actions(driver);
wait.until(ExpectedConditions.visibilityOfElementLocated(applicationMgmt_btn));
appmgmt.moveToElement(driver.findElement(applicationMgmt_btn)).build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(applicationQueue_btn));
driver.findElement(applicationQueue_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Application Queue' button under Application Mgmt menu");

driver.switchTo().defaultContent();
driver.switchTo().frame(mainFrame);

WebElement main = driver.findElement(By.name("main"));
driver.switchTo().frame(main);
Thread.sleep(500);
wait.until(ExpectedConditions.visibilityOfElementLocated(cso_drp));
Select cso = new Select(driver.findElement(cso_drp));
cso.selectByVisibleText(csoSelect);
test.log(LogStatus.PASS,"CSO selected as: "+ csoSelect +" in Application Queue page");

Select loanStatus = new Select(driver.findElement(loanStatus_drp));
loanStatus.selectByIndex(3);
test.log(LogStatus.PASS,"Loan Status selected as: 'Pending Funding' in Application Queue page");

driver.findElement(applicationQueueSearch_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Submit' button in Application Queue page");

try{
	WebElement htmltable = driver.findElement(searchResults_webTbl);
	
	// Picking Loan from WebTable
	List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

	for (rnum = 3; rnum < rows.size(); rnum++) {

		List<WebElement> columns = rows.get(rnum).findElements(
				By.tagName("td"));

		for (int i = 1; i <= 1; i++)// columns.size()
		{
			String lmsLoanNumber = columns.get(i).getText();

			if (lmsLoanNumber.equalsIgnoreCase(loanNumber)) {

				test.log(LogStatus.PASS,
						"'Searched for loan number' in pending funding search results"+loanNumber);

				driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[" + rnum	+ "]/td[14]/input")).click();
				Thread.sleep(500);
				test.log(LogStatus.PASS,
						"Clicked on 'Go' button in search results web table ");

			}
		}
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
			test.log(LogStatus.PASS,"Clicked on 'Submit' button in View PDA Document Page");						
		}
	}
	driver.switchTo().window(parentwindow);
	driver.switchTo().defaultContent();
}
catch(Exception e)
{
	System.out.println(e);
	e.printStackTrace();
}
}
	
	public void authorizedLmsLogin(String LMS_APP_URL, String authLMS_userName,
			String authLMS_password, ExtentTest test) throws InterruptedException {
		
		driver.get(LMS_APP_URL);
		test.log(LogStatus.PASS, "'LMS application' Launched");

		driver.manage().window().maximize();
		driver.findElement(username_txt).sendKeys(authLMS_userName);
		test.log(LogStatus.PASS, "LMS application 'Username' entered as: "
				+ authLMS_userName);

		driver.findElement(password_txt).sendKeys(authLMS_password);
		test.log(LogStatus.PASS, "LMS application 'Password' entered as: "
				+ authLMS_password);

		driver.findElement(login_btn).click();
		test.log(LogStatus.PASS,
				"Clicked on 'Submit' button in LMS Login screen");
		Thread.sleep(500);
	}
	
    public void authorizedDocsValidationOlBnkAuth(String csoSelect,String loanNumber,ExtentTest test) throws InterruptedException,
	StaleElementReferenceException {

WebElement topFrame = driver.findElement(By.id("topFrame"));
driver.switchTo().frame(topFrame);

driver.findElement(directLendMgmt_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Direct Lend Management' page in LMS application page");

driver.switchTo().defaultContent();
WebElement mainFrame = driver.findElement(By.id("mainFrame"));
driver.switchTo().frame(mainFrame);

WebDriverWait wait = new WebDriverWait(driver, 30);

Actions appmgmt = new Actions(driver);
wait.until(ExpectedConditions.visibilityOfElementLocated(applicationMgmt_btn));
appmgmt.moveToElement(driver.findElement(applicationMgmt_btn)).build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(applicationQueue_btn));
driver.findElement(applicationQueue_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Application Queue' button under Application Mgmt menu");

driver.switchTo().defaultContent();
driver.switchTo().frame(mainFrame);

WebElement main = driver.findElement(By.name("main"));
driver.switchTo().frame(main);

wait.until(ExpectedConditions.visibilityOfElementLocated(cso_drp));
Select cso = new Select(driver.findElement(cso_drp));
cso.selectByVisibleText(csoSelect);
test.log(LogStatus.PASS,"CSO selected as: "+ csoSelect +" in Application Queue page");

Select loanStatus = new Select(driver.findElement(loanStatus_drp));
loanStatus.selectByIndex(3);
test.log(LogStatus.PASS,"Loan Status selected as: 'Pending Funding' in Application Queue page");

driver.findElement(applicationQueueSearch_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Submit' button in Application Queue page");


	WebElement htmltable = driver.findElement(searchResults_webTbl);
	
	// Picking Loan from WebTable
	List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

	for (rnum = 3; rnum < rows.size(); rnum++) {

		List<WebElement> columns = rows.get(rnum).findElements(
				By.tagName("td"));

		for (int i = 1; i <= 1; i++)// columns.size()
		{
			String lmsLoanNumber = columns.get(i).getText();

			if (lmsLoanNumber.equalsIgnoreCase(loanNumber)) {

				test.log(LogStatus.PASS,
						"'Searched for loan number' in pending funding search results");

				driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["	+ rnum + "]/td[13]/input")).click();
											
				
		
				Thread.sleep(500);
				test.log(LogStatus.PASS,
						"Clicked on 'Go' button in search results web table ");
			
				
			}
			}
		}
	
	String parentwindow = driver.getWindowHandle();

	for (String handle : driver.getWindowHandles()) {

		if (!handle.equalsIgnoreCase(parentwindow)) {

			driver.switchTo().window(handle);
			
			WebElement embedFrame=driver.findElement(By.className("pdaAc"));
			driver.switchTo().frame(embedFrame);
			driver.findElement(By.id("assignedDoc")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='showDocDetails']/tbody/tr[7]/td[1]/a")));
			driver.findElement(By.xpath("//*[@id='showDocDetails']/tbody/tr[7]/td[1]/a")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.name("status0")));
			driver.findElement(By.name("status0")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='showDocDetails']/tbody/tr[8]/td[1]/a")));
			driver.findElement(By.xpath("//*[@id='showDocDetails']/tbody/tr[8]/td[1]/a")).click();			
			wait.until(ExpectedConditions.elementToBeClickable(By.name("status1")));
			driver.findElement(By.name("status1")).click();
		

//			wait.until(ExpectedConditions.elementToBeClickable(acceptPDA_rad));
//			driver.findElement(acceptPDA_rad).click();
			Thread.sleep(500);
			test.log(LogStatus.PASS,"Clicked on 'Accept PDA document' radio button in View PDA Document Page");
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitPDA_btn)));
			driver.findElement(submitPDA_btn).click();
			
			test.log(LogStatus.PASS,
					"Clicked on 'Submit' button in View PDA Document Page");
			Thread.sleep(500);
		}
			driver.switchTo().window(parentwindow);
			driver.switchTo().defaultContent();
	}
}
    public void authorizedUploadDocs(String csoSelect,String loanNumber,ExtentTest test) throws InterruptedException,
	StaleElementReferenceException {

WebElement topFrame = driver.findElement(By.id("topFrame"));
driver.switchTo().frame(topFrame);

driver.findElement(directLendMgmt_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Direct Lend Management' page in LMS application page");

driver.switchTo().defaultContent();
WebElement mainFrame = driver.findElement(By.id("mainFrame"));
driver.switchTo().frame(mainFrame);

WebDriverWait wait = new WebDriverWait(driver, 30);

Actions appmgmt = new Actions(driver);
wait.until(ExpectedConditions.visibilityOfElementLocated(applicationMgmt_btn));
appmgmt.moveToElement(driver.findElement(applicationMgmt_btn)).build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(applicationQueue_btn));
driver.findElement(applicationQueue_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Application Queue' button under Application Mgmt menu");

driver.switchTo().defaultContent();
driver.switchTo().frame(mainFrame);

WebElement main = driver.findElement(By.name("main"));
driver.switchTo().frame(main);

wait.until(ExpectedConditions.visibilityOfElementLocated(cso_drp));
Select cso = new Select(driver.findElement(cso_drp));
cso.selectByVisibleText(csoSelect);
test.log(LogStatus.PASS,"CSO selected as: "+ csoSelect +" in Application Queue page");

Select loanStatus = new Select(driver.findElement(loanStatus_drp));
loanStatus.selectByIndex(3);
test.log(LogStatus.PASS,"Loan Status selected as: 'Pending Funding' in Application Queue page");

driver.findElement(applicationQueueSearch_btn).click();
Thread.sleep(3000);
test.log(LogStatus.PASS,"Clicked on 'Submit' button in Application Queue page");

try{
	WebElement htmltable = driver.findElement(searchResults_webTbl);
	
	// Picking Loan from WebTable
	List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

	for (rnum = 3; rnum < rows.size(); rnum++) {

		List<WebElement> columns = rows.get(rnum).findElements(
				By.tagName("td"));

		for (int i = 1; i <= 1; i++)// columns.size()
		{
			String lmsLoanNumber = columns.get(i).getText();

			if (lmsLoanNumber.equalsIgnoreCase(loanNumber)) {

				test.log(LogStatus.PASS,
						"'Searched for loan number' in pending funding search results");
				
				driver.findElement(
						By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]"
								+ "/td/table/tbody/tr["
								+ rnum
								+ "]/td[14]/input")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS,
						"Clicked on 'Go' button in search results web table ");	
			}
			}
		}
	
	String parentwindow = driver.getWindowHandle();

	for (String handle : driver.getWindowHandles()) {

		if (!handle.equalsIgnoreCase(parentwindow)) {

			driver.switchTo().window(handle);
			
			WebElement embedFrame=driver.findElement(By.tagName("embed"));
			driver.switchTo().frame(embedFrame);
			
			wait.until(ExpectedConditions.elementToBeClickable(uploadDocs_btn));
			driver.findElement(uploadDocs_btn).click();
			Thread.sleep(500);
			test.log(LogStatus.PASS,"Clicked on 'Upload document'  button in  PDA Document popup");
			driver.switchTo().defaultContent();
			String childWindow1 = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				if(!winHandle.equalsIgnoreCase(parentwindow)&&!winHandle.equalsIgnoreCase(childWindow1))
				{
				driver.switchTo().window(winHandle);
		
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
			test.log(LogStatus.PASS, "Loan Originated Successfully");
	
		}
			driver.switchTo().window(parentwindow);
	}
		}
		
			
		}	 
}
catch(Exception e){
	System.out.println(e.getStackTrace());
}
}
   
    public void authorizedUploadDocsOlBnk(String csoSelect,String loanNumber,ExtentTest test) throws InterruptedException,
   	StaleElementReferenceException {

   WebElement topFrame = driver.findElement(By.id("topFrame"));
   driver.switchTo().frame(topFrame);

   driver.findElement(directLendMgmt_btn).click();
   Thread.sleep(500);
   test.log(LogStatus.PASS,"Clicked on 'Direct Lend Management' page in LMS application page");

   driver.switchTo().defaultContent();
   WebElement mainFrame = driver.findElement(By.id("mainFrame"));
   driver.switchTo().frame(mainFrame);

   WebDriverWait wait = new WebDriverWait(driver, 30);

   Actions appmgmt = new Actions(driver);
   wait.until(ExpectedConditions.visibilityOfElementLocated(applicationMgmt_btn));
   appmgmt.moveToElement(driver.findElement(applicationMgmt_btn)).build().perform();

   wait.until(ExpectedConditions.visibilityOfElementLocated(applicationQueue_btn));
   driver.findElement(applicationQueue_btn).click();
   Thread.sleep(500);
   test.log(LogStatus.PASS,"Clicked on 'Application Queue' button under Application Mgmt menu");

   driver.switchTo().defaultContent();
   driver.switchTo().frame(mainFrame);

   WebElement main = driver.findElement(By.name("main"));
   driver.switchTo().frame(main);

   wait.until(ExpectedConditions.visibilityOfElementLocated(cso_drp));
   Select cso = new Select(driver.findElement(cso_drp));
   cso.selectByVisibleText(csoSelect);
   test.log(LogStatus.PASS,"CSO selected as: "+ csoSelect +" in Application Queue page");

   Select loanStatus = new Select(driver.findElement(loanStatus_drp));
   loanStatus.selectByIndex(3);
   test.log(LogStatus.PASS,"Loan Status selected as: 'Pending Funding' in Application Queue page");

   driver.findElement(applicationQueueSearch_btn).click();
   Thread.sleep(3000);
   test.log(LogStatus.PASS,"Clicked on 'Submit' button in Application Queue page");

   try{
   	WebElement htmltable = driver.findElement(searchResults_webTbl);
   	
   	// Picking Loan from WebTable
   	List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

   	for (rnum = 3; rnum < rows.size(); rnum++) {

   		List<WebElement> columns = rows.get(rnum).findElements(
   				By.tagName("td"));

   		for (int i = 1; i <= 1; i++)// columns.size()
   		{
   			String lmsLoanNumber = columns.get(i).getText();

   			if (lmsLoanNumber.equalsIgnoreCase(loanNumber)) {

   				test.log(LogStatus.PASS,
   						"'Searched for loan number' in pending funding search results");
   				
   				driver.findElement(
   						By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]"
   								+ "/td/table/tbody/tr["
   								+ rnum
   								+ "]/td[13]/input")).click();
   				Thread.sleep(2000);
   				test.log(LogStatus.PASS,
   						"Clicked on 'Go' button in search results web table ");	
   			}
   			}
   		}
   	
   	String parentwindow = driver.getWindowHandle();

   	for (String handle : driver.getWindowHandles()) {

   		if (!handle.equalsIgnoreCase(parentwindow)) {

   			driver.switchTo().window(handle);
   			System.out.println(handle);
   			WebElement embedFrame=driver.findElement(By.className("pdaAc"));
   			driver.switchTo().frame(embedFrame);
   			
   			wait.until(ExpectedConditions.elementToBeClickable(uploadDocsBtnOlBnk));
   			driver.findElement(uploadDocsBtnOlBnk).click();
   			Thread.sleep(500);
   			test.log(LogStatus.PASS,"Clicked on 'Upload document'  button in  PDA Document popup");
   			driver.switchTo().defaultContent();
   			String childWindow1 = driver.getWindowHandle();
   			for (String winHandle : driver.getWindowHandles()) {
   				if(!winHandle.equalsIgnoreCase(parentwindow)&&!winHandle.equalsIgnoreCase(childWindow1))
   				{
   				driver.switchTo().window(winHandle);
   				System.out.println(winHandle);
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
   			test.log(LogStatus.PASS, "Loan Originated Successfully");
   	
   		}
   			driver.switchTo().window(parentwindow);
   	}
   		}
   		
   			
   		}	 
   }
   catch(Exception e){
   	System.out.println(e.getStackTrace());
   }
   }
    public void authorizedDisburseFunds(String csoSelect,String loanNumber,ExtentTest test) throws InterruptedException,
	StaleElementReferenceException {

WebElement topFrame = driver.findElement(By.id("topFrame"));
driver.switchTo().frame(topFrame);

driver.findElement(directLendMgmt_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Direct Lend Management' page in LMS application page");

driver.switchTo().defaultContent();
WebElement mainFrame = driver.findElement(By.id("mainFrame"));
driver.switchTo().frame(mainFrame);

WebDriverWait wait = new WebDriverWait(driver, 30);

Actions appmgmt = new Actions(driver);
wait.until(ExpectedConditions.visibilityOfElementLocated(applicationMgmt_btn));
appmgmt.moveToElement(driver.findElement(applicationMgmt_btn)).build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(applicationQueue_btn));
driver.findElement(applicationQueue_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Application Queue' button under Application Mgmt menu");

driver.switchTo().defaultContent();
driver.switchTo().frame(mainFrame);

WebElement main = driver.findElement(By.name("main"));
driver.switchTo().frame(main);

wait.until(ExpectedConditions.visibilityOfElementLocated(cso_drp));
Select cso = new Select(driver.findElement(cso_drp));
cso.selectByVisibleText(csoSelect);
test.log(LogStatus.PASS,"CSO selected as: "+ csoSelect +" in Application Queue page");

Select loanStatus = new Select(driver.findElement(loanStatus_drp));
loanStatus.selectByIndex(3);
test.log(LogStatus.PASS,"Loan Status selected as: 'Pending Funding' in Application Queue page");

driver.findElement(applicationQueueSearch_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Submit' button in Application Queue page");


	WebElement htmltable = driver.findElement(searchResults_webTbl);
	
	// Picking Loan from WebTable
	List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

	for (rnum = 3; rnum < rows.size(); rnum++) {

		List<WebElement> columns = rows.get(rnum).findElements(
				By.tagName("td"));

		for (int i = 1; i <= 1; i++)// columns.size()
		{
			String lmsLoanNumber = columns.get(i).getText();

			if (lmsLoanNumber.equalsIgnoreCase(loanNumber)) {

				test.log(LogStatus.PASS,
						"'Searched for loan number' in pending funding search results");

				driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["	+ rnum + "]/td[14]/input")).click();
											
				
		
				Thread.sleep(500);
				test.log(LogStatus.PASS,
						"Clicked on 'Go' button in search results web table ");
			
				
			}
			}
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
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitPDA_btn)));
			driver.findElement(submitPDA_btn).click();
			
			test.log(LogStatus.PASS,
					"Clicked on 'Submit' button in View PDA Document Page");
			Thread.sleep(500);
			wait.until(ExpectedConditions.alertIsPresent());
			
			Alert alert=driver.switchTo().alert();
			alert.accept();
			test.log(LogStatus.PASS, "Loan Originated Successfully");
	
		}
			driver.switchTo().window(parentwindow);
	}
}
    public void authorizedDisburseFundsOlBnk(String csoSelect,String loanNumber,ExtentTest test) throws InterruptedException,
	StaleElementReferenceException {

WebElement topFrame = driver.findElement(By.id("topFrame"));
driver.switchTo().frame(topFrame);

driver.findElement(directLendMgmt_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Direct Lend Management' page in LMS application page");

driver.switchTo().defaultContent();
WebElement mainFrame = driver.findElement(By.id("mainFrame"));
driver.switchTo().frame(mainFrame);

WebDriverWait wait = new WebDriverWait(driver, 30);

Actions appmgmt = new Actions(driver);
wait.until(ExpectedConditions.visibilityOfElementLocated(applicationMgmt_btn));
appmgmt.moveToElement(driver.findElement(applicationMgmt_btn)).build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(applicationQueue_btn));
driver.findElement(applicationQueue_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Application Queue' button under Application Mgmt menu");

driver.switchTo().defaultContent();
driver.switchTo().frame(mainFrame);

WebElement main = driver.findElement(By.name("main"));
driver.switchTo().frame(main);

wait.until(ExpectedConditions.visibilityOfElementLocated(cso_drp));
Select cso = new Select(driver.findElement(cso_drp));
cso.selectByVisibleText(csoSelect);
test.log(LogStatus.PASS,"CSO selected as: "+ csoSelect +" in Application Queue page");

Select loanStatus = new Select(driver.findElement(loanStatus_drp));
loanStatus.selectByIndex(3);
test.log(LogStatus.PASS,"Loan Status selected as: 'Pending Funding' in Application Queue page");

driver.findElement(applicationQueueSearch_btn).click();
Thread.sleep(500);
test.log(LogStatus.PASS,"Clicked on 'Submit' button in Application Queue page");


	WebElement htmltable = driver.findElement(searchResults_webTbl);
	
	// Picking Loan from WebTable
	List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

	for (rnum = 3; rnum < rows.size(); rnum++) {

		List<WebElement> columns = rows.get(rnum).findElements(
				By.tagName("td"));

		for (int i = 1; i <= 1; i++)// columns.size()
		{
			String lmsLoanNumber = columns.get(i).getText();

			if (lmsLoanNumber.equalsIgnoreCase(loanNumber)) {

				test.log(LogStatus.PASS,
						"'Searched for loan number' in pending funding search results");

				driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr["	+ rnum + "]/td[13]/input")).click();
											
				
		
				Thread.sleep(500);
				test.log(LogStatus.PASS,
						"Clicked on 'Go' button in search results web table ");
			
				
			}
			}
		}
	
	String parentwindow = driver.getWindowHandle();

	for (String handle : driver.getWindowHandles()) {

		if (!handle.equalsIgnoreCase(parentwindow)) {

			driver.switchTo().window(handle);
			
			WebElement embedFrame=driver.findElement(By.className("pdaAc"));
			driver.switchTo().frame(embedFrame);
			//driver.findElement(By.id("assignedDoc")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='showDocDetails']/tbody/tr[7]/td[1]/a")));
			driver.findElement(By.xpath("//*[@id='showDocDetails']/tbody/tr[7]/td[1]/a")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.name("status0")));			
			driver.findElement(By.name("status0")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='showDocDetails']/tbody/tr[8]/td[1]/a")));
			driver.findElement(By.xpath("//*[@id='showDocDetails']/tbody/tr[8]/td[1]/a")).click();			
			wait.until(ExpectedConditions.elementToBeClickable(By.name("status1")));
			driver.findElement(By.name("status1")).click();
						

			//wait.until(ExpectedConditions.elementToBeClickable(acceptPDA_rad));
		//	driver.findElement(acceptPDA_rad).click();
			Thread.sleep(500);
			test.log(LogStatus.PASS,"Clicked on 'Accept PDA document' radio button in View PDA Document Page");
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitPDA_btn)));
			driver.findElement(submitPDA_btn).click();
			
			test.log(LogStatus.PASS,
					"Clicked on 'Submit' button in View PDA Document Page");
			Thread.sleep(500);
			wait.until(ExpectedConditions.alertIsPresent());
			
			Alert alert=driver.switchTo().alert();
			alert.accept();
			test.log(LogStatus.PASS, "Loan Originated Successfully");
	
		}
			driver.switchTo().window(parentwindow);
			driver.switchTo().defaultContent();
	}
}
}