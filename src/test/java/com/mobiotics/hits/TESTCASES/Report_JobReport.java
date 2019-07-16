package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.JobReportPageTest.JobReportPage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class Report_JobReport  extends BaseTest{
	@Test
	public void Report_JobReportPageTest() throws Exception {
		
		//preCondition();
		
		JobReportPage homePage = new  HomePage().navigateToReportMenu_JobReportPage();
		
		homePage.jobReportsDownLoad();
		
	}

}
