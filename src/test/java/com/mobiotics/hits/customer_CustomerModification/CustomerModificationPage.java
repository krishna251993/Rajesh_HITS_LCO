package com.mobiotics.hits.customer_CustomerModification;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.product_Addproduct_AddALCartePage.AddAla_CartePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

public class CustomerModificationPage  extends BasePage{
	
	String message=null;
	
	String path="./ExcelPages/TestData.xlsx";
	
	static final Logger logger = Logger.getLogger(AddAla_CartePage.class);
	
	public CustomerModificationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='input-group pull-left']//input")
	private WebElement enterCustIdOrSerialNum;
	
	@FindBy(xpath="//div[@class='input-group pull-left']//button")
	private WebElement clickOnTOProceed;
	

	@FindBy(id="titleid")
	private WebElement selectTitle;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement customerName;
	
     @FindBy(xpath="//input[@name='surname']")
	 private WebElement customerSurName;
     
     @FindBy(xpath="//input[@name='email']")
     private WebElement customerEmailId;
     
     @FindBy(xpath="//input[@name='mobileno']")
     private WebElement customerMobieNumber;
     
     @FindBy(xpath="//input[@name='address1']")
     private WebElement customerAddress1;
     
     @FindBy(xpath="//input[@name='address2']")
     private WebElement customerAddress2;
     
     @FindBy(xpath="//input[@type='submit']")
     private WebElement clickToSubmitTheForm;
     
     @FindBy(xpath="/html/body/div[1]")
     private WebElement alertMsg;

     
     //when user will enter wrong customerID then a pop-Up will generate
     @FindBy(xpath="/html/body/div[1]")
     //@FindBy(xpath="//div[@class='alert alert-danger top-error text-center' and contains(text(),'Invalid Customer Id/Serial no')]")
     private WebElement invalidData;
     
     @FindBy(xpath="//div[@class='alert alert-danger top-error text-center' and contains(text(),'No KYC Document Found')]")
     private WebElement kycNotify;
     
     public void modifyCustomer() throws InterruptedException {
    	 int lastRow=DemoExcelLibrary3.getlastrow("modify customer", path);
    	 for(int i=1;i<=lastRow;i++) {
    		 long custID=DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 0, path);
    		 String custIDString=String.valueOf(custID);
    		 waitTillElementIsVisible(enterCustIdOrSerialNum);
    		 enterCustIdOrSerialNum.sendKeys(custIDString);
    		 waitTillElementIsVisible(clickOnTOProceed);
 			clickOnTOProceed.click();
 			waitTillElementIsVisible(invalidData);
 			if(invalidData.isDisplayed()==true) {
 				message = invalidData.getText();
 				Thread.sleep(10000);
 				log.info("before if");
 			}
 			
 			System.out.println(message);
    		 
			if (message.contentEquals("Invalid Customer Id/Serial no\r\n")) {
				log.info("inside 1st if");
				waitTillElementIsVisible(enterCustIdOrSerialNum);
				enterCustIdOrSerialNum.sendKeys(Keys.SHIFT);
				enterCustIdOrSerialNum.sendKeys(Keys.ALT);
				enterCustIdOrSerialNum.clear();
				continue;
			}
			
			else {
				//waitTillElementIsVisible(kycNotify);;
				updateFunc();
			}
			
			break;
    	 }
     }
     
     
     public void updateFunc() throws InterruptedException {
    	 waitTillElementIsVisible(selectTitle);
  	   
  	   Select select = new Select(selectTitle);
  	   select.selectByVisibleText("Mr.");
  	   logger.info("user selected the Title");
  	   
  	   customerName.clear();
  	   customerName.sendKeys("Rakesh");
  	   logger.info("User entered the first name");
  	   
  	   customerSurName.clear();
  	   customerSurName.sendKeys("Kumar");
  	   logger.info("user enters last name");
  	   
  	   customerEmailId.clear();
  	   customerEmailId.sendKeys("rakesh.kumar@gmail.com");
  	   logger.info("user enters the mailID");
  	   
  	   customerMobieNumber.clear();
  	   customerMobieNumber.sendKeys("9038932749");
  	   logger.info("user enters mobile Number");
  	   
  	   customerAddress1.clear();
  	   customerAddress1.sendKeys("Hsr lyt");
  	 logger.info("Users enters Address line1");
  	   
  	   customerAddress2.clear();
  	   customerAddress2.sendKeys("Sector 2");
  	 logger.info("User enters the Address line-2");
  	   
  	   
  	   clickToSubmitTheForm.click();
  	   logger.info("users clicked submit button");
  	   Thread.sleep(2000);
  	   
  	   waitTillElementIsVisible(alertMsg);
  	   String msg = alertMsg.getText();
  	   logger.info("aler message "+msg);
  	   System.out.println(msg);
  	   
  	  
     }
}
