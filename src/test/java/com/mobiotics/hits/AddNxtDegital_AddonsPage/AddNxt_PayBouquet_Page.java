package com.mobiotics.hits.AddNxtDegital_AddonsPage;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

import generic.Utility;



public class AddNxt_PayBouquet_Page extends BasePage {
	static final Logger logger = Logger.getLogger(AddNxt_PayBouquet_Page.class);

	public AddNxt_PayBouquet_Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='pull-leftinput']")
	WebElement NxtDegital_AddOnsTitle;
	
	@FindBy(name = "customerid")
	private WebElement enterCustomerIdToSearch;
	
	@FindBy(id = "customerid")
	private WebElement clickToSearchCustomer;
	
	@FindBy(xpath="//*[@id=\"addontable\"]/tbody/tr[1]/td[7]/input")
	private WebElement checkBox;
	
	@FindBy(id = "confirm-subscribe")
	private WebElement  clickOnConfirmButtonToAddaddOnsPack;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[2]")
	private WebElement priceOfThePlan;
	
	@FindBy(xpath = "//tbody[@class='cart-table']//td[3]")
	private WebElement tax;
	
	@FindBy(xpath="//tbody[@class='cart-table']//td[4]")
	private WebElement Totalprice;
	
	@FindBy(xpath="//tbody[@class='cart-table']//td[5]")
	private WebElement expiryDate;
	
	
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div[2]/div/table[2]/tbody/div/div/div[2]/div[4]/h4/text()")
	private WebElement totalTax;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div[2]/div/table[2]/tbody/div/div/div[2]/div[2]/h4/text()")
	private WebElement totalPrice;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div[2]/div/table[2]/tbody/div/div/div[2]/div[6]/h3/text()")
	private WebElement payableAmount;
	
	@FindBy(xpath = "//button[@id='confirmcart']")
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
	
	@FindBy(name = "productlist")
	private List<WebElement> checkBoxesToAddaddOnsPack;
	
	@FindBy(xpath = "//td[@colspan='5']")
	private WebElement wallet;
	
	@FindBy(xpath = "//tbody[@id='plan_status']//td[1]")
	private WebElement productId;
	
	@FindBy(xpath = "//tbody[@id='plan_status']//td[4]")
	private WebElement errorMsg;
	
	@FindBy(xpath = "//tbody[@id='plan_status']//td[5]")
	private WebElement errorCodeForTheFailure;
	
	@FindBy(id="pack_selection")
	private WebElement nxtPayBouquetSelect;
	
	
	
	private String xp1 = "(//input[@type='checkbox'])[";

	private String xp2 = "]";
	
	public void selectDropDown(WebElement element, String value) {
		waitTillElementIsVisible(element);
		Select select=new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	public void ranXpath(int num) {
		driver.findElement(By.xpath(xp1 + num + xp2)).click();
	}
	
	public int countNoOfAllAcartePresent() {
		return checkBoxesToAddaddOnsPack.size();
	}
	
	private String dataPath="./ExcelPages/TestData.xlsx";
	
	
	public void add_NxtDigital_Addons_Bulk() throws InterruptedException {
		waitTillElementIsVisible(clickonbullkbutton);
		clickonbullkbutton.click();
		
		logger.info("I have clicked on the bulkButton");
		choosefiletoUpload.sendKeys(System.getProperty("user.dir")+"/ExcelPages/Bulk_Add_NXtAddOns.csv");
		waitTillElementIsVisible(uploadButton);
		uploadButton.click();
		log.info("about to click on the submit button");
		waitTillElementIsVisible(uploadsuccess);
		log.info(uploadsuccess.getText());
		System.out.println(uploadsuccess.getText());
		logger.info(uploadsuccess.getText());
		
		if(uploadsuccess.getText().contains("Upload success")) {
			waitTillElementIsVisible(submitButton);
			logger.info("user is supposed to click on the submit button");
			
			if(otherError.isDisplayed()) {
				logger.info("other error is  present please verify manualy");
				waitTillElementIsVisible(otherError);
				logger.warn("other Error:-"+otherError.getText());
				
			}
			
			
			else if (successErrorfinal.isDisplayed()) {
				logger.info("Success Msg");
				waitTillElementIsVisible(successErrorfinal);
				logger.info(successErrorfinal.getText());
				System.out.println(successErrorfinal.getText());
			}
		}
		
		waitTillElementIsVisible(closeButton);
		
		
		
		
		Thread.sleep(5000);
		closeButton.click();
		
	}
	// the above bulk will run as per the requirement otherwise go withe normal flow
	
	public void add_nxt_Pay_Bouquet() {
		logger.info("--------------------------");
		logger.info("Go with Singal Activation");
		
		waitTillElementIsVisible(enterCustomerIdToSearch);
		long custID=DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 5, dataPath);
		String custIdString=String.valueOf(custID);
		enterCustomerIdToSearch.sendKeys(custIdString);
		
		logger.info("user inter the "+custIdString+" To add NXT Add ons Carte");
		
		waitTillElementIsVisible(clickToSearchCustomer);
		clickToSearchCustomer.click();
		
		logger.info("user clicked on GO Btn");
		selectDropDown(nxtPayBouquetSelect, "Broadcaster Pack");
		
		if(clickOnConfirmButtonToAddaddOnsPack.isEnabled()) {
			waitTillElementIsVisible(clickOnConfirmButtonToAddaddOnsPack);
			clickOnConfirmButtonToAddaddOnsPack.click();
			logger.info("User Click on the confirm button");
			
		}
		
		else {
			waitTillElementIsVisible(custName);
			logger.info("Customer Name:-"+custName.getText());
			logger.info("Number of ALL NxT Pack is available="+countNoOfAllAcartePresent());
			int randomNo=Utility.getRandomNumber(1, countNoOfAllAcartePresent());
			System.out.println(Utility.getRandomNumber(1, countNoOfAllAcartePresent()));
			
			ranXpath(1);
			waitTillElementIsVisible(clickOnConfirmButtonToAddaddOnsPack);
			clickOnConfirmButtonToAddaddOnsPack.click();
			logger.info("User Click on the confirm button");
			//waitTillElementIsVisible(productName);
			//logger.info(" Product Name is " + productName.getText() + " Price Of The Plan "
					//+ priceOfThePlan.getText() );
			
			//String TotalPrice=totalPrice.getText();
			//double totalPriseDouble=Double.valueOf(TotalPrice);
			//double totalTaxDouble=Double.valueOf(totalTax.getText());
			//logger.info("Total Prise="+totalPriseDouble+"Total Tax="+totalTaxDouble);
			
			//waitTillElementIsClickable(clickToAddaddOnsPack);
			
			waitTillElementIsVisible(clickToAddaddOnsPack);
			
			clickToAddaddOnsPack.click();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
