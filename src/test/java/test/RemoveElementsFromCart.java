package test;

import org.testng.Assert;
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
import pom.removeElement;
import utility.Reports;
@Listeners(test.Listners.class)
public class RemoveElementsFromCart extends BaseTest {

	removeElement removes;
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
	NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
	naptolhomepage.enterInSearchTab("cooker");
	naptolhomepage.clickOnSearch();
	
	ProductResultPage productResultPage =new ProductResultPage(driver);
	productResultPage.clickOnQuickView(driver, 0);
	
	ProductQuickViewPage productQuickViewPage =new ProductQuickViewPage(driver);
	productQuickViewPage.clickOnBuyButton();
	
	
	CartPage cartPage =new CartPage(driver);
	
	cartPage.clickOnContinueShopping();
	
	productResultPage =new ProductResultPage(driver);
	productResultPage.clickOnQuickView(driver, 1);

	productQuickViewPage =new ProductQuickViewPage(driver);
	productQuickViewPage.clickOnBuyButton();
	
	removes = new removeElement(driver);
	removes.clickOnRemove(driver, 0);
	
	removes.clickOnClose();
	
	


}
@AfterMethod
public void close()
{
	driver.close();
}

}
