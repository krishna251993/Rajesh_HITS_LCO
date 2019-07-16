package com.mobiotics.hits.Renew_AfterExpiryPage;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

import generic.Utility;

public class AfterExpiryPage extends BasePage {
	
	static final Logger logger=Logger.getLogger(AfterExpiryPage.class);
	
	public AfterExpiryPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "customerid")
	private WebElement enterCustomerIdToSearch;
	
	@FindBy(id = "customerid")
	private WebElement clickToSearchCustomer;
	
	@FindBy(id = "confirm-subscribe")
	private WebElement clickOnConfirmSelect;
	
	@FindBy(xpath="//input[@name='productlist']")
	private List<WebElement> checkBoxes;
	
	@FindBy(xpath = "//table[@class='table cart']//tbody//td[1]")
	private WebElement productName;
	
	@FindBy(xpath = "//table[@class='table cart']//tbody//td[2]")
	private WebElement totalLCOPrice;
	
	@FindBy(xpath = "//table[@class='table cart']//tbody//td[3]")
	private WebElement totalNCFPrice;
	
	@FindBy(xpath = "//table[@class='table cart']//tbody//td[4]")
	private WebElement totalTax;
	
	@FindBy(xpath = "//table[@class='table cart']//tbody//td[4]")
	private WebElement expiryDate;
	
	@FindBy(xpath = "//table[@class='table cart']//tbody//td[5]")
	private WebElement totalAmount;
	
	@FindBy(xpath = "//button[@id='confirmcart']")
	private WebElement renewButton;
	
	@FindBy(xpath = "//div[@class='productreport table-responsive']//td[1]")
	private WebElement productId;
	
	@FindBy(xpath = "//div[@class='productreport table-responsive']//td[2]")
	private WebElement productName1;
	
	@FindBy(xpath = "//div[@class='productreport table-responsive']//td[3]")
	private WebElement status;
	
	@FindBy(xpath = "//div[@class='productreport table-responsive']//td[4]")
	private WebElement error;
	
	@FindBy(xpath = "//div[@class='productreport table-responsive']//td[5]")
	private WebElement errorCode;
	
	@FindBy(xpath = "(//div[@class='alert alert-danger top-error text-center fixed-top'])")
	private WebElement popUp;
	
	@FindBy(id = "bulkrenewmodal")
	private WebElement clickonbullkbutton;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement choosefiletoUpload;
	
	@FindBy(id = "upload")
	private WebElement uploadButton;
	
	@FindBy(xpath="//label[@class='upload-status text-success']")
	private WebElement uploadsucessMsg;
	
	
	@FindBy(id = "close")
	private WebElement closeButton;
	
	@FindBy(xpath = "//div[@id='bulkrenew']//p[1]")
	private WebElement otherError;
	
	@FindBy(xpath = "//div[@id='bulkrenew']//p[2]")
	private WebElement successErrorfinal;
	
	@FindBy(id = "customerName")
	private WebElement custName;
	
	private String xp1="(//input[@name='productlist'])[";
	
	private String xp2="]";
	
	private String path="./ExcelPages/TestData.xlsx";
	
	private String bulkFilePath=System.getProperty("user.dir")+"/ExcelPages/bulkRenew_AfterExpiry.csv";
	
	public int countNumberOfPlans() {
		return checkBoxes.size();
	}
	
	
	public void runXpath(int randomNum) {
		driver.findElement(By.xpath(xp1+randomNum+xp2)).click();
	}
	
	
	
	
	
	
	public void RenewTheAfterExpiryInBulk() throws InterruptedException {
		waitTillElementIsVisible(clickonbullkbutton);
		 clickonbullkbutton.click();
		 logger.info("user clicked Bulk Renew Button");
		 
		//waitTillElementIsVisible(choosefiletoUpload); 
		choosefiletoUpload.sendKeys(bulkFilePath);
		
		logger.info("user uploaded the bulk file");
		waitTillElementIsVisible(uploadButton);
		uploadButton.click();
		logger.info("After bulk file upload user clicked on upload btn");
		
		waitTillElementIsVisible(uploadsucessMsg);
		
		 System.out.println(uploadsucessMsg.getText());
		 
		 if (uploadsucessMsg.getText().contentEquals("Upload success")) {
			 
			 
			 logger.info("user uploaded the bulk file successfuly");
			 
			 if (otherError.isDisplayed()) {
				 logger.info("other Error is displayed");
				 waitTillElementIsVisible(otherError);
				 logger.info("other error is "+otherError.getText());
				 
			 }
			 else if (successErrorfinal.isDisplayed()) {
				 log.info("Success Msg");
				 waitTillElementIsVisible(successErrorfinal);
				 System.out.println(successErrorfinal.getText());
				 logger.info(successErrorfinal.getText());
				 
			 }
		 }
		 
		 waitTillElementIsVisible(closeButton);
		 
		 Thread.sleep(50000);
		 
		 closeButton.click();
		
	}
	
	//--------------------This is Singal Renewal------------------
	
	
	
	public void singalRenewOfExpiredPlane() {
		logger.info("user is going to renew the plan singal");
		waitTillElementIsVisible(enterCustomerIdToSearch);
		
		
		long custIDNum=DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 11, path);
		String custIDString=String.valueOf(custIDNum);
		
		enterCustomerIdToSearch.sendKeys(custIDString);
		
		
		waitTillElementIsVisible(clickToSearchCustomer);
		clickToSearchCustomer.click();
		if(countNumberOfPlans()>0) {
			int totalPlans=countNumberOfPlans();
			int randomPlans=Utility.getRandomNumber(1, totalPlans);
			runXpath(randomPlans);
			
			waitTillElementIsVisible(clickOnConfirmSelect);
			clickOnConfirmSelect.click();
			
			logger.info("user clicked the confirm Button");
			
			waitTillElementIsVisible(totalNCFPrice);
			waitTillElementIsVisible(totalTax);
			
			float LCOPrice=Float.valueOf(totalLCOPrice.getText());
			float NCFPrice=Float.valueOf(totalNCFPrice.getText());
			System.out.println(NCFPrice);
			float tax=Float.valueOf(totalTax.getText());		
			System.out.println(tax);
			
			float totalPrice=Utility.calculatePrice(LCOPrice, NCFPrice, tax);
			
			
			System.out.println("Total price="+totalPrice);
			
			logger.info("Total price By Calculation="+totalPrice);
			
			
			float total=Float.valueOf(totalAmount.getText());
			System.out.println("Total price by portal="+ total);
			
			logger.info("Total price by portal="+ total);
			
			if(totalPrice==total) {
				logger.info("Price calculation has done correctly");
			}
			
			else {
				logger.info("Expected prise and calculated price is different");
			}
			
			String id = productName.getText();
			String expiry = expiryDate.getText();
			//String amount = totalAmount.getText();
			
			System.out.println(
					"ProductName is " + id + " Expiry Date " + expiry );
			
			waitTillElementIsVisible(renewButton);
			
			
			renewButton.click();
			
			waitTillElementIsVisible(productId);
			
			String id1 = productId.getText();
			String name = productName1.getText();
			String statusPlan = status.getText();
			String errorMsg = error.getText();
			String errorMsgCode = errorCode.getText();
			
			System.out.println("ProductId is " + id1 + " Product Name is " + name + " Status of Plan is "
					+ statusPlan + " ErrorMessage is " + errorMsg + " and the Error Code is " + errorMsgCode);
		
			
		}
	}
	
}
