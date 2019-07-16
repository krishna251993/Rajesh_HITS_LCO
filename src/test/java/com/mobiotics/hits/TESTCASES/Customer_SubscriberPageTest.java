package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.Customer_SubscriberCornerPage.SubscriberCornerPage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class Customer_SubscriberPageTest  extends BaseTest{
	@Test
	public void subscriberPage_Test() throws Exception {
		//preCondition();
		
		
		SubscriberCornerPage homePage=new HomePage().navigateToCustomerMenu_SubscriberCornerPage();
		homePage.getSubscriberStatus();
	}

}
