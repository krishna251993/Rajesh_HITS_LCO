package com.mobiotics.hits.product_Addproduct_AddALCartePage;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

import generic.Utility;

public class AddAla_CartePage extends BasePage {
	
	static final Logger logger = Logger.getLogger(AddAla_CartePage.class);
	public AddAla_CartePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "customerid")
	private WebElement enterCustomerIdToSearch;
	
	@FindBy(id = "customerid")
	private WebElement clickToSearchCustomer;
	
	@FindBy(name = "productlist")
	private List<WebElement> checkBoxesToAddaddOnsPack;
	
	@FindBy(id = "confirm-subscribe")
	private WebElement clickOnConfirmButtonToAddaddOnsPack;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[2]")
	private WebElement priceOfThePlan;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[3]")
	private WebElement expiryDateOfThePlan;
	
	@FindBy(id = "confirmcart")
	private WebElement clickToAddaddOnsPack;
	
	@FindBy(id = "bulkaddonsmodal")
	private WebElement clickonbullkbutton;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement choosefiletoUpload;
	
	@FindBy(id = "upload")
	private WebElement uploadButton;
	
	@FindBy(xpath = "//div[@id='bulkaddons']//label[2]")
	private WebElement uploadsuccess;
	
	@FindBy(xpath = "//div[@id='bulkaddons']//p[1]")
	private WebElement otherError;
	
	@FindBy(xpath = "//div[@id='bulkaddons']//p[2]")
	private WebElement successErrorfinal;
	
	@FindBy(id = "submit")
	private WebElement submitButton;
	
	@FindBy(id = "close")
	private WebElement closeButton; 
	
	@FindBy(id = "customerName")
	private WebElement custName;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[1]")
	private WebElement productName;
	
	@FindBy(xpath = "//tbody[@id='plan_status']//td[3]")
	private WebElement statusOfThePlan;
	
	@FindBy(xpath = "//td[@colspan='5']")
	private WebElement wallet;
	
	@FindBy(xpath = "//tbody[@id='plan_status']//td[1]")
	private WebElement productId;
	
	@FindBy(xpath = "//tbody[@id='plan_status']//td[4]")
	private WebElement errorMsg;
	
	@FindBy(xpath = "//tbody[@id='plan_status']//td[5]")
	private WebElement errorCodeForTheFailure;
	
	//To check the Random Radio Button
	
	private String xp1 = "(//input[@name='productlist'])[";

	private String xp2 = "]";
	
	public void ranXpath(int num) {
		driver.findElement(By.xpath(xp1 + num + xp2)).click();
	}
	
	public int countNoOfAllAcartePresent() {
		return checkBoxesToAddaddOnsPack.size();
	}
	
	private String dataPath="./ExcelPages/TestData.xlsx";
	
	public void Add_AlaCartePage_inBulk() throws InterruptedException {
		waitTillElementIsVisible(clickonbullkbutton);
		clickonbullkbutton.click();
		logger.info("I have clicked on bulk Button");
		
		choosefiletoUpload.sendKeys(System.getProperty("user.dir")+"/ExcelPages/bulkaddproducttemplateFor_Ala_Carte.csv");
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
			waitTillElementIsVisible(submitButton);
			//Thread.sleep(5000);
			submitButton.click();
			logger.info("clicked on submit button");
			
			if (otherError.isDisplayed()) {
				logger.info("other error is  present please verify manualy");
				waitTillElementIsVisible(otherError);
				System.out.println(otherError.getText());
				
				logger.warn(otherError.getText());
				
			}
			
			else if (successErrorfinal.isDisplayed()) {
				logger.info("Success Msg");
				waitTillElementIsVisible(successErrorfinal);
				logger.info(successErrorfinal.getText());
				System.out.println(successErrorfinal.getText());
			}
			
		}
		
		waitTillElementIsVisible(closeButton);
		closeButton.click();
		
	}
		
// ---------------------single add addon's starts from here-----------------------

	public void addAlaCarte_packinSingal() {
		
		logger.info("clicked again");
		waitTillElementIsVisible(enterCustomerIdToSearch);
		
		long custID=DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 1, dataPath);
		String custIdString=String.valueOf(custID);
		enterCustomerIdToSearch.sendKeys(custIdString);
		
		logger.info("user inter the "+custIdString+" To add Al-A Carte");
		waitTillElementIsVisible(clickToSearchCustomer);
		clickToSearchCustomer.click();
		
		logger.info("user clicked on Go Btn");
		
		if(clickOnConfirmButtonToAddaddOnsPack.isEnabled()==true) {
			waitTillElementIsVisible(clickOnConfirmButtonToAddaddOnsPack);
			clickOnConfirmButtonToAddaddOnsPack.click();
			logger.info("User Click on the confirm button");
			
		}
		
		
		else {
			waitTillElementIsVisible(custName);
			System.out.println(custName.getText());
			logger.info("Customer Name-->"+custName);
			logger.info("Number of ALL A- carte is available="+countNoOfAllAcartePresent());
			System.out.println(Utility.getRandomNumber(1, countNoOfAllAcartePresent()));
			ranXpath(Utility.getRandomNumber(1, countNoOfAllAcartePresent()));
			waitTillElementIsVisible(clickOnConfirmButtonToAddaddOnsPack);
			
			clickOnConfirmButtonToAddaddOnsPack.click();
			logger.info("User Click on the confirm button");
			waitTillElementIsVisible(productName);
			
			System.out.println(" Product Name is " + productName.getText() + " Price Of The Plan "
					+ priceOfThePlan.getText() + " Expiry Date Is On " + expiryDateOfThePlan.getText());
			
			logger.info(" Product Name is " + productName.getText() + " Price Of The Plan "
					+ priceOfThePlan.getText() + " Expiry Date Is On " + expiryDateOfThePlan.getText());
			
			
			clickToAddaddOnsPack.click();
			
			
			
			
				

			}
			
			
			
			
			
		}
		
		
	}
