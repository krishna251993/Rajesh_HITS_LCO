package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;


import com.mobiotics.hits.Customer_RefundRequestPage.Customer_Refund_RequestPage;
import com.mobiotics.hits.Customer_RefundRequestPage.Customer_Refund_RequestPage_New;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class Customer_RefundFeatureTest extends BaseTest {
	
	@Test
	public void refundFeatureTest() throws Exception {
		//preCondition();
		Customer_Refund_RequestPage_New homePage=new HomePage().navigateTo_refundRequestPage();
		homePage.testRefundRequest();
	}

}
