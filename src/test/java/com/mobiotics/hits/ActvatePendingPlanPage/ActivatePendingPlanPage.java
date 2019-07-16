package com.mobiotics.hits.ActvatePendingPlanPage;

import java.util.List;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.product_Addproduct_AddALCartePage.AddAla_CartePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

public class ActivatePendingPlanPage extends BasePage {

	static final Logger logger = Logger.getLogger(AddAla_CartePage.class);
	 public ActivatePendingPlanPage() 
	   {
		  PageFactory.initElements(driver, this);
	   }
	 @FindBy(xpath="//input[@name='customerid']")
	 private WebElement enterCustomerSerialNumber;  
	 
	 @FindBy(xpath="//button [@id='customerid']")
	 private WebElement clickToSearchCustomer;
	 
	 @FindBy(xpath="/html/body/div[4]/div[1]/div[3]/div/table/tbody/tr[3]/td[11]/input")
	   private WebElement checkBox;
	 
	 @FindBy(xpath="//input[@type='checkbox']")
	 private List<WebElement> checkBoxes;
	 
	 @FindBy(id="confirm-subscribe")
	 private WebElement clickToConfirmSelect;
	 
	 @FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//tr[1]//td[1]")
	 private WebElement packageName; 
	 
	 @FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//tr[1]//td[2]")
	 private WebElement contentPrice; 
	 
	 @FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//tr[1]//td[5]")
	 private WebElement TotalPrice; 
	 
	 @FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//tr[1]//td[6]")
	 private WebElement contractID; 
	 
	 @FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tbody//tr[1]//td[7]")
	 private WebElement expiryDate;
	 
	 
	 @FindBy(xpath="//button[@id='confirmcart']")
	 private WebElement clickToDisconnectThePlan;
	 
	 @FindBy(xpath="//div[@class='productreport table-responsive']//tbody//td[4]")
	   private WebElement error;
	 
	 @FindBy(xpath="//div[@class='productreport table-responsive']//tbody//td[3]")
	   private WebElement status;
	 
	 @FindBy(xpath="//div[@class='productreport table-responsive']//tbody//td[5]")
	   private WebElement errorCode;
	 
	 @FindBy(id="click-confirm")
	   private WebElement errorButton;
	 
	 @FindBy(xpath="//div[@id='mypopmessage']//p")
	   private WebElement errorMsg;
	 
	 public void ranXpath(int num) {
			//driver.findElement(By.xpath(xp1_getPendingPlansDetails + num + xp2_getPendingPlansDetails)).click();
		}
		
		public int countNoOfAllpendingPlans() {
			return checkBoxes.size();
		}
		
		private String dataPath="./ExcelPages/TestData.xlsx";
		
		public void activatePendingPlans_Bulk() {
			
		}
	 
	 public void activateThePendingPlan() throws InterruptedException {
		 waitTillElementIsVisible(enterCustomerSerialNumber);
		long custIDNum= DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 6, dataPath);
		 
		 String custIDString=String.valueOf(custIDNum);
		 
		 enterCustomerSerialNumber.sendKeys(custIDString);
		 waitTillElementIsVisible(clickToSearchCustomer);
		  clickToSearchCustomer.click();
		  
		  
		  if(clickToConfirmSelect.isEnabled())
		  {
			  clickToConfirmSelect.click();
			  logger.info("package Name:-"+packageName.getText());
			  logger.info("content Price:-"+contentPrice.getText());
			  logger.info("Total Price:-"+TotalPrice.getText());
			  logger.info("contract ID:-"+ contractID.getText());
			  logger.info("Expiry Date:-"+ expiryDate.getText());
			 
			  clickToDisconnectThePlan.click();
			  
			  System.out.println( " ProductName is "+ packageName.getText() + 
					  " Status Of The Plan is "+status.getText()+ " ErrorMsg is "+error.getText()+
				    	  " ErrorCode is "+errorCode.getText());
			  logger.info(" ProductName is "+ packageName.getText() + 
					  " Status Of The Plan is "+status.getText()+ " ErrorMsg is "+error.getText()+
				    	  " ErrorCode is "+errorCode.getText());
			  
		  }
		  
		  else
		  {
			 
			   checkBox.click();
			   waitTillElementIsVisible(clickToConfirmSelect);
			   clickToConfirmSelect.click();
			   
			   	  logger.info("package Name:-"+packageName.getText());
				  logger.info("content Price:-"+contentPrice.getText());
				  logger.info("Total Price:-"+TotalPrice.getText());
				  logger.info("contract ID:-"+ contractID.getText());
				  logger.info("Expiry Date:-"+ expiryDate.getText());
				  
				  
				  clickToDisconnectThePlan.click();
				  
				  System.out.println( " ProductName is "+ packageName.getText() + 
						  " Status Of The Plan is "+status.getText()+ " ErrorMsg is "+error.getText()+
					    	  " ErrorCode is "+errorCode.getText());
				  logger.info(" ProductName is "+ packageName.getText() + 
						  " Status Of The Plan is "+status.getText()+ " ErrorMsg is "+error.getText()+
					    	  " ErrorCode is "+errorCode.getText());
		  }
		  
		  
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
