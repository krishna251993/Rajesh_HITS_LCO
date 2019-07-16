package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.Device_RetrackDeactiveDevicePage.RetrackDeActiveDevicePage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class ReTrack_DeActivePageTest extends BaseTest {
	
	@Test
	
	public void retrackDeActiveDevice() throws InterruptedException {
		RetrackDeActiveDevicePage homePage=new HomePage().navigateToDeviceMenu_RetrackDeactiveDevivePage();
		
		//homePage.Retrack_DeactiveDevice_Bulk();
		
		homePage.ReTrack_DeActiveDevice_Single();
	}
	
	
	
	
}
