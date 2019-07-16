package com.mobiotics.hits.Customer_SubscriberCornerPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;

import com.mobiotics.hits.utilities.DemoExcelLibrary3;

import junit.framework.Assert;

public class SubscriberCornerPage extends BasePage {

	
	String path="./ExcelPages/TestData.xlsx";
	
	public SubscriberCornerPage() {
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(SubscriberCornerPage.class);
	
	@FindBy(xpath="/html/body/div[3]/row/div[1]/h1")
	private WebElement subscriberPageTitle;
	
	@FindBy(name = "Customer Id")
	private WebElement enterCustID;
	
	@FindBy(id = "customerIdBtn")
	private WebElement clickButton;
	
	@FindBy(xpath = "/html/body/div[1]")
	private WebElement invalidErrorMsg;
	
	public boolean checkerrorMsg() {
		
		waitTillElementIsVisible(invalidErrorMsg);
		System.out.println(invalidErrorMsg.isEnabled());
		return invalidErrorMsg.isEnabled();
		
		
	}
	
	public void getSubscriberStatus() throws InterruptedException {
		
		if(subscriberPageTitle.getText().equals("Subscriber Corner")) {
			Assert.assertTrue(true);
			
			long customerID=DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 0, path);
			String CustIDString=String.valueOf(customerID);
			enterCustID.sendKeys(CustIDString);
			waitTillElementIsVisible(clickButton);
			clickButton.click();
			Thread.sleep(9000);
			if(checkerrorMsg()==true) {
				log.info("valid customer ID");
				System.out.println("It's a In valid customer ID");
			}
			
			else {
				log.info("It's a valid Customer ID");
				System.out.println("It's invalid Customer ID");
			}
			
		}
		
	}
}
