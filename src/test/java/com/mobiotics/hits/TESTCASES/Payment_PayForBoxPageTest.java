package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;
import com.mobiotics.hits.paymentmenu_AddPayment.PayTMPaymentPage;
import com.mobiotics.hits.paymentmenu_PayForBox.PayForBox;

public class Payment_PayForBoxPageTest extends BaseTest{
	@Test
	public void testPayment_PayForBox() throws Exception {
		
		//preCondition();
		PayForBox homepage= new HomePage().navigateToPaymentMenu_PayForBoxPage();
		homepage.goToPayForBoxReport();
		
		
		
		PayTMPaymentPage paytmpayment_Page=new PayTMPaymentPage();
		String txn_status=paytmpayment_Page.enterCardDetails("5241933238790000", "01", "2020", "123", "123123");
		log.info(txn_status);
		float Afterpay_available_Bal=paytmpayment_Page.getAvailableCreditBal();
		log.info("After adding the ammount:"+Afterpay_available_Bal);
		
		
		//when Paytm Page get active that time we can enable this
		
		
	}

}
