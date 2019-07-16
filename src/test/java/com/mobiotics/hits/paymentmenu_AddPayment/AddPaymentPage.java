package com.mobiotics.hits.paymentmenu_AddPayment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.hits.commonpages.BasePage;

public class AddPaymentPage extends BasePage{
	


	public AddPaymentPage()  {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='pull-leftinput']")
	 private WebElement textIsPresent;
	
	@FindBy(xpath="//input[@class='form-control']")
	 private WebElement enterAmountToPay;
	
	@FindBy(xpath="//button[@type='submit']")
	 private WebElement payButton;
	/*
	public CitrusPaymentPage payment_EnterValues() {
		enterAmountToPay.sendKeys("1");
		payButton.click();
		return new CitrusPaymentPage();
		
	}
	
	*/
	
	@FindBy(id="balance")
	WebElement availableCredit_Bal;
	
	public float getAvailableCreditBal() throws Exception {
		 waitTillElementIsVisible(availableCredit_Bal);
		 String aval_Bal=availableCredit_Bal.getText();
		float balance = Float.valueOf(aval_Bal);
		return balance;
	}
	
	
	
	public PayTMPaymentPage payment_EnterValues() {
		enterAmountToPay.sendKeys("1");
		payButton.click();
		return new PayTMPaymentPage();
	}
}
