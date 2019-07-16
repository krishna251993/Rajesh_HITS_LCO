package com.mobiotics.Product_ReconnectPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.product_ProductDisconnect.ProductDisconnectPage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

import generic.Property;

public class ProductReconnectPage extends BasePage {
	
	static final Logger logger = Logger.getLogger(ProductDisconnectPage.class);

	public ProductReconnectPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='customerid']")
	 private WebElement enterCustomerSerialNum;
	
	@FindBy(xpath="//button [@id='customerid']")
   private WebElement clickToSearchCustomer;
	
	@FindBy(xpath="//input[@name='productlist']")
	private WebElement clickToReconnect;
	//if multiple check boxes are available then we need to do some another implementation
	
	@FindBy(xpath="//div[@class='productsubscription table-responsive']//tbody//td[5]")
	private WebElement checkBox;
	//checkbox
	
	@FindBy(xpath="//button[@id='confirm-subscribe']")
	private WebElement clickOnConfirmButton;
	
	
	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//td[1]")
	private WebElement packageName;
	
	@FindBy(xpath="//div[@class='productreport table-responsive']//tbody//td[1]")
	private WebElement contractID;
	
	@FindBy(xpath="//tbody[@class='cart-table']//tr//td[3]")
	private WebElement expiryDate;
	
	@FindBy(xpath="//button[@id='confirmcart']")
	private WebElement clickToReconnectThePlan;
	
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
	
	@FindBy(id="bulkreconnectmodal")
	private WebElement bulkbtn;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement fileupload;
	
	
	
	
	@FindBy(id="click-confirm")
	  private WebElement errorButton;
	  
	  @FindBy(xpath="//div[@class='alert alert-danger top-error text-center']")
	  private WebElement errorMsg;
	  
	  String errormsg="//div[@class='alert alert-danger top-error text-center']";
	  
	  
	  
	  
	
	
	
	  @FindBy(id="upload")
	  private WebElement upload;
	
	  @FindBy(xpath="//div[@id='bulkreconnect']//label[2]")
	  private WebElement uploadmsg;
	
	  @FindBy(xpath="//div[@id='bulkreconnect']//p[1]")
	  private WebElement otherError;
	
	  @FindBy(xpath="//div[@id='bulkreconnect']//p[2]")
	  private WebElement afterbulkupload;
	
	  @FindBy(id="customerName")
	  private WebElement custName;
	
	  @FindBy(xpath="//button[@class='btn btn-default closeButton' and contains(text(),'Close')]")
	  private WebElement finalClosebutton;
	  
	  private String DataPath=System.getProperty("user.dir")+"/ExcelPages/TestData.xlsx";
	
	  private String bulkfile=System.getProperty("user.dir")+"/ExcelPages/bulkreconnecttemplate.csv";
	  
	  public void reconnectPlane_Bulk() throws InterruptedException {
		  waitTillElementIsVisible(bulkbtn);
		  
		  bulkbtn.click();
		  logger.info("user clicked on the bulk btn");
		  //waitTillElementIsVisible(fileupload);
		  fileupload.sendKeys(bulkfile);
		  logger.info("user entered the bulk file");
		  waitTillElementIsVisible(upload);
		  upload.click();
		  logger.info("after adding the bulk file click on upload btn");
		  waitTillElementIsVisible(uploadmsg);
		  logger.info("after uploading "+uploadmsg.getText());
		  
		  
		  if(uploadmsg.getText().contentEquals("Upload success")) {
			  logger.info("uploading successfully");
			  
			  if(otherError.isDisplayed()) {
				  waitTillElementIsVisible(otherError);
				  logger.info("öther error="+otherError.getText());
			  }
			  else {
				  
				  logger.info("no other error are present");
				  waitTillElementIsVisible(uploadmsg);
				  logger.info(uploadmsg.getText());
				  waitTillElementIsVisible(afterbulkupload);
				  logger.info(afterbulkupload.getText());
				  logger.info("got the success text");
				  
			  }
		  }
			  
			  else {
				  waitTillElementIsVisible(uploadmsg);
				logger.info("There is something wrong in the Excel" + uploadmsg.getText());
			  }
		  
		  waitTillElementIsVisible(finalClosebutton);
		  finalClosebutton.click();
		  logger.info("cloicked on the close button");
	  }
		  
		  //---------------------Singal Reconnect Start-------------------------------
		  
		  
	  public void reconnectPlan_Single() throws InterruptedException {
		  
		  Thread.sleep(5000);
		  
		  waitTillElementIsVisible(enterCustomerSerialNum);
		  long custIDNum=DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 3, DataPath);
		  String custIDString=String.valueOf(custIDNum);
		  enterCustomerSerialNum.sendKeys(custIDString);
		  
		  waitTillElementIsVisible(clickToSearchCustomer);
		  clickToSearchCustomer.click();
		  
		  boolean status=Property.IsTestElementPresent(driver, errormsg);
		  
		  if(status==true) {
			  logger.info("user entered wrong customerID");
			  logger.info("CustomerID entered by the users="+errorMsg.getText());
			
		  }
		  
		  else 
		  {
			 
			 if(checkBox.isEnabled()) {
				 waitTillElementIsVisible(custName);
				 logger.info("customer name="+custName.getText());
				 
				 checkBox.click();
				 
				 waitTillElementIsVisible(clickOnConfirmButton);
				 
				 clickOnConfirmButton.click();
				 
                waitTillElementIsVisible(clickToReconnectThePlan);
				 
				 clickToReconnectThePlan.click();
				 
				 logger.info("Product Details To Re-connect-"+packageName.getText()+" "+contractID.getText()+" "+expiryDate.getText());
				 
				 				 
				 
				 
			 }
		  }
		  
		  
		  
		  
		  
		  
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
