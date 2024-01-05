package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.NaptolHomePage;
import pom.ProductResultPage;
import utility.Reports;
@Listeners(test.Listners.class)
public class productDisplayPage extends BaseTest{
	
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
	
	@Test(priority = 1)
	public void verifyProductDisplayedOnValidSearch()
	{
		test=extentreports.createTest("verifyProductDisplayedOnValidSearch");
		NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
		naptolhomepage.enterInSearchTab("cooker");
		naptolhomepage.clickOnSearch();
		SoftAssert soft = new SoftAssert();

		String currentUrl =driver.getCurrentUrl();
		soft.assertTrue(currentUrl.contains("https://www.naaptol.com/search.html?type=srch_catlg&kw=cooker"));
		//soft.assertEquals(naptolhomepage.getMobileHeading(),"mobile" );
		ProductResultPage productResultPage=new ProductResultPage(driver);
		Assert.assertTrue(productResultPage.getNumberOfProduct()>0);
		
	}

	@Test(priority = 2)
	public void verifyProductNotDisplayedOnInvalidSearch()
	{
		test=extentreports.createTest("verifyProductNotDisplayedOnInvaidSearch");
		NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
		naptolhomepage.enterInSearchTab("iphone");
		naptolhomepage.clickOnSearch();
		SoftAssert soft=new SoftAssert();
		String currentUrl1 =driver.getCurrentUrl();
		soft.assertTrue(currentUrl1.contains("https://www.naaptol.com/search.html?type=srch_catlg&kw=iphone"));
		ProductResultPage productResultPage=new ProductResultPage(driver);
		Assert.assertTrue(productResultPage.getNumberOfProduct()==0);
		
		
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
