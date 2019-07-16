package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.AddNxtDegital_AddonsPage.AddNxt_PayBouquet_Page;
import com.mobiotics.hits.AddNxt_Pay_Bouquets.AddNxtPayBouquet1Page;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class AddNxtPayBouquet1PageTest extends BaseTest{
	
	@Test
	public void addNxtPayBouquet1() throws InterruptedException {
		AddNxtPayBouquet1Page homePage=new HomePage().navigateToProductMenu_AddNxtPayBouquet1();
		homePage.add_nxt_Pay_Bouquet1();
		
	}
	
	
	}


