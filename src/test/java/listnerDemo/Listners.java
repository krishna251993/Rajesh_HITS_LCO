//this is listner is created by extending the TestListnerAdapter

package listnerDemo;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listners extends TestListenerAdapter {
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test started");
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("test Failuer");
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped");
	}

}
