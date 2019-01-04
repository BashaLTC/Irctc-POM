package wrappers;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ProjectWrappers extends GenericWrappers{

	public String browserName;
	
	@BeforeMethod(groups={"Smoke","Functional","Regression"})
	public void beforeMethod(){
		startTest(testCaseName, testCaseDescription);
		test.assignAuthor(author);
		test.assignCategory(category);
		invokeApp(browserName);
	}
	@AfterMethod(groups={"Smoke","Functional","Regression"})
	public void closeBrowsers(){
		closeAllBrowsersNoSnap();
	}
	@BeforeSuite(groups={"Smoke","Functional","Regression"})
	public void beforeSuite(){
		startReport();
	}
	@AfterSuite(groups={"Smoke","Functional","Regression"})
		public void afterSuite(){
		endReport();
	}
	@AfterClass(groups={"Smoke","Functional","Regression"})
		public void afterClass(){
		endTest();
	}
	@BeforeTest(groups={"Smoke","Functional","Regression"})
		public void beforeTest(){
		loadObjects();
		
	}
	@AfterTest(groups={"Smoke","Functional","Regression"})
		public void afterTest(){
		unloadObjects();
	}
	
}

