package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.Renew_AfterExpiryPage.AfterExpiryPage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class Renew_AfterExpiryPageTest extends BaseTest {

	
	@Test
	
	public void testRenew_AfterExpiryPageTest() throws Exception {
		//preCondition();
		AfterExpiryPage homePage=new HomePage().navigateToRenewMenu_AfterExpiryPage();
		homePage.RenewTheAfterExpiryInBulk();
		//homePage.singalRenewOfExpiredPlane();
	
	
	}
}
