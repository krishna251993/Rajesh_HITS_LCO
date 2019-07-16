package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.Report_ExpiryReportPage.ExpiryReportPage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;


public class Report_ExpiryReportPageTest extends BaseTest {
	
	@Test
	public void testReport_ExpiryReportPageTest() throws Exception
	{
		//preCondition();
		ExpiryReportPage homePage = new HomePage().navigateToReportMenu_ExpiryReportPage();
		homePage.downloadExpiryReport();
	}

}
