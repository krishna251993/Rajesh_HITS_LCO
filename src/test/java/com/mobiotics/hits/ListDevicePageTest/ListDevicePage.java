package com.mobiotics.hits.ListDevicePageTest;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

import generic.DateHelper;



public class ListDevicePage extends BasePage {
	
	
	public ListDevicePage() {
			PageFactory.initElements(driver, this);
		}
	
	static final Logger logger = Logger.getLogger(ListDevicePage.class);

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement deviceDownLoad;
	
	
	
	@FindBy(xpath = "//form[@id='customeridsearch']//input")
	private WebElement searchByCustomerID;
	
	@FindBy(xpath = "//form[@id='customeridsearch']//button")
	private WebElement clickOnGOCustomerID;
	
	@FindBy(name = "deviceid")
	private WebElement searchByDeviceID;
	
	@FindBy(xpath="//form[@id='deviceidsearch']//button")
	private WebElement clickToSearchByDeviceID;
	
	@FindBy(xpath = "//td[.='No Data Found']")
	private WebElement noData;
	
	@FindBy(id="refresh")
	private WebElement clickToSearchByDate;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody//td[5]")
	private List<WebElement> elePresent;
	
	
	
	public void downLoadListDeviceByCustID() {
		
		String Datapath ="./ExcelPages/TestData.xlsx";
		long custIDNum = DemoExcelLibrary3.getexcelDatanumber("modify customer", 1, 7, Datapath);
		String CustID=String.valueOf(custIDNum);
		
		if(noData.getText().equals("No Data Found"))
		{
			waitTillElementIsVisible(deviceDownLoad);
			deviceDownLoad.click();
			
		}
		
		else {
			searchByCustomerID.sendKeys(CustID);
			clickOnGOCustomerID.click();
		}	
		
	}
	
	public void downloadDeviceListByDeviceID() {
		
	}
	
	public void downloadDeviceListByDate() {
		
		if(noData.getText().equals("No Data Found"))
		{
			DateHelper datePicker = new DateHelper();

			datePicker.selectMonth("April");
			datePicker.selectDate("1");
			clickToSearchByDate.click();
			waitTillElementIsVisible(deviceDownLoad);
			deviceDownLoad.click();

		}
		
		else {
			
			deviceDownLoad.click();
			
		}
		
	}

			}
	
	
	

