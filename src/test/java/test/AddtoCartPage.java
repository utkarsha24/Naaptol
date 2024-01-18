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
import pojo.LaunchBrowser1;
import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;
@Listeners(test.Listners.class)
public class AddtoCartPage extends BaseTest {
	

		
		ExtentReports extentreports;
		ExtentTest test;
		
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
	public void verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption() throws InterruptedException {
		
		test=extentreports.createTest("verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption");
		NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
		naptolhomepage.enterInSearchTab("Mobiles");
		naptolhomepage.clickOnSearch();
		
		ProductResultPage productResultPage =new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 1);
		
		ProductQuickViewPage productQuickViewPage =new ProductQuickViewPage(driver);
		productQuickViewPage.selectColor(0);
		productQuickViewPage.clickOnBuyButton();
		
		CartPage cartPage =new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProductInCart(driver),1);
		
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
