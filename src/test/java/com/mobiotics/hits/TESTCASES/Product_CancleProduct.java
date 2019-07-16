package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;
import com.mobiotics.hits.product_CancelPeroduct.CancelProductTestPage;

public class Product_CancleProduct extends BaseTest{
	
	@Test
	
	public void cancleProductPageTest() throws Exception {
		//preCondition();
		
		CancelProductTestPage homePage = new HomePage().navigateToProduct_CancelProduct();
		//homePage.cancelProductInBulk();
		homePage.cancelProductSingle();
	}

}
