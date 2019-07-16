package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.OSDPage.OSDMessageServicePage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;


public class OSDMsgServiceTest extends BaseTest {
	
	@Test
	public void testDevice_OSDMessageServicePageTest() throws Exception {
		//preCondition();
		OSDMessageServicePage homePage=new HomePage().navigateToDeviceMenu_OsdMesssageServicePage();
		//homePage.osdMsgService();
		
		homePage.sendOSDSingnalIn_Bulk();
	}

}
