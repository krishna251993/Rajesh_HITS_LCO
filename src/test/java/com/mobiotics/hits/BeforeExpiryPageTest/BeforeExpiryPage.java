package com.mobiotics.hits.BeforeExpiryPageTest;

import java.util.List;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

import generic.Utility;

public class BeforeExpiryPage  extends BasePage{

	public BeforeExpiryPage() {
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger= Logger.getLogger(BeforeExpiryPage.class);

	@FindBy(name = "customerid")
	private WebElement enterCustomerIdToSearch;

	@FindBy(id = "customerName")
	private WebElement custName;
	
	//@FindBy(xpath = "//button[@data-target='#confirmRemoveModal']")
	//private List<WebElement> doNotRenewbuttons;
	
	@FindBy(xpath = "(//div[@class='modal-content'])[3]")
	private WebElement popUp;
	
	@FindBy(className = "confirmMessage")
	private WebElement confirmMsg;
	
	
	@FindBy(xpath = "//button[@class='btn btn-warning confirm']")
	private WebElement popUpConfirmButton;
	
	@FindBy(xpath = "((//div[@class='modal-content'])[2]//p)[1]")
	private WebElement popUpErrorMsg;
	
	@FindBy(xpath = "//p[.='Removed Successfully.']")
	private WebElement popUpSuccessMsg;
	
	@FindBy(id = "confirm_close")
	private WebElement popUpClosebutton;
	
	@FindBy(id = "customerid")
	private WebElement clickToSearchCustomer;
	
	@FindBy(id = "confirm-subscribe")
	private WebElement clickOnRenewAll;
	
	@FindBy(id = "bulkdonotrenewmodal")
	private WebElement bulkDoNotRenewButton;
	
	@FindBy(xpath = "(//input[@type='file'])[1]")
	private WebElement fileUpload;
	
	@FindBy(id = "upload")
	private WebElement uploadButton;
	
	@FindBy(xpath="(//button[@class='btn btn-default'])[2]")
	private WebElement closeBtn;
	
	@FindBy(id="bulkrenewmodal")
	private WebElement clickonbullkbutton;
	
	@FindBy(xpath="//label[.='Upload success']")
	private WebElement singleSuccessMsg; 

	@FindBy(xpath="(//p[@class='error text-danger'])[1]")
	private WebElement otherError;
	
	@FindBy(xpath="//button[@type='button' and @class='btn btn-warning removeButton']")
	private List<WebElement> doNotRenewBtns;
	
	@FindBy(xpath="(//button[@class='btn btn-warning confirm'])")
	private WebElement confirmToClose;
	
	@FindBy(xpath="((//button[@class='btn btn-default' and text()='Close']))[3]")
	private WebElement close;
	private String xp1="(//button[@type='button' and @class='btn btn-warning removeButton'])[";
	
	private String xp2="]";
	
	
	
	private String path="./ExcelPages/TestData.xlsx";
	
	private String bulkRenewFilePath=System.getProperty("user.dir")+"/ExcelPages/BulkRenew_Before_Expiry.csv";
	
	
	//private String bulkDoNotrenewFilepath=System.getProperty("user.dir")+"/ExcelPages/bulkDoNotRenew_BeforeExpiry.csv";
	
	public int calNoOfRenewOptionAvailable() {
		return doNotRenewBtns.size();
	}
	
	public void  runXpath(int randomNo) {
		driver.findElement(By.xpath(xp1+randomNo+xp2)).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void renewBeforeExpiryIn_Bulk() {
		
		
		waitTillElementIsVisible(clickonbullkbutton);
		clickonbullkbutton.click();
		logger.info("user clicked on the Bulk Renew option");
		//waitTillElementIsVisible(fileUpload);
		fileUpload.sendKeys(bulkRenewFilePath);
		logger.info("user uploaded the bulk file");
		waitTillElementIsVisible(uploadButton);
		uploadButton.click();
		logger.info("User hit the Upload button");
		
		waitTillElementIsVisible(singleSuccessMsg);
		if (singleSuccessMsg.getText().contentEquals("Upload success"))
		{
			logger.info(singleSuccessMsg.getText());
			
			if(otherError.isDisplayed()) {
				logger.warn("other error is displaying i.e "+otherError.getText());
				waitTillElementIsVisible(closeBtn);
				closeBtn.click();
			}
			else {
				logger.info("user has successfully added the bulk file");
				
				closeBtn.click();
				
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	//-------------------------Single Renew the Active Product-----------------------
	
	public void singleRenewActiveProduct() throws InterruptedException {
		
		logger.info("user is going renew the plans singaly");
		waitTillElementIsVisible(enterCustomerIdToSearch);
		enterCustomerIdToSearch.clear();
		String custID=String.valueOf(DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 12, path));
		
		enterCustomerIdToSearch.sendKeys(custID);
		waitTillElementIsVisible(clickToSearchCustomer);
		clickToSearchCustomer.click();
		
		//exception need to be handled
		
		waitTillElementIsVisible(custName);
		logger.info("customer who is going to renew the Active product is "+custName.getText());
		
		if(calNoOfRenewOptionAvailable()>1) {
			int totalRenewOption=calNoOfRenewOptionAvailable();
			int randomNo=Utility.getRandomNumber(1, totalRenewOption);
			
			
			
			runXpath(randomNo);
			logger.info("user renewe the plane which having the index of "+randomNo);
			waitTillElementIsVisible(confirmToClose);
			confirmToClose.click();
			Thread.sleep(10000);
			waitTillElementIsVisible(close);
			close.click();
			
		}
			
	}
	}
