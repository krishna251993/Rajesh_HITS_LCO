package com.mobiotics.hits.JobReportPageTest;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mobiotics.hits.commonpages.BasePage;

import generic.DateHelper;



public class JobReportPage extends BasePage {
	
	
	public JobReportPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	static final Logger logger=Logger.getLogger(JobReportPage.class);

	@FindBy(id = "jobstatus")
	private WebElement selectJObStatus;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement reportDownLoad;

	@FindBy(id = "refresh")
	private WebElement clickOnDate;

	public void jobReportsDownLoad() throws InterruptedException {
		DateHelper datepicker = new DateHelper();

		Select select = new Select(selectJObStatus);

		datepicker.selectMonth("April");
		datepicker.selectDate("1");
		clickOnDate.click();

		List<WebElement> list = select.getOptions();
		int size = list.size();

		for (int i = 1; i < size; i++) {
			select.selectByIndex(i);
			Thread.sleep(2000);
			if (reportDownLoad.isEnabled()) {
				waitTillElementIsVisible(reportDownLoad);
				reportDownLoad.click();
				Thread.sleep(5000);
			} else {
				System.out.println("There is no data to download");
			}
		}
	}
	
}
