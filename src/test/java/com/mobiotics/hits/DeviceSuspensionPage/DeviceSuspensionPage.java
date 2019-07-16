package com.mobiotics.hits.DeviceSuspensionPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;


import generic.DateHelper;


public class DeviceSuspensionPage extends BasePage {

	
	String fromDateXp1 = "/html/body/div[4]/div[1]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[";
	String fromDateXp2 = "]/td[";
	
	String path="./ExcelPages/TestData.xlsx";
	
	DateHelper dh = new DateHelper();
	
	public DeviceSuspensionPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(DeviceSuspensionPage.class);
	
	@FindBy(xpath = "//h1[text()='Suspension']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[1]")
	private WebElement fromDateCal;
	
	@FindBy(xpath = "(//a[@class='previous']/following-sibling::span)[1]")
	private WebElement fromMonth;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[1]")
	private WebElement previousMnthShftFrom;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[1]")
	private WebElement nxtShftMnthFrm;
	
	@FindBy(xpath = "(//a[@class='previous'])[2]/following-sibling::span")
	private WebElement yearFrom;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[2]")
	private WebElement previousShftYearFrom;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[2]")
	private WebElement nxtShftYEARFrom;
	
	@FindBy(id = "refresh")
	private WebElement goDateBtn;
	
	
	@FindBy(xpath = "//input[@name='customerid']/following-sibling::button")
	private WebElement goBtnCustId;
	
	@FindBy(id = "bulksuspensionmodal")
	private WebElement suspensionBtn;
	
	@FindBy(name = "customerid")
	private WebElement customerIdTxtFld;

	@FindBy(id = "customerno")
	private WebElement custIdTxtFieldInPopup;
	
	@FindBy(id = "uploadSingleSuspension")
	private WebElement submitBtnPopUp;
	
	@FindBy(xpath = "//*[@id='suspensionmessage']/p[1]/div/strong")
	private WebElement suspensionMsg;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement uploadFile;
	
	
	@FindBy(id = "uploadBulk")
	private WebElement uploadBtn;
	
	@FindBy(xpath = "//label[text()='Upload success']")
	private WebElement uploadSuccessMsg;
	
	@FindBy(id = "myModalLabel")
	private WebElement popupTitle;
	
	@FindBy(id = "uploadtype")
	private WebElement uploadTypeDropDown;
	
	@FindBy(id = "close")
	private WebElement closeBtn;
	
	@FindBy(xpath = "//button[text()='Suspension Download']")
	private WebElement suspensionDownloadBtn;
	
		
	@FindBy(xpath="//div[@class='alert alert-danger top-error text-center']")
	private WebElement NodataFoundPopUp;
	
	
	
	
	private String nodataFound="//div[@class='alert alert-danger top-error text-center']";
	
	private String dataPath="./ExcelPages/TestData.xlsx";
	
	private String bulkSuspensionFilePath=System.getProperty("user.dir")+"/ExcelPages/bulksuspension_reactivatetemplate.csv";
	
	
	public void SuspeensionCustomer(String uploadType ) throws InterruptedException {
		
		
		
		waitTillElementIsClickable(suspensionBtn);
		
		suspensionBtn.click();
		
		Select listUploadType = new Select(uploadTypeDropDown);
		listUploadType.selectByVisibleText(uploadType);
		
		if(uploadType.equalsIgnoreCase("Single")) {
			
			String custID=String.valueOf(DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 15, dataPath));
			
			custIdTxtFieldInPopup.sendKeys(custID);
			submitBtnPopUp.click();
			
			try {
				if(suspensionMsg.isDisplayed())
				{
					logger.info(suspensionMsg.getText());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(1000);
			closeBtn.click();	
			
		}
		else {
			uploadFile.sendKeys(bulkSuspensionFilePath);
			
			waitTillElementIsClickable(uploadBtn);
			uploadBtn.click();
			
			if(uploadSuccessMsg.isDisplayed())
			{
				logger.info(uploadSuccessMsg.getText());
				Assert.assertTrue(uploadSuccessMsg.isDisplayed());
			}
			
			else
			{
				
				logger.info("Bulk Upload is failed");
			}
			Thread.sleep(1000);
			closeBtn.click();
		}
		
		
		
				
	
	
	
	
	
}
}