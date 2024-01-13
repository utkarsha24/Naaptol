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

import pojo.LaunchBrowser1;
import pom.CartPage;
import pom.ChecksearchDeatilsPage;
import pom.NaptolHomePage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;
import utility.Reports;



@Listeners(test.Listners.class)
public class VerifyDetails extends BaseTest {

	NaptolHomePage naptolhomepage;
	CartPage cartPage;
	ExtentReports extentreports;
	ExtentTest test;
	ProductQuickViewPage productQuickViewPage;
	ProductResultPage productResultPage;
	ChecksearchDeatilsPage checkSearchDetailsPage;
	@BeforeTest
	public void configureReport()
	{
		extentreports=Reports.generateReport();
	}
	//@Parameters({"browser"})
	@BeforeMethod
	public void openApp() {
		driver=LaunchBrowser1.chrome();
		
	}
@Test(priority = 1)
	public void VerifyIfProductsDetailsOnQuickViewTab() throws InterruptedException {//test No 9
	test=extentreports.createTest("VerifyIfProductsDetailsOnQuickViewTab");
	NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
	naptolhomepage.enterInSearchTab("headphones");
	naptolhomepage.clickOnSearch();
	
	checkSearchDetailsPage=new ChecksearchDeatilsPage(driver);
	String title=checkSearchDetailsPage.getSearchProductTitle(2);
	
	
	
	productResultPage =new ProductResultPage(driver);
	productResultPage.clickOnQuickView(driver, 2);
	
	productQuickViewPage =new ProductQuickViewPage(driver);
	
	Assert.assertEquals(productQuickViewPage.getQuicViewTitle(0), title);
}
	@Test(priority = 2)
	public void verifyIfProductsDetailsOnShoppingcartAreSimilarToProductAddedFromQuickViewTab() throws InterruptedException {
	
	test=extentreports.createTest("verifyIfProductsDetailsOnShoppingcartAreSimilarToProductAddedFromQuickViewTab");
	NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
	naptolhomepage.enterInSearchTab("mobile");
	naptolhomepage.clickOnSearch();
	
	productResultPage =new ProductResultPage(driver);
	productResultPage.clickOnQuickView(driver, 0);
	
	productQuickViewPage = new ProductQuickViewPage(driver);
	String Title=productQuickViewPage.getQuicViewTitle(0);
	System.out.println(Title);
	double Price=productQuickViewPage.getPrice();
	System.out.println(Price);
	double Shiping=productQuickViewPage.getShipingCharges();
	System.out.println(Shiping);

	productQuickViewPage.clickOnBuyButton();

	cartPage = new CartPage(driver);
	
	Assert.assertEquals(cartPage.getProductTitle(0, driver),Title);
	
	Assert.assertEquals(cartPage.getCartPrice(0),Price);
	
	Assert.assertEquals(cartPage.getCartshipingCharges(0),Shiping);
}

	@Test(priority = 3)
	public void addSingleToCartAndVerifyIfUnitPriceShippingPriceIsEqualToOrderAmount() throws InterruptedException
	{
	test=extentreports.createTest("addSingleToCartAndVerifyIfUnitPriceShippingPriceIsEqualToOrderAmount");
	NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
	naptolhomepage.enterInSearchTab("mobile");
	naptolhomepage.clickOnSearch();
	
	productResultPage =new ProductResultPage(driver);
	productResultPage.clickOnQuickView(driver, 0);
	
	productQuickViewPage = new ProductQuickViewPage(driver);
	productQuickViewPage.clickOnBuyButton();
	
	cartPage=new CartPage(driver);
	//cartPage.getCartPrice(0);
	//cartPage.getCartshipingCharges(0);
	double orderAmount=cartPage.getCartAmount(driver,0);
	Assert.assertTrue(cartPage.getCartPrice(0)+cartPage.getCartshipingCharges(0)==orderAmount);
		
}

	@Test(priority = 4) 
	public void AddTwoToCartAndVerifyIfUnitPriceShippingPriceIsEqualToOrderAmountAndAlsoVerifyIfSumOfOrderAmountIsEqualToCartAmount() throws InterruptedException
	{
	test=extentreports.createTest("AddTwoToCartAndVerifyIfUnitPriceShippingPriceIsEqualToOrderAmountAndAlsoVerifyIfSumOfOrderAmountIsEqualToCartAmount");
	naptolhomepage=new NaptolHomePage(driver);
	naptolhomepage.enterInSearchTab("Mobiles");
	naptolhomepage.clickOnSearch();
	
	productResultPage =new ProductResultPage(driver);
	productResultPage.clickOnQuickView(driver, 0);
	
	productQuickViewPage =new ProductQuickViewPage(driver);
	productQuickViewPage.clickOnBuyButton();
	
	
	cartPage =new CartPage(driver);
	cartPage.clickOnContinueShopping();
	
	//productResultPage =new ProductResultPage(driver);
	productResultPage.clickOnQuickView(driver, 1);
	
	//productQuickViewPage =new ProductQuickViewPage(driver);
	productQuickViewPage.clickOnBuyButton();
	
	double orderAmount=cartPage.getCartAmount(driver,0);
	//System.out.println(orderAmount);
	double orderAmount1=cartPage.getCartAmount(driver,1);
	//System.out.println(orderAmount1);

	double TotalAmount=cartPage.getCartTotal();
	//System.out.println(TotalAmount);
	
	Assert.assertTrue(orderAmount+orderAmount1==TotalAmount);
	
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
