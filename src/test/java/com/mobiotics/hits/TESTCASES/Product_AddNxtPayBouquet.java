package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.AddNxtDegital_AddonsPage.AddNxt_PayBouquet_Page;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class Product_AddNxtPayBouquet extends BaseTest {
	
	
	@Test
	public void addNxt_PayBouquet() throws Exception {
		//preCondition();
		
		AddNxt_PayBouquet_Page homePage=new HomePage().navigateToProductMenu_AddNxtPayBouquet();
		
		homePage.add_nxt_Pay_Bouquet();
		
		//homePage.add_NxtDigital_Addons_Bulk();
		
		
		
	}

}
