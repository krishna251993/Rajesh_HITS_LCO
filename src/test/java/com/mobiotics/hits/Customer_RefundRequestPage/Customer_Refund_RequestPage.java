package com.mobiotics.hits.Customer_RefundRequestPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

import generic.DateHelper;


public class Customer_Refund_RequestPage extends BasePage {
	
	
	public static int startday;
	public static int endDay;
	public static int disconnectDay;
	public boolean isDisplayErrEndDateGreater;
	public boolean isDisplayErrDisconnectAfter4Days;
	
	
	public Customer_Refund_RequestPage() {
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(Customer_Refund_RequestPage.class);
	
	
	@FindBy(xpath="//input[@name='lconame' and @placeholder='Enter the LCO Username ' ]")
	private WebElement lcoNwkName;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='customerid']")
	private WebElement customerId;
	

	@FindBy(xpath="//input[@name='packagename']")
	private WebElement packageNameField;
	
	@FindBy(name="packagerate")
	private WebElement packageRateField;
	
	
	//xpath need to be change
	@FindBy(xpath="(//span[@class='input-group-addon'])[2]")
	private WebElement packageStartCal;
	
	
    private String xp1="(//td[text()='";
	
	private String xp2="'])[7]";
	
	
	@FindBy(xpath="(//span[@class='input-group-addon'])[3]")
	private WebElement packageEndCal;
	
	@FindBy(xpath="//*[@id='end_date']/div[2]/table/thead/tr[1]/th[1]/span")
	
	//(//i[@class='glyphicon glyphicon-chevron-right'])[5]
	private WebElement packageEndMonth;
	
	private String endXp1 = "(//td[text()='";
	private String endXp2 = "'])[9]";
	
	@FindBy(xpath="(//i[@class='glyphicon glyphicon-calendar'])[4]")
	private WebElement packDisconnectCal;
	
	String disconnectXp1 = "(//td[text()='";
	String disconnectXp2 = "'])[11]";
	
	@FindBy(xpath="//input[@value='GO']")
	private WebElement goButton;
	
	@FindBy(xpath="//input[@name='reason']")
	private WebElement reason;
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitFormButton;
	
	
	@FindBy(xpath = "//p[@class='text-danger error_start']")
	private WebElement errEndDateGreater;
	
	@FindBy(xpath = "/html/body/div[1]")
	private WebElement errDisconnectAfter4days;
	
	
	@FindBy(xpath = "//*[@id=\"end_date\"]/div[2]/table/thead/tr[1]/th[1]/span")
	private WebElement endMonth;
	
	@FindBy(xpath = "(//a[@class='previous'])[9]")
	private WebElement endDatePreviousMonth;
	
	@FindBy(xpath="//button[@class='btn btn-success pull-right btn-md requestbutton']")
	private WebElement refundRequest;
	
	
	private String path="./ExcelPages/TestData.xlsx";
	
	public void clickOnRefundRequest() {
		waitTillElementIsClickable(refundRequest);
		refundRequest.click();
	}
	
	
	public void setLCONwkName(String lconame)
	{
		lcoNwkName.clear();
		lcoNwkName.sendKeys(lconame);
	}
	
	public void setEmail(String emailId)
	{
		email.clear();
		email.sendKeys(emailId);
	}
	
	
	public void setCustomerId(String canNo)
	{
		customerId.clear();
		customerId.sendKeys(canNo);
	}
	
	public void setPackageName(String packageName)
	{
		packageNameField.clear();
		packageNameField.sendKeys(packageName);
	}
	
	public void setPackageRate(String packageRate)
	{
		packageRateField.clear();
		packageRateField.sendKeys(packageRate);
	}
	
	public void clickpackStartDateCalendar()
	{
		waitTillElementIsVisible(packageStartCal);
		packageStartCal.click();
	}
	
	public void clickPackEndCalendar()
	{
		waitTillElementIsVisible(packageEndCal);
		packageEndCal.click();
	}
	
	public WebElement selectEndMonth()
	{
		waitTillElementIsVisible(packageEndMonth);
		return packageEndMonth;
	}
	
	public void clickRefundRequestCalendar() throws InterruptedException
	{
		waitTillElementIsVisible(packDisconnectCal);
		packDisconnectCal.click();
	}
	
	public void clickGoButton()
	{
		goButton.click();
	}
	
	public void setReason(String reasonToDisconnect)
	{
		reason.clear();
		reason.sendKeys(reasonToDisconnect);
	}
	
	public void submitForm()
	{
		submitFormButton.click();
	}
	
	
	public boolean isDisplayederrEndDateGreater()
	{
		return errEndDateGreater.isDisplayed();
	}
	
	public String getTexterrEndDateGreater()
	{
		return errEndDateGreater.getText();
	}
	
	
	public boolean isDisplayederrDisconnectAfter4days()
	{
		waitTillElementIsVisible(errDisconnectAfter4days);
		return errDisconnectAfter4days.isDisplayed();
	}
	
	public String getTexterrDisconnectAfter4days()
	{
		waitTillElementIsVisible(errDisconnectAfter4days);
		return errDisconnectAfter4days.getText();
	}
	
	public String getEndMonthText()
	{
		waitTillElementIsVisible(endMonth);
		return endMonth.getText();
	}
	
	public WebElement clickPreviusForEndMonth()
	{
		waitTillElementIsVisible(endDatePreviousMonth);
		return endDatePreviousMonth;
	}
	
	public void runXpathForStartDate(int num) {
		waitTillElementIsVisible(driver.findElement(By.xpath(xp1+num+xp2)));
		driver.findElement(By.xpath(xp1+num+xp2)).click();
		
	}
	
	public void runXpathForEndDay(int endDay)
	{
		waitTillElementIsVisible(driver.findElement(By.xpath(endXp1+endDay+endXp2)));
		driver.findElement(By.xpath(endXp1+endDay+endXp2)).click();
	}
	
	
	public void runXpathForDisconnectDate(int disconnectDate)
	{
		waitTillElementIsVisible(driver.findElement(By.xpath(disconnectXp1+disconnectDate+disconnectXp2)));
		driver.findElement(By.xpath(disconnectXp1+disconnectDate+disconnectXp2)).click();
	}
	
	
	public void refundCalculationWithoutTax() {
		
	}
	
	public void putRefundRequest() throws InterruptedException {
		
		DateHelper datehelper=new DateHelper();
		//clickOnRefundRequest();
		int rowCount=DemoExcelLibrary3.getlastrow("Refund", path);
		for (int i = 1; i < rowCount; i++) {
			isDisplayErrEndDateGreater = false;	
			isDisplayErrDisconnectAfter4Days = false;
			String lcoNwkName=DemoExcelLibrary3.getexcelData("Refund", i, 0, path);
			logger.info("LCO Network name is: "+lcoNwkName);
			// code need to be implement
			
			
			setLCONwkName(lcoNwkName);
			String email=DemoExcelLibrary3.getexcelData("Refund", i, 1, path);
			
			logger.info("LCO email id is "+email);
			
			setEmail(email);
			
			long custID= DemoExcelLibrary3.getexcelDatanumber("Refund", i, 2, path);
			setCustomerId(String.valueOf(custID));
			
			String packageName=DemoExcelLibrary3.getexcelData("Refund", i, 3, path);
			logger.info("Package name is: "+packageName);
			setPackageName(packageName);
			
			int packageRate=DemoExcelLibrary3.getexcelDatanumber("Refund", 1, 4, path);
			logger.info("Pack Rate is: "+packageRate);
			setPackageRate(String.valueOf(packageRate));
			
			clickpackStartDateCalendar();
			String startDate=DemoExcelLibrary3.getexcelData("Refund", 1, 5, path);
			logger.info("pack start date is "+startDate);
			
			startday=DemoExcelLibrary3.changeDateToNum(path, "Refund", i, 5, 0, 1);
			
			datehelper.selectDate("//*[@id='start_date']/div[2]/table/tbody/tr[", "]/td[", startday);
			
			Thread.sleep(3000);
			
			clickPackEndCalendar();
			
			String currentMonthString=getEndMonthText();
			
			DateHelper.selectMonth(path, "Refund", currentMonthString, i, 6, clickPreviusForEndMonth(), selectEndMonth());
			
			String endDate=DemoExcelLibrary3.getexcelData("Refund",i, 6, path);
			logger.info("Pack End Date is "+endDate);
			
			
			endDay=DateHelper.changeDateToNum(path, "Refund", i, 6, 0, 1);
			
			
			//Need to be verify
			
			
			datehelper.selectDate("//*[@id='end_date']/div[2]/table/tbody/tr[", "]/td[", endDay);
			
			clickRefundRequestCalendar();
			
			String disconnectDate=DemoExcelLibrary3.getexcelData("Refund", i, 7, path);
			logger.info("Pack disconnect date is "+disconnectDate);
			
			DateHelper.changeDateToNum(path, "Refund", i, 7, 0, 1);
			datehelper.selectDate("//*[@id='disc_date']/div[2]/table/tbody/tr[", "]/td[", disconnectDay);
			
			String reasonOfDisconnect=DemoExcelLibrary3.getexcelData("Refund", i, 8, path);
			
			clickGoButton();
			
			
			try {
				isDisplayErrEndDateGreater=isDisplayederrEndDateGreater();
				if(isDisplayErrEndDateGreater) {
					String errEndDateGreaterMsg=getTexterrEndDateGreater();
					logger.info(errEndDateGreaterMsg);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		
			try
			{
				if(isDisplayErrDisconnectAfter4Days==false && isDisplayErrEndDateGreater==false )
				{
					//calculate the refound amound and validate it
					//if refund amount is also correct then click submit button
					setReason(reasonOfDisconnect);
					submitForm();
				}
			}
			
			catch (Exception e) 
			{
				
			}
			
			System.out.println();
			System.out.println();
			
		}
		
	}
	
	
}
