package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.NaptolHomePage;
import utility.Reports;
@Listeners(test.Listners.class)
public class verifyIfUserIsAbleToSearchProduct extends BaseTest {
	
	
	ExtentReports extentreports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport()
	{
		extentreports=Reports.generateReport();
	}
	
	@BeforeMethod
	public void openApp() {
		driver=LaunchBrowser.chrome();
		
	}
	@Test
	public void verifyIfUserIsAbleToSearchProducts() {
	test=extentreports.createTest("verifyIfUserIsAbleToSearchProducts");
	NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
	naptolhomepage.enterInSearchTab("mobile handset");
	naptolhomepage.clickOnSearch();
	String currentUrl =driver.getCurrentUrl();
	Assert.assertTrue(currentUrl.contains("https://www.naaptol.com/search.html?type=srch_catlg&kw=mobile"));
	Assert.assertEquals(naptolhomepage.getMobileHeading(),"mobile" );
	}
	
	@AfterMethod
	public void addTestStatus(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName());
		}
    
	}
	
	
	
	 @AfterTest
     public void publishReports() {

		 extentreports.flush();
        }
	
}


