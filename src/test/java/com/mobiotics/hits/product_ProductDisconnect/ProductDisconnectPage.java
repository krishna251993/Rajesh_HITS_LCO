package com.mobiotics.hits.product_ProductDisconnect;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

import generic.Property;





public class ProductDisconnectPage extends BasePage {
	
	static final Logger logger = Logger.getLogger(ProductDisconnectPage.class);

	public ProductDisconnectPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='customerid']")
	  private WebElement enterCustomerSerialNumber;
	
	@FindBy(xpath="//button [@id='customerid']")
	  private WebElement clickToSearchCustomer;
	
	@FindBy(xpath="//div[@class='productsubscription table-responsive']//tbody//td[5]")
	  private List<WebElement> checkBoxes;
	
	@FindBy(xpath="//div[@class='productsubscription table-responsive']//tbody//td[5]")
	  private WebElement checkBox;
	
	@FindBy(xpath="//button[@id='confirm-subscribe']")
	  private WebElement clickToConfirmSelect;
	
	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//td[1]")
	  private WebElement packageName;
	
	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//td[2]")
	  private WebElement contractId;
	
	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//td[3]")
	  private WebElement expiryDate;
	
	  @FindBy(xpath="//button[@id='confirmcart']")
	  private WebElement clickToDisconnectThePlan;
	
	  
	  @FindBy(xpath="//div[@class='productreport table-responsive']//tbody//td[1]")
	  private WebElement ProductId;
	  
	  @FindBy(xpath="//div[@class='productreport table-responsive']//tbody//td[2]")
	  private WebElement productName;
	  
	  @FindBy(xpath="//div[@class='productreport table-responsive']//tbody//td[3]")
	  private WebElement statusOfPlan;
	  
	  @FindBy(xpath="//div[@class='productreport table-responsive']//tbody//td[4]")
	  private WebElement error;
	  
	  @FindBy(xpath="//div[@class='productreport table-responsive']//tbody//td[5]")
	  private WebElement errorCode;
	  
	
	  @FindBy(xpath="/html/body/div[1]")
	  private WebElement invalidCust;
	  
	  private String invalidCustString="/html/body/div[1]";
	  
	  @FindBy(xpath="//div[@class='alert alert-danger top-error text-center' and text()='	Get Customer Failed']")
	  private WebElement errorMessage;
	  
	  @FindBy(id="customerName")
	  private WebElement custName;
	  
	  @FindBy(id="bulkdisconnectmodal")
	  private WebElement bulkbtn;
	  
	  @FindBy(xpath="//input[@type='file']")
	  private WebElement fileupload;
	  
	  @FindBy(id="upload")
	  private WebElement upload;
	  
	  @FindBy(xpath="//div[@id='bulkdisconnect']//label[2]")
	  private WebElement uploadmsg;
	  
	  @FindBy(id="close")
	  private WebElement clickclosebtn;
	  
	  @FindBy(xpath="//div[@id='bulkdisconnect']//p[1]")
	  private WebElement otherError;
	  
	  @FindBy(xpath="//div[@id='bulkdisconnect']//p[2]")
	  private WebElement afterbulkupload;
	  
	  @FindBy(xpath="//button[@class='btn btn-default' and contains(text(),'Close')]")
	  private WebElement finalClosebutton;
	  
	  
	  private String bilkFilepath=System.getProperty("user.dir")+"/ExcelPages/bulkdisconnecttemplate (1).csv";

	  private String DataPath=System.getProperty("user.dir")+"/ExcelPages/TestData.xlsx";
	  
	  
	  private String element="//div[@class='alert alert-danger top-error text-center' and text()='	Get Customer Failed']";
	  
	  
	  
	  
	  
	  public void disconnectPlan_Bulk() throws InterruptedException, IOException {
		  waitTillElementIsVisible(bulkbtn);
		  bulkbtn.click();
		  fileupload.sendKeys(bilkFilepath);
		  logger.info("File has been uploaded");
		  waitTillElementIsVisible(upload);
		  upload.click();
		  logger.info("clicked on upload button");
		  waitTillElementIsVisible(uploadmsg);
		  logger.info("after uploading the file: "+uploadmsg.getText());
		  if (uploadmsg.getText().contentEquals("Upload success")){
			  logger.info("Bulk Data Has been Uploaded Successfully");
			  
			  if(otherError.isDisplayed()) {
				  waitTillElementIsVisible(otherError);
				  logger.info("Error message="+otherError.getText());
				  
			  }
			  else {
				  
				  waitTillElementIsVisible(afterbulkupload);
					System.out.println(afterbulkupload.getText());
					logger.info(afterbulkupload.getText());
				  
			  }
		  }else {
			  waitTillElementIsVisible(uploadmsg);
				System.out.println("There is something wrong in the Excel " + uploadmsg.getText());
				logger.info("There is something wrong in the Excel " + uploadmsg.getText());
				
		  }
		  
		  waitTillElementIsVisible(finalClosebutton);
			finalClosebutton.click();
			log.info("click on close button");

	  }
	//------------------------Singal Disconnect plane star from here------------------------------------
			public void singalDisconnect() throws InterruptedException {
				
			Thread.sleep(5000);
			waitTillElementIsVisible(enterCustomerSerialNumber);
			long custID=DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 2, DataPath);
			String custIDString=String.valueOf(custID);
			enterCustomerSerialNumber.sendKeys(custIDString);
			logger.info("user entered "+custIDString+" for singal disconnection");
			waitTillElementIsVisible(clickToSearchCustomer);
			clickToSearchCustomer.click();
			logger.info("user clicked to Go button");
			
			
			boolean status=Property.IsTestElementPresent(driver, element);
			System.out.println(status);
			
			
			
			
			//problem is here ndeed to be check
			//if(invalidCust.isEnabled())
			if(status==true) {
				logger.info("user entered the wrong customerID");
				//waitTillElementIsVisible(errorMessage);
				logger.info("error message="+errorMessage.getText());
			}
			else if(custName.isDisplayed()){
				logger.info("user entered the correct customerID");
				logger.info("customer name-"+custName.getText());
				
				if(checkBox.isEnabled()) {
					checkBox.click();
					clickToConfirmSelect.click();
					waitTillElementIsVisible(packageName);
					logger.info("Selected Package Summary's ProductName is " + packageName.getText() + " Contract Id is "
									+ contractId.getText() + " and Expiry Date is On " + expiryDate.getText());
					
					clickToDisconnectThePlan.click();
					
					if (ProductId.isDisplayed()) {
						waitTillElementIsVisible(ProductId);

						System.out.println("Product Id is " + ProductId.getText() + " ProductName is "
								+ productName.getText() + " Status Of The Plan is " + statusOfPlan.getText()
								+ " ErrorMsg is " + error.getText() + " ErrorCode is " + errorCode.getText());
						
						
						log.info("Product Id is " + ProductId.getText() + " ProductName is "
								+ productName.getText() + " Status Of The Plan is " + statusOfPlan.getText()
								+ " ErrorMsg is " + error.getText() + " ErrorCode is " + errorCode.getText());
						
					}
					else {
						WebElement element = driver.findElement(
								By.xpath("//div[@class='alert alert-danger top-error text-center fixed-top']"));
						waitTillElementIsVisible(element);
						System.out.println(element.getText());
					}
				}
				
				
			}
	
	  }
}
