package com.mobiotics.hits.TESTCASES;


import org.testng.annotations.Test;

import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;
import com.mobiotics.hits.product_ProductDisconnect.ProductDisconnectPage;

public class Product_ProductDisconnectPageTest extends BaseTest {

	@Test
	public void product_ProductDisconnectPageTest() throws Exception {
		//preCondition();
		ProductDisconnectPage homePage=new HomePage().navigateToProductMenu_ProductDisconnectPage();
		homePage.disconnectPlan_Bulk();
		//homePage.singalDisconnect();
	}
}
