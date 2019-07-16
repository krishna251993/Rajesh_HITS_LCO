package com.mobiotics.hits.paymentmenu_AddPayment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mobiotics.hits.commonpages.BasePage;

public class PayTMPaymentPage extends BasePage {
	
	float balance;
	
	public PayTMPaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='dcCardNumber  d text-input large-input cardInput type-tel card-field-selector']")
	WebElement cardNumber;
	
	@FindBy(id="dcExpMonth")
	WebElement expMonth;
	
	@FindBy(id="dcExpYear")
	WebElement expYear;
	
	@FindBy(id="dcCvvBox")
	WebElement cvv;
	
	@FindBy(id="dcSubmit")
	WebElement payNow;
	
	@FindBy(id="OTP")
	WebElement OTP;
	
	@FindBy(name="proceed")
	WebElement Submit;
	
	@FindBy(xpath="(//div[@class=\"container-fluid plan-container plan-box\"]//h3)[1]")
	WebElement txn_Status;
	
	@FindBy(partialLinkText="View Balance")
	WebElement view_balence;
	
	
	
	
	public void clickOnViewBalance() {
		waitTillElementIsVisible(view_balence);
		view_balence.click();
	}
	
	
	public String getTxnStatus() {
		waitTillElementIsVisible(txn_Status);
		return txn_Status.getText();
	}
	public void enterCardNo(String cardno)
	{
		 waitTillElementIsVisible(cardNumber);
		cardNumber.sendKeys(cardno);
	}
	
	public void enterExpMonth(String expMonthString) {
		waitTillElementIsVisible(expMonth);
		Select ssel=new Select(expMonth);
		ssel.selectByValue(expMonthString);
	}
	
	public void enterExpYear(String expYr) {
		
		waitTillElementIsVisible(expYear);
		Select ssel=new Select(expYear);
		ssel.selectByVisibleText(expYr);
		
	}
	
	public void clickOnPayNow() {
		waitTillElementIsVisible(payNow);
		payNow.click();
	}
	
	public void enterCVV(String cvvNo) {

		waitTillElementIsVisible(cvv);
		cvv.sendKeys(cvvNo);
		
	}
	
	public void enterOTP(String otp) {
		
		waitTillElementIsVisible(OTP);
		OTP.sendKeys(otp);
		
		
	}
	
	public void clickOnSubmit() {
		Submit.click();
	}
	
	public String enterCardDetails(String cardNo,String expMonthString,String expYearString,String cvvNoString,String otp) {
		enterCardNo(cardNo);
		enterExpMonth(expMonthString);
		
		enterExpYear(expYearString);
		enterCVV(cvvNoString);
		clickOnPayNow();
		enterOTP(otp);
		
		clickOnSubmit();
		String TxnStatus=getTxnStatus();
		clickOnViewBalance();
		return TxnStatus;
	}
	
	@FindBy(id="balance")
	WebElement availableCredit_Bal;
	
	public float getAvailableCreditBal() throws Exception {
		 waitTillElementIsVisible(availableCredit_Bal);
		 String aval_Bal=availableCredit_Bal.getText();
		float balance = Float.valueOf(aval_Bal);
		return balance;
	}
	
	

}
