package listnerDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListner implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	
		System.out.println("Test case started and dertails are "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case success and dertails are "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failkuer and dertails are "+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped and dertails are "+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test case fail within the success pe`rcentage and dertails are "+result.getName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test case on started and dertails are "+context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test case on finish and dertails are "+context.getName());
		
	}

}
