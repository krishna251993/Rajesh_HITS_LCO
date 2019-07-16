package listnerDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(listnerDemo.TestNGListner.class)

public class MyFirstTestCase {
	@Test
	public void GoogleTitletest() {
		System.setProperty("webdriver.chrome.driver", "D:\\mobiotics_imcl_automation\\HITS_LCO\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.getTitle();
		
	}

}
