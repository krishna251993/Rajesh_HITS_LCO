package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;
import com.mobiotics.hits.product_AddProduct_AddBasePackPage.Product_AddProduct_AddBasePackPage;

public class ProductAddBasePackTest extends BaseTest{
	
	@Test
	public void AddBasePackTest() throws Exception {
		//preCondition();
		Product_AddProduct_AddBasePackPage homePage= new HomePage().navigateToProductMenu_AddBasePackPage();
		homePage.singleAdd_BasePack();
		//homePage.bulkAddBasePack();
	}

}
