package generic;



public class Utility {

	
	public static int getRandomNumber(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	public static float  calculatePrice(float price1,float price2,float price3) {
		return price1+price2+price3;
	}
	

}
