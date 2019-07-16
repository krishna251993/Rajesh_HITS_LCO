package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.Device_RetrackActiveDevicePage.RetrackActiveDevicePage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class Device_RetrackActiveDevicePageTest extends BaseTest {

	RetrackActiveDevicePage homePage;
	@Test(priority=1)
	
	public void testDevice_RetrackActiveDevicePageTest() throws Exception {
		//preCondition();
		homePage= new HomePage().navigateToDeviceMenu_RetrackActiveDevicePage();
		homePage.retrackActiveService();
		
	}
	
	@Test(priority=2)
	public void testDevice_RetrackActiveDevicePageTestInBulk() {
		homePage.Retrack_ActiveDevice_Bulk();
	}
}
