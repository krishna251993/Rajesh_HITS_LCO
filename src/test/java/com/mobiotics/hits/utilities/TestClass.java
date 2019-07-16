package com.mobiotics.hits.utilities;



public class TestClass {
	

	  public void checKDiffBetweenTwoDate() {
		  
		  String startDate="01_04_2019";
		  String endDate="01_05_2019";
		  
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
	  
	   public  String[] split(String date) {
		   String retVal[]= {
				   "",
				   "",
				   ""
		   };
		   date=date+"_";
		   date=date+" ";
		   
		   for(int i=0;i<=2;i++) {
			   retVal[i]=date.substring(0, date.indexOf("_"));
			   //System.out.println(retVal[i]);
			   date = date.substring((date.indexOf("_")+1), date.length());
			   //System.out.println(date);
		   }
		   
		return retVal;      
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestClass ob1=new TestClass();
		ob1.checKDiffBetweenTwoDate();
		
		
		  
		
				 }

	
	
	
	

}
