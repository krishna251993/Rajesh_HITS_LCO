package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;
import com.mobiotics.hits.customer_ListCustomer.ListCustomerPage;

public class Customer_ListCustomerPageTest extends BaseTest{
	
	
	@Test
	public void testCustomer3_ListCustomerPAgeTest() throws Exception {
		
		//preCondition();
		ListCustomerPage homePage = new HomePage().navigateToCustomerMenu_ListCustomer();
		  
		  homePage.getListOfCustomer();
	}

			 
}
