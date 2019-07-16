package com.mobiotics.hits.product_AddProduct_AddBasePackPage;

import java.util.List;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

public class Product_AddProduct_AddBasePackPage extends BasePage{
	
	public Product_AddProduct_AddBasePackPage() {
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(Product_AddProduct_AddBasePackPage.class);
	
	
	@FindBy(xpath="//h1[@class='pull-leftinput']")
	private WebElement basePlaneSubscriptionTittle;
	
	@FindBy(xpath="//input[@name='customerid']")
	private WebElement enterCustomerIdToSearch;
	
	@FindBy(xpath="//button[@id='customerid']")
	private WebElement clickToSearchCustomer;
	
	@FindBy(xpath="(//input[@type='radio' and @name='productlist'])[2]")
	private List<WebElement> radioButtonToActivateBasePack;
	
	@FindBy(xpath="//button[@id='confirm-subscribe']")
	private WebElement clickOnConfirmButtonToActivateBasePack;
	
	
	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//tr[1]//td[1]")
	private WebElement productName;
	
	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//tr[1]//td[2]")
	private WebElement priceOfThePlan;
	
	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//tr[1]//td[3]")
	private WebElement NCFPrice;

	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//tr[1]//td[4]")
	private WebElement Tax;
	
	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//tr[1]//td[5]")
	private WebElement TotalPrice;
	
	@FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//tr[1]//td[6]")
	private WebElement ExpiryDate;
	
	@FindBy(xpath="//button[@id='confirmcart']")
	private WebElement clickToSubscribeBasePack;
	
	@FindBy(xpath="//div[@class='productreport table-responsive']//tbody//tr//td[1]")
	 private WebElement productIdAfterClickingTheConfirm;
	
	@FindBy(xpath="//div[@class='productreport table-responsive']//tbody//tr//td[3]")
	 private WebElement statusOfThePlan;
	
	@FindBy(xpath="//div[@class='productreport table-responsive']//tbody//tr//td[4]")
	private WebElement errorMsg;
	
	@FindBy(xpath="//div[@class='productreport table-responsive']//tbody//tr//td[5]")
	private WebElement errorCodeForTheFailure;
	
	@FindBy(xpath="//div[@class='productsubscription table-responsive']//td")
	private WebElement errorMessage;
	
	@FindBy(xpath=".//*[@id='mypopmessage']/div/div/div/div[2]/p")
	  private WebElement basePackError;
	  
	  @FindBy(xpath=".//*[@id='click-confirm']") 
	  private WebElement closeButton;
	  
	  @FindBy(xpath="//div[@id='mypopmessage']/div/div/div/div[1]/h4")
	  private WebElement errorPop;
	  
	  @FindBy(id="customerName")
	  private WebElement custName;
	  
	  @FindBy(id="bulkaddbasepackmodal")
	  private WebElement bulkbtn;
	    
	  @FindBy(xpath="//input[@type='file']")
	  private WebElement fileupload;

	  @FindBy(id="upload")
	  private WebElement upload;
	  
	  @FindBy(xpath="//div[@id='bulkbasepack']//label[2]")
	  private WebElement uploadmsg;
	  
	  @FindBy(id="submit")
	  private WebElement bulksubmitbtn;
	  
	  @FindBy(xpath="//div[@id='bulkbasepack']//p[1]")
	  private WebElement otherError;
	  
	  @FindBy(xpath="//div[@id='bulkbasepack']//p[2]")
	  private WebElement afterbulkupload;
	  
	  @FindBy(id="close")
	  private WebElement clickclosebtn;
	  
	  private String xp1="(//input[@type='radio'])[";
	  private String xp2="]";
	  
	  private String DataPath=System.getProperty("user.dir")+"/ExcelPages/TestData.xlsx";
	  
	  private String bulkFilePath=System.getProperty("user.dir")+"/ExcelPages/bulkaddproducttemplate.csv";

	  
	  public void ranXpath(int num) {
			driver.findElement(By.xpath(xp1 + num + xp2)).click();
		}
	  
	  public void bulkAddBasePack() {
		  
		  if(basePlaneSubscriptionTittle.getText().contains("Baseplan Subscription")) {
			  Assert.assertTrue(true);
			  waitTillElementIsVisible(bulkbtn);
			  bulkbtn.click();
			  logger.info("user clicked on the bulk add base plane");
			  fileupload.sendKeys(bulkFilePath);
			  logger.info("user uploaded the Bulk file");
			  upload.click();
			  logger.info("user clicked on the upload Btn");
			  waitTillElementIsVisible(uploadmsg);
			  if(uploadmsg.getText().contains("Upload success")) {
				  
				  logger.info("Bulk File uploaded Successfully");
				  if(otherError.isDisplayed()) {
					  logger.info("Some other Errors are present");
					  
					  waitTillElementIsVisible(otherError);
					  logger.info(otherError.getText());
					  clickclosebtn.click();
				  }
			  }
			  
			  else {
				  Assert.assertTrue(false);
				  logger.info("usrer is in the wrong page");
				  
			  }
			  
			  
		  }
		  
	  }
		  
		  
		  //----------------------------------Singal Activation---------------------------------------
		  
		  public void singleAdd_BasePack() {
			  long basePackNo=DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 4, DataPath);
			  String custID=String.valueOf(basePackNo);
			  if(custID.contains(".")) {
				  logger.info("customer Id contains decimal");
				  String s=custID;
				  long lCustId= Double.valueOf(s).longValue();
				  String sCustID=Long.toString(lCustId);
				  waitTillElementIsVisible(enterCustomerIdToSearch);
				  enterCustomerIdToSearch.sendKeys(sCustID);
			  }
			  else {
				  logger.info("customer Id Doesn't contain decimal value");
				  enterCustomerIdToSearch.sendKeys(custID);
			  }
			  waitTillElementIsVisible(clickToSearchCustomer);
			  clickToSearchCustomer.click();
			  logger.info("User clic to GO btn");
			  //due to the server error I Can't able to write the script
			  
			  
			  if(clickOnConfirmButtonToActivateBasePack.isEnabled()) {
				  clickOnConfirmButtonToActivateBasePack.click();
				logger.info("Product Name="+productName.getText()+"Price of plane="+priceOfThePlan.getText()
							+"NCF Price="+NCFPrice.getText()+"Tax="+Tax.getText()+"Total price="+TotalPrice.getText()+" Expiry Date="+ExpiryDate.getText()); 
				waitTillElementIsVisible(clickToSubscribeBasePack);
				//clickToSubscribeBasePack.click();
				logger.info("status of plane subscription="+statusOfThePlan.getText());
				
			  }
			  
			  else
			  {
				  logger.info("Customer Name="+custName.getText());
				  List<WebElement> list = driver.findElements(By.xpath("//input[@name='productlist']"));
					list.size();
					
					if(list.size()>0) {
						ranXpath(1);
						clickOnConfirmButtonToActivateBasePack.click();
						
						waitTillElementIsVisible(productName);
						System.out.println(" Product Name is : " + productName.getText() + " Price Of The Plan : "
								+ priceOfThePlan.getText() + " Expiry Date Is On : "
								+ ExpiryDate.getText());
						
						logger.info("Product Name="+productName.getText()+"Price of plane="+priceOfThePlan.getText()
						+"NCF Price="+NCFPrice.getText()+"Tax="+Tax.getText()+"Total price="+TotalPrice.getText()+" Expiry Date="+ExpiryDate.getText()); 
						
						
						
						waitTillElementIsVisible(clickToSubscribeBasePack);
						clickToSubscribeBasePack.click();
						
						waitTillElementIsVisible(productIdAfterClickingTheConfirm);
						waitTillElementIsVisible(statusOfThePlan);
						waitTillElementIsVisible(errorMsg);
						waitTillElementIsVisible(errorCodeForTheFailure);
						System.out.println("Product Id is : " + productIdAfterClickingTheConfirm.getText()
								+ " Status Of The Plan : " + statusOfThePlan.getText() + " Reason is : "
								+ errorMsg.getText() + " Code is : " + errorCodeForTheFailure.getText());
						
						logger.info("Product Id is : " + productIdAfterClickingTheConfirm.getText()
								+ " Status Of The Plan : " + statusOfThePlan.getText() + " Reason is : "
								+ errorMsg.getText() + " Code is : " + errorCodeForTheFailure.getText());
					}
			  }
			  
		  }
		  
		  
		  
		//This I will develope once i will get all the test data .
		  }
		 
	
	
	 


