package com.mobiotics.hits.product_CancelPeroduct;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

import generic.Property;
import generic.Utility;

public class CancelProductTestPage extends BasePage{
	
	static final Logger logger=Logger.getLogger(CancelProductTestPage.class);
	
	public CancelProductTestPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "customerid")
	private WebElement enterCustomerIdToSearch;
	
	@FindBy(id = "customerid")
	private WebElement clickToSearchCustomer;
	
	@FindBy(name = "productlist")
	private List<WebElement> checkBoxesToCancelProduct;
	
	@FindBy(id = "confirm-subscribe")
	private WebElement clickOnConfirmButtonToCancleProduct;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[1]")
	private WebElement productName;

	@FindBy(xpath = "//tbody[@class='cart-table']//td[2]")
	private WebElement contractID;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[3]")
	private WebElement expiryDate;
	
	@FindBy(id = "confirmcart")
	private WebElement clickToCancleProduct;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div[4]/div/table/tbody/tr/td[1]")
	private WebElement productID;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div[4]/div/table/tbody/tr/td[3]")
	private WebElement statusOfPlan;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div[4]/div/table/tbody/tr/td[4]")
	private WebElement error;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div[4]/div/table/tbody/tr/td[5]")
	private WebElement errorCode;
	
	@FindBy(id = "bulkdisconnectmodal")
	private WebElement clickonBulkButton;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement choosefiletoUpload;
	
	@FindBy(id = "upload")
	private WebElement uploadButton;
	
	@FindBy(xpath = "//label[@class='upload-status text-success']")
	private WebElement uploadsuccess;
	
	
	@FindBy(xpath="//p[@class='success text-success']")
	private WebElement requestMsg ;
	
	@FindBy(xpath="(//button[@class='btn btn-default'])[2]")
	private WebElement closeBtn;
	
	@FindBy(id = "customerName")
	private WebElement custName;
	
	
	@FindBy(xpath="//input[@name='productlist']")
	private List<WebElement> cancelProductsCheckBoxes;
	
	private String xp1="(//input[@name='productlist'])[";
	
	private String xp2="]";
	
	public void ranXpath(int num) {
		driver.findElement(By.xpath(xp1 + num + xp2)).click();
	}
	
	public int countNoOfProductsAvailableToCancle() {
		return cancelProductsCheckBoxes.size();
	}
	
	private String dataPath="./ExcelPages/TestData.xlsx";
	
	private String bulkCancelProductFile= System.getProperty("user.dir")+"/ExcelPages/bulkcanceltemplate.csv";
	
	public void cancelProductInBulk() throws InterruptedException {
		
		
		waitTillElementIsVisible(clickonBulkButton);
		clickonBulkButton.click();
		
		logger.info("I have clicked on bulk Button");
		//Property.action_Move_To_Element(driver, choosefiletoUpload);
		//waitTillElementIsVisible(choosefiletoUpload);
		Thread.sleep(5000);
		
		choosefiletoUpload.sendKeys(bulkCancelProductFile);
		
		logger.info("I have uploded the Bulk file");
		waitTillElementIsVisible(uploadButton);
		uploadButton.click();
		
		Thread.sleep(2000);
		
		logger.info("about to click on the submit button");
		waitTillElementIsVisible(uploadsuccess);
		logger.info(uploadsuccess.getText());
		System.out.println(uploadsuccess.getText());
		
		Thread.sleep(2000);
		
		if (uploadsuccess.getText().contentEquals("Upload success"))
		{
			
			waitTillElementIsVisible(requestMsg);
			
			logger.info(requestMsg.getText());
		}
		waitTillElementIsVisible(closeBtn);
		
		closeBtn.click();
	}
	
	
	//-------------------------------------Singal cancel the product----------------------------
	
	
	public void cancelProductSingle() {
		logger.info("clicked again");
		waitTillElementIsVisible(enterCustomerIdToSearch);
		long custID=DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 13, dataPath);
		String custIdString=String.valueOf(custID);
		
        enterCustomerIdToSearch.sendKeys(custIdString);
		
		logger.info("user inter the "+custIdString+" To add Al-A Carte");
		
		
		waitTillElementIsVisible(clickToSearchCustomer);
		clickToSearchCustomer.click();
		
		logger.info("user clicked on Go Btn");
		
		if(clickOnConfirmButtonToCancleProduct.isEnabled()) {
			waitTillElementIsVisible(clickOnConfirmButtonToCancleProduct);
			clickOnConfirmButtonToCancleProduct.click();
			logger.info("User Click on the confirm button");
			
		}
		
		else {
			waitTillElementIsVisible(custName);
			System.out.println(custName.getText());
			logger.info("Customer Name-->"+custName);
			
			logger.info("Number of product are available to cancel="+countNoOfProductsAvailableToCancle());
			
			System.out.println(Utility.getRandomNumber(1, countNoOfProductsAvailableToCancle()));
			
			ranXpath(Utility.getRandomNumber(1, countNoOfProductsAvailableToCancle()));
			waitTillElementIsVisible(clickOnConfirmButtonToCancleProduct);
			
			clickOnConfirmButtonToCancleProduct.click();
			
			logger.info("User Click on the confirm button");
			waitTillElementIsVisible(productName);
			
			System.out.println(" Product Name is " + productName.getText() + " Price Of The Plan "
					 + " Expiry Date Is On " + expiryDate.getText());
			
			logger.info(" Product Name is " + productName.getText() + " Price Of The Plan "
					 + " Expiry Date Is On " + expiryDate.getText());
			
		
			
			waitTillElementIsVisible(clickToCancleProduct);
			
			clickToCancleProduct.click();
			
		}
		
		
	}
	
	
	
	
	
	
	
}
