package SeleniumProject;

import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerClass extends TestListenerAdapter {
	public void onTestStart(ITestResult tr) {
		log("Test started");
	}

	public void onTestSuccess(ITestResult tr) {
		log("Test " + tr.getName() + " PASSED");
		log(tr.getTestClass());
		log("Priority of the method is " + tr.getMethod().getPriority());
		System.out.println(".....");
	}

	public void onTestFailure(ITestResult tr) {
		log("Test " + tr.getName() + " FAILED");

		log("Priority of the method is " + tr.getMethod().getPriority());
		System.out.println(".....");
	}

	public void onTestSkip(ITestResult tr) {
		log("Test " + tr.getName() + " SKIPPED");

		log("Priority of the method is " + tr.getMethod().getPriority());
		System.out.println(".....");
	}

	private void log(String methodname)

	{
		System.out.println(methodname);

	}

	private void log(IClass testClass)

	{
		System.out.println(testClass);

	}

}
