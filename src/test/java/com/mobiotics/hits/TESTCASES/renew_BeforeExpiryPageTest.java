package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.BeforeExpiryPageTest.BeforeExpiryPage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class renew_BeforeExpiryPageTest extends BaseTest{
	@Test
	public void renewExpired_Product() throws InterruptedException {
		BeforeExpiryPage homePage=new HomePage().navigateToRenewMenu_BeforeExpiryPage();
		
		homePage.renewBeforeExpiryIn_Bulk();
		
		//homePage.singleRenewActiveProduct();
	}
}
