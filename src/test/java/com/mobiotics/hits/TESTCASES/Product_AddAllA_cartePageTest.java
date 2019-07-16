package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;
import com.mobiotics.hits.product_Addproduct_AddALCartePage.AddAla_CartePage;

public class Product_AddAllA_cartePageTest extends BaseTest {
	@Test
	public void addAllA_CartePageTest() throws Exception {
		
		
		
		//preCondition();
		
		AddAla_CartePage homePage=new HomePage().nevigateToProductMenu_AddAl_A_CtrePage();
		
		//homePage.Add_AlaCartePage_inBulk();
		
		homePage.addAlaCarte_packinSingal();
		
		
	}

}
