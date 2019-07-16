package com.mobiotics.hits.OSDPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.product_Addproduct_AddALCartePage.AddAla_CartePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

public class OSDMessageServicePage extends BasePage {

	public OSDMessageServicePage() {
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(AddAla_CartePage.class);

	@FindBy(id = "serialno")
	private WebElement enterCustSerialNum;
	
	@FindBy(id = "messagetemplate")
	private WebElement selectMessage;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-info']")
	private WebElement clickOnSendButton;
	
	@FindBy(xpath = "//form[@id='osd']/p[1]")
	private WebElement successMsg;
	
	@FindBy(id = "customerName")
	private WebElement customerName;
	
	@FindBy(xpath = "//form[@id='osd']/p[2]")
	private WebElement errorMsg;
	
	@FindBy(id="bulkmodalsubscribe")
	private WebElement bulkOSDBtn;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement fileUpload;
	
	@FindBy(id="upload")
	private WebElement uploadBtn;
	
	@FindBy(xpath="//p[@class='success text-success']")
	private WebElement requestsuccessfullymsg;
	
	@FindBy(xpath="//label[@class='upload-status text-success']")
	private WebElement uploadSuccess;
	
	@FindBy(xpath="(//button[@class='btn btn-default'])[1]")
	private WebElement closeBtn;
	
	
	private String dataPath="./ExcelPages/TestData.xlsx";
	
	private String bulkFilePath=System.getProperty("user.dir")+"/ExcelPages/BulkOSDTempelate.csv";
	
	

	public void osdMsgService() throws InterruptedException {
		
		waitTillElementIsVisible(enterCustSerialNum);
		enterCustSerialNum.clear();
		long custIDNum=DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 9, dataPath);
		String custIDString=String.valueOf(custIDNum);
		enterCustSerialNum.sendKeys(custIDString);
		logger.info("user entered "+custIDString+" for sending OSD message");
		enterCustSerialNum.sendKeys(Keys.TAB);
		waitTillElementIsVisible(customerName);
		
		if (customerName.isDisplayed()) {
			System.out.println("Customer Name is " + customerName.getText());
			logger.info("Customer Name is " + customerName.getText());
			
			Select select = new Select(selectMessage);
			select.selectByVisibleText("1 - Welcome to NXTDigital");
			clickOnSendButton.click();
			Thread.sleep(2500);
			try {
				waitTillElementIsVisible(successMsg);
			} catch (Exception e) {
				logger.info("Exception came on the successfull Message:-"+e.getMessage());
			}
			
			if (successMsg.isDisplayed()) {
				Thread.sleep(1000);
				log.info("success msg displayed");
				waitTillElementIsVisible(successMsg);
				String sucessMsg = successMsg.getText();
				System.out.println(sucessMsg);
				Thread.sleep(3000);

			} else if (errorMsg.isDisplayed()) {
				log.info("error msg displayed");
				Thread.sleep(1000);
				waitTillElementIsVisible(errorMsg);
				String failMsg = errorMsg.getText();
				System.out.println(failMsg);
				Thread.sleep(3000);

			}
		}else {
			System.out.println("Customer Name not displaying");
		}
		
	}
	
	 public void sendOSDSingnalIn_Bulk() {
		 
		 waitTillElementIsVisible(bulkOSDBtn);
		 
		 bulkOSDBtn.click();
		 fileUpload.sendKeys(bulkFilePath);
		 
		 waitTillElementIsVisible(uploadBtn);
		 uploadBtn.click();
		 
		 waitTillElementIsVisible(uploadSuccess);
		 logger.info(uploadSuccess.getText());
		 
		 if(uploadSuccess.getText().equals("Upload success")){
			 waitTillElementIsVisible(requestsuccessfullymsg);
			 logger.info(requestsuccessfullymsg.getText());
			 
			 waitTillElementIsVisible(closeBtn);
			 closeBtn.click();
			 
		 }
		  
		 
		 
		
	}
}
