package test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;
@Listeners(test.Listners.class)
public class AddMultipleProductOnCart extends BaseTest{
	
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
public void verifyIfUserIsAbleToAddMultipleProductToCartUsingQuickViewOption() throws InterruptedException {
	NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
	naptolhomepage.enterInSearchTab("Mobiles");
	naptolhomepage.clickOnSearch();
	
	ProductResultPage productResultPage =new ProductResultPage(driver);
	productResultPage.clickOnQuickView(driver, 0);
	
	ProductQuickViewPage productQuickViewPage =new ProductQuickViewPage(driver);
	productQuickViewPage.clickOnBuyButton();
	
	
	CartPage cartPage =new CartPage(driver);
	cartPage.clickOnContinueShopping();
	
	ProductResultPage productResultPage1 =new ProductResultPage(driver);
	productResultPage1.clickOnQuickView(driver, 1);
	
	ProductQuickViewPage productQuickViewPage1 =new ProductQuickViewPage(driver);
	productQuickViewPage1.clickOnBuyButton();
	

	
}
@AfterMethod
public void close()
{
	driver.close();
}

}

