package com.mobiotics.hits.Report_ListPayments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mobiotics.hits.commonpages.BasePage;

import generic.DateHelper;

public class ListPaymentPage extends BasePage {
	
	public ListPaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="status")
	private WebElement payment_Status;
	
	@FindBy(id="paymentmode")
	private WebElement payment_Mode;
	
	 @FindBy(xpath="//button[@class='btn btn-success pull-right']")
	 private WebElement DownloadPaymentReport;

	 @FindBy(xpath="//button[@id='refresh']")
	 private WebElement clickOnGoButtonForDateSearch;
	   
	 private void selectValue(WebElement element,String value )
	 {
		 Select select = new Select(element);
		 select.selectByVisibleText(value);
	 }
	 
	 public void DownloadListPaymentReport() throws InterruptedException {
		 DateHelper datepicker=new DateHelper();
		 selectValue(payment_Status, "PENDING");
		 Thread.sleep(5000);
		 selectValue(payment_Mode, "ALL");
		 datepicker.selectMonth("April");
		 datepicker.selectDate("1");
		 clickOnGoButtonForDateSearch.click();
		 
		 List<WebElement> list=driver.findElements(By.xpath("//div[@class='paymentlist table-responsive']//tbody//td[1]"));
		 if(list.size()!=0) {
			 waitTillElementIsVisible(clickOnGoButtonForDateSearch);
			 clickOnGoButtonForDateSearch.click();
			 
			 waitTillElementIsVisible(DownloadPaymentReport);
			 DownloadPaymentReport.click();
			 Thread.sleep(4000);
		 }
		 else
		 {
			 String string = driver.findElement(By.xpath("//div[@class='paymentlist table-responsive']//tbody//td")).getText();
			  System.out.println(string);
			  log.info("no plane is available=");
		 }
	 }
}
