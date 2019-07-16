package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.Product_ReconnectPage.ProductReconnectPage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class Product_ProductReconnectPageTest extends BaseTest{

	@Test
	public void testProduct_productReconnectPageTest() throws Exception {
		//preCondition();
		ProductReconnectPage homePage=new HomePage().navigateToProductMenue_ProductReconnectPage();
		homePage.reconnectPlane_Bulk();
		//homePage.reconnectPlan_Single();
		
	}
}
