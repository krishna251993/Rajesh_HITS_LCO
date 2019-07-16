package com.mobiotics.hits.customer_ListCustomer;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mobiotics.hits.commonpages.BasePage;


import generic.DateHelper;



public class ListCustomerPage extends BasePage {
	int size=0;
	
	static final Logger logger = Logger.getLogger(ListCustomerPage.class);

	public ListCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="/html/body/div[3]/div[1]/div[1]/h1")
	private WebElement customerList;
	
	 @FindBy(xpath="//form[@id='customeridsearch']//button")
	   private WebElement clickToSearchByCustId;
	   
	   @FindBy(xpath="//form[@id='firstnamesearch']/input")
	   private WebElement searchByFirstName;
	   
	   @FindBy(xpath="//form[@id='firstnamesearch']/button")
	   private WebElement clickToSearchByFirstName;
	   
	   @FindBy(xpath="//form[@id='mobilenosearch']/input ")
	   private WebElement searchByMobileNumber;
	   
	   @FindBy(xpath="//form[@id='mobilenosearch']/button")
	   private WebElement clickToSearchByPhoneNumber;
	   
	   @FindBy(xpath="//form[@id='deviceserialnosearch']/input")
	   private WebElement searchByDeviceSerialNum;
	   
	   @FindBy(xpath="//form[@id='deviceserialnosearch']/button")
	   private WebElement clickToSearchByDeviceSerialNum;
	   
	   @FindBy(xpath="//select[@id='customerstatus']")
	   private WebElement selectByCustomerStatus;
	   
	   @FindBy(xpath="//select[@id='kycstatus']")
	   private WebElement selectByKycStatus;
	   
	   @FindBy(xpath="//button[@id='refresh']")
	   private WebElement clickToSearchByDates;
	   
	   @FindBy(xpath="html/body/div[2]/div[1]/div[2]/button[1]")
	   private WebElement clickForCustomerDownLoad;
	   
	   @FindBy(xpath="html/body/div[2]/div[1]/div[2]/button[2]")
	   private WebElement clickForActivationDownLoad;
	   
	   @FindBy(xpath="//button[@id='activationsButton']")
	   private WebElement clickOnActivations;
	   
	   String pending1="/html/body/div[3]/div[4]/div/table/tbody/tr[";
	   String pending2="]/td[8]";
	   
	   
	   
	   @FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tr//td[7]")
	   private WebElement statusOfPlans;
	   
	   @FindBy(xpath="//form[@id='download']//button")
	   private WebElement customerDownloadConfirmation;
	   
	   @FindBy(xpath="//div[@class='col-lg-12 col-sm-12 col-xs-12 col-md-12']//tr//td[1]")
	   private WebElement contractId;

	   public void getNumberOfCustList() {
		   List<WebElement> allElement=driver.findElements(By.xpath("/html/body/div[3]/div[4]/div/table/tbody//tr"));
		   this.size= allElement.size();
	   }
	   
	   public void getStatusOfPlane() {
		   getNumberOfCustList();
		   for (int i = 0; i < size; i++) {
			   String status=driver.findElement(By.xpath(pending1+i+pending2)).getText();
			   log.info(i+" Status= "+status);   
		}
	   }
	   
	   public void selectValue(WebElement element, String value)
	   {
		   Select selectValue = new Select(element);
		   selectValue.selectByVisibleText(value);
	   }
	   
	   
	   public void getListOfCustomer() throws InterruptedException {
		   DateHelper datePicker = new DateHelper();
		   selectValue(selectByCustomerStatus, "PENDING");
		   logger.info("user Sellected the pending status");
		   selectValue(selectByKycStatus, "VERIFIED");
		   selectValue(selectByKycStatus, "ALL");
		   datePicker.selectMonth("April");
		   datePicker.selectDate("1");
		   logger.info("üser selected the Date");
		   
		   waitTillElementIsVisible(clickToSearchByDates);
		   clickToSearchByDates.click();
		   
		   
		   
		   List<WebElement> list = driver.findElements(By.xpath("//button[@id='activationsButton']"));
		   
			Thread.sleep(3000);

			System.out.println(list.size());
			if (list.size() != 0) {
				System.out.println(list);
				log.info("enter if loop");
				for (WebElement ele : list) {
					logger.info("enter for loop");
					Thread.sleep(3000);
					ele.click();

					log.info("I clicked");
					// clickOnActivations.click();
					waitTillElementIsVisible(contractId);
					Thread.sleep(2000);
					String activationContractId = contractId.getText();
					String activationStatusOfPlan = statusOfPlans.getText();
					System.out.println("Product Activations Contract Id " + activationContractId
							+ " and the Ststus of the plans are " + activationStatusOfPlan);
					driver.findElement(By.id("close")).click();

					waitTillElementIsVisible(clickForCustomerDownLoad);
					Thread.sleep(2000);
					clickForCustomerDownLoad.click();
					waitTillElementIsVisible(customerDownloadConfirmation);
					customerDownloadConfirmation.click();
					Thread.sleep(2000);
					waitTillElementIsVisible(clickForActivationDownLoad);
					clickForActivationDownLoad.click();
					Thread.sleep(2000);
					customerDownloadConfirmation.click();
					Thread.sleep(2000);
				}
	   }
			
			else {
				String string = driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//td")).getText();
				logger.info(string);
			}
			
	   

	   }
	   
}
