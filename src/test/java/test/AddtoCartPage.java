package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
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
public class AddtoCartPage extends BaseTest {
	

		
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
	public void verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption() {
		NaptolHomePage naptolhomepage=new NaptolHomePage(driver);
		naptolhomepage.enterInSearchTab("Mobiles");
		naptolhomepage.clickOnSearch();
		
		ProductResultPage productResultPage =new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		ProductQuickViewPage productQuickViewPage =new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnBuyButton();
		
		CartPage cartPage =new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProductInCart(driver),1);
		
	}

}
