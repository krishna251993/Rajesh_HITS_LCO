package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.ListDevicePageTest.ListDevicePage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class Device_ListDevicesPageTest extends BaseTest {

	@Test 
	public void ListDevicePageTest() throws Exception {
		//preCondition();
		ListDevicePage homePage=new HomePage().navigateToDeviceMenu_ListDevicePage();
		
		homePage.downloadDeviceListByDate();
	}
}
