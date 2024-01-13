package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import pom.RemoveElement;
import utility.Reports;
@Listeners(test.Listners.class)
public class RemoveElementsFromCart extends BaseTest {

	RemoveElement removes;
	ProductResultPage productResultPage;
	ProductQuickViewPage productQuickViewPage;
	ExtentReports extentreports;
	ExtentTest test;
	CartPage cartPage;
	
		
	@BeforeTest
	public void configureReport()
	{
		extentreports=Reports.generateReport();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openApp(String browser) {
		driver=LaunchBrowser.browser(browser);
		
	}
@Test
public void verifyIfUserIsAbleToRemoveTheProductFromCart() throws InterruptedException {
	test=extentreports.createTest("verifyIfUserIsAbleToRemoveTheProductFromCart");
	NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
	naptolhomepage.enterInSearchTab("cooker");
	naptolhomepage.clickOnSearch();
	
	productResultPage =new ProductResultPage(driver);
	productResultPage.clickOnQuickView(driver, 0);
	
	productQuickViewPage =new ProductQuickViewPage(driver);
	productQuickViewPage.clickOnBuyButton();
	
	
	cartPage =new CartPage(driver);
	
	cartPage.clickOnContinueShopping();
	
	productResultPage =new ProductResultPage(driver);
	productResultPage.clickOnQuickView(driver, 1);

	productQuickViewPage =new ProductQuickViewPage(driver);
	productQuickViewPage.clickOnBuyButton();
	
	removes = new RemoveElement(driver);
	removes.clickOnRemove(driver, 0);
	
	removes.clickOnClose();
	
	


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
