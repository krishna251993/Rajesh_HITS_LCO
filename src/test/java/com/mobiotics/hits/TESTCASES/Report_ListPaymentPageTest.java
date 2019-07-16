package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.Report_ListPayments.ListPaymentPage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class Report_ListPaymentPageTest extends BaseTest {

	@Test
	public void testPayment_ListPaymentPageTest() throws Exception {
		
		//preCondition();
		ListPaymentPage homePage=new HomePage().navigateToPaymentMenu_ListPayment();
		homePage.DownloadListPaymentReport();
		
		
	}
}
