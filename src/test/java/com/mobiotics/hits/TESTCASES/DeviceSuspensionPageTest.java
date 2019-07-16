package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.DeviceSuspensionPage.DeviceSuspensionPage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class DeviceSuspensionPageTest extends BaseTest {
	
	
	@Test
	
	public void deviceSuspensionTestMethod() throws InterruptedException {
		
		DeviceSuspensionPage homePage=new HomePage().navigateToSuspensionPage();
		homePage.SuspeensionCustomer("Single");
		//Bulk
		
		//Single
	}
}
