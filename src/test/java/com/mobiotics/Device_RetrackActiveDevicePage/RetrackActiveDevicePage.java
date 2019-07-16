package com.mobiotics.Device_RetrackActiveDevicePage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

public class RetrackActiveDevicePage extends BasePage {

	
	static final Logger logger=Logger.getLogger(RetrackActiveDevicePage.class);
	
	public RetrackActiveDevicePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "serialno")
	private WebElement enterCustSerialNum;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clickOnSendButton;

	@FindBy(id = "retrack_error")
	private WebElement invalidData;

	@FindBy(id = "retrack_error")
	private WebElement errorMsg;

	@FindBy(id = "customerName")
	private WebElement customerName;

	@FindBy(id = "retrack_success")
	private WebElement successMsg;
	
	@FindBy(id="bulkretrackmodal")
	private WebElement bulkRetrackButton;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement fileUploaed;
	
	@FindBy(xpath="//label[@class='upload-status text-success']")
	private WebElement uploadSuccessStatus;
	
	@FindBy(id="upload")
	private WebElement uploadBtn;
	
	@FindBy(xpath="//*[@id=\"bulkretrack\"]/div/div/div[2]/p[1]")
	private WebElement fatelError;
	
	@FindBy(xpath="//*[@id=\"bulkretrack\"]/div/div/div[2]/p[2]")
	private WebElement successStatus;
	
	@FindBy(xpath="(//button[@class='btn btn-default'])[1]")
	private WebElement closeBtn;
	
	
	
	
	private String bulkRetrackFile=System.getProperty("user.dir")+"/ExcelPages/BulkRetrack.csv";
	
	private String dataPath="./ExcelPages/TestData.xlsx";
	
	public boolean checkSuccessMsg() {
		try {
			driver.findElement(By.id("retrack_success"));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("Success msg not get due to "+e.getMessage());
			return false;
		}
	}
	
	
	public void retrackActiveService() throws InterruptedException {
		int lastRow=DemoExcelLibrary3.getlastrow("modify customer", dataPath);
		for (int i = 1; i <= lastRow; i++) {
			waitTillElementIsVisible(enterCustSerialNum);
			enterCustSerialNum.clear();

			long custIDNum=DemoExcelLibrary3.getexcelDatanumber("modify customer", i, 10, dataPath);
			String custIDString=String.valueOf(custIDNum);
			
			enterCustSerialNum.sendKeys(custIDString);
			logger.info("user entered "+custIDString+" Retrack the Active Devices");
			waitTillElementIsVisible(clickOnSendButton);
			clickOnSendButton.click();
			Thread.sleep(25000);
			
			
			if (customerName.isDisplayed()) {
				System.out.println("Customer Name is " + customerName.getText());
				if (checkSuccessMsg()) {
					Thread.sleep(10000);
					waitTillElementIsVisible(successMsg);
					String passMsg = successMsg.getText();
					System.out.println(passMsg);
					Thread.sleep(4000);
					
					driver.findElement(By.xpath("//button[@type='submit']")).click();
				}else {
					Thread.sleep(10000);
					waitTillElementIsVisible(errorMsg);
					String failMsg = errorMsg.getText();
					System.out.println(failMsg);
					logger.info("error message="+failMsg);
					Thread.sleep(4000);
				}
				
				break;
				}else {
					logger.info("invalid customer");
				}
		}
		
		Thread.sleep(4000);
}
	
	
	
	
	public void Retrack_ActiveDevice_Bulk() {
		waitTillElementIsVisible(bulkRetrackButton);
		bulkRetrackButton.click();
		
		//waitTillElementIsVisible(fileUploaed);
		fileUploaed.sendKeys(bulkRetrackFile);
		
		waitTillElementIsVisible(uploadBtn);
		uploadBtn.click();
		
		waitTillElementIsVisible(uploadSuccessStatus);
		
		logger.info("uploading status:-"+uploadSuccessStatus.getText());
		
		if(uploadSuccessStatus.getText().equals("Upload success"))
		{
			logger.info(successStatus.getText());
			waitTillElementIsVisible(closeBtn);
			closeBtn.click();
			
		}
		
		
	}
}