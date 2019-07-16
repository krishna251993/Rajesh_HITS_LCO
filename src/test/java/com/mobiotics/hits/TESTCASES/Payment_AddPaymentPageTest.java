package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;
import com.mobiotics.hits.paymentmenu_AddPayment.AddPaymentPage;
import com.mobiotics.hits.paymentmenu_AddPayment.PayTMPaymentPage;

public class Payment_AddPaymentPageTest extends BaseTest {

	@Test
	public void testPayment_AddPaymentPageTest() throws Exception {
		//preCondition();
		AddPaymentPage home= new HomePage().navigateToPaymentMenu_AddPayment();
		
		
		float beforeAdd_available_Bal=home.getAvailableCreditBal();
		log.info("Before agdding the amount: "+beforeAdd_available_Bal);
		home.payment_EnterValues();
		PayTMPaymentPage paytmpayment_Page=new PayTMPaymentPage();
		String txn_status=paytmpayment_Page.enterCardDetails("5241933238790000", "01", "2020", "123", "123123");
		log.info(txn_status);
		float AfterAdd_available_Bal=home.getAvailableCreditBal();
		log.info("After adding the ammount:"+AfterAdd_available_Bal);
		if(AfterAdd_available_Bal>beforeAdd_available_Bal) {
			log.info("Amount added successfully");
		}
		
		else {
			log.info("Transaction Failed");
		}
		
	}
}
