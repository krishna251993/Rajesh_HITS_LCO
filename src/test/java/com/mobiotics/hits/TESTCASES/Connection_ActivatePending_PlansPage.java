package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.ActvatePendingPlanPage.ActivatePendingPlanPage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class Connection_ActivatePending_PlansPage extends BaseTest {

	
	@Test
	
	public void activatePendingPlanTest() throws Exception
	{
		//It is okey to run in production server
		//preCondition();
		ActivatePendingPlanPage homePage= new HomePage().navigateToProductMenu_ActivatePendingPlans();
		
		homePage.activateThePendingPlan();
		
		
		//For bulk activation of the pending plans we need to add some code
	}
	
	
}
