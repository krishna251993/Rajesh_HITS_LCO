package com.mobiotics.hits.paymentmenu_PayForBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mobiotics.hits.commonpages.BasePage;

import generic.DateHelper;

public class PayForBox extends BasePage{
	
	public PayForBox() {
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(id="boxtype")
	private WebElement selectboxType;
	
	@FindBy(id="status")
	private WebElement selectstatus;
	
	@FindBy(id="model")
	private WebElement searchByModel;
	
	@FindBy(xpath="//button[@type='submit' and contains(text(), 'Go')]")
	private WebElement GoBtn;
	
	@FindBy(xpath="//button[@id='refresh']")
	private WebElement clickToSearchByDate;
	
	@FindBy(id="payfoboxpaymentbtn")
	private WebElement payForBoxBtn;
	
	@FindBy(id="boxtypeselect")
	private WebElement selectBoxType;
	
	@FindBy(id="modelinput")
	private WebElement modalInput;
	
	@FindBy(id="quantity")
	private WebElement quantity;
	
	@FindBy(id="amount")
	private WebElement amount;
	
	@FindBy(id="comment")
	private WebElement comment;
	
	@FindBy(id="submit")
	private WebElement submit;
	
	 public void SelectByValue(WebElement element, String value)
	   {
		   Select select = new Select(element);
		   select.selectByVisibleText(value);
	   }
	 
	 public void goToPayForBoxReport() {
		 
		 
		 SelectByValue(selectboxType, "SD");
		 SelectByValue(selectstatus, "PAID");
		 
		 DateHelper date= new DateHelper();
		 date.selectMonth("March");
		 date.selectDate("1");
		 clickToSearchByDate.click();
		 
		 List<WebElement> list = driver.findElements(By.xpath("//div[@class='paymentlist table-responsive']//tbody//td[1]"));
		 if(list.size()!=0){
			 waitTillElementIsVisible(payForBoxBtn);
			 payForBoxBtn.click();
			 
			 
			   waitTillElementIsVisible(selectBoxType);
			   SelectByValue(selectBoxType, "HD");//need to be check
			   
			   waitTillElementIsVisible(modalInput);
			   modalInput.sendKeys("abcd");
			   
			   waitTillElementIsVisible(quantity);
			   quantity.sendKeys("1");
			   
			   waitTillElementIsVisible(comment);
			   comment.sendKeys("Hello");
			   
			   submit.click();
			   
			   
			   
			   
			   
		 }
		 
		
		 
	 }
	
}
