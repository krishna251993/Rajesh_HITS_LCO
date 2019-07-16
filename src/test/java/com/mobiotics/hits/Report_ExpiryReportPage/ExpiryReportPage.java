package com.mobiotics.hits.Report_ExpiryReportPage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mobiotics.hits.commonpages.BasePage;

public class ExpiryReportPage extends BasePage{

	
	public ExpiryReportPage() 
	  {
		PageFactory.initElements(driver, this);
	  }
	  
	  @FindBy(id="expiry")
	  private WebElement selectWhenIsExpriying;
	  
	  @FindBy(xpath="//button[@type='submit']")
	  private WebElement downloadButton;
	  
	  
	  
	  public void downloadExpiryReport() throws InterruptedException
	  {
		  Select select = new Select(selectWhenIsExpriying);
		  
		  List<WebElement> list = select.getOptions();
			int size = list.size();
			
		  		for (int i = 1; i < size; i++) {
				select.selectByIndex(i);			  
		  waitTillElementIsVisible(downloadButton);
		  if(downloadButton.isEnabled())
		  {
			  downloadButton.click();
		  }
		  else
		  {
			  System.out.println("No Data To DownLoad");
		  }
	  }Thread.sleep(3000);

	
	
}
	  
}
