package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;
import com.mobiotics.hits.customer_CustomerModification.CustomerModificationPage;

public class Customer_ModifyCustomerPageTest extends BaseTest {

	@Test
	public void testCustomer_ModifyCustomerPageTest() throws Exception {
		//preCondition();
		CustomerModificationPage homePage=new HomePage().navigateToCustomerMenu_ModifyCustomer();
		
		homePage.modifyCustomer();
	}
}
