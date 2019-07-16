package generic;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

public class DateHelper  extends BasePage{
	private String date1= "//div[(contains(@class,'bfh-datepicker start'))]//td[text()='";
	
	private String date2="']";
	
	private String month1="//div[(contains(@class,'bfh-datepicker start'))]//table//tr[(contains(@class,'months-header'))]"
            + "//span[contains(text(),'";

    private String month2 = "')]";
    
    private String previousMonth = "//div[(contains(@class,'bfh-datepicker start'))]//table//th[(contains(@class,'month'))]"
    		+ "/a[contains(@class,'previous')]";
    
    public void selectDate(String date)
    {
    	driver.findElement(By.xpath(date1+date+date2)).click();
    }
    
    public boolean isElementPresent(String month) {
    	try {
			return driver.findElement(By.xpath(month1 + month + month2)).isDisplayed();
		} catch (Exception e) {
			
			return false;
		}
    }
    
    public void selectMonth(String month) {
    	
    	driver.findElement(By.xpath("//span[@class='input-group-addon']")).click();
    	if(isElementPresent(month)) {
    		driver.findElement(By.xpath(month1 + month + month2)).click();
    		
    	}
    	else {
    		for(int i=1;i<=12;i++)
    		{
    			driver.findElement(By.xpath(previousMonth)).click();
    			if(isElementPresent(month)){
					driver.findElement(By.xpath(month1 + month + month2)).click();
					break;
				}
    		}
    	}
    }
    
    
    //----------------------------------------------------------Select overloaded method----------------
    
    public static int changeDateToNum(String path,String sheetName,int row,int col,int in1,int in2) {
    	String day="";
    	String cellValue=DemoExcelLibrary3.getexcelData(sheetName, row, col, path);
    	day=day+cellValue.charAt(in1)+cellValue.charAt(in2);
    	return Integer.parseInt(day);
    }
    
    
    
    public static void selectMonth(String path,String sheetName,String currentMonthName,int row,int col,WebElement previousEndMonth,WebElement selectEndMonth) {
    	
    	
    	ArrayList<String> monthList=new ArrayList<String>();
    	monthList.add("");
    	monthList.add("January");
    	monthList.add("February");
		monthList.add("March");
		monthList.add("April");
		monthList.add("May");
		monthList.add("June");
		monthList.add("July");
		monthList.add("Auguast");
		monthList.add("September");
		monthList.add("October");
		monthList.add("November");
		monthList.add("December");
		
		int index=monthList.indexOf(currentMonthName);
		int mm=changeDateToNum(path, sheetName, row, col, 3, 4);
		int difference=mm-index;
		while(difference!=0) {
			if(difference<0) {
				previousEndMonth.click();
				difference++;
			}
			
			else if(difference>0) {
				selectEndMonth.click();
				difference--;
			}
		}
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    public  void selectDate (String xp1, String xp2, int dateVal)
	{
		boolean br=false;
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=7; j++)
			{
				
				WebElement calDate = driver.findElement(By.xpath(xp1+i+xp2+j+"]"));
				waitTillElementIsVisible(calDate);
				if(calDate.isEnabled())
				{
					int calDateNum = Integer.parseInt(calDate.getText());
					if(calDateNum==dateVal)
					{
						calDate.click();
						br=true;
						break;
						
					}
				}
				
			}
			if(br) {
				break;
			}
				
		}
	}

    
   public void checKDiffBetweenTwoDate(String startDate,String endDate) {
	   int  [] nodim = {
			   0,
			   31,
			   28,
			   31,
			   30,
			   31,
			   30,
			   31,
			   31,
			   30,
			   31,
			   30,
			   31
			  };
			  String[] inpArr1 = split(startDate);
			  String[] inpArr2 = split(endDate);
			  int d1 = Integer.parseInt(inpArr1[0]);
			  int m1 = Integer.parseInt(inpArr1[1]);
			  int y1 = Integer.parseInt(inpArr1[2]);
			  int d2 = Integer.parseInt(inpArr2[0]);
			  int m2 = Integer.parseInt(inpArr2[1]);
			  int y2 = Integer.parseInt(inpArr2[2]);
			  if (y1 % 4 == 0) nodim[2] = 29;
			  int diff = m1 == m2 && y1 == y2 ? d2 - (d1 - 1) : (nodim[m1] - (d1 - 1));
			  int mm1 = m1 + 1, mm2 = m2 - 1, yy1 = y1, yy2 = y2;
			  for (; yy1 <= yy2; yy1++, mm1 = 1) {
			   mm2 = yy1 == yy2 ? (m2 - 1) : 12;
			   if (yy1 % 4 == 0) nodim[2] = 29;
			   else nodim[2] = 28;
			   if (mm2 == 0) {
			    mm2 = 12;
			    yy2 = yy2 - 1;
			   }
			   for (; mm1 <= mm2 && yy1 <= yy2; mm1++) diff = diff + nodim[mm1];
			  }
			  System.out.print("No. of days from " + startDate + " to " + endDate + " is " + diff);
	  
	  
	  

   }
   
   public String[] split(String date) {
	   String retVal[]= {
			   "",
			   "",
			   ""
	   };
	   date=date+"_";
	   date=date+" ";
	   
	   for(int i=0;i<=2;i++) {
		   retVal[i]=date.substring(0, date.indexOf("_"));
		   date = date.substring((date.indexOf("_")+1), date.length());
	   }
	   
	return retVal;      
   }
    
    
    
   
   
    public void selectYear(WebElement previousClick, WebElement nextClick, int currentYear, int selectYear)
	{
		int difference = selectYear - currentYear;
		
			while(difference<0)
			{
				previousClick.click();
				difference++;
			}
			
			while(difference>0)
			{
				nextClick.click();
				difference--;
			}
		
			if(difference==0)
			{
				return;
			}
		
		
	}
   
    
    
    
    
    
    public void selectMonth(WebElement previousMonth, WebElement nextMonth, String currentMonth, int mm)
  	{
  		ArrayList<String> monthList = new ArrayList<String>();
  		monthList.add("");
  		monthList.add("January");
  		monthList.add("February");
  		monthList.add("March");
  		monthList.add("April");
  		monthList.add("May");
  		monthList.add("June");
  		monthList.add("July");
  		monthList.add("Auguast");
  		monthList.add("September");
  		monthList.add("October");
  		monthList.add("November");
  		monthList.add("December");
  	
  		int index = monthList.indexOf(currentMonth);
  		int difference = mm-index;
  	
  		while(difference!=0)
  		{
  			if(difference<0)
  			{
  				previousMonth.click();
  				difference++;
  			}
  			else if(difference>0)
  			{
  				nextMonth.click();
  				difference--;
  			}
  		}
  	
  	
  	}

    
    
    
    
    
    
    
    
}
